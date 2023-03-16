<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Blog Crud Opertaions JEE</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="<%=request.getContextPath()%>/home"
				class="navbar-brand"> Blog Crud Opertaions JEE </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Blogs</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${blog != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${blog == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${blog != null}">
            			Edit Blog
            		</c:if>
						<c:if test="${blog == null}">
            			Add New Blog
            		</c:if>
					</h2>
				</caption>

				<c:if test="${blog != null}">
					<input type="hidden" name="id" value="<c:out value='${blog.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Blog Titre</label> <input type="text"
						value="<c:out value='${blog.titre}' />" class="form-control"
						name="titre" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Blog SousTitre</label> <input type="text"
						value="<c:out value='${blog.soustitre}' />" class="form-control"
						name="soustitre">
				</fieldset>

				<fieldset class="form-group">
					<label>Blog Contenu </label> <input type="text"
						value="<c:out value='${blog.contenu}' />" class="form-control"
						name="contenu">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>