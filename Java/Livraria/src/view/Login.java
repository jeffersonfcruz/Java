package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
	setResizable(false);
		setTitle("L O G I N");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setBounds(37, 70, 70, 14);
		contentPane.add(lblNewLabel);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(112, 67, 241, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setBounds(37, 113, 70, 14);
		contentPane.add(lblNewLabel_1);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(112, 110, 241, 20);
		contentPane.add(txtSenha);
	
		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(Login.class.getResource("/img/dbofff.png")));
		lblStatus.setBounds(10, 186, 64, 64);
		contentPane.add(lblStatus);
		
		
		JButton btnLogar = new JButton("Acessar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar();
			}
		});
		
		btnLogar.setBounds(242, 147, 111, 23);
		contentPane.add(btnLogar);
		
		RestrictedTextField login = new RestrictedTextField(txtLogin);
		login.setLimit(10);

		RestrictedTextField senha = new RestrictedTextField(txtSenha);
		senha.setLimit(255);
		
		getRootPane().setDefaultButton(btnLogar);
	}
		
	
	
	//Criação de um objeto para acessar a camada model
		DAO dao = new DAO();
		private JLabel lblStatus;
		/**
		 * Método usado para verificar o status do servidor
		 */
		private void status() {
			try {
				// Abrir para conexão
				Connection con = dao.conectar();
				if (con == null) {
					//Escolher imagem dboff
					lblStatus.setIcon(new ImageIcon(Login.class.getResource("/img/dbon.png")));
				} else {
					// Escolher imagem dbon
					lblStatus.setIcon(new ImageIcon(Login.class.getResource("/img/dbofff.png")));
				}
				// Não esquecer de fechar a conexão
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		/**
		 * Método usado para autenticar um usuário
		 */
		private void logar() {
			// validação da senha (captura segura)
			String capturaSenha = new String(txtSenha.getPassword());
			//validação
			if (txtLogin.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Informe o seu Login");
				txtLogin.requestFocus();
			} else if(txtSenha.getPassword().length == 0) {
				JOptionPane.showMessageDialog(null, "Digite a sua senha");
				txtSenha.requestFocus();
			} else {
				//lógica principal
				String read = "select * from usuarios where login=? and senha = md5(?)";
				try {
					// abrir a conexão
					Connection con = dao.conectar();
					// Preparar a execução da query
					PreparedStatement pst = con.prepareStatement(read);
					// Setar os argumentos (login e senha)
					// Substituir os ?(argumentos) pelo conteúdo das caixas de texto
					pst.setString(1, txtLogin.getText());
					pst.setString(2, capturaSenha);
					// Executar a query e de acordo com o resultado liberar os recursos da tela principal
					ResultSet rs = pst.executeQuery();
					// Validação (autenticação de usuário)
					// rs.next() -> existência de login e senha correspondente
					if (rs.next()) {
						//Verificar o perfil do usuario
						String perfil = rs.getString(5);
						if (perfil.equals("admin")) {
							Principal principal = new Principal();
							principal.setVisible(true);
							//personalizar
							principal.btnRelatorios.setEnabled(true);
							principal.btnUsuarios.setEnabled(true);
							principal.panelUsuario.setBackground(Color.RED);
							//setar o nome do usuario na tela principal
							principal.lblUsuario.setText
							("Usuário: " + rs.getString(2));
							con.close();
							this.dispose();
						} else {
							Principal principal = new Principal();
							principal.setVisible(true);
							principal.lblUsuario.setText
							("Usuário: " + rs.getString(2));
							principal.panelUsuario.setBackground(Color.yellow);
							con.close();
							this.dispose();
						}
						//Principal principal = new Principal();
						//principal.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Login e/ou senha inválido(s)");
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
}