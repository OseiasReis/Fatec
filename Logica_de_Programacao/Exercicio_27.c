#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) 
{
	setlocale(LC_ALL,"portuguese");
	int Dia1, Mes1, Ano1, Data1, Dia2, Mes2, Ano2, Data2;
	printf("Digite o primeiro dia:");
	scanf ("%d",&Dia1);
	printf("Digite o primeiro mês:");
	scanf ("%d",&Mes1);
	printf("Digite o primeiro ano:");
	scanf("%d",&Ano1);
	Data1 = (Ano1*100+Mes1)*100+Dia1;
	printf("Digite o segundo dia:");
	scanf ("%d",&Dia2);
	printf("Digite o segundo mês:");
	scanf ("%d",&Mes2);
	printf("Digite o segundo ano:");
	scanf("%d",&Ano2);
	Data2 = (Ano2*100+Mes2)*100+Dia2;
		if (Data1<Data2)
			printf("%d / %d / %d \n%d / %d / %d\n",Dia1,Mes1,Ano1,Dia2,Mes2,Ano2);
		else
			printf("%d / %d / %d \n%d / %d / %d\n",Dia2,Mes2,Ano2,Dia1,Mes1,Ano1);
	system("PAUSE");
	return 0;
}
