package caixa_ele;

public class Dados{
	//só deu pra fazer com static
	protected static int sb[]={0,5000,5000,5000,5000};
	protected static int[][] c={{100, 100, 100, 100, 100},{100, 100, 100, 100, 100, 100},{100, 100, 100, 100, 100, 100},{100, 100, 100, 100, 100, 100},{100, 100, 100, 100, 100, 100},{100, 100, 100, 100, 100, 100}};
	protected static int mab[]={0,0,0,0,0}, meb[]={9999,9999,9999,9999,9999};
	protected static int med[][]={{0,0},{0,0},{0,0},{0,0},{0,0}}, tot[][]={{0},{0},{0},{0},{0}};
	
	public int[] getSb() {
		return sb;
	}
	public void setSb(int[] sb) {
		this.sb = sb;
	}
	public int[][] getC() {
		return c;
	}
	public void setC(int[][] c) {
		this.c = c;
	}
	public int[] getMab() {
		return mab;
	}
	public void setMab(int[] mab) {
		this.mab = mab;
	}
	public int[] getMeb() {
		return meb;
	}
	public void setMeb(int[] meb) {
		this.meb = meb;
	}
	public int[][] getMed() {
		return med;
	}
	public void setMed(int[][] med) {
		this.med = med;
	}
	public int[][] getTot() {
		return tot;
	}
	public void setTot(int[][] tot) {
		this.tot = tot;
	}
	
	public static void main(String args[]) {
		
	}
}
