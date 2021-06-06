#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) 
{
	float resp, base, alt, area;
	printf("Deseja calcular a area do retangulo?\n");
	printf("1-para Sim ou 2-para Não\n");
	scanf ("%f",&resp);
	while (resp=1) {
	printf("Digite a Base do retangulo:\n");
	scanf ("%f",&base);
	printf("Digite a Altura do retangulo:\n");
	scanf("%f",&alt);
	area= (base*alt)/2;
	printf("A area do retangulo eh de %f\n", area);
	printf("Deseja calcular novamente?\n");
	printf("1-para Sim ou 2-para Não\n");
	scanf ("%f",&resp);
	}
	return 0;
}
