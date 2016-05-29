package com.flogger.repositories;

import com.flogger.IRepository;
import com.flogger.domains.Article;
import com.flogger.domains.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* ArticleRepository is represented as stub class for now */
public class ArticleRepository implements IRepository<Article>{

    @Override
    public Article getById(Integer id) {
        Article article = new Article();
        article.setId(id);
        article.setHeader("Header #" + id);
        article.setContents("About " + id);
        article.setLikesCount(3);
        article.setTimestamp(new Date());
        User user = new User();
        user.setId(id);
        article.setOwner(user);
        return article;
    }

    @Override
    public List<Article> getAll() {
        List<Article> articles = new ArrayList<>();
        articles.add(getById(1));
        articles.add(getById(2));
        articles.add(getById(3));
        return articles;
    }

    @Override
    public Boolean insert(Article article) {
        return true;
    }

    @Override
    public void update(Article article) {

    }

    @Override
    public void delete(Article article) {

    }
}
