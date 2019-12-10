<%-- 
    Document   : ArticleDetail
    Created on : Dec 10, 2019, 11:00:11 PM
    Author     : bactv
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
        <table border="1" cellspacing="0">
            <tr>
                <td>Title</td>
                <td>${article.title}</td>
            </tr>
            <tr>
                <td>Author</td>
                <td>
                    <c:forEach var="author" items="${article.listAuthor}">
                        ${author.name}
                        <br>
                    </c:forEach></td>
            </tr>
            <tr>
                <td>Year</td>
                <td>${article.year}</td>
            </tr>
            <tr>
                <td>Publisher</td>
                <td>${article.publisher}</td>
            </tr>
            <tr>
                <td>Abstract</td>
                <td>${article.getAbstract()}</td>
            </tr>
        </table>
    </body>
</html>
