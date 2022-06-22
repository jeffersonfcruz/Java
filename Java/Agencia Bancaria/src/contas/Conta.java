/**
 * POO - Encapsulamento e métodos especiais
 */
package contas;

/**
 *
 * @author Jefferson Cruz
 */
public class Conta {
	// Atributos
	// Para encapsular (proteger) uma variavel devemos usar o modificador private
	// e criar metodos especificados (get e set)
	// para outras classes e pacotes terem acesso as variaveis

	// Encapsulamento Passo 1 : Modificador "private"
	private String cliente;
	private double saldo;

	/**
	 * Construtor
	 */
	public Conta() {
		System.out.println("------------------------");
		System.out.println("Agência 0261");
	}

	// Encapsulamento Passo 2 : Criar os métodos especificos (get e set)
	// Eclipse: Direito (Mouse) - > Source -> Generate getter and setters
	/**
	 * Ler o Conteudo da Variavel Cliente
	 * 
	 * @return cliente
	 */
	public String getCliente() {
		return cliente;
	}

	/**
	 * Setar ou atribuir um nome a variavel cliente
	 * 
	 * @param cliente
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	/**
	 * Obter o Saldo do Cliente
	 * 
	 * @return saldo
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * Setar (atribuir) um valor a conta corrente
	 * 
	 * @param
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	// Método
	// Exibir simples que exibe o valor do saldo
	protected void exibirSaldo() {
		System.out.println("Saldo: R$ " + saldo);
	}

	/*
	 * Método simples com uma variavel local
	 * @param valor
	 */
	protected void sacar(double valor) {
		saldo -= valor;
		System.out.println("Débito: R$" + valor);
	}
	/*
	 * Método simples com uma variavel local
	 * @param valor
	 */
	protected void depositar(double valor) {
		saldo += valor;
		System.out.println("Crédito: R$" + valor);
	}
	/**
	 * Metodo simples com uma variavel local e um objeto que sera criado para indicar a conta de destino da transferencia
	 * @param destino
	 * @param valor
	 */
	protected void tranferencia(Conta destino, double valor) {
		this.sacar(valor);
		destino.depositar(valor);
		System.out.println("Transferencia: R$" + valor);
	}
	
/**
 * Método com retorno obrigatorio 
 * @param cc1
 * @param cc2
 * @return
 */
		double soma (double cc1, double cc2) {
		double total = cc1 + cc2; 
		return total;
	}
}