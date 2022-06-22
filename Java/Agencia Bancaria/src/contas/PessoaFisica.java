/**
 * Conta Corrente
 */
package contas;

/**
 *
 * @author Jefferson Cruz
 */
public class PessoaFisica {

	/**
	 * Método Principal
	 * @param args
	 */
	public static void main(String[] args) {
		//Cliente 1
		Conta cc1 = new Conta();
		cc1.setCliente("Leandro Ramos");
		cc1.setSaldo(10000);
		System.out.println("Cliente: " + cc1.getCliente());
		cc1.exibirSaldo();
		cc1.sacar(1000);
		cc1.exibirSaldo();
		//Cliente 2
		Conta cc2 = new Conta();
		cc2.setCliente("Kelly Cristina");
		cc2.setSaldo(8500);
		System.out.println("Cliente: " + cc2.getCliente());
		cc2.exibirSaldo();
		cc2.depositar(1500);
		cc2.exibirSaldo();
		//Transferencia
		System.out.println("--------------------------------");
		System.out.println("----------Transferencia---------");
		System.out.println("Cliente: " + cc1.getCliente());
		System.out.println("Favorecido: " + cc2.getCliente());
		cc1.tranferencia(cc2, 2000);
		System.out.println("--------------------------------");
		System.out.println("Cliente: " + cc1.getCliente());
		cc1.exibirSaldo();
		System.out.println("Favorecido: " + cc2.getCliente());
		cc2.exibirSaldo();
		
		//Relatorio gerencial
		Conta gerente = new Conta();
		double relatorio = gerente.soma(cc1.getSaldo(),cc2.getSaldo());
		System.out.println("Saldo total das contas: " + relatorio);
		}
	}