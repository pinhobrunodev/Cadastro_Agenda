

<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="model.JavaBeans"%>


<%
ArrayList<JavaBeans> listar = (ArrayList<JavaBeans>) request.getAttribute("registros");
%>




<!DOCTYPE html>
<html lang="PT-BR">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="styleRegistros.css">
<title>Agenda</title>
</head>
<body>



	<div id="container">
		<div id="header">
			<h1>Agenda de contatos</h1>
			<button>
				<a href="novo.html" class="botao1"> Novo contato</a>
			</button>
		</div>
		<table>

			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>E-Mail</th>
					<th>Fone</th>
					<th>Opções</th>
				</tr>

			</thead>
			
			

			<tbody>

					<% for(int i = 0;i<listar.size();i++){ %>
                        <tr>
                            <td><%=listar.get(i).getID()%></td>
                            <td><%=listar.get(i).getNome()%></td>
                            <td><%=listar.get(i).getEmail()%></td>
                            <td><%=listar.get(i).getFone()%></td>
                            <td><button id="excluir"><a href="delete?id=<%=listar.get(i).getID()%>" >Excluir</a></button>
                           <button id="edit"><a href="select?id=<%=listar.get(i).getID()%>" >Editar</a></button></td>
                            
                       
                  
                            </tr>
                            <%} %> 

			
			
			
			</tbody>


		</table>


	</div>
</body>
</html>
