programa
{
	funcao inicio()
	{
		real n[20], aux
		inteiro i, j

		para(i=0; i<=19; i++){
			escreva("Num ", i, ": ")
			leia(n[i])
		}
		para(i=0; i<=18; i++){
			j=i+1
			se(n[i]>n[j]){
				aux=n[i]
				n[i]=n[j]
				n[j]=aux
				i=-1
			}
		}
		para(i=0; i<=19; i++){
			escreva(n[i],"\n")
		}
	}
}

/*
 * Criar e coletar em um vetor [20] com números aleatórios. 
 * Classificar este vetor em ordem crescente e mostre os dados.
 * 
 * n[20]| 8| 6| 7| 3| 4|...|
 * aux  | 8| 8| 8| 7| 6|...|
 * i    | 2| 3| 4| 6| 7|...|
 * j    | 3| 4| 6| 7| 8|...|
 * 
 * saida
 * n[20]| 2| 3| 4| 6| 7|...|
 */
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 263; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */