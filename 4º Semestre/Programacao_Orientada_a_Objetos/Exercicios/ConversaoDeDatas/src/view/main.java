package view;


public class main {

	public static void main(String[] args) {
		int dia = 5;
		int mes = 9;
		int ano = 2016;
		PegarData(dia, mes, ano);
	}

	private static void PegarData(int dia, int mes, int ano) {

		int data = dia + mes + ano;
		int base = 15 + 10 + 1582;
		if (mes < 3) {
			ano -= 1;
			mes += 12;
		} 
		if (data >= base){
			double a = ano / 100;
			double b = a / 4;
			double c = 2 - a + b;
			double d = 365.25 * (ano + 4716);
			double e = 30.6001 * mes + 1;
			double dataju = (d + e + dia + 0.5 + c - 1524.5) + 30;
			if (dataju%1==0) {
				dataju -= 1;
			}
			System.out.println(dataju);
		}
	}


}
