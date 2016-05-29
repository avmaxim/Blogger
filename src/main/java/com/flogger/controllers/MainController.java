/*
    This controller is used merely for demonstration
 */

package com.flogger.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
        urlPatterns = {"/home"},
        description = "Login Servlet")
public class MainController extends HttpServlet implements Servlet {

    private static final String HTML_START = "<html><body>";
    private static final String HTML_END = "</body></html>";

    public MainController(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println(HTML_START);
        out.println("<h1 style=\"text-align: center; margin-top: 50px\">Hi there, from Flogger Home =)</h1>");
        out.println("<h3 style=\"text-align: center; color: green\"> Date = " + new Date() +"</h3>");
        out.println(HTML_END);

        //a little clean up;
        out.flush();
        out.close();
    }

}
