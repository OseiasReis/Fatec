programa
{
	funcao inicio()
	{
		real nv, ec, td
		escreva("N�mero de voltas: ")
		leia(nv)
		escreva("Exten��o do circuito (em metros): ")
		leia(ec)
		escreva("Tempo de dura��o (minutos): ")
		leia(td)
		velmed(nv, ec, td)
	}

	funcao velmed(real nv, real ec, real td)
	{
		real vm
		vm=((nv*ec)/td*60)*3.6
		escreva("Velocidade m�dia " + vm + "km/h.")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta se��o do arquivo guarda informa��es do Portugol Studio.
 * Voc� pode apag�-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 48; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */