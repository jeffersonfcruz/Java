/**
 * POO - Fundamentos
 * Atividade Avaliação
 */
package carros;

/**
 * @author Jefferson Cruz
 * Classe Modelo
 */
public class Carro {
	public Carro() {
		super();
		System.out.println("-----------------------------------------------------");
	}
	int ano;
	String cor;

	/**
	 * Metodo usado para ligar o carro
	 */
	void ligar () {
		System.out.println("Carro Ligado");
	}
	/**
	 * Metodo usado para desligar o Carro
	 */
	void desligar () {
		System.out.println("Carro Desligado");
	}
	/**
	 * Metodo usado para Acelerar
	 */
	void acelerar() {
		System.out.println("Acelerando");
	}
}
