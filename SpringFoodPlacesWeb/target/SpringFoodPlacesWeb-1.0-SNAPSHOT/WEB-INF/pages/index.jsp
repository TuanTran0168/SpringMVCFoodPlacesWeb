<%-- 
    Document   : index
    Created on : Jul 27, 2023, 10:33:58 AM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href=" <c:url value="/css/index.css" /> "/>
<c:url value="/" var = "action" />


<h1 style = "text-align: center">${msg}</h1>

<c:if test="${param.accessDenied != null}">
    <div class="alert alert-danger alert-dismissible fade show">
        <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        <strong>Danger!</strong> DÔ ĐÂY CHI :) BIẾT GÌ MÀ DÔ
    </div>
</c:if>

<section class = "body">
    <h1 class ="text-center text-white">CHO MÌNH XIN CÁI GIAO DIỆN</h1>
</section>



    
