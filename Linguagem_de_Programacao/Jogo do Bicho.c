#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) 
{
	setlocale(LC_ALL,"portuguese");
	int mam, qua, car, her, aqua, gran, escolha;
	do {
	printf("Escolha um animal da lista:\n\n");
	printf(" ----------------------------------------------\n");
	printf("| Leão  | Cavalo | Crocodilo | Morcego | Homem |\n");
	printf("|----------------------------------------------|\n");
	printf("| Águia |  Cobra | Avestruz  | Pinguim |       |\n");
	printf("|----------------------------------------------|\n");
	printf("| Pato  | Baleia | Tartaruga | Macaco  |       |\n");
	printf(" ----------------------------------------------\n\n\n");
	printf("Depois de escolher, responda as seguintes questões com '1' para Sim ou '2' para Não, de acordo com a sua escolha e de acordo com a maior quantidade do mesmo:\n\n");
	printf("1) É Mamífero?\nR:");
	scanf ("%d",&mam);	
	printf("2) É Quadrúpede?\nR:");
	scanf ("%d",&qua);
	printf("3) É Carnívoro?\nR:");
	scanf ("%d",&car);
		if (mam==1&&qua==1&&car==1)
		printf("O animal escolhido é o Leão!\a\a\n\n");
		else {
			if (mam==1&&qua==1&&car==2)
			printf("O animal escolhido é o Cavalo!\a\a\n\n");
			else {
				if (mam==2&&qua==1&&car==1)
				printf("O animal escolhido é o Crocodilo!\a\a\n\n");
				else {
					if (mam==2&&qua==1&&car==2)
					printf("O animal escolhido é a Tartaruga!\a\a\n\n");	
					else {
						printf("4) É Herbívoro?\nR:");
						scanf ("%d",&her);
							if (mam==1&&qua==2&&car==1&&her==1)
							printf("O animal escolhido é o Homem!\a\a\n\n");
							else {
								if (mam==1&&qua==2&&car==2&&her==1)
								printf("O animal escolhido é o Macaco!\a\a\n\n");
								else {
									if (mam==1&&qua==2&&car==2&&her==2)
									printf("O animal escolhido é o Morcego!\a\a\n\n");
									else {
										if (mam==1&&qua==2&&car==1&&her==2)
										printf("O animal escolhido é a Baleia!\a\a\n\n");
										else {
											if (mam==2&&qua==2&&car==1&&her==1)
											printf("O animal escolhido é a Águia!\a\a\n\n");
											else {
												printf("5) É Aquático?\nR:");
												scanf ("%d",&aqua);
													if (mam==2&&qua==2&&car==1&&her==2&&aqua==1)
													printf("O animal escolhido é o Pinguim!\a\a\n\n");
													else {
														if (mam==2&&qua==2&&car==1&&her==2&&aqua==2)
														printf("O animal escolhido é a Cobra!\a\a\n\n");
														else {	
															printf("6) É Grande?\nR:");
															scanf ("%d",&gran);
																if (mam==2&&qua==2&&car==2&&her==1&&aqua==2&&gran==1)
																printf("O animal escolhido é o Avestruz!\a\a\n\n");
																else {
																	if (mam==2&&qua==2&&car==2&&her==1&&aqua==2&&gran==2)
																	printf("O animal escolhido é o Pato!\a\a\n\n");
																	else
																		printf("\nO animal descrito não esta na lista, tente outro.\n\n\n");
																																		
																	}
															}
														}
												}
											}
										}
									}
								}
						}
					}
				}
			}
		printf("Deseja repetir, digite '1' para Sim ou '2' para Não.\n");
		scanf ("%d",&escolha);
	} while (escolha==1);
	system("PAUSE");
	return 0;
}
