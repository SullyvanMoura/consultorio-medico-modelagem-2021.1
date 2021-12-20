package Tela;

import Sistema.Sistema;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;

public class TelaLogin {
	
	private Sistema sistema;
	private JFrame frame;
	private JTextField txtlogin;
	private JPasswordField txtsenha;

	/**
	 * Launch the application.
	 */
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void start(Sistema sistema) {
		this.sistema = sistema;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin(sistema);
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
	public TelaLogin(Sistema sistema) {
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
		
		JButton btnNewButton = new JButton("Novo Cadastro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaCadastro tela = new TelaCadastro(sistema);
				tela.start(sistema);
				frame.dispose();
				
			}
		});
		btnNewButton.setBounds(40, 272, 133, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(40, 45, 56, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(40, 155, 76, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtlogin = new JTextField();
		txtlogin.setBounds(40, 79, 247, 20);
		frame.getContentPane().add(txtlogin);
		txtlogin.setColumns(10);
		
		txtsenha = new JPasswordField();
		txtsenha.setBounds(40, 180, 247, 20);
		frame.getContentPane().add(txtsenha);
		
		JButton btnNewButton_1 = new JButton("Entrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user = txtlogin.getText();
				String senha = txtsenha.getText();
				
				if (user.contains("Consultorio1") && senha.contains("1234")) {
					
					TelaInicial tela = new TelaInicial(sistema);
					tela.start(sistema);
					frame.dispose();
					
				}
				else if (user.contains("DrAlmeida") && senha.contains("1234")) {
					
					TelaInicial tela = new TelaInicial(sistema);
					tela.start(sistema);
					frame.dispose();
				}
				//else if (user.contains("") && senha.contains("")) {
					
				//	TelaInicial tela = new TelaInicial(sistema);
				//	tela.start(sistema);
				//	frame.dispose();
				//}
				else {
					JOptionPane.showMessageDialog(null, "Login ou senha inválidos!");
				}
				
			}
		});
		btnNewButton_1.setBounds(258, 272, 95, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaMedicoOUConsultorio tela = new TelaMedicoOUConsultorio(sistema);
				tela.start(sistema);
				frame.dispose();
				
			}
		});
		btnNewButton_2.setBounds(40, 306, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
}
