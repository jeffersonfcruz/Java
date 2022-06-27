package view;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblData;

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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/img/logo.png")));
		lblNewLabel.setBounds(10, 289, 128, 128);
		contentPane.add(lblNewLabel);
		
		lblData = new JLabel("New label");
		lblData.setBounds(286, 362, 266, 40);
		contentPane.add(lblData);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			//evento clicar no botão (usuarios)
			public void actionPerformed(ActionEvent e) {
				//link para o JDialog
				Usuarios usuarios = new Usuarios();
				usuarios.setVisible(true);
				//habilitar o modal no cógido de (Usuarios) para não abrir mais de uma janela
			}
		});
		btnNewButton.setIcon(new ImageIcon(Principal.class.getResource("/img/users.png")));
		btnNewButton.setToolTipText("Usu\u00E1rios");
		btnNewButton.setBounds(10, 11, 128, 128);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setVisible(true);
			}
		});
		btnNewButton_1.setToolTipText("Fornecedores");
		btnNewButton_1.setIcon(new ImageIcon(Principal.class.getResource("/img/fornecedores.png")));
		btnNewButton_1.setBounds(148, 11, 128, 128);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produtos produtos = new Produtos();
				produtos.setVisible(true);
			}
		});
		btnNewButton_1_1.setToolTipText("Produtos");
		btnNewButton_1_1.setIcon(new ImageIcon(Principal.class.getResource("/img/produto.png")));
		btnNewButton_1_1.setBounds(286, 11, 128, 128);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes clientes = new Clientes();
				clientes.setVisible(true);
			}
		});
		btnNewButton_1_2.setToolTipText("Clientes");
		btnNewButton_1_2.setIcon(new ImageIcon(Principal.class.getResource("/img/clientes.png")));
		btnNewButton_1_2.setBounds(424, 11, 128, 128);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorios relatorios = new Relatorios();
				relatorios.setVisible(true);
			}
		});
		btnNewButton_1_3.setToolTipText("Relat\u00F3rios");
		btnNewButton_1_3.setIcon(new ImageIcon(Principal.class.getResource("/img/relatorios.png")));
		btnNewButton_1_3.setBounds(10, 150, 128, 128);
		contentPane.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_4 = new JButton("");
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
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(10, 345, 542, 72);
		contentPane.add(panel);
	}
}
