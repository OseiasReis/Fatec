programa
{
	funcao inicio()
	{
		inteiro sb[5]={0,5000,5000,5000,5000}, c[6]={100,100,100,100,100,100}
		inteiro mab[5][1]={{0},{0},{0},{0},{0}}, meb[5][1]={{9999},{9999},{9999},{9999},{9999}}
		inteiro med[5][2]={{0,0},{0,0},{0,0},{0,0},{0,0}}, tot[5][1]={{0},{0},{0},{0},{0}}
		menup(sb, mab, meb, med, tot, c)
	}

	funcao menup(inteiro sb[], inteiro mab[][], inteiro meb[][], inteiro med[][], inteiro tot[][], inteiro c[]){
		inteiro menu
		logico ca, es
		escreva("MENU PRINCIPAL\n1 - Carregar Cédulas\n2 - Retirar Cédulas\n3 - Estatística\n9 - Fim\n")
		escreva("\nDigite a opção de escolha: ")
		leia (menu)
		escolha (menu){
			caso 1: 	limpa()
					ca=verdadeiro
					es=falso
					banco(ca, sb, es, mab, meb, med, tot, c)
			pare
			caso 2: 	limpa()
					ca=falso
					es=falso
					banco(ca, sb, es, mab, meb, med, tot, c)
			pare
			caso 3: 	limpa()
					ca=falso
					es=verdadeiro
					banco(ca, sb, es, mab, meb, med, tot, c)
			pare
			caso 9: 	limpa()
				   	escreva("---------FIM----------")
			pare
			caso contrario: limpa()
						escreva("Número invalido\n")
						menup(sb, mab, meb, med, tot, c)
		}
	}

	funcao retirada(inteiro b, inteiro sb[], logico es, inteiro mab[][], inteiro meb[][], inteiro med[][], inteiro tot[][], inteiro c[]){
		inteiro ret=0, valor, ced=0, i=5, f, qt, j=0, k=b
		inteiro v[6]={2,5,10,20,50,100}
		logico ca, co=verdadeiro
		se(es==falso){
		escreva("RETIRADA\nFaça a retirada de valores obedecendo ao critério do maior pelo menor.\n")
		escreva("\n1 - Retirar Cédulas Automaticamente\n2 - Retirar Cédulas Manualmente\n3 - Outro banco\n4 - Voltar\n")
		escreva("\nDigite a opção de escolha: ")
		leia (ret)
		escolha (ret){
/*Automaticamente*/caso 1: limpa()
					escreva("Digite o valor a ser retirado:\n")
					leia (valor)
					limpa()
					se(valor>1){
					//Conta Estatisticas Down
					se(valor >= v[i]){
						se(valor>mab[k][0]){
							mab[k][0]=valor
						}
						se(valor<meb[k][0]){
							meb[k][0]=valor
						}
						med[k][0]+=valor
						med[k][1]+=1
	
						tot[k][0]+=valor
					}
					//Conta Estatisticas Up
					
					enquanto(i >= 0){
						se(sb[b]-valor >= 0){
							se(valor >= v[i]){
								se(c[i]==0){
									escreva("Não possui mais cédulas de ", v[i],"\n")
									i--
								}senao{
									escreva(valor, ": Cédula de ", v[i], "\n")
									valor -= v[i]
									sb[b] -= v[i]
									c[i] -= 1
									ced++
								}
							}senao{
								i--
							}
						}senao{
							escreva("Não possui mais notas ou excede o limite do caixa")
							escreva("\nSaldo: ", sb[b])
							i=-1
						}
					}
					}senao{
						escreva("Digite um valor maior")
					}
					escreva ("\n",ced, " cédulas\n")

					escreva("\nDeseja voltar?\n0-Menu - 1-Retirada\n")
					leia (f)
					escolha(f){
						caso 0:	limpa()
								menup(sb, mab, meb, med, tot, c)
						pare
						caso 1:	limpa()
								retirada(b, sb, es, mab, meb, med, tot, c)
						pare
						caso contrario:limpa()
									escreva("Opção invalido\n")
									retirada(b, sb, es, mab, meb, med, tot, c)
					}
					
/*Manualmente*/pare
			caso 2: 	limpa()
					escreva("Digite o valor a ser retirado:\n")
					leia (valor)
					limpa()
					se(valor>1){
					//Conta Estatisticas Down
					se(valor >= v[i]){
						se(valor>mab[k][0]){
							mab[k][0]=valor
						}
						se(valor<meb[k][0]){
							meb[k][0]=valor
						}
						med[k][0]+=valor
						med[k][1]+=1
	
						tot[k][0]+=valor
					}
					//Conta Estatisticas Up
					
					enquanto(i >= 0){
						se(sb[b]-valor >= 0){
							se(valor >= v[i] e co==verdadeiro){
								escreva("Quantas cédulas de ", v[i]," a ser retirada?\n")
								leia (qt)
								se(sb[b]-valor >= 0 e qt*v[i] <= valor){
									se(c[i]==0){
										escreva("Não possui mais cédulas de ", v[i],"\n")
										i--
									}senao{
										escreva(valor, ": Cédula de ", v[i], "\n")
										valor -= v[i]
										sb[b] -= v[i]
										c[i] -= 1
										ced++
									}
								}senao{
									escreva("Não é possivel retirar essa quantidade")
									co=falso
								}
							}senao{
								i--
							}
						}senao{
							escreva("Não possui mais cédulas ou excede o limite")
							escreva("\nSaldo: ", sb[b])
							i=-1
						}
					}
					}senao{
						escreva("Digite um valor maior")
					}
					escreva ("\n",ced, " cédulas\n")

					escreva("\nDeseja voltar?\n0-Menu - 1-Retirada\n")
					leia (f)
					escolha(f){
						caso 0:	limpa()
								menup(sb, mab, meb, med, tot, c)
						pare
						caso 1:	limpa()
								retirada(b, sb, es, mab, meb, med, tot, c)
						pare
						caso contrario:limpa()
									escreva("Opção invalido\n")
									retirada(b, sb, es, mab, meb, med, tot, c)
					}
			pare
			caso 3: 	limpa()
					ca=falso
					es=falso
					banco(ca, sb, es, mab, meb, med, tot, c)
			pare
			caso 4: 	limpa()
					ca=falso
					banco(ca, sb, es, mab, meb, med, tot, c)
			pare
			caso contrario: limpa()
						escreva("Opção invalida\n")
						retirada(b, sb, es, mab, meb, med, tot, c)
		}
		}senao{
			
//Inicio ESTATISTICAS -----------------------------------------------------------------------------------
			se(mab[k][0]==0 e meb[k][0] == 9999){
				escreva("Sem valores\n\n")
			}senao{
				cadeia nb1="Banco do Brasil", nb2="Santander", nb3="Itaú", nb4="Caixa" 
				se(b==1){
					escreva(nb1, "\n")
				}
				se(b==2){
					escreva(nb2, "\n")
				}
				se(b==3){
					escreva(nb3, "\n")
				}
				se(b==4){
					escreva(nb4, "\n")
				}
				escreva("Maior valor sacado: " + mab[b][0] + "\n")
				escreva("Menor valor sacado: " + meb[b][0] + "\n")
				se(med[4][0]==0){
					med[4][0]=1
				}
				med[b][0]=med[b][0]/med[k][1]
				escreva("Media dos saques: " + med[b][0] + "\n")
				escreva("Total dos saques: " + tot[b][0] + "\n")
				escreva("Sobra dos caixas: " + sb[b] + "\n")
			}
			
			
			
			escreva("\nDeseja voltar?\n0-Menu  1-Banco (Estatisticas)\n")
			leia (f)
			escolha(f){
				caso 0:	limpa()
						es=falso
						menup(sb, mab, meb, med, tot, c)
				pare
				caso 1:	limpa()
						ca=falso
						es=verdadeiro
						banco(ca, sb, es, mab, meb, med, tot, c)
				pare
				caso contrario: limpa()
							escreva("Opção invalido\n")
							carregar(b, sb, mab, meb, med, tot, c)
			}
		}
//Fim ESTATISTICAS -----------------------------------------------------------------------------------
	}

	funcao banco(logico ca, inteiro sb[], logico es, inteiro mab[][], inteiro meb[][], inteiro med[][], inteiro tot[][], inteiro c[]){
		inteiro ban, b=0
		se(ca==verdadeiro){
			carregar(b, sb, mab, meb, med, tot, c)
		}senao{
		escreva("BANCO\n1 - Banco do Brasil\n2 - Santander\n3 - Itaú\n4 - Caixa\n\n\n5 - Voltar")
		escreva("\nDigite a opção de escolha: ")
		leia (ban)
		escolha (ban){
			caso 1:	b=1
					limpa()
					se(es == verdadeiro){
						retirada(b, sb, es, mab, meb, med, tot, c)
					}senao{
						retirada(b, sb, es, mab, meb, med, tot, c)
					}
					
			pare
			caso 2: 	b=2
					limpa()
					se(es == verdadeiro){
						retirada(b, sb, es, mab, meb, med, tot, c)
					}senao{
						retirada(b, sb, es, mab, meb, med, tot, c)
					}
			pare
			caso 3: 	b=3
					limpa()
					se(es == verdadeiro){
						retirada(b, sb, es, mab, meb, med, tot, c)
					}senao{
						retirada(b, sb, es, mab, meb, med, tot, c)
					}
			pare
			caso 4: 	b=4
					limpa()
					se(es == verdadeiro){
						retirada(b, sb, es, mab, meb, med, tot, c)
					}senao{
						retirada(b, sb, es, mab, meb, med, tot, c)
					}
			pare
			caso 5: 	limpa()
					menup(sb, mab, meb, med, tot, c)
			pare
			caso contrario: limpa()
						escreva("Banco invalido\n")
						banco(ca, sb, es, mab, meb, med, tot, c)
		}
		}
	}

	funcao carregar(inteiro b, inteiro sb[], inteiro mab[][], inteiro meb[][], inteiro med[][], inteiro tot[][], inteiro c[]){
		inteiro f, i, j=1
		logico ca, es
		
		escreva("Cédulas de 100: ", c[5], "\n")
		escreva("Cédulas de 50: ", c[4], "\n")
		escreva("Cédulas de 20: ", c[3], "\n")
		escreva("Cédulas de 10: ", c[2], "\n")
		escreva("Cédulas de 5: ", c[1], "\n")
		escreva("Cédulas de 2: ", c[0], "\n")

		escreva("\nDeseja voltar?\n0-Menu\n")
		leia (f)
		escolha(f){
			caso 0:	limpa()
					menup(sb, mab, meb, med, tot, c)
			pare
			caso contrario: limpa()
						escreva("Opção invalido\n")
						carregar(b, sb, mab, meb, med, tot, c)
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 8113; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */