package Sistema;
import java.util.ArrayList;

public class Consulta {
	
	private DataHora diaHorario;
	private FormaPagamento formaPagamento;
	private boolean confirmacao;
	private Prontuario prontuarios;
	private ArrayList<Receita> receitas;
	private ArrayList<Exame>  exames;
	
	public Consulta(DataHora diaHorario) {
		this.diaHorario = diaHorario;
	}

	public DataHora getDiaHorario() {
		return diaHorario;
	}
	
	
}
