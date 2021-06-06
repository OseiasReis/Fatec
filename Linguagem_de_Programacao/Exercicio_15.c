#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) 
{
	float A, B, C, x1, x2, delta;
	printf("Digite o valor de A:");
	scanf ("%f",&A);
	printf("Digite o valor de B:");
	scanf ("%f",&B);
	printf("Digite o valor de C:");
	scanf ("%f",&C);
	delta = pow (B,2)-4*A*C;
	if (delta >= 0)
	{
	x1=(-B+sqrt(delta/2))/(2*A);
	x2=(-B-sqrt(delta/2))/(2*A);
	printf("\nO valor de x1 eh %.2f",x1);
	printf("\nO valor de x2 eh %.2f",x2);
	}
	else
	{
	printf("\nNão eh possivel encontrar o valor de x1, nem o valor de x2.");
	}
	system("PAUSE");
	return 0;
}
