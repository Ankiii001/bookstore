<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css">
<div class="container">

	<div class="links">
		<h1>
			<a href="list">Book Store</a>
		</h1>
		<h2>
			<a href="new">Add New Book</a>
		</h2>
	</div>
	<table>
		<caption>List of Books</caption>
		<tr>
			<th>S.No</th>
			<th>Title</th>
			<th>Author</th>
			<th>Price</th>
		</tr>
		<c:forEach items="${book_list}" var="item">
			<tr>
				<td>${item.getId() }</td>
				<td>${item.getTitle() }</td>
				<td>${item.getAuthor() }</td>
				<td>${item.getPrice() }</td>
			</tr>
		</c:forEach>
	</table>
</div>
</html>