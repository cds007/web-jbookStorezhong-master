
<%--
  Created by IntelliJ IDEA.
  User: 22051
  Date: 2022/11/1
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="icon" href="images/chongwu.ico" type="image/x-icon">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.2/jquery.min.js"></script>
    <link rel="stylesheet" href="css/TopButtomMain.css">
    <link rel="stylesheet" href="css/order.css">
    <link href="https://cdn.bootcss.com/normalize/8.0.1/normalize.min.css" rel="stylesheet">
    <script src="https://kit.fontawesome.com/e2c1b76463.js" crossorigin="anonymous"></script>
    <title>叮当书城</title>
    <style>
    </style>
</head>
<body>
<div class="top-nav">
    <div class="container clearf">
        <div class="left">
            <a href="main" class="item">首页</a>
        </div>
        <div class="right">
            <c:if test="${sessionScope.account!=null}">
                <a href="viewListOrder?name=${sessionScope.account.name}" class="item">我的订单</a>
                <%--                <a href="" class="item">收藏夹</a>--%>
                <a href="signOff" class="item">退出登录</a>
                <a href="MyAccountForm" class="item">个人主页</a>
            </c:if>
            <c:if test="${sessionScope.account==null}">
                <a href="loginForm" class="item">我的订单</a>
                <%--                <a href="" class="item">收藏夹</a>--%>
                <a href="register" class="item">注册</a>
                <a href="loginForm" class="item">登录</a>
            </c:if>
        </div>
    </div>
    <div class="header">
        <div class="container clearf">
            <div class="col-2 logo">叮当书城</div>
            <div class="col-5 search-bar">
                <!--搜索栏目-->
                <form action="searchProduct" method="post">
                    <input type="text"  id="keyword" name="keyword" size="14" />
                    <%--                    <input type="submit" name="searchProducts" value="Search" />--%>
                    <button type="submit" name="searchProducts" value="Search">搜索</button>
                </form>
                <div id="productAutoComplete" class="productAutoComplete">
                    <ul id="productAutoList" class="productAutoList">
                    </ul>
                </div>
                <script src="js/findProduct.js" type="text/javascript" xml:lang="javascript" charset="UTF-8"></script>
            </div>
            <div class="col-3 cart">
                <a href="viewCart" class="item">我的购物车</a>
            </div>
        </div>
    </div>
    <div class="main-promote">