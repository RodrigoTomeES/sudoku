package sudoku;

public class Entero_historial {
	private int numero;
	private boolean estadoInicial;
	
	public Entero_historial(int numero,boolean estadoInicial) {
		/*{Precondicion: numero es una variable de tipo entero, estadoInicial es una variable de topo booleano}
		 * {Postcondicion: asigna al atributo numero del objeto el parámetro numero, asigna al atributo estadoInicial del objeto el parámetro estadoInicial
		 * Por lo que el objeto queda construido}
		 */
		this.numero=numero;
		this.estadoInicial=estadoInicial;
	}
	
	public int getNumero() {
		/*{Precondicion: }
		 * {Postcondicion: devuelve el dato del atributo numero del objeto}
		 */
		return this.numero;
	}
	
	public void setNumero(int numero) {
		/*{Precondicion: numero es una variable de tipo entero}
		 * {Postcondicion: asigna al atributo numero el parámetro numero}
		 */
		this.numero=numero;
	}
	
	public boolean getEstadoInicial() {
		/*{Precondicion: }
		 * {Postcondicion: devuelve cierto si este valor es el estado inicial o falso en caso contrario}
		 */
		return this.estadoInicial;
	}
	
	public void setEstadoInicial(boolean estadoInicial) {
		/*{Precondicion: estadoInicial es una variable de tipo booleano}
		 * {Postcondicion: asigna el parámetro estadoInicial al atributo del objeto llamado estadoInicial}
		 */
		this.estadoInicial=estadoInicial;
	}
}
