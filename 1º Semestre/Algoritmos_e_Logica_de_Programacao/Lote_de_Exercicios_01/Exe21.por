programa
{
	funcao inicio()
	{
		real n1, n2, n3, n4, media
		escreva("Nota 1: ")
		leia(n1)
		escreva("Nota 2: ")
		leia(n2)
		escreva("Nota 3: ")
		leia(n3)
		escreva("Nota 4: ")
		leia(n4)
		media= (n1+n2+n3+n4)/4
		se (media >= 6.0){
			escreva("APROVADO Nota: " + media)
		}
		senao
		se (media >= 3.0 e media < 6.0){
			escreva("EXAME Nota: " + media)
		}
		senao{
			escreva("RETIDO Nota: " + media)
		}
	}
}

/*Receba 4 notas bimestrais de um aluno. Calcule e mostre a m�dia aritm�tica. 
 * Mostre a mensagem de acordo com a m�dia:
a. Se a m�dia for >= 6,0 exibir ?APROVADO?;
b. Se a m�dia for >= 3,0 ou < 6,0 exibir ?EXAME?;
c. Se a m�dia for < 3,0 exibir ?RETIDO?.
*/
/* $$$ Portugol Studio $$$ 
 * 
 * Esta se��o do arquivo guarda informa��es do Portugol Studio.
 * Voc� pode apag�-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 674; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */