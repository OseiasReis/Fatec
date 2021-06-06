package ed;

public class exe01 {
	static int i=0;
	public static void main(String[] args) {
		int v[]= {5,8,9,6,3,2,4,5,7,8,1};
		int m=0;
		System.out.println(maior(v, m));
	}

	private static int maior(int[] v, int m) {
		if(i >= v.length) {
			return m;
		}else {
			if(m<v[i]) {
				m=v[i];
			}
			i++;
			return maior(v, m);
		}
	}
}
