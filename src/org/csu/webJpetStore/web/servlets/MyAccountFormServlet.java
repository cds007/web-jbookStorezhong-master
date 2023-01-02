package org.csu.webJpetStore.web.servlets;

import org.csu.webJpetStore.domain.Account;
import org.csu.webJpetStore.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyAccountFormServlet extends HttpServlet {
    private static final String MY_ACCOUNT_FORM ="/WEB-INF/jsp/account/MyAccountForm.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        HttpSession httpSession=req.getSession();
        Account loginAccount=(Account) httpSession.getAttribute("account");
        if (loginAccount==null){
            req.getRequestDispatcher(MY_ACCOUNT_FORM).forward(req,resp);
            /*如果个人账户页面的名称不是这个还要进一步改一下*/
        }else{
            System.out.println("get to myaccountform");
            if(loginAccount != null){
                HttpServletRequest httpRequest= req;
                String strBackUrl = "http://" + req.getServerName() + ":" + req.getServerPort()
                        + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());

                LogService logService = new LogService();
                String logInfo = logService.logInfo(" ") + strBackUrl + " 跳转到我的账户界面";
                logService.insertLogInfo(loginAccount.getUserid(), logInfo);
            }

            req.getRequestDispatcher(MY_ACCOUNT_FORM).forward(req,resp);
        }
    }
    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
