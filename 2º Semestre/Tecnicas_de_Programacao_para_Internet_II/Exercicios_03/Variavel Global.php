<?php

function soma($a)
{
global $b;
$b = $a + 5;
}
soma(10);
echo "O valor de B é $b";

?>