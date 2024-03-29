package view;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
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
	//método responsável pela impressão do relatório de clientes
		private void relatorioClientes() {
			//criar objeto para construir a página pdf
			Document document = new Document();
			//gerar o documento pdf
			try {
				//cria um documento pdf em branco de nome clientes.pdf
				PdfWriter.getInstance(document, new FileOutputStream("clientes.pdf"));
				document.open();
				//gerar o conteúdo do documento
				Date data = new Date();			
		        	DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
				document.add(new Paragraph(new Paragraph(formatador.format(data))));
				document.add(new Paragraph(" "));
				document.add(new Paragraph("Clientes cadastrados"));
				document.add(new Paragraph(" "));
				//... Demais conteúdos (imagem, tabela, gráfico, etc)
				PdfPTable tabela = new PdfPTable(4);
				PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
				PdfPCell col2 = new PdfPCell(new Paragraph("Fone"));
				PdfPCell col3 = new PdfPCell(new Paragraph("CPF"));
				PdfPCell col4 = new PdfPCell(new Paragraph("E-mail"));
				tabela.addCell(col1);
				tabela.addCell(col2);
				tabela.addCell(col3);
				tabela.addCell(col4);
				// Acessar o banco de dados
				 
				document.add(tabela);
			} catch (Exception e) {
				System.out.println(e);
			} finally { //executa o código independente do resultado OK ou não
				document.close();
			}
			
			//abrir o documento que foi gerado no leitor padrão de pdf do sistema (PC)
			try {
				Desktop.getDesktop().open(new File("clientes.pdf"));
			} catch (Exception e) {
				System.out.println(e);
			}
		}
}
