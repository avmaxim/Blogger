package com.flogger.models;

import com.flogger.domains.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ArticleModel {

    private Integer id;
    private String header;
    private String contents;
    private Integer likesCount;
    private String date;
    private Integer ownerId;

    public Integer getId(){  return id;  }
    public void setId(Integer id){ this.id = id; }

    public String getHeader(){  return header;  }
    public void setHeader(String header){ this.header = header; }

    public String getContents(){  return contents; }
    public void setContents(String contents){ this.contents = contents; }

    public Integer getLikesCount(){ return likesCount; }
    public void setLikesCount(Integer likesCount){this.likesCount = likesCount; }

    public String getDate(){ return date; }
    public void setDate(String date){this.date = date; }

    public Integer getOwnerId(){ return ownerId; }
    public void setOwnerId(Integer ownerId){this.ownerId = ownerId; }

}
