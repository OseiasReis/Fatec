#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) 
{
	setlocale(LC_ALL,"portuguese");
	int i;
	printf("Dentre 1 a 100, os numeros impares sao:\n");
	i=1;
	for (i==1; i<=100; i+=2) {
		printf ("\n%d",i);
	}
	return 0;
}
