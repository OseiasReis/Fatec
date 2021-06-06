package ed;

public class exe03 {
	static int x=0;
	static int i=0;
	static int j=0;
	static int y=0;
	public static void main(String[] args) {
		int v[]= {5,8,9,6,3,2,4,5,7,8,1};
		j=v.length-1;
		inverter(v);
		for(int y=0; y<v.length; y++) {
			System.out.print(v[y]+" - ");
		}
	}

	private static int inverter(int[] v) {
		if(y>=v.length/2) {
			return 0;
		}else {
			x = v[i];
			v[i] = v[j];
			v[j] = x;
			j--;
			i++;
			y++;
			return inverter(v);
		}
	}
}
