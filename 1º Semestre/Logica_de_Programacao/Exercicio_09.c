#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) 
{
  float A, B, C, x1, x2, delta;
  printf("Digite o valor de A:", A);
  scanf ("%f",&A);
  printf("Digite o valor de B:", B);
  scanf ("%f",&B);
  printf("Digite o valor de C:", C);
  scanf ("%f",&C)
  delta = (b**2-4*A*C);
  x1 = (-B-delta//2)/2*A;
  x2 = (-B+delta//2)/2*A;
  printf("O resultado de x1 é:", x1);
  printf("O resultado de x2 é:", x2);
  getch();
  system("PAUSE");	
  return 0;
}
