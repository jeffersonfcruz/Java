/**
 * Atividade de Avaliação - POO
 */
package carros;

/**
 * @author jefferson.wfcruz
 * Classe responsavel pela criação dos onjetos (Carros)
 */
public class Objeto {

	/**
	 * @param args
	 * Método Principal
	 */
	public static void main(String[] args) {
		Carro ferrari = new Carro ();
		ferrari.ano = 2022;
		ferrari.cor = "Vermelha";
		System.out.println("Ano: " + ferrari.ano);
		System.out.println("Cor do Carro: " + ferrari.cor);
		ferrari.ligar();
		ferrari.acelerar();
		ferrari.desligar();
		Carro fusca = new Carro();
		fusca.ano = 1965;
		fusca.cor = "Azul";
		System.out.println("Ano: " + fusca.ano);
		System.out.println("Cor do Carro: " + fusca.cor);
		fusca.ligar();
		fusca.acelerar();
		fusca.desligar();
	}

}
