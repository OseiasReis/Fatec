package exe03;

public class main03 {
	public static void main(String[] args) {
		int v[] = {1,2,3,4,5,6,7,8,9,10};
		int i=0, j=v.length-1;
		inverter(v, i, j);
		for(i=0; i<v.length; i++) {
			System.out.print(v[i]+" - ");
		}
	}
	private static int inverter(int v[], int i, int j){
		int aux;
		if(i>v.length/2) {
			return 0;
		}
		aux=v[i];
		v[i]=v[j];
		v[j]=aux;
		return inverter(v, i+1, j-1);
	}
}
