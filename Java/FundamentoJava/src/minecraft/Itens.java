/**
 * 
 */
package minecraft;

/**
 * @author Jefferson Cruz
 *
 */
public class Itens {

	/**
	 * Construtor
	 */
	public Itens() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Método principal
	 * @param args
	 */
	public static void main(String[] args) {
		Enxada enxadaDiamante = new Enxada();
		enxadaDiamante.resistencia = 10;
		enxadaDiamante.textura = "diamante";
		enxadaDiamante.conquista = false;
		System.out.println("Enxada de" + enxadaDiamante.textura);
		System.out.println("Resistência" + enxadaDiamante.resistencia);
		enxadaDiamante.arar();
		if (enxadaDiamante.conquista == true) {
		System.out.println("________________________________________");
		System.out.println("Conquista obtida");
		System.out.println("Dedicação séria. Hora do plantio");
		System.out.println("________________________________________");
		}
		}
		

	}
