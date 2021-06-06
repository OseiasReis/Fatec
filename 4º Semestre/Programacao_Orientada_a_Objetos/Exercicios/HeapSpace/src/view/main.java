package view;

import java.util.ArrayList;
import java.util.List;

public class main {
	public static void main(String[] args) {
		List lista = new ArrayList();
		 
        for ( int i = 0; i < 900000000; i++ ){
            lista.add( "Testando o Heap" );
        }
	}
}
