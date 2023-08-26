<%-- 
    Document   : categories
    Created on : Aug 9, 2023, 9:11:49 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/restaurantManager/indexCategories" var = "action" />

<h1 style="text-align: center">${msg}</h1>
<section class="container">
    <div>
        <a href="categoriesFood/newCategoriesFood" class = "btn btn-success"> Thêm Danh Mục </a>
    </div>

    <table class="table-hover container">
        <thead>
            <tr>
                <th>Category Id</th>
                <th>Category Name</th>
                <th>id nha hang</th>
                <hr>
            </tr>
        </thead>
        
    <c:forEach items="${categories}" var="c">
        <tbody>
            <tr>
                <td>${c.categoryfoodId}</td>
                <td>${c.categoryname}</td>
                <td>${c.restaurantId}</td>
                <td>
                        <a href="<c:url value="/restaurantManager/categoriesFood/newCategoriesFood/${c.categoryfoodId}" />" class = "btn btn-success">Cập nhật</a>
                        <c:url value="/api/restaurantManager/categoriesFood/newCategoriesFood/${c.categoryfoodId}" var="apiDel" />
                        <button class = "btn btn-danger" onclick="delCate('${apiDel}', ${c.categoryfoodId})">Xóa</button>
                    </td>
            </tr>
        </tbody> 
    </c:forEach>
    </table>
</section>

<script src="<c:url value="/js/category.js" />"></script>

