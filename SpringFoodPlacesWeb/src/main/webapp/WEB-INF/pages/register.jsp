<%-- 
    Document   : registerController
    Created on : Aug 2, 2023, 8:44:16 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 style="text-align: center">ĐĂNG KÝ</h1>

<form:form method="post" modelAttribute="user" >
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="username" id="username" placeholder="Nhập tên đăng nhập... " name="username" />
        <label for="firstname">Nhập tên đăng nhập...</label>
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="password" id="password" placeholder="Nhập mật khẩu... " name="password" />
        <label for="password">Nhập mật khẩu...</label>
    </div>

    <div class="form-floating mb-3 mt-3"> <%-- ẢO MA cái path--%>
        <form:input type="text" class="form-control" path="password" id="confirmPassoword" placeholder="Xác nhận mật khẩu... " name="confirmPassoword" />
        <label for="confirmPassoword">Xác nhận mật khẩu...</label>
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="phonenumber" id="phonenumber" placeholder="Nhập số điện thoại... " name="phonenumber" />
        <label for="phonenumber">Nhập số điện thoại...</label>
    </div>

        <button class="btn btn-info">
            Đăng ký
        </button>
</form:form>