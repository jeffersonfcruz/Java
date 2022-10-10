package view;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JDialog;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAO;

public class Relatorios extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorios dialog = new Relatorios();
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
	public Relatorios() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Relatorios.class.getResource("/img/relatorios.png")));
		setTitle("R E L A T \u00D3 R I O S");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JButton btnRelClientes = new JButton("Clientes");
		btnRelClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioClientes();
			}
		});
		btnRelClientes.setBounds(81, 49, 89, 23);
		getContentPane().add(btnRelClientes);
		
		JButton btnRelVencidos = new JButton("Produtos Vencidos");
		btnRelVencidos.setBounds(10, 83, 160, 23);
		getContentPane().add(btnRelVencidos);
		
		JButton btnRelInventario = new JButton("Inventario");
		btnRelInventario.setBounds(260, 83, 101, 23);
		getContentPane().add(btnRelInventario);
		
		JButton btnRelFornecedores = new JButton("Fornecedores");
		btnRelFornecedores.setBounds(260, 49, 131, 23);
		getContentPane().add(btnRelFornecedores);
		
		JButton btnRelReposicao = new JButton("Reposição de Estoque");
		btnRelReposicao.setBounds(10, 117, 160, 23);
		getContentPane().add(btnRelReposicao);
		
		JButton btnRelMarketing = new JButton("E-Mail Marketing");
		btnRelMarketing.setBounds(260, 117, 164, 23);
		getContentPane().add(btnRelMarketing);

	}
	DAO dao = new DAO();
	
	//método responsavel pela impressao do relatorio de clientes
	
	private void relatorioClientes() {
		Document document = new Document();
		try {
			//cria um documento pdf de nome clientes.pdf
			PdfWriter.getInstance(document, new FileOutputStream("clientes.pdf"));
			document.open();
			//gerar o conteudo do documento
			document.add(new Paragraph("Clientes Cadastrados"));
		} catch (Exception e) {
			System.out.println(e);
		} finally { //executa o código independentedo resultado OK ou não
			document.close();
		}
		// abrir um documento gerado no leitor padrão de pdf do sistema
		try {
			Desktop.getDesktop().
		} catch {
			
		}
	}
}
