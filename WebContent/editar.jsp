<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf">
<link rel="stylesheet" href="styleEditar.css">
<title>Editar contato</title>
</head>
<body>
	<div id="container">
		<div class="corpo">
			<form action="update" method="POST" name="registrarContato">
				<img id="imgWidth" src="images/editar.png" alt="agenda">
				<h1>Editar</h1>
				<h2>ID</h2>
				<!-- Bloqueando a caixa -->                               <!-- Atributo que ta recebendo da classe Controller -->
				<input type="text" required name="id" readonly="readonly" value="<%out.print(request.getAttribute("id"));%>"> <br>
				<h2>Novo nome</h2>
				<input type="text" required name="nome"value="<%out.print(request.getAttribute("nome"));%>"> <br>
				<h2>Novo E-mail</h2>
				<input type="email" required name="email"value="<%out.print(request.getAttribute("email"));%>"> <br>
				<h2>Novo Telefone</h2>
				<input type="number" required name="fone"value="<%out.print(request.getAttribute("fone"));%>"> <br> <input
					id="botao" type="submit" value="Salvar" onclick="validar()">
			</form>

			<script src="scripts/validador.js"></script>


		</div>
	</div>
</body>
</html>