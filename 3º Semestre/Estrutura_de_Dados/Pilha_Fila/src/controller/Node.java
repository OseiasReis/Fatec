package controller;

public class Node {
	private char caracter;
	private Node next;

	public Node(char caracter, Node next) {

		this.caracter = caracter;
		this.next = next;

	}

	public Node(char character) {
		this(character, null);
	}

	public char getCaracter() {
		return caracter;
	}

	public void setCaracter(char caracter) {
		this.caracter = caracter;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
