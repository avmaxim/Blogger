package com.flogger.services;

import com.flogger.models.ArticleModel;

import java.util.ArrayList;
import java.util.List;


public class ArticleService implements IArticleService{

    @Override
    public List<ArticleModel> getAll(){
        List<ArticleModel> response = new ArrayList<>();
        ArticleModel article = new ArticleModel();
        article.setId(1);
        article.setLikesCount(0);
        article.setHeader("Java vs Javascript 2016. Still stumped? ");
        article.setContents("in the nutshell, java is mostly used for back, js for front");
        article.setTimestamp("2016-05-26 05:30:29");
        article.setOwnerId(2);
        response.add(article);

        article = new ArticleModel();
        article.setId(1);
        article.setLikesCount(0);
        article.setHeader("Java vs Javascript 2016. Still stumped? ");
        article.setContents("in the nutshell, java is mostly used for back, js for front");
        article.setTimestamp("2016-05-26 05:30:29");
        article.setOwnerId(3);
        response.add(article);

        article = new ArticleModel();
        article.setId(2);
        article.setLikesCount(0);
        article.setHeader("Java vs Javascript 2016. Still stumped? ");
        article.setContents("in the nutshell, java is mostly used for back, js for front");
        article.setTimestamp("2016-05-26 05:30:29");
        article.setOwnerId(1);
        response.add(article);

        article = new ArticleModel();
        article.setId(3);
        article.setLikesCount(0);
        article.setHeader("Java vs Javascript 2016. Still stumped? ");
        article.setContents("in the nutshell, java is mostly used for back, js for front");
        article.setTimestamp("2016-05-26 05:30:29");
        article.setOwnerId(5);
        response.add(article);

        article = new ArticleModel();
        article.setId(5);
        article.setLikesCount(0);
        article.setHeader("Java vs Javascript 2016. Still stumped? ");
        article.setContents("in the nutshell, java is mostly used for back, js for front");
        article.setTimestamp("2016-05-26 05:30:29");
        article.setOwnerId(4);
        response.add(article);

        article = new ArticleModel();
        article.setId(6);
        article.setLikesCount(0);
        article.setHeader("Java vs Javascript 2016. Still stumped? ");
        article.setContents("in the nutshell, java is mostly used for back, js for front");
        article.setTimestamp("2016-05-26 05:30:29");
        article.setOwnerId(6);
        response.add(article);

        article = new ArticleModel();
        article.setId(7);
        article.setLikesCount(0);
        article.setHeader("Java vs Javascript 2016. Still stumped? ");
        article.setContents("in the nutshell, java is mostly used for back, js for front");
        article.setTimestamp("2016-05-26 05:30:29");
        article.setOwnerId(7);
        response.add(article);

        return response;
    }
}