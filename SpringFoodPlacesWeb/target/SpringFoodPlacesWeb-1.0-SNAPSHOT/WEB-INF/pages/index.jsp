<%-- 
    Document   : index
    Created on : Jul 27, 2023, 10:33:58 AM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/" var = "action" />


<h1 style = "text-align: center">${msg}</h1>

<c:if test="${param.accessDenied != null}">
    <div class="alert alert-danger alert-dismissible fade show">
        <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        <strong>Danger!</strong> DÔ ĐÂY CHI :) BIẾT GÌ MÀ DÔ
    </div>
</c:if>

<section>
    <div>
        <a href="#" class = "btn btn-success"> Thêm sản phẩm </a>
    </div>

    <c:if test="${counter > 1}">
        <ul class="pagination mt-1">
            <c:url value="/" var="pageAction">
                <c:param name="pageAll"></c:param>
            </c:url>
            <li class="page-item"><a class="page-link" href="${pageAction}">Tất cả user</a></li>

            <c:forEach begin="1" end="${counter}" var = "i">
                <c:url value="/" var="pageAction">
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
            <c:forEach items="${users}" var = "user">
                <tr>
                    <td>
                        <img style="width: 120px" src="${user.avatar}" alt="Avatar của ${user.firstname} ${user.lastname}"/>
                    </td>
                    <td>${user.userId}</td>
                    <td>${user.roleId.roleId}</td>
                    <td>${user.firstname} ${user.lastname}</td>
                    <td>${user.phonenumber}</td>
                    <td>${user.location}</td>

                    <td>
                        <a href="#" class = "btn btn-success">Cập nhật</a>
                        <button class = "btn btn-danger">Xóa nà</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>


<ul>

    <c:forEach items="${roles}" var = "role">

        <li>${role.roleId} -  ${role.roleName}</li>

    </c:forEach>

</ul>

<ul>

    <c:forEach items="${users}" var = "user">

        <li>${user.userId} -  ${user.firstname} -  ${user.lastname} -  ${user.phonenumber} -  ${user.location}</li>

    </c:forEach>

</ul>

