package view;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.DAO;

public class Fornecedor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtPesquisarFornecedor;
	private JTextField txtForId;
	private JTextField txtForCnpj;
	private JTextField txtForIm;
	private JTextField txtForIe;
	private JTextField txtForRazao;
	private JTextField txtForFantasia;
	private JTextField txtForSite;
	private JTextField txtForFone;
	private JTextField txtForContato;
	private JTextField txtForEmail;
	private JTextField txtForCep;
	private JTextField txtForEndereco;
	private JTextField txtForNumero;
	private JTextField txtForComplemento;
	private JTextField txtForBairro;
	private JTextField txtForCidade;
	private JTable tblFornecedores;
	private JComboBox cboForUF;

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

		txtPesquisarFornecedor = new JTextField();
		txtPesquisarFornecedor.setBounds(92, 18, 130, 20);
		getContentPane().add(txtPesquisarFornecedor);
		txtPesquisarFornecedor.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setBounds(20, 135, 25, 14);
		getContentPane().add(lblNewLabel_1);

		txtForId = new JTextField();
		txtForId.setBounds(58, 132, 58, 20);
		getContentPane().add(txtForId);
		txtForId.setColumns(10);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/find1.png")));
		label.setBounds(232, 3, 48, 48);
		getContentPane().add(label);

		JLabel lblNewLabel_1_1 = new JLabel("CNPJ:");
		lblNewLabel_1_1.setBounds(134, 182, 37, 14);
		getContentPane().add(lblNewLabel_1_1);

		txtForCnpj = new JTextField();
		txtForCnpj.setColumns(10);
		txtForCnpj.setBounds(178, 179, 127, 20);
		getContentPane().add(txtForCnpj);

		JLabel lblNewLabel_1_1_1 = new JLabel("IE:");
		lblNewLabel_1_1_1.setBounds(322, 182, 17, 14);
		getContentPane().add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("IM:");
		lblNewLabel_1_1_1_1.setBounds(507, 182, 17, 14);
		getContentPane().add(lblNewLabel_1_1_1_1);

		txtForIm = new JTextField();
		txtForIm.setColumns(10);
		txtForIm.setBounds(539, 179, 150, 20);
		getContentPane().add(txtForIm);

		cboForUF = new JComboBox();
		cboForUF.setModel(new DefaultComboBoxModel(
				new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
						"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cboForUF.setBounds(605, 327, 84, 22);
		getContentPane().add(cboForUF);

		txtForIe = new JTextField();
		txtForIe.setColumns(10);
		txtForIe.setBounds(349, 179, 132, 20);
		getContentPane().add(txtForIe);

		JLabel lblNewLabel_1_2 = new JLabel("Raz\u00E3o Social:");
		lblNewLabel_1_2.setBounds(20, 213, 96, 14);
		getContentPane().add(lblNewLabel_1_2);

		txtForRazao = new JTextField();
		txtForRazao.setColumns(10);
		txtForRazao.setBounds(126, 210, 179, 20);
		getContentPane().add(txtForRazao);

		JLabel lblNewLabel_1_2_1 = new JLabel("Nome Fantasia:");
		lblNewLabel_1_2_1.setBounds(315, 213, 98, 14);
		getContentPane().add(lblNewLabel_1_2_1);

		txtForFantasia = new JTextField();
		txtForFantasia.setColumns(10);
		txtForFantasia.setBounds(436, 210, 253, 20);
		getContentPane().add(txtForFantasia);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("SITE:");
		lblNewLabel_1_2_1_1.setBounds(20, 244, 46, 14);
		getContentPane().add(lblNewLabel_1_2_1_1);

		txtForSite = new JTextField();
		txtForSite.setColumns(10);
		txtForSite.setBounds(57, 241, 179, 20);
		getContentPane().add(txtForSite);

		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("FONE:");
		lblNewLabel_1_2_1_1_1.setBounds(246, 244, 37, 14);
		getContentPane().add(lblNewLabel_1_2_1_1_1);

		txtForFone = new JTextField();
		txtForFone.setColumns(10);
		txtForFone.setBounds(293, 238, 181, 20);
		getContentPane().add(txtForFone);

		JLabel lblNewLabel_1_2_1_2 = new JLabel("Contato:");
		lblNewLabel_1_2_1_2.setBounds(484, 241, 62, 14);
		getContentPane().add(lblNewLabel_1_2_1_2);

		txtForContato = new JTextField();
		txtForContato.setColumns(10);
		txtForContato.setBounds(547, 238, 142, 20);
		getContentPane().add(txtForContato);

		JLabel lblNewLabel_1_2_2 = new JLabel("E-mail:");
		lblNewLabel_1_2_2.setBounds(20, 269, 62, 14);
		getContentPane().add(lblNewLabel_1_2_2);

		txtForEmail = new JTextField();
		txtForEmail.setColumns(10);
		txtForEmail.setBounds(82, 266, 188, 20);
		getContentPane().add(txtForEmail);

		JLabel lblNewLabel_1_2_2_1 = new JLabel("CEP:");
		lblNewLabel_1_2_2_1.setBounds(307, 269, 37, 14);
		getContentPane().add(lblNewLabel_1_2_2_1);

		JButton btnBuscarCep = new JButton("Buscar CEP");
		btnBuscarCep.setBounds(507, 265, 89, 23);
		getContentPane().add(btnBuscarCep);

		txtForCep = new JTextField();
		txtForCep.setColumns(10);
		txtForCep.setBounds(354, 266, 142, 20);
		getContentPane().add(txtForCep);

		JLabel lblNewLabel_1_2_2_2 = new JLabel("Endere\u00E7o: ");
		lblNewLabel_1_2_2_2.setBounds(20, 300, 62, 14);
		getContentPane().add(lblNewLabel_1_2_2_2);

		txtForEndereco = new JTextField();
		txtForEndereco.setColumns(10);
		txtForEndereco.setBounds(82, 297, 181, 20);
		getContentPane().add(txtForEndereco);

		JLabel lblNewLabel_1_2_2_1_1 = new JLabel("N\u00FAmero:");
		lblNewLabel_1_2_2_1_1.setBounds(273, 300, 51, 14);
		getContentPane().add(lblNewLabel_1_2_2_1_1);

		txtForNumero = new JTextField();
		txtForNumero.setColumns(10);
		txtForNumero.setBounds(334, 297, 62, 20);
		getContentPane().add(txtForNumero);

		JLabel lblNewLabel_1_2_2_1_1_1 = new JLabel("Complemento:");
		lblNewLabel_1_2_2_1_1_1.setBounds(406, 300, 75, 14);
		getContentPane().add(lblNewLabel_1_2_2_1_1_1);

		txtForComplemento = new JTextField();
		txtForComplemento.setColumns(10);
		txtForComplemento.setBounds(512, 296, 177, 20);
		getContentPane().add(txtForComplemento);

		JLabel lblNewLabel_1_2_2_2_1 = new JLabel("Bairro: ");
		lblNewLabel_1_2_2_2_1.setBounds(20, 331, 62, 14);
		getContentPane().add(lblNewLabel_1_2_2_2_1);

		txtForBairro = new JTextField();
		txtForBairro.setColumns(10);
		txtForBairro.setBounds(93, 328, 170, 20);
		getContentPane().add(txtForBairro);

		JLabel lblNewLabel_1_2_2_1_1_2 = new JLabel("Cidade:");
		lblNewLabel_1_2_2_1_1_2.setBounds(273, 331, 51, 14);
		getContentPane().add(lblNewLabel_1_2_2_1_1_2);

		txtForCidade = new JTextField();
		txtForCidade.setColumns(10);
		txtForCidade.setBounds(334, 328, 190, 20);
		getContentPane().add(txtForCidade);

		JLabel lblNewLabel_1_2_2_1_1_1_1 = new JLabel("UF:");
		lblNewLabel_1_2_2_1_1_1_1.setBounds(547, 331, 25, 14);
		getContentPane().add(lblNewLabel_1_2_2_1_1_1_1);

		JTextArea txtForObs = new JTextArea();
		txtForObs.setBounds(92, 375, 232, 54);
		getContentPane().add(txtForObs);

		JLabel lblNewLabel_1_2_2_2_1_1 = new JLabel("Observa\u00E7\u00E3o: ");
		lblNewLabel_1_2_2_2_1_1.setBounds(20, 380, 70, 14);
		getContentPane().add(lblNewLabel_1_2_2_2_1_1);

		JButton btnExcluir = new JButton("");
		btnExcluir.setToolTipText("Remover");
		btnExcluir.setBorderPainted(false);
		btnExcluir.setContentAreaFilled(false);
		btnExcluir.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/delete.png")));
		btnExcluir.setBounds(625, 376, 64, 64);
		getContentPane().add(btnExcluir);

		JButton btnAlterar = new JButton("");
		btnAlterar.setToolTipText("Alterar");
		btnAlterar.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/modify.png")));
		btnAlterar.setContentAreaFilled(false);
		btnAlterar.setBorderPainted(false);
		btnAlterar.setBounds(551, 375, 64, 64);
		getContentPane().add(btnAlterar);

		JButton btnAdicionar = new JButton("");
		btnAdicionar.setToolTipText("Adicionar");
		btnAdicionar.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/create.png")));
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.setBorderPainted(false);
		btnAdicionar.setBounds(477, 376, 64, 64);
		getContentPane().add(btnAdicionar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(225, 62, 464, 109);
		getContentPane().add(scrollPane);

		tblFornecedores = new JTable();
		scrollPane.setViewportView(tblFornecedores);

		JButton btnPesquisar = new JButton("Buscar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarFornecedor();
			}
		});
		btnPesquisar.setBounds(126, 131, 89, 23);
		getContentPane().add(btnPesquisar);

	}// fim do construtor

	DAO dao = new DAO();
	private void pesquisarFornecedor() {
		// validação
		if (txtForId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "digite o ID do Fornecedor");
			txtForId.requestFocus();
		} else {
			String read = "select * from fornecedores where idfor = ?";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(read);
				pst.setString(1, txtForId.getText());
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					txtForId.setText(rs.getString(1));
					txtForCnpj.setText(rs.getString(2));
					txtForIe.setText(rs.getString(3));
					txtForIm.setText(rs.getString(4));
					txtForRazao.setText(rs.getString(5));
					txtForFantasia.setText(rs.getString(6));
					txtForSite.setText(rs.getString(7));
					txtForFone.setText(rs.getString(8));
					txtForContato.setText(rs.getString(9));
					txtForEmail.setText(rs.getString(10));
					txtForCep.setText(rs.getString(11));
					txtForEndereco.setText(rs.getString(12));
					txtForNumero.setText(rs.getString(13));
					txtForComplemento.setText(rs.getString(14));
					txtForBairro.setText(rs.getString(15));
					txtForCidade.setText(rs.getString(16));
					cboForUF.setSelectedItem(rs.getString(17));
				} else {
					JOptionPane.showMessageDialog(null, "Fornecedor inexistente");
				}
				con.close();

			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}
}
