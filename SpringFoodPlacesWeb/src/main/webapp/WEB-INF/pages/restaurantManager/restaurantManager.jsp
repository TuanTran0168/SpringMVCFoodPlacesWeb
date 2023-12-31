<%-- 
    Document   : restaurantManager.jsp
    Created on : Aug 17, 2023, 8:50:56 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href=" <c:url value="/css/background.css" /> "/>
<link rel="stylesheet" href=" <c:url value="/css/toastBug.css" /> "/>
<link rel="stylesheet" href=" <c:url value="/css/restaurantManager.css" /> "/>

<c:if test="${not empty param.msg}">
    <div class="toast show">
        <div class="toast-header">
            <h1>THÔNG BÁO!</h1>
            <button type="button" class="btn-close" data-bs-dismiss="toast"></button>
        </div>
        <div class="toast-body">
            ${param.msg}
        </div>
    </div>
</c:if>

<div class="container ">
    <div class="heading">
        <h1>QUẢN TRỊ NHÀ HÀNG</h1>
    </div>
    <div class="res-manager">
        <div class="res-item">
            <a href="<c:url value="/restaurantManager/restaurants" />" class="btn btn-info">
                <h3>
                    <i class="fa-solid fa-bowl-food fa-bounce"></i>
                    <br>Quản lý restaurants
                </h3>
            </a>

        </div>
<!--        <div class="res-item">
            <a href="<c:url value="restaurantManager/restaurants/newRestaurant" />" class="btn btn-info">
                <h3>
                    <i class="fa-solid fa-utensils fa-beat-fade"></i>
                    <br>Quản lý newRestaurant
                </h3></a>

        </div>-->
    </div>

<!--    <a href="<c:url value="restaurantManager/shelfLife" />" class="btn btn-success">Quản lý shelfLife</a>

    <a href="<c:url value="restaurantManager/categoriesFood" />" class="btn btn-success">Quản lý categoriesFood</a>

    <a href="<c:url value="restaurantManager/foodItems" />" class="btn btn-success">Quản lý foodItems</a>-->


</div>