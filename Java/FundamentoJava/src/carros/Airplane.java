/**
 * 
 */
package carros;

/**
 * @author Jefferson Cruz
 * 
 */
public class Airplane {

	/**
	 * Construtor
	 * @param args
	 */
	public static void main(String[] args) {
		// objeto1
		Aviao boing = new Aviao();
		boing.envergadura = 10;
		boing.ano = 1880;
		boing.cor = "Amarelo";
		System.out.println("Ano do Avi�o: " + boing.ano);
		System.out.println("Cor do Avi�o: " + boing.cor);
		System.out.println("Envergadura do Avi�o: " + boing.envergadura);
		boing.ligar();
		boing.desligar();
		boing.acelerar();
		boing.aterrizar();
	}
}