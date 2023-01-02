package org.csu.webJpetStore.web.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.*;
import java.lang.*;
import com.alibaba.fastjson.JSON;
import org.csu.webJpetStore.domain.Cart;
import org.csu.webJpetStore.domain.CartItem;

public class UpdateCartJSServlet extends HttpServlet {
    private Cart cart;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从对话中，获取购物车
        HttpSession session = req.getSession();
        cart = (Cart)session.getAttribute("cart");

        String quantity =  req.getParameter("quantity");
        //获取购物车，通过quantity来修改
        System.out.println(quantity);
        //quantity形如 CSG-1,12，前者是id，后者是数量
        //接下来需要获取这个id和数量

        int douCnt=0;//逗号的位置
        for (int i = 0; i < quantity.length(); i++) {
            if (quantity.charAt(i)==','){
                douCnt=i;
                break;
            }
        }
        String itemId=quantity.substring(0,douCnt);
        int quan=Integer.parseInt(quantity.substring(douCnt+1));
        cart.setQuantityByItemId(itemId,quan);
        session.setAttribute("cart", cart);

        //接下来需要传递两个数据:total和subtotal
        Cart cart2 = (Cart)session.getAttribute("cart");
        Iterator<CartItem> cartItemIterator2 = cart2.getAllCartItems();
        String quantityAll="";
        BigDecimal total= BigDecimal.valueOf(0);
        BigDecimal subtotal=BigDecimal.valueOf(0);
        while(cartItemIterator2.hasNext()){
            System.out.println("coming");
            CartItem cartItem2 = cartItemIterator2.next();
            System.out.println("gettotal:"+cartItem2.getTotal());
            if (cartItem2.getItem().getItemId().equals(itemId)){
                System.out.println("itemId is equal!!!");
                cartItem2.setTotal(cartItem2.getItem().getListPrice().multiply(BigDecimal.valueOf(quan)));
                total=total.add(cartItem2.getTotal());
            }
            subtotal=subtotal.add(cartItem2.getTotal());
        }
        System.out.println("total is:"+total);
        System.out.println("subtotal is:"+subtotal);
        quantityAll=total.toString()+","+subtotal.toString();

        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        out.print(quantityAll);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
