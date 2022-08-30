package org.example.summerproject.repository;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Component
public class AppDataSource {
    private static final PGSimpleDataSource ds;
    private static final Connection connection;

    static {
        ds = new PGSimpleDataSource();

        ds.setServerNames(new String[]{"localhost:5432"});
        ds.setDatabaseName("summerproject");
        ds.setUser("user");
        ds.setPassword("password");

        try {
            connection = ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }

}
