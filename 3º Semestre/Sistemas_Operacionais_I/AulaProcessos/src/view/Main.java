package view;

import controller.OpProc;

public class Main {
	public static void main(String[] args) {
		OpProc opProc = new OpProc();
		String so = opProc.so();
		System.out.println(so);
//		String processo = "regedit.exe"; //nome do processo
//		opProc.chamaProcesso(processo);
		String processo = "tasklist /fo table"; //comandos de cmd (listar tarefas)
		opProc.lerProcesso(processo);
//		processo = "ping -t1 www.fateczl.edu.br"; //-t tempo em minutos
//		opProc.lerProcesso(processo);
		
//		String info = "1036"; //pid
		String info = "cmd.exe"; //nome
		opProc.mataProcesso(info);
	}
}
