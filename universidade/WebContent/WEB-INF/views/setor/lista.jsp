<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Listando os setores</title>
		<!-- <link type="text/css" rel="stylesheet" href="resources/css/reset.css"> -->
		<link type="text/css" rel="stylesheet" href="resources/css/bootstrap.min.css">
		<link type="text/css" rel="stylesheet" href="resources/css/style.css">
		<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<script src="resources/js/bootstrap.bundle.min.js"> </script>
		<!--<link rel="stylesheet" href="resources/css/mobile.css" media="(max-width:939px)"/> -->
	</head>
	<body>
		<c:import url="/WEB-INF/views/header.jsp" />
		<c:import url="/WEB-INF/views/menu.jsp" />
		<a href="adicionarSetor" class="btn btn-primary"> Adicionando setor </a>
		<table class="table">
			<thead class="table-success">
				<tr>
					<th> Código </th>
					<th> Nome do Setor</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${setores}" var="setor">
					<tr id="setor_${setor.codigo}">
						<td>${setor.codigo} </td>
						<td>${setor.nome} </td>
						<!-- <td> <a href="excluirSetor?codigo=${setor.codigo}"> Remover </a> </td> -->
		 			</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<c:import url="/WEB-INF/views/footer.jsp" />
	</body>
</html>