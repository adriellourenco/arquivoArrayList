package br.senai.sp.jandira.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.senai.sp.jandira.model.Arquivo;
import br.senai.sp.jandira.model.Contato;
import br.senai.sp.jandira.repository.ContatoRepository;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameArquivoArrayList extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField textTelefone;
	private JTextField txtCidade;
	private JLabel lblCadastroDeContatos;

	//Atributos referentes a Criação/Gravação de Contatos
	Contato objContato = null;
	ContatoRepository objContatoRepository = null;
	Arquivo objArquivo = null;

	public FrameArquivoArrayList() {
		
		objContato = new Contato();
		objContatoRepository = new ContatoRepository();
		objArquivo = new Arquivo();
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setBounds(25, 79, 57, 20);
		contentPane.add(lblNome); 
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(25, 116, 57, 14);
		contentPane.add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefone.setBounds(25, 156, 57, 14);
		contentPane.add(lblTelefone);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCidade.setBounds(25, 195, 57, 14);
		contentPane.add(lblCidade);
		
		txtNome = new JTextField();
		txtNome.setBounds(92, 80, 300, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(92, 114, 300, 20);
		contentPane.add(txtEmail);
		
		textTelefone = new JTextField();
		textTelefone.setColumns(10);
		textTelefone.setBounds(92, 154, 300, 20);
		contentPane.add(textTelefone);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(92, 193, 300, 20);
		contentPane.add(txtCidade);
		
		lblCadastroDeContatos = new JLabel("Cadastro de Contatos");
		lblCadastroDeContatos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCadastroDeContatos.setBounds(25, 11, 220, 29);
		contentPane.add(lblCadastroDeContatos);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			//Ação do Botão Cadastrar
				//Captura dos dados para o Objeto Contato
				objContato.setNome(txtNome.getText());
				objContato.setEmail(txtEmail.getText());
				objContato.setTelefone(textTelefone.getText());
				objContato.setCidade(txtCidade.getText());
				
				//Preparação dos dados para a Gravação no Arquivo txt
				String texto = objContato.getNome() + ";" 
						+ objContato.getEmail() + ";" 
						+ objContato.getTelefone() + ";"
						+ objContato.getCidade() + "\n";
				
				//Gravação dos Dados no Arquivo txt
				String caminho = "C:\\Users\\21276092\\Desktop\\CONTATO\\contatos.txt";
				objArquivo.escrever(caminho, texto);
			
			}
		});
		btnCadastrar.setBounds(154, 241, 120, 50);
		contentPane.add(btnCadastrar);
	}
}
