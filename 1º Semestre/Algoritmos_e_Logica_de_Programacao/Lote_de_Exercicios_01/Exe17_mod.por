programa
{
	funcao inicio()
	{
		real tp, vm
		escreva("Tempo percorrido em horas: ")
		leia(tp)
		escreva("Velocidade media: ")
		leia(vm)
		litros(tp, vm)
	}

	funcao litros(real tp, real vm){
		real dis, lg
		dis= tp*vm
		lg= dis/12
		escreva("Quantidade de litros gastos: " + lg + " litros")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta se��o do arquivo guarda informa��es do Portugol Studio.
 * Voc� pode apag�-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 44; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */