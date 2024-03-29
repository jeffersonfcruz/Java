package view;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Iterator;

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
import javax.swing.table.DefaultTableModel;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;
import net.proteanit.sql.DbUtils;
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
		lblNewLabel.setBounds(20, 21, 97, 14);
		getContentPane().add(lblNewLabel);

		txtPesquisarFornecedor = new JTextField();
		txtPesquisarFornecedor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisarFornecedorTabela();
			}
		});
		txtPesquisarFornecedor.setBounds(127, 18, 156, 20);
		getContentPane().add(txtPesquisarFornecedor);
		txtPesquisarFornecedor.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setBounds(497, 21, 25, 14);
		getContentPane().add(lblNewLabel_1);

		txtForId = new JTextField();
		txtForId.setBounds(532, 18, 58, 20);
		getContentPane().add(txtForId);
		txtForId.setColumns(10);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/find1.png")));
		label.setBounds(291, 3, 48, 48);
		getContentPane().add(label);

		JLabel lblNewLabel_1_1 = new JLabel("CNPJ:");
		lblNewLabel_1_1.setBounds(20, 182, 37, 14);
		getContentPane().add(lblNewLabel_1_1);

		txtForCnpj = new JTextField();
		txtForCnpj.setColumns(10);
		txtForCnpj.setBounds(67, 179, 156, 20);
		getContentPane().add(txtForCnpj);

		JLabel lblNewLabel_1_1_1 = new JLabel("IE:");
		lblNewLabel_1_1_1.setBounds(246, 182, 17, 14);
		getContentPane().add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("IM:");
		lblNewLabel_1_1_1_1.setBounds(457, 182, 17, 14);
		getContentPane().add(lblNewLabel_1_1_1_1);

		txtForIm = new JTextField();
		txtForIm.setColumns(10);
		txtForIm.setBounds(507, 179, 182, 20);
		getContentPane().add(txtForIm);

		cboForUF = new JComboBox();
		cboForUF.setModel(new DefaultComboBoxModel(
				new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
						"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cboForUF.setBounds(605, 327, 84, 22);
		getContentPane().add(cboForUF);

		txtForIe = new JTextField();
		txtForIe.setColumns(10);
		txtForIe.setBounds(291, 179, 142, 20);
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
		btnBuscarCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtForCep.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o CEP para realizar a busca do endereço");
					txtForCep.requestFocus();
				} else {
					buscarCEP();
				}
			}
		});
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
		lblNewLabel_1_2_2_1_1_1.setBounds(406, 300, 105, 14);
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

		txtForObs = new JTextArea();
		txtForObs.setBounds(134, 375, 333, 54);
		getContentPane().add(txtForObs);

		JLabel lblNewLabel_1_2_2_2_1_1 = new JLabel("Observa\u00E7\u00E3o: ");
		lblNewLabel_1_2_2_2_1_1.setBounds(20, 380, 96, 23);
		getContentPane().add(lblNewLabel_1_2_2_2_1_1);

		btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirFornecedor();
			}
		});
		btnExcluir.setEnabled(false);
		btnExcluir.setToolTipText("Remover");
		btnExcluir.setBorderPainted(false);
		btnExcluir.setContentAreaFilled(false);
		btnExcluir.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/delete.png")));
		btnExcluir.setBounds(625, 376, 64, 64);
		getContentPane().add(btnExcluir);

		btnAlterar = new JButton("");
		btnAlterar.setEnabled(false);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarFornecedores();
			}
		});
		btnAlterar.setToolTipText("Alterar");
		btnAlterar.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/modify.png")));
		btnAlterar.setContentAreaFilled(false);
		btnAlterar.setBorderPainted(false);
		btnAlterar.setBounds(551, 375, 64, 64);
		getContentPane().add(btnAlterar);

		btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarFornecedor();
			}
		});
		btnAdicionar.setToolTipText("Adicionar");
		btnAdicionar.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/create.png")));
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.setBorderPainted(false);
		btnAdicionar.setBounds(477, 376, 64, 64);
		getContentPane().add(btnAdicionar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 62, 669, 109);
		getContentPane().add(scrollPane);

		tblFornecedores = new JTable();
		tblFornecedores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			//evento clicar com o mouse na tabela
				setarCaixasTexto();
			}
		});
		scrollPane.setViewportView(tblFornecedores);

		JButton btnPesquisar = new JButton("Buscar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarFornecedor();
			}
		});
		btnPesquisar.setBounds(600, 17, 89, 23);
		getContentPane().add(btnPesquisar);

		// Validacao com o uso da biblioteca Atxy2k

				// txtForCNPJ
				RestrictedTextField validarCNPJ = new RestrictedTextField(txtForCnpj);

				// Restringir a somente numeros no campo CNPJ
				validarCNPJ.setOnlyNums(true);
				// Limitar a somente 14 numeros no campo CNPJ
				validarCNPJ.setLimit(14);

				// txtForIE
				RestrictedTextField validarIE = new RestrictedTextField(txtForIe);

				// Restringir a somente numeros no campo IE
				validarIE.setOnlyNums(true);
				// Limitar a somente 14 numeros no campo IE
				validarIE.setLimit(14);

				// txtForIM
				RestrictedTextField validarIM = new RestrictedTextField(txtForIm);

				// Restringir a somente numeros no campo IM
				validarIM.setOnlyNums(true);
				// Limitar a somente 14 numeros no campo IM
				validarIM.setLimit(14);

				// txtForRazao
				RestrictedTextField validarRazao = new RestrictedTextField(txtForRazao);

				// Restringir a somente letras no campo razao
				validarRazao.setOnlyText(true);
				// Aceitar espaco no campo razao
				validarRazao.setAcceptSpace(true);
				// Limitar a somente 100 caracteres no campo razao
				validarRazao.setLimit(100);

				// txtForFantasia
				RestrictedTextField validarFantasia = new RestrictedTextField(txtForFantasia);

				// Limitar a somente 100 caracteres no campo fantasia
				validarFantasia.setLimit(100);

				// txtForSite
				RestrictedTextField validarSite = new RestrictedTextField(txtForSite);

				// Limitar a somente 60 caracteres no campo site
				validarSite.setLimit(60);

				// txtForFone
				RestrictedTextField validarFone = new RestrictedTextField(txtForFone);

				// Restringir a somente numeros no campo Fone
				validarFone.setOnlyNums(true);
				// Limitar a somente 14 numeros no campo Fone
				validarFone.setLimit(14);

				// txtForContato
				RestrictedTextField validarContato = new RestrictedTextField(txtForContato);

				// Restringir a somente letras no campo contato
				validarContato.setOnlyText(true);
				// Aceitar espaco no campo contato
				validarContato.setAcceptSpace(true);
				// Limitar a somente 20 caracteres no campo contato
				validarContato.setLimit(20);

				// txtForEmail
				RestrictedTextField validarEmail = new RestrictedTextField(txtForEmail);

				// Limitar a somente 50 caracteres no campo email
				validarEmail.setLimit(50);

				// txtForCEP
				RestrictedTextField validarCEP = new RestrictedTextField(txtForCep);

				// Restringir a somente numeros no campo CEP
				validarCEP.setOnlyNums(true);
				// Limitar a somente 8 numeros no campo CEP
				validarCEP.setLimit(8);

				// txtForEndereco
				RestrictedTextField validarEndereco = new RestrictedTextField(txtForEndereco);

				// Restringir a somente letras no campo endereco
				validarEndereco.setOnlyText(true);
				// Aceitar espaco no campo endereco
				validarEndereco.setAcceptSpace(true);
				// Limitar a somente 60 caracteres no campo endereco
				validarEndereco.setLimit(60);

				// txtForNumero
				RestrictedTextField validarNumero = new RestrictedTextField(txtForNumero);

				// Restringir a somente digitos no campo numero
				validarNumero.setOnlyNums(true);
				// Limitar a somente 10 digitos no campo numero
				validarNumero.setLimit(10);

				// txtForComplemento
				RestrictedTextField validarComplemento = new RestrictedTextField(txtForComplemento);

				// Limitar a somente 50 caracteres no campo complemento
				validarComplemento.setLimit(50);

				// txtForBairro
				RestrictedTextField validarBairro = new RestrictedTextField(txtForBairro);

				// Limitar a somente 50 caracteres no campo bairro
				validarBairro.setLimit(50);

				// txtForCidade
				RestrictedTextField validarCidade = new RestrictedTextField(txtForCidade);

				// Restringir a somente letras no campo cidade
				validarCidade.setOnlyText(true);
				// Aceitar espaco no campo cidade
				validarCidade.setAcceptSpace(true);
				// Limitar a somente 50 caracteres no campo cidade
				validarCidade.setLimit(50);
				
	}// fim do construtor

	DAO dao = new DAO();
	private JTextArea txtForObs;
	private JButton btnAdicionar;
	private JButton btnAlterar;
	private JButton btnExcluir;
	
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
					btnAlterar.setEnabled(true);
					btnExcluir.setEnabled(true);
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
					limparForCampos();
					btnAdicionar.setEnabled(true);
				}
				con.close();

			} catch (SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro.\nVerifique se os dados ja não estão inseridos em um outro fornecedor.");
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}
	
	private void pesquisarFornecedorTabela() {
		String readT = "select idfor as ID ,fantasia as Fornecedor,fone as Telefone from fornecedores where fantasia like ?";
		try {
			// estabelecer conexão
			Connection con = dao.conectar();
			// Preparar a execução da query
			PreparedStatement pst = con.prepareStatement(readT);
			// Substituir os ???? pelo conteudo das caixas de texto
			pst.setString(1, txtPesquisarFornecedor.getText() + "%");
			ResultSet rs = pst.executeQuery();
			//uso da biblioteca ts2xml para "popular" a tabela
			tblFornecedores.setModel(DbUtils.resultSetToTableModel(rs));
			con.close();
			
		}	catch(Exception e){
			System.out.println(e);
		}
		
	}
	/**
	 * Método responsavel por setar as caixas  de texto
	 * de acordo com os campos da tabela (mouse click)
	 */
	
	private void setarCaixasTexto() {
		//criar uma variável para receber a linha da tabela
		int setar = tblFornecedores.getSelectedRow();
		txtForId.setText(tblFornecedores.getModel().getValueAt(setar, 0).toString());
		limparCamposFornecedor();
	}
	// demais metodos de CRUD
	
	/**
	 * Limpar campos
	 */
	private void limparCamposFornecedor() {
		//limpar a tabela
		((DefaultTableModel) tblFornecedores.getModel()).setRowCount(0);
	}
	
	private void adicionarFornecedor() {
		// validação
		if (txtForCnpj.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o CNPJ");
			txtForCnpj.requestFocus();
		} else if (txtForIe.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Inscrição Estadual");
			txtForIe.requestFocus();
		} else if (txtForIm.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Inscrição Municipal");
			txtForIm.requestFocus();
		} else if (txtForRazao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Razão");
			txtForRazao.requestFocus();
		} else if (txtForFantasia.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Nome Fantasia");
			txtForFantasia.requestFocus();
		} else if (txtForFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Indorme o telefone");
			txtForFone.requestFocus();
		} else if (txtForEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe o E-Mail do Fornecedor");
			txtForEmail.requestFocus();
		} else if (txtForCep.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe o CEP");
			txtForCep.requestFocus();
		} else if (txtForEndereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Endereço");
			txtForEndereco.requestFocus();
		} else if (txtForNumero.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Numero do endereço");
			txtForNumero.requestFocus();
		} else if (txtForBairro.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Bairro");
			txtForBairro.requestFocus();
		} else if (txtForCidade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Cidade");
			txtForCidade.requestFocus();
		} else if (cboForUF.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Selecione a UF");
			cboForUF.requestFocus();
		} else {
			// lógica principal
			String create = "insert into  fornecedores (cnpj,ie,im,razao,fantasia,site,fone,contato,email,cep,endereco,numero,complemento,bairro,cidade,uf) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				// estabelecer conexão
				Connection con = dao.conectar();
				// Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(create);
				// Substituir os ???? pelo conteudo das caixas de texto
				pst.setString(1, txtForCnpj.getText());
				pst.setString(2, txtForIe.getText());
				pst.setString(3, txtForIm.getText());
				pst.setString(4, txtForRazao.getText());
				pst.setString(5, txtForFantasia.getText());
				pst.setString(6, txtForSite.getText());
				pst.setString(7, txtForFone.getText());
				pst.setString(8, txtForContato.getText());
				pst.setString(9,txtForEmail.getText());
				pst.setString(10,txtForCep.getText());
				pst.setString(11,txtForEndereco.getText());
				pst.setString(12,txtForNumero.getText());
				pst.setString(13,txtForComplemento.getText());
				pst.setString(14,txtForBairro.getText());
				pst.setString(15,txtForCidade.getText());
				pst.setString(16,cboForUF.getSelectedItem().toString());
				// Executar a query e inserir o usuario no banco
				pst.executeUpdate();
				limparForCampos();
				// Encerrar a conexão
				con.close();
				JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso");

				
			} catch (SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro.\nVerifique se os dados ja não estão inseridos em um outro Fornecedor.");
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	private void alterarFornecedores() {
				if (txtForId.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Digite o ID do Fornecedor");
					txtForId.requestFocus();
				} 
				else if (txtForCnpj.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o CNPJ do fornecedor");
					txtForCnpj.requestFocus();
				}
				else if (txtForIe.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha Inscrição Estadual do fornecedor");
					txtForIe.requestFocus();
				}
				else if (txtForIm.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha Inscrição Municipal do fornecedor");
					txtForIm.requestFocus();
				}
				else if (txtForRazao.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha a Razão Social do fornecedor");
					txtForRazao.requestFocus();
				}
				else if (txtForFantasia.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha 'Nome Fantasia' do fornecedor");
					txtForFantasia.requestFocus();
				}
				else if (txtForSite.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o Site do fornecedor");
					txtForSite.requestFocus();
				}
				else if (txtForFone.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o Telefone do fornecedor");
					txtForFone.requestFocus();
				}
				else if (txtForContato.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o Contato do fornecedor");
					txtForContato.requestFocus();
				}
				else if (txtForEmail.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o Email do fornecedor");
					txtForEmail.requestFocus();
				}
				else if (txtForCep.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o CEP do fornecedor");
					txtForCep.requestFocus();
				}
				else if (txtForEndereco.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o Endereço do fornecedor");
					txtForEndereco.requestFocus();
				}
				else if (txtForNumero.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o Numero do fornecedor");
					txtForNumero.requestFocus();
				}
				else if (txtForBairro.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o Bairro do fornecedor");
					txtForBairro.requestFocus();
				}
				else if (txtForCidade.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha a Cidade do fornecedor");
					txtForCidade.requestFocus();
				}
				
				else {
					String update = "update fornecedores set cnpj=?, ie=?, im=?, razao=?, fantasia=?, site=?, fone=?, contato=?, email=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, uf=?, obs=? where idfor=?";
					try {
						Connection con = dao.conectar();
						PreparedStatement pst = con.prepareStatement(update);
						pst.setString(1, txtForCnpj.getText());
						pst.setString(2, txtForIe.getText());
						pst.setString(3, txtForIm.getText());
						pst.setString(4, txtForRazao.getText());
						pst.setString(5, txtForFantasia.getText());
						pst.setString(6, txtForSite.getText());
						pst.setString(7, txtForFone.getText());
						pst.setString(8, txtForContato.getText());
						pst.setString(9,  txtForEmail.getText());
						pst.setString(10, txtForCep.getText());
						pst.setString(11, txtForEndereco.getText());
						pst.setString(12, txtForNumero.getText());
						pst.setString(13, txtForComplemento.getText());
						pst.setString(14, txtForBairro.getText());
						pst.setString(15, txtForCidade.getText());
						pst.setString(16, cboForUF.getSelectedItem().toString());
						pst.setString(17, txtForObs.getText());
						pst.setString(18, txtForId.getText());
						pst.executeUpdate();
				
						limparForCampos();
				
						// Encerrar a conexão
						con.close();
						
						JOptionPane.showMessageDialog(null, "Fornecedor atualizado com sucesso");
					} catch (SQLIntegrityConstraintViolationException ex) {
						JOptionPane.showMessageDialog(null, "Ocorreu um erro.\nVerifique se os dados ja não estão inseridos em um outro fornecedor.");
					} catch (Exception e) {
						System.out.println(e);
						}
				}
	}
	private void excluirFornecedor () {
		//validação (confirmação de exclusão)
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do usuário?", "Atenção!",JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			//Lógica principal
			String delete = "delete from fornecedores where idfor=?;";
			
			try {
				// Estabelecer conexão
				Connection con = dao.conectar();
				// Preparar a execução da query (comando sql) substituindo a ? pelo iduser
				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1,txtForId.getText());
				// Executar a query
				pst.executeUpdate();
				// confirmação
				limparForCampos();
				JOptionPane.showMessageDialog(null, "Fornecedor excluído com sucesso.");
				
				limparForCampos();
			}	catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	private void buscarCEP() {

		String logradouro = "";
		String tipoLogradouro = "";
		String resultado = null;
		String CEP = txtForCep.getText();

		try {

			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + CEP + "&formato=xml");

			SAXReader xml = new SAXReader();

			Document documento = xml.read(url);

			Element root = documento.getRootElement();

			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {

				Element element = it.next();

				if (element.getQualifiedName().equals("cidade")) {
					txtForCidade.setText(element.getText());
				}

				if (element.getQualifiedName().equals("bairro")) {
					txtForBairro.setText(element.getText());
				}

				if (element.getQualifiedName().equals("uf")) {
					cboForUF.setSelectedItem(element.getText());
				}

				if (element.getQualifiedName().equals("tipo_logradouro")) {
					tipoLogradouro = element.getText();
				}

				if (element.getQualifiedName().equals("logradouro")) {
					logradouro = element.getText();
				}

				if (element.getQualifiedName().equals("resultado")) {
					resultado = element.getText();

					if (resultado.equals("1")) {
					}

					else {
						JOptionPane.showMessageDialog(null, "CEP não encontrado");
					}
				}
			}

			// Setar o campo endereco
			txtForEndereco.setText(tipoLogradouro + " " + logradouro);

		}
		catch (Exception e) {
			System.out.println(e);
		}

	}
	private void limparForCampos() {
		txtForCnpj.setText(null);
		txtForIm.setText(null);
		txtForIe.setText(null);
		txtForRazao.setText(null);
		txtForFantasia.setText(null);
		txtForSite.setText(null);
		txtForFone.setText(null);
		txtForContato.setText(null);
		txtForEmail.setText(null);
		txtForCep.setText(null);
		txtForEndereco.setText(null);
		txtForNumero.setText(null);
		txtForComplemento.setText(null);
		txtForBairro.setText(null);
		txtForCidade.setText(null);
		cboForUF.setSelectedItem("");
		btnAdicionar.setEnabled(false);
		btnAlterar.setEnabled(false);
		btnExcluir.setEnabled(false);
	}
}