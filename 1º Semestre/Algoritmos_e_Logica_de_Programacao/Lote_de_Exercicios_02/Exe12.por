programa
{
	funcao inicio()
	{
		inteiro p[8][8], i, j, soma=0
		
		para(i=0; i<=7; i++){
			para(j=0; j<=7; j++){
				se(i==0 ou i==7){
					se(j==0 ou j==7){
						p[i][j]=2
						escreva(p[i][j], "|")
					}senao{
						se(j==1 ou j==6){
							p[i][j]=4
							escreva(p[i][j], "|")
						}senao{
							se(j==2 ou j==5){
								p[i][j]=3
								escreva(p[i][j],"|")
							}senao{
								se(i==0 e j==3 ou i==7 e j==4){
									p[i][j]=6
									escreva(p[i][j], "|")
								}
								se(i==7 e j==3 ou i==0 e j==4){
									p[i][j]=5
									escreva(p[i][j], "|")
								}
							}
						}
					}
				}senao{
					se(i==1 ou i==6 ){
						p[i][j]=1
						escreva(p[i][j], "|")
					}senao{
						se(i==2 ou i==3 ou i==4 ou i==5 ){
							p[i][j]=7
							escreva(p[i][j], "|")
						}
					}
				}
			}
			escreva("\n")
		}
		para(i=0; i<=1; i++){
			para(j=0; j<=7; j++){
				soma+=p[i][j]
			}
		}

		para(i=6; i<=7; i++){
			para(j=0; j<=7; j++){
				soma+=p[i][j]
			}
		}
		escreva("\nSoma: ", soma)
	}
}

/*
 * Carregar códigos das peças em um tabuleiro de xadrez, onde:
 * |Código:|  1  |  2  |  3  |  4   |  5   |  6  |  7  |
 * | Peça: | Peão|Torre|Bispo|Cavalo|Rainha| Rei |Vazio|
 * 
 * Calcular e mostrar a soma das peças do tabuleiro.
 * 
 * p[8][8]
 * |2|4|3|6|5|3|4|2|
 * |1|1|1|1|1|1|1|1|
 * |7|7|7|7|7|7|7|7|
 * |7|7|7|7|7|7|7|7|
 * |7|7|7|7|7|7|7|7|
 * |7|7|7|7|7|7|7|7|
 * |1|1|1|1|1|1|1|1|
 * |2|4|3|6|5|3|4|2|
 * 
 * i   |0|2|2|3 |4 |5 |6 |7 |
 * j   |0|2|2|3 |4 |5 |6 |7 |
 * soma|2|6|9|15|20|23|27|29|...|74|
 */
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 987; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */