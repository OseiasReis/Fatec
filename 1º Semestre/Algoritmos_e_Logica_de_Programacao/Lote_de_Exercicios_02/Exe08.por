programa
{
	funcao inicio()
	{
		inteiro p[4][3], i, j, s=1, pr=1, v=0

		escreva("DIGITE AS VENDAS\n")
		
		para(i=0; i<=3; i++){
			escreva("\nSemana ", s, "\n")
			pr=1
			para(j=0; j<=2; j++){
				escreva("Produto ", pr, ": ")
				leia (p[i][j])
				pr++
			}
			s++
		}

		pr=1
		escreva("\n\nA quantidade de cada produto vendido no mês:")
		para(j=0; j<=2; j++){
			para(i=0; i<=3; i++){
				v+=p[i][j]
			}
			escreva("\nProduto ", pr, ": ", v)
			pr++
			v=0
		}

		s=1
		escreva("\n\nA quantidade de produtos vendidos por semana:")
		para(i=0; i<=3; i++){
			para(j=0; j<=2; j++){
				v+=p[i][j]
			}
			escreva("\nSemana ", s, ": ", v)
			s++
			v=0
		}
		
		escreva("\n\nO total de produtos vendidos no mês:")
		para(i=0; i<=3; i++){
			para(j=0; j<=2; j++){
				v+=p[i][j]
			}
		} 
		escreva("\nMês: ", v)
	}
}

/*
 * Criar e carregar uma matriz [4][3] inteiro com quantidade de produtos
 * vendidos em 4 semanas. Calcular e exibir:
 * a. A quantidade de cada produto vendido no mês;
 * b. A quantidade de produtos vendidos por semana;
 * c. O total de produtos vendidos no mês.
 * 
 * 
 * p[4][3]
 * | 1| 5| 3| 
 * | 2| 4| 6|
 * | 3| 8| 2|
 * | 4| 6| 4|
 * 
 * i | 0| 1| 2| 3|
 * j | 0| 1| 2|  |
 * s | 1| 2| 3| 4|
 * pr| 1| 2| 3|  |
 * v | 0|10|23|15|...
 */
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1269; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */