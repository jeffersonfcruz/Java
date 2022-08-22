package view;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Clientes extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCliNome;
	private JTextField txtCliId;
	private JTextField txtCliFone;
	private JTextField txtCliCpf;
	private JTextField txtCliEmail;
	private JTextField txtCliCEP;
	private JTextField txtCliComplemento;
	private JTextField txtCliNum;
	private JTextField txtCliEnd;
	private JTextField txtCliBairro;
	private JTextField txtCliCidade;
	private JButton btnAdicionar;
	private JButton btnAlterar;
	private JButton btnExcluir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes dialog = new Clientes();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Clientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Clientes.class.getResource("/img/clientes.png")));
		setTitle("C L I E N T E S");
		setModal(true);
		setBounds(100, 100, 450, 400);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID: ");
		lblNewLabel.setBounds(10, 11, 37, 14);
		getContentPane().add(lblNewLabel);
		
		txtCliNome = new JTextField();
		txtCliNome.setBounds(57, 37, 320, 17);
		getContentPane().add(txtCliNome);
		txtCliNome.setColumns(10);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setBounds(10, 39, 37, 14);
		getContentPane().add(lblNome);
		
		txtCliId = new JTextField();
		txtCliId.setColumns(10);
		txtCliId.setBounds(35, 8, 77, 17);
		getContentPane().add(txtCliId);
		
		JLabel lblFone = new JLabel("FONE: ");
		lblFone.setBounds(10, 64, 37, 14);
		getContentPane().add(lblFone);
		
		txtCliFone = new JTextField();
		txtCliFone.setColumns(10);
		txtCliFone.setBounds(57, 62, 160, 17);
		getContentPane().add(txtCliFone);
		
		JLabel lblCpf = new JLabel("CPF: ");
		lblCpf.setBounds(10, 117, 37, 14);
		getContentPane().add(lblCpf);
		
		txtCliCpf = new JTextField();
		txtCliCpf.setColumns(10);
		txtCliCpf.setBounds(57, 115, 160, 17);
		getContentPane().add(txtCliCpf);
		
		JLabel lblEmail = new JLabel("EMAIL: ");
		lblEmail.setBounds(10, 92, 54, 14);
		getContentPane().add(lblEmail);
		
		txtCliEmail = new JTextField();
		txtCliEmail.setColumns(10);
		txtCliEmail.setBounds(57, 90, 207, 17);
		getContentPane().add(txtCliEmail);
		
		JLabel lblMarketing = new JLabel("Deseja receber email? : ");
		lblMarketing.setBounds(227, 64, 150, 14);
		getContentPane().add(lblMarketing);
		
		JComboBox cboCliEmail = new JComboBox();
		cboCliEmail.setModel(new DefaultComboBoxModel(new String[] {"", "Sim", "N\u00E3o"}));
		cboCliEmail.setBounds(370, 60, 54, 22);
		getContentPane().add(cboCliEmail);
		
		JLabel lblCep = new JLabel("CEP: ");
		lblCep.setBounds(10, 145, 37, 14);
		getContentPane().add(lblCep);
		
		txtCliCEP = new JTextField();
		txtCliCEP.setColumns(10);
		txtCliCEP.setBounds(57, 143, 86, 17);
		getContentPane().add(txtCliCEP);
		
		JLabel lblEndereo = new JLabel("ENDERE\u00C7O:");
		lblEndereo.setBounds(10, 173, 77, 14);
		getContentPane().add(lblEndereo);
		
		txtCliComplemento = new JTextField();
		txtCliComplemento.setColumns(10);
		txtCliComplemento.setBounds(264, 197, 160, 17);
		getContentPane().add(txtCliComplemento);
		
		JLabel lblNumero = new JLabel("NUMERO:");
		lblNumero.setBounds(286, 145, 54, 14);
		getContentPane().add(lblNumero);
		
		txtCliNum = new JTextField();
		txtCliNum.setColumns(10);
		txtCliNum.setBounds(347, 143, 77, 17);
		getContentPane().add(txtCliNum);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(173, 199, 91, 14);
		getContentPane().add(lblComplemento);
		
		txtCliEnd = new JTextField();
		txtCliEnd.setColumns(10);
		txtCliEnd.setBounds(85, 171, 339, 17);
		getContentPane().add(txtCliEnd);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 229, 54, 14);
		getContentPane().add(lblBairro);
		
		txtCliBairro = new JTextField();
		txtCliBairro.setColumns(10);
		txtCliBairro.setBounds(57, 227, 106, 17);
		getContentPane().add(txtCliBairro);
		
		JComboBox cboCliUf = new JComboBox();
		cboCliUf.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cboCliUf.setBounds(347, 229, 77, 22);
		getContentPane().add(cboCliUf);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 198, 86, 14);
		getContentPane().add(lblCidade);
		
		JLabel lblMarketing_1_1 = new JLabel("UF:");
		lblMarketing_1_1.setBounds(300, 228, 37, 17);
		getContentPane().add(lblMarketing_1_1);
		
		txtCliCidade = new JTextField();
		txtCliCidade.setColumns(10);
		txtCliCidade.setBounds(57, 198, 106, 17);
		getContentPane().add(txtCliCidade);
		
		btnExcluir = new JButton("");
		btnExcluir.setEnabled(false);
		btnExcluir.setDefaultCapable(false);
		btnExcluir.setContentAreaFilled(false);
		btnExcluir.setToolTipText("Excluir");
		btnExcluir.setIcon(new ImageIcon(Clientes.class.getResource("/img/delete.png")));
		btnExcluir.setBounds(360, 286, 64, 64);
		getContentPane().add(btnExcluir);
		
		btnAlterar = new JButton("");
		btnAlterar.setEnabled(false);
		btnAlterar.setToolTipText("Alterar");
		btnAlterar.setBorderPainted(false);
		btnAlterar.setContentAreaFilled(false);
		btnAlterar.setIcon(new ImageIcon(Clientes.class.getResource("/img/modify.png")));
		btnAlterar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlterar.setBounds(286, 286, 64, 64);
		getContentPane().add(btnAlterar);
		
		btnAdicionar = new JButton("");
		btnAdicionar.setToolTipText("Adicionar");
		btnAdicionar.setIcon(new ImageIcon(Clientes.class.getResource("/img/create.png")));
		btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.setBorderPainted(false);
		btnAdicionar.setBounds(212, 286, 64, 64);
		getContentPane().add(btnAdicionar);
		
		JButton btnBuscarCep = new JButton("Buscar CEP");
		btnBuscarCep.setBounds(153, 141, 89, 23);
		getContentPane().add(btnBuscarCep);

	}
}
