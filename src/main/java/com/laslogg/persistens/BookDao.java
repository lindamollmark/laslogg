package com.laslogg.persistens;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * Created by Linda on 2017-02-03.
 */
@Repository
public class BookDao {

    public void save(BookEntity book){
        System.out.println("Kommer in i dao");

    }
}
