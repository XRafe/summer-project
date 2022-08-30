package org.example.summerproject.repository.custom.connection;

import lombok.SneakyThrows;
import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    @SneakyThrows
    public static ResultSet requestToDatabase(String req) {
        return getConnection().prepareStatement(req).executeQuery();
    }
}
