<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<link rel="stylesheet" type="text/css" href="css/sign.css">
<body background="images/background.png">


<div id="content">
    <h1 >用户登录</h1><br />
    <c:if test="${requestScope.msg != null}">

        <i class="fa-solid fa-triangle-exclamation error-icon"></i>
        <p class="error-msg" style="">${requestScope.msg}</p>

    </c:if>

    <form action="signon" method="post" >
        <input type="text" name="username" id="userid" placeholder="请输入用户名" /><br /><br />
        <input type="password" name="password" id="password" placeholder="请输入密码" /><br /><br />
        <input type="text"  name="code" id="code" placeholder="请输入验证码" autocomplete="off"  ><br/><br/>
        <a href="signon"><img border="0" src="code" alt="code" name="checkCode" width="300px" height="50px"> </a><br/><br/>
        <input type="submit" id="denglu"  value="登录" />&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <a href="register" target="_blank"><input type="button" name="zhuce"id="zhuce"value="注册"/></a>


    </form>

</div>
</body>

</html>