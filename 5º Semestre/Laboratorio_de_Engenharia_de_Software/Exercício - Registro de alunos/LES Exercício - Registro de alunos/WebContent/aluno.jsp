<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Aluno</title>
</head>
<body>
	<h3>Cadastro de Aluno</h3>
	
	
	
	<br>
	<form action="./AlunoController" method="post">
		
		ID:
		<input type="text" name="id"/>
		<br>
		RA:
		<input type="text" name="ra"/>
		<br>
		Nome:
		<input type="text" name="nome"/>
		<br>
		Idade:
		<input type="text" name="idade"/>
		<br>
		Sexo:
		<select>
			<option disabled value="">Selecione o sexo</option>
			<option value="M">M</option>
			<option value="F">F</option>
		</select>
		<br>
		<br>
		<input type="submit" name="cmd" value="Adicionar"/>
		<input type="submit" name="cmd" value="Remover"/>
		<input type="submit" name="cmd" value="Atualizar"/>
		<input type="submit" name="cmd" value="Pesquisar"/>
	
	</form>
</body>
</html>