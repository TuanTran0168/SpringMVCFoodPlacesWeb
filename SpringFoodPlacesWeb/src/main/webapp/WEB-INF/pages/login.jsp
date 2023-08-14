<%-- 
    Document   : login
    Created on : Aug 11, 2023, 10:12:07 AM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/login" var="action" />

<form class="container" method="post" action="${action}">
    <div class="form-floating mb-3 mt-3">
        <input type="text" class="form-control" id="username" placeholder="Nhập username" name="username">
        <label for="username">Nhập tên đăng nhập</label>
    </div>

    <div class="form-floating mt-3 mb-3">
        <input type="text" class="form-control" id="password" placeholder="Nhập password" name="password">
        <label for="password">Nhập mật khẩu</label>
    </div>
    
    <div class="form-floating mt-3 mb-3">
        <input type="submit" value="Đăng nhập" class="btn btn-danger">
    </div>
</form>