programa
{
	funcao inicio()
	{
		inteiro vt1[3], vt2[3], vt3[6], i, j=0

		para(i=0; i<=2; i++){
			escreva ("Digite um numero VT1: ")
			leia(vt1[i])
		}
		para(i=0; i<=2; i++){
			escreva ("Digite um numero VT2: ")
			leia(vt2[i])
		}
		para(i=0; i<=2; i++){
			vt3[i] = vt1[i]
		}
		para(i=3; i<=5; i++){
			vt3[i] = vt2[j]
			j++
		}
		escreva ("VT1: ")
		para(i=0; i<=2; i++){
			escreva (vt1[i], " | ")
		}
		escreva ("\nVT2: ")
		para(i=0; i<=2; i++){
			escreva (vt2[i], " | ")
		}
		escreva ("\nVT3: ")
		para(i=0; i<=5; i++){
			escreva (vt3[i], " | ")
		}
	}
}

/*
 * Criar e coletar valores inteiros nos vetores VT1[3] e VT2[3]. 
 * Concatenar esses valores em um 3º vetor (VT3[6]) e mostrar os seus dados. P. ex: 
 * VT1| 1| 2| 3| |VT2| 4| 5| 6| |VT3| 1| 2| 3| 4| 5| 6
 * 
 * vt1[3]| 1| 2| 3|  |  |  |
 * vt2[3]| 4| 5| 6|  |  |  |
 * vt3[6]| 1| 2| 3| 4| 5| 6|
 * i     | 0| 1| 2| 0| 1| 2|...|
 * j     | 0| 1| 2|  |  |  |
 */
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 934; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */