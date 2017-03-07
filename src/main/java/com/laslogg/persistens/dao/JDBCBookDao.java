package com.laslogg.persistens.dao;

import com.laslogg.persistens.entity.BookEntity;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Linda on 2017-02-03.
 */
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
}
