package sudoku;

public class Sudoku {
	private Entero_historial sudokuInicial [][];
	
	public Sudoku(int tamano){
		/* {Precondici�n: tama�o es una variable de tipo entero y cuyo valor puede ir entre [0,9] y debe ser un cuadrado perfecto}
		 * {Postcondici�n: construye una matriz con tama�o como n�mero de filas y de columnas}
		 */
		
		//Preguntar otra opcion
		
		this.sudokuInicial=new Entero_historial [tamano][tamano];
		for(int i = 0; i < tamano; i++) {
			for(int j = 0; j < tamano; j++) {
				this.sudokuInicial[i][j] = new Entero_historial();
			}
		}
	}
	
	public Entero_historial[][] getSudokuInicial() {
		/* {Precondici�n: }
		 * {Postcondici�n: devuelve la matriz guardada en el atributo sudokuInicial}
		 */
		return this.sudokuInicial;
	}
	
	public int tamanoSudoku() {
		/* {Precondici�n: }
		 * {Postcondici�n: devuelve el n�mero de filas ya que es una matriz cuadrada}
		 */
		return this.sudokuInicial.length;
	}
	
	public void anadirNumeroInicial(int numero,int fila, int columna) {
		/* {Precondic�n: la variable fila y columna tienen que ser n�meros de tipo entero entre 1 y tama�oSudoku. La variable n�mero ser� de tipo entero entre [1,tama�oSudoku]}
		 * {Postcondici�n: a�ade un objeto de tipo Entero_historial en la posici�n que indica la intersecci�n de la fila y la columna.
		 * Dicho objeto se construye con el par�metro n�mero y true}
		 */
		this.sudokuInicial[fila-1][columna-1]= new Entero_historial(numero,true);
	}
	
	public void anadirNumero(int numero,int fila, int columna) {
		/* {Precondici�n: la variable fila y columna tienen que ser n�meros de tipo entero entre 1 y tama�oSudoku. La variable n�mero ser� de tipo entero entre [1,tama�oSudoku]}
		 * {Postcondici�n: a�ade un objeto de tipo Entero_historial en la posici�n que indica la intersecci�n de la fila y la columna.
		 * Dicho objeto se construye con el par�metro n�mero y false}
		 */
		this.sudokuInicial[fila-1][columna-1]= new Entero_historial(numero,false);
	}
	
	public Entero_historial obtenerValorDeCasilla(int fila, int columna) {
		/* {Precondici�n: fila y columna son dos par�metros de tipo entero cuyo valor va desde 1 hasta tama�oSudoku}
		 * {Postcondici�n: devuelve el valor de la casilla que se obtiene como intersecci�n de los par�metros fila y columna}
		 */ 
		return this.sudokuInicial[fila-1][columna-1];
	}
	
	public void eliminarNumeroACasilla(int fila, int columna) {
		/* {Precondici�n: la variable fila y columna tienen que ser n�meros de tipo entero entre 1 y tama�oSudoku}
		 * {Postcondici�n: eliminan el objeto de tipo Entero_historial de la posici�n que se consigue como intersecci�n de la fila y la columna}
		 */
		this.sudokuInicial[fila-1][columna-1]= new Entero_historial();
	}
	
	public void mostrarEstadoSudoku() {
		/* {Precondici�n: }
		 * {Postcondici�n: muestra todos los valores almacenados en el sudoku en ese momento}
		 */
		String rayita = new String();
		for (int n = 0; n < this.tamanoSudoku(); n++) {
			rayita += "----";
		}
		if (this.tamanoSudoku()!=0) rayita+="-";
		
		System.out.println(rayita);
		for (int i = 0; i<this.tamanoSudoku();i++){
			System.out.print("|");
			for(int j=0;j<this.tamanoSudoku();j++) {
				System.out.print(" " + this.sudokuInicial[i][j].getNumero() + " ");
				System.out.print("|");
			}
			System.out.print("\n");
			System.out.println(rayita);
		}
		System.out.print("\n");
	}
	
	public void volverAlEstadoInicial() {
		/* {Precondici�n: }
		 * {Postcondici�n: recorre la matriz y va asignando nulls a aquellas posiciones que al llamar a la funci�n que indica si
		 * es un estado inicial devuelve falso}
		 */
		for(int i=0;i<this.tamanoSudoku();i++) {
			for(int j=0;j<this.tamanoSudoku();j++) {
				if(!this.sudokuInicial[i][j].getEstadoInicial()) {
					this.sudokuInicial[i][j] = new Entero_historial();
				}
			}
		}
	}
	
	public boolean esCorrectoAnadirValorACasilla(int valor, int fila, int columna) {
		boolean resultado=true;
		for(int j=0;j<this.tamanoSudoku()-1&&resultado;j++) {
			resultado=resultado&&(this.sudokuInicial[fila-1][j].getNumero()!=valor);
		}
		for(int i=0;i<this.tamanoSudoku()-1&&resultado;i++) {
			resultado=resultado&&(this.sudokuInicial[i][columna-1].getNumero()!=valor);
		}
		
		//Preguntar
		
		int tamano = (int) Math.sqrt(this.tamanoSudoku());
		int esquinaSuperiorCuadranteFila = (fila/tamano)*tamano;
		int esquinaSuperiorCuadranteColumna = (columna/tamano)*tamano;
		for(int i=0;i<tamano&&resultado;i++) {
			for(int j=0;j<tamano&&resultado;j++) {
				resultado=resultado&&(this.sudokuInicial[esquinaSuperiorCuadranteFila+i][esquinaSuperiorCuadranteColumna+j].getNumero()!=valor);
			}
		}
		
		return resultado;
	}
	
}
