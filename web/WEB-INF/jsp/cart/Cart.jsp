<%--
  Created by IntelliJ IDEA.
  User: 22051
  Date: 2022/11/5
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink">
    <a href="viewProduct?productId=${sessionScope.product.productId}">Return to ${sessionScope.product.productId}</a>
</div>
<div class="public-shop-cart-two">
    <div class="content">
        <span>全部商品</span>

        <div class="cart-title">
            <span>商品</span>
            <span>商品ID</span>
            <span>所属小类ID</span>
            <span>商品信息</span>
            <span>单价</span>
            <span>数量</span>
            <span>小计</span>
            <span>操作</span>
        </div>
        <%--            如果购物车是空的--%>
        <c:if test="${sessionScope.cart.numberOfItems == 0}">
            <div class="cart-detail">
                <div class="cart-price">你的购物车是空的，快去挑选商品吧！！！！！</div>
            </div>
        </c:if>
        <c:forEach var="cartItem" items="${sessionScope.cart.cartItems}">
            <div class="cart-detail">
<%--                图片先留着，不会做--%>
                <div class="cart-title">
                        ${cartItem.item.attribute5}
                </div>
        <%--ItemId--%>
                <div class="cart-price"><a href="viewItem?itemId=${cartItem.item.itemId}">${cartItem.item.itemId}</a></div>

        <%--ProductId--%>
                <div class="cart-price">${cartItem.item.product.productId}</div>
        <%--商品描述信息--%>
                <div class="cart-price">
                        ${cartItem.item.attribute1} ${cartItem.item.attribute2}
                        ${cartItem.item.attribute3} ${cartItem.item.attribute4}
<%--                        ${cartItem.item.product.name}--%>
                </div>
        <%--单价--%>
                <div class="cart-price"><fmt:formatNumber value="${cartItem.item.listPrice}" pattern="¥#,##0.00" /></div>
        <%--数量--%>
                <div class="cart-number">
                    <input type="text" id="${cartItem.item.itemId}" class="cartQuantity" name="${cartItem.item.itemId}" value="${cartItem.quantity}">
                    <div id="cartMsg"></div>
                </div>
        <%--总价--%>
                <div class="cart-subtotal" id="${cartItem.item.itemId}total"><fmt:formatNumber value="${cartItem.total}" pattern="¥#,##0.00" /></div>
        <%--删除--%>
                <div class="cart-oprate"><a  href="removeItemFromCart?workingItemId=${cartItem.item.itemId}">删除</a></div>
            </div>
        </c:forEach>

        <c:if test="${sessionScope.cart.numberOfItems > 0}">
            <div class="cart-btn" ><span>总价：</span><span id="subtotal"> ¥${sessionScope.cart.subTotal} </span><button class="btn"><a  href="newOrderForm?itemId=${cartItem.item.itemId}">去结算</a></button></div>
        </c:if>

    </div>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>
