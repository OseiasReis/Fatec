<meta charset="UTF-8" />
<?php
	function soma() {
		$p = func_get_args();
		$t = func_num_args();
		$s = 0;
		for($i = 0; $i < $t; $i++) {
			$s += $p[$i];
		}
		return $s;
	}
	$res = soma(3, 4, 7, 14, );
	echo "A soma desses valores é igual a $res.";
?>