<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person List</title>
</head>
<body>
	<h2>${message}</h2>

	<c:if test="${not empty booklist}">
		<table class="tg">
		    <tr>
		        <th width="80">Book ID</th>
		        <th width="120">Book Title</th>
		        <th width="120">Book Author</th>
		        <th width="150">Book ISBN</th>
        		<th width="60">Delete</th>		       
			    <c:forEach items="${booklist}" var="book">
			        <tr>
			            <td>${book.id}</td>
			            <td>${book.title}</td>
			            <td>${book.author}</td>
			            <td>${book.isbn}</td>
			            <td><a href="<c:url value='/edit/${book.id}' />" >Edit</a></td>
			            <td><a href="<c:url value='/remove/${book.id}' />" >Delete</a></td>
			        </tr>
			    </c:forEach>
		    </table>
	</c:if>
</body>
</html>