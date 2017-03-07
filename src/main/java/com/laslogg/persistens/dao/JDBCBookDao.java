package com.laslogg.persistens.dao;

import com.laslogg.persistens.entity.BookEntity;
import com.laslogg.persistens.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JDBCBookDao implements BookDao {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void save(BookEntity book){
        String sql = "INSERT INTO BOOK " +
                "(NAME, AUTHOR, PAGES, USER) VALUES (?, ?, ?, ?)";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, book.getName());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getNumberOfPages());
            ps.setInt(4, book.getUser().getId());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }


    }

    public List<BookEntity> getUsersBook(int userId) {
        String sql = "SELECT * FROM BOOK WHERE" +
                " USER = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        List<BookEntity> bookList = new ArrayList<BookEntity>();
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BookEntity book = new BookEntity();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("NAME"));
                book.setAuthor(rs.getString("Author"));
                book.setNumberOfPages(rs.getInt("pages"));
                UserEntity user = new UserEntity();
                user.setId(rs.getInt("user"));
                book.setUser(user);
                bookList.add(book);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (conn != null) {
                try {
                    ps.close();
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
        return bookList;
    }
}
