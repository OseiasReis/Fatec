#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) 
{
	setlocale(LC_ALL,"portuguese");
	int numero, decimal, binario;
	printf("Insira um numero inteiro:\n");
	scanf("%d",&numero);
	decimal = numero;
    while (numero>0) {
    	
        printf("O numero %d decimal, %d binário",decimal,binario);
 	return 0; 
}
