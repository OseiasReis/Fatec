programa
{
	funcao inicio()
	{
		real pa, mm, np
		escreva("Preço atual: ")
		leia(pa)
		escreva("Média mensal: ")
		leia(mm)
		preco(pa, mm)
	}

	funcao preco(real pa, real mm)
	{
		real np
		se(mm < 500){
			se(pa<30){
				np = (pa*10/100) + pa
				escreva("Novo preço: " + np)
			}
			senao
				escreva("Novo preço: " + pa)
		}
		senao
		se(mm >= 500 e mm < 1000){
			se(pa >= 30 e pa < 80){
				np = (pa*15/100) + pa
				escreva("Novo preço: " + np)
			}
			senao
				escreva("Novo preço: " + pa)
		}
		senao
		se(mm >= 1000){
			se(pa >= 80){
				np = ((pa*-5)/100) + pa
				escreva("Novo preço: " + np)
			}
			senao
				escreva("Novo preço: " + pa)
		}
		senao
			escreva("Novo preço: " + pa)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 190; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */