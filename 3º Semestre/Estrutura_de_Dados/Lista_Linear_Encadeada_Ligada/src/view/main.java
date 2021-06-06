package view;

import control.JLinkedList;
import control.Node;
import control.UnderflowException;

public class main {
	public static void main(String[] args) {
		JLinkedList lista = new JLinkedList();
		try {
			lista.insertFirst(new Node("D"));
			lista.insertFirst(new Node("A"));
			lista.insertFirst(new Node("B"));
			lista.insertLast(new Node("S"));
			lista.insertLast(new Node("C"));
			lista.removeFirst(); //pode lançar UnderflowException
			lista.removeLast(); //pode lançar UnderflowException
		} catch (UnderflowException e) {
			System.out.println("ERRO: Impossível remover!");
			e.printStackTrace();
		}
		lista.show();
	}
}
