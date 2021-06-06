<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello World</title>
<style>
</style>
</head>
<body>
	<form method='get' action='Dados'>
		<fieldset>
			<legend>Logar-se</legend>
				<p> <label for='cNome'><b>Nome:</b> </label>
				<input type='text' name='tNome' id='cNome' size='45' maxlength='35' placeholder= 'Digite o Nome'/>
				<p> <label for='cMatricula'><b>Matricula:</b> </label>
				<input type='number' name='tMatricula' id='cMatricula' size='45' maxlength='35' placeholder= 'Digite a Matricula'/>
			<br /><br /><input type='submit' name='tEnviar' value='Enviar'/>
		</fieldset>
	</form>
	
	${param.Nome}
	<br />
	${param.Matricula}
	
</body>
</html>