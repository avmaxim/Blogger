package com.flogger.services;

import com.flogger.IRepository;
import com.flogger.domains.*;

public interface IRepositoryService {
    IRepository<User> getUserRepository();
    IRepository<Article> getArticleRepository();
}
