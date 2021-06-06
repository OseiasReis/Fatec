programa
{
	funcao inicio()
	{
		inteiro p[4][4], i, j, v=1, res, s=1
		
		para(i=0; i<=3; i++){
			para(j=0; j<=3; j++){
				p[i][j]=v
				se(i==j e i!=0){
					res=s*4
					s=res
					p[i][j]=res
					escreva(p[i][j], " | ")
				}senao{
					escreva(p[i][j], " | ")
				}
				v++
			}
			escreva("\n")
		}
	}
}


/*
 * Criar e carregar uma matriz [4][4] com valores aleatórios, sendo que a 
 * diagonal principal terá seus dados carregados no programa segundo:
 * 
 * |1 |  |  |  |
 * |  |4 |  |  |
 * |  |  |16|  |
 * |  |  |  |64|
 * 
 * p[4][4]
 * |1 |2 |3 |4 |
 * |5 |4 |7 |8 |
 * |9 |10|16|12|
 * |13|14|15|64|
 * 
 * i  |0|1 |2 |3 |
 * j  |0|1 |2 |3 |
 * v  |1|2 |3 |4 |...|16|
 * res|4|16|64|  |
 * s  |1|4 |16|64|
 */
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 244; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */