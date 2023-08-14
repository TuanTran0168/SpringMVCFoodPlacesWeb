<%-- 
    Document   : restaurants
    Created on : Aug 2, 2023, 9:49:37 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="<c:url value="/js/restaurants.js" />"></script>

<c:url value="admin/restaurants" var = "action" />
<h1 style = "text-align: center">${msg}</h1>

<section>
    <div>
        <a href="restaurants/newRestaurant" class = "btn btn-success"> Thêm restaurants </a>
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
                <th>Tên nhà hàng</th>
                <th>Địa chỉ</th>
                <th>Confirm-status</th>
                <th>Chủ nhà hàng</th>
                <th>Trạng thái</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${restaurant_list}" var = "restaurant">
                <tr>
                    <td>
                        <img style="width: 120px" src="${restaurant.avatar}" alt="Avatar của ${restaurant.restaurantName} "/>
                    </td>
                    <td>${restaurant.restaurantId}</td>
                    <td>${restaurant.restaurantName}</td>
                    <td>${restaurant.location}</td>
                    <td>${restaurant.confirmationStatus}</td>
                    <td>${restaurant.userId.userId}</td>
                    <td>${restaurant.restaurantStatus.restaurantStatus}</td>
                    <td>
                        <c:url value="/api/admin/restaurants/${restaurant.restaurantId}" var="restaurantPathAPI"/>
                        <a href="<c:url value="/admin/restaurants/${restaurant.restaurantId}" />" class = "btn btn-success">Cập nhật</a>
                        <button class = "btn btn-danger" onclick="deleteRestaurant('${restaurantPathAPI}', ${restaurant.restaurantId})">Xóa nà</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>