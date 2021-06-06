programa
{
	funcao inicio()
	{
		real ali, alid=50
		inteiro dias=0
		escreva("Alimentos em quilos: ")
		leia(ali)
		se(ali>=alid){
			enquanto(alid<=ali){
				ali= ali-50
				dias++
			}
			escreva("Durara " + dias + " dias")
		}senao
			escreva("Durara " + dias + " dias")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 10; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */