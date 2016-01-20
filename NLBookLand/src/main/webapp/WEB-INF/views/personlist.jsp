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

	<c:if test="${not empty personlist}">
		<table class="tg">
		    <tr>
		        <th width="80">Person ID</th>
		        <th width="120">Person Name</th>
		        <th width="120">Person phone</th>
		        <th width="60">Person email address</th>
		        <th width="60">Edit</th>
        		<th width="60">Delete</th>		       
			    <c:forEach items="${personlist}" var="person">
			        <tr>
			            <td>${person.id}</td>
			            <td>${person.name}</td>
			            <td>${person.phone}</td>
			            <td>${person.email}</td>
			            <td><a href="<c:url value='/detail?id=${person.id}' />" >Details</a></td>			            
			        </tr>
			    </c:forEach>
		    </table>
		<%-- <ul>
			<c:forEach var="listValue" items="${Personlist}">
				<li>${listValue} <a href="Personbooks?name=${listValue}">Click Here for ${listValue} borrowed books</a></li>				
			</c:forEach>
		</ul>
 --%>
	</c:if>
</body>
</html>