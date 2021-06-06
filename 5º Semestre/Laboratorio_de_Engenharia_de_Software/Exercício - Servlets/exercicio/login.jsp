<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login</title>
	<link rel="stylesheet" href="./css/bootstrap.min.css"/>
	<script src="./js/bootstrap.min.js"></script>
</head>
<body>
	<h2>Login</h2>
	
	<%  
	String msg = (String)session.getAttribute("MENSAGEM");
		
	if (msg != null) {
		session.setAttribute("MENSAGEM", null);
	%>
			<h3 class="alert alert-success"><%=msg%></h3>
	<%
	}
	%>
	
	<form action="./CheckLogin" method="post">
		<div class="container">
			<div class="form-group">
    			<label for="txtId">Login</label>
    			<input type="text" class="form-control" id="txtLogin" name="txtLogin"/>
  			</div>
			<div class="form-group">
    			<label for="txtSabor">Senha</label>
    			<input type="password" class="form-control" id="txtSenha" name="txtSenha"/>
  			</div>  	
			
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Entrar</button>
			</div>																		
		</div>
	</form>
</body>
</html>