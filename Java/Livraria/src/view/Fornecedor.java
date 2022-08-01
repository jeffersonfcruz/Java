package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class Fornecedor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fornecedor dialog = new Fornecedor();
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
	public Fornecedor() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Fornecedor.class.getResource("/img/fornecedores.png")));
		setTitle("F O R N E C E D O R");
		setBounds(100, 100, 730, 479);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fornecedor");
		lblNewLabel.setBounds(20, 21, 62, 14);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(92, 18, 130, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setBounds(20, 85, 25, 14);
		getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(44, 82, 70, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/find1.png")));
		lblNewLabel_2.setBounds(232, 11, 48, 48);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("CNPJ:");
		lblNewLabel_1_1.setBounds(123, 85, 37, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(170, 82, 127, 20);
		getContentPane().add(textField_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("IE:");
		lblNewLabel_1_1_1.setBounds(307, 85, 17, 14);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("IM:");
		lblNewLabel_1_1_1_1.setBounds(497, 85, 17, 14);
		getContentPane().add(lblNewLabel_1_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(539, 82, 150, 20);
		getContentPane().add(textField_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		comboBox.setBounds(605, 301, 84, 22);
		getContentPane().add(comboBox);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(334, 82, 132, 20);
		getContentPane().add(textField_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("Raz\u00E3o Social:");
		lblNewLabel_1_2.setBounds(20, 135, 84, 14);
		getContentPane().add(lblNewLabel_1_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(111, 132, 213, 20);
		getContentPane().add(textField_5);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Nome Fantasia:");
		lblNewLabel_1_2_1.setBounds(328, 135, 98, 14);
		getContentPane().add(lblNewLabel_1_2_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(436, 132, 253, 20);
		getContentPane().add(textField_6);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("SITE:");
		lblNewLabel_1_2_1_1.setBounds(20, 172, 46, 14);
		getContentPane().add(lblNewLabel_1_2_1_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(61, 169, 179, 20);
		getContentPane().add(textField_7);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("FONE:");
		lblNewLabel_1_2_1_1_1.setBounds(250, 172, 37, 14);
		getContentPane().add(lblNewLabel_1_2_1_1_1);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(296, 169, 181, 20);
		getContentPane().add(textField_8);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Contato:");
		lblNewLabel_1_2_1_2.setBounds(497, 172, 62, 14);
		getContentPane().add(lblNewLabel_1_2_1_2);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(547, 169, 142, 20);
		getContentPane().add(textField_9);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("E-mail:");
		lblNewLabel_1_2_2.setBounds(20, 215, 62, 14);
		getContentPane().add(lblNewLabel_1_2_2);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(92, 212, 188, 20);
		getContentPane().add(textField_10);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("CEP:");
		lblNewLabel_1_2_2_1.setBounds(307, 215, 37, 14);
		getContentPane().add(lblNewLabel_1_2_2_1);
		
		JButton btnNewButton = new JButton("Buscar CEP");
		btnNewButton.setBounds(506, 211, 89, 23);
		getContentPane().add(btnNewButton);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(354, 212, 142, 20);
		getContentPane().add(textField_11);
		
		JLabel lblNewLabel_1_2_2_2 = new JLabel("Endere\u00E7o: ");
		lblNewLabel_1_2_2_2.setBounds(20, 265, 62, 14);
		getContentPane().add(lblNewLabel_1_2_2_2);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(82, 262, 181, 20);
		getContentPane().add(textField_12);
		
		JLabel lblNewLabel_1_2_2_1_1 = new JLabel("N\u00FAmero:");
		lblNewLabel_1_2_2_1_1.setBounds(273, 265, 51, 14);
		getContentPane().add(lblNewLabel_1_2_2_1_1);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(337, 262, 62, 20);
		getContentPane().add(textField_13);
		
		JLabel lblNewLabel_1_2_2_1_1_1 = new JLabel("Complemento:");
		lblNewLabel_1_2_2_1_1_1.setBounds(427, 265, 75, 14);
		getContentPane().add(lblNewLabel_1_2_2_1_1_1);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(512, 262, 177, 20);
		getContentPane().add(textField_14);
		
		JLabel lblNewLabel_1_2_2_2_1 = new JLabel("Bairro: ");
		lblNewLabel_1_2_2_2_1.setBounds(20, 305, 62, 14);
		getContentPane().add(lblNewLabel_1_2_2_2_1);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(92, 302, 170, 20);
		getContentPane().add(textField_15);
		
		JLabel lblNewLabel_1_2_2_1_1_2 = new JLabel("Cidade:");
		lblNewLabel_1_2_2_1_1_2.setBounds(273, 305, 51, 14);
		getContentPane().add(lblNewLabel_1_2_2_1_1_2);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(334, 302, 190, 20);
		getContentPane().add(textField_16);
		
		JLabel lblNewLabel_1_2_2_1_1_1_1 = new JLabel("UF:");
		lblNewLabel_1_2_2_1_1_1_1.setBounds(557, 305, 25, 14);
		getContentPane().add(lblNewLabel_1_2_2_1_1_1_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(92, 359, 232, 70);
		getContentPane().add(textArea);
		
		JLabel lblNewLabel_1_2_2_2_1_1 = new JLabel("Observa\u00E7\u00E3o: ");
		lblNewLabel_1_2_2_2_1_1.setBounds(20, 364, 70, 14);
		getContentPane().add(lblNewLabel_1_2_2_2_1_1);
		
		JButton button = new JButton("");
		button.setToolTipText("Remover");
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/delete.png")));
		button.setBounds(625, 365, 64, 64);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("");
		button_1.setToolTipText("Alterar");
		button_1.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/modify.png")));
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		button_1.setBounds(551, 364, 64, 64);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setToolTipText("Adicionar");
		button_2.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/create.png")));
		button_2.setContentAreaFilled(false);
		button_2.setBorderPainted(false);
		button_2.setBounds(477, 365, 64, 64);
		getContentPane().add(button_2);

	}
}
