package Sistema;
import java.util.ArrayList;
import java.util.Collections;

public class Consultorio {
	
	private String nome;
	private String cnpj;
	private ArrayList<Medico> medicos;
	
	public Consultorio(String nome, String cnpj) {
		
		this.nome = nome;
		this.cnpj = cnpj;
		this.medicos = new ArrayList<Medico>();
		
	}
	
	public void criarMedico(String nome, String crm, String telefone, String senha) {
		
		Medico novoMedico = new Medico(nome, crm, telefone, senha);
		medicos.add(novoMedico);
		Collections.sort(medicos);
		
	}

	public ArrayList<Medico> getMedicos() {
		return medicos;
	}

	public String getNome() {
		return nome;
	}
	
	
	
}
