<%--
  Created by IntelliJ IDEA.
  User: 22051
  Date: 2022/11/4
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink">
    <a href="main">回到主页面</a>
</div>

<div id="Catalog">
    <%--    传入小类和实例列表--%>
    <h2>${sessionScope.product.name}</h2>
</div>
<div class="public-shop-cart-one">
    <div class="content">
        <span>List</span>
        <div class="cart-title">
            <span>Item ID</span>
            <span>Product ID</span>
            <span>Description</span>
            <span>List Price</span>
            <span>Operation</span>
        </div>

        <c:forEach var="item" items="${sessionScope.itemList}">
            <div class="cart-detail">

                <div class="cart-title">
                    <a href="viewItem?itemId=${item.itemId}">${item.itemId}</a>
                </div>
                <div class="cart-price">${item.product.productId}</div>

                <div class="cart-price">
                        ${item.attribute1}
                        ${item.attribute2}
                        ${item.attribute3}
                        ${item.attribute4}
<%--                        ${sessionScope.product.name}--%>
                </div>
                <div class="cart-price"> <fmt:formatNumber type="number" value="${item.listPrice}"
                                                           pattern="¥#,##0.00" /></div>

                <div class="cart-price">
                    <a class="Button" href="addItemToCart?workingItemId=${item.itemId}">Add to Cart</a>
                </div>

            </div>

        </c:forEach>

    </div>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>






