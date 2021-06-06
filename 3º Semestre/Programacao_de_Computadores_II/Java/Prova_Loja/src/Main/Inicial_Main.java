package Main;

import java.io.Serializable;
import java.util.Set;

import Model.Clientes;
import Model.Dominio;
import Model.Produtos;
import Model.Vendedores;
import persistir.Persistir_ser_DAO;

public class Inicial_Main {
	public static void main(String[] args) throws Exception{
		
		Vendedores vd1 = new Vendedores("Oséias");
		vd1.registro = 01;
		Vendedores vd2 = new Vendedores("Walter");
		vd2.registro = 02;
		Vendedores vd3 = new Vendedores("White");
		vd2.registro = 03;

		Clientes cl1 = new Clientes("Fuleira");
		cl1.codigo = 01;
		Clientes cl2 = new Clientes("Fulano");
		cl1.codigo = 02;
		Clientes cl3 = new Clientes("Fullmetal");
		cl1.codigo = 03;
		
		Produtos pr1 = new Produtos("Video-Game");
		pr1.cod_barras = 0000000000001;
		Produtos pr2 = new Produtos("Televisão");
		pr1.cod_barras = 0000000000002;
		Produtos pr3 = new Produtos("Computador");
		pr1.cod_barras = 0000000000003;
		
		Dominio dm = new Dominio();
		Set<Vendedores> l = dm.ListaRegistrados();
		for (Vendedores v : l){
			System.out.println(v.nome);
		}
		
		Persistir_ser_DAO<Serializable, Vendedores> ps = new Persistir_ser_DAO<Serializable, Vendedores>();
		ps.create(vd1);
		ps.create(vd2);
		ps.create(vd3);
		ps.create(cl1);
		ps.create(cl2);
		ps.create(cl3);
		ps.create(pr1);
		ps.create(pr2);
		ps.create(pr3);
	}
}
