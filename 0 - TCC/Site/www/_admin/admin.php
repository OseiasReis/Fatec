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
                        <li><a href="sliders.php">SLIDERS</a></li>
                    </ul>
                </nav>
            </div>
        </header>
</header>
<!--/header -->
<!-- center -->
<center>
    <section>
        <div id="painel_cont">
            <div class="icon">
                <a href="cad_user.php">
                    <img src="_img/_icons/icon_adduser.jpg"/>
                    <h3>Adicionar Usuario</h3>
                </a>
            </div>
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