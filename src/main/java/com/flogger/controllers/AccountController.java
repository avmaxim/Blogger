package com.flogger.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.flogger.FloggerJsonData;
import com.flogger.domains.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import com.flogger.models.*;

import javax.naming.*;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.util.Map;

@Controller
@RequestMapping("/account")
public class AccountController {

    @RequestMapping (value = "/login" , method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody FloggerJsonData loginUser(@RequestBody UserLoginModel person) {
        UserLoginModel user = new UserLoginModel();
        user.setUsername(person.getUsername());
        user.setPassword(person.getPassword());
        return FloggerJsonData.GetAsJson(user);
    }

    @RequestMapping (value = "/logout" , method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody FloggerJsonData logoutUser() {
        return FloggerJsonData.GetAsJson("null");
    }

    @RequestMapping (value = "/register" , method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody   FloggerJsonData registerUser(@RequestBody UserRegistrationModel person) {
        UserRegistrationModel user = new UserRegistrationModel();
        user.setUsername(person.getUsername());
        user.setPassword(person.getPassword());
        user.setEmail(person.getEmail());
        return FloggerJsonData.GetAsJson(user);
    }

    /*
    protected void authenticateUser(@RequestBody ) throws ServletException, IOException {

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
                    //response.sendRedirect("/views/auth-success.jsp");
                    break;
                }
            }

            if(!isExists) {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/client/application/html/login.html");
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
    }*/

/*
    public void contextInitialized() throws ServletException {
        initDatabaseConnection("floggerdb");
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
           // context.setAttribute("db_success", "true");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }*/
}