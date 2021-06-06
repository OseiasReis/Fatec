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
    <section id="sliders_painel_cont">
        <h1>Configuração Sliders</h1>
        <nav>
            <ul>
                <?php
                    // inclui a conexao
                    include "../config.php";

                    // Recebe parametro
                    $id = $_GET["id"];

                    // Monta uma consulta MySQL para a busca
                    $sql="SELECT * FROM sliders";

                    // Executa a consulta
                    $result=mysqli_query($con,$sql);

                    // Exibi resultado

                    while ($row=mysqli_fetch_array($result,MYSQLI_ASSOC)) {

                        $id = $row["Cod_Slider"];
                        $mensagem = $row["Mensagem"];

                        echo "<li>";
                            echo "<div class='left'>";
                                echo "<img src='_includes/gerarimg_slider.php?id=".$id."'/>";
                            echo "</div>";
                            echo "<div class='right'>";
                                echo "<p>{$mensagem}</p>";
                                echo "<p><a href='editslider.php?id=".$id."'>Editar</a></p>";
                            echo "</div>";
                        echo "</li>";

                    };
                ?>
            </ul>
        </nav>
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