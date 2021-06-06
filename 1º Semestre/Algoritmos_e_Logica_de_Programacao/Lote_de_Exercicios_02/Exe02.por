programa
{
	funcao inicio()
	{
		inteiro n[100], i, m=0, ma=0, me=9999
		real media=0.0

		para(i=0; i<=99; i++){
			escreva ("Digite um numero: ")
			leia(n[i])
			media += n[i]
			m++
			se(n[i] > ma){
				ma=n[i]
			}
			se(n[i] < me){
				me=n[i]
			}
		}
		media= media/m
		escreva ("Maior: ", ma, "\n")
		escreva ("Menor: ", me, "\n")
		escreva ("Média: ", media, "\n")
	}
}

/*
 * Criar e coletar um vetor [100] inteiro e exibir:
 * a. O maior e o menor valor;
 * b. A média dos valores.
 * 
 * n[100]|    | 9| 5| 8| 6| 2|...|
 * i     |    | 0| 1| 2| 3| 4|...|
 * m     |   0| 1| 2| 3| 4| 5|...|
 * ma    |   0| 9|  |  |  |  |...|
 * me    |9999| 9| 5|  |  | 2|...|
 * media |   0| 9|14|22|28|30|...|
 */
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 220; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */