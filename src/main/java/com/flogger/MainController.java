package com.flogger;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( urlPatterns = {"/index"} )

public class MainController extends HttpServlet {

    private static final String HTML_START = "<html><body>";
    private static final String HTML_END = "</body></html>";

    public MainController(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println(HTML_START);
            out.println("<h1 style=\"text-align: center; margin-top: 50px\">Hi there, from Andrew =)</h1>");
            out.println("<h3 style=\"text-align: center; color: green\"> Date = " + new Date() +"</h3>");
        out.println(HTML_END);

        //a little clean up;
        out.flush();
        out.close();
    }

}
