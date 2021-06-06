#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) 
{
	float alt, peso, M;
	char sex;
	printf("Digite sua altura:");
	scanf ("%f",&alt);
	printf("Digite seu sexo: 1-para masculino ou 2-para feminino:");
	scanf ("%f",&sex);
	if (sex=1)
	{
	peso=(72,7*alt)-58;
	}
	else
	{
	peso=(62,1*alt)-44,7;
	}
	printf("\nO seu peso ideal eh de:%f", peso);
	system("PAUSE");
	return 0;
}
