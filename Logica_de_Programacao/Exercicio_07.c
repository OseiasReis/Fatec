#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
  float temp, velo, dist, litro;
  printf("Digite o tempo gasto:", temp);
  scanf ("%f",&temp);
  printf("Digite a velocidade media:", velo);
  scanf ("%f",&velo);
  dist = (temp * velo);
  litro = dist/12;
  printf("\n O tempo gasto foi de: %f", temp);
  printf("\n A velocidade media e de: %f", velo);
  printf("\n A distancia foi de: %f", dist);
  printf("\n O total de litros de combustivel gasto foi de: %f", litro);
  getch();
  system("PAUSE");	
  return 0;
}
