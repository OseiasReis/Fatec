package control;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	public Node raiz; //node raiz da árvore
	public BinaryTree() {
		raiz = null;
	}

	public void inserir(Node p, int valor) {
		if (p == null) {
			raiz = new Node(valor, null, null);
		} else if (valor <= p.element) {
			if (p.esq != null) {
				inserir(p.esq, valor);
			} else {
				p.esq = new Node(valor, null, null);
			}
		} else if (valor > p.element) {
			if (p.dir != null) {
				inserir(p.dir, valor);
			} else {
				p.dir = new Node(valor, null, null);
			}
		}
	}

	public String printTree(Node p) {
		String retorno;
		retorno = "(";
		if (p != null) {
			retorno += " " + p.element + " ";
			retorno += printTree(p.esq);
			retorno += printTree(p.dir);
		}
		retorno = retorno + ") ";
		return retorno;
	}

	public Node remover(Node p, int valor) {
		Node aux, r = null;
		if (p.element == valor) { //achei o valor na árvore
			if ((p.esq == null) && (p.dir == null)) { //não tem filhos
				return null;
			} else if (p.esq == null) { //tem apenas filho direito
				//(subárvore direita)
				return p.dir;
			} else if (p.dir == null) { //tem apenas filho esquerdo
				//(subárvore esquerda)
				return p.esq;
			} else { //tem dois filhos
				//(subárvores esquerda e direita)
				//continua...
				r = p;
				aux = p.dir;											//ENCONTRANDO O MAIOR ELEMENTO NA SUB-ÁRVOE-DIREITA
				while (aux.esq != null) { //encontrar o descendente
					//mais à esquerda na
					//subárvore direita
					r = aux;
					aux = aux.esq;
				}
				aux = p.esq;											//ENCONTRANDO O MAIOR ELEMENTO NA SUB-ÁRVOE-ESQUERDA
				while (aux.dir != null) { //encontrar o descendente
					//mais à direita na
					//subárvore esquerda
					r = aux;
					aux = aux.dir;
				}
				p.element = aux.element;
				if (r == p) { //não entrou no laço while
					r.dir = aux.dir;
				} else {
					r.esq = aux.dir;
				}
				return p;
			}
			//continua...
		} else if (p.element < valor) {
			remover(p.dir, valor); //remover na subárvore direita
		} else {
			remover(p.esq, valor); //remover na subárvore esquerda
		}
		return p;
	}

	public void preOrdem(Node p) {
		if (p != null) {
			System.out.print(p.element + " ");
			preOrdem(p.esq);
			preOrdem(p.dir);
		}
	}

	public void preOrdemIterativo(Node p) {
		Stack pilha = new Stack();
		if (p != null) { //árvore não pode ser vazia
			pilha.push(p);
			while (!pilha.isEmpty()) {
				p = (Node) pilha.pop(); //desempinha
				System.out.print(p.element + " ");
				if (p.dir != null) {
					//empilha filho direito
					pilha.push(p.dir);
				}
				if (p.esq != null) {
					//empinha filho esquerdo
					pilha.push(p.esq);
				}
			}
		}
	}

	public void inOrdem(Node p) {
		if (p != null) {
			inOrdem(p.esq);
			System.out.print(p.element + " ");
			inOrdem(p.dir);
		}
	}

	public void inOrdemIterativo(Node p) {
		Stack pilha = new Stack();
		if (p != null) {
			pilha.push(p);
			while (!pilha.isEmpty())  {
				while (p !=  null) {
					pilha.push(p);
					p = p.esq;
				}
				p = (Node) pilha.pop();
				System.out.print(p.element + " ");
				p = p.dir;
			}
		}
	}

	public void posOrdem(Node p) {
		if (p != null) {
			posOrdem(p.esq);
			posOrdem(p.dir);
			System.out.print(p.element + " ");
		}
	}

	public void posOrdemIterativo(Node p) {
		Stack pilha = new Stack();
		Stack pilha2 = new Stack();
		if (p != null) { //árvore não pode ser vazia
			pilha.push(p);
			while (!pilha.isEmpty()) {
				p = (Node) pilha.pop();
				pilha2.push(p);
				if(p.esq != null) {
					pilha.push(p.esq);
				}
				if(p.dir != null) {
					pilha.push(p.dir);
				}
			}
			while(!pilha2.isEmpty()) {
				p = (Node) pilha2.pop();
				System.out.print(p.element + " ");
			}
		}
	}

	public void percursoEmLargura(Node p) {
		Queue fila = new LinkedList();
		if (p != null) { //árvore não pode ser vazia
			fila.add(p);
			while (!fila.isEmpty()) {
				p = (Node) fila.remove(); //desenfileira
				System.out.print(p.element + " ");
				if (p.esq != null) {
					//enfileira filho esquerdo
					fila.add(p.esq);
				}
				if (p.dir != null) {
					//enfileira filho direito
					fila.add(p.dir);
				}
			}
		}
	}

	public int LarguraRecu(Node p) {
		if(p == null) {
			return -1;
		}
		else {
			int fEsq = LarguraRecu(p.esq);
			int fDir = LarguraRecu(p.dir);

			if(fEsq > fDir)
				return fEsq+1;
			else
				return fDir+1;
		}
	}

	public int QtdNode(Node p) {
		return (p == null) ? 0 : 1 + QtdNode(p.esq) + QtdNode(p.dir);
	}
}
