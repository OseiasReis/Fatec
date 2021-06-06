programa
{
	funcao inicio()
	{
		inteiro an, aa, mn, ma, dn, da
		escreva("Dia de nascimento: ")
		leia(dn)
		escreva("Mês de nascimento: ")
		leia(mn)
		escreva("Ano de nascimento: ")
		leia(an)
		escreva("Dia atual: ")
		leia(da)
		escreva("Mês atual: ")
		leia(ma)
		escreva("Ano atual: ")
		leia(aa)
		se(dn==31 e mn==02){
				escreva("Fevereiro tem 28 dias (29 em anos bissextos)")
		}senao
		se(dn==30 e mn==02){
				escreva("Fevereiro tem 28 dias (29 em anos bissextos)")
		}senao
		se(da==31 e ma==02){
				escreva("Fevereiro tem 28 dias (29 em anos bissextos)")
		}senao
		se(da==30 e ma==02){
				escreva("Fevereiro tem 28 dias (29 em anos bissextos)")
		}senao{
			verif(an, aa, mn, ma, dn, da)
		}
		
	}

	funcao verif(inteiro an, inteiro aa, inteiro mn, inteiro ma, inteiro dn, inteiro da)
	{
		inteiro ia, im, id, bi, bin=0, bia=0
			se(dn<=31 e mn<=12 e an<=aa){
				se(da<=31 e ma<=12){
					se(an==aa e mn>=ma e dn>=da){
						escreva("Data maior do que a data atual")						
					}
					senao{
						para(bi=0; bi<=an;){
							bin++
							bi=bi+4
						}
						para(bi=0; bi<=aa;){
							bia++
							bi=bi+4
						}
						bi= bia-bin
						ia=aa-an
						se(mn<=ma){
							im=ma-mn
							se(im>12){
								ia++
								im= im-12
							}
							se(dn<=da){
								id=da-dn
								id=id+bi
								enquanto(id>31){
									im++
									id=id-30
								}
								escreva("Ano(s): ", ia,"\nMes(es): ", im, "\nDia(s): ", id)
							}
							senao{
								id=dn-da
								id=id+bi
								enquanto(id>31){
									im++
									id=id-30
								}
								escreva("Ano(s): ", ia,"\nMes(es): ", im, "\nDia(s): ", id)
							}
						}
						senao{
							im=(12-mn)+ma
							ia--
							se(im>12){
								ia++
								im= im-12
							}
							se(dn<=da){
								id=da-dn
								id=id+bi
								enquanto(id>31){
									im++
									id=id-30
								}
								escreva("Ano(s): ", ia,"\nMes(es): ", im, "\nDia(s): ", id)
							}
							senao{
								id=dn-da
								id=id+bi
								enquanto(id>31){
									im++
									id=id-30
								}
								escreva("Ano(s): ", ia,"\nMes(es): ", im, "\nDia(s): ", id)
							}
						}
					}
						
				}
				senao
					escreva("Datas não existentes ou maior do que a data atual")
			}
			senao
				escreva("Datas não existentes ou maior do que a data atual")
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 844; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */