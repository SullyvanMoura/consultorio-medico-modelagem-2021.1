package Tela;

import Sistema.Medico;
import Sistema.Sistema;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaListaMedicosParaFicha {
	
	private Sistema sistema;
	private boolean atualizar;
	private JFrame frame;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	
	public void start(Sistema sistema, boolean atualizar) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaMedicosParaFicha window = new TelaListaMedicosParaFicha(sistema, atualizar);
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
	public TelaListaMedicosParaFicha(Sistema sistema, boolean atualizar) {
		this.sistema = sistema;
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

		JLabel lblNewLabel = new JLabel("Selecione o M\u00E9dico:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel.setBounds(357, 30, 363, 57);
		frame.getContentPane().add(lblNewLabel);
		
		int espaco = 100;
		
		for (Medico med : sistema.getConsultorios().get(0).getMedicos()) {
			
			JButton btnNewButton = new JButton(med.getNome());
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
						TelaListarTodosPacientes tela = new TelaListarTodosPacientes(sistema, med, atualizar);
						tela.start(sistema, med, atualizar);
						
						frame.dispose();

					
				}
			});
			btnNewButton.setBounds(387, espaco, 250, 40);
			espaco += 50;
			frame.getContentPane().add(btnNewButton);
		}
		
		btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaFichas tela = new TelaFichas(sistema);
				tela.start(sistema);
				
				frame.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_2.setBounds(78, 547, 166, 48);
		frame.getContentPane().add(btnNewButton_2);
		
	}

}
