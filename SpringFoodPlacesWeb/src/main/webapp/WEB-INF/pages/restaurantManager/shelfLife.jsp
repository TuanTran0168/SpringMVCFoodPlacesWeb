<%-- 
    Document   : shelfLife
    Created on : Aug 12, 2023, 11:24:59 AM
    Author     : HP
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<c:url value="/restaurantManager/indexShelfLife" var = "action" />

<h1 style="text-align: center">${msg}</h1>
<section class="container">
    <div>
        <a href="shelfLife/newShelfLife" class = "btn btn-success"> Thêm Thời Gian Bán </a>
    </div>

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
                        <c:url value="#" var="apiDel" />
                        <button class = "btn btn-danger" onclick="delCate('${apiDel}', ${c.categoryfoodId})">Xóa</button>
                    </td>
                </tr>
            </tbody> 
        </c:forEach>
    </table>
</section>

