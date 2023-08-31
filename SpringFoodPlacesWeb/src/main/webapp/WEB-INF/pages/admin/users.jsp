<%-- 
    Document   : users
    Created on : Jul 31, 2023, 9:52:17 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="<c:url value="/js/user.js" />"></script>
<link rel="stylesheet" href=" <c:url value="/css/background.css" /> "/>

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
