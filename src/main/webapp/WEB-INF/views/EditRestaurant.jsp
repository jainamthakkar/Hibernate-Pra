<%@page import="com.entity.RestaurantEntity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% RestaurantEntity restaurants = (RestaurantEntity)request.getAttribute("restaurants");%>

	<form action="editedrestro" method="post">
		ID : <input type="number" name="restaurantId"  value="<%=restaurants.getRestaurantId() %>" readonly/><br><br>
		Name : <input type="text" name="name" value="<%=restaurants.getName() %>"/><br><br>
		Address : <input type="text" name="address" value="<%=restaurants.getAddress() %>"/><br><br>
		Category : <input type="text" name="category" value="<%=restaurants.getCategory() %>"/><br><br>
		
		<input type="submit" value="Save Update">
	</form>
</body>
</html>