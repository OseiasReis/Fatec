programa
{
	funcao inicio()
	{
		real pa, mm, np
		escreva("Pre�o atual: ")
		leia(pa)
		escreva("M�dia mensal: ")
		leia(mm)
		preco(pa, mm)
	}

	funcao preco(real pa, real mm)
	{
		real np
		se(mm < 500){
			se(pa<30){
				np = (pa*10/100) + pa
				escreva("Novo pre�o: " + np)
			}
			senao
				escreva("Novo pre�o: " + pa)
		}
		senao
		se(mm >= 500 e mm < 1000){
			se(pa >= 30 e pa < 80){
				np = (pa*15/100) + pa
				escreva("Novo pre�o: " + np)
			}
			senao
				escreva("Novo pre�o: " + pa)
		}
		senao
		se(mm >= 1000){
			se(pa >= 80){
				np = ((pa*-5)/100) + pa
				escreva("Novo pre�o: " + np)
			}
			senao
				escreva("Novo pre�o: " + pa)
		}
		senao
			escreva("Novo pre�o: " + pa)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta se��o do arquivo guarda informa��es do Portugol Studio.
 * Voc� pode apag�-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 190; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */