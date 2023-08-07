<%-- 
    Document   : registerController
    Created on : Aug 2, 2023, 8:44:16 AM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<link rel="stylesheet" href=" <c:url value="/css/register.css" /> "/>

<h1 style="text-align: center">ĐĂNG KÝ</h1>

<%--<form:form method="post" modelAttribute="user" >
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="username" id="username" placeholder="Nhập tên đăng nhập... " name="username" />
        <label for="firstname">Nhập tên đăng nhập...</label>
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="password" id="password" placeholder="Nhập mật khẩu... " name="password" />
        <label for="password">Nhập mật khẩu...</label>
    </div>

    <div class="form-floating mb-3 mt-3">  ẢO MA cái path
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
</form:form>--%>

<div class="header">
    <div class="header-main">
        <h1>ĐĂNG KÝ LẸ ĐI :)</h1>
        <div class="header-bottom">
            <div class="header-right w3agile">

                <div class="header-left-bottom agileinfo">

                    <form action="#" method="post">
                        <input type="text" value="User name" name="name" onfocus="this.value = '';"
                               onblur="if (this.value === '') {
                                           this.value = 'User name';
                                       }" />
                        <input type="password" value="Password" name="password" onfocus="this.value = '';"
                               onblur="if (this.value === '') {
                                           this.value = 'password';
                                       }" />
                        <input type="text" value="Confirm password" name="confirmPasword" onfocus="this.value = '';"
                               onblur="if (this.value === '') {
                                           this.value = 'confirmPasword';
                                       }" />
                        <input type="text" value="Phonenumber" name="phonenumber" onfocus="this.value = '';"
                               onblur="if (this.value === '') {
                                           this.value = 'phonenumber';
                                       }" />
                        <div class="remember">
                            <span class="checkbox1">
                                <label class="checkbox"><input type="checkbox" name="" checked=""><i> </i>Remember
                                    me</label>
                            </span>
                            <div class="forgot">
                                <h6><a href="#">Forgot Password?</a></h6>
                            </div>
                            <div class="clear"> </div>
                        </div>

                        <input type="submit" value="Login">
                    </form>
                    <div class="header-left-top">
                        <div class="sign-up">
                            <h2>or</h2>
                        </div>

                    </div>
                    <div class="header-social wthree login-gg">

                        <a href="#" class="face">
                            <img src="images/gg.png" class="imggg">
                            <h5>google</h5>
                        </a>
                    </div>

                </div>
            </div>

        </div>
    </div>
</div>