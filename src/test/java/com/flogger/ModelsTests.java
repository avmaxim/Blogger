package com.flogger;
import com.flogger.controllers.AccountController;
import com.flogger.models.EntitiesLookupModel;
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
public class ModelsTests {
    @Test
    public void EntitiesLookupModelTest(){
        EntitiesLookupModel model = new EntitiesLookupModel();
        model.setId(2);
        model.setValue("dfdf");
        if (model.getValue() == "")
            Assert.fail();
    }

    @Test
    public void EntitiesIdTest(){
        EntitiesLookupModel model = new EntitiesLookupModel();
        model.setValue("hello");
        model.setId(87);
        if (model.getId() <= 0)
            Assert.fail();
    }
}
