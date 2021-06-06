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
	for (i==1; i<=10; i++) {
		result=tabu*i;
		printf("\n%d",result);
	}
	return 0;
}
