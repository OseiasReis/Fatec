package recursiva01;

public class exe03 {
	public static void main(String args[]){
		int num=5;
		serie01(num);
		serie02(num);
		System.out.println("O resultado de serie01 é " + serie01(num));
		System.out.println("O resultado de serie02 é " + serie02(num));
		System.out.println("O resultado de serie02 é " + serie03(num));
	}

	private static int serie01(int num) {
		int x;
		if(num==1){
			return 1;
		}else{
			x=num+serie01(num-1);
			//System.out.println(soma);
			return x;
		}
	}
	
	private static double serie02(int num) {
		//int x;
		double x, y=1;
		if(num==1){
			return 1;
		}else{
			x=y/num+serie02(num-1);
			return x;
		}
	}
	
	private static double serie03(int num) {
		//int x;
		double x, y=1;
		if(num==1){
			return 1;
		}else{
			x=y/num+serie03(num-1);
			System.out.println(x);
			return x;
		}
	}
}
