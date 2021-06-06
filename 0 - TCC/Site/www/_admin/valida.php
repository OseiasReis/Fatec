<?php
    $login_cookie = $_COOKIE['login'];
        if(isset($login_cookie)){
            echo"Bem-Vindo, $login_cookie";
            
        }else{
            header("Location: ../index.php");
        }
?>