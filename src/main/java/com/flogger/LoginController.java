package com.flogger;

/**
 * Created by andrei on 5/22/2016.
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.sql.DataSource;

@WebServlet(
        urlPatterns = {"/login"},
        description = "Login Servlet",
        initParams = {
                @WebInitParam(name = "username", value = "avmaxim"),
                @WebInitParam(name = "password", value = "hello")
        })

public class LoginController extends HttpServlet implements Servlet{

    DataSource pool;    //Database Connection Pool

    public LoginController(){
        super();
    }

    @Override
    public void init() throws ServletException {
        initDatabaseConnection("booksdb");
    }

    private void initDatabaseConnection(String databaseName) throws ServletException{
        try {
            // Create a JNDI Initial context to be able to lookup the DataSource
            InitialContext ctx = new InitialContext();
            // Lookup the DataSource, which will be backed by a pool
            //   that the application server provides.
            pool = (DataSource)ctx.lookup("java:comp/env/jdbc/" + databaseName);
            if (pool == null)
                throw new ServletException("Unknown DataSource 'jdbc/" + databaseName + "'");
            getServletContext().setAttribute("db_success", "true");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get REQUEST parameters for username and password
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Allocate an output writer to write the response message into the network socket
        PrintWriter out = response.getWriter();

        Connection conn = null;
        Statement statement = null;

        try{
             // Get a connection from the pool
            conn = pool.getConnection();
            statement = conn.createStatement();

            ResultSet records = statement.executeQuery("SELECT Username, Password FROM user");

            String usernameDB = null;
            String passwordDB = null;
            Boolean isExists = false;

            while(records.next()){
                usernameDB = records.getString("Username");
                passwordDB = records.getString("Password");

                if(usernameDB.equals(username) && passwordDB.equals(password)) {
                    isExists = true;
                    response.setContentType("text/html;charset=UTF-8");
                    response.sendRedirect("/views/auth-success.jsp");
                    break;
                }
            }

            if(!isExists) {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/login.jsp");
                out.println("<font color=red>Either user name or password is wrong.</font>");
                rd.include(request, response);
            }

        }catch(SQLException ex) {
            ex.printStackTrace();
        }finally{
            out.close();
            try {
                if (statement != null) statement.close();
                if (conn != null) conn.close();  // return to pool
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}