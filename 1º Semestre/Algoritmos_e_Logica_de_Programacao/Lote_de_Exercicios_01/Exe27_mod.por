programa
{
	funcao inicio()
	{
		real nv, ec, td
		escreva("Número de voltas: ")
		leia(nv)
		escreva("Extenção do circuito (em metros): ")
		leia(ec)
		escreva("Tempo de duração (minutos): ")
		leia(td)
		velmed(nv, ec, td)
	}

	funcao velmed(real nv, real ec, real td)
	{
		real vm
		vm=((nv*ec)/td*60)*3.6
		escreva("Velocidade média " + vm + "km/h.")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 48; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */