<?php
    // Deleta o cookie em uso. 
    setcookie("login","");

    header("Location: ../index.php");
?>