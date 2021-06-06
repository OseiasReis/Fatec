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
    <section id="edit_slider_cont">
            <h1>Edição de Slider</h1>
            <?php
                
                // inclui a conexao
                include "../config.php";

                // Recebe parametro
                $id = $_GET["id"];

                // Monta uma consulta MySQL para a busca
                $sql="SELECT * FROM sliders WHERE Cod_Slider LIKE '%$id%'";

                // Executa a consulta
                $result=mysqli_query($con,$sql);

                // Exibi resultado
                while ($row=mysqli_fetch_array($result,MYSQLI_ASSOC)) {

                    $id = $row["Cod_Slider"];
                    $mensagem = $row["Mensagem"];

                    echo "<div class='left'>";
                        echo "<form method='POST' action='_includes/editar_slider.php'>";
                            echo "<p><label>Mensagem: </label>".$id."</p>";
                            echo "<p><label>ID Slider: </label><input type='text' name='id_slider' placeholder='".$mensagem."'/></p>";
                            echo "<p><input type='submit' value='Alterar' name='Alterar' class='bt'/></p>";
                        echo "</form>";
                    echo "</div>";
                    echo "<div class='right'>";
                        echo "<img src='_includes/gerarimg_slider.php?id=".$id."'/>";
                    echo "</div>";

                };

            ?>
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