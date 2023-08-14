<%-- 
    Document   : header
    Created on : Jul 31, 2023, 9:35:50 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name != null}">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/" />">${pageContext.request.userPrincipal.name}</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/logout" />">Đăng xuất nè</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/login" />">Đăng nhập nè</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/register" />">Đăng ký nè</a>
                        </li>
                    </c:otherwise>
                </c:choose>

            </ul>
            <form class="d-flex" action="${action}">
                <input class="form-control me-2" type="text" name="keyword" placeholder="Nhập gì đi... ">
                <button class="btn btn-primary" type="submit">Tìm</button>
            </form>
        </div>
    </div>

</nav>
<%-- 
    Document   : header
    Created on : Jul 31, 2023, 9:35:50 AM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--<div class="header">
    <div class="flex">
        <h2><span href="#">Trang Chủ</span></h2>
        <div class="btn-dn-dk">
            <button href="#">Đăng Nhập</button>
            <button href="#">Đăng Ký</button>
        </div>
    </div>
    <hr>
</div>-->
