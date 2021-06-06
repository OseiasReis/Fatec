#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) 
{
	setlocale(LC_ALL, "Portuguese");
	
  float juros1, juros2, juros3, mes1, mes2, mes3;
  
  juros1 = 500*0.01;
  mes1 = 500+juros1;
  
  juros2 = mes1*0.01;
  mes2 = mes1+juros2;
  
  juros3 = mes2*0.01;
  mes3 = mes2+juros3;
  
  printf("O saldo na sua poupança é de %.2f:", mes3);
  getch();
  system("PAUSE");	
  return 0;
}

/* juros1 = 5
mes1 = 505

juros2 = 5.05
mes2 = 510.05

juros3 = 5.10
mes3 = 515.10 */
