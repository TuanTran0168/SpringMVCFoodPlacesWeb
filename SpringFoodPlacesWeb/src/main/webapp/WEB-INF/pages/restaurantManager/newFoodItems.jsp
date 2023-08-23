<%-- 
    Document   : newFoodItems
    Created on : Aug 17, 2023, 11:51:46 AM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 style="text-align: center">THÊM MÓN</h1>

<div class="container">

    <c:url value="/restaurantManager/foodItems/newFoodItems" var="action"/>
    <form:form method="post" action="${action}" modelAttribute="foodItem" enctype="multipart/form-data">
        <form:errors path="*" element="div" cssClass="alert alert-danger" />
        <div class="form-floating mb-3 mt-3">
            <form:input type="text" class="form-control" path="foodName" id="foodName" placeholder="Nhập tên món... " name="foodName" />
            <label for="foodName">Nhập tên món...</label>
        </div>

        <div class="form-floating mb-3 mt-3">
            <form:input type="text" class="form-control" path="price" id="price" placeholder="Nhập giá... " name="price" />
            <label for="price">Nhập giá...</label>
        </div>
        
        <div class="form-floating mb-3 mt-3">
            <form:input type="text" class="form-control" path="foodType" id="foodType" placeholder="Nhập loại... " name="foodType" />
            <label for="foodType">Nhập loại...</label>
        </div>

        <div class="form-floating mb-3 mt-3">
            <form:input type="file" class="form-control" path="file" id="file" name="file" />
            <label for="file">Avatar</label>
        </div>

        <button type="submit" class="btn btn-info">
            <c:choose>
                <c:when test="${foodItem.foodId == null}">
                    Thêm món
                </c:when>
                <c:otherwise>
                    Cập nhật món
                </c:otherwise>
            </c:choose>
        </button>
        <form:hidden path="foodId" />
        <form:hidden path="avatar" />
    </form:form>
</div>
