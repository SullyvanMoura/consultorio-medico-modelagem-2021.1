package Tela;

import Sistema.Medico;
import Sistema.Sistema;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TelaSelecaoMedico {

	private Sistema sistema;
	private boolean cancelar;
	private JButton btnNewButton_1;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	
	public void start(Sistema sistema, boolean cancelar) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSelecaoMedico window = new TelaSelecaoMedico(sistema, cancelar);
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
	
	public TelaSelecaoMedico(Sistema sistema, boolean cancelar) {
		this.sistema = sistema;
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
		
		JLabel lblNewLabel = new JLabel("Selecione o m\u00E9dico:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel.setBounds(357, 30, 310, 57);
		frame.getContentPane().add(lblNewLabel);
		int espaco = 100;
		
		for (Medico med : sistema.getConsultorios().get(0).getMedicos()) {
			
			JButton btnNewButton = new JButton(med.getNome());
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
						TelaSelecaoPaciente tela = new TelaSelecaoPaciente(sistema, med, cancelar);
						tela.start(sistema, med, cancelar);
						
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
				
				TelaInicial tela = new TelaInicial(sistema);
				tela.start(sistema);
				
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_1.setBounds(78, 547, 166, 48);
		frame.getContentPane().add(btnNewButton_1);
		
	}
}
