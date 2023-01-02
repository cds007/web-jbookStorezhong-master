<%--
  Created by IntelliJ IDEA.
  User: 22051
  Date: 2022/11/8
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp"%>

<div class="Order" align="center">
  <form action="shippingAddress" method="post">
    <table class="table-2 firstTable">
      <tr>
        <th colspan=2>寄送地址</th>
      </tr>

      <tr>
        <td>姓:</td>
        <td><input type="text" name="shipToFirstName" value="${sessionScope.order.shipToFirstName}"/></td>
      </tr>
      <tr>
        <td>名:</td>
        <td><input type="text" name="shipToLastName" value="${sessionScope.order.shipToLastName}"/></td>
      </tr>
      <tr>
        <td>地址1:</td>
        <td><input type="text" size="40" name="shipAddress1" value="${sessionScope.order.shipAddress1}"/></td>
      </tr>
      <tr>
        <td>地址2:</td>
        <td><input type="text" size="40" name="shipAddress2" value="${sessionScope.order.shipAddress2}"/></td>
      </tr>
      <tr>
        <td>城市:</td>
        <td><input type="text" name="shipCity" value="${sessionScope.order.shipCity}"/></td>
      </tr>
      <tr>
        <td>省份:</td>
        <td><input type="text" size="4" name="shipState" value="${sessionScope.order.shipState}"/></td>
      </tr>
      <tr>
        <td>邮政编码:</td>
        <td><input type="text" size="10" name="shipZip" value="${sessionScope.order.shipZip}"/></td>
      </tr>
      <tr>
        <td>国家:</td>
        <td><input type="text" size="15" name="shipCountry" value="${sessionScope.order.shipCountry}"/></td>
      </tr>

    </table>
    <input type="submit" name="newOrder" value="Continue" class="buttonContinue"/>
  </form>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>
