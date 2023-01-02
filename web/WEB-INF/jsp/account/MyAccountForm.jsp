<%@ page import="org.csu.webJpetStore.domain.Account" %><%--
  Created by IntelliJ IDEA.
  User: 22051
  Date: 2022/11/9
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp"%>

<c:set var="user" value="${sessionScope.loginaccount}"/>
<div>
    <form  action="MyAccountExchange" class="user-form"  method="post">
        <fieldset class="tab1">
            <c:if test="${requestScope.rmsg != null}">
                <div class="user-form-error">
                    <p class="error-msg">${requestScope.rmsg}</p>
                </div>
            </c:if>
            <h3 align="center">User Information</h3>
            <h4 align="center" id="feedback"></h4>
            <table class="table-view" align="center">
                <tr>
                    <td>User ID:</td>
                    <td><input type="text" name="name" id ="userid" value="${sessionScope.account.name}" autocomplete="off"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="text" name="Password" /></td>
                </tr>
                <tr>
                    <td>Repeat Password:</td>
                    <td><input type="text" name="Password2" /></td>
                </tr>
            </table>

            <h3 align="center">Account Information</h3>
            <table class="table-view" align="center">
                <tr>
                    <td>First name:</td>
                    <td><input type="text" name="firstName" value="${sessionScope.account.firstname}" autocomplete="off" /></td>
                </tr>
                <tr>
                    <td>Last name:</td>
                    <td><input type="text" name="lastName" value="${sessionScope.account.lastname}" autocomplete="off"/></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" name="email" value="${sessionScope.account.email}" autocomplete="off"/></td>
                </tr>
                <tr>
                    <td>Phone:</td>
                    <td><input type="text" name="phone" value="${sessionScope.account.phone}" autocomplete="off"/></td>
                </tr>
                <tr>
                    <td>Address 1:</td>
                    <td><input type="text" name="address1" value="${sessionScope.account.addr1}" autocomplete="off"/></td>
                </tr>
                <tr>
                    <td>Address 2:</td>
                    <td><input type="text" name="address2"  value="${sessionScope.account.addr2}" autocomplete="off"/></td>
                </tr>
                <tr>
                    <td>City:</td>
                    <td><input type="text" name="city" value="${sessionScope.account.city}" autocomplete="off"/></td>
                </tr>
                <tr>
                    <td>State:</td>
                    <td><input type="text" name="state" size="4" value="${sessionScope.account.state}" autocomplete="off"/></td>
                </tr>
                <tr>
                    <td>Zip:</td>
                    <td><input type="text" name="zip" size="10" value="${sessionScope.account.zip}" autocomplete="off"/></td>
                </tr>
                <tr>
                    <td>Country:</td>
                    <td><input type="text" name="country" size="15" value="${sessionScope.account.country}" autocomplete="off"/></td>
                </tr>
            </table>

            <h3 align="center">Profile Information</h3>

            <table class="table-view" align="center">
                <tr>
                    <td>Language Preference:</td>
                    <td><select name="languagePreference">
                        <option value="CHINESE" (${sessionScope.account.langpref}=="CHINESE")?(selected="selected"):pass>CHINESE</option>
                        <option  value="ENGLISH" (${sessionScope.account.langpref}=="ENGLISH")?(selected="selected"):pass>ENGLISH</option>
                    </select> </td>
                </tr>
                <tr>
                    <td>Favourite Category:</td>
                    <td><select name="favouriteCategoryId" >
                        <option value="FISH"  (${sessionScope.account.favcategory}=="FISH")?(selected="selected"):pass>FISH</option>
                        <option value="DOGS" (${sessionScope.account.favcategory}=="DOGS")?(selected="selected"):pass>DOGS</option>
                        <option value="REPTILES" (${sessionScope.account.favcategory}=="REPTILES")?(selected="selected"):pass>REPTILES</option>
                        <option value="CATS" (${sessionScope.account.favcategory}=="CATS")?(selected="selected"):pass>CATS</option>
                        <option value="BIRDS" (${sessionScope.account.favcategory}=="BIRDS")?(selected="selected"):pass>BIRDS</option>
                    </select></td>
                </tr>
                <%--                <tr>--%>
                <%--                    <td>Enable MyList</td>--%>
                <%--                    <td><input type="checkbox" name="listOption"  value="1" checked="${sessionScope.account.mylistopt}"/></td>--%>
                <%--                </tr>--%>
                <tr>
                    <td>Enable MyBanner</td>
                    <td><input type="checkbox" name="bannerOption" value="1" checked="${sessionScope.account.banneropt}"/></td>
                </tr>

            </table>
        </fieldset>
        <div class="user-input-item">
            <input type="submit" value="确定修改" class="user-form-submit1">
        </div>
    </form>
    <script type="text/javascript"  src="js/AccountExchange.js"></script>
    <%@ include file="../common/IncludeBottom.jsp"%>

