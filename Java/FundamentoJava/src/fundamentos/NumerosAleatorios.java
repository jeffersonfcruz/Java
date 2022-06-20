/**
 * Fundamentos do Java
 * Gerador de numeros e caracteres aleatorios
 */
package fundamentos;

import java.util.Random;

/**
 * Metodo Principal
 * @author Jefferson Cruz
 */
public class NumerosAleatorios {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Uso da classe Random para gerar numeros aleatorios
		Random gerador = new Random ();
		//(100) Gerar numeros entre 0 e 99
		//Exemplo 1
		int numero = gerador.nextInt(100);
		System.out.println(numero);
		//Exemplo 2
		int dado = gerador.nextInt(6) + 1;
		System.out.println("Face do Dado: " + dado);
		// Exemplo 3: 
		// A Linha Abaixo cria um objeto que contém caracteres
		String chassi = new String("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		System.out.print("Chassi: * ");
		for (int i = 0; i < 16; i++) {
			// A linha abaixo cria uma variavel do tipo char que usa o objeto
			// gerador para gerar um numero aleatorio entre 0 e o tamanho máximo
			// de caracters do objeto chassi (.lenght() -> tamanho da String)
			// (char) converter o tipo int para tipo char
			char numeracao = (char)gerador.nextInt(chassi.length());
			//a linha abaixo imprime o valor da variavel numeracao
			//(.charAt() - > imprime apenas 1 Caractere
			System.out.print(chassi.charAt(numeracao));
		}
		System.out.println(" *");
	}
}
