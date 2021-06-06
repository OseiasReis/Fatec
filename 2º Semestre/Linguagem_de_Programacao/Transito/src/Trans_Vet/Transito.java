package Trans_Vet;

public class Transito {

	int CodCidade, QTDAcidentes, TipoVeiculo;
	String NomeCidade;
	  
	Transito () {	 
		  this(0, 0, 0, "");  
	}	 
	Transito ( int CodCid, int QTDAci, int TipoVei, String NomeCid)  {	 
		CodCidade   = CodCid;	 
		QTDAcidentes  = QTDAci;
		TipoVeiculo = TipoVei;
		NomeCidade = NomeCid;
	}	
}
