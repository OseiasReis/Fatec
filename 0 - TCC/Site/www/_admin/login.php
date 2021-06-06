<?php 
    $login = $_POST['user'];
    $senha = md5($_POST['pass']);
    $entrar = $_POST['entrar'];

    // inclui a conexao
    include "../config.php";

        if (isset($entrar)) {
            // Monta uma consulta MySQL para a busca
            $sql="SELECT * FROM usuarios WHERE login = '$login' AND senha = '$senha'";
            // Executa a consulta
            $result = mysqli_query($con,$sql) or die("erro ao selecionar");
                if (mysqli_num_rows($result)<=0){
                    echo"<script language='javascript' type='text/javascript'>alert('Login e/ou senha incorretos');window.location.href='index.php';</script>";
                    die();
                }else{
                    setcookie("login",$login);
                    header("Location:admin.php");
                }
        }
?>