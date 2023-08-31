<%-- 
    Document   : foodItems
    Created on : Aug 17, 2023, 10:19:35 AM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section class="container">
    <div>
        <a href="foodItems/newFoodItems" class = "btn btn-success mt-3"> Thêm món ăn </a>
    </div>

    <table class="table-hover container">
        <thead>
            <tr>
                <th>Id</th>
                <th>Ảnh</th>
                <th>Tên</th>
                <th>Giá</th>
                <th>Tình Trạng</th>
                <th>mô tả</th>
                
        <hr>
        </tr>
        </thead>

        <c:forEach items="${foodItems}" var="f">
            <tbody>
                <tr>
                    <td>${f.foodId}</td>
                    <td><img style="width:120px" src=${f.avatar} /></td>
                    <td>${f.foodName}</td>
                    <td>${f.price}</td>
                    <td>${f.available}</td>
                    <td>${f.description}</td>
                    
                    <td>
                        <a href="<c:url value="/restaurantManager/foodItems/${f.foodId}" />" class = "btn btn-success">Cập nhật</a>
                        <c:url value="/api/server/restaurantManager/foodItems/newFoodItems/${f.foodId}" var="apiDel" />
                        <button class = "btn btn-danger" onclick="deleteFood('${apiDel}', ${f.foodId})">Xóa</button>
                    </td>
                </tr>
            </tbody>
        </c:forEach>
    </table>
</section>

<script src="<c:url value="/js/foodItems.js" />"></script>
