package exe01;

public class main01 {
	public static void main(String[] args) {
		int v[] = {8,2,5,4,7,1,3,9,6};
		int ma=0, i=0;
		System.out.println(maior(v, ma, i));
	}
	private static int maior(int v[], int ma, int i){
		if(i==v.length) {
			return ma;
		}
		if(v[i]>ma) {
			ma=v[i];
		}
		return maior(v, ma, i+1);
	}
}
