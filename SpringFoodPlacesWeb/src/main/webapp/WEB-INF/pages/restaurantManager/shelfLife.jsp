<%-- 
    Document   : shelfLife
    Created on : Aug 12, 2023, 11:24:59 AM
    Author     : HP
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href=" <c:url value="/css/foodItems.css" /> "/>

<c:url value="/restaurantManager/indexShelfLife" var = "action" />

<link rel="stylesheet" href=" <c:url value="/css/toastBug.css" /> "/>
<c:if test="${not empty param.msg}">
    <div class="toast show">
        <div class="toast-header">
            <h1>ERROR!</h1>
            <button type="button" class="btn-close" data-bs-dismiss="toast"></button>
        </div>
        <div class="toast-body">
            ${param.msg}
        </div>
    </div>
</c:if>
<section class="container">
    <!--    <div>
            <a href="shelfLife/newShelfLife" class = "btn btn-success"> Thêm Thời Gian Bán </a>
        </div>-->

    <div>
        <form:form method="post" modelAttribute="shelfLife">
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:input type="text" class="form-control" path="shelflifeName" id="shelflifeName" placeholder="Nhập Tên... " name="shelflifeName" />
            <label for="shelflifeName">Nhập Tên</label>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:input required="required" type="date" class="form-control" path="fromDate" id="fromDate" placeholder="Nhập Ngày Bắt Đầu... " name="fromDate" />
            <label for="fromDate">Nhập Ngày Bắt Đầu</label>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:input required="required" type="date" class="form-control" path="toDate" id="toDate" placeholder="Nhập Ngày Kết Thúc... " name="toDate" />
            <label for="toDate">Nhập Ngày Kết Thúc</label>
        </div>

        <div class="form-floating mb-3 mt-3">
            <button class="btn btn-info" type="submit">
                Thêm thời gian bán PROMAX
            </button>
        </div>
    </form:form>
</div>
</section>

<table class="table-hover container">
    <thead>
        <tr>
            <th>Name</th>
            <th>fromDate</th>
            <th>toDate</th>

    <hr>
    </tr>
    </thead>

    <c:forEach items="${shelfLifes}" var="s">
        <tbody>
            <tr>
                <td>${s.shelflifeName}</td>
                <td>${s.fromDate}</td>
                <td>${s.toDate}</td>

                <td>
                    <a href="<c:url value="/restaurantManager/shelfLife/newShelfLife/${s.shelflifeId}" />" class = "btn btn-success">Cập nhật</a>
                    <c:url value="/api/server/restaurantManager/shelfLife/newShelfLife/${s.shelflifeId}" var="apiDel" />
                    <button class = "btn btn-danger" onclick="deleteShelfLife('${apiDel}', ${s.shelflifeId})">Xóa</button>
                </td>
            </tr>
        </tbody>
    </c:forEach>
</table>
<script src="<c:url value="/js/shelfLife.js" />"></script>

