package com.flogger;

import com.flogger.controllers.AccountController;
import com.flogger.models.UserLoginModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import java.lang.NullPointerException;

import javax.naming.Context;
import javax.servlet.ServletException;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {
    private AccountController myAccountController;
    @Before
    public void PrepareAccountController(){
        myAccountController = new AccountController();
    }

    @Test
    public void NullUserTest(){
        UserLoginModel model = new UserLoginModel();
        model.setUsername("somename");
        model.setPassword("somepassword");
        UserLoginModel result = new UserLoginModel();
        result = myAccountController.loginUser(model);
        if (result == null)
            Assert.fail();
    }

    @Test
    public void EmptyUserTest(){
        UserLoginModel model = new UserLoginModel();
        model.setUsername("df");
        model.setUsername("sfsfsfsfseee");
        UserLoginModel result = new UserLoginModel();
        result = myAccountController.loginUser(model);
        String name = result.getUsername();
        String password = result.getPassword();
        if ((name == "") || (password == ""))
            Assert.fail();

    }


}
