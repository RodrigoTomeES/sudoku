package sudoku;

public class Entero_historial {
	private int numero;
	private boolean estadoInicial;

	public Entero_historial() {
		/*
		 * {Precondición: } {Postcondicón: devuelve un Entero_historial cuyo número es
		 * -1 y estadoInicial es false}
		 */
		this.numero = -1;
		this.estadoInicial = false;
	}

	public Entero_historial(int numero, boolean estadoInicial) {
		/*
		 * {Precondición: numero es una variable de tipo entero, estadoInicial es una
		 * variable de tipo booleano} {Postcondición: asigna al atributo numero del
		 * objeto el parámetro numero, asigna al atributo estadoInicial del objeto el
		 * parámetro estadoInicial Por lo que el objeto queda construido}
		 */
		this.numero = numero;
		this.estadoInicial = estadoInicial;
	}

	public int getNumero() {
		/*
		 * {Precondición: } {Postcondición: devuelve el dato del atributo numero del
		 * objeto}
		 */
		return this.numero;
	}

	public void setNumero(int numero) {
		/*
		 * {Precondición: numero es una variable de tipo entero} {Postcondición: asigna
		 * al atributo numero el parámetro numero}
		 */
		this.numero = numero;
	}

	public boolean getEstadoInicial() {
		/*
		 * {Precondición: } {Postcondición: devuelve cierto si este valor es el estado
		 * inicial o falso en caso contrario}
		 */
		return this.estadoInicial;
	}

	public void setEstadoInicial(boolean estadoInicial) {
		/*
		 * {Precondición: estadoInicial es una variable de tipo booleano}
		 * {Postcondición: asigna el parámetro estadoInicial al atributo del objeto
		 * llamado estadoInicial}
		 */
		this.estadoInicial = estadoInicial;
	}
}
