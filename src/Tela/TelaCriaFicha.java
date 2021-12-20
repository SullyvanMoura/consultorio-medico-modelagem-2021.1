package Tela;

import Sistema.Sistema;
import Sistema.Medico;
import Sistema.Paciente;
import Sistema.EstadoCivil;
import Sistema.CPF;
import Sistema.DataHora;
import Sistema.Convenio;
import Sistema.Endereco;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCriaFicha {
	
	private Sistema sistema;
	private Medico medico;
	private Paciente paciente;
	private JFrame frame;
	private JTextField txtCPF;
	private JTextField txtDiaNascimento;
	private JTextField txtCep;
	private JTextField txtNomeConvenio;
	private JTextField txtEstado;
	private JTextField txtRua;
	private JTextField txtBairro;
	private JTextField txtMatriculaConvenio;
	private JButton btnNewButton_1;
	private JTextField txtMesNascimento;
	private JTextField txtAnoNascimento;
	private JTextField txtNumero;

	/**
	 * Launch the application.
	 */
	
	public void start(Sistema sistema, Medico medico, Paciente paciente) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCriaFicha window = new TelaCriaFicha(sistema, medico, paciente);
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
	public TelaCriaFicha(Sistema sistema, Medico medico, Paciente paciente) {
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
		
		txtCPF = new JTextField();
		txtCPF.setToolTipText("Apenas os n\u00FAmeros, sem pontos. ex.: 12345678911");
		txtCPF.setBounds(78, 151, 178, 20);
		frame.getContentPane().add(txtCPF);
		txtCPF.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(78, 120, 109, 20);
		frame.getContentPane().add(lblNewLabel);
		
		txtDiaNascimento = new JTextField();
		txtDiaNascimento.setText("DIA");
		txtDiaNascimento.setToolTipText("");
		txtDiaNascimento.setColumns(10);
		txtDiaNascimento.setBounds(78, 241, 29, 20);
		frame.getContentPane().add(txtDiaNascimento);
		
		JLabel lblDataDeNacimento = new JLabel("Data de Nacimento");
		lblDataDeNacimento.setToolTipText("");
		lblDataDeNacimento.setFont(new Font("Arial", Font.BOLD, 16));
		lblDataDeNacimento.setBounds(78, 210, 178, 20);
		frame.getContentPane().add(lblDataDeNacimento);
		
		txtCep = new JTextField();
		txtCep.setToolTipText("Apenas os n\u00FAmeros, sem pontos");
		txtCep.setText("CEP");
		txtCep.setColumns(10);
		txtCep.setBounds(755, 151, 178, 20);
		frame.getContentPane().add(txtCep);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setFont(new Font("Arial", Font.BOLD, 16));
		lblEndereo.setBounds(755, 120, 109, 20);
		frame.getContentPane().add(lblEndereo);
		
		JLabel lblEstadoCivil = new JLabel("Estado Civil:");
		lblEstadoCivil.setFont(new Font("Arial", Font.BOLD, 16));
		lblEstadoCivil.setBounds(404, 120, 109, 20);
		frame.getContentPane().add(lblEstadoCivil);
		
		txtNomeConvenio = new JTextField();
		txtNomeConvenio.setText("NOME DE CONV\u00CANIO");
		txtNomeConvenio.setColumns(10);
		txtNomeConvenio.setBounds(404, 241, 178, 20);
		frame.getContentPane().add(txtNomeConvenio);
		
		JLabel lblNomeDoConvnio = new JLabel("Conv\u00EAnio:");
		lblNomeDoConvnio.setFont(new Font("Arial", Font.BOLD, 16));
		lblNomeDoConvnio.setBounds(404, 210, 178, 20);
		frame.getContentPane().add(lblNomeDoConvnio);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(404, 151, 178, 22);
		comboBox.addItem(EstadoCivil.SOLTEIRO);
		comboBox.addItem(EstadoCivil.CASADO);
		comboBox.addItem(EstadoCivil.DIVORCIADO);
		comboBox.addItem(EstadoCivil.VIUVO);
		frame.getContentPane().add(comboBox);  	
		
		txtEstado = new JTextField();
		txtEstado.setText("ESTADO");
		txtEstado.setColumns(10);
		txtEstado.setBounds(755, 199, 178, 20);
		frame.getContentPane().add(txtEstado);
		
		txtRua = new JTextField();
		txtRua.setText("RUA");
		txtRua.setColumns(10);
		txtRua.setBounds(755, 291, 178, 20);
		frame.getContentPane().add(txtRua);
		
		txtBairro = new JTextField();
		txtBairro.setText("BAIRRO");
		txtBairro.setColumns(10);
		txtBairro.setBounds(755, 241, 178, 20);
		frame.getContentPane().add(txtBairro);
		
		txtMatriculaConvenio = new JTextField();
		txtMatriculaConvenio.setText("MATR\u00CDCULA");
		txtMatriculaConvenio.setToolTipText("apenas os n\u00FAmero, sem pontos");
		txtMatriculaConvenio.setColumns(10);
		txtMatriculaConvenio.setBounds(404, 284, 178, 20);
		frame.getContentPane().add(txtMatriculaConvenio);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro de Nova Ficha");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_1.setBounds(322, 34, 380, 48);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Criar Ficha");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CPF cpf = new CPF(txtCPF.getText());
				DataHora dataNasc = new DataHora(Integer.valueOf(txtDiaNascimento.getText()),
						Integer.valueOf(txtMesNascimento.getText()),Integer.valueOf(txtAnoNascimento.getText()));
				Endereco endereco = new Endereco(txtRua.getText(), txtNumero.getText(), txtBairro.getText(), txtEstado.getText(), txtCep.getText());
				EstadoCivil estado = (EstadoCivil) comboBox.getSelectedItem();
				Convenio convenio = new Convenio(txtNomeConvenio.getText(), txtMatriculaConvenio.getText());
						
				sistema.criarFichaPaciente(paciente, cpf, dataNasc, endereco, estado, convenio);
				
				JOptionPane.showMessageDialog(null, "Ficha Criada com Sucesso!");
				
				TelaInicial tela = new TelaInicial(sistema);
				tela.start(sistema);

				frame.dispose();
			}
		});
		btnNewButton.setBounds(767, 547, 166, 48);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaListarTodosPacientes tela = new TelaListarTodosPacientes(sistema, medico, false);
				tela.start(sistema, medico, false);
				
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_1.setBounds(78, 547, 166, 48);
		frame.getContentPane().add(btnNewButton_1);
		
		txtMesNascimento = new JTextField();
		txtMesNascimento.setText("M\u00CAS");
		txtMesNascimento.setBounds(117, 241, 29, 20);
		frame.getContentPane().add(txtMesNascimento);
		txtMesNascimento.setColumns(10);
		
		txtAnoNascimento = new JTextField();
		txtAnoNascimento.setText("ANO");
		txtAnoNascimento.setBounds(156, 241, 47, 20);
		frame.getContentPane().add(txtAnoNascimento);
		txtAnoNascimento.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setText("NUMERO");
		txtNumero.setColumns(10);
		txtNumero.setBounds(755, 342, 178, 20);
		frame.getContentPane().add(txtNumero);
	}
}
