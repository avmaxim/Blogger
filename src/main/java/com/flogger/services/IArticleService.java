package com.flogger.services;

import com.flogger.models.ArticleModel;

import java.util.List;

public interface IArticleService {
    List<ArticleModel> getAll();
    ArticleModel getById(Integer id);
    Integer save(ArticleModel article);
    Integer update(ArticleModel article);
    void deleteById(int id);
}
