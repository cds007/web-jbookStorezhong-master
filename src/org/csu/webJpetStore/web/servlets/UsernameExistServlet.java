
package org.csu.webJpetStore.web.servlets;

import org.csu.webJpetStore.domain.Account;
import org.csu.webJpetStore.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "UsernameIsExistServlet",urlPatterns = "/usernameIsExistServlet")
public class UsernameExistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userid = req.getParameter("userid");
        AccountService accountService = new AccountService();
        Account result = accountService.getAccount(userid);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/plain");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = resp.getWriter();
        if (result.getUserid() == null) {
            out.print("Not Exist");
        } else {
            out.print("Exist");
        }
    }
}






 /*
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
         String username = request.getParameter("userid");
         Account account = new Account();
         account.setUserid(username);
         AccountService accountService = new AccountService();

         response.setContentType("text/xml");
         PrintWriter out = response.getWriter();
         response.setHeader("Access-Control-Allow-Origin","*");
         if(accountService.getAccount(account.getUserid()) != null){
             out.println("Exist");
         }
         else {
             out.println("Not Exist");
         }
         out.flush();
         out.close();
     }
 }

*/



