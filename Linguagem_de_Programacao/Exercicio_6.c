#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
  float com, larg, area;
  printf("Digite o comprimento:", com);
  scanf ("%f",&com);
  printf("Digite a largura:", larg);
  scanf ("%f",&larg);
  area = (com * larg)/2; 
  printf("O valor da area é de: %f", area);
  getch();
  system("PAUSE");	
  return 0;
}
