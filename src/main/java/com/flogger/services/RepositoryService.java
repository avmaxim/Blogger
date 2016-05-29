package com.flogger.services;

import com.flogger.IRepository;
import com.flogger.domains.Article;
import com.flogger.domains.User;
import com.flogger.repositories.ArticleRepository;
import com.flogger.repositories.UserRepository;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class RepositoryService implements  IRepositoryService{

    @Override
    public IRepository<User> getUserRepository() {
        /* fetching users from database */
        return new UserRepository();
    }

    @Override
    public IRepository<Article> getArticleRepository() {
        /* fetching articles from database */
        return new ArticleRepository();
    }
}
