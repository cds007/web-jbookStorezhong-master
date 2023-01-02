<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2022/11/6
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink">
    <a href="viewProduct?productId=${sessionScope.product.productId}">回到${sessionScope.product.productId}</a>
</div>
<br/>
<div class="heiheihei">
    <section class="product">
        <div class="product__photo">
            <div class="photo-container">
                <div class="photo-main">
                    <div class="controls">
                        <i class="material-icons">分享</i>
                        <i class="material-icons">喜爱的图片</i>
                    </div>
                    <br/>
                    ${sessionScope.item.attribute5}
                </div>
                <%--            <div class="photo-album">--%>
                <%--                <ul>--%>
                <%--                    <li></li>--%>
                <%--                </ul>--%>
                <%--            </div>--%>
            </div>
        </div>
        <div class="product__info">
            <div class="title">
                <h1>好看的书籍</h1>
                <span>${sessionScope.item.itemId}</span>
            </div>
            <div class="price">
                R$ <span>${sessionScope.item.listPrice}</span>
            </div>
            <%--        <div class="variant">--%>
            <%--            <h3>SELECT A COLOR</h3>--%>
            <%--            <ul>--%>
            <%--                <li><img src="https://res.cloudinary.com/john-mantas/image/upload/v1537302064/codepen/delicious-apples/green-apple2.png" alt="green apple"></li>--%>
            <%--                <li><img src="https://res.cloudinary.com/john-mantas/image/upload/v1537302752/codepen/delicious-apples/yellow-apple.png" alt="yellow apple"></li>--%>
            <%--                <li><img src="https://res.cloudinary.com/john-mantas/image/upload/v1537302427/codepen/delicious-apples/orange-apple.png" alt="orange apple"></li>--%>
            <%--                <li><img src="https://res.cloudinary.com/john-mantas/image/upload/v1537302285/codepen/delicious-apples/red-apple.png" alt="red apple"></li>--%>
            <%--            </ul>--%>
            <%--        </div>--%>
            <div class="description">
                <h3>基本信息</h3>
                <ul>
                    <li>${sessionScope.item.attribute1}</li>
                    <li>${sessionScope.item.attribute2}</li>
                    <li>${sessionScope.item.attribute3}</li>
                    <li>${sessionScope.item.attribute4}</li>
                </ul>
            </div>
<%--            <div class="description">--%>
<%--                <c:if test="${sessionScope.item.quantity <= 0}">--%>
<%--                    Back ordered.--%>
<%--                </c:if> <c:if test="${sessionScope.item.quantity > 0}">--%>
<%--                ${sessionScope.item.quantity} in stock.--%>
<%--            </c:if>--%>
<%--            </div>--%>
            <div>
                <a class="buy--btn" href="addItemToCart?workingItemId=${item.itemId}">Add to Cart</a>
<%--                <a href="" class="buy--btn">ADD TO CART</a>--%>
            </div>
        </div>
    </section>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>
