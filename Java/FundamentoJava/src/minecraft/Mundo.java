/**
 * Jogo Minecraft (Exemplo POO)
 */
package minecraft;

/**
 * @author Jefferson Cruz
 * Classe responsavel pela criação dos objetos
 * 
 */
public class Mundo {

	/**
	 * Método Principal 
	 * @param args
	 */
	public static void main(String[] args) {
		// Objeto
		Bloco blocoTerra = new Bloco ();
		blocoTerra.resistencia = 1;
		blocoTerra.textura = "Terra";
		System.out.println("Bloco: "+ blocoTerra.textura);
		System.out.println("Resistencia: " + blocoTerra.resistencia);
		blocoTerra.construir();
		blocoTerra.minerar();
		// Objeto 2
		Bloco blocoMadeira = new Bloco();
		blocoMadeira.resistencia = 2;
		blocoMadeira.textura = "Madeira";
		System.out.println("Bloco: " + blocoMadeira.textura);
		System.out.println("Resistencia " + blocoMadeira.resistencia);
		blocoMadeira.minerar();
		blocoMadeira.craftar();
	}
}
