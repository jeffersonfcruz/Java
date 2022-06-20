/**
 * POO - Fundamentos
 * Atividade Avaliação
 */
package carros;

import java.util.Random;

/**
 * @author Jefferson Cruz
 * Classe Modelo
 */
public class Carro {
	public Carro() {
		for (int i = 0; i < 16; i++) {
			Random gerador = new Random ();
			String chassi = new String("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ");
			char numeracao = (char)gerador.nextInt(chassi.length());
			System.out.print(chassi.charAt(numeracao));
		}
		System.out.println(" ");
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
