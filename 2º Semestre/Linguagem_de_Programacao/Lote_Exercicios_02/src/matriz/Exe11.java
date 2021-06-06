package matriz;

public class Exe11 {
	public static void main(String args[]) {
		int p[][]=new int[8][8], i, j;
		
		for(i=0; i<=7; i++){
			for(j=0; j<=7; j++){
				if(i==0 || j==0 || i==7 || j==7){
					p[i][j]=1;
					System.out.print(p[i][j]+ "|");
				}else{
					if(i==1 || j==1 || i==6 || j==6){
						p[i][j]=2;
						System.out.print(p[i][j]+ "|");
					}else{
						if(i==2 || j==2 || i==5 || j==5){
							p[i][j]=3;
							System.out.print(p[i][j]+ "|");
						}else{
							if(i==3 || j==3 || i==4 || j==4){
								p[i][j]=4;
								System.out.print(p[i][j]+ "|");
							}
						}
					}
				}
			}
			System.out.print("\n");
		}
	}
}
