<?php
    // inclui a conexao
    include "../config.php";

    // Recebe parametro
    $id = $_GET["id"];
    $nome = $_GET["titulo"];

    // Monta uma consulta MySQL para a busca
    $sql="SELECT * FROM acervo WHERE cod_acervo LIKE '%$id%' AND titulo LIKE '%$nome%'";

    // Executa a consulta
    $result=mysqli_query($con,$sql);

    // Exibi resultado

    while ($row=mysqli_fetch_array($result,MYSQLI_ASSOC)) {

    $img = $row["imagem"];

        header("Content-type: image/png");
        echo $img;

    };
?>