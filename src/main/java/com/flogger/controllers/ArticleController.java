package com.flogger.controllers;

import com.flogger.FloggerJsonData;
import com.flogger.models.ArticleModel;
import com.flogger.services.IArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by andrei on 5/29/2016.
 */

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Resource(name = "articleService")
    private IArticleService articleService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public   @ResponseBody  FloggerJsonData getAll() {
        return FloggerJsonData.GetAsJson(articleService.getAll());
    }

}
