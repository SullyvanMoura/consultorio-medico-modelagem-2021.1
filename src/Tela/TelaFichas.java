package Tela;

import Sistema.Sistema;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;

public class TelaFichas {
	
	private Sistema sistema;
	private JFrame frame;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	
	public void start(Sistema sistema) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFichas window = new TelaFichas(sistema);
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
	public TelaFichas(Sistema sistema) {
		this.sistema = sistema;
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
		
		JButton btnNewButton = new JButton("Criar Ficha Para Paciente");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaListaMedicosParaFicha tela = new TelaListaMedicosParaFicha(sistema, false);
				tela.start(sistema, false);
				
				frame.dispose();
				
			}
		});
		btnNewButton.setBounds(362, 200, 300, 100);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ver/Atualizar uma Ficha");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaListaMedicosParaFicha tela = new TelaListaMedicosParaFicha(sistema, true);
				tela.start(sistema, true);
				
				frame.dispose();
				
			}
		});
		btnNewButton_1.setBounds(362, 327, 300, 100);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Seleciona uma das op\u00E7\u00F5es:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel.setBounds(297, 50, 431, 74);
		frame.getContentPane().add(lblNewLabel);
		
		btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaInicial tela = new TelaInicial(sistema);
				tela.start(sistema);
				
				frame.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_2.setBounds(78, 547, 166, 48);
		frame.getContentPane().add(btnNewButton_2);
		
	}

}
