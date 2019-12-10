<%-- 
    Document   : home
    Created on : Dec 10, 2019, 9:36:11 PM
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
        Filter
        <br>
        <form  method="post">
            By year 
            <select name="year" onchange="this.form.submit()">
                <c:forEach var="year" items="${years}">
                    <option value="${year}" ${param.year == year?"selected":""}>${year}</option>
                </c:forEach>
            </select>
            <br>
            by Author
            <select name="author" onchange="this.form.submit()">
                <c:forEach var="author" items="${authors}">
                    <option value="${author.authorId}" ${param.author == author.authorId?"selected":""}>${author.name}</option>
                </c:forEach>
            </select>

        </form>
        <br>
        <br>

        <table border="1">
            <tr>
                <td>Article</td>
                <td>Year</td>
                <td>By</td>

            </tr>

            <c:forEach var="article" items="${articles}">
                <tr>
                    <td><a href="view?id=${article.id}" >${article.title}</a></td>
                    <td>${article.year}</td>
                    <td>
                        <c:forEach var="author" items="${article.listAuthor}">
                            <a href=""> ${author.name}</a>
                            <br>
                        </c:forEach>
                    </td>
                </tr>


            </c:forEach>



        </table>


    </body>
</html>
