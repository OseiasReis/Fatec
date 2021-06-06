package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {
	public static void main(String[] args) {
		RedesController rc = new RedesController();
		int opc=0;
		while(opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção:\n1 - Ip\n2 - Ping\n9 - Fim"));
			switch (opc) {
			case 1: 
				rc.ip();
				for (int i = 0; i < 3; ++i)  
					System.out.println();
			break;
			case 2: 
				rc.ping();
				for (int i = 0; i < 3; ++i)  
					System.out.println();
			break;
			case 9: System.exit(0);
			break;
			default:
				System.out.println("Informe um número valido");
				break;
			}
		}
	}
}
