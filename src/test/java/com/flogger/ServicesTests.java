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
public class ServicesTests {
    @Test
    public void FloggerJsonDataTest(){
        FloggerJsonData data = new FloggerJsonData();
        data.setData(new Object());
        if (data.getData() == null)
            Assert.fail();
    }

    @Test
    public void ObjectNotNullTest(){
        FloggerJsonData data = new FloggerJsonData();
        data.setData(new Object());
        if (data == null)
            Assert.fail();
    }
}
