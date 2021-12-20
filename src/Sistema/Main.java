package Sistema;
import Tela.TelaMedicoOUConsultorio;

public class Main {

	public static void main(String[] args) {
		Sistema sistema = new Sistema();
		sistema.encheSistema();
		
		TelaMedicoOUConsultorio tela = new TelaMedicoOUConsultorio(sistema);
		tela.start(sistema);
	}
}
