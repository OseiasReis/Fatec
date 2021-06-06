package view;

import control.BinaryTree;

public class Main {
	public static void main(String args[]) {
		BinaryTree arvore = new BinaryTree();
//		arvore.inserir(arvore.raiz, 50); arvore.inserir(arvore.raiz, 40);
//		arvore.inserir(arvore.raiz, 60); arvore.inserir(arvore.raiz, 35);
//		arvore.inserir(arvore.raiz, 45); arvore.inserir(arvore.raiz, 55);
//		arvore.inserir(arvore.raiz, 65);
		arvore.inserir(arvore.raiz, 8); arvore.inserir(arvore.raiz, 3);
		arvore.inserir(arvore.raiz, 1); arvore.inserir(arvore.raiz, 6);
		arvore.inserir(arvore.raiz, 4); arvore.inserir(arvore.raiz, 7);
		arvore.inserir(arvore.raiz, 10); arvore.inserir(arvore.raiz, 14);
		arvore.inserir(arvore.raiz, 13);
//		System.out.println(arvore.printTree(arvore.raiz));
//		arvore.raiz = arvore.remover(arvore.raiz, 45);
//		System.out.println(arvore.printTree(arvore.raiz));
//		arvore.raiz = arvore.remover(arvore.raiz, 60);
//		System.out.println(arvore.printTree(arvore.raiz));
//		arvore.raiz = arvore.remover(arvore.raiz, 50);
//		System.out.println(arvore.printTree(arvore.raiz));
		
		System.out.println("preOrdemIterativo:");
		arvore.preOrdemIterativo(arvore.raiz);
		System.out.println();
		System.out.println("preOrdem:");
		arvore.preOrdem(arvore.raiz);
		System.out.println("\n");
		
		System.out.println("inOrdemIterativo:");
		arvore.inOrdemIterativo(arvore.raiz);
		System.out.println();
		System.out.println("inOrdem:");
		arvore.inOrdem(arvore.raiz);
		System.out.println("\n");
		
		System.out.println("posOrdemIterativo:");
		arvore.posOrdemIterativo(arvore.raiz);
		System.out.println();
		System.out.println("posOrdem:");
		arvore.posOrdem(arvore.raiz);
		System.out.println("\n");
		
		System.out.println("Largura:");
		arvore.percursoEmLargura(arvore.raiz);
		System.out.println();
		System.out.println("LarguraRecu:");
		System.out.println(arvore.LarguraRecu(arvore.raiz));
		System.out.print("\n");
		
		System.out.println("Quantidade de nós:");
		System.out.println(arvore.QtdNode(arvore.raiz));
	}
}
