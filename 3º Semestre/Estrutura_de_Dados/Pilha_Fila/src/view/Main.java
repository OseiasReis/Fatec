package view;

import controller.EmptyStackException;
import controller.Polish;
import controller.Stack;

public class Main {
	public static void main(String[] args) {		
		Polish ob = new Polish();
		ob.check("10+5*(41+21)");
		
		Stack s = new Stack(7);
		s.push('0');
		s.push('2');
		s.push('5');
		s.push('3');
		s.push('8');
		s.push('4');
		s.push('5');
//		try {
//			s.pop();
//			s.pop();
//		} catch (EmptyStackException e) {
//			System.out.println("ERRO: Impossível remover!");
//			e.printStackTrace();
//		}
		//System.out.println(s.isFull());
		System.out.println(s.getSize());
		try {
			System.out.println(s.showTop());
		} catch (EmptyStackException e) {
			e.printStackTrace();
		}
		try {
			s.showList();
		} catch (EmptyStackException e) {
			e.printStackTrace();
		}
	}

}
