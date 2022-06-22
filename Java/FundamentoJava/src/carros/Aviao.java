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
			System.out.println("Diminuindo velocidade e altura");
		}
		void acelerar () {
			System.out.println("Avião aumentando velocidade e altura");
		}
		void ligar () {
			System.out.println("Avião ligado");
		}
		void desligar () {
			System.out.println("Avião desligado");
		}
}