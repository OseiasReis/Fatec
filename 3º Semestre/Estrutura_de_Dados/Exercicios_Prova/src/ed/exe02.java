package ed;

public class exe02 {
	static int i=0;
	public static void main(String[] args) {
		int v[]= {5,8,9,6,3,2,4,5,7,8,1};
		int s=0;
		System.out.println(soma(v, s));
	}

	private static int soma(int[] v, int s) {
		if(i >= v.length) {
			return s;
		}else {
			s+=v[i];
			i++;
			return soma(v, s);
		}
	}
}
