package control;

public class Node {
	public int element; //Elemento do Node é um inteiro
	public Node esq; //Referência para o filho esquerdo
	public Node dir; //Referência para o filho direito
	//Construtor do node
	public Node(int valor, Node e, Node d){
		element = valor;
		esq = e;
		dir = d;
	}
}
