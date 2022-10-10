package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;
import net.proteanit.sql.DbUtils;

public class Produtos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtProdBarcode;
	private JTextField txtProdID;
	private JTextField txtBuscarFor;
	private JTextField txtForID;
	private JTable tblFornecedores;
	private JTextField txtProdNome;
	private JTextField txtProdFabricante;
	private JTextField txtProdEstoque;
	private JTextField txtProdEstoqueMin;
	private JTextField txtProdLocal;
	private JTextField txtProdCusto;
	private JTextField txtProdLucro;
	private JButton btnPesquisarProdID;
	private JTextArea txtProdDescricao;
	private JComboBox cboProdUnidade;
	private JDateChooser dataEntrada;
	private JDateChooser dataValidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Produtos  dialog = new Produtos ();
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
	public Produtos () {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				txtProdBarcode.requestFocus();
			}
		});
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Produtos.class.getResource("/img/favicon.png")));
		setTitle("Produtos");
		setModal(true);
		setBounds(100, 100, 882, 600);
		getContentPane().setLayout(null);

		JLabel imgBarCode = new JLabel("");
		imgBarCode.setIcon(new ImageIcon(Produtos.class.getResource("/img/barcode.png")));
		imgBarCode.setBounds(24, 37, 80, 45);
		getContentPane().add(imgBarCode);

		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo");
		lblNewLabel_1.setBounds(38, 117, 46, 14);
		getContentPane().add(lblNewLabel_1);

		txtProdBarcode = new JTextField();
		txtProdBarcode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					pesquisarProdutoCodigoBarras();
				}
			}
		});
		txtProdBarcode.setBounds(104, 51, 161, 20);
		getContentPane().add(txtProdBarcode);

		txtProdID = 	new JTextField();
		txtProdID.setBounds(104, 114, 161, 20);
		getContentPane().add(txtProdID);

		btnPesquisarProdID = new JButton("Pesquisar");
		btnPesquisarProdID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarProdutoCodigo();
			}
		});
		btnPesquisarProdID.setBounds(275, 113, 112, 23);
		getContentPane().add(btnPesquisarProdID);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Fornecedor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(397, 45, 451, 189);
		getContentPane().add(panel);
		panel.setLayout(null);

		txtBuscarFor = new JTextField();
		txtBuscarFor.setForeground(Color.DARK_GRAY);
		txtBuscarFor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				buscarFornecedorTabela();
			}
		});

		txtBuscarFor.setBounds(10, 27, 166, 20);
		panel.add(txtBuscarFor);

		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setBounds(274, 30, 11, 14);
		panel.add(lblNewLabel_3);

		txtForID = new JTextField();
		txtForID.setBounds(295, 27, 136, 20);
		panel.add(txtForID);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 421, 120);
		panel.add(scrollPane);

		tblFornecedores = new JTable();
		tblFornecedores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setarCaixasTexto();
			}
		});
		scrollPane.setViewportView(tblFornecedores);

		txtProdNome = new JTextField();
		txtProdNome.setBounds(104, 170, 161, 20);
		getContentPane().add(txtProdNome);

		JLabel lblNewLabel_1_1 = new JLabel("Produto");
		lblNewLabel_1_1.setBounds(38, 173, 46, 14);
		getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel_1_1_1.setBounds(38, 227, 46, 14);
		getContentPane().add(lblNewLabel_1_1_1);

		txtProdDescricao = new JTextArea();
		txtProdDescricao.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtProdDescricao.setBounds(104, 222, 283, 103);
		getContentPane().add(txtProdDescricao);

		btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarProduto();
			}
		});
		btnAdicionar.setBorderPainted(false);
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.setIcon(new ImageIcon(Produtos .class.getResource("/img/createP.png")));
		btnAdicionar.setToolTipText("Adicionar");
		btnAdicionar.setEnabled(true);
		btnAdicionar.setBounds(587, 472, 64, 64);
		getContentPane().add(btnAdicionar);

		btnAlterar = new JButton("");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarFornecedor();
			}
		});
		btnAlterar.setIcon(new ImageIcon(Produtos.class.getResource("/img/updateP.png")));
		btnAlterar.setToolTipText("Alterar");
		btnAlterar.setEnabled(false);
		btnAlterar.setContentAreaFilled(false);
		btnAlterar.setBorderPainted(false);
		btnAlterar.setBounds(679, 472, 64, 64);
		getContentPane().add(btnAlterar);

		btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirFornecedor();
			}
		});
		btnExcluir.setIcon(new ImageIcon(Produtos.class.getResource("/img/deleteP.png")));
		btnExcluir.setToolTipText("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.setContentAreaFilled(false);
		btnExcluir.setBorderPainted(false);
		btnExcluir.setBounds(769, 472, 64, 64);
		getContentPane().add(btnExcluir);

		txtProdFabricante = new JTextField();
		txtProdFabricante.setBounds(104, 355, 286, 20);
		getContentPane().add(txtProdFabricante);

		JLabel lblNewLabel_1_2 = new JLabel("Fabricante");
		lblNewLabel_1_2.setBounds(38, 358, 60, 14);
		getContentPane().add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("Estoque");
		lblNewLabel_1_2_1.setBounds(38, 405, 60, 14);
		getContentPane().add(lblNewLabel_1_2_1);

		txtProdEstoque = new JTextField();
		txtProdEstoque.setBounds(104, 402, 89, 20);
		getContentPane().add(txtProdEstoque);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Estoque m\u00EDnimo");
		lblNewLabel_1_2_1_1.setBounds(215, 405, 80, 14);
		getContentPane().add(lblNewLabel_1_2_1_1);

		txtProdEstoqueMin = new JTextField();
		txtProdEstoqueMin.setBounds(301, 402, 89, 20);
		getContentPane().add(txtProdEstoqueMin);

		JLabel lblNewLabel_1_1_2 = new JLabel("Local");
		lblNewLabel_1_1_2.setBounds(38, 509, 46, 14);
		getContentPane().add(lblNewLabel_1_1_2);

		txtProdLocal = new JTextField();
		txtProdLocal.setBounds(78, 506, 163, 20);
		getContentPane().add(txtProdLocal);

		JLabel lblNewLabel_1_2_1_2 = new JLabel("Unidade");
		lblNewLabel_1_2_1_2.setBounds(38, 457, 60, 14);
		getContentPane().add(lblNewLabel_1_2_1_2);

		JLabel lblNewLabel_1_2_1_3 = new JLabel("Custo");
		lblNewLabel_1_2_1_3.setBounds(454, 402, 60, 14);
		getContentPane().add(lblNewLabel_1_2_1_3);

		txtProdCusto = new JTextField();
		txtProdCusto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtProdCusto.setBounds(520, 399, 89, 20);
		getContentPane().add(txtProdCusto);

		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Lucro(%)");
		lblNewLabel_1_2_1_1_1.setBounds(641, 402, 80, 14);
		getContentPane().add(lblNewLabel_1_2_1_1_1);

		txtProdLucro = new JTextField();
		txtProdLucro.setBounds(717, 399, 89, 20);
		getContentPane().add(txtProdLucro);

		cboProdUnidade = new JComboBox();
		cboProdUnidade.setModel(new DefaultComboBoxModel(new String[] { "", "UN", "CX", "PÇ", "KG", "PCT", "M" }));
		cboProdUnidade.setBounds(104, 453, 81, 22);
		getContentPane().add(cboProdUnidade);

		JLabel lblNewLabel_1_2_2 = new JLabel("Entrada");
		lblNewLabel_1_2_2.setBounds(454, 281, 60, 14);
		getContentPane().add(lblNewLabel_1_2_2);

		dataEntrada = new JDateChooser();
		dataEntrada.setBounds(520, 281, 286, 20);
		getContentPane().add(dataEntrada);

		JLabel lblNewLabel_1_2_2_1 = new JLabel("Validade");
		lblNewLabel_1_2_2_1.setBounds(454, 331, 60, 14);
		getContentPane().add(lblNewLabel_1_2_2_1);

		dataValidade = new JDateChooser();
		dataValidade.setBounds(520, 331, 286, 20);
		getContentPane().add(dataValidade);
		
		RestrictedTextField validartxtBuscarFor = new RestrictedTextField(txtBuscarFor);
		validartxtBuscarFor.setLimit(30);
		
		RestrictedTextField validarBarcode = new RestrictedTextField(txtProdBarcode);
		validarBarcode.setOnlyNums(true);
		validarBarcode.setLimit(13);
		
		RestrictedTextField validarCodigo = new RestrictedTextField(txtProdID);
		validarCodigo.setOnlyNums(true);
		validarCodigo.setLimit(10);
		
		RestrictedTextField validarNome = new RestrictedTextField(txtProdNome);
		validarNome.setOnlyText(true);
		validarNome.setAcceptSpace(true);
		validarNome.setLimit(22);
		
		RestrictedTextField validarFabricante = new RestrictedTextField(txtProdFabricante);
		validarFabricante.setLimit(30);
		
		RestrictedTextField validarEstoque = new RestrictedTextField(txtProdEstoque);
		validarEstoque.setOnlyNums(true);
		validarEstoque.setLimit(5);
		
		RestrictedTextField validarEstoqueMin = new RestrictedTextField(txtProdEstoqueMin);
		validarEstoqueMin.setOnlyNums(true);
		validarEstoqueMin.setLimit(5);
		
		RestrictedTextField validarLocal = new RestrictedTextField(txtProdLocal);
		validarLocal.setLimit(10);
		
		RestrictedTextField validarCusto = new RestrictedTextField(txtProdCusto);
		validarCusto.setLimit(5);
		
		RestrictedTextField validarLucro = new RestrictedTextField(txtProdLucro);
		
		JButton btnNewButton = new JButton("Limpar Campos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnNewButton.setBounds(687, 11, 161, 23);
		getContentPane().add(btnNewButton);
		validarLucro.setLimit(5);
		
	} // Fim do construtor
		// Criar objeto para acessar o banco

	DAO dao = new DAO();
	
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnAdicionar;

	/**
	 * Metodo responsavel pela pesquisa avancada do fornecedor usando o nome
	 * fantasia e a biblioteca rs2xml
	 */

	private void buscarFornecedorTabela() {
		String readT = "select idfor as ID, cnpj as CNPJ, fantasia as Fornecedor, fone as Telefone from fornecedores where fantasia like ?;";

		try {
			Connection con = dao.conectar();

			PreparedStatement pst = con.prepareStatement(readT);

			pst.setString(1, txtBuscarFor.getText() + "%");

			ResultSet rs = pst.executeQuery();

			tblFornecedores.setModel(DbUtils.resultSetToTableModel(rs));

			if (txtBuscarFor.getText().isEmpty()) {
				txtForID.setText(null);
			}

			con.close();

		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Metodo responsavel pela pesquisa do ID do fornecedor (setar as caixas de
	 * texto de acordo com os campos da tabela)
	 */

	private void setarCaixasTexto() {

		int setar = tblFornecedores.getSelectedRow();
		txtForID.setText(tblFornecedores.getModel().getValueAt(setar, 0).toString());
		txtBuscarFor.setText(tblFornecedores.getModel().getValueAt(setar, 2).toString());
	}
	private void pesquisarProdutoCodigoBarras() {
		String read2 = "select * from produtos where barcode = ?";
		try {			
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, txtProdBarcode.getText());			
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {	
				txtProdID.setText(rs.getString(1));
				txtProdBarcode.setText(rs.getString(2));				
				txtProdNome.setText(rs.getString(3));
				 txtProdDescricao.setText(rs.getString(4));
				 txtProdFabricante.setText(rs.getString(5));
				 String setarDataCad = rs.getString(6);
					Date dataCad = new SimpleDateFormat("yyyy-MM-dd").parse(setarDataCad);
					dataEntrada.setDate(dataCad);
				 String setarDataVal = rs.getString(7);
					Date dataVal = new SimpleDateFormat("yyyy-MM-dd").parse(setarDataVal);
					dataValidade.setDate(dataVal);
				 txtProdEstoque.setText(rs.getString(8));
				 txtProdEstoqueMin.setText(rs.getString(9));
				 cboProdUnidade.setSelectedItem(rs.getString(10));
				 txtProdLocal.setText(rs.getString(11));
				 txtProdCusto.setText(rs.getString(12));
				 txtProdLucro.setText(rs.getString(13));
				 txtForID.setText(rs.getString(14));
			}else {
				JOptionPane.showMessageDialog(null, "Produto não cadastrado");
				btnAdicionar.setEnabled(true);
			}
			con.close();
			limparCamposBarcode();
		} catch (Exception e) {
			System.out.println(e);
		}
	}	
	//pesquisar produto por código
		private void pesquisarProdutoCodigo() {
			String read = " select * from produtos where codigo =?";
			try {
				// estabelecer conexão
				Connection con = dao.conectar();
				// Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(read);
				// Seta o arguemento (id)
				pst.setString(1, txtProdID.getText());
				// Executar a query e exibir o resultado no formulario
				ResultSet rs = pst.executeQuery();
				// validação(existencia de usuario)
				if (rs.next()) {	
					txtProdID.setText(rs.getString(1));
					txtProdBarcode.setText(rs.getString(2));				
					txtProdNome.setText(rs.getString(3));
					 txtProdDescricao.setText(rs.getString(4));
					 txtProdFabricante.setText(rs.getString(5));
					 String setarDataCad = rs.getString(6);
						Date dataCad = new SimpleDateFormat("yyyy-MM-dd").parse(setarDataCad);
						dataEntrada.setDate(dataCad);
					 String setarDataVal = rs.getString(7);
						Date dataVal = new SimpleDateFormat("yyyy-MM-dd").parse(setarDataVal);
						dataValidade.setDate(dataVal);
					 txtProdEstoque.setText(rs.getString(8));
					 txtProdEstoqueMin.setText(rs.getString(9));
					 cboProdUnidade.setSelectedItem(rs.getString(10));
					 txtProdLocal.setText(rs.getString(11));
					 txtProdCusto.setText(rs.getString(12));
					 txtProdLucro.setText(rs.getString(13));
					 txtForID.setText(rs.getString(14));
					 btnAlterar.setEnabled(true);
					 btnExcluir.setEnabled(true);
					 btnAdicionar.setEnabled(false);
				}else {
					JOptionPane.showMessageDialog(null, "Produto não cadastrado");
					limparCampos();
				}	
				con.close();
			}catch (Exception e) {
				System.out.println(e);
			}	
		}
		private void adicionarProduto() {
			// validação
			
			if (txtProdNome.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o Produto");
				txtProdNome.requestFocus();
				
			} else if ( txtProdDescricao.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha a Descrição");
				 txtProdDescricao.requestFocus();
				
			} else if (txtProdFabricante.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o Nome do Fabricante");
				txtProdFabricante.requestFocus();
				
			} else if (txtProdEstoque.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Informe o o estoque");
				txtProdEstoque.requestFocus();
				
			} else if (txtProdEstoqueMin.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Informe o estoque minimo");
				txtProdEstoqueMin.requestFocus();
				
			} else if ( txtProdCusto.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o custo");
				 txtProdCusto.requestFocus();
				
			} else if (txtProdLocal.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o Local do produto");
				txtProdLocal.requestFocus();
				
			} else if (cboProdUnidade.getSelectedItem().equals("")) {
				JOptionPane.showMessageDialog(null, "Selecione a Unidade");
				cboProdUnidade.requestFocus();
				
			} else if (dataEntrada.getDate()==null) {
				JOptionPane.showMessageDialog(null, "Digite a Data de Entrada");
				dataEntrada.requestFocus();
				
			} else if (dataValidade.getDate()==null) {
				JOptionPane.showMessageDialog(null, "Digite a Data de Validade");
				dataValidade.requestFocus();
				
			}
			else {
				// lógica principal
				String create = "insert into produtos(barcode,produto,descricao,fabricante,datacad,dataval,estoque,estoquemin,unidade,custo,localizacao,lucro,idfor) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
				try {
					// estabelecer conexão
					Connection con = dao.conectar();
					// Preparar a execução da query
					PreparedStatement pst = con.prepareStatement(create);
					// Substituir os ???? pelo conteudo das caixas de texto
					pst.setString(1,txtProdBarcode.getText());
					pst.setString(2,txtProdNome.getText());
					pst.setString(3,txtProdDescricao.getText());
					pst.setString(4,txtProdFabricante.getText());
					
					SimpleDateFormat formatador = new SimpleDateFormat("yyyyMMdd");
					String dataEntradaFormatada = formatador.format(dataEntrada.getDate());
					pst.setString(5, dataEntradaFormatada);					
					
					SimpleDateFormat formatador1 = new SimpleDateFormat("yyyyMMdd");
					String dataValidadeFormatada = formatador1.format(dataValidade.getDate());
					pst.setString(6, dataValidadeFormatada);
					
					pst.setString(7,txtProdEstoque.getText());
					pst.setString(8,txtProdEstoqueMin.getText());
					pst.setString(9,cboProdUnidade.getSelectedItem().toString());
					pst.setString(10,txtProdCusto.getText());
					pst.setString(11,txtProdLocal.getText());	
					pst.setString(12,txtProdLucro.getText());
					pst.setString(13,txtForID.getText());
					
					// Executar a query e inserir o usuario no banco
					pst.executeUpdate();
					// Encerrar a conexão
					JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
					con.close();
					limparCampos(); 
				}
					catch (SQLIntegrityConstraintViolationException ex) {

						JOptionPane.showMessageDialog(null,
								"Ocorreu um erro. \nVerifique novamente o Produto");
					}
				 catch (Exception e) {
					System.out.println(e);
					limparCampos();
				}
			}
		}
		private void alterarFornecedor() {

			// validação
			if (txtProdNome.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o Produto");
				txtProdNome.requestFocus();
				
			} else if ( txtProdDescricao.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha a Descrição");
				 txtProdDescricao.requestFocus();
				
			} else if (txtProdFabricante.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o Nome do Fabricante");
				txtProdFabricante.requestFocus();
				
			} else if (txtProdEstoque.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Informe o o estoque");
				txtProdEstoque.requestFocus();
				
			} else if (txtProdEstoqueMin.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Informe o estoque minimo");
				txtProdEstoqueMin.requestFocus();
				
			} else if ( txtProdCusto.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o custo");
				 txtProdCusto.requestFocus();
				
			} else if (txtProdLocal.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o Local do produto");
				txtProdLocal.requestFocus();
				
			} else if (cboProdUnidade.getSelectedItem().equals("")) {
				JOptionPane.showMessageDialog(null, "Selecione a Unidade");
				cboProdUnidade.requestFocus();
				
			} else if (dataEntrada.getDate()==null) {
				JOptionPane.showMessageDialog(null, "Digite a Data de Entrada");
				dataEntrada.requestFocus();
				
			} else if (dataValidade.getDate()==null) {
				JOptionPane.showMessageDialog(null, "Digite a Data de Validade");
				dataValidade.requestFocus();
				
			} else {
				String update = "update produtos set barcode = ?, produto = ?, descricao = ?, fabricante = ?, datacad = ?, dataval = ?, estoque = ?, estoquemin = ?, unidade = ?, localizacao = ?, custo = ?, lucro = ?, idfor = ? where codigo = ?";
				try {
					Connection con = dao.conectar();
					PreparedStatement pst = con.prepareStatement(update);
					pst.setString(1, txtProdBarcode.getText());
					pst.setString(2, txtProdNome.getText());
					pst.setString(3, txtProdDescricao.getText());
					pst.setString(4, txtProdFabricante.getText());
					SimpleDateFormat formatador = new SimpleDateFormat("yyyyMMdd");
					String dataEntradaFormatada = formatador.format(dataEntrada.getDate());
					pst.setString(5, dataEntradaFormatada);					
					
					SimpleDateFormat formatador1 = new SimpleDateFormat("yyyyMMdd");
					String dataValidadeFormatada = formatador1.format(dataValidade.getDate());
					pst.setString(6, dataValidadeFormatada);
					pst.setString(7, txtProdEstoque.getText());
					pst.setString(8, txtProdEstoqueMin.getText());
					pst.setString(9, cboProdUnidade.getSelectedItem().toString());
					pst.setString(10, txtProdLocal.getText());	
					pst.setString(11, txtProdCusto.getText());
					pst.setString(12, txtProdLucro.getText());
					pst.setString(13, txtForID.getText());
					pst.setString(14, txtProdID.getText());
					
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso");
					con.close();
					limparCampos();
				}catch (SQLIntegrityConstraintViolationException ex) {

					JOptionPane.showMessageDialog(null,
							"Ocorreu um erro. \nVerifique novamente o Produto ");
					txtProdNome.requestFocus();			
					limparCampos();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
		
		private void excluirFornecedor() {
			int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do produto?", "Atenção!",
					JOptionPane.YES_NO_OPTION);
			if (confirma == JOptionPane.YES_OPTION) {
				String delete = "delete from produtos where codigo=?;";
				try {
					Connection con = dao.conectar();
					PreparedStatement pst = con.prepareStatement(delete);
					pst.setString(1, txtProdID.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Produto excluído com sucesso.");
					limparCampos();
				} catch (Exception e) {
					System.out.println(e);
				}
			}

		}
		private void limparCampos() {
			txtProdBarcode.setText(null);
			txtProdNome.setText(null);
			txtProdDescricao.setText(null);
			txtProdFabricante.setText(null);
			txtProdEstoqueMin.setText(null);
			txtProdCusto.setText(null);
			txtProdLocal.setText(null);
			txtProdID.setText(null);		
			txtProdLucro.setText(null);
			cboProdUnidade.setSelectedItem("");
			txtForID.setText(null);
			txtBuscarFor.setText(null);
			dataEntrada.setDate(null);
			dataValidade.setDate(null);
			((DefaultTableModel) tblFornecedores.getModel()).setRowCount(0);
			btnAdicionar.setEnabled(true);
			btnAlterar.setEnabled(false);
			btnExcluir.setEnabled(false);
		}
		private void limparCamposBarcode() {
			txtProdNome.setText(null);
			txtProdDescricao.setText(null);
			txtProdFabricante.setText(null);
			txtProdEstoqueMin.setText(null);
			txtProdCusto.setText(null);
			txtProdLocal.setText(null);
			txtProdID.setText(null);		
			txtProdLucro.setText(null);
			cboProdUnidade.setSelectedItem("");
			txtForID.setText(null);
			txtBuscarFor.setText(null);
			dataEntrada.setDate(null);
			dataValidade.setDate(null);
			((DefaultTableModel) tblFornecedores.getModel()).setRowCount(0);
			btnAdicionar.setEnabled(true);
			btnAlterar.setEnabled(false);
			btnExcluir.setEnabled(false);
		}
}//fim