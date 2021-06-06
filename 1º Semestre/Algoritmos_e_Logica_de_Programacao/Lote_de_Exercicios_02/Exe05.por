programa
{
	funcao inicio()
	{
		inteiro n[20], i, soma=0

		para(i=0; i<=19; i++){
			escreva ("Num ", i, ": ")
			leia(n[i])
		}
		para(i=0; i<=19; i++){
			soma = n[i] - n[20-i]
			escreva ("\nSoma ", i, ": ", soma, "\n")
		}
	}
}

/*
 * Criar e coletar em um vetor [20] inteiro. Calcule e exiba, segundo: 10 ? (A[1] ? A[21?1]) i = 1
 * 
 * n[20]|  5|  2|  4|...| 30|
 * i    |  1|  2|  3|...| 19|
 * soma |-25|-26|-21|...| 25|
 */
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 141; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */