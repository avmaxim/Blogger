package com.flogger.domains;

import java.util.Date;

public class Avertisement extends Entity{

    private String header;
    private String contents;
    private Article article;

    public String getContents(){ return header; }
    public void setContents(String contents){  this.contents = contents;}

    public String getHeader(){ return header; }
    public void setHeader(String header){this.header = header; }

    public Article getArticle(){ return article; }
    public void setArticle(Article article){this.article = article; }
}
