<%-- 
    Document   : restaurantManager.jsp
    Created on : Aug 17, 2023, 8:50:56 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href=" <c:url value="/css/background.css" /> "/>

<div class="container">

    <a href="<c:url value="/restaurantManager/restaurants" />" class="btn btn-info">Quản lý restaurants</a>

<a href="<c:url value="restaurantManager/restaurants/newRestaurant" />" class="btn btn-info">Quản lý newRestaurant</a>

    <a href="<c:url value="restaurantManager/shelfLife" />" class="btn btn-success">Quản lý shelfLife</a>

    <a href="<c:url value="restaurantManager/categoriesFood" />" class="btn btn-success">Quản lý categoriesFood</a>

    <a href="<c:url value="restaurantManager/foodItems" />" class="btn btn-success">Quản lý foodItems</a>


</div>