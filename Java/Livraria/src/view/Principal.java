package view;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblData;
	public JButton btnUsuarios;
	public JButton btnRelatorios;
	public JPanel panelUsuario;
	public JLabel lblUsuario;
	public JButton btnFornecedores;
	public JButton btnClientes;
	public JButton btnProdutos;
	//atribuir uma variavel publica.

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		addWindowListener(new WindowAdapter() {
			// Evento ativar janela 
			@Override
			public void windowActivated(WindowEvent e) {
				Date data = new Date ();
				DateFormat formatador =
						DateFormat.getDateInstance(DateFormat.FULL);
				lblData.setText(formatador.format(data));
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/favicon.png")));
		setResizable(false);
		setTitle("P R I N C I P A L");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsuario = new JLabel("New label");
		lblUsuario.setBounds(148, 345, 128, 72);
		contentPane.add(lblUsuario);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/img/logo.png")));
		lblNewLabel.setBounds(10, 289, 128, 128);
		contentPane.add(lblNewLabel);
		
		btnUsuarios = new JButton("");
		btnUsuarios.setEnabled(false);
		btnUsuarios.addActionListener(new ActionListener() {
			//evento clicar no bot�o (usuarios)
			public void actionPerformed(ActionEvent e) {
				//link para o JDialog
				Usuarios usuarios = new Usuarios();
				usuarios.setVisible(true);
				//habilitar o modal no c�gido de (Usuarios) para n�o abrir mais de uma janela
			}
		});
		btnUsuarios.setIcon(new ImageIcon(Principal.class.getResource("/img/users.png")));
		btnUsuarios.setToolTipText("Usu\u00E1rios");
		btnUsuarios.setBounds(10, 11, 128, 128);
		contentPane.add(btnUsuarios);
		
		btnFornecedores = new JButton("");
		btnFornecedores.setEnabled(false);
		btnFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setVisible(true);
			}
		});
		btnFornecedores.setToolTipText("Fornecedores");
		btnFornecedores.setIcon(new ImageIcon(Principal.class.getResource("/img/fornecedores.png")));
		btnFornecedores.setBounds(148, 11, 128, 128);
		contentPane.add(btnFornecedores);
		
		btnProdutos = new JButton("");
		btnProdutos.setEnabled(false);
		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produtos produtos = new Produtos();
				produtos.setVisible(true);
			}
		});
		btnProdutos.setToolTipText("Produtos");
		btnProdutos.setIcon(new ImageIcon(Principal.class.getResource("/img/produto.png")));
		btnProdutos.setBounds(286, 11, 128, 128);
		contentPane.add(btnProdutos);
		
		btnClientes = new JButton("");
		btnClientes.setEnabled(false);
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes clientes = new Clientes();
				clientes.setVisible(true);
			}
		});
		btnClientes.setToolTipText("Clientes");
		btnClientes.setIcon(new ImageIcon(Principal.class.getResource("/img/clientes.png")));
		btnClientes.setBounds(424, 11, 128, 128);
		contentPane.add(btnClientes);
		
		btnRelatorios = new JButton("");
		btnRelatorios.setEnabled(false);
		btnRelatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorios relatorios = new Relatorios();
				relatorios.setVisible(true);
			}
		});
		btnRelatorios.setToolTipText("Relat\u00F3rios");
		btnRelatorios.setIcon(new ImageIcon(Principal.class.getResource("/img/relatorios.png")));
		btnRelatorios.setBounds(10, 150, 128, 128);
		contentPane.add(btnRelatorios);
		
		JButton btnNewButton_1_4 = new JButton("");
		btnNewButton_1_4.setEnabled(false);
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pdv pdv = new Pdv();
				pdv.setVisible(true);
			}
		});
		btnNewButton_1_4.setToolTipText("PDV");
		btnNewButton_1_4.setIcon(new ImageIcon(Principal.class.getResource("/img/pdv.png")));
		btnNewButton_1_4.setBounds(148, 150, 128, 128);
		contentPane.add(btnNewButton_1_4);
		
		JButton btnNewButton_1_5 = new JButton("");
		btnNewButton_1_5.setEnabled(false);
		btnNewButton_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ferramentas ferramenta = new Ferramentas();
				ferramenta.setVisible(true);
			}
		});
		btnNewButton_1_5.setToolTipText("Ferramentas");
		btnNewButton_1_5.setIcon(new ImageIcon(Principal.class.getResource("/img/ferramentas.png")));
		btnNewButton_1_5.setBounds(286, 150, 128, 128);
		contentPane.add(btnNewButton_1_5);
		
		JButton btnNewButton_1_6 = new JButton("");
		btnNewButton_1_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnNewButton_1_6.setToolTipText("Sobre");
		btnNewButton_1_6.setIcon(new ImageIcon(Principal.class.getResource("/img/sobre.png")));
		btnNewButton_1_6.setBounds(424, 150, 128, 128);
		contentPane.add(btnNewButton_1_6);
		
		panelUsuario = new JPanel();
		panelUsuario.setBackground(SystemColor.textHighlight);
		panelUsuario.setBounds(10, 345, 542, 72);
		contentPane.add(panelUsuario);
		panelUsuario.setLayout(null);
		
		lblData = new JLabel("New label");
		lblData.setBounds(285, 0, 257, 72);
		panelUsuario.add(lblData);
	}
}
