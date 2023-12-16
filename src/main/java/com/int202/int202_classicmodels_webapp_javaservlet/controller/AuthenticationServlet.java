package com.int202.int202_classicmodels_webapp_javaservlet.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "AuthenticationServlet", value = "/login")
public class AuthenticationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Yeah passes");
        String username = (String) req.getAttribute("username");
        HttpSession session = req.getSession();
        if (session == null || session.isNew()) {
            // Create a new session
            session = req.getSession(true);
            // Set the attribute in the new session
            session.setAttribute("username", username);
        } else {
            // Session already exists, attribute can be set directly
            session.setAttribute("username", username);
        }
        this.getServletContext().getRequestDispatcher("office-list").forward(req, resp);
    }
}
