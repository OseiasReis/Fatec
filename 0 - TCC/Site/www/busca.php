<!doctype html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8" />
        <title>i.Library</title>
        <link rel="stylesheet" type="text/css" href="_css/style.css" />
        <link rel="stylesheet" type="text/css" href="_css/theme.css" />
        <link rel="stylesheet" type="text/css" href="_engine/style.css" />
	    <script type="text/javascript" src="_engine/jquery.js"></script>
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
        <script type="text/javascript">
            window.onload = function(){
                $("#bannertopb").fadeOut(0); //Fecha elemento imediatamente
                var alturaParaExibir = 100;	//Determina a altura em que o elemento aparecera
                $(window).scroll(function(){		
                    if($(this).scrollTop() >= alturaParaExibir ){ 				
                        $("#bannertopb").slideDown('slide'); //Faz o elemento aparecer			
                    }else{  
                        $("#bannertopb").slideUp('slide'); //Fez o elemento desaparecer
                    } 
                });
            }
        </script>
        <script>
            $(document).ready(function(){
                $("#containerlogin").fadeOut(0);
                $("#containerlogintotal").fadeOut(0);
                $("#btnlogin").click(function(){
                    $("#containerlogin").slideToggle(250);
                    $("#containerlogintotal").slideToggle(250);
                });
                $("#containerlogintotal").click(function(){
                    $("#containerlogin").slideToggle(250);
                    $("#containerlogintotal").slideToggle(250);
                });
            });
        </script>
    </head>
    <body>
        <header>
            <div id="bannertopb">
                <div id="logob"><img src="_includes/geralogo.php"/></div>
                <div id="buscab">
                    <form action="busca.php" method="GET">
                        <input class="bt-buscab" type="submit" value="" />
                        <input class="buscab" id="consulta" name="consulta" placeholder="O que procura?" />
                    </form>
                </div>
                <div id="menub">
                    <nav class="menub">
                        <ul>
                            <li><a href="index.php">PRINCIPAL</a></li>
                            <li><a href="contato.php">CONTATO</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
            <div id="bannertop">
                <div id="logo"><img src="_includes/geralogo.php"/></div>
                <div id="busca">
                    <form action="busca.php" method="GET">
                        <input class="bt-busca" type="submit" value="" />
                        <input class="busca" id="consulta" name="consulta" placeholder="O que procura?" />
                    </form>
                </div>
            </div>
            <div id="menu">
                <nav class="menu">
                    <ul>
                        <li><a href="index.php">PRINCIPAL</a></li> 
                        <li><a href="buscapersonalizada.php">BUSCA PERSONALIZADA</a></li>
                        <?php
                            // inclui a conexao
                            include "config.php";

                            // Monta uma consulta MySQL para a busca
                            $sql="SELECT * FROM classificacao";

                            // Executa a consulta
                            $result=mysqli_query($con,$sql);

                            // Conta quantos resultados foram encontrados
                            $resultcount=mysqli_num_rows($result);

                            // Exibi resultado
                            echo "<li><a>GÉNEROS</a><ul>";

                            while ($row=mysqli_fetch_array($result,MYSQLI_ASSOC)) {

                                $id = $row["cod_classificacao"];
                                $assunto = $row["assunto"];

                                echo "<li><a href='genero.php?genero={$id}'>{$assunto}</a></li>";

                            };

                            echo "</ul></li>";

                            // Finaliza conexao
                            mysqli_close($con);
                        ?>
                        <li><a href="contato.php">CONTATO</a></li>
                    </ul>
                </nav>
            </div>
        </header>
        <center>
            <div id="bandeja">
                <section class="tx_preto center">
                    <?php
                    
                        // Salva o que foi buscado em uma variável
                        $busca = $_GET["consulta"];
                    
                        // Verifica se foi feita alguma busca
                        // Caso contrario, redireciona o visitante pra home
                        if (!isset($busca)) {
                            
                            header("Location: /");
                            exit;
                            
                        }
                    
                        if (empty($busca)) {
                            
                            echo "Por favor preencher o campo de busca.";
                            
                        } else {
                    
                            // inclui a conexao
                            include "config.php";

                            // Monta uma consulta MySQL para a busca
                            $sql="SELECT * FROM acervo WHERE titulo LIKE '%$busca%'";
                            
                            // Executa a consulta
                            $result=mysqli_query($con,$sql);

                            // Conta quantos resultados foram encontrados
                            $resultcount=mysqli_num_rows($result);

                            if ($resultcount == 0) {

                                // Exibi caso nao tenha encontrado resultados
                                echo "Nenhum resultado encontrado para $busca!";

                            } else {

                                // Exibi resultado
                                echo "<ul class='resultado_busca'>";

                                $cont = 1;

                                while (($row=mysqli_fetch_array($result,MYSQLI_ASSOC)) && ($cont <= 30)) {

                                    $cont += 1;

                                    $id = $row["cod_acervo"];
                                    $titulo = $row["titulo"];
                                    $autor = $row["nome_autor"];
                                    $link = 'sobre.php?id=' . $row['cod_acervo'] . '&titulo=' . $titulo;
									$img = $row["imagem"];

                                    echo "<li>";
                                        echo "<a href='{$link}'>";
                                            if ($img == ""){
												echo "<img src='_img/sem-foto.jpg'/>";
											} else {
												echo "<img src='_includes/gerarimg.php?id=".$id."&titulo=".$titulo."'/>";
											}
                                            echo "<h3>{$titulo}</h3>";
                                            echo "<p>{$autor}</p>";
                                        echo "</a>";
                                    echo "</li>";

                                };

                                echo "</ul>";

                            }

                            // Finaliza conexao
                            mysqli_close($con);
                        }
                    ?>
                </section>
            </div>
        </center>
        <footer>
            <div id="linksfooter">
            
            </div>
            <div id="footer">
                <p class="fleft"><a>Todos os direitos reservados &copy; i.Libary - 2016.</a></p>
                <p class="fright"><a></a></p>
            </div>
        </footer>
    </body>
</html>