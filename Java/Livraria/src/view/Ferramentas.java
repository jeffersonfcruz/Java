package view;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JDialog;

public class Ferramentas extends JDialog {

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
					Ferramentas dialog = new Ferramentas();
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
	public Ferramentas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ferramentas.class.getResource("/img/ferramentas.png")));
		setModal(true);
		setTitle("F E R R A M E N T A S");
		setBounds(100, 100, 450, 300);

	}

}
