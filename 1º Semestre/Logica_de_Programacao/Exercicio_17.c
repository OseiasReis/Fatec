#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) 
{
	float quant, pesc, quilos;
	printf("Digite a quantidade de quilos pescados:");
	scanf ("%f",&pesc);
	if (pesc>50)
	{
	quilos=(pesc-50)*4;
	printf("\nA quantidade de quilos foi ultrapassada e sua multa sera de:%.f\n", quilos);
	}
	else
	{
	printf("\nA quantidade de quilos não foi ultrapassado\n");
	}
	system("PAUSE");
	return 0;
}
