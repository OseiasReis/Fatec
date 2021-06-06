<!Doctype html/>
<html>
<head>
<meta charset="utf-8"/>
<title>Area administrativa</title>
<link rel="stylesheet" type="text/css" href="_css/style.css" />
</head>
<body>
    <?php
        $login_cookie = $_COOKIE['login'];
            if(isset($login_cookie)){
                header("Location: admin.php");
            }
    ?>
    <div id="logo_login"><img src="_img/logo_admin.png"/></div>
    <div id="container_login">
        <form action="login.php" method="post">
            <p><label for="user">Nome: </label><input name="user" id="user" type="text" /></p>
            <p><label for="pass">Senha: </label><input name="pass" id="pass" type="password" /></p>
            <p><input type="submit" value="login" id="entrar" name="entrar" /></p>
        </form>
    </div>
    
</body>
</html>