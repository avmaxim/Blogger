package com.flogger.domains;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Article extends Entity {

    private String header;
    private String contents;
    private Integer likesCount;
    private Date date;
    private User owner;

    private final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public String getHeader(){  return header;  }
    public void setHeader(String header){ this.header = header; }

    public String getContents(){  return contents; }
    public void setContents(String contents){ this.contents = contents; }

    public Integer getLikesCount(){ return likesCount; }
    public void setLikesCount(Integer likesCount){this.likesCount = likesCount; }

    public Date getTimestamp(){ return date; }
    public void setTimestamp(Date date){this.date = date; }

    public User getOwner(){ return owner; }
    public void setOwner(User owner){this.owner = owner; }

    @Override
    public String toString(){

        return "[id: " + getId() + "], " +
                "[header: " + getHeader() + "], " +
                "[contents: " + getContents() + "], " +
                "[likesCount: " + getLikesCount() + "], " +
                "[date: " + getTimestamp() + "], " +
                "[userID: " + ((getOwner() == null) ? "null" : getOwner().getId()) + "]";
    }
}
