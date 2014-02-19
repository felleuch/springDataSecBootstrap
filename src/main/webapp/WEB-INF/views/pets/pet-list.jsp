<%@ page language="java" contentType="text/html; charset=ISO-8859-1"       pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<body>
<h1>Pet List page</h1>






<table class="table" >
<thead>
<tr>
<th width="25px">Name</th><th width="150px">Color</th><th width="25px">Type</th><th width="50px">Type</th>
</tr>
</thead>
<tbody>
<c:forEach var="pet" items="${petList}">
<tr>
<td>${pet.name}</td>
<td>${pet.color}</td>
<td>${pet.petType.name}</td>
<td>
<a href="${pageContext.request.contextPath}/pets/edit/${pet.id}.html">Edit</a><br/>
<a href="${pageContext.request.contextPath}/pets/delete/${pet.id}.html">Delete</a><br/>
</td>
</tr>
</c:forEach>
</tbody>
</table>
<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html>