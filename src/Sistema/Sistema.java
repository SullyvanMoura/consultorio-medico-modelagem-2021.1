package Sistema;

import java.util.ArrayList;

public final class Sistema {
	
	private ArrayList<Consultorio> consultorios;
	
	public Sistema() {
		
		this.consultorios = new ArrayList<Consultorio>();
	}
	
	public void encheSistema() {

		criarConsultorio("Consultorio1", "123456");
		criarLoginMedico(consultorios.get(0),"Dr. Joao", "123456", "21999999999","senha");
		criarLoginMedico(consultorios.get(0),"Dr. Almeida Dias", "123456", "21999999999","senha");
		DataHora data1 = new DataHora(12,10,2021,15,30);
		DataHora data2 = new DataHora(11,10,2021,10,00);
		DataHora data3 = new DataHora(10,10,2021,14,00);
		DataHora data4 = new DataHora(10,10,2021,10,30);
		DataHora data5 = new DataHora(10,10,2021,10,00);
		DataHora data6 = new DataHora(12,10,2021,11,00);
		DataHora data7 = new DataHora(11,10,2021,16,00);
		
		DataHora data8 = new DataHora(20,10,2021,10,00);
		DataHora data9 = new DataHora(22,10,2021,9,30);
		DataHora data10 = new DataHora(18,10,2021,15,30);
		DataHora data11 = new DataHora(18,10,2021,14,30);
		DataHora data12 = new DataHora(18,10,2021,14,00);
		DataHora data13 = new DataHora(19,10,2021,16,00);
		
		adicionarHorarios(getConsultorios().get(0).getMedicos().get(1), data8);
		adicionarHorarios(getConsultorios().get(0).getMedicos().get(1), data9);
		adicionarHorarios(getConsultorios().get(0).getMedicos().get(1), data10);
		adicionarHorarios(getConsultorios().get(0).getMedicos().get(1), data11);
		adicionarHorarios(getConsultorios().get(0).getMedicos().get(1), data12);
		adicionarHorarios(getConsultorios().get(0).getMedicos().get(1), data13);

		adicionarHorarios(getConsultorios().get(0).getMedicos().get(0), data1);
		adicionarHorarios(getConsultorios().get(0).getMedicos().get(0), data2);
		adicionarHorarios(getConsultorios().get(0).getMedicos().get(0), data3);
		adicionarHorarios(getConsultorios().get(0).getMedicos().get(0), data4);
		adicionarHorarios(getConsultorios().get(0).getMedicos().get(0), data5);
		adicionarHorarios(getConsultorios().get(0).getMedicos().get(0), data6);
		adicionarHorarios(getConsultorios().get(0).getMedicos().get(0), data7);
		
		getConsultorios().get(0).getMedicos().get(0).criarPaciente("José Figueiredo da Silva Filho", new Email("jose@gmail.com"), "21964571547");
		getConsultorios().get(0).getMedicos().get(0).criarPaciente("Filipe Braida", new Email("filipebraida@gmail.com"), "21951798554");
		getConsultorios().get(0).getMedicos().get(0).criarPaciente("Bruno Dembogurski", new Email("brunodembogurski@gmail.com"), "21998546325");
		
		getConsultorios().get(0).getMedicos().get(1).criarPaciente("McLovin", new Email("mclovin@gmail.com"), "219542654783");
		getConsultorios().get(0).getMedicos().get(1).criarPaciente("Regina Casé", new Email("regina@yahoo.com"), "21926987453");
		getConsultorios().get(0).getMedicos().get(1).criarPaciente("Fausto Silva", new Email("faustao@gmail.com"), "21998564514");
		
	}
	
	public void criarConsultorio(String nome, String cnpj) {
		
		this.consultorios.add(new Consultorio(nome, cnpj));

	}
	
	public void criarLoginMedico(Consultorio consultorio, String nome, String crm, String telefone, String senha) {
		consultorio.criarMedico(nome, crm, telefone, senha);
	}
	
	public void agendarConsulta(Medico medico, Paciente paciente,DataHora diaHorario) {
		//int idxPaciente = medico.getPacientes().indexOf(paciente);
		
		//medico.getPacientes().get(idxPaciente).criarConsulta(diaHorario);
		
		paciente.criarConsulta(diaHorario);
		
		medico.getAgenda().getHorarios().remove(diaHorario);
	}
	
	public void cancelarConsulta(Medico medico, Paciente paciente, DataHora diaHorario) {
		paciente.cancelarConsulta(diaHorario);
		
		adicionarHorarios(medico, diaHorario);
	}
	
	public void criarFichaPaciente(Paciente paciente, CPF cpf, DataHora dataNascimento, Endereco endereco, EstadoCivil estadoCivil, Convenio convenio) {
		paciente.criarFicha(cpf, dataNascimento, endereco, estadoCivil, convenio);
		
		//System.out.println(paciente.getFicha().getCpf().getCpf());
		//System.out.println(paciente.getFicha().getDataNascimento().getAno());
		//System.out.println(paciente.getFicha().getEndereco().getRua());
		//System.out.println(paciente.getFicha().getEstadoCivil());
		//System.out.println(paciente.getFicha().getConvenio());
		
	}
	
	public void adicionarHorarios(Medico medico, DataHora diaHorario) {
		medico.getAgenda().adicionarHorario(diaHorario);
		
	}
	
	public void removerHorarios(Medico medico, DataHora diaHorario) {
		medico.getAgenda().removerHorarios(diaHorario);
	}

	public ArrayList<Consultorio> getConsultorios() {
		return consultorios;
	}
	
}
