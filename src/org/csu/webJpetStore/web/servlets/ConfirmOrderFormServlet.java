package org.csu.webJpetStore.web.servlets;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.csu.webJpetStore.domain.Account;
import org.csu.webJpetStore.domain.Order;

/**暂时不用**/
//import org.csu.webJpetStore.service.LogService;
import org.csu.webJpetStore.service.LogService;
import org.csu.webJpetStore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ConfirmOrderFormServlet extends HttpServlet {
    private static final String CONFIRM_ORDER_FORM = "/WEB-INF/jsp/order/ConfirmOrder.jsp";
    private static final String SHIPPINGFORM = "/WEB-INF/jsp/order/ShippingForm.jsp";

    private String shippingAddressRequired;
    private Order order;
    private OrderService orderService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        shippingAddressRequired = request.getParameter("shippingAddressRequired");
        order = new Order();

        HttpSession session = request.getSession();
        order = (Order)session.getAttribute("order");
        Account account = (Account)session.getAttribute("account");
        shippingAddressRequired = null;
        if (shippingAddressRequired == null){
            orderService = new OrderService();
            //这里插入订单时，订单号会递增生成
            //这里我要改一下逻辑了，没有办法，我得把这句话调到确认支付那里了。
            orderService.insertOrder(order);
            session.setAttribute("order", order);
            /**不用更改收获地址**/
            /**日志相关**/
            if(account != null){
                HttpServletRequest httpRequest= request;
                String strBackUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
                        + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

                LogService logService = new LogService();
                String logInfo = logService.logInfo(" ") + strBackUrl + " 确认生成订单 ";
                logService.insertLogInfo(account.getUserid(), logInfo);
            }

            request.getRequestDispatcher(CONFIRM_ORDER_FORM).forward(request, response);
        }
        else{
            shippingAddressRequired = null;
              /**日志相关**/
            if(account != null){
                HttpServletRequest httpRequest= request;
                String strBackUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
                        + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

                LogService logService = new LogService();
                String logInfo = logService.logInfo(" ") + strBackUrl + " 更改收货地址";
                logService.insertLogInfo(account.getUserid(), logInfo);
            }
            request.getRequestDispatcher(SHIPPINGFORM).forward(request, response);
        }

    }
}
