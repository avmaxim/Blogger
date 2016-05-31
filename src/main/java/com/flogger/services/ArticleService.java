package com.flogger.services;

import com.flogger.models.ArticleModel;

import java.sql.*;
import java.util.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class ArticleService implements IArticleService{

    private DataSource dataSource;
    java.text.SimpleDateFormat sqlDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<ArticleModel> getAll(){
        String query = "select ArticleID, Header, Contents, LikesCount, DateTime, UserID from article";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<ArticleModel> articles = new ArrayList<>();
        List<Map<String,Object>> articlesRows = jdbcTemplate.queryForList(query);

        for(Map<String,Object> articlesRow : articlesRows){
            ArticleModel article = new ArticleModel();
            article.setId(Integer.parseInt(String.valueOf(articlesRow.get("ArticleID"))));
            article.setHeader(String.valueOf(articlesRow.get("Header")));
            article.setContents(String.valueOf(articlesRow.get("Contents")));
            article.setLikesCount(Integer.parseInt(String.valueOf(articlesRow.get("LikesCount"))));
            article.setDate(String.valueOf(articlesRow.get("DateTime")));
            article.setOwnerId(Integer.parseInt(String.valueOf(articlesRow.get("UserID"))));
            articles.add(article);
        }
        return articles;
    }

    @Override
    public ArticleModel getById(Integer id) {
        String query = "select ArticleID, Header, Contents, LikesCount, DateTime, UserID from article where ArticleID = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        ArticleModel article = null;
        try {
            article = jdbcTemplate.queryForObject(query, new Object[]{id}, new RowMapper<ArticleModel>() {
                @Override
                public ArticleModel mapRow(ResultSet rs, int rowNum)
                        throws SQLException {
                    ArticleModel article = new ArticleModel();
                    article.setId(rs.getInt("ArticleID"));
                    article.setHeader(rs.getString("Header"));
                    article.setContents(rs.getString("Contents"));
                    article.setLikesCount(rs.getInt("LikesCount"));
                    article.setDate(String.valueOf((new Date(rs.getTimestamp("DateTime").getTime()))));
                    article.setOwnerId(rs.getInt("UserID"));
                    return article;
                }
            });
        }catch(EmptyResultDataAccessException ex) {
            article = null;
        }finally{
            return article;
        }
    }

    @Override
    public Integer save(ArticleModel article) {
        String query = "insert into article (Header, Contents, LikesCount, DateTime, UserID) values (?,?,?,?,?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] args = new Object[] {
                                    article.getHeader(),
                                    article.getContents(),
                                    article.getLikesCount(),
                                    sqlDateFormat.format(new Date()),
                                    article.getOwnerId()};

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(query, new String[] {"ArticleID"});
                        ps.setString(1, article.getHeader());
                        ps.setString(2, article.getContents());
                        ps.setInt(3, article.getLikesCount());
                        ps.setTimestamp(4, new Timestamp(new Date().getTime()));
                        ps.setInt(5, article.getOwnerId());
                        return ps;
                    }
                },
                keyHolder);

        return keyHolder.getKey().intValue();
    }

    @Override
    public Integer update(ArticleModel article) {
        String query = "update article set Header=?, Contents=? where ArticleID=?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] args = new Object[] {article.getHeader(),
                                        article.getContents(),
                                        article.getId()};
        int out = jdbcTemplate.update(query, args);

        return article.getId();
    }

    @Override
    public void deleteById(int id) {
        String query = "delete from article where ArticleID=?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        int out = jdbcTemplate.update(query, id);
        if(out !=0){
            System.out.println("Article deleted with id="+id);
        }else
            System.out.println("No Article found with id="+id);
    }
}
