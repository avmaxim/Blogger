package com.flogger;
import com.flogger.controllers.AccountController;
import com.flogger.controllers.MainController;
import com.flogger.models.UserLoginModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import javax.naming.Context;
import javax.servlet.ServletException;
import java.io.IOException;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MainControllerTest {
    private MainController MC;
    @Before
    public  void IntializeController(){
        MC = new MainController();
    }
    @Test
    public void CheckControllerInfo(){
        String result =  MC.getServletInfo();
        if (result != "")
            Assert.fail();
    }
}
