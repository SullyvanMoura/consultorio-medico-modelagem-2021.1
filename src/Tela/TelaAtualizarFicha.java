package Tela;

import Sistema.Sistema;
import Sistema.Medico;
import Sistema.Paciente;
import Sistema.EstadoCivil;
import Sistema.CPF;
import Sistema.DataHora;
import Sistema.Convenio;
import Sistema.Endereco;
import Sistema.Email;
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

public class TelaAtualizarFicha {
	
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
	private JTextField txtxNome;
	private JTextField txtTelefone;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	
	public void start(Sistema sistema, Medico medico, Paciente paciente) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizarFicha window = new TelaAtualizarFicha(sistema, medico, paciente);
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
	public TelaAtualizarFicha(Sistema sistema, Medico medico, Paciente paciente) {
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
		txtCPF.setText(paciente.getFicha().getCpf().getCpf());
		txtCPF.setToolTipText("Apenas os n\u00FAmeros, sem pontos. ex.: 12345678911");
		txtCPF.setBounds(86, 241, 178, 20);
		frame.getContentPane().add(txtCPF);
		txtCPF.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(86, 210, 109, 20);
		frame.getContentPane().add(lblNewLabel);
		
		txtDiaNascimento = new JTextField();
		txtDiaNascimento.setText(String.valueOf(paciente.getFicha().getDataNascimento().getDia()));
		txtDiaNascimento.setToolTipText("");
		txtDiaNascimento.setColumns(10);
		txtDiaNascimento.setBounds(86, 322, 29, 20);
		frame.getContentPane().add(txtDiaNascimento);
		
		JLabel lblDataDeNacimento = new JLabel("Data de Nacimento");
		lblDataDeNacimento.setToolTipText("");
		lblDataDeNacimento.setFont(new Font("Arial", Font.BOLD, 16));
		lblDataDeNacimento.setBounds(86, 291, 178, 20);
		frame.getContentPane().add(lblDataDeNacimento);
		
		txtCep = new JTextField();
		txtCep.setToolTipText("Apenas os n\u00FAmeros, sem pontos");
		txtCep.setText(paciente.getFicha().getEndereco().getCep());
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
		txtNomeConvenio.setText(paciente.getFicha().getConvenio().getConvenio());
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
		comboBox.setSelectedItem(paciente.getFicha().getEstadoCivil());
		frame.getContentPane().add(comboBox);  	
		
		txtEstado = new JTextField();
		txtEstado.setText(paciente.getFicha().getEndereco().getEstado());
		txtEstado.setColumns(10);
		txtEstado.setBounds(755, 199, 178, 20);
		frame.getContentPane().add(txtEstado);
		
		txtRua = new JTextField();
		txtRua.setText(paciente.getFicha().getEndereco().getRua());
		txtRua.setColumns(10);
		txtRua.setBounds(755, 291, 178, 20);
		frame.getContentPane().add(txtRua);
		
		txtBairro = new JTextField();
		txtBairro.setText(paciente.getFicha().getEndereco().getBairro());
		txtBairro.setColumns(10);
		txtBairro.setBounds(755, 241, 178, 20);
		frame.getContentPane().add(txtBairro);
		
		txtMatriculaConvenio = new JTextField();
		txtMatriculaConvenio.setText(paciente.getFicha().getConvenio().getMatricula());
		txtMatriculaConvenio.setToolTipText("apenas os n\u00FAmero, sem pontos");
		txtMatriculaConvenio.setColumns(10);
		txtMatriculaConvenio.setBounds(404, 284, 178, 20);
		frame.getContentPane().add(txtMatriculaConvenio);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro de Nova Ficha");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_1.setBounds(322, 34, 380, 48);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Atualizar Ficha");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = txtxNome.getText();
				Email email = new Email(txtEmail.getText());
				String telefone = txtTelefone.getText();
				
				medico.atualizarPaciente(paciente, nome, email, telefone);
				
				CPF cpf = new CPF(txtCPF.getText());
				DataHora dataNasc = new DataHora(Integer.valueOf(txtDiaNascimento.getText()),
						Integer.valueOf(txtMesNascimento.getText()),Integer.valueOf(txtAnoNascimento.getText()));
				Endereco endereco = new Endereco(txtRua.getText(), txtNumero.getText(), txtBairro.getText(), txtEstado.getText(), txtCep.getText());
				EstadoCivil estado = (EstadoCivil) comboBox.getSelectedItem();
				Convenio convenio = new Convenio(txtNomeConvenio.getText(), txtMatriculaConvenio.getText());
						
				sistema.criarFichaPaciente(paciente, cpf, dataNasc, endereco, estado, convenio);
				
				JOptionPane.showMessageDialog(null, "Ficha Atualizada com Sucesso!");
				
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
				
				TelaListarTodosPacientes tela = new TelaListarTodosPacientes(sistema, medico, true);
				tela.start(sistema, medico,true);
				
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_1.setBounds(78, 547, 166, 48);
		frame.getContentPane().add(btnNewButton_1);
		
		txtMesNascimento = new JTextField();
		txtMesNascimento.setText(String.valueOf(paciente.getFicha().getDataNascimento().getMes()));
		txtMesNascimento.setBounds(125, 322, 29, 20);
		frame.getContentPane().add(txtMesNascimento);
		txtMesNascimento.setColumns(10);
		
		txtAnoNascimento = new JTextField();
		txtAnoNascimento.setText(String.valueOf(paciente.getFicha().getDataNascimento().getAno()));
		txtAnoNascimento.setBounds(164, 322, 47, 20);
		frame.getContentPane().add(txtAnoNascimento);
		txtAnoNascimento.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setText(paciente.getFicha().getEndereco().getNumero());
		txtNumero.setColumns(10);
		txtNumero.setBounds(755, 342, 178, 20);
		frame.getContentPane().add(txtNumero);
		
		txtxNome = new JTextField();
		txtxNome.setText(paciente.getNome());
		txtxNome.setToolTipText("Apenas os n\u00FAmeros, sem pontos. ex.: 12345678911");
		txtxNome.setColumns(10);
		txtxNome.setBounds(86, 151, 178, 20);
		frame.getContentPane().add(txtxNome);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.BOLD, 16));
		lblNome.setBounds(86, 120, 109, 20);
		frame.getContentPane().add(lblNome);
		
		txtTelefone = new JTextField();
		txtTelefone.setText(paciente.getTelefone());
		txtTelefone.setToolTipText("Apenas os n\u00FAmeros, sem pontos. ex.: 12345678911");
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(86, 405, 178, 20);
		frame.getContentPane().add(txtTelefone);
		
		JLabel lblTelefone = new JLabel("Telefone: ");
		lblTelefone.setFont(new Font("Arial", Font.BOLD, 16));
		lblTelefone.setBounds(86, 374, 109, 20);
		frame.getContentPane().add(lblTelefone);
		
		txtEmail = new JTextField();
		txtEmail.setText(paciente.getEmail().getEmail());
		txtEmail.setToolTipText("Apenas os n\u00FAmeros, sem pontos. ex.: 12345678911");
		txtEmail.setColumns(10);
		txtEmail.setBounds(86, 486, 178, 20);
		frame.getContentPane().add(txtEmail);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 16));
		lblEmail.setBounds(86, 455, 109, 20);
		frame.getContentPane().add(lblEmail);
	}
}
