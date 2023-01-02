package org.csu.webJpetStore.web.servlets;

import org.csu.webJpetStore.domain.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ShippingAddressChangeServlet extends HttpServlet {
    private Order order;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        order = (Order)session.getAttribute("order");

        String context = req.getParameter("context");
        System.out.println("context is "+context);


        int douCnt=0;//逗号的位置
        for (int i = 0; i < context.length(); i++) {
            if (context.charAt(i)==','){
                douCnt=i;
                break;
            }
        }
        String names=context.substring(0,douCnt);
        String values=context.substring(douCnt+1);
        System.out.println("names is "+names);
        System.out.println("values is "+values);

        if (names.equals("shipToFirstName")){
            order.setShipToFirstName(values);
        } else if (names.equals("shipToLastName")) {
            order.setShipToLastName(values);
        } else if (names.equals("shipAddress1")) {
            order.setShipAddress1(values);
        } else if (names.equals("shipAddress2")) {
            order.setShipAddress2(values);
        } else if (names.equals("shipCity")) {
            order.setShipCity(values);
        } else if (names.equals("shipState")) {
            order.setShipState(values);
        } else if (names.equals("shipZip")) {
            order.setShipZip(values);
        } else if (names.equals("shipCountry")) {
            order.setShipCountry(values);
        }
        session.setAttribute("order", order);

        String re="successfully change";
        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        out.print(re);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
