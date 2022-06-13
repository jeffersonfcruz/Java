/**
 * POO - Fundamentos
 */
package minecraft;

/**
 * @author Jefferson Cruz
 * Classe Modelo
 */
public class Bloco {
	public Bloco() {
		super();
		System.out.println("-------------------------------------");
	}
	// Atributos
	int resistencia ; 
	String textura ;
	// Métodos
	// void = Método simples sem retorno
	/**
	 * Metodo usado para construir
	 */
	void construir () {
		System.out.println("Bloco colocado");
	}
	/**
	 * Metodo usado para Minerar
	 */
	void minerar () {
		System.out.println("Recursos obtidos");
	}
	/**
	 * Metodo usado para Craftar
	 */
	void craftar () {
		System.out.println("Item Criado");
	}
}
