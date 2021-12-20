package Sistema;

public class DataHora implements Comparable{
	
	private int dia;
	private int mes;
	private int ano;
	private int hora;
	private int minuto;
	
	public DataHora(int dia, int mes, int ano, int hora, int minuto) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.hora = hora;
		this.minuto = minuto;	
}
	
	public DataHora(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
}
	
	private int dataParaMinutos(DataHora datahora) { 
		int ano = datahora.getAno()*365*24*60;
		int mes = datahora.getMes()*30*24*60;
		int dia = datahora.getDia()*24*60;
		int hora = datahora.getHora()*60;
		int minuto = datahora.getMinuto();
		
		int total = ano + mes + dia + hora + minuto;
		return total;
	}
	
	private int dataParaMinutosDeste() { 
		int ano = this.getAno()*365*24*60;
		int mes = this.getMes()*30*24*60;
		int dia = this.getDia()*24*60;
		int hora = this.getHora()*60;
		int minuto = this.getMinuto();
		
		int total = ano + mes + dia + hora + minuto;
		return total;
	}
	
	@Override
	public int compareTo(Object outroDataHora) {
		
		DataHora outro = (DataHora) outroDataHora;
		
		return dataParaMinutosDeste() - dataParaMinutos(outro);
	}
	
	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAno() {
		return ano;
	}

	public int getHora() {
		return hora;
	}

	public int getMinuto() {
		return minuto;
	}
}
