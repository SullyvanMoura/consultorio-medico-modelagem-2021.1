package Tela;

import Sistema.Sistema;
import Sistema.Medico;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Sistema.Paciente;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class TelaListarTodosPacientes {
	
	private Sistema sistema;
	private Medico medico;
	private boolean atualizar;
	private JFrame frame;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	
	public void start(Sistema sistema, Medico medico, boolean atualizar) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarTodosPacientes window = new TelaListarTodosPacientes(sistema, medico, atualizar);
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
	public TelaListarTodosPacientes(Sistema sistema, Medico medico,boolean atualizar) {
		this.sistema = sistema;
		this.medico = medico;
		this.atualizar = atualizar;
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

		for (Paciente pas : medico.getPacientes()) {
			
			if (atualizar && pas.getFicha() != null) {
				JButton btnNewButton = new JButton(pas.getNome());
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if (atualizar) {
							TelaAtualizarFicha tela = new TelaAtualizarFicha(sistema, medico, pas);
							tela.start(sistema, medico, pas);
							
							frame.dispose();
						}
						else {
							TelaCriaFicha tela = new TelaCriaFicha(sistema, medico, pas);
							tela.start(sistema, medico, pas);
							
							frame.dispose();
						}
						
					}
				});
				btnNewButton.setBounds(387, espaco, 250, 40);
				espaco += 50;
				frame.getContentPane().add(btnNewButton);
			}
			
			else if (!atualizar && pas.getFicha() == null) {
				JButton btnNewButton = new JButton(pas.getNome());
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if (atualizar) {
							TelaAtualizarFicha tela = new TelaAtualizarFicha(sistema, medico, pas);
							tela.start(sistema, medico, pas);
							
							frame.dispose();
						}
						else {
							TelaCriaFicha tela = new TelaCriaFicha(sistema, medico, pas);
							tela.start(sistema, medico, pas);
							
							frame.dispose();
						}
						
					}
				});
				btnNewButton.setBounds(387, espaco, 250, 40);
				espaco += 50;
				frame.getContentPane().add(btnNewButton);
			}
			
			
		}
		
		btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaListaMedicosParaFicha tela = new TelaListaMedicosParaFicha(sistema, atualizar);
				tela.start(sistema, atualizar);
				
				frame.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_2.setBounds(78, 547, 166, 48);
		frame.getContentPane().add(btnNewButton_2);
		
	}
}
