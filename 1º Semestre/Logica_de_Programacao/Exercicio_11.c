#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) 
{
  float poup, juros1, juros2, juros3, result1, result2, result3;
  poup = 500,00;
  juros1 = (500,00/100*1);
  result1 = (poup+juros1);
  juros2 = (result1+result1/100*1);
  result2 = (result1+juros2);
  juros3 = (result2+result2/100*1);
  result3 = (result2+juros3);
  printf("O saldo na sua poupança é de %f:", result3);
  getch();
  system("PAUSE");	
  return 0;
}
