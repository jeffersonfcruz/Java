/**
 * 
 */
package carros;

/**
 * @author Jefferson Cruz
 *
 */
public class Aviao extends Carro {

	/**
	 *
	 */
	public Aviao() {
		System.out.println("_____________________");
	}
		// Atributos
		double envergadura;
		void aterrizar() {
			System.out.println("Avi�o Aterrizando");
		}
		void acelerar () {
			System.out.println("Avi�o Acelerando");
		}
		void ligar () {
			System.out.println("Avi�o Ligado");
		}
		void desligar () {
			System.out.println("Avi�o Desligado");
		}
}