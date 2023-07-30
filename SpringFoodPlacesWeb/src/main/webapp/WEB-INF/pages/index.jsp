<%-- 
    Document   : index
    Created on : Jul 27, 2023, 10:33:58 AM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WEB CỦA TUI ĐÓ</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </head>
    <body>
        <c:url value="/" var = "action" />
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">WEB CỦA TUI</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="collapsibleNavbar">
                    <ul class="navbar-nav me-auto">

                        <li class="nav-item">
                            <a class="nav-link" href="${action}">Trang chủ</a>
                        </li>

                        <c:forEach items="${roles}" var = "role">
                            <c:url value="/" var = "rolesAction">
                                <c:param name="roleId" value="${role.roleId}" />
                            </c:url>
                            <li class="nav-item">
                                <a class="nav-link" href="${rolesAction}">${role.roleId} -  ${role.roleName}</a>
                            </li>

                        </c:forEach>

                    </ul>
                    <form class="d-flex" action="${action}">
                        <input class="form-control me-2" type="text" name="keyword" placeholder="Nhập gì đi... ">
                        <button class="btn btn-primary" type="submit">Tìm</button>
                    </form>
                </div>
            </div>

        </nav>

        <h1 style = "text-align: center">${msg}</h1>

        <section>
            <div>
                <a href="#" class = "btn btn-success"> Thêm sản phẩm </a>
            </div>

            <c:if test="${counter > 1}">
                <ul class="pagination mt-1">
                    <li class="page-item"><a class="page-link" href="${action}">Tất cả user</a></li>

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

    </body>
</html>
