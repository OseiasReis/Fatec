#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) 
{
	setlocale(LC_ALL,"portuguese");
	int ida;
	printf("Digite sua idade:\n");
	scanf ("%d",&ida);
			if (ida>=5&&ida<=7)
			printf("Você está na categoria Infantil A.\n");
		else {
			if (ida>=8&&ida<=10)
				printf("Você está na categoria Infantil B.\n");
			else 
				{
				if (ida>=11&&ida<=13)
					printf("Você está na categoria Juvenil A.\n");
				else
					{
					if (ida>=14&&ida<=17)
						printf("Você está na categoria Juvenil B.\n");
					else
						{
						if (ida>=0&&ida<=4)
							printf("Sem categoria definida.\n");
						else
							printf("Você está na categoria Senior.\n");
						}
					}
				}
			}
	system("PAUSE");
	return 0;
}
