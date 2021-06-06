package control;

public class HeapSort {
	public static int[] heapSort(int[] vetor){
		int aux;
		constroiHeapDescendo(vetor);
		//		constroiHeapSubindo(vetor);
		int ultimo = vetor.length -1;
		while (ultimo >= 0) {
			aux = vetor[ultimo];
			vetor[ultimo] = vetor[0];
			vetor[0] = aux;
			ultimo--;
			descer(vetor, 0, ultimo);
			//			subir(vetor, vetor.length-1, ultimo);
		}
		return vetor;
	}
	// demais métodos

	public static void constroiHeapDescendo(int[] vetor){
		for (int i = (vetor.length / 2) -1; i >= 0; i--) { //ventror.lenght é o final, dividido por 2 indica o pai dele, ir trocando até o final ser maior igual a 0;
			descer(vetor, i, (vetor.length -1));
		}
	}

	public static void constroiHeapSubindo(int[] vetor){
		for (int i = 0; i <= (vetor.length / 2) -1; i++) {
			subir(vetor, i, (vetor.length -1));
		}
	}

	public static void subir(int[] vetor, int filho, int ultimo){
		int pai = filho / 2;
		int esq = ((2 * pai) + 1);
		int dir = ((2 * pai) + 2);
		int maior = pai;
		if (vetor[esq] < vetor[pai]) {
			maior = esq; //Filho Esquerdo Maior
		}
		if (vetor[dir] < vetor[maior]) {
			maior = dir; //Filho Direito Maior
		}
		if (maior != pai) {
			//Trocar Pai e Filho Maior
			int aux = vetor[pai];
			vetor[pai] = vetor[maior];
			vetor[maior] = aux;
			subir(vetor, maior, ultimo);
		}
	}

	public static void descer(int[] vetor, int pai, int ultimo){
		int esq = ((2 * pai) + 1);
		int dir = ((2 * pai) + 2);
		int maior = pai;
		if ((esq <= ultimo) && (vetor[esq] > vetor[pai])) {
			maior = esq; //Filho Esquerdo Maior
		}
		if ((dir <= ultimo) && (vetor[dir] > vetor[maior])) {
			maior = dir; //Filho Direito Maior
		}
		if (maior != pai) {
			//Trocar Pai e Filho Maior
			int aux = vetor[pai];
			vetor[pai] = vetor[maior];
			vetor[maior] = aux;
			descer(vetor, maior, ultimo);
		}
	}

	public static boolean isHeapMax(int[] vetor) {
		//eh o mesmo do de baixo
		for (int i=1; i<vetor.length; i++) {
			if(2*i>=vetor.length) {
				return true;
			}
			if ((vetor[i]<vetor[2*i]) && (vetor[i]<vetor[(2*i)+1])) {
				return false;
			}
		}
		return true;
	}

	public static boolean isHeap(int[] vetor) {
		int tamanho=vetor.length-1;

		for (int f=tamanho; f>=0; f--) {
			int p = tamanho/2;
			if (vetor[tamanho] > vetor[p]) {
				return false;
			}
		}
		return true;
	}
}
