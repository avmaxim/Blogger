package com.flogger;
import com.flogger.controllers.EntitiesLookupController;
import com.flogger.models.UserLoginModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import javax.naming.Context;
import javax.servlet.ServletException;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class EntitiesLookupControllerTest {
    private EntitiesLookupController eluc;

    @Before
    public void PrepareController(){
        eluc = new EntitiesLookupController();
    }

    @Test(expected = Exception.class)
    public void CheckArticlesForNull(){
        eluc.getArticlesFromDatabase();
    }

    @Test(expected = Exception.class)
    public void CheckusersForNull(){
        eluc.getUsersFromDatabase();
    }

}
