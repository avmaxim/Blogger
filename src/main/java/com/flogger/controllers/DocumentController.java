package com.flogger.controllers;

import com.flogger.models.ArticleModel;
import com.flogger.services.IArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;


@Controller
@RequestMapping("/document")
public class DocumentController {

    @Resource(name = "articleService")
    private IArticleService articleService;

    @RequestMapping(value = "/downloadArticleAsPDF/{articleId}", method = RequestMethod.GET)
    public ModelAndView downloadPDF(@PathVariable(value="articleId") Integer id) {
        ArticleModel article = articleService.getById(id);
        return new ModelAndView("pdfView", "article", article);
    }

    @RequestMapping(value = "/downloadArticlesAsExcel", method = RequestMethod.GET)
    public ModelAndView downloadExcel() {
        List<ArticleModel> articles = articleService.getAll();
        return new ModelAndView("xlsView", "articles", articles);
    }

    @RequestMapping(value = "/downloadArticlesAsCSV", method = RequestMethod.GET)
    public ModelAndView downloadCSV() {
        List<ArticleModel> articles = articleService.getAll();
        String[] header = { "id", "header", "contents", "likesCount",
                "date", "ownerId"};

        ModelAndView model = new ModelAndView("csvView");
        model.addObject("csvData", articles);
        model.addObject("csvHeader", header);

        return model;
    }

}