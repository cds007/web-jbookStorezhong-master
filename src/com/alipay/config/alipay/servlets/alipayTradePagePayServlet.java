package com.alipay.config.alipay.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class alipayTradePagePayServlet extends HttpServlet {

    public static final String PAGEPAY = "/WEB-INF/jsp/alipay/alipay.trade.page.pay.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("dispatcher to PayForm from alipayTradePagePayServlet");
        req.getRequestDispatcher(PAGEPAY).forward(req,resp);
    }
}
