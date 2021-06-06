#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) 
{
	int AN, AA, IDA;
	AA=2015;
	printf("Digite seu ano de nascimento:");
	scanf ("%d",&AN);
	IDA=AA-AN;
	if (IDA>=18)
	{
	printf("\nVocê atingiu a maioridade.");
	}
	else
	{
	printf("\nVocê não atingiu a maioridade.");
	}
	system("PAUSE");
	return 0;
}
