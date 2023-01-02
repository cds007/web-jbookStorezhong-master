<%--
  Created by IntelliJ IDEA.
  User: 22051
  Date: 2022/11/8
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp"%>


<%--    <ul class="messages">--%>
<%--        <li>${sessionScope.message}</li>--%>
<%--    </ul>--%>

<div id="BackLink">
        <a href="main">Return to Main Menu</a>
</div>

<div class="Order" align="center">
        <h2><strong>${sessionScope.message}</strong></h2>
        <table class="table-2 firstTable">
            <tr>
                <th align="center" colspan="2">
                    订单 #${sessionScope.order.orderId}
                    <fmt:formatDate value="${sessionScope.order.orderDate}" pattern="yyyy/MM/dd hh:mm:ss" />
                </th>
            </tr>
            <br>
            <tr>
                <th colspan="2">支付细节</th>
            </tr>
            <tr>
                <td>支付方式:</td>
<%--                <td><c:out value="${sessionScope.order.cardType}" /></td>--%>
                <td>支付宝支付</td>
            </tr>
<%--            <tr>--%>
<%--                <td>Card Number:</td>--%>
<%--                <td><c:out value="${sessionScope.order.creditCard}" /> * Fake number!</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Expiry Date (MM/YYYY):</td>--%>
<%--                <td><c:out value="${sessionScope.order.expiryDate}" /></td>--%>
<%--            </tr>--%>
            <br>
            <tr>
                <th colspan="2">账单细节</th>
            </tr>
            <tr>
                <td>姓:</td>
                <td><c:out value="${sessionScope.order.billToFirstName}" /></td>
            </tr>
            <tr>
                <td>名:</td>
                <td><c:out value="${sessionScope.order.billToLastName}" /></td>
            </tr>
            <tr>
                <td>地址1:</td>
                <td><c:out value="${sessionScope.order.billAddress1}" /></td>
            </tr>
            <tr>
                <td>地址2:</td>
                <td><c:out value="${sessionScope.order.billAddress2}" /></td>
            </tr>
            <tr>
                <td>城市:</td>
                <td><c:out value="${sessionScope.order.billCity}" /></td>
            </tr>
            <tr>
                <td>省份:</td>
                <td><c:out value="${sessionScope.order.billState}" /></td>
            </tr>
            <tr>
                <td>邮政编码:</td>
                <td><c:out value="${sessionScope.order.billZip}" /></td>
            </tr>
            <tr>
                <td>国家:</td>
                <td><c:out value="${sessionScope.order.billCountry}" /></td>
            </tr>
            <br>
            <tr>
                <th colspan="2">寄送地址</th>
            </tr>
            <tr>
                <td>姓:</td>
                <td><c:out value="${sessionScope.order.shipToFirstName}" /></td>
            </tr>
            <tr>
                <td>名:</td>
                <td><c:out value="${sessionScope.order.shipToLastName}" /></td>
            </tr>
            <tr>
                <td>地址1:</td>
                <td><c:out value="${sessionScope.order.shipAddress1}" /></td>
            </tr>
            <tr>
                <td>地址2:</td>
                <td><c:out value="${sessionScope.order.shipAddress2}" /></td>
            </tr>
            <tr>
                <td>城市:</td>
                <td><c:out value="${sessionScope.order.shipCity}" /></td>
            </tr>
            <tr>
                <td>省份:</td>
                <td><c:out value="${sessionScope.order.shipState}" /></td>
            </tr>
            <tr>
                <td>邮政编码:</td>
                <td><c:out value="${sessionScope.order.shipZip}" /></td>
            </tr>
            <tr>
                <td>国家:</td>
                <td><c:out value="${sessionScope.order.shipCountry}" /></td>
            </tr>
            <tr>
                <td>邮差:</td>
                <td><c:out value="${sessionScope.order.courier}" /></td>
            </tr>
            <tr>
                <td colspan="2">状态: <c:out value="${sessionScope.order.status}" /></td>
            </tr>
        </table>
        <br>
    <h2><strong>商品细节</strong></h2>

        <table class="table-2 secondTable">
                        <tr>
                            <th>商品ID</th>
                            <th>商品描述</th>
                            <th>数量</th>
                            <th>价格</th>
<%--                            <th>总价</th>--%>
                        </tr>
                        <c:forEach var="lineItem" items="${sessionScope.order.lineItems}">
                            <tr>
                                <td>
                                    <a href="viewItem?itemId=${lineItem.item.itemId}">${lineItem.item.itemId}</a>
                                </td>
                                <td><c:if test="${lineItem.item != null}">
                                    ${lineItem.item.attribute1}
                                    ${lineItem.item.attribute2}
                                    ${lineItem.item.attribute3}
                                    ${lineItem.item.attribute4}
                                    ${lineItem.item.product.name}
                                </c:if>
                                    <c:if test="${lineItem.item == null}">
                                        <i>{description unavailable}</i>
                                    </c:if></td>

                                <td>${lineItem.quantity}</td>
                                <td><fmt:formatNumber value="${lineItem.unitPrice}" pattern="$#,##0.00" /></td>
                                <td><fmt:formatNumber value="${lineItem.total}" pattern="$#,##0.00" /></td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td colspan="5">
                                总价: <fmt:formatNumber value="${sessionScope.order.totalPrice}" pattern="$#,##0.00" />
                            </td>
                        </tr>
        </table>
    </div>

    <%@ include file="../common/IncludeBottom.jsp"%>

