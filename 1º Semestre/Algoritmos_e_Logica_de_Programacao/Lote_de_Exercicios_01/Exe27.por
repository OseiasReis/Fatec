programa
{
	funcao inicio()
	{
		real nv, ec, td, vm
		escreva("Número de voltas: ")
		leia(nv)
		escreva("Extenção do circuito (em metros): ")
		leia(ec)
		escreva("Tempo de duração (minutos): ")
		leia(td)
		vm=((nv*ec)/td*60)*3.6
		escreva("Velocidade média " + vm + "km/h.")
		//10, 8, 200 = 86.4
	}
}

/*
 * Receba o número de voltas, a extensão do circuito (em metros) e o tempo de
duração (minutos). Calcule e mostre a velocidade média em km/h.
 */
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 300; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */