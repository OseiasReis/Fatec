<?php
    // inclui a conexao
    include "config.php";

    // Monta uma consulta MySQL para a busca
    $sql="SELECT * FROM config";

    // Executa a consulta
    $result=mysqli_query($con,$sql);

    while ($row=mysqli_fetch_array($result,MYSQLI_ASSOC)) {

    //$row=mysqli_fetch_array($result,MYSQLI_ASSOC)

    $nomesite = $row["nome"];
    $endereco = $row["endereco"];
    $email = $row["email"];

    $para = $email;
    $assunto = 'Contato '. $nomesite;
    $Nome = $_POST['Nome'];
    $Mail = $_POST['Mail']; 
    $Tele = $_POST['Tele'];
    $Celu = $_POST['Celu'];
    $Msgm = $_POST['Msgm']; 
    
    $mensagem = "<strong>Nome: </strong>".$Nome;
    $mensagem .= "<br/><strong>E-Mail: </strong>".$Mail;
    $mensagem .= "<br/><strong>Telefone: </strong>".$Tele;
    $mensagem .= "<br/><strong>Celular: </strong>".$Celu;
    $mensagem .= "<br/><strong>Mensagem: </strong>".$Msgm; 

    $headers =  "Content-Type:text/html; charset=UTF-8\n";
    $headers .= "From:  {$endereco}\n"; //Vai ser mostrado que  o email partiu deste email e seguido do nome
    $headers .= "X-Sender:  <{$email}>\n"; //email do servidor //que enviou
    $headers .= "X-Mailer: PHP  v".phpversion()."\n";
    $headers .= "X-IP:  ".$_SERVER['REMOTE_ADDR']."\n";
    $headers .= "MIME-Version: 1.0\n";

    mail($para, $assunto, $mensagem, $headers);  //função que faz o envio do email.
        
    };
    
    // Finaliza conexao
    mysqli_close($con);

?>
<?php
   $redirect = "index.php";
   header("location:$redirect");
?>