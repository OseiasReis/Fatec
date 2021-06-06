package Exercicio31_45;

public class Exe42 {
	public static void main(String args[]) {
		int n=99, i=1;
		double res=0, s;
		for(s=1; s<=n; s++){
			res+= (i/s);
			System.out.println(i+"/" + s + "= " + res);
			s++;
			i++;
		}
	}
}
