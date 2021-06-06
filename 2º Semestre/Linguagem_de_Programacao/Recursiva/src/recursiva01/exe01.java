package recursiva01;

public class exe01 {
	public static void main(String srgs[]){
		int num=4;
		recursiva(num);
		System.out.println("O resultado é " + recursiva(num));
	}

	private static int recursiva(int num) {
		int x;
		if(num==1){
			return 1;
		}else{
			x=num*recursiva(num-1);
			return x;
		}
	}
}
//1º) 5050