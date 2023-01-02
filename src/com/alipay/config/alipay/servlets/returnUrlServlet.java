package com.alipay.config.alipay.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class returnUrlServlet extends HttpServlet {

    public static final String RETURN_URL = "/WEB-INF/jsp/alipay/return_url.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("tiao zhuan dao return form successfully !!! from returnUrl Servlet");
        req.getRequestDispatcher(RETURN_URL).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
