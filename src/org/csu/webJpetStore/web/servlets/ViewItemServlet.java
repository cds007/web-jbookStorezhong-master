package org.csu.webJpetStore.web.servlets;

import org.csu.webJpetStore.domain.Account;
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
import java.util.List;

public class ViewItemServlet extends HttpServlet {
    private static final String VIEW_ITEM = "/WEB-INF/jsp/catalog/Item.jsp";

    private String itemId;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        itemId = request.getParameter("itemId");
        CatalogService service = new CatalogService();
        Item item = service.getItem(itemId);
        System.out.println(item.getItemId());
        service.getItemListByProduct(itemId);
        List<Item> itemList = service.getItemListByProduct(itemId);

        HttpSession session = request.getSession();
        session.setAttribute("item", item);
        session.setAttribute("itemList", itemList);

        /**中间还有账户相关的东西，看不太懂，先空着**/
        Account account = (Account)session.getAttribute("account");

        if(account != null){
            HttpServletRequest httpRequest= request;
            String strBackUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
                    + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

            LogService logService = new LogService();
            String logInfo = logService.logInfo(" ") + strBackUrl + " 查看具体商品 " + item;
            logService.insertLogInfo(account.getUserid(), logInfo);
        }

        request.getRequestDispatcher(VIEW_ITEM).forward(request, response);
    }
}
