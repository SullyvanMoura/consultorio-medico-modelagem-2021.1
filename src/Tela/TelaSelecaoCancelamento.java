package Tela;

import Sistema.Sistema;
import Sistema.DataHora;
import Sistema.Medico;
import Sistema.Paciente;
import Sistema.Consulta;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class TelaSelecaoCancelamento {
	
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
					TelaSelecaoCancelamento window = new TelaSelecaoCancelamento(sistema, medico, paciente);
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
	public TelaSelecaoCancelamento(Sistema sistema, Medico medico, Paciente paciente) {
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
		
		for (Consulta con : paciente.getConsultas()) {
			DataHora dh = con.getDiaHorario();
			
			
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
					
					int result = JOptionPane.showConfirmDialog(frame,"Deseja cancelar a consulta desta data e horário?\n" + horario, "Confirmação",
				               JOptionPane.YES_NO_OPTION,
				               JOptionPane.QUESTION_MESSAGE);
				            if(result == JOptionPane.YES_OPTION){
				            	sistema.cancelarConsulta(medico, paciente, dh);
				            	JOptionPane.showMessageDialog(null, "Consulta cancelada com sucesso!");
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
				
				TelaSelecaoPaciente tela = new TelaSelecaoPaciente(sistema, medico, true);
				tela.start(sistema, medico, true);
				
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_1.setBounds(78, 547, 166, 48);
		frame.getContentPane().add(btnNewButton_1);
		
	}

}
