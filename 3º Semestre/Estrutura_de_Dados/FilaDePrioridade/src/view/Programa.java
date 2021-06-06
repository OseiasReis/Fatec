package view;

import control.HeapSort;

public class Programa {
	public static void main(String args[]) {
		int[] vetor = new int[]{1, 60, 10, 2, 7, 90, 0, 100, 35, 96};
		System.out.println("Desordenado:");
		for (int valor : vetor) {
			System.out.print(valor + " ");
		}
		HeapSort.heapSort(vetor);
		System.out.println("\n\nOrdenado:");
		for (int valor : vetor) {
			System.out.print(valor + " ");
		}
		
		System.out.println("\n");
		//int[] vetor2 = new int[]{84, 22, 19, 17, 10, 5, 6, 3, 9};
		//System.out.println(HeapSort.isHeapMax(vetor));
		System.out.println(HeapSort.isHeap(vetor));
	}
}
