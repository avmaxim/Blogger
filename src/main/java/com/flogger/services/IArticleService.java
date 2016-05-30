package com.flogger.services;

import com.flogger.models.ArticleModel;

import java.util.List;

public interface IArticleService {
    List<ArticleModel> getAll();
}
