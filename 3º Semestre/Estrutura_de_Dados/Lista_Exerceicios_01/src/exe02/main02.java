package exe02;

public class main02 {
	public static void main(String[] args) {
		int num=5915;
		System.out.println(somar(num));
	}
	public static int somar(int num) {	
		if (num % 10 == num)
			return num;
		return ((num % 10) + somar(num / 10));
	}
}
