<%-- 
    Document   : restaurants
    Created on : Aug 2, 2023, 9:49:37 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 style="text-align: center">QUẢN LÝ NHÀ HÀNG</h1>
<h1>${restaurantStatus_list[1].statusId}</h1>
<h1>${restaurantStatus_list[1].restaurantStatus}</h1>

<c:url value="/restaurants" var="action"/>

<form:form method="post" action="${action}" modelAttribute="restaurant" >
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
        <form:select class="form-select" id="restaurants" name="restaurants" path="restaurantStatus">
            <c:forEach items="${restaurantStatus_list}" var="rS">
                <option value="${rS.statusId}" selected>${rS.restaurantStatus}</option>
            </c:forEach>
        </form:select>

        <label for="restaurants" class="form-label">Danh mục restaurantStatus</label>
    </div>

    <button type="submit" class="btn btn-info">
        Thêm
    </button>
</form:form>