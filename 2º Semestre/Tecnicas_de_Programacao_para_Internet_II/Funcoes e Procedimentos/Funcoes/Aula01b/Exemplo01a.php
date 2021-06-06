<meta charset="UTF-8" />
<?php
	$p = "leite";
	$pr = 4.5;
	echo "<p>O $p custa R$$ " .number_format($pr, 2). "</p>";
	printf("O %s custa R$ %.2f", $p, $pr);
?>