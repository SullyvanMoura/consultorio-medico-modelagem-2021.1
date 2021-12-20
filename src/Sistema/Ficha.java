package Sistema;

public class Ficha {
	
	private CPF cpf;
	private DataHora dataNascimento;
	private Endereco endereco;
	private EstadoCivil estadoCivil;
	private Convenio convenio;
	
	public Ficha(CPF cpf, DataHora dataNascimento, Endereco endereco, EstadoCivil estadoCivil, Convenio convenio) {
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.estadoCivil = estadoCivil;
		this.convenio = convenio;
	}

	public CPF getCpf() {
		return cpf;
	}

	public void setCpf(CPF cpf) {
		this.cpf = cpf;
	}

	public DataHora getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(DataHora dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}
	
}
