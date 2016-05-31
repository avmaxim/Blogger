package com.flogger.controllers;

import com.flogger.FloggerJsonData;
import com.flogger.domains.Article;
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

    @RequestMapping(value = "/getById/{articleId}", method = RequestMethod.GET)
    public   @ResponseBody  FloggerJsonData getById(@PathVariable(value="articleId") Integer id) {
        return FloggerJsonData.GetAsJson(articleService.getById(id));
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody FloggerJsonData save(@RequestBody ArticleModel model, HttpServletRequest request) {
        return FloggerJsonData.GetAsJson(articleService.save(model));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody FloggerJsonData update(@RequestBody ArticleModel model, HttpServletRequest request) {
        return FloggerJsonData.GetAsJson(articleService.update(model));
    }

    @RequestMapping(value = "/deleteById/{articleId}", method = RequestMethod.POST)
    public @ResponseBody FloggerJsonData Save(@PathVariable(value="articleId") Integer id) {
        articleService.deleteById(id);
        return FloggerJsonData.GetAsJson("");
    }


}
