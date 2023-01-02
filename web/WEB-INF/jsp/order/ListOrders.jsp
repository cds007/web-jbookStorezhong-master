<%--
  Created by IntelliJ IDEA.
  User: 22051
  Date: 2022/11/10
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../common/IncludeTop.jsp"%>

<div class="Order" align="center">
<h2>My Orders</h2>
<table class="table-2 secondTable">
    <tr>
        <th>Order ID</th>
        <th>Date</th>
        <th>Total Price</th>
    </tr>

    <c:forEach var="order" items="${sessionScope.orderList}">
        <tr>
            <td>
                <a href="viewOrder?orderId=${order.orderId}">${order.orderId}</a>
            </td>
            <td>
                <fmt:formatDate value="${order.orderDate}" pattern="yyyy/MM/dd hh:mm:ss" />
            </td>
            <td>
                <fmt:formatNumber value="${order.totalPrice}" pattern="$#,##0.00" />
            </td>
        </tr>
    </c:forEach>
</table>
</div>
<%@ include file="../common/IncludeBottom.jsp"%>
