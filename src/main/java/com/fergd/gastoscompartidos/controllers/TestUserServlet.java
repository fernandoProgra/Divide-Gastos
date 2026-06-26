package com.fergd.gastoscompartidos.controllers;

import com.fergd.gastoscompartidos.dao.UserDAO;
import com.fergd.gastoscompartidos.models.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/test-user")
public class TestUserServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {

        response.setContentType("application/json");

        try {

            User user = new User();

            user.setUsername("fernando");
            user.setEmail("fernando@test.com");
            user.setPasswordHash("123456");

            UserDAO userDAO = new UserDAO();

            userDAO.save(user);

            response.getWriter().write("""
                    {
                        "message":"user created"
                    }
                    """);

        } catch (Exception e) {

            response.setStatus(500);

            response.getWriter().write(e.getMessage());
        }
    }
}