package com.flogger.services;


import com.flogger.domains.*;
import com.flogger.models.EntitiesLookupModel;
import com.sun.corba.se.spi.activation.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class EntitiesLookupService implements IEntitiesLookupService{

    @Resource(name = "repositoryService")
    public IRepositoryService repositoryService;

    @Override
    public List<EntitiesLookupModel> getUsers() {
        List<EntitiesLookupModel> entities = new ArrayList<>();
        List<User> users = repositoryService.getUserRepository().getAll();

        for(int i = 0; i < users.size(); i++){
            EntitiesLookupModel entityLookupModel = new EntitiesLookupModel();
            User user = users.get(i);
            entityLookupModel.setId(user.getId());
            entityLookupModel.setValue(user.toString());
            entities.add(entityLookupModel);
        }
        return entities;
    }

    @Override
    public List<EntitiesLookupModel> getArticles() {

        List<EntitiesLookupModel> entities = new ArrayList<>();
        List<Article> articles = repositoryService.getArticleRepository().getAll();

        for(int i = 0; i < articles.size(); i++){
            EntitiesLookupModel entityLookupModel = new EntitiesLookupModel();
            Article article = articles.get(i);
            entityLookupModel.setId(article.getId());
            entityLookupModel.setValue(article.toString());
            entities.add(entityLookupModel);
        }
        return entities;
    }
}
