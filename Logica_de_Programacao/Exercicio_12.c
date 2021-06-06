#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) 
{
  float VH, HTM, depen, valorB, valorL;
  printf("Digite o valor hora:", VH);
  scanf ("%f",&VH);
  printf("Digite as horas trabalhadas por mes:", HTM);
  scanf ("%f",&HTM);
  printf("Digite o numero de dependentes:", depen);
  scanf ("%f",&depen);
  valorB = (VH*HTM);
  valorL = (valorB+(300*depen));
  printf("O Valor Bruto é %f:", valorB);
  printf("O Valor Liquido é %f:", valorL);
  getch();
  system("PAUSE");	
  return 0;
}
