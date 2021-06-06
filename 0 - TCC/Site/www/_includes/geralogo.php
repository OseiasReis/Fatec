<?php
    // inclui a conexao
    include "../config.php";

    // Monta uma consulta MySQL para a busca
    $sql="SELECT * FROM config";

    // Executa a consulta
    $result=mysqli_query($con,$sql);

    // Exibi resultado

    while ($row=mysqli_fetch_array($result,MYSQLI_ASSOC)) {

    $logo = $row["logo"];

    header("Content-type: image/png");
    echo $logo;

    };
?>