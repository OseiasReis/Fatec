<?php 
 
$login = $_POST['login'];
$senha = MD5($_POST['senha']);

// inclui a conexao
include "../../config.php";

// Monta uma consulta MySQL para a busca
$sql="SELECT * FROM usuarios WHERE login = '$login'";
// Executa a consulta
$result= mysqli_query($con,$sql);
$array = mysqli_fetch_array($result,MYSQLI_ASSOC);
$logarray = $array['login'];
 
    if($login == "" || $login == null){
        echo"<script language='javascript' type='text/javascript'>alert('O campo login deve ser preenchido');window.location.href='cad_user.php';</script>";
 
        }else{
            if($logarray == $login){
 
                echo"<script language='javascript' type='text/javascript'>alert('Esse login já existe');window.location.href='cad_user.php';</script>";
                die();
 
            }else{
                $sql = "INSERT INTO usuarios (login,senha) VALUES ('$login','$senha')";
                $insert = mysqli_query($con,$sql);
                 
                if($insert){
                    echo"<script language='javascript' type='text/javascript'>alert('Usuário cadastrado com sucesso!');window.location.href='cad_user.php'</script>";
                }else{
                    echo"<script language='javascript' type='text/javascript'>alert('Não foi possível cadastrar esse usuário');window.location.href='cad_user.php'</script>";
                }
            }
        }
?>