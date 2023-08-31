<%-- 
    Document   : users
    Created on : Jul 31, 2023, 9:52:17 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="<c:url value="/js/user.js" />"></script>

<h1 style="text-align: center">QUẢN LÝ USERS</h1>

<c:url value="/admin/users" var = "action" />
<h1 style = "text-align: center">${msg}</h1>

<c:if test="${param.accessDenied != null}">
    <div class="alert alert-danger alert-dismissible fade show">
        <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        <strong>Danger!</strong> DÔ ĐÂY CHI :) BIẾT GÌ MÀ DÔ
    </div>
</c:if>

<section>
    <div>
        <a href="users/newUser" class = "btn btn-success"> Thêm user </a>
    </div>

    <c:if test="${counter > 1}">
        <ul class="pagination mt-1">
            <c:url value="/admin/users" var="pageAction">
                <c:param name="pageAll"></c:param>
            </c:url>
            <li class="page-item"><a class="page-link" href="${pageAction}">Tất cả user</a></li>

            <c:forEach begin="1" end="${counter}" var = "i">
                <c:url value="/admin/users" var="pageAction">
                    <c:param name="page" value="${i}"></c:param>
                </c:url>
                <li class="page-item"><a class="page-link" href="${pageAction}">${i}</a></li>
                </c:forEach>
        </ul>
    </c:if>
    <table class="table table-hover container">
        <thead>
            <tr>
                <th>Avatar</th>
                <th>id</th>
                <th>role</th>
                <th>Họ và tên</th>
                <th>Số điện thoại</th>
                <th>Địa chỉ</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users_list}" var = "user">
                <tr>
                    <td>
                        <img style="width: 120px" src="${user.avatar}" alt="Avatar của ${user.firstname} ${user.lastname}"/>
                    </td>
                    <td>${user.userId}</td>
                    <td>${user.roleId.roleId}</td>
                    <td>${user.firstname} ${user.lastname}</td>
                    <td>${user.phonenumber}</td>
                    <td>${user.location}</td>

<!--                    <td>
                        <a href="<c:url value="/admin/users/${user.userId}" />" class = "btn btn-success">Cập nhật</a>
                        <button class = "btn btn-danger">Xóa nà</button>
                    </td>-->
                    
                    <td>
                        <c:url value="/api/server/admin/users/${user.userId}" var="userPathAPI"/>
                        <a href="<c:url value="/admin/users/${user.userId}" />" class = "btn btn-success">Cập nhật</a>
                        <button class = "btn btn-danger" onclick="deleteUser('${userPathAPI}', ${user.userId})">Xóa nà</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>

<%--<form:form method="post" modelAttribute="user" >
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="username" id="username" placeholder="Nhập tên đăng nhập... " name="username" />
        <label for="firstname">Lát làm...</label>
    </div>

    <div class="form-floating mb-3 mt-3">  ẢO MA cái path
        <form:input type="text" class="form-control" path="password" id="confirmPassoword" placeholder="Xác nhận mật khẩu... " name="confirmPassoword" />
        <label for="confirmPassoword">Lát làm...</label>
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="phonenumber" id="phonenumber" placeholder="Nhập số điện thoại... " name="phonenumber" />
        <label for="phonenumber">Lát làm...</label>
    </div>
</form:form>--%>


<!--<div class="header">
    <div class="header-main">
        <h1>Classy Login Form</h1>
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
</div>-->

