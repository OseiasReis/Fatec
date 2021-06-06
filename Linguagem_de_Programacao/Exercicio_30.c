#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) 
{
	setlocale(LC_ALL,"portuguese");
	int tabu,i,result;
	printf("Digite um número de uma determinada tabuada:\n");
	scanf ("%d",&tabu);
	i=0;
	do {
		i=i+1;
		result=tabu*i;
		printf("\n%d",result);
	} while (i<10);
	return 0;
}
