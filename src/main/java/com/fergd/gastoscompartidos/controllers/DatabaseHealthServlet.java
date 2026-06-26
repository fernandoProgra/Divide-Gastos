package com.fergd.gastoscompartidos.controllers;

import com.fergd.gastoscompartidos.config.DatabaseConnection;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/db-health")
public class DatabaseHealthServlet
        extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {

        response.setContentType(
                "application/json"
        );

        try (
                Connection connection =
                        DatabaseConnection.getConnection()
        ) {

            response.getWriter().write("""
                    {
                        "database":"connected"
                    }
                    """);

        } catch (Exception e) {

            response.setStatus(500);

            response.getWriter().write(e.toString());

            e.printStackTrace();
        }
    }
}