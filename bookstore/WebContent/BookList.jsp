<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

table, th, td {
	border: 1px solid black;
	height: 50px;
}

th {
	text-align: left;
	padding: 15px;
	background-color: #4CAF50;
	color: white;
}

caption {
	color: red;
	font-weight: bold;
	font-size: 2em;
	padding: 8px 0 10px;
}

h1 {
	text-align: center;
}
</style>

<div class="container">
	<h1>Book Store</h1>
	<table>
		<caption>List of Books</caption>
		<tr>
			<th>Title</th>
			<th>Author</th>
			<th>Price</th>
		</tr>
		<c:forEach items="${book_list}" var="item">
			<tr>
				<td>${item.getTitle() }</td>
				<td>${item.getAuthor() }</td>
				<td>${item.getPrice() }</td>
			</tr>
		</c:forEach>
	</table>
</div>
</html>