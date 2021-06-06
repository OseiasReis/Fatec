#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) 
{
	float N1, N2, N3, N4, soma, media;
	 printf("Digite a primeira nota:", N1);
  	scanf ("%f",&N1);
 	 printf("Digite a segunda nota:", N2);
 	 scanf ("%f",&N2);
 	 printf("Digite a terceira nota:", N3);
 	 scanf ("%f",&N3);
 	 printf("Digite a quarta nota:", N4);
 	 scanf ("%f",&N4);
 	 media = (N1 + N2 + N3 + N4)/4;
 	if (media >= 6)
 	 printf("\n Sua media eh de: %f", media);
 	else
 	printf("\n Sua media eh de: %f", media);
   system("PAUSE");	
	return 0;
}
