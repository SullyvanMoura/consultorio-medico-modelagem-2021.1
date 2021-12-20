package Tela;

import Sistema.Sistema;
import Sistema.Medico;
import Sistema.Paciente;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaSelecaoPaciente {
	
	private Sistema sistema;
	private Medico medico;
	private boolean cancelar;
	private JFrame frame;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	
	public void start(Sistema sistema, Medico medico, boolean cancelar) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSelecaoPaciente window = new TelaSelecaoPaciente(sistema, medico, cancelar);
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
	public TelaSelecaoPaciente(Sistema sistema, Medico medico, boolean cancelar) {
		this.sistema = sistema;
		this.medico = medico;
		this.cancelar = cancelar;
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
		
		JLabel lblNewLabel = new JLabel("Selecione o paciente:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel.setBounds(330, 30, 363, 57);
		frame.getContentPane().add(lblNewLabel);
		
		int espaco = 100;
		
		if (!cancelar) {
			JButton btnNewButton = new JButton("Cadastrar Paciente");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					TelaNovoPaciente tela = new TelaNovoPaciente(sistema, medico);
					tela.start(sistema, medico);
					
					frame.dispose();
					
				}
			});
			btnNewButton.setBounds(387, espaco, 250, 40);
			espaco += 50;
			frame.getContentPane().add(btnNewButton);
		}
		
		for (Paciente pas : medico.getPacientes()) {
			
			JButton btnNewButton = new JButton(pas.getNome());
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if (cancelar) {
						TelaSelecaoCancelamento tela = new TelaSelecaoCancelamento(sistema, medico, pas);
						tela.start(sistema, medico, pas);
					}
					else {
						TelaSelecaoHorario tela = new TelaSelecaoHorario(sistema, medico, pas);
						tela.start(sistema, medico, pas);
					}
					
					frame.dispose();
					
				}
			});
			btnNewButton.setBounds(387, espaco, 250, 40);
			espaco += 50;
			frame.getContentPane().add(btnNewButton);
		}
		

		
		btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaSelecaoMedico tela = new TelaSelecaoMedico(sistema,cancelar);
				tela.start(sistema, cancelar);
				
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_1.setBounds(78, 547, 166, 48);
		frame.getContentPane().add(btnNewButton_1);
		
	}
}
