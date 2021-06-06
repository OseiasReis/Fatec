package matriz;

public class Exe12 {
	public static void main(String args[]) {
		int p[][]=new int[8][8], i, j, soma=0;
		
		for(i=0; i<=7; i++){
			for(j=0; j<=7; j++){
				if(i==0 || i==7){
					if(j==0 || j==7){
						p[i][j]=2;
						System.out.print(p[i][j]+ "|");
					}else{
						if(j==1 || j==6){
							p[i][j]=4;
							System.out.print(p[i][j]+ "|");
						}else{
							if(j==2 || j==5){
								p[i][j]=3;
								System.out.print(p[i][j]+"|");
							}else{
								if(i==0 && j==3 || i==7 && j==4){
									p[i][j]=6;
									System.out.print(p[i][j]+ "|");
								}
								if(i==7 && j==3 || i==0 && j==4){
									p[i][j]=5;
									System.out.print(p[i][j]+ "|");
								}
							}
						}
					}
				}else{
					if(i==1 || i==6 ){
						p[i][j]=1;
						System.out.print(p[i][j]+ "|");
					}else{
						if(i==2 || i==3 || i==4 || i==5 ){
							p[i][j]=7;
							System.out.print(p[i][j]+ "|");
						}
					}
				}
			}
			System.out.print("\n");
		}
		for(i=0; i<=1; i++){
			for(j=0; j<=7; j++){
				soma+=p[i][j];
			}
		}

		for(i=6; i<=7; i++){
			for(j=0; j<=7; j++){
				soma+=p[i][j];
			}
		}
		System.out.print("\nSoma: "+ soma);
	}
}
