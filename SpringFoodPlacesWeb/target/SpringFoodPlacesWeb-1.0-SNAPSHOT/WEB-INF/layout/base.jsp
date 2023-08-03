<%-- 
    Document   : base
    Created on : Jul 31, 2023, 9:35:39 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <tiles:insertAttribute name="title"/>
        </title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

        <!--        <style>
        <%@include file="/WEB-INF/resources/css/register.css"%>
    </style>
    
    // TRỜI TRỜI TRỜI CÚ TUI TRỜI ƠI :)))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))
    <link rel="stylesheet" href="../resources/css/register.css"/>-->

    </head>
    <body>

        <tiles:insertAttribute name="header"/>

        <div>
            <tiles:insertAttribute name="content"/>
        </div>

        <tiles:insertAttribute name="footer"/>

    </body>
</html>
