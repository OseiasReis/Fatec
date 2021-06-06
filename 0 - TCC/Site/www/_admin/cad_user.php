<!Doctype html />
<html>
<head>
<meta charset="utf-8"/>
<title>Cadastro de usuario</title>
<link rel="stylesheet" type="text/css" href="_css/style.css" />
</head>
<body>

<!-- header -->
<header>
    <div id="bannerlogin">
        <div id="msgboasvindas">
            <?php
                $login_cookie = $_COOKIE['login'];
                if(isset($login_cookie)){
                    echo"<p>Bem-Vindo, $login_cookie</p>";

                }else{
                    header("Location: ../index.php");
                }
            ?>
        </div>
        <div id="login">
            <nav class="login">
                <ul>
                    <li><a href="logout.php" >Logout</a></li>
                </ul>
            </nav>
        </div>
    </div>
    <div id="menu">
                <nav class="menu">
                    <ul>
                        <li><a href="admin.php">PRINCIPAL</a></li>
                        <li><a href="cad_user.php">CADASTRO USER</a></li>
                    </ul>
                </nav>
            </div>
        </header>
</header>
<!--/header -->
<!-- center -->
<center>
    <section id="cad_user_cont">
        <div class="left">
            <h1>Cadastro de usuario</h1>
            <form method="POST" action="_includes/cadastrar_usuario.php">
                <p><label>Login: </label><input type="text" name="login"></p>
                <p><label>Senha: </label><input type="password" name="senha"></p>
                <p><input type="submit" value="Cadastrar" name="cadastrar" class="bt"></p>
            </form>
        </div>
        <div class="right">
            
        </div>
    </section>
</center>    
<!--/center -->
<!-- footer -->
<footer>
    <p>Todos os direitos reservados - Ilibrary &copy; 2016.</p>
</footer>    
<!--/footer -->
    
</body>
</html>