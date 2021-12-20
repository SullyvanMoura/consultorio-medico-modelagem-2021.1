
package Tela;

import Sistema.Sistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaMedicoOUConsultorio {

	private Sistema sistema;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	
	public void start(Sistema sistema) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMedicoOUConsultorio window = new TelaMedicoOUConsultorio(sistema);
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
	public TelaMedicoOUConsultorio(Sistema sistema) {
		this.sistema = sistema;

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(483, 184, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escolha o Tipo de Login: ");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(63, 11, 276, 87);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("M\u00E9dico");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaLogin tela = new TelaLogin(sistema);
				tela.start(sistema);
				
				frame.dispose();
				
			}
		});
		btnNewButton.setBounds(126, 131, 126, 43);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Consult\u00F3rio");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaLogin tela = new TelaLogin(sistema);
				tela.start(sistema);
				
				frame.dispose();
				
			}
		});
		btnNewButton_1.setBounds(126, 222, 126, 50);
		frame.getContentPane().add(btnNewButton_1);
	}

}
