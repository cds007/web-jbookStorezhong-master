package org.csu.webJpetStore.web.servlets;

import org.csu.webJpetStore.domain.Account;
import org.csu.webJpetStore.domain.Cart;
import org.csu.webJpetStore.domain.Order;
import org.csu.webJpetStore.service.LogService;
/**以后用**/
//import org.csu.webJpetStore.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class NewOrderFormServlet extends HttpServlet {
    /**创建新订单界面**/
    private static final String NEW_ORDER = "/WEB-INF/jsp/order/NewOrderForm.jsp";
    /**登录注册界面**/
    private static final String SIGNONFORM = "/WEB-INF/jsp/account/SignonForm.jsp";
    /**错误界面**/
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";

    private Account account;
    private Order order;
    private Cart cart;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**这里我要修改一下，进行测试**/
        HttpSession session = request.getSession();
        account = (Account)session.getAttribute("account");
        cart = (Cart)session.getAttribute("cart");
        if (account == null){
            System.out.println("account is null");
        }
//        account = new Account();
//        account.setAddress1("中国");
//        account.setAddress2("湖南长沙");
//        account.setUsername("陈龙");
//        account.setPassword("123456");
//        account.setEmail("1120@qq.com");
//        account.setFirstName("龙");
//        account.setLastName("陈");
//        session.setAttribute("account",account);
        if (account == null){
            session.setAttribute("message", "You must sign on before attempting to check out.  Please sign on and try checking out again.");
            request.getRequestDispatcher(SIGNONFORM).forward(request, response);
        } else if(cart != null){
            order = new Order();
            order.initOrder(account, cart);
            session.setAttribute("order", order);

           Account account = (Account)session.getAttribute("account");
            /**日志相关信息**/
            if(account != null){
                HttpServletRequest httpRequest= request;
                String strBackUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
                        + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

                LogService logService = new LogService();
                String logInfo = logService.logInfo(" ") + strBackUrl + " 跳转到新订单页面";
                logService.insertLogInfo(account.getUserid(), logInfo);
            }

            request.getRequestDispatcher(NEW_ORDER).forward(request, response);
        }else{
            /**购物车为空的情况**/
            session.setAttribute("message", "An order could not be created because a cart could not be found.");

//            Account account = (Account)session.getAttribute("account");
            /**日志相关信息**/
//            if(account != null){
//                HttpServletRequest httpRequest= request;
//                String strBackUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
//                        + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());
//
//                LogService logService = new LogService();
//                String logInfo = logService.logInfo(" ") + strBackUrl + " 生成订单页面信息错误";
//                logService.insertLogInfo(account.getUsername(), logInfo);
//            }
            request.getRequestDispatcher(ERROR).forward(request, response);
        }
    }
}
