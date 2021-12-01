<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<div class="container-fluid">
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<!--Primeiro item do menu -->
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Setor</a>
					<ul class="dropdown-menu">
						<li> <a class="dropdown-item" href="nova"> Adicionar setor </a> </li>
						<li> <a class="dropdown-item" href="listarSetor"> Listar setor </a></li>
					</ul>
				</li>
				<!-- menu do usuário -->
				<li>
					<a class="navbar-brand nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown"> <img src="<c:url value='/resources/images/logo.png' />" alt="logo" style="width:40px" class="rounded-pill"> </a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="#"> login </a> </li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>