package com.flogger;

import com.flogger.controllers.DatabaseOutputController;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import javax.naming.Context;
import javax.servlet.ServletException;
import java.util.*;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DBConnectionTest {
    private DatabaseOutputController databaseOutputController;

    private Hashtable env;

    @Before
    public void setUp(){
        databaseOutputController = new DatabaseOutputController();
        env = new Hashtable();

        env.put(Context.SECURITY_PRINCIPAL, "root");
        env.put(Context.PROVIDER_URL, "jdbc:mysql://localhost:3306/floggerdb");
        env.put(Context.SECURITY_AUTHENTICATION, "Container");
        env.put(Context.SECURITY_CREDENTIALS, "mama");
    }

    //@Test
    public void poolShouldBeNull(){
        try {
            databaseOutputController.initDatabaseConnection("alsdflogger", env);
        }catch(ServletException ex){
            ex.printStackTrace();
        }finally {
            assertNull(databaseOutputController.getPool());
        }
    }

    //@Test
    public void poolShouldBeOk(){
        try {
            databaseOutputController.initDatabaseConnection("floggerdb", env);
        }catch(ServletException ex){
            ex.printStackTrace();
        }finally {
            assertNotNull(databaseOutputController.getPool());
        }
    }
}
