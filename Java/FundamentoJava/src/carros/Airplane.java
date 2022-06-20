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
		System.out.println("Ano do Avião: " + boing.ano);
		System.out.println("Cor do Avião: " + boing.cor);
		System.out.println("Envergadura do Avião: " + boing.envergadura);
		boing.ligar();
		boing.desligar();
		boing.acelerar();
		boing.aterrizar();
	}
}