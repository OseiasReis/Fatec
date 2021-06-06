programa
{
	funcao inicio()
	{
		inteiro hi=0, hf=0, hhi, hhf=0, mm=0, m1=0, m2=0 //não compila com variavel vazia
		escreva("Hora de inicio:\nHH:")
		leia(hhi)
		se (hhi < 24){
			escreva("MM:")
			leia(mm)
			se (mm < 60){
				m1= mm
				hi= hhi*60
				hi= hi+mm
				escreva("\nHora de termino:\nHH:")
				leia(hhf)
				se (hhf < 24){
					escreva("MM:")
					leia(mm)
					se (mm < 60){
						m2= mm
						hf= hhf*60
						hf= hf+mm
					}
					senao
						escreva("Tempo maximo é de 59m")
				}senao
					escreva("Tempo maximo é de 24h")
			}senao
				escreva("Tempo maximo é de 59m")
		}senao
			escreva("Tempo maximo é de 24h")
		periodo(hi, hf, hhi, hhf, mm, m1, m2)
	}

	

	funcao periodo(inteiro hi, inteiro hf, inteiro hhi, inteiro hhf, inteiro mm, inteiro m1, inteiro m2){
		inteiro h, m
		se(hi < hf){
			h= (hf-hi)/60
			se (m1 < m2){
				m= m2-m1
				escreva("Horas de jogo: " + h + ":" + m + "h")
			}
			senao{
				m= (60-m1)+m2
				se (m==60){
					m=0
				}
				escreva("Horas de jogo: " + h + ":" + m + "h")
			}
		}
		senao
		se(hi >= hf){
			se(hhi==hhf e m1==m2){
				h= 0
			}
			senao
			se(hhi==hhf e m1>m2){
				h= (24-(hi/60))+(hf/60)-1
			}
			senao{
				h= (24-(hi/60))+(hf/60)
			}
			se (m1 < m2){
				m= m2-m1
				escreva("Horas de jogo: " + h + ":" + m + "h")
			}
			senao{
				m= (60-m1)+m2
				se (m==60){
					m=0
				}
			escreva("Horas de jogo: " + h + ":" + m + "h")
			}
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 679; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */