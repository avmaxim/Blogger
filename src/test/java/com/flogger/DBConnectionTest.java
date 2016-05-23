package com.flogger;

import com.flogger.DBOutputController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import javax.naming.Context;
import javax.servlet.ServletException;
import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DBConnectionTest {
    private DBOutputController dbOutputController;

    private Hashtable env;

    @Before
    public void setUp(){
        dbOutputController = new DBOutputController();
        env = new Hashtable();

        env.put(Context.SECURITY_PRINCIPAL, "root");
        env.put(Context.PROVIDER_URL, "jdbc:mysql://localhost:3306/booksdb");
        env.put(Context.SECURITY_AUTHENTICATION, "Container");
        env.put(Context.SECURITY_CREDENTIALS, "mama");
    }

    @Test
    public void poolShouldBeNull(){
        try {
            dbOutputController.initDatabaseConnection("book", env);
        }catch(ServletException ex){
            ex.printStackTrace();
        }finally {
            assertNull(dbOutputController.getPool());
        }
    }

    @Test
    public void poolShouldBeOk(){
        try {
            dbOutputController.initDatabaseConnection("booksdb", env);
        }catch(ServletException ex){
            ex.printStackTrace();
        }finally {
            assertNotNull(dbOutputController.getPool());
        }
    }
}
