package com.fergd.gastoscompartidos.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/dividegastos_db";

    private static final String USER = "postgres";

    private static final String PASSWORD = "retomarProgra";

    public static Connection getConnection()
            throws Exception {

        Class.forName("org.postgresql.Driver");

        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }
}
