<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Formulário de login</title>
		<link rel="stylesheet" href="resources/css/bootstrap.min.css">
		<link rel="stylesheet" href="resources/css/style.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<script src="resources/js/bootstrap.bundle.min.js"> </script>
	</head>
	<body>
		<c:import url="/WEB-INF/views/header.jsp" />
		<h4> Página de Login </h4>
		<form action="efetuaLogin" method="post">
		<div class="mb-3 mt-3">
			<label for="login" class="form-label"> Login: </label>
			<input type="text" class="form-control" id="login" placeholder="Digite seu nome de usuário" name="login" />
			<br />
			<!-- Erros de preenchimento -->
			<!--<form:errors path="usuario.login" /> -->
		</div>
		<div class="mb-3">
			<label for="senha" class="form-label"> Senha: </label>
			<input type="password" class="form-control" id="senha" placeholder="Digite sua senha" name="senha" />
			<br />
			<!-- Erros de preenchimento -->
			<!--<form:errors path="usuario.senha" /> -->
		</div>
			<button type="submit" class="btn btn-primary"> Entrar </button>
		</form>
		<c:import url="/WEB-INF/views/footer.jsp" />
 	</body>
</html>