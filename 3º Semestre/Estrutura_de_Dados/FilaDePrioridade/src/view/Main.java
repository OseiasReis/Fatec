package view;

import control.Heap;

public class Main {
	public static void main(String args[]) {
		Heap h = new Heap(100);
		h.insere(16); h.insere(14); h.insere(10);
		h.insere(8); h.insere(7); h.insere(9);
		h.insere(3); h.insere(2); h.insere(2);
		h.insere(1);
		System.out.println(h.printHeap(1));
		h.insere(50);
		System.out.println(h.printHeap(1));
		h.remove();
		System.out.println(h.printHeap(1));
	}
}
