package org.csu.webJpetStore.web.servlets;

import com.alibaba.fastjson.JSON;
import org.csu.webJpetStore.domain.Item;
import org.csu.webJpetStore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ItemDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productId=req.getParameter("productId");
        System.out.println(productId);
       String a=null;
           String b=null;
        if(productId.equals("JL-01")) {a="csg-01";b="csg-02";}
        else if(productId.equals("YW-02")) {a="csg-03";b="csg-04";}
        else if(productId.equals("LJKLY-03")) {a="csg-05";b="csg-06";}
        else if(productId.equals("KQY-04")) {a="csg-07";b="csg-08";}
        else if(productId.equals("JM-01") ){a="csg-09";b="csg-10";}
        else if(productId.equals("HSQ-02") ){a="csg-11";b="csg-12";}
        else if(productId.equals("CQ-03") ){a="csg-13";b="csg-14";}
        else if(productId.equals("LBLD-04")) {a="csg-15";b="csg-16";}
        else if(productId.equals("ZHTYM-04")) {a="csg-17";b="csg-18";}
        else if(productId.equals("YGDMM-01") ){a="csg-19";b="csg-20";}
        else if(productId.equals("BOM-02") ){a="csg-21";b="csg-22";}
        else if(productId.equals("ELSLM-03")) {a="csg-23";b="csg-24";}
        else if(productId.equals("BXG-01") ){a="csg-25";b="csg-26";}
        else if(productId.equals("YOG-02") ){a="csg-27";b="csg-28";}
        else if(productId.equals("XZZ-03") ){a="csg-29";b="csg-30";}
        else if(productId.equals("SG-04") ){a="csg-31";b="csg-32";}
        else if(productId.equals("BWN-01")) {a="csg-33";b="csg-34";}
        else if(productId.equals("FRN-02")) {a="csg-35";b="csg-36";}
        else if(productId.equals("MTY-03") ){a="csg-37";b="csg-38";}
        else if(productId.equals("MDYW-04")) {a="csg-39";b="csg-40";}
        System.out.println(a);
        System.out.println(b);
        resp.setContentType("text/json");
        PrintWriter out =resp.getWriter();
        out.println(a);
        out.println(b);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
