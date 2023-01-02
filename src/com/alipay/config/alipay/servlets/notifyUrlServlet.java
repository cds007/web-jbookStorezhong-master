package com.alipay.config.alipay.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class notifyUrlServlet extends HttpServlet {

    public static final String NOTIFY_URL = "/WEB-INF/jsp/alipay/notify_url.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("a yibu from notifyUrlServlet");
        req.getRequestDispatcher(NOTIFY_URL).forward(req,resp);
    }
}
