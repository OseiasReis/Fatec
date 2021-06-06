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
                <section> 
                    <?php
                        // inclui a conexao
                        include "config.php";

                        // Recebe parametro
                        $id = $_GET["id"];
                        $nome = $_GET["titulo"];

                        // Monta uma consulta MySQL para a busca
                        $sql="SELECT * FROM acervo WHERE cod_acervo LIKE '%$id%' AND titulo LIKE '%$nome%'";

                        // Executa a consulta
                        $result=mysqli_query($con,$sql);

                        // Exibi resultado

                        $cont = 1; 

                        while (($row=mysqli_fetch_array($result,MYSQLI_ASSOC)) && ($cont <= 30)) {
                            
                            $cont += 1;

                            $id = $row["cod_acervo"];
                            $titulo = $row["titulo"];
                            $subtitulo = $row["subtitulo"];
                            $autor = $row["nome_autor"];
                            $descricao = $row["resumo"];
                            $midia = $row["tipo_material"];
                            $editora = $row["editora"];
                            $edicao = $row["edicao"];
                            $volume = $row["volume"];
                            $idioma = $row["idioma"];
                            $paginas = $row["num_paginas"];
                            $ano = $row["ano_publicacao"];
                            $localpublicacao = $row["local_publicacao"];
                            $isbn = $row["isbn"];
                            $dimensoes = $row["dimensoes"];
                            $img = $row["imagem"];
                            
                            echo "<div id='sobre'>";
                                echo "<div class='destaque'>";
                                    if ($img == ""){
                                        echo "<img src='_img/sem-foto.jpg'/>";
                                    } else {
                                        echo "<img src='_includes/gerarimg.php?id=".$id."&titulo=".$titulo."'/>";
                                    }
                                    echo "<h1>{$titulo}</h1>";
                                    echo "<h2>{$subtitulo}</h2>";
                                    echo "<h3>{$autor}</h3>";
                                    echo "<p>{$descricao}</p>";
                                echo "</div>";
                            echo "</div>";
                            echo "<div id='sobre'>";
                                echo "<h1>Sobre o {$midia} {$titulo}</h1>";
                                echo "<p><strong>Editora: </strong>{$editora}</p>";
                                echo "<p><strong>Edição: </strong>{$edicao}</p>";
                                echo "<p><strong>Volume: </strong>{$volume}</p>";
                                echo "<p><strong>Autor: </strong>{$autor}</p>";
                                echo "<p><strong>Idioma: </strong>{$idioma}</p>";
                                echo "<p><strong>Numero de paginas: </strong>{$paginas}</p>";
                                echo "<p><strong>Ano de publicação: </strong>{$ano}</p>";
                                echo "<p><strong>Local de publicação: </strong>{$localpublicacao}</p>";
                                echo "<p><strong>I.S.B.N: </strong>{$isbn}</p>";
                                echo "<p><strong>Dimensões: </strong>{$dimensoes}</p>";
                            echo "</div>";

                        };
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