<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link type="text/css" rel="stylesheet" href="resources/css/bootstrap.min.css">
		<link type="text/css" rel="stylesheet" href="resources/css/style.css">
		<link type="text/css" rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<script src="resources/js/bootstrap.bundle.min.js"> </script>
		<title> Listando os campus </title>
	</head>
	<body>
		<c:import url="/WEB-INF/views/header.jsp" />
		<c:import url="/WEB-INF/views/menu.jsp" />
		
		<a href="adicionarCampus" class="btn btn-primary"> Adicionar campus</a>
		<table class="table">
			<thead class="table-success">
				<tr>
					<th> Código </th>
					<th> Nome </th>
					<th> Cidade </th>
					<th> Estado </th>
				</tr>
			</thead>
	
			<tbody>
				<c:forEach items="${campu}" var="campus">
					<tr id="campus_${campus.codigo}">	
						<td>${campus.codigo}</td>
						<td>${campus.nome}</td>
						<td>${campus.cidade}</td>
						<td>${campus.estado}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<c:import url="/WEB-INF/views/footer.jsp" />
	</body>
</html>