package Sistema;
import java.util.Collections;
import java.util.ArrayList;

public class Agenda {
	
	private ArrayList<DataHora> horarios;
	
	public Agenda() {
		this.horarios = new ArrayList<DataHora>();
	}
	
	public void adicionarHorario(DataHora dataHora) {
		this.horarios.add(dataHora);
		Collections.sort(horarios);
	}
	
	public void removerHorarios(DataHora dataHora) {
		this.horarios.remove(dataHora);
	}

	public ArrayList<DataHora> getHorarios() {
		return horarios;
	}
	
	
	
}
	
