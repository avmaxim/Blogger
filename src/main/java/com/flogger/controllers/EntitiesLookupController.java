package com.flogger.controllers;

import com.flogger.FloggerJsonData;
import com.flogger.models.EntitiesLookupModel;
import com.flogger.services.IEntitiesLookupService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/entities")
public class EntitiesLookupController {

    @Resource(name = "entitiesLookupService")
    private IEntitiesLookupService entitiesLookupService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody FloggerJsonData getUsersFromDatabase() {
        return FloggerJsonData.GetAsJson(entitiesLookupService.getUsers());
    }

    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    public @ResponseBody FloggerJsonData getArticlesFromDatabase() {
        return FloggerJsonData.GetAsJson(entitiesLookupService.getArticles());
    }
}
