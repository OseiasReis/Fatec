programa
{
	funcao inicio()
	{
		real n[20], aux
		inteiro i, j, in, me, fim, num, nin, nfim
		logico enc=falso

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
			escreva(n[i]," - ")
		}
		
		escreva("\n\nNumero a ser encontrado: ")
		leia (num)
		
		nin=n[0]
		in=0
		nfim=n[19]
		fim=19
		me=(in+fim)/2
		escreva("\nInicio: ", in, " --- Valor: ", nin, "\nMeio:   ", me," --- Valor: ", n[me],"\nFim:    ", fim, " --- Valor: ", nfim, "\nEncontrado: " , enc, "\n\n")
		
		enquanto(enc==falso){
			se(n[me]==num ou nin==num ou nfim==num){
				enc=verdadeiro
				escreva("Numero encontrado: ", num, "\nEncontrado: " , enc, "\n")
			}senao{
				se(num>n[me]){
					in=me+1
					nin=n[me+1]
					me=(in+fim)/2
					escreva("Inicio: ", in, " --- Valor: ", nin, "\nMeio:   ", me," --- Valor: ", n[me],"\nFim:    ", fim, " --- Valor: ", nfim, "\nEncontrado: " , enc, "\n\n")
				}senao{
					fim=me-1
					nfim=n[me-1]
					me=(in+fim)/2
					escreva("Inicio: ", in, " --- Valor: ", nin, "\nMeio:   ", me," --- Valor: ", n[me],"\nFim:    ", fim, " --- Valor: ", nfim, "\nEncontrado: " , enc, "\n\n")
				}
			}
		}
	}
}

/* 
 * A partir do exercício 6 (vetor classificado) solicitar um valor qualquer 
 * e verificar a sua existência no vetor (utilizar pesquisa binária).
 * 
 * n[20]| 8| 6| 7| 3| 4|...|
 * aux  | 8| 8| 8| 7| 6|...|
 * i    | 2| 3| 4| 6| 7|...|
 * i    | 1| 2| 3| 4| 5|...|
 * j    | 3| 4| 6| 7| 8|...|
 * in   | 0|10|  |  |  |
 * nin  | 1| 5|  |  |  |
 * me   | 9|14|  |  |  |
 * fim  |19|19|  |  |  |
 * nfim | 9| 9|  |  |  |
 * num  | 7|  |  |  |  |
 * enc  |false|...|verdadeiro|
 */
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1722; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */