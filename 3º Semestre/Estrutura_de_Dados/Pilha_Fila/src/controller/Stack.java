package controller;

public class Stack {
	public Object[] pilha;
	protected Node top;
	protected int size;
	
	public Stack(int n) {
		top =  null;
		size = 0;
		this.pilha = new Object[n];
	}
	
	public boolean isEmpty() {
		return this.top == null;
	}
	
	public boolean isFull() {
		if(getSize() == 0) {
			System.out.println("Lista vazia!");
		}else if(getSize()==top.getCaracter()-1){
			return true;
		}
		return false;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public char showTop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return top.getCaracter();
	}
	
	public void showList() throws EmptyStackException {
		if (isEmpty()) {
			System.out.println("Lista vazia!");
		} else {
			System.out.print("A lista é: ");
			Node current = top;
			while (current != null) {
				System.out.print(current.getCaracter() + " ");
				current = current.getNext();
			}
			System.out.println("\n");
		}
	}

	public char peek() throws EmptyStackException {
		
		if(isEmpty()) {
			 throw new EmptyStackException();
		}
		
		return top.getCaracter();
	}
	
	public void push(char element) {
		Node novo =  new Node(element, top);
		top = novo;
		size ++;
	}
	
	public char pop() throws EmptyStackException {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		char temp = top.getCaracter(); //auxiliar
		top = top.getNext();
		size--;
		return temp;
	}
}
