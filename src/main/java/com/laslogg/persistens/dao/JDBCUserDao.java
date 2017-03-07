package com.laslogg.persistens.dao;

import com.laslogg.persistens.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Linda on 2017-02-04.
 */
@Repository
public class JDBCUserDao implements UserDao {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void save(UserEntity user) {
        String sql = "INSERT INTO USER " +
                "(USERNAME, PASSWORD) VALUES (?, ?)";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }


    }

    public UserEntity getUser(String username) {
        UserEntity user = new UserEntity();
        String sql = "SELECT * FROM USER WHERE" +
                " USERNAME = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("USERNAME"));
                user.setPassword(rs.getString("password"));
                return user;
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
        return user;
    }

    public boolean isValidUser(String username, String password) {
        boolean validUser = false;
        String sql = "SELECT * FROM USER WHERE" +
                " USERNAME = ? AND PASSWORD = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                validUser = true;
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
        return validUser;
    }
}
