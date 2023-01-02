<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2022/11/7
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp"%>
<div id="BackLink">
    <a href="main">回到主页面</a>
</div>
<br/>
<div class="public-shop-cart-two">
    <div class="content">
        <span>检索商品</span>
        <div class="cart-title">
            <span style="width: 600px">商品</span>
            <span>所属小类ID</span>
            <span>名字</span>
            <span>所属种类</span>
            <span>操作</span>
        </div>
        <c:forEach var="product" items="${sessionScope.productList}">
            <div class="cart-detail">
                <div class="cart-title" style="width: 600px">
                        ${product.description}
                </div>
                <div class="cart-price">
                        ${product.productId}
                </div>
                <div class="cart-price">
                        ${product.name}
                </div>
                <div class="cart-price">
                        ${product.categoryId}
                </div>
                <div>
                    <a href="viewProduct?productId=${product.productId}" >获取商品</a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>
