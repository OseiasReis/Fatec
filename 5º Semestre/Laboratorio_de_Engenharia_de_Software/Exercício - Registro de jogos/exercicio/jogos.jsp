<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Jogos, java.util.List, java.util.ArrayList"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Gestão de Jogos</title>
	<link rel="stylesheet" href="./css/bootstrap.min.css"/>
	<script src="./js/bootstrap.min.js"></script>
</head>
<body>
	<h2>Gestão de Jogos</h2>
	
	<%  
	String msg = (String)session.getAttribute("MENSAGEM");
	String alert = null;
	List<Jogos> lista = (List<Jogos>)session.getAttribute("LISTA");
	if (lista == null) { 
		lista = new ArrayList<Jogos>();
	} else { 
		session.setAttribute("LISTA", null);
	}
	
	if (msg != null) {
		session.setAttribute("MENSAGEM", null);
	%>
			<h3 class="alert alert-success"><%=msg%></h3>
	<%
	}
	%>
	
	
	<form action="./JogosController" method="post">
		<div class="container">
			<div class="form-group">
    			<label for="txtId">Id</label>
    			<input type="text" class="form-control" id="txtId" name="txtId" readonly/>
  			</div>
			<div class="form-group">
    			<label for="txtSabor">Nome</label>
    			<input type="text" class="form-control" id="txtNome" name="txtNome"/>
  			</div>  	
			<div class="form-group">
    			<label for="txtTipo">Dificuldade</label>
    			<select class="form-control" id="txtDif" name="txtDif">
      				<option value="facil">Fácil</option>
      				<option value="medio">Médio</option>
      				<option value="dificil">Difícil</option>
				    <option value="lendario">Lendário</option>
				</select>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary" name="cmd" value="adicionar">Adicionar</button>
				<button type="submit" class="btn btn-primary" name="cmd" value="pesquisar">Pesquisar</button>
			</div>																		
		</div>
		<div class="container">
			<table class="table table-striped">
				<tbody>
					<% for (Jogos jogos : lista) { %>
					<tr>
						<td><%=jogos.getId()%></td>
						<td><%=jogos.getNome()%></td>
						<td><%=jogos.getDif()%></td>
					</tr>
					<% } %>
				</tbody>
			</table>
		</div>
	</form>
</body>
</html>