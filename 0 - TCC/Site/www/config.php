<?php

    // Conexão com ao MySQL
    $hostdb = "localhost"; // Host do BD
    $userdb = "root"; // Usuario do BD
    $passdb = ""; // Senha do BD
    $database = "ilibrary"; // Banco de dados

    $con = mysqli_connect("$hostdb", "$userdb", "$passdb", "$database");

    // Teste de conexão
    if (mysqli_connect_errno()){
        echo "Falha na conexão com MySQL: " . mysqli_connect_error();
    }
    // Alterar conjunto de caracteres utf8
    mysqli_set_charset($con,"utf8");                                                 
?>