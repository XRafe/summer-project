package org.example.summerproject.repository;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class AppDataSource {

    private static final PGSimpleDataSource ds;

    static {
        ds = new PGSimpleDataSource();

        ds.setServerNames(new String[]{"localhost:5432"});
        ds.setDatabaseName("summerproject");
        ds.setUser("user");
        ds.setPassword("password");
    }

    public static DataSource getDataSource() {
        return ds;
    }

}
