<%--
  Created by IntelliJ IDEA.
  User: DABugakov
  Date: 27.11.2015
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>Users</h1>

<c:url var="addUrl" value="/users/add.do" />

<table style="border: 1px solid; width: 500px; text-align:center">
    <thead style="background:#fcf">
    <tr>
        <th>Name</th>
        <th>Mail</th>
        <th colspan="2"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="users">
        <tr>
            <td><c:out value="${users.name}" /></td>
            <td><c:out value="${users.email}" /></td>
            <td><a href="${addUrl}">Add</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<c:if test="${empty users}">
    There are currently no users in the list. <a href="${addUrl}">Add</a> a person.
</c:if>

</body>
</html>