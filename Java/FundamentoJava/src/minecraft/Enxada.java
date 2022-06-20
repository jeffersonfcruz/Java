/**
 * POO - Fundamentos
 */
package minecraft;

/**
 * @author Jefferson Cruz 
 * Classe modelo com heran�a (extends)
 */
public class Enxada extends Bloco {

	/**
	 * Construtor
	 */
	public Enxada() {
		System.out.println("____CAMPO____");
	}

	// atributos
	boolean conquista;

	// m�todo
	/**
	 * M�todo usado para arar a terra 
	 */
	void arar() {
		System.out.println("Terra preparada para o plantio");
		// aten��o
		conquista = true;
	}
	// Polimorfismo (sobrescrita do metodo minerar)
	void minerar() {
		System.out.println("Dano causado");
	}
}