programa
{
	funcao inicio()
	{
		inteiro i, m=0, qam=0
		real media=0.0, n[30]

		para(i=0; i<=29; i++){
			escreva ("Nota: ")
			leia(n[i])
			media += n[i]
			m++
			se(i == 29){
				media= media/m
				para(i=0; i<=29; i++){
					se(n[i] > media){
						qam++
					}
					
				}
			}
		}
		escreva ("M�dia do grupo: ", media, "\n")
		escreva ("Quantidade acima da m�dia: ", qam, "\n")
		escreva ("Posi��o valores abaixo da m�dia: ")
		para(i=0; i<=29; i++){
			se(n[i] < media){
				escreva(i ," - ")
			}
		}
	}
}

/* Criar e coletar em um vetor [30] real e calcular e exibir:
 * a. A m�dia do grupo;
 * b. A quantidade de notas acima do grupo;
 * c. As posi��es dos valores abaixo da m�dia do grupo.
 *
 * i    |  0|  1|  2|  3|  4|  5|...| 29|
 * m    |  0|  1|  2|  3|  4|  5|...| 29|
 * qam  |  0|  1|  2|  2|  3|...|
 * media|   |   |   |   |   |...|
 * n[30]|5.3|9.1|8.9|6.3|7.5|...|
 */
/* $$$ Portugol Studio $$$ 
 * 
 * Esta se��o do arquivo guarda informa��es do Portugol Studio.
 * Voc� pode apag�-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 790; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */