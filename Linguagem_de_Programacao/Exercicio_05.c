#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
  int media, prim, segu, terc, quar;
  printf("Digite a primeira nota:", prim);
  scanf ("%d",&prim);
  printf("Digite a segunda nota:", segu);
  scanf ("%d",&segu);
  printf("Digite a terceira nota:", terc);
  scanf ("%d",&terc);
  printf("Digite a quarta nota:", quar);
  scanf ("%d",&quar);
  media = (prim + segu + terc + quar)/4; 
  printf("Sua media é de: %d", media);
  getch();
  system("PAUSE");	
  return 0;
}
