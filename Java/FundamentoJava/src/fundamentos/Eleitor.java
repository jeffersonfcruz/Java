/**
 * Fundamentos do Java
 * Variáveis, operadores e estruturas de controle
 * Exercício 1 - APP Eleitor
 * Desenvolver um APP no modo console que em função da idade do eleitor avise se o voto é obrigatório ou não
 * Abaixo de 16: VOTO PROIBIDO
 * Entre 16 e 17, incluindo estas idades: VOTO FACULTATIVO
 * Entre 18 e 69, incluindo estas idades: VOTO OBRIGATÓRIO
 * Acima ou igual a 70: VOTO FACULTATIVO
 */

package fundamentos;

import java.util.Scanner;

/**
 * @author Jefferson Cruz
 *
 */

public class Eleitor {

	/**
	 * Método principal
	 * @param args
	 */

	public static void main(String[] args) {
		// Variáveis
		int idade;

		// Objetos
		Scanner teclado = new Scanner (System.in);
		System.out.println("APP ELEITOR ===================");
		System.out.print("Digite sua idade: ");


		//Entrada
		idade = teclado.nextInt();

		//Apoio ao teste do fluxo (verificar se a idade foi capturada)
		//System.out.println(idade);
		// processamento e saida
		if (idade < 16) {
			System.out.println("PROIBIDO VOTAR");
		}
			else if (idade > 17 && idade <71){
			System.out.println("VOTO OBRIGATORIO");
		} else {
			System.out.println("VOTO FACULTATIVO");
		}
		// encerrar a captura de dados
		teclado.close();
	}
}