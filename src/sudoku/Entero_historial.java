package sudoku;

public class Entero_historial {
	private int numero;
	private boolean estadoInicial;

	public Entero_historial() {
		/*
		 * {Precondici�n: } {Postcondic�n: devuelve un Entero_historial cuyo n�mero es
		 * -1 y estadoInicial es false}
		 */
		this.numero = -1;
		this.estadoInicial = false;
	}

	public Entero_historial(int numero, boolean estadoInicial) {
		/*
		 * {Precondici�n: numero es una variable de tipo entero, estadoInicial es una
		 * variable de tipo booleano} {Postcondici�n: asigna al atributo numero del
		 * objeto el par�metro numero, asigna al atributo estadoInicial del objeto el
		 * par�metro estadoInicial Por lo que el objeto queda construido}
		 */
		this.numero = numero;
		this.estadoInicial = estadoInicial;
	}

	public int getNumero() {
		/*
		 * {Precondici�n: } {Postcondici�n: devuelve el dato del atributo numero del
		 * objeto}
		 */
		return this.numero;
	}

	public void setNumero(int numero) {
		/*
		 * {Precondici�n: numero es una variable de tipo entero} {Postcondici�n: asigna
		 * al atributo numero el par�metro numero}
		 */
		this.numero = numero;
	}

	public boolean getEstadoInicial() {
		/*
		 * {Precondici�n: } {Postcondici�n: devuelve cierto si este valor es el estado
		 * inicial o falso en caso contrario}
		 */
		return this.estadoInicial;
	}

	public void setEstadoInicial(boolean estadoInicial) {
		/*
		 * {Precondici�n: estadoInicial es una variable de tipo booleano}
		 * {Postcondici�n: asigna el par�metro estadoInicial al atributo del objeto
		 * llamado estadoInicial}
		 */
		this.estadoInicial = estadoInicial;
	}
}
