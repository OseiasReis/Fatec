package controller;

public class Polish {

	public Polish() {
		super();
	}

	public void check(String expression) {
		expression = expression.trim();
		int tamanho = expression.length();
		char temp;
		Stack operadores = new Stack(0);
		StringBuffer polish = new StringBuffer();

		for (int i = 0; i < tamanho; i++) {

			temp = expression.charAt(i);

			if (Character.isDigit(temp)) { // numero
				polish.append(temp);
			} else {
				try {
					char aux = operadores.pop();
					if(aux > temp) {
						polish.append(aux);
					}else if(aux == temp) {
						polish.append(temp);
					}else {
						operadores.push(temp); //empilha
					}
				} catch (EmptyStackException e) {
					operadores.push(temp);//empilha
				}
			}
		}
		
		System.out.println(polish.toString());
	}
}
