/**
 * Seguros
 */
package seguros;

import contas.Conta;

/**
 * @author Jefferson Cruz
 *
 */
public class SeguroPessoaFisica extends Conta {

	/**
	 * Método Principal
	 * @param args
	 */
	public static void main(String[] args) {
	// Cliente 3
	// Usando o Modificados Protected, devemos usar a propria herança para criar o objeto 
		
	SeguroPessoaFisica cc3 = new SeguroPessoaFisica ();
	cc3.setCliente("Robson Vaamonde");
	cc3.setSaldo(9000);
	System.out.println("Cliente: " + cc3.getCliente());
	cc3.exibirSaldo();
	}

}
