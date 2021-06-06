programa
{
	funcao inicio()
	{
		inteiro hi, hf, hhi, hhf, mm, h, m, m1, m2
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
					senao
						escreva("Tempo maximo é de 59m")
				}
				senao
					escreva("Tempo maximo é de 24h")
			}
			senao
				escreva("Tempo maximo é de 59m")
		}
		senao
			escreva("Tempo maximo é de 24h")
	}
}

/*Receba a hora de início e de final de um jogo (HH,MM) sabendo que o
tempo máximo é de 24 horas e pode começar num dia e terminar noutro.
*/
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 648; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */