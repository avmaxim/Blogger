package com.flogger;
import com.flogger.controllers.AccountController;
import com.flogger.domains.Article;
import com.flogger.domains.Avertisement;
import com.flogger.domains.User;
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
public class DomainsTests {

    @Test
    public void ArticleLikesCountTest() {
        Article ar = new Article();
        int likeCount = 10;
        ar.setLikesCount(likeCount);
        if (ar.getLikesCount() < 0)
            Assert.fail();
    }

    @Test
    public void ArticleOwnerTest(){
        Article ar = new Article();
        ar.setOwner(new User());
        if (ar.getOwner() == null)
            Assert.fail();
    }

    @Test
    public void ArticleAttributesTest(){
        Article ar = new Article();
        ar.setContents("Food");
        ar.setHeader("Potato");
        ar.setTimestamp(new Date(72652528));
        if (ar.getContents() == "" || ar.getHeader() == "" || ar.getTimestamp() == null){
            Assert.fail();
        }
    }

    @Test
    public void AdvertisementContentTest(){
        Avertisement avd = new Avertisement();
        avd.setContents("try twix");
        if (avd.getContents() == "")
            Assert.fail();
    }

    @Test
    public void AdvertisementHeaderTest(){
        Avertisement adv = new Avertisement();
        adv.setHeader("Yoooo!!!");
        if (adv.getHeader() == "")
            Assert.fail();
    }

    @Test
    public void AdvertisementIdTest(){
        Avertisement adv = new Avertisement();
        adv.setId(23);
        if (adv.getId() < 0)
            Assert.fail();
    }

    @Test
    public void AdvertisementArticleTest(){
        Avertisement adv = new Avertisement();
        adv.setArticle(new Article());
        if (adv.getArticle() == null)
            Assert.fail();
    }
}
