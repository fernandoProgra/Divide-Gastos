package com.fergd.gastoscompartidos.dao;

import com.fergd.gastoscompartidos.config.DatabaseConnection;
import com.fergd.gastoscompartidos.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDAO {

    public void save(User user) throws Exception {

        String sql = """
                INSERT INTO users
                (
                    username,
                    email,
                    password_hash
                )
                VALUES
                (
                    ?,
                    ?,
                    ?
                )
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(
                    1,
                    user.getUsername()
            );

            statement.setString(
                    2,
                    user.getEmail()
            );

            statement.setString(
                    3,
                    user.getPasswordHash()
            );

            statement.executeUpdate();
        }
    }
}