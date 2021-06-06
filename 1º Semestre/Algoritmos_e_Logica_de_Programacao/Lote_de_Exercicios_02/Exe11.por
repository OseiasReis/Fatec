programa
{
	funcao inicio()
	{
		inteiro p[8][8], i, j
		
		para(i=0; i<=7; i++){
			para(j=0; j<=7; j++){
				se(i==0 ou j==0 ou i==7 ou j==7){
					p[i][j]=1
					escreva(p[i][j], "|")
				}senao{
					se(i==1 ou j==1 ou i==6 ou j==6){
						p[i][j]=2
						escreva(p[i][j], "|")
					}senao{
						se(i==2 ou j==2 ou i==5 ou j==5){
							p[i][j]=3
							escreva(p[i][j],"|")
						}senao{
							se(i==3 ou j==3 ou i==4 ou j==4){
								p[i][j]=4
								escreva(p[i][j], "|")
							}
						}
					}
				}
			}
			escreva("\n")
		}
	}
}

/*
 * Criar uma matriz [8][8] inteiro e o programa irá carregar segundo:
 * 
 * p[8][8]
 * |1|1|1|1|1|1|1|1|
 * |1|2|2|2|2|2|2|1|
 * |1|2|3|3|3|3|2|1|
 * |1|2|3|4|4|3|2|1|
 * |1|2|3|4|4|3|2|1|
 * |1|2|3|3|3|3|2|1|
 * |1|2|2|2|2|2|2|1|
 * |1|1|1|1|1|1|1|1|
 * 
 * i|0|1|2|3|4|5|6|7|
 * j|0|1|2|3|4|5|6|7|
 */
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 848; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */