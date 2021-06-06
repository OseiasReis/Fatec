package Exercicio21_30;

import java.util.Random;

public class Exe30 {
	public static void main(String args[]) {
		int an, aa, mn, ma, dn, da, ia, im, id, bi, bin=0, bia=0;
		Random gerador = new Random();
		dn= gerador.nextInt(31)+1;
		System.out.println("Dia de nascimento: " + dn);
		mn= gerador.nextInt(12)+1;
		System.out.println("Mês de nascimento: " + mn);
		an=1999;	
		System.out.println("Ano de nascimento: " + an);
		da= gerador.nextInt(31)+1;	
		System.out.println("Dia atual: " + da);
		ma= gerador.nextInt(12)+1;
		System.out.println("Mês atual: " + ma);
		aa=2018;
		System.out.println("Ano atual: " + aa);
		if(dn==31 && mn==02){
				System.out.println("Fevereiro tem 28 dias (29 em anos bissextos);");
		}else {
			if(dn==30 && mn==02){
					System.out.println("Fevereiro tem 28 dias (29 em anos bissextos);");
			}else {
				if(da==31 && ma==02){
						System.out.println("Fevereiro tem 28 dias (29 em anos bissextos);");
				}else {
					if(da==30 && ma==02){
							System.out.println("Fevereiro tem 28 dias (29 em anos bissextos);");
					}
				}
			}
		}
			if(dn<=31 && mn<=12 && an<=aa){
				if(da<=31 && ma<=12){
					if(an==aa && mn>=ma && dn>=da){
						System.out.println("Data maior do que a data atual");						
					}
					else{
						for(bi=0; bi<=an;){
							bin++;
							bi=bi+4;
						}
						for(bi=0; bi<=aa;){
							bia++;
							bi=bi+4;
						}
						bi= bia-bin;
						ia=aa-an;
						if(mn<=ma){
							im=ma-mn;
							if(im>12){
								ia++;
								im= im-12;
							}
							if(dn<=da){
								id=da-dn;
								id=id+bi;
								while(id>31){
									im++;
									id=id-30;
								}
								System.out.println("Ano(s);: "+ ia+"\nMes(es);: "+ im+ "\nDia(s);: "+ id);
							}
							else{
								id=dn-da;
								id=id+bi;
								while(id>31);{
									im++;
									id=id-30;
								}
								System.out.println("Ano(s);: "+ ia+"\nMes(es);: "+ im+ "\nDia(s);: "+ id);
							}
						}
						else{
							im=(12-mn)+ma;
							ia--;
							if(im>12){
								ia++;
								im= im-12;
							}
							if(dn<=da){
								id=da-dn;
								id=id+bi;
								while(id>31){
									im++;
									id=id-30;
								}
								System.out.println("Ano(s);: "+ ia+"\nMes(es);: "+ im+ "\nDia(s);: "+ id);
							}
							else{
								id=dn-da;
								id=id+bi;
								while(id>31){
									im++;
									id=id-30;
								}
								System.out.println("Ano(s);: "+ ia+"\nMes(es);: "+ im+ "\nDia(s);: "+ id);
							}
						}
					}
				}
				else
					System.out.println("Datas não existentes ou maior do que a data atual");
			}
			else
				System.out.println("Datas não existentes ou maior do que a data atual");
		
	}
}
