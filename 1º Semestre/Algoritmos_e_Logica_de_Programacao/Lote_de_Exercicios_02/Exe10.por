programa
{
	funcao inicio()
	{
		inteiro p[8][8], i, j
		real res=1.0, soma=0.0
		para(i=0; i<=7; i++){
			para(j=0; j<=7; j++){
				p[i][j]=res
				soma+=res
				res=res*2
				escreva(p[i][j], " | ")
			}
			escreva("\n")
		}
		escreva("\nSoma dos valores: ", soma)
	}
}

/*
 * Criar uma matriz [8][8] onde o programa irá carregar segundo:
 * casa |1|2|3|4|...|*Exibir a soma|
 * valor|1|2|4|8|...| dos valores  |
 * 
 * p[8][8]
 * |1         |2         |4         |8         |16        |32        |64        |128       |
 * |256       |512       |1024      |2048      |4096      |8192      |16384     |32768     |
 * |65536     |131072    |262144    |524288    |1048576   |2097152   |4194304   |8388608   |
 * |16777216  |33554432  |67108864  |134217728 |268435456 |536870912 |1073741824|2147483647|
 * |2147483647|2147483647|2147483647|2147483647|2147483647|2147483647|2147483647|2147483647|
 * |2147483647|2147483647|2147483647|2147483647|2147483647|2147483647|2147483647|2147483647|
 * |2147483647|2147483647|2147483647|2147483647|2147483647|2147483647|2147483647|2147483647|
 * |2147483647|2147483647|2147483647|2147483647|2147483647|2147483647|2147483647|2147483647|
 * 
 * i   |0|1|2|3 |...|7         |
 * j   |0|1|2|3 |...|7         |
 * res |1|2|4|8 |...|2147483647|
 * soma|1|3|7|15|...|1.844E19  |
 */
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1173; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */