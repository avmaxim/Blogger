package com.flogger.domains;

import java.util.Date;

public class Comment extends Entity {

    private String contents;
    private Date date;
    private Article article;

    public String getContents(){ return contents; }
    public void setContents(String contents){  this.contents = contents;}

    public Date getTimestamp(){ return date; }
    public void setTimestamp(Date date){this.date = date; }

    public Article getArticle(){ return article; }
    public void setArticle(Article article){this.article = article; }
}
