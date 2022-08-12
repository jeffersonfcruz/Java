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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

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
		
		textField = new JTextField();
		textField.setBounds(57, 37, 320, 17);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setBounds(10, 39, 37, 14);
		getContentPane().add(lblNome);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(35, 8, 77, 17);
		getContentPane().add(textField_1);
		
		JLabel lblFone = new JLabel("FONE: ");
		lblFone.setBounds(10, 64, 37, 14);
		getContentPane().add(lblFone);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(57, 62, 160, 17);
		getContentPane().add(textField_2);
		
		JLabel lblCpf = new JLabel("CPF: ");
		lblCpf.setBounds(10, 117, 37, 14);
		getContentPane().add(lblCpf);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(57, 115, 160, 17);
		getContentPane().add(textField_3);
		
		JLabel lblEmail = new JLabel("EMAIL: ");
		lblEmail.setBounds(10, 92, 37, 14);
		getContentPane().add(lblEmail);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(57, 90, 207, 17);
		getContentPane().add(textField_4);
		
		JLabel lblMarketing = new JLabel("Deseja receber email? : ");
		lblMarketing.setBounds(227, 64, 150, 14);
		getContentPane().add(lblMarketing);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Sim", "N\u00E3o"}));
		comboBox.setBounds(370, 60, 54, 22);
		getContentPane().add(comboBox);
		
		JLabel lblCep = new JLabel("CEP: ");
		lblCep.setBounds(10, 145, 37, 14);
		getContentPane().add(lblCep);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(57, 143, 86, 17);
		getContentPane().add(textField_5);
		
		JLabel lblEndereo = new JLabel("ENDERE\u00C7O:");
		lblEndereo.setBounds(10, 173, 77, 14);
		getContentPane().add(lblEndereo);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(264, 197, 160, 17);
		getContentPane().add(textField_6);
		
		JLabel lblNumero = new JLabel("NUMERO:");
		lblNumero.setBounds(286, 145, 54, 14);
		getContentPane().add(lblNumero);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(347, 143, 77, 17);
		getContentPane().add(textField_7);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(173, 199, 91, 14);
		getContentPane().add(lblComplemento);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(85, 171, 339, 17);
		getContentPane().add(textField_8);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 229, 54, 14);
		getContentPane().add(lblBairro);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(57, 227, 106, 17);
		getContentPane().add(textField_9);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		comboBox_1.setBounds(347, 229, 77, 22);
		getContentPane().add(comboBox_1);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 198, 86, 14);
		getContentPane().add(lblCidade);
		
		JLabel lblMarketing_1_1 = new JLabel("UF:");
		lblMarketing_1_1.setBounds(300, 228, 37, 17);
		getContentPane().add(lblMarketing_1_1);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(57, 198, 106, 17);
		getContentPane().add(textField_10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setDefaultCapable(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setToolTipText("Excluir");
		btnNewButton.setIcon(new ImageIcon(Clientes.class.getResource("/img/delete.png")));
		btnNewButton.setBounds(360, 286, 64, 64);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setToolTipText("Alterar");
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setIcon(new ImageIcon(Clientes.class.getResource("/img/modify.png")));
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBounds(286, 286, 64, 64);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setToolTipText("Adicionar");
		btnNewButton_2.setIcon(new ImageIcon(Clientes.class.getResource("/img/create.png")));
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBounds(212, 286, 64, 64);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Buscar CEP");
		btnNewButton_3.setBounds(153, 141, 89, 23);
		getContentPane().add(btnNewButton_3);

	}
}
