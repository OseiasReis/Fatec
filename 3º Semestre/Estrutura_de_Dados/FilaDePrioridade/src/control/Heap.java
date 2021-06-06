package control;

public class Heap {
	int vetor[];
	int n;
	public Heap(int t) {
		vetor = new int[t];
		n = 0;//heap inicia vazio
	}
	//demais métodos

	public void insere(int elemento) {
		vetor[n+1] = elemento; //n é a posição do último
		n++;
		subir(n);
	}

	void subir(int filho){
		int pai = filho / 2;
		if (pai >= 1) {
			if (vetor[filho] > vetor[pai]) {
				//Trocar pai e filho
				int aux;
				aux = vetor[filho];
				vetor[filho] = vetor[pai];
				vetor[pai] = aux;
				subir(pai);
			}
		}
	}

	public void remove() {
		vetor[1] = vetor[n];
		n--;
		descer(1, n);
	}

	void descer(int pai, int ultimo){
		int filho = 2 * pai; //Filho esquerdo
		if (filho <= ultimo) {
			if (filho < ultimo) { //Tem filho direito
				if (vetor[filho + 1] > vetor[filho]) {
					filho++; //Filho direito maior
				}
			}
			if (vetor[pai] < vetor[filho]) {
				//Trocar pai e filho maior
				int aux;
				aux = vetor[pai];
				vetor[pai] = vetor[filho];
				vetor[filho] = aux;
				descer(filho, ultimo);
			}
		}
	}

	public String printHeap(int p) {
		String retorno;
		retorno = "(";
		if (p <= n) {
			retorno += " " + vetor[p]+ " ";
			retorno += printHeap(2*p);
			retorno += printHeap(2*p+1);
		}
		retorno = retorno + ") ";
		return retorno;
	}
	
//	Heap começa vazio
//	na hora de inserir, N é a posição do último;
//	passa N para subir;
//	subir recebe o filho e indica que o pai é filho/2;
//	se filho for menor que o pai, troca os dois;
//	chamar subir dnv (recursivo, para subir mais um nivel);
//	tem que ter um if(pai>=1) pq tem q ter uma condição de parada, ou fica infinito;
//	para remove, o primeiro recebe o ultimo e o método descer tem por parametro (1, n) de pai e ultimo;
//	no descer, filho esquerdo é 2*pai;
//	se filho for menor igual ao ultimo, é pq pode ser que o pai n tenha filho;
//	se for maior, não existe;
//	agr se filho for menor que ultimo, então ele tem irmão;
//	se pai for menor que filho, tem q trocar e chamar descer dnv, outra recursiva, dnv é obrigatorio a parada;
//	printHeap se p<=n, preenche a variavel de apresentação; depois retorna;
}
