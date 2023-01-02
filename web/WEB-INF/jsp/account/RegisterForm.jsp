<%--
  Created by IntelliJ IDEA.
  User: 22051
  Date: 2022/11/9
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="css/sign.css">
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.2/jquery.min.js"></script>
<body background="images/background.png">
<div class="content">
    <h1 align="center">用户注册</h1><br />
    <font color="aqua">
        <form  action="Register" class="user-form"  method="post">
            <fieldset >
                <c:if test="${requestScope.rmsg != null}">
                    <div class="user-form-error">
                        <p class="error-msg">${requestScope.rmsg}</p>
                    </div>
                </c:if>
                <h3 align="center">User Information</h3>
                <div id="feedback"></div>
                <table align="center" >
                    <tr>
                        <td class="font111">User ID:</td>
                        <td><input type="text" id="userid" name="userid" class="font111" /></td>
                    </tr>
                    <tr>
                        <td class="font111">Password:</td>
                        <td><input type="text" id="password"  name="Password" class="font111" /></td>
                    </tr>
                    <tr>
                        <td class="font111">Repeat Password:</td>
                        <td><input type="text" id="password1" name="Password2"  /></td>
                    </tr>
                </table>

                <h3 align="center">Account Information</h3>
                <table  align="center">
                    <tr>
                        <td class="font111">First name:</td>
                        <td><input type="text" id="password2"name="firstName" class="font111" /></td>
                    </tr>
                    <tr>
                        <td class="font111">Last name:</td>
                        <td><input type="text"  id="password3"name="lastName"class="font111" /></td>
                    </tr>
                    <tr>
                        <td class="font111">Email:</td>
                        <td><input type="text" id="password4"name="email" class="font111" /></td>
                    </tr>
                    <tr>
                        <td class="font111">Phone:</td>
                        <td><input type="text" id="password5" name="phone" class="font111"/></td>
                    </tr>
                    <tr>
                        <td class="font111">Address 1:</td>
                        <td><input type="text" id="password6"name="address1" class="font111" /></td>
                    </tr>
                    <tr>
                        <td class="font111">Address 2:</td>
                        <td><input type="text" id="password7" name="address2" class="font111" /></td>
                    </tr>
                    <tr>
                        <td class="font111">City:</td>
                        <td><input type="text" id="password8"name="city" class="font111" /></td>
                    </tr>
                    <tr>
                        <td class="font111">State:</td>
                        <td><input type="text" id="password9" name="state" size="4" class="font111" /></td>
                    </tr>
                    <tr>
                        <td class="font111">Zip:</td>
                        <td><input type="text" id="password10" name="zip" size="10" class="font111" /></td>
                    </tr>
                    <tr>
                        <td class="font111"Country:></td>
                        <td><input type="text"  id="password11" name="country" size="15"  class="font111"/></td>
                    </tr>
                </table>

                <h3 align="center">Profile Information</h3>

                <table class="table-view" align="center">
                    <tr>
                        <td class="font111">Language Preference:</td>
                        <td><select id="password12" name="languagePreference" class="font111">
                            <option value="CHINESE" class="font111">CHINESE</option>
                            <option  value="ENGLISH" class="font111">ENGLISH</option>
                        </select></td>
                    </tr>
                    <tr>
                        <td class="font111">Favourite Category:</td>
                        <td><select id="password13" name="favouriteCategoryId" class="font111" class="font111">
                            <option value="FISH" class="font111">FISH</option>
                            <option selected="selected" value="DOGS" class="font111">DOGS</option>
                            <option value="REPTILES" class="font111">REPTILES</option>
                            <option value="CATS" class="font111">CATS</option>
                            <option value="BIRDS" class="font111">BIRDS</option>
                        </select></td>
                    </tr>
                    <%--                    <tr>--%>
                    <%--                        <td class="font111">Enable MyList</td>--%>
                    <%--                        <td><input id="password14" type="checkbox" name="listOption"  value="1" class="font111"/></td>--%>
                    <%--                    </tr>--%>
                    <tr>
                        <td class="font111">Enable MyBanner</td>
                        <td><input id="password15" type="checkbox" name="bannerOption" value="1" class="font111"/></td>
                    </tr>

                </table>
            </fieldset>

            <input id="denglu1" type="submit" value="开始注册" align="center" >

        </form>
        <script type="text/javascript"  src="js/RegisterForm.js"></script>

    </font>
</div>