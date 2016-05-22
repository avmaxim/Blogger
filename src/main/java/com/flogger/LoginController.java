package com.flogger;

/**
 * Created by andrei on 5/22/2016.
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        urlPatterns = {"/login"},
        description = "Login Servlet",
        initParams = {
                @WebInitParam(name = "username", value = "avmaxim"),
                @WebInitParam(name = "password", value = "hello")
        })
public class LoginController extends HttpServlet implements Servlet{

    public LoginController(){
        super();
    }

    public void init() throws ServletException {
        //we can create DB connection resource here and set it to Servlet context
        if(getServletContext().getInitParameter("db_url").equals("jdbc:mysql://localhost/mysql_db") &&
                getServletContext().getInitParameter("db_username").equals("mysql_username") &&
                getServletContext().getInitParameter("db_password").equals("mysql_password"))

            getServletContext().setAttribute("db_success", "true");
        else
            throw new ServletException("Database Connection error");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get REQUEST parameters for username and password
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //get servlet config init params
        String usernameDB = getServletConfig().getInitParameter("username");
        String passwordDB = getServletConfig().getInitParameter("password");

        //logging example
        log("Username="+username+"::password="+password);

        if(usernameDB.equals(username) && passwordDB.equals(password)){
            response.sendRedirect("/views/auth-success.jsp");
        }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/login.jsp");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);
        }
    }
}