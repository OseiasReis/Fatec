programa
{
	funcao inicio()
	{
		real nv, ec, td, vm
		escreva("N�mero de voltas: ")
		leia(nv)
		escreva("Exten��o do circuito (em metros): ")
		leia(ec)
		escreva("Tempo de dura��o (minutos): ")
		leia(td)
		vm=((nv*ec)/td*60)*3.6
		escreva("Velocidade m�dia " + vm + "km/h.")
		//10, 8, 200 = 86.4
	}
}

/*
 * Receba o n�mero de voltas, a extens�o do circuito (em metros) e o tempo de
dura��o (minutos). Calcule e mostre a velocidade m�dia em km/h.
 */
/* $$$ Portugol Studio $$$ 
 * 
 * Esta se��o do arquivo guarda informa��es do Portugol Studio.
 * Voc� pode apag�-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 300; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */