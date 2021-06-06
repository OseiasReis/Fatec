#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) 
{
	setlocale(LC_ALL,"portuguese");
	float N1, N2, N3, N4, media;
	printf("Digite 1ª nota:\n");
	scanf ("%f",&N1);
	printf("Digite 2ª nota:\n");
	scanf ("%f",&N2);
	printf("Digite 3ª nota:\n");
	scanf ("%f",&N3);
	printf("Digite 4ª nota:\n");
	scanf ("%f",&N4);
	media = (N1+N2+N3+N4)/4;
		if (media>=9)
			printf("Aprovado com conceito A.\n");
		else
			{
			if (media>=7&&media<9)
				printf("Aprovado com conceito B.\n");
			else 
				{
				if (media>=5&&media<7)
					printf("Aprovado com conceito C.\n");
				else
					{
					if (media>=2,5&&media<5)	
						printf("Reprovado com conceito D.");
					else
						printf("Reprovado com conceito E.\n");
					}
				}
			}
	system("PAUSE");
	return 0;
}
