package view;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Clientes extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCliId;
	private JTextField txtCliNome;
	private JTextField txtCliFone;
	private JTextField txtCliCpf;
	private JTextField txtCliEmail;
	private JComboBox cboCliEmail;
	private JTextField txtCliCEP;
	public JTextField txtCliEnd;
	private JTextField txtCliNum;
	private JTextField txtCliComplemento;
	public JTextField txtCliBairro;
	public JTextField txtCliCidade;
	public JComboBox cboCliUf;
	public JButton btnBuscarCep;
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
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Clientes.class.getResource("/img/clientes.png")));
		setTitle("C L I E N T E S");
		setModal(true);
		setBounds(100, 100, 450, 501);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID: ");
		lblNewLabel.setBounds(10, 137, 37, 14);
		getContentPane().add(lblNewLabel);
		
		txtCliNome = new JTextField();
		txtCliNome.setBounds(104, 160, 320, 17);
		getContentPane().add(txtCliNome);
		txtCliNome.setColumns(10);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setBounds(10, 162, 37, 14);
		getContentPane().add(lblNome);
		
		txtCliId = new JTextField();
		txtCliId.setColumns(10);
		txtCliId.setBounds(32, 135, 77, 17);
		getContentPane().add(txtCliId);
		
		JLabel lblFone = new JLabel("FONE: ");
		lblFone.setBounds(10, 190, 37, 14);
		getContentPane().add(lblFone);
		
		txtCliFone = new JTextField();
		txtCliFone.setColumns(10);
		txtCliFone.setBounds(57, 188, 160, 17);
		getContentPane().add(txtCliFone);
		
		JLabel lblCpf = new JLabel("CPF: ");
		lblCpf.setBounds(10, 245, 37, 14);
		getContentPane().add(lblCpf);
		
		txtCliCpf = new JTextField();
		txtCliCpf.setColumns(10);
		txtCliCpf.setBounds(57, 243, 160, 17);
		getContentPane().add(txtCliCpf);
		
		JLabel lblEmail = new JLabel("EMAIL: ");
		lblEmail.setBounds(10, 218, 54, 14);
		getContentPane().add(lblEmail);
		
		txtCliEmail = new JTextField();
		txtCliEmail.setColumns(10);
		txtCliEmail.setBounds(57, 215, 207, 17);
		getContentPane().add(txtCliEmail);
		
		JLabel lblMarketing = new JLabel("Deseja receber email? : ");
		lblMarketing.setBounds(227, 190, 150, 14);
		getContentPane().add(lblMarketing);
		
		cboCliEmail = new JComboBox();
		cboCliEmail.setModel(new DefaultComboBoxModel(new String[] {"", "S", "N"}));
		cboCliEmail.setBounds(370, 186, 54, 22);
		getContentPane().add(cboCliEmail);
		
		JLabel lblCep = new JLabel("CEP: ");
		lblCep.setBounds(10, 273, 37, 14);
		getContentPane().add(lblCep);
		
		txtCliCEP = new JTextField();
		txtCliCEP.setColumns(10);
		txtCliCEP.setBounds(56, 271, 86, 17);
		getContentPane().add(txtCliCEP);
		
		JLabel lblEndereo = new JLabel("ENDERE\u00C7O:");
		lblEndereo.setBounds(10, 301, 77, 14);
		getContentPane().add(lblEndereo);
		
		txtCliComplemento = new JTextField();
		txtCliComplemento.setColumns(10);
		txtCliComplemento.setBounds(264, 326, 160, 17);
		getContentPane().add(txtCliComplemento);
		
		JLabel lblNumero = new JLabel("NUMERO:");
		lblNumero.setBounds(283, 273, 54, 14);
		getContentPane().add(lblNumero);
		
		txtCliNum = new JTextField();
		txtCliNum.setColumns(10);
		txtCliNum.setBounds(347, 271, 77, 17);
		getContentPane().add(txtCliNum);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(173, 326, 91, 14);
		getContentPane().add(lblComplemento);
		
		txtCliEnd = new JTextField();
		txtCliEnd.setColumns(10);
		txtCliEnd.setBounds(85, 299, 339, 17);
		getContentPane().add(txtCliEnd);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 358, 54, 14);
		getContentPane().add(lblBairro);
		
		txtCliBairro = new JTextField();
		txtCliBairro.setColumns(10);
		txtCliBairro.setBounds(57, 356, 106, 17);
		getContentPane().add(txtCliBairro);
		
		cboCliUf = new JComboBox();
		cboCliUf.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cboCliUf.setBounds(347, 354, 77, 22);
		getContentPane().add(cboCliUf);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 328, 86, 14);
		getContentPane().add(lblCidade);
		
		JLabel lblMarketing_1_1 = new JLabel("UF:");
		lblMarketing_1_1.setBounds(303, 357, 37, 17);
		getContentPane().add(lblMarketing_1_1);
		
		txtCliCidade = new JTextField();
		txtCliCidade.setColumns(10);
		txtCliCidade.setBounds(57, 324, 106, 17);
		getContentPane().add(txtCliCidade);
		
		btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirClientes();
			}
		});
		btnExcluir.setEnabled(false);
		btnExcluir.setDefaultCapable(false);
		btnExcluir.setContentAreaFilled(false);
		btnExcluir.setToolTipText("Excluir");
		btnExcluir.setIcon(new ImageIcon(Clientes.class.getResource("/img/delete.png")));
		btnExcluir.setBounds(360, 387, 64, 64);
		getContentPane().add(btnExcluir);
		
		btnAlterar = new JButton("");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarClientes();
			}
		});
		btnAlterar.setEnabled(false);
		btnAlterar.setToolTipText("Alterar");
		btnAlterar.setBorderPainted(false);
		btnAlterar.setContentAreaFilled(false);
		btnAlterar.setIcon(new ImageIcon(Clientes.class.getResource("/img/modify.png")));
		btnAlterar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlterar.setBounds(286, 387, 64, 64);
		getContentPane().add(btnAlterar);
		
		btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarClientes();
			}
		});
		btnAdicionar.setToolTipText("Adicionar");
		btnAdicionar.setIcon(new ImageIcon(Clientes.class.getResource("/img/create.png")));
		btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.setBorderPainted(false);
		btnAdicionar.setBounds(210, 387, 64, 64);
		getContentPane().add(btnAdicionar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarClientes();
			}
		});
		btnBuscar.setBounds(119, 133, 89, 23);
		getContentPane().add(btnBuscar);
		
		btnBuscarCep = new JButton("Buscar CEP");
		btnBuscarCep.setEnabled(false);
		btnBuscarCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtCliCEP.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o CEP para realizar a busca do endereço");
					txtCliCEP.requestFocus();
				} else {
					buscarCEP();
				}
			}
		});
		btnBuscarCep.setBounds(152, 269, 112, 23);
		getContentPane().add(btnBuscarCep);

		// Validacao com o uso da biblioteca Atxy2k

				// txtCliCPF
				RestrictedTextField validarCPF = new RestrictedTextField(txtCliCpf);

				// Restringir a somente numeros no campo CPF
				validarCPF.setOnlyNums(true);
				// Limitar a somente 14 numeros no campo CPF
				validarCPF.setLimit(14);

				// txtCliNome
				RestrictedTextField validarNome = new RestrictedTextField(txtCliNome);

				// Restringir a somente letras no campo nome
				validarNome.setOnlyText(true);
				// Aceitar espaco no campo nome
				validarNome.setAcceptSpace(true);
				// Limitar a somente 100 caracteres no campo nome
				validarNome.setLimit(100);

				// txtCliFone
				RestrictedTextField validarFone = new RestrictedTextField(txtCliFone);

				// Restringir a somente numeros no campo Fone
				validarFone.setOnlyNums(true);
				// Limitar a somente 14 numeros no campo Fone
				validarFone.setLimit(14);

				// txtCliEmail
				RestrictedTextField validarEmail = new RestrictedTextField(txtCliEmail);

				// Limitar a somente 50 caracteres no campo email
				validarEmail.setLimit(50);

				// txtCliCEP
				RestrictedTextField validarCEP = new RestrictedTextField(txtCliCEP);

				// Restringir a somente numeros no campo CEP
				validarCEP.setOnlyNums(true);
				// Limitar a somente 8 numeros no campo CEP
				validarCEP.setLimit(8);

				// txtCliEndereco
				RestrictedTextField validarEndereco = new RestrictedTextField(txtCliEnd);

				// Restringir a somente letras no campo endereco
				validarEndereco.setOnlyText(true);
				// Aceitar espaco no campo endereco
				validarEndereco.setAcceptSpace(true);
				// Limitar a somente 60 caracteres no campo endereco
				validarEndereco.setLimit(60);

				// txtCliNumero
				RestrictedTextField validarNumero = new RestrictedTextField(txtCliNum);

				// Restringir a somente digitos no campo numero
				validarNumero.setOnlyNums(true);
				// Limitar a somente 10 digitos no campo numero
				validarNumero.setLimit(10);

				// txtCliComplemento
				RestrictedTextField validarComplemento = new RestrictedTextField(txtCliComplemento);

				// Limitar a somente 50 caracteres no campo complemento
				validarComplemento.setLimit(50);

				// txtCliBairro
				RestrictedTextField validarBairro = new RestrictedTextField(txtCliBairro);

				// Limitar a somente 50 caracteres no campo bairro
				validarBairro.setLimit(50);

				// txtCliCidade
				RestrictedTextField validarCidade = new RestrictedTextField(txtCliCidade);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(210, 11, 214, 140);
				getContentPane().add(scrollPane);
				
				tblClientes = new JTable();
				tblClientes.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					//evento clicar com o mouse na tabela
						setarCaixasTexto();
					}
				});
				scrollPane.setViewportView(tblClientes);
				
				txtPesquisarCliente = new JTextField();
				txtPesquisarCliente.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {
						pesquisarClienteTabela();
					}
				});
				txtPesquisarCliente.setColumns(10);
				txtPesquisarCliente.setBounds(10, 38, 190, 22);
				getContentPane().add(txtPesquisarCliente);
				
				JLabel lblNewLabel_1 = new JLabel("Procure por um Cliente:");
				lblNewLabel_1.setBounds(10, 12, 190, 14);
				getContentPane().add(lblNewLabel_1);

				// Restringir a somente letras no campo cidade
				validarCidade.setOnlyText(true);
				// Aceitar espaco no campo cidade
				validarCidade.setAcceptSpace(true);
				// Limitar a somente 50 caracteres no campo cidade
				validarCidade.setLimit(50);
	}
	DAO dao = new DAO();
	private JTable tblClientes;
	private JTextField txtPesquisarCliente;
	
	private void pesquisarClienteTabela() {
		String readT = "select idcli as ID ,nome as Nome,fone as Telefone from clientes where nome like ?";
		try {
			// estabelecer conexão
			Connection con = dao.conectar();
			// Preparar a execução da query
			PreparedStatement pst = con.prepareStatement(readT);
			// Substituir os ???? pelo conteudo das caixas de texto
			pst.setString(1, txtPesquisarCliente.getText() + "%");
			ResultSet rs = pst.executeQuery();
			//uso da biblioteca ts2xml para "popular" a tabela
			tblClientes.setModel(DbUtils.resultSetToTableModel(rs));
			
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
		int setar = tblClientes.getSelectedRow();
		txtCliId.setText(tblClientes.getModel().getValueAt(setar, 0).toString());
		limparCamposClientes();
	}
	// demais metodos de CRUD
	
	/**
	 * Limpar campos
	 */
	private void limparCamposClientes() {
		//limpar a tabela
		((DefaultTableModel) tblClientes.getModel()).setRowCount(0);
	}
	
	
	
	private void pesquisarClientes () {
		if (txtCliId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "digite o ID do Cliente");
			txtCliId.requestFocus();
		} else {
			String read = "select * from clientes where idcli = ?";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(read);
				pst.setString(1, txtCliId.getText());
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					btnAlterar.setEnabled(true);
					btnExcluir.setEnabled(true);
					txtCliId.setText(rs.getString(1));
					txtCliNome.setText(rs.getString(2));
					txtCliFone.setText(rs.getString(3));
					txtCliCpf.setText(rs.getString(4));
					txtCliEmail.setText(rs.getString(5));
					cboCliEmail.setSelectedItem(rs.getString(6));
					txtCliCEP.setText(rs.getString(7));
					txtCliEnd.setText(rs.getString(8));
					txtCliNum.setText(rs.getString(9));
					txtCliComplemento.setText(rs.getString(10));
					txtCliBairro.setText(rs.getString(11));
					txtCliCidade.setText(rs.getString(12));
					cboCliUf.setSelectedItem(rs.getString(13));
					btnAdicionar.setEnabled(false);
					btnBuscarCep.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Cliente inexistente");
					limparCliCampos();
					btnAdicionar.setEnabled(true);
				}
				con.close();
			} 	catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	private void adicionarClientes() {
		// validação
		if (txtCliNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o nome do cliente");
			txtCliNome.requestFocus();
		} else if (txtCliFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha telefone do cliente");
			txtCliFone.requestFocus();
		} else if (cboCliEmail.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Selecione se o cliente deseja receber emails");
			cboCliEmail.requestFocus();
		} else {
			// lógica principal
			String create = "insert into clientes (nome,fone,cpf,email,marketing,cep,endereco,numero,complemento,bairro,cidade,uf) values(?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				// estabelecer conexão
				Connection con = dao.conectar();
				// Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(create);
				// Substituir os ???? pelo conteudo das caixas de texto
				pst.setString(1, txtCliNome.getText());
				pst.setString(2, txtCliFone.getText());
				pst.setString(3, txtCliCpf.getText());
				pst.setString(4, txtCliEmail.getText());
				pst.setString(5,cboCliEmail.getSelectedItem().toString());
				pst.setString(6, txtCliCEP.getText());
				pst.setString(7, txtCliEnd.getText());
				pst.setString(8, txtCliNum.getText());
				pst.setString(9,txtCliComplemento.getText());
				pst.setString(10,txtCliBairro.getText());
				pst.setString(11,txtCliCidade.getText());
				pst.setString(12,cboCliUf.getSelectedItem().toString());
				// Executar a query e inserir o usuario no banco
				pst.executeUpdate();
				limparCliCampos();
				// Encerrar a conexão
				con.close();
				JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");	
			} catch (SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro.\nVerifique se os dados ja não estão inseridos em um outro cliente.");
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	private void alterarClientes() {
				if (txtCliId.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Digite o ID do cliente");
					txtCliId.requestFocus();
				} 
				else {
					String update = "update clientes set nome=?, fone=?, cpf=?, email=?, marketing=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, uf=? where idcli=?";
					try {
						Connection con = dao.conectar();
						PreparedStatement pst = con.prepareStatement(update);
						pst.setString(1, txtCliNome.getText());
						pst.setString(2, txtCliFone.getText());
						pst.setString(3, txtCliCpf.getText());
						pst.setString(4, txtCliEmail.getText());
						pst.setString(5, cboCliEmail.getSelectedItem().toString());
						pst.setString(6, txtCliCEP.getText());
						pst.setString(7, txtCliEnd.getText());
						pst.setString(8, txtCliNum.getText());
						pst.setString(9,  txtCliComplemento.getText());
						pst.setString(10, txtCliBairro.getText());
						pst.setString(11, txtCliCidade.getText());
						pst.setString(12, cboCliUf.getSelectedItem().toString());
						pst.setString(13, txtCliId.getText());
						pst.executeUpdate();
				
						limparCliCampos();
				
						// Encerrar a conexão
						con.close();
						
						JOptionPane.showMessageDialog(null, "Dados do cliente alterados");
					} catch (SQLIntegrityConstraintViolationException ex) {
						JOptionPane.showMessageDialog(null, "Ocorreu um erro.\nVerifique se os dados ja não estão inseridos em um outro cliente.");
					} catch (Exception e) {
						System.out.println(e);
						}
				}
	}
	private void excluirClientes () {
		//validação (confirmação de exclusão)
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do cliente?", "Atenção!",JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			//Lógica principal
			String delete = "delete from clientes where idcli=?;";
			
			try {
				// Estabelecer conexão
				Connection con = dao.conectar();
				// Preparar a execução da query (comando sql) substituindo a ? pelo iduser
				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1,txtCliId.getText());
				// Executar a query
				pst.executeUpdate();
				// confirmação
				limparCliCampos();
				JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso.");
				
				limparCliCampos();
			}	catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	private void limparCliCampos() {
		txtCliNome.setText(null);
		txtCliId.setText(null);
		txtCliFone.setText(null);
		txtCliCpf.setText(null);
		txtCliEmail.setText(null);
		txtCliCEP.setText(null);
		txtCliComplemento.setText(null);
		txtCliNum.setText(null);
		txtCliEnd.setText(null);
		txtCliBairro.setText(null);
		txtCliCidade.setText(null);
		cboCliUf.setSelectedItem("");
		cboCliEmail.setSelectedItem("");
		btnAdicionar.setEnabled(false);
		btnAlterar.setEnabled(false);
		btnExcluir.setEnabled(false);
		
	}
	private void buscarCEP() {

		String logradouro = "";
		String tipoLogradouro = "";
		String resultado = null;
		String CEP = txtCliCEP.getText();

		try {

			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + CEP + "&formato=xml");

			SAXReader xml = new SAXReader();

			Document documento = xml.read(url);

			Element root = documento.getRootElement();

			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {

				Element element = it.next();

				if (element.getQualifiedName().equals("cidade")) {
					txtCliCidade.setText(element.getText());
				}

				if (element.getQualifiedName().equals("bairro")) {
					txtCliBairro.setText(element.getText());
				}

				if (element.getQualifiedName().equals("uf")) {
					cboCliUf.setSelectedItem(element.getText());
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
			txtCliEnd.setText(tipoLogradouro + " " + logradouro);

		}
		catch (Exception e) {
			System.out.println(e);
		}

	}
}
