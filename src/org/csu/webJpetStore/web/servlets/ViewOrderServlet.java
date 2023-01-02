package org.csu.webJpetStore.web.servlets;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.csu.webJpetStore.domain.Account;
import org.csu.webJpetStore.domain.Cart;
import org.csu.webJpetStore.domain.LineItem;
import org.csu.webJpetStore.domain.Order;

/**先不用**/
//import org.csu.webJpetStore.service.LogService;
import org.csu.webJpetStore.service.LogService;
import org.csu.webJpetStore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ViewOrderServlet extends HttpServlet {
    private static final String VIEWORDER = "/WEB-INF/jsp/order/ViewOrder.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";

    private Order order;
    private OrderService orderService;
    private Cart cart;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        order = (Order) session.getAttribute("order");
        cart = (Cart) session.getAttribute("cart");

        if (order != null) {
//            orderService = new OrderService();
//            //这里插入订单时，订单号会递增生成
//            //这里我要改一下逻辑了，没有办法，我得把这句话调到确认支付那里了。
//            orderService.insertOrder(order);
//            session.setAttribute("order", order);
            //清空购物车
            cart = null;
            session.setAttribute("cart", cart);

            session.setAttribute("message", "Thank you, your order has been submitted.");

            //HttpSession session = request.getSession();
            Account account = (Account)session.getAttribute("account");
              /**日志相关**/
            if(account != null){
                HttpServletRequest httpRequest= request;
                String strBackUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
                        + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

                LogService logService = new LogService();
                String logInfo = logService.logInfo(" ") + strBackUrl + " 查看订单 " + order;
                logService.insertLogInfo(account.getUserid(), logInfo);
            }

            request.getRequestDispatcher(VIEWORDER).forward(request, response);
        } else {
            session.setAttribute("message", "An error occurred processing your order (order was null).");
            request.getRequestDispatcher(ERROR).forward(request, response);
        }
    }
}
