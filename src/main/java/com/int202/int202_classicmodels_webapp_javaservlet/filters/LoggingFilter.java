package com.int202.int202_classicmodels_webapp_javaservlet.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter(filterName = "LoggingFilter", servletNames = {"AuthenticationServlet"})
public class LoggingFilter implements Filter {

    private FilterConfig config;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long before = System.currentTimeMillis();
        //before invoke resources

        if (isValidUsernameAndPass(servletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            System.out.println("Error! invalid input");
            HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
            httpRequest.setAttribute("loginError", "Invalid username or password");
            httpRequest.getRequestDispatcher("index.jsp").forward(servletRequest, servletResponse);
        }
        //after invoke resources
        long duration = System.currentTimeMillis() - before;
        String msg = "Resource: " + ((HttpServletRequest) servletRequest).getRequestURI() +
                ", execution time: "+ duration+ " milliSeconds";
        this.config.getServletContext().log(msg);
    }

    private static boolean isValidUsernameAndPass(ServletRequest servletRequest){
        String username = servletRequest.getParameter("username");
        String pass = servletRequest.getParameter("password");
        if (isValidString(username) && isValidString(pass)){
            return true;
        } else {
            return false;
        }
    }

    private static boolean isValidString(String msg){
        if (msg.isEmpty() || msg.isBlank()) return false;
        return msg.length() >= 8;
    }
    @Override
    public void destroy() {
    }
}
