package Sistema;
import java.util.ArrayList;

public class Paciente implements Comparable{
	private String nome;
	private Email email;
	private String telefone;
	private Ficha ficha;
	private ArrayList<Consulta> consultas;
	
	public Paciente(String nome, Email email, String telefone) {
		
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.consultas = new ArrayList<Consulta>();
	}
	
	@Override
	public int compareTo(Object outroPaciente) {
		
		String nomeNovo = ((Paciente) outroPaciente).getNome();
		
		return this.nome.compareTo(nomeNovo);
		
	}
	
	public Ficha getFicha() {
		return ficha;
	}

	public void criarFicha(CPF cpf, DataHora dataNascimento, Endereco endereco, EstadoCivil estadoCivil, Convenio convenio) {
		this.ficha = new Ficha(cpf, dataNascimento, endereco, estadoCivil, convenio);
	}
	
	public void criarConsulta(DataHora diaHorario) {
		
		Consulta novaConsulta = new Consulta(diaHorario);
		
		consultas.add(novaConsulta);
		
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void cancelarConsulta(DataHora diaHorario) {
		
		for (Consulta con: consultas) {

			if (con.getDiaHorario() == diaHorario) {
				
				consultas.remove(con);
				break;
			}
		}
	}

	public String getNome() {
		return nome;
	}

	public ArrayList<Consulta> getConsultas() {
		return consultas;
	}
	
	public Email getEmail() {
		return this.email;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	
	
}

