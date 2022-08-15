package view;

import java.awt.Color;
import java.awt.Cursor;
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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;
public class Usuarios extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtUsuId;
	private JTextField txtUsuNome;
	private JTextField txtUsuLogin;
	private JPasswordField txtUsuSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuarios dialog = new Usuarios();
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
	public Usuarios() {
		setResizable(false);
		setModal(true);
		setTitle("U S U \u00C1 R I O S");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Usuarios.class.getResource("/img/users.png")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(20, 24, 31, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usu\u00E1rio");
		lblNewLabel_1.setBounds(20, 71, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtUsuId = new JTextField();
		txtUsuId.setEditable(false);
		txtUsuId.setBounds(61, 21, 67, 20);
		getContentPane().add(txtUsuId);
		txtUsuId.setColumns(10);
		
		txtUsuNome = new JTextField();
		txtUsuNome.setBounds(76, 68, 160, 20);
		getContentPane().add(txtUsuNome);
		txtUsuNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setBounds(138, 24, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		txtUsuLogin = new JTextField();
		txtUsuLogin.setBounds(190, 21, 160, 20);
		getContentPane().add(txtUsuLogin);
		txtUsuLogin.setColumns(10);
		
		txtUsuSenha = new JPasswordField();
		txtUsuSenha.setBounds(76, 113, 160, 20);
		getContentPane().add(txtUsuSenha);
		
		JLabel lblNewLabel_2_1 = new JLabel("Senha");
		lblNewLabel_2_1.setBounds(20, 116, 46, 14);
		getContentPane().add(lblNewLabel_2_1);
		
		cboUsuPerfil = new JComboBox();
		cboUsuPerfil.setModel(new DefaultComboBoxModel(new String[] {"", "admin", "vendedor", "user"}));
		cboUsuPerfil.setBounds(76, 156, 67, 22);
		getContentPane().add(cboUsuPerfil);
		
		btnAdicionar = new JButton("");
		btnAdicionar.setEnabled(false);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarUsuario();
			}
		});
		btnAdicionar.setToolTipText("Adicionar");
		btnAdicionar.setIcon(new ImageIcon(Usuarios.class.getResource("/img/create.png")));
		btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.setBorderPainted(false);
		btnAdicionar.setBounds(165, 186, 64, 64);
		getContentPane().add(btnAdicionar);
		
		JLabel lblNewLabel_3 = new JLabel("Perfil");
		lblNewLabel_3.setBounds(20, 160, 29, 14);
		getContentPane().add(lblNewLabel_3);
		
		btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirUsuario();
			}
		});
		btnExcluir.setEnabled(false);
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.setIcon(new ImageIcon(Usuarios.class.getResource("/img/delete.png")));
		btnExcluir.setToolTipText("Excluir");
		btnExcluir.setContentAreaFilled(false);
		btnExcluir.setBorderPainted(false);
		btnExcluir.setBounds(317, 186, 64, 64);
		getContentPane().add(btnExcluir);
		
		btnAlterar = new JButton("");
		btnAlterar.setEnabled(false);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkSenha.isSelected()) {
					alterarUsuarioSenha();
				} else {
					alterarUsuario();
				}
			}
		});
		btnAlterar.setIcon(new ImageIcon(Usuarios.class.getResource("/img/modify.png")));
		btnAlterar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlterar.setToolTipText("Alterar");
		btnAlterar.setContentAreaFilled(false);
		btnAlterar.setBorderPainted(false);
		btnAlterar.setBounds(243, 186, 64, 64);
		getContentPane().add(btnAlterar);
		
		JButton btnPesquisar = new JButton("");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarUsuario();
			}
		});
		btnPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPesquisar.setIcon(new ImageIcon(Usuarios.class.getResource("/img/find.png")));
		btnPesquisar.setToolTipText("Procurar");
		btnPesquisar.setContentAreaFilled(false);
		btnPesquisar.setBorderPainted(false);
		btnPesquisar.setBounds(360, 11, 64, 64);
		getContentPane().add(btnPesquisar);

		
		//validação com o uso da biblioteca atxy2k
		//txtUsuId
		RestrictedTextField validarId = new RestrictedTextField(txtUsuId);
		validarId.setOnlyNums(true);
		validarId.setLimit(4);
		//txtUsuNome
		RestrictedTextField validarNome = new RestrictedTextField(txtUsuNome);
		validarNome.setLimit(40);
		//txtUsuLogin
		RestrictedTextField validarLogin = new RestrictedTextField(txtUsuLogin);
		validarLogin.setLimit(15);
		//txtUsuSenha
		RestrictedTextField validarSenha = new RestrictedTextField(txtUsuSenha);
		
		chkSenha = new JCheckBox("Alterar senha");
		chkSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//alterar a cor do background de uma caixa de texto
				txtUsuSenha.setBackground(Color.ORANGE);
				txtUsuSenha.setText(null);
				txtUsuSenha.requestFocus();
				txtUsuSenha.setEditable(true);
			}
		});
		chkSenha.setVisible(false);
		chkSenha.setBounds(261, 112, 140, 23);
		getContentPane().add(chkSenha);
		validarSenha.setLimit(255);
		
	}//Fim do Construtor
	
	
	DAO dao = new DAO();
	private JComboBox cboUsuPerfil;
	private JButton btnAdicionar;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JCheckBox chkSenha;
	
	
	
	/**
	 * Método responsável pela pesquisa de usuários
	 */
	
	private void pesquisarUsuario() {
		// validação
		if (txtUsuLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "digite o ID do usúario");
			txtUsuId.requestFocus();
		} else {
			// Lógica principal
			// Query (Instrução SQL)
			String read = "select * from usuarios where login = ?";
			// tratar exceções sempre que lidar com o banco
			try {
				// estabelecer conexão
				Connection con = dao.conectar();
				// Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(read);
				// Setar o arguemento (id)
				pst.setString(1, txtUsuLogin.getText());
				// Executar a query e exibir o resultado no formulario
				ResultSet rs = pst.executeQuery();
				// validação(existencia de usuario)
				if (rs.next()) {
					// preencher (setar) os campos do formuralario
					txtUsuId.setText(rs.getString(1));
					txtUsuNome.setText(rs.getString(2));
					txtUsuLogin.setText(rs.getString(3));
					cboUsuPerfil.setSelectedItem(rs.getString(5));
					txtUsuSenha.setText(rs.getString(4));
					btnAlterar.setEnabled(true);
					btnExcluir.setEnabled(true);
					chkSenha.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Usúario inexistente");
					txtUsuNome.setEditable(true);
					cboUsuPerfil.setEnabled(true);
					cboUsuPerfil.setEditable(true);
					txtUsuSenha.setEditable(true);
					txtUsuNome.requestFocus();
					btnAdicionar.setEnabled(true);
				}
				// Nunca esquecer de encerrar a conexão
				con.close();

			} catch (SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "Login em uso.\nEscolha outro login.");
				txtUsuLogin.setText(null);
				txtUsuLogin.requestFocus();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}
	
	/*
	 * Método responsavel por adicionar um novo usuario no banco
	 */
		
	private void adicionarUsuario() {
		// validação da senha
		String capturaSenha =  new String(txtUsuSenha.getPassword());
		
		//validação
				
		if (txtUsuNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Nome do usuário");
			txtUsuNome.requestFocus();
		} 
		else if (txtUsuLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Login do usuário");
			txtUsuNome.requestFocus();
		}
		else if (txtUsuSenha.getPassword().length == 0) {
			JOptionPane.showMessageDialog(null,"Preencha a Senha");
			txtUsuSenha.requestFocus();
		}			
		else if (cboUsuPerfil.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null,"Selecione o Perfil do Usuário");
			cboUsuPerfil.requestFocus();
		}
		else {
			String create = "insert into usuarios (usuario,login,senha,perfil) values (?,?,md5(?),?);";
			try {
				//Estabelecer a conexão
				Connection con = dao.conectar();
				//Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(create);
				//Substituir os (?) pelo conteúdo da caixa de texto
				pst.setString(1, txtUsuNome.getText());
				pst.setString(2, txtUsuLogin.getText());
				pst.setString(3, capturaSenha);
				pst.setString(4, cboUsuPerfil.getSelectedItem().toString());
				//executar a query e inserir o usuario
				pst.executeUpdate();
				
				//Aviso de adição
				JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
				
				//limpar campos
				limparCampos();
				// fechar a conexão
				con.close();
			} 
			catch (SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "Login em uso.\nEscolha outro LOGIN.");
				txtUsuLogin.requestFocus();
				txtUsuLogin.setText(null);
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	/**
	 * Método responsavel por alterar um novo usuario no banco
	 */
	private void alterarUsuario() {
		// validação
		if (txtUsuNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o usúario");
			txtUsuNome.requestFocus();
		} else if (txtUsuLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o login");
			txtUsuLogin.requestFocus();
		} else if (cboUsuPerfil.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Selecione o perfil do usuário");
			cboUsuPerfil.requestFocus();
		} else {
			// lógica principal
			String update = "update usuarios set usuario=?, login=? ,perfil=? where idusu=?";
			try {
				// estabelecer conexão
				Connection con = dao.conectar();
				// Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(update);
				// Substituir os ???? pelo conteudo das caixas de texto
				pst.setString(1, txtUsuNome.getText());
				pst.setString(2, txtUsuLogin.getText());
				pst.setString(3, cboUsuPerfil.getSelectedItem().toString());
				pst.setString(4, txtUsuId.getText());
				// Executar a query e inserir o usuario no banco
				pst.executeUpdate();
				// Encerrar a conexão
				con.close();
				JOptionPane.showMessageDialog(null, "Usuario atualizado com sucesso");

			} catch (SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "Login em uso.\nEscolha outro login.");
				txtUsuLogin.setText(null);
				txtUsuLogin.requestFocus();

				limparCampos();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	/**
	 * Método responsavel por alterar um novo usuario no banco e alterar sua respectiva senha.
	 */
	private void alterarUsuarioSenha() {
		String capturaSenha = new String(txtUsuSenha.getPassword());
		// validação
		if (txtUsuNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o usúario");
			txtUsuNome.requestFocus();
		} else if (txtUsuLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o login");
			txtUsuLogin.requestFocus();
		} else if (cboUsuPerfil.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Selecione o perfil do usuário");
			cboUsuPerfil.requestFocus();
		} else if (txtUsuSenha.getPassword().length == 0) {
			JOptionPane.showMessageDialog(null, "Preencha a senha");
			txtUsuSenha.requestFocus();
		} else {
			// lógica principal
			String update2 = "update usuarios set usuario=?, login=?, senha=md5(?),perfil=? where idusu=?";
			try {
				// estabelecer conexão
				Connection con = dao.conectar();
				// Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(update2);
				// Substituir os ???? pelo conteudo das caixas de texto
				pst.setString(1, txtUsuNome.getText());
				pst.setString(2, txtUsuLogin.getText());
				pst.setString(3, capturaSenha);
				pst.setString(4, cboUsuPerfil.getSelectedItem().toString());
				pst.setString(5, txtUsuId.getText());
				// Executar a query e inserir o usuario no banco
				pst.executeUpdate();
				// Encerrar a conexão
				con.close();
				JOptionPane.showMessageDialog(null, "Usuario atualizado com sucesso");

			} catch (SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "Login em uso.\nEscolha outro login.");
				txtUsuLogin.setText(null);
				txtUsuLogin.requestFocus();

				limparCampos();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	/**
	 * Método responsavel por excluir um novo usuario no banco
	 */
	private void excluirUsuario () {
		//validação (confirmação de exclusão)
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do usuário?", "Atenção!",JOptionPane.YES_NO_OPTION);
		if(confirma == JOptionPane.YES_OPTION) {
			//Lógica principal
			String delete = "delete from usuarios where idusu=?;";
			
			try {
				// Estabelecer conexão
				Connection con = dao.conectar();
				// Preparar a execução da query (comando sql) substituindo a ? pelo iduser
				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1,txtUsuId.getText());
				// Executar a query
				pst.executeUpdate();
				// confirmação
				limparCampos();
				JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso.");
				
			limparCampos();
			}catch (Exception e) {
			System.out.println(e);
		}
		}
	
	}
	private void limparCampos() {
		txtUsuId.setText(null);
		txtUsuNome.setText(null);
		txtUsuLogin.setText(null);
		txtUsuSenha.setText(null);
		txtUsuSenha.setBackground(Color.WHITE);
		cboUsuPerfil.setSelectedItem("");
		btnAdicionar.setEnabled(false);
		btnAlterar.setEnabled(false);
		btnExcluir.setEnabled(false);
		chkSenha.setVisible(false);
		chkSenha.setSelected(false);
	}
} //Fim do c�digo
