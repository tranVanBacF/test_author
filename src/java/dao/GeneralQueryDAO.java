/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Article;
import entity.Author;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bactv
 */
public class GeneralQueryDAO {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList getYear() throws SQLException {
        ArrayList years = new ArrayList<>();
        years.add("All");
        try {
            String query = "select distinct year from Articles ";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                years.add(rs.getInt(1));
            }
            return years;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
            ps.close();
            rs.close();
        }
        return null;
    }

    public List<Author> getAuthor() throws SQLException {
        List<Author> authors = new ArrayList<>();
        authors.add(new Author(0, "All"));
        try {
            String query = "select * from authors";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Author author = new Author(rs.getInt(1), rs.getString(2));
                authors.add(author);
            }
            return authors;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
            ps.close();
            rs.close();
        }
        return null;
    }

    public List<Author> getAllAuthorOfArticle(int articleId) throws SQLException {
        List<Author> authors = new ArrayList<>();
        try {
            String query = "select au.AuthorID, au.Name from Article_Author ar_au, Articles ar,  Authors au\n"
                    + "where ar_au.ArticleID = ar.ArticleID and ar_au.AuthorID  = au.AuthorID\n"
                    + "and ar_au.ArticleID = ?";
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, articleId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Author author = new Author(rs.getInt(1), rs.getString(2));
                authors.add(author);
            }
            return authors;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            conn.close();
//            ps.close();
//            rs.close();
        }
        return null;
    }

    public List<Article> getAllArticle() throws SQLException {
        List<Article> Articles = new ArrayList<>();

        try {
            String query = "select *  from Articles";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Article article = new Article();

                article.setId(rs.getInt(1));
                article.setTitle(rs.getString(2));
                article.setYear(rs.getInt(3));
                article.setPublisher(rs.getString(4));
                article.setAbstract(rs.getString(5));
                article.setListAuthor(getAllAuthorOfArticle(rs.getInt(1)));

                Articles.add(article);
            }
            return Articles;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
            ps.close();
            rs.close();
        }
        return null;
    }

    public List<Author> getAllAuthorOfArticle(int articleId, String author_id) throws SQLException {
        List<Author> authors = new ArrayList<>();
        String where = "";
        if (!author_id.equals("0") ) {
            where = " and au.AuthorID = " + author_id;
        }
        try {
            String query = "select au.AuthorID, au.Name from Article_Author ar_au, Articles ar,  Authors au\n"
                    + "where ar_au.ArticleID = ar.ArticleID and ar_au.AuthorID  = au.AuthorID\n"
                    + "and ar_au.ArticleID = ?" + where;
            System.out.println("query author: " + query);

            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, articleId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Author author = new Author(rs.getInt(1), rs.getString(2));
                authors.add(author);
            }
            return authors;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            conn.close();
//            ps.close();
//            rs.close();
        }
        return null;
    }

    public List<Article> getAllArticle(String year, String authorId) throws SQLException {
        List<Article> Articles = new ArrayList<>();
        String where = "";
        if (!year.equals("All") ) {
            where += " and year = " + year;
        }
        if (!authorId.equals("0")) {
            where += "and AuthorID = " + authorId;
        }

        try {
            String query = "select distinct  ar.ArticleID, Title, Year, Publisher, Abstract from Articles ar, Article_Author ar_au \n"
                    + "where ar.ArticleID  = ar_au.ArticleID " + where;
            System.out.println("query article: " + query);
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Article article = new Article();

                article.setId(rs.getInt(1));
                article.setTitle(rs.getString(2));
                article.setYear(rs.getInt(3));
                article.setPublisher(rs.getString(4));
                article.setAbstract(rs.getString(5));
                article.setListAuthor(getAllAuthorOfArticle(rs.getInt(1), authorId));

                Articles.add(article);
            }
            return Articles;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
            ps.close();
            rs.close();
        }
        return null;
    }

}
