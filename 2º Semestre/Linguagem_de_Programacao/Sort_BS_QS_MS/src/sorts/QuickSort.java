package sorts;

public class QuickSort {
	public static void main (String args[]){
		int vt[] = {25, 57, 48, 37, 12, 92, 86, 33}, x, z, i, j, aux;
		resol(vt);
		for(i=0; i<=3; i++){
			
		}
	}
	
	public static int[] resol(int vt[]){
		int x, z, i, j, aux;
		for(i=0; i<=3; i++){
			for(j=1; j<=4; j++){
				x=vt[i];
				z=vt[j];
				if(x>z){
					aux = vt[i];
					vt[i] = z;
					vt[j] = aux;
				}
			}
		}
		return vt;
	}
}
