<%-- 
    Document   : index
    Created on : Jul 27, 2023, 10:33:58 AM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h1>${msg}</h1>
        <ul>
            
            <c:forEach items="${roles}" var = "r">
                
                <li>${r.roleId} -  ${r.roleName}</li>
                
            </c:forEach>
            
        </ul>

    </body>
</html>
