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

import com.toedter.calendar.JDateChooser;

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
	private JTextField txtProdFornecedor;
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
			
			public void keyReleased(KeyEvent e) {
				
			}
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			@Override
			//evento usado no leitor de código de barras
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
		//txtBuscarFor.setText("Digite para pesquisar...        ");
		
		//txtBuscarFor.addFocusListener(new FocusListener() {

			//@Override
			//public void focusGained(FocusEvent event) {
				//if (txtBuscarFor.getText().equals("Digite para pesquisar...     ")) {
					//txtBuscarFor.setText("");
				//}
			//}

			//@Override
			//public void focusLost(FocusEvent event) {
				//if (txtBuscarFor.getText().equals("")) {
					//txtBuscarFor.setText("Digite para pesquisar...     ");
				//}
			//}
		//});

		txtBuscarFor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// Evento digitacao
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

		txtProdFornecedor = new JTextField();
		txtProdFornecedor.setEnabled(false);
		txtProdFornecedor.setBounds(104, 355, 286, 20);
		getContentPane().add(txtProdFornecedor);

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
			// Estabelecer a conexao
			Connection con = dao.conectar();

			// Preparar a execucao da query
			PreparedStatement pst = con.prepareStatement(readT);

			// Setar o argumento (fantasia)
			// Substituir o ? pelo conteudo da caixa de texto
			pst.setString(1, txtBuscarFor.getText() + "%");

			// Executar a query e exibir o resultado no formulario
			ResultSet rs = pst.executeQuery();

			// Uso da bilblioteca rs2xml para "popular" a tabela
			tblFornecedores.setModel(DbUtils.resultSetToTableModel(rs));

			if (txtBuscarFor.getText().isEmpty()) {
				//limparCampos();
				txtForID.setText(null);
				btnAdicionar.setEnabled(true);
			}

			// NUNCA esquecer de encerrar a conexao
			con.close();

		}

		// Tratar excecoes sempre que lidar com o banco
		catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Metodo responsavel pela pesquisa do ID do fornecedor (setar as caixas de
	 * texto de acordo com os campos da tabela)
	 */

	private void setarCaixasTexto() {

		// Criar uma variavel para receber a linha da tabela
		int setar = tblFornecedores.getSelectedRow();

		txtForID.setText(tblFornecedores.getModel().getValueAt(setar, 0).toString());
		txtBuscarFor.setText(tblFornecedores.getModel().getValueAt(setar, 2).toString());
		txtProdFornecedor.setText(tblFornecedores.getModel().getValueAt(setar, 2).toString());
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
				 txtProdFornecedor.setText(rs.getString(5));
				 String setarDataCad = rs.getString(6);
					Date dataCad = new SimpleDateFormat("yyyy-MM-dd").parse(setarDataCad);
					dataEntrada.setDate(dataCad);
				//String setarDataVal = rs.getString(7);
					//Date dataVal = new SimpleDateFormat("yyyy-MM-dd").parse(setarDataVal);
					//dataValidade.setDate(dataVal);
				 txtProdEstoque.setText(rs.getString(8));
				 txtProdEstoqueMin.setText(rs.getString(9));
				 cboProdUnidade.setSelectedItem(rs.getString(10));
				 txtProdLocal.setText(rs.getString(11));
				 txtProdCusto.setText(rs.getString(12));
				 txtProdLucro.setText(rs.getString(13));
				 btnAlterar.setEnabled(true);
				 btnExcluir.setEnabled(true);
				 btnAdicionar.setEnabled(false);
			}else {
				JOptionPane.showMessageDialog(null, "Produto não cadastrado");
				btnAdicionar.setEnabled(true);
			}
			con.close();
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
					 txtProdFornecedor.setText(rs.getString(5));
					 String setarDataCad = rs.getString(6);
						Date dataCad = new SimpleDateFormat("yyyy-MM-dd").parse(setarDataCad);
						dataEntrada.setDate(dataCad);
					//String setarDataVal = rs.getString(7);
						//Date dataVal = new SimpleDateFormat("yyyy-MM-dd").parse(setarDataVal);
						//dataValidade.setDate(dataVal);
					 txtProdEstoque.setText(rs.getString(8));
					 txtProdEstoqueMin.setText(rs.getString(9));
					 cboProdUnidade.setSelectedItem(rs.getString(10));
					 txtProdLocal.setText(rs.getString(11));
					 txtProdCusto.setText(rs.getString(12));
					 txtProdLucro.setText(rs.getString(13));
					 btnAlterar.setEnabled(true);
					 btnExcluir.setEnabled(true);
					 btnAdicionar.setEnabled(false);
				}else {
					JOptionPane.showMessageDialog(null, "Produto não cadastrado");
					limparCampos();
					btnAdicionar.setEnabled(true);
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
				
			} else if (txtProdFornecedor.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o Nome do Fabricante");
				txtProdFornecedor.requestFocus();
				
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
				
			}	 else if (cboProdUnidade.getSelectedItem().equals("")) {
				JOptionPane.showMessageDialog(null, "Selecione a Unidade");
				cboProdUnidade.requestFocus();
			} else {
				// lógica principal
				String create = "insert into produtos(barcode,produto,descricao,fabricante,estoque,estoquemin,unidade,custo,localizacao,lucro,idfor) values(?,?,?,?,?,?,?,?,?,?,?)";
				try {
					// estabelecer conexão
					Connection con = dao.conectar();
					// Preparar a execução da query
					PreparedStatement pst = con.prepareStatement(create);
					// Substituir os ???? pelo conteudo das caixas de texto
					pst.setString(1,txtProdBarcode.getText());
					pst.setString(2,txtProdNome.getText());
					pst.setString(3,txtProdDescricao.getText());
					pst.setString(4,txtBuscarFor.getText());
					//pst.setString(5,txtProdValidade.getText());
					pst.setString(5,txtProdEstoque.getText());
					pst.setString(6,txtProdEstoqueMin.getText());
					pst.setString(7,cboProdUnidade.getSelectedItem().toString());
					pst.setString(8,txtProdCusto.getText());
					pst.setString(9,txtProdLocal.getText());	
					pst.setString(10,txtProdLucro.getText());
					pst.setString(11,txtForID.getText());
					
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
						txtProdNome.requestFocus();
						limparCampos(); 
						btnAdicionar.setEnabled(true);

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
				
			} else if (txtProdFornecedor.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o Nome do Fabricante");
				txtProdFornecedor.requestFocus();
				
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
				
			}	 else if (cboProdUnidade.getSelectedItem().equals("")) {
				JOptionPane.showMessageDialog(null, "Selecione a Unidade");
				cboProdUnidade.requestFocus();
			} else {
				String update = "update produtos set barcode=?,produto=?,descricao=?,fabricante=?,estoque=?,estoquemin=?,unidade=?, custo=?, localizacao=?,lucro=? where codigo =?";
				try {
					Connection con = dao.conectar();
					PreparedStatement pst = con.prepareStatement(update);
					pst.setString(1,txtProdBarcode.getText());
					pst.setString(2, txtProdNome.getText());
					pst.setString(3,  txtProdDescricao.getText());
					pst.setString(4, txtProdFornecedor.getText());
					//pst.setString(5,txtProdValidade.getText());
					pst.setString(5, txtProdEstoque.getText());
					pst.setString(6, txtProdEstoqueMin.getText());
					pst.setString(7, cboProdUnidade.getSelectedItem().toString());
					pst.setString(8, txtProdCusto.getText());
					pst.setString(9,txtProdLocal.getText());	
					pst.setString(10, txtProdLucro.getText());
					pst.setString(11,txtProdID.getText());
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
					limparCampos();
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
			txtProdFornecedor.setText(null);
			txtProdEstoque.setText(null);
			txtProdEstoqueMin.setText(null);
			txtProdCusto.setText(null);
			txtProdLocal.setText(null);
			txtProdID.setText(null);		
			txtProdLucro.setText(null);
			cboProdUnidade.setSelectedItem("");
			dataEntrada.setDate(null);
			btnAlterar.setEnabled(false);
			btnExcluir.setEnabled(false);
		}
}//fim