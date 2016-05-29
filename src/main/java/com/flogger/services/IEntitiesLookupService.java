package com.flogger.services;


import com.flogger.models.EntitiesLookupModel;

import java.util.List;

public interface IEntitiesLookupService {
    List<EntitiesLookupModel> getUsers();
    List<EntitiesLookupModel> getArticles();
}
