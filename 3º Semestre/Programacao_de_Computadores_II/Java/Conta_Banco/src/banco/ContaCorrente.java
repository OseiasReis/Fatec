package banco;

public class ContaCorrente extends Conta implements Tributavel{
	
	private double deposita;
	
	public ContaCorrente(int saldo) {
		super(saldo);
	}
	
	public void deposita(double dep){
		this.deposita = dep;
	}
	
	public double calculaTributos() {
		return this.getSaldo() * 0.01;
	}
}
