package exe07;

public class Node {
	private String element; //Elemento do Node é uma string
	private Node next;//Referência para um objeto Node
	//Cria um node com um elemento e uma referência para o próximo node

	public Node(String s, Node n) {

		this.element = s;
		this.next = n;

	}

	//Cria um node com um elemento e uma referência null
	public Node(String element) {
		this(element, null);
	}

	//Retorna o elemento deste node
	public String getElement() {
		return element;
	}

	//Define o elemento deste node
	public void setElement(String newElem) {
		element = newElem;
	}

	//Retorna a referência para o próximo node
	public Node getNext() {
		return next;
	}

	//Define a referência para o próximo node
	public void setNext(Node newNext) {
		next = newNext;
	}
}
