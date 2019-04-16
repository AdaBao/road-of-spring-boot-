<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show all students</title>
</head>
<body>

<table>
<tr>
<th>
编号
</th>
<th>
姓名
</th>
<th>
年龄
</th>
</tr>
<c:forEach items="${students}" var="student">
<tr>
<td>${student.id}</td>
<td>${student.name}</td>
<td>${student.age}</td>
</tr>
</c:forEach>
</table>
</body>
</html>