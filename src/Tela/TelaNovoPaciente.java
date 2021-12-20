package Tela;

import Sistema.Sistema;
import Sistema.Medico;
import Sistema.Paciente;
import Sistema.Email;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaNovoPaciente {
	
	private Sistema sistema;
	private Medico medico;
	private JFrame frmCadastroDeNovo;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtTelefone;

	/**
	 * Launch the application.
	 */
	
	public void start(Sistema sistema, Medico medico) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaNovoPaciente window = new TelaNovoPaciente(sistema, medico);
					window.frmCadastroDeNovo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public TelaNovoPaciente(Sistema sistema, Medico medico) {
		this.sistema = sistema;
		this.medico = medico;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeNovo = new JFrame();
		frmCadastroDeNovo.setTitle("Cadastro de Novo Paciente");
		frmCadastroDeNovo.getContentPane().setFont(new Font("Arial", Font.BOLD, 16));
		frmCadastroDeNovo.setBounds(171, 34, 1024, 700);
		frmCadastroDeNovo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeNovo.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome: ");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(54, 103, 103, 20);
		frmCadastroDeNovo.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email: ");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(54, 250, 103, 20);
		frmCadastroDeNovo.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telefone:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_2.setBounds(54, 401, 103, 20);
		frmCadastroDeNovo.getContentPane().add(lblNewLabel_2);
		
		txtNome = new JTextField();
		txtNome.setBounds(54, 134, 323, 20);
		frmCadastroDeNovo.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(54, 281, 323, 20);
		frmCadastroDeNovo.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(54, 432, 323, 20);
		frmCadastroDeNovo.getContentPane().add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Insira os Dados do Paciente:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_3.setBounds(260, 21, 293, 41);
		frmCadastroDeNovo.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Paciente novoPaciente = medico.criarPaciente(txtNome.getText(), new Email(txtEmail.getText()), txtTelefone.getText());
				
				TelaSelecaoHorario tela = new TelaSelecaoHorario(sistema, medico ,novoPaciente);
				tela.start(sistema, medico, novoPaciente);
				frmCadastroDeNovo.dispose();
				
				
				
			}
		});
		btnNewButton.setBounds(605, 505, 121, 32);
		frmCadastroDeNovo.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaSelecaoMedico tela = new TelaSelecaoMedico(sistema, false);
				tela.start(sistema, false);
				
				frmCadastroDeNovo.dispose();
				
			}
		});
		btnNewButton_1.setBounds(54, 505, 110, 32);
		frmCadastroDeNovo.getContentPane().add(btnNewButton_1);
	}
}
