import java.lang.*;


public class Sudoku {
	private Entero_historial sudokuInicial [][];
	
	public Sudoku(int tamaño){
		/* {Precondición: tamaño es una variable de tipo entero y cuyo valor puede ir entre 1 e infinito}
		 * {Postcondición: construye una matriz con tamaño como número de filas y de columnas}
		 */
		this.sudokuInicial=new Entero_historial [tamaño][tamaño];
	}
	
	public Entero_historial[][] getSudokuInicial() {
		/* {Precondición: }
		 * {Postcondición: devuelve la matriz guardada en el atributo sudokuInicial}
		 */
		return this.sudokuInicial;
	}
	
	public int tamañoSudoku() {
		/* {Precondición: }
		 * {Postcondición: devuelve el número de filas ya que es una matriz cuadrada}
		 */
		return this.sudokuInicial.length;
	}
	
	public void añadirNumeroInicial(int numero,int fila, int columna) {
		/* {Precondición: la variable fila y columna tienen que ser números de tipo entero entre 1 y tamañoSudoku. La variable número será de tipo entero entre [1,tamañoSudoku]}
		 * {Postcondición: añade un objeto de tipo Entero_historial en la posición que indica la intersección de la fila y la columna.
		 * Dicho objeto se construye con el parámetro número y true}
		 */
		this.sudokuInicial[fila-1][columna-1]= new Entero_historial(numero,true);
	}
	
	public void añadirNumero(int numero,int fila, int columna) {
		/* {Precondición: la variable fila y columna tienen que ser números de tipo entero entre 1 y tamañoSudoku. La variable número será de tipo entero entre [1,tamañoSudoku]}
		 * {Postcondición: añade un objeto de tipo Entero_historial en la posición que indica la intersección de la fila y la columna.
		 * Dicho objeto se construye con el parámetro número y false}
		 */
		this.sudokuInicial[fila-1][columna-1]= new Entero_historial(numero,false);
	}
	
	public Entero_historial obtenerValorDeCasilla(int fila, int columna) {
		/* {Precondición: fila y columna son dos parámetros de tipo entero cuyo valor va desde 1 hasta tamañoSudoku}
		 * {Postcondición: devuelve el valor de la casilla que se obtiene como intersección de los parámetros fila y columna}
		 */ 
		return this.sudokuInicial[fila-1][columna-1];
	}
	
	public void eliminarNumeroACasilla(int fila, int columna) {
		/* {Precondición: la variable fila y columna tienen que ser números de tipo entero entre 1 y tamañoSudoku}
		 * {Postcondición: eliminan el objeto de tipo Entero_historial de la posición que se consigue como intersección de la fila y la columna}
		 */
		this.sudokuInicial[fila-1][columna-1]=null;
	}
	
	public void mostrarEstadoSudoku() {
		/* {Precondición: }
		 * {Postcondición: muestra todos los valores almacenados en el sudoku en ese momento}
		 */
		for (int i = 0; i<this.tamañoSudoku()-1;i++){
			for(int j=0;j<this.tamañoSudoku()-1;j++) {
				System.out.print(this.sudokuInicial[i][j]);
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	public void volverAlEstadoInicial() {
		/* {Precondición: }
		 * {Postcondición: recorre la matriz y va asignando nulls a aquellas posiciones que al llamar a la función que indica si
		 * es un estado inicial devuelve falso}
		 */
		for(int i=0;i<this.tamañoSudoku()-1;i++) {
			for(int j=0;j<this.tamañoSudoku()-1;j++) {
				if(!this.sudokuInicial[i][j].getEstadoInicial()) {
					this.sudokuInicial[i][j]=null;
				}
			}
		}
	}
	
	/*public boolean esCorrectoAñiadirValorACasilla(int valor, int fila, int columna) {
		boolean resultado=true;
		for(int j=0;j<this.tamañoSudoku()-1;j++) {
			resultado=resultado&&(this.sudokuInicial[fila-1][j].getNumero()!=valor);
		}
		for(int i=0;i<this.tamañoSudoku()-1;i++) {
			resultado=resultado&&(this.sudokuInicial[i][columna-1].getNumero()!=valor);
		}
		
	}
	*/
}
