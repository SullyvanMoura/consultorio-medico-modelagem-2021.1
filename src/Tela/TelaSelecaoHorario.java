package Tela;

import Sistema.Sistema;

import Sistema.Medico;
import Sistema.Paciente;
import Sistema.DataHora;
import Sistema.Agenda;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaSelecaoHorario {
	
	private Sistema sistema;
	private Medico medico;
	private Paciente paciente;
	private JFrame frame;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */

	public void start(Sistema sistema, Medico medico, Paciente paciente) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSelecaoHorario window = new TelaSelecaoHorario(sistema, medico, paciente);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public TelaSelecaoHorario(Sistema sistema, Medico medico, Paciente paciente) {
		this.sistema = sistema;
		this.medico = medico;
		this.paciente = paciente;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(171, 34, 1024, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		JLabel lblNewLabel = new JLabel("Selecione um hor\u00E1rio:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel.setBounds(330, 30, 363, 57);
		frame.getContentPane().add(lblNewLabel);
		
		int espaco = 100;
		
		for (DataHora dh : medico.getAgenda().getHorarios()) {
			
			int dia = dh.getDia();
			int mes = dh.getMes();
			int ano = dh.getAno();
			int hora = dh.getHora();
			int minuto = dh.getMinuto();
			String talvezero = "";
			String outrozero = "";
			if (minuto == 0) {
				talvezero = "0";
			}
			else if (minuto < 10) {
				outrozero = "0";
			}
			
			String horario = dia + "/" + mes + "/" + ano + " - " + hora + ":" + outrozero + minuto + talvezero;
			
			JButton btnNewButton = new JButton(horario);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int result = JOptionPane.showConfirmDialog(frame,"Deseja marcar a consulta para esta data e horário?\n" + horario, "Confirmação de Horário",
				               JOptionPane.YES_NO_OPTION,
				               JOptionPane.QUESTION_MESSAGE);
				            if(result == JOptionPane.YES_OPTION){
				            	
				            	sistema.agendarConsulta(medico, paciente, dh);
				            	JOptionPane.showMessageDialog(null, "Consulta marcada com sucesso!");
				            	TelaInicial tela = new TelaInicial(sistema);
				            	tela.start(sistema);
				            	frame.dispose();
				            	
				            }
				            else if (result == JOptionPane.NO_OPTION){
				            	
				            }
				            else {
				            	
				            }
					
				}
			});
			btnNewButton.setBounds(411, espaco, 200, 30);
			espaco += 40;
			frame.getContentPane().add(btnNewButton);
		}
		
		btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaSelecaoPaciente tela = new TelaSelecaoPaciente(sistema, medico, false);
				tela.start(sistema, medico, false);
				
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_1.setBounds(78, 547, 166, 48);
		frame.getContentPane().add(btnNewButton_1);

	}

}
