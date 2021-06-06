#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) 
{
	int senha;
	printf("Digite sua senha:");
	scanf ("%f",&senha);
	if (senha==12345)
	{
	printf("\nSenha Valida\n");
	}
	else
	{
	printf("\nSenha Invalida\n");
	}
	system("PAUSE");
	return 0;
}
