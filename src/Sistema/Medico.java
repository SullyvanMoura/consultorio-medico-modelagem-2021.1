package Sistema;
import java.util.ArrayList;
import java.util.Collections;

public class Medico implements Comparable {
	
	private String nome;
	private String crm;
	private String telefone;
	private String senha;
	private Agenda agenda;
	private ArrayList<Paciente> pacientes;
	
	public Medico(String nome, String crm, String telefone, String senha) {
		
		this.nome = nome;
		this.crm = crm;
		this.telefone = telefone;
		this.senha = senha;
		this.pacientes = new ArrayList<Paciente>();
		this.agenda = new Agenda();
		
	}

	@Override
	public int compareTo(Object outroMedico) {
		
		String nomeNovo = ((Medico) outroMedico).getNome();
		
		return this.nome.compareTo(nomeNovo);
		
	}
	
	public Paciente criarPaciente(String nome, Email email, String telefone) {
		
		Paciente novoPaciente = new Paciente(nome, email, telefone);
		this.pacientes.add(novoPaciente);
		Collections.sort(pacientes);
		
		return novoPaciente;
		
	}
	
	public void atualizarPaciente(Paciente paciente, String nome, Email email, String telefone) {
		paciente.setNome(nome);
		paciente.setEmail(email);
		paciente.setTelefone(telefone);
	}
	
	
	public Agenda getAgenda() {
		return agenda;
	}

	public ArrayList<Paciente> getPacientes() {
		return pacientes;
	}
	
	public String getNome() {
		return nome;
	}


	
}
