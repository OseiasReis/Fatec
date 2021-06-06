package view;

import javax.swing.JOptionPane;

import controller.OpProc;

public class Main {
	public static void main(String[] args) {
		String processo;
		OpProc opProc = new OpProc();
		String so = System.getProperty("os.name");
		int opc=0;
		while(opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção:\n1 - Listar Proc\n2 - Matar Proc\n9 - Fim"));
			switch (opc) {
			case 1: 
				if(so.contains("W")) {
					processo = "tasklist /fo table";
				}else {
					//COMANDO LINUX 
					processo = "ps -A";
				}
				opProc.lerProcesso(processo);
				for (int i = 0; i < 3; ++i)  
					System.out.println();
			break;
			case 2:
				String info = JOptionPane.showInputDialog("Escreva o PID ou nome do processo:");
				opProc.mataProcesso(info, so);
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

