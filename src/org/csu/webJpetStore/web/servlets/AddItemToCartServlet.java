package org.csu.webJpetStore.web.servlets;

import org.csu.webJpetStore.domain.Account;
import org.csu.webJpetStore.domain.Cart;
import org.csu.webJpetStore.domain.Item;
import org.csu.webJpetStore.domain.Product;
import org.csu.webJpetStore.service.CatalogService;
import org.csu.webJpetStore.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddItemToCartServlet extends HttpServlet {
    //Servlet的功能负责中转
    //1.处理完请求后的跳转页面
    private static final String VIEW_CART = "/WEB-INF/jsp/cart/Cart.jsp";

    //2.定义处理请求所需要的数据,workingItemId就是我添加到购物车里的那个Item的ID
    private String workingItemId;
    private Cart cart;//购物车

    private Product product;//小类，我需要调用他的图片

    //3.是否需要调用业务逻辑层
    private CatalogService catalogService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        workingItemId = req.getParameter("workingItemId");
        System.out.println("test1 in AddItemToCartServlet");
        Account account;
        //从对话中，获取购物车
        HttpSession session = req.getSession();
        cart = (Cart) session.getAttribute("cart");
        account = (Account) session.getAttribute("account");
        System.out.println("test2 in AddItemToCartServlet");
        if (cart == null) {
            //第一次使用购物车
            cart = new Cart();
            System.out.println("test3 in AddItemToCartServlet");
        }
        if (cart.containsItemId(workingItemId)) {
            //已有该物品，数量加一
            cart.incrementQuantityByItemId(workingItemId);
            if(account != null){
                HttpServletRequest httpRequest= (HttpServletRequest) req;
                String strBackUrl = "http://" + req.getServerName() + ":" + req.getServerPort()
                        + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

                LogService logService = new LogService();
                Item item = catalogService.getItem(workingItemId);
                String logInfo = logService.logInfo(" ") + strBackUrl + " " + item + "数量+1 ";
                logService.insertLogInfo(account.getUserid(), logInfo);
            }
        } else {
            catalogService = new CatalogService();
            //看源码逻辑
            boolean isInStock = catalogService.isItemInStock(workingItemId);
            //这里注意item是空的，看源码的逻辑是怎样的，再看一眼数据库有没有问题
            //mmd我把他数据库改了
            Item item = catalogService.getItem(workingItemId);
            cart.addItem(item, isInStock);
            if(account != null){
                HttpServletRequest httpRequest= req;
                String strBackUrl = "http://" + req.getServerName() + ":" + req.getServerPort()
                        + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

                LogService logService = new LogService();
                String logInfo = logService.logInfo(" ") + strBackUrl + " 添加物品 " + item + " 到购物车";
                logService.insertLogInfo(account.getUserid(), logInfo);
            }
        }
        session.setAttribute("cart", cart);
        req.getRequestDispatcher(VIEW_CART).forward(req, resp);
    }
}