package org.csu.webJpetStore.web.servlets;

import org.csu.webJpetStore.domain.Product;
import org.csu.webJpetStore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import com.alibaba.fastjson.JSON;

public class FindProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取搜索框输入的内容
        String keyword = request.getParameter("keyword");
//        if (keyword!=null) {
//
//            keyword = new String(keyword.getBytes("ISO8859-1"), "UTF-8");
//
//        }
        response.setContentType("text/html;charset=UTF-8");
        request.getCharacterEncoding();
        //向server层调用相应的业务
        CatalogService service = new CatalogService();
        List<Product> productList = service.searchProductList(keyword);

        String result=JSON.toJSONString(productList);
        System.out.println(result);

        response.setContentType("text/json");
        PrintWriter out = response.getWriter();
        out.println(result);
    }
}
