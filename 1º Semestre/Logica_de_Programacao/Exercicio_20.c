#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) 
{
	setlocale(LC_ALL,"portuguese");
	int valor, result;
	printf("Digite um numero:");
	scanf ("%d",&valor);
	result=valor%2;
	if (result==0)
	{
		printf("O numero digitado é par.\n");
	}
	else
	{
		printf("O numero digitado é impar.\n");
	}
	system("PAUSE");
	return 0;
}
