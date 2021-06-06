#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
  float cels, fahr;
  printf("Digite a temperatura em Celsius:", cels);
  scanf ("%f",&cels);
  farh = (9*cels+160)/5;
  printf("A temperatura em fhrenheit e:", fahr, "ºF");
  getch();
  system("PAUSE");	
  return 0;
}
