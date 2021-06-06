programa
{
	funcao inicio()
	{
		real aa=1.10, am=1.50, ca=0.03, cm=0.02
		inteiro a=0
		enquanto(aa<=am){
			aa=aa+ca
			//escreva(aa, " aa\n")
			am=am+cm
			//escreva(am, " am\n")
			a++
		}
		escreva(a, " anos\n")
	}
}

/*
 * Calcule e mostre quantos anos serão necessários para que Ana seja maior que Maria 
 * sabendo que Ana tem 1,10 m e cresce 3 cm ao ano e Maria tem 1,5 m e cresce 2 cm ao ano.
 * 
 * |aa|1.10|1.13|1.16|...|2.29|2.32|
 * |am|1.50|1.52|1.54|...|2.30|2.32|
 * |ca|0.03|    |    |...|    |    |
 * |cm|0.02|    |    |...|    |    |
 * |a |0   |1   |2   |...|40  |41  |
 */
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 162; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */