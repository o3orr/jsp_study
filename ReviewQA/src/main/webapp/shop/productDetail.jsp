<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Detail</title>
</head>
<body>

	${ProductDetail.product_name}
    ${ProductDetail.price}
	${ProductDetail.description}
	
	<input type="button" value="리뷰" onclick="location.href='ShopServlet?command=review_list&product_id=${ProductDetail.product_id}'">

</body>
</html>