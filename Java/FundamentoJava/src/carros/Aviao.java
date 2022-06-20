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
			System.out.println("Avião Aterrizando");
		}
		void acelerar () {
			System.out.println("Avião Acelerando");
		}
		void ligar () {
			System.out.println("Avião Ligado");
		}
		void desligar () {
			System.out.println("Avião Desligado");
		}
}