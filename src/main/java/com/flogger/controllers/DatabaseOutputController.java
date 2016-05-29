package com.flogger.controllers;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;


@WebServlet(
        urlPatterns = {"/database-contents"},
        description = "Database Contents Servlet")

public class DatabaseOutputController extends HttpServlet implements Servlet {
    DataSource pool;    //Database Connection Pool

    public DatabaseOutputController(){
        super();
    }

    @Override
    public void init() throws ServletException {
        initDatabaseConnection("floggerdb");
    }

    public void initDatabaseConnection(String databaseName) throws ServletException{
        try{
            InitialContext ctx = new InitialContext();
            pool = (DataSource)ctx.lookup("java:comp/env/jdbc/" + databaseName);
            if (pool == null)
                throw new ServletException("Unknown DataSource 'jdbc/"+ databaseName +"'");
            getServletContext().setAttribute("db_success", "true");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }

    public void initDatabaseConnection(String databaseName, Hashtable env) throws ServletException{
        try{
            InitialContext ctx = new InitialContext(env);
            pool = (DataSource)ctx.lookup("java:comp/env/jdbc/" + databaseName);
            if (pool == null)
                throw new ServletException("Unknown DataSource 'jdbc/"+ databaseName +"'");
            getServletContext().setAttribute("db_success", "true");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }

    public DataSource getPool(){
        return pool;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Connection conn = null;

        try{
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Database Contents</title></head>");
            out.println("<body>");

            conn = pool.getConnection();

            printDatabase(out, conn);

            out.println("</body>");
            out.println("</html>");

        }catch(SQLException ex) {
            ex.printStackTrace();
        }finally{

            out.close();
            try {
                if (conn != null) conn.close();  // return to pool
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void printDatabase(PrintWriter out, Connection conn) throws SQLException{
        Map<String, ResultSet> results = new HashMap<String, ResultSet>();
        ArrayList<Statement> statements = new ArrayList<Statement>();

        final int tablesCount = 5;

        for(int i = 0; i < tablesCount; i++){
            statements.add(conn.createStatement());
        }

        results.put("user", statements.get(0).executeQuery("select * from user"));
        results.put("article", statements.get(1).executeQuery("select * from article"));
        results.put("advertisement", statements.get(2).executeQuery("select * from advertisement"));
        results.put("comment", statements.get(3).executeQuery("select * from comment"));
        results.put("role", statements.get(4).executeQuery("select * from role"));

        Iterator iter = results.entrySet().iterator();
        Map.Entry<String, ResultSet> keyValue = null;
        while(iter.hasNext()){
            keyValue = (Map.Entry<String, ResultSet>) iter.next();
            out.println("<table>");
            out.println("<caption>" + keyValue.getKey() + "</caption>");
            ResultSet r = keyValue.getValue();
            printTableFromDatabase(out, r);
            out.println("</table>");
        }
        try{
            for(int i = 0; i < tablesCount; i++) {
                if (statements.get(i) != null) statements.get(i).close();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    private void printTableFromDatabase(PrintWriter out, ResultSet resultSet) throws SQLException{
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        out.println("<tr>");
        for(int columnNumber = 1; columnNumber <= resultSetMetaData.getColumnCount(); columnNumber++){
            out.println("<td>"+ resultSetMetaData.getColumnName(columnNumber)+"</td>");
        }
        out.println("</tr>");
        while (resultSet.next()){
            out.println("<tr>");
            for(int columnNumber = 1; columnNumber <= resultSetMetaData.getColumnCount(); columnNumber++){
                out.println("<td>"+ resultSet.getString(resultSetMetaData.getColumnName(columnNumber))+"</td>");
            }
            out.println("</tr>");
        }
    }

}
