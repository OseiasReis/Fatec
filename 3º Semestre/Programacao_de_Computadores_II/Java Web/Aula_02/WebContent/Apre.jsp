<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrado</title>
<style>
h1{
font-size: 80px;
text-align: center;
color: red;
}

h2{
font-size: 30px;
text-align: center;
color: green;
}

h3{
margin-top: 60px;
font-size: 20px;
text-align: center;
}

h4{
margin-top: -30px;
font-size: 20px;
text-align: center;
}

color{
	color: red;
}

</style>
</head>
<body>
	<h1>Seja Bem Vindo!</h1>
	<h2>Cadastrado com Sucesso</h2>
	
	<h3><color>Nome:</color> ${param.nome}</h3>
	<br />
	<h4><color>Matricula:</color> ${param.matricula}</h4>
</body>
</html>