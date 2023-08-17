<%-- 
    Document   : newRestaurant
    Created on : Aug 6, 2023, 4:19:27 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 style="text-align: center">QUẢN LÝ NHÀ HÀNG</h1>
<h1>${restaurantStatus_list[1].statusId}</h1>
<h1>${restaurantStatus_list[1].restaurantStatus}</h1>

<div class="container">

    <c:url value="/restaurantManager/restaurants/newRestaurant" var="action"/>
    <form:form method="post" action="${action}" modelAttribute="restaurant" enctype="multipart/form-data">
        <form:errors path="*" element="div" cssClass="alert alert-danger" />
        <div class="form-floating mb-3 mt-3">
            <form:input type="text" class="form-control" path="restaurantName" id="restaurantName" placeholder="Nhập tên nhà hàng... " name="restaurantName" />
            <label for="restaurantName">Nhập tên nhà hàng...</label>
        </div>

        <div class="form-floating mb-3 mt-3">
            <form:input type="text" class="form-control" path="location" id="location" placeholder="Nhập địa chỉ nhà hàng... " name="location" />
            <label for="location">Nhập địa chỉ nhà hàng...</label>
        </div>

        <div class="form-floating mb-3 mt-3">
            <form:input type="text" class="form-control" path="mapLink" id="mapLink" placeholder="Nhập tên nhà hàng... " name="mapLink" />
            <label for="restaurantName">Cái maplink này nhập đại đi chứ đách xử lý đc...</label>
        </div>

        <div class="form-floating mb-3 mt-3">
            <form:input type="file" class="form-control" path="file" id="file" name="file" />
            <label for="file">Avatar</label>
        </div>

        <div class="form-floating mb-3 mt-3">
            <form:select class="form-select" id="restaurants" name="restaurants" path="restaurantStatus">
                <c:forEach items="${restaurantStatus_list}" var="rS">
                    <c:choose>
                        <c:when test="${rS.statusId == restaurant.restaurantStatus.statusId}">
                            <option value="${rS.statusId}" selected="${rS.restaurantStatus}">${rS.restaurantStatus}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${rS.statusId}">${rS.restaurantStatus}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>

            <label for="restaurants" class="form-label">Danh mục restaurantStatus</label>
        </div>
        <button type="submit" class="btn btn-info">
            <c:choose>
                <c:when test="${restaurant.restaurantId == null}">
                    Thêm nhà hàng
                </c:when>
                <c:otherwise>
                    Cập nhật nhà hàng
                </c:otherwise>
            </c:choose>
        </button>
        <form:hidden path="restaurantId" />
        <form:hidden path="avatar" />
    </form:form>
</div>