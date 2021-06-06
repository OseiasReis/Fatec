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
                    <div id="buscapersonalizada">
                        <form action="buscapersonalizadaresult.php" method="GET">
                            <fieldset class="buscapersonalizada">
                                <legend>Busca Personalizada</legend>
                                <p><label class="tipo" for="tipo">Tipo de Material:</label>
                                    <select name="tipo" class="tipo" id="tipo">
                                        <option value="Livro">Livro</option>
                                        <option value="Midia">CD/DVD</option>
                                        <option value="Mapa">Mapa</option>
                                        <option value="Revista">Revista</option>
                                        <option value="Outros">Outros</option>
                                </optgroup></p>
                                <p><input class="busca" id="consulta" name="consulta" placeholder="O que procura?" /></p>
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
                                    echo "<fieldset id='fildgenero'>";
                                        echo "<legend>Género</legend>";

                                    while ($row=mysqli_fetch_array($result,MYSQLI_ASSOC)) {

                                        $id = $row["cod_classificacao"];
                                        $assunto = $row["assunto"];

                                        echo "<input type='radio' class='genero' name='genero' id='c{$id}' value='{$id}'><label for='c{$id}'>{$assunto}</label>";

                                    };

                                    echo "</fieldset>";

                                    // Finaliza conexao
                                    mysqli_close($con);
                                ?>
                                <input class="bt-buscapersonalizada" type="submit" value="" />
                            </fieldset>
                        </form>
                    </div>
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