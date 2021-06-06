package sorts;

public class BubbleSort {
	public static void main (String args[]){
		int vt[] = {26, 47, 38, 11, 95}, i, j, l1=3;
		i=0; j=1;
		resol(vt, l1);
		/*while(vt[i]>vt[j]){
			resol(vt, l1--);
			i++;
			j++;
		}*/
		for(i=0; i<=4; i++){
			System.out.print(vt[i] + " - ");
		}
	}
	
	public static int[] resol(int vt[], int l1){
		int x, z, i, j, aux;
		j=1;
		for(i=0; i<=l1; i++){
				x=vt[i];
				z=vt[j];
				if(x>z){
					aux = x;
					vt[i] = z;
					vt[j] = aux;
					j++;
				}else{
					j++;
				}
		}
		//resol(vt, l1--);
		return vt;
	}
}
