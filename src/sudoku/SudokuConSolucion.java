package sudoku;
import java.util.Iterator;
import java.util.Set;

import grafo.GrafoConColores;

public class SudokuConSolucion extends Sudoku{
	private GrafoConColores gr;
	
	private void construirGrafoInicial( ){
		  this.gr=new GrafoConColores();
		  int numFilas=super.tamanoSudoku();
		  int numVertices=numFilas*numFilas;
		  for (int v=1; v<=numVertices; v++)
		    this.gr.anadirVertice(v);
		  //gr es el nombre del atributo de Sudoku que contiene el grafo con colores
		
		  //Añado aristas para todas las parejas de vértices que están en la misma fila
		  for (int i = 0; i < numFilas ; i++) {
		    for (int j = 0; j < numFilas; j++) {
		      for (int k = j + 1; k < numFilas ; k++) {
		        int v1=numFilas*i + j+1;
		        int v2=numFilas*i + k+1;
		        this.gr.anadirArista(v1,v2);
		      }
		    }
		  }
		
		  //Añado aristas para todas las parejas de vértices que están en la misma
		  // columna
		  for (int j = 0; j < numFilas; j++) {
		    for (int i = 0; i < numFilas ; i++) {
		      for (int k = i + 1; k < numFilas ; k++) {
		        int v1=numFilas*i + j+1;
		        int v2=numFilas*k + j+1;
		        this.gr.anadirArista(v1,v2);
		      }
		    }
		  }
		
		  //Añado aristas para todas las parejas de vértices que están en la misma región
		  int n = (int)Math.sqrt(numFilas);
		  for (int i = 0; i < n ; i++) {
			  for (int j = 0; j < n; j++) {
				int i0 = i * n;
				int j0 = j * n;
				// (i0,j0) es la esquina superior izquierda de la región
				for (int i1 = i0; i1 < i0 + n; i1++) {
					for (int j1 = j0; j1 < j0 + n; j1++) {
			          for (int i2 =i0; i2<i0+n; i2++){
			            for (int j2 = j0; j2 < j0 + n; j2++) {
			              int v1 = numFilas * i1 + j1 + 1;
			              int v2 = numFilas * i2 + j2 + 1;
			              if ((v2 != v1) && !this.gr.sonAdyacentes(v1, v2))
			                this.gr.anadirArista(v1, v2);
			            }
			          }
			        }
			      }
		   }
		 }
		
		 // Por último añado los colores a los vértices correspondientes a los
		 // valores iniciales del sudoku
		 for (int i=0; i<numFilas; i++){
		   for (int j=0; j<numFilas; j++){
		     if (this.getSudokuInicial()[i][j].getEstadoInicial())
		       this.gr.anadirColorAVertice(i*numFilas+j+1,this.getSudokuInicial()[i][j].getNumero());
		   }
		 }
	}
	
	public SudokuConSolucion(int tamaño){
		/* {Precondición: tamaño es una variable de tipo entero y cuyo valor puede ir entre [0,9] y debe ser un cuadrado perfecto}
		 * {Postcondición: construye la superclase así como el atributo gr de dicho objeto}
		 */
		
		//(fila,columna)->ver=fila*num_fila+columna+1
		//vertice->fila=(ver-1)/numfilas;columna=(ver-1)%numFilas;
		
		super(tamaño);
		this.construirGrafoInicial();
	}
	
	public GrafoConColores getGr() {
		return gr;
	}

	public void setGr(GrafoConColores gr) {
		this.gr = gr;
	}

	@Override
	public void anadirNumeroInicial(int numero,int fila, int columna) {
		/* {Precondición: la variable fila y columna tienen que ser números de tipo entero entre 1 y tamañoSudoku. La variable número será de tipo entero entre [1,tamañoSudoku]}
		 * {Postcondición: añade un objeto de tipo Entero_historial en la posición que indica la intersección de la fila y la columna.
		 * Dicho objeto se construye con el parámetro número y true}
		 */
		super.anadirNumeroInicial(numero, fila, columna);
		this.gr.anadirColorAVertice((fila-1)*super.tamanoSudoku()+columna, numero);
	}
	
	@Override
	public void anadirNumero(int numero,int fila, int columna) {
		/* {Precondición: la variable fila y columna tienen que ser números de tipo entero entre 1 y tamañoSudoku. La variable número será de tipo entero entre [1,tamañoSudoku]}
		 * {Postcondición: añade un objeto de tipo Entero_historial en la posición que indica la intersección de la fila y la columna.
		 * Dicho objeto se construye con el parámetro número y false}
		 */
		super.anadirNumero(numero, fila, columna);
		this.gr.anadirColorAVertice((fila-1)*super.tamanoSudoku()+columna, numero);
	}
	
	@Override
	public void eliminarNumeroACasilla(int fila, int columna) {
		/* {Precondición: la variable fila y columna tienen que ser números de tipo entero entre 1 y tamañoSudoku}
		 * {Postcondición: eliminan de la superclase el valor, luego elimina el color asociado a ese vértice del grafo
		 * y por último elemina dicho vértice}
		 */
		super.eliminarNumeroACasilla(fila, columna);
		this.gr.eliminarColorVertice((fila-1)*super.tamanoSudoku()+columna);
	}
	
	public boolean sePuedeResolverSudoku (){
		/* {Precondición: }
		 * {Postcondición: devuelve cierto si se puede colorear el grafo y falso en caso contrario}
		 */
		GrafoConColores aux = this.gr.clone();
		return aux.colorear(super.tamanoSudoku());
	}
	
	public void resolverSudoku () {
		/* {Precondición: }
		 * {Postcondición: resuelve el sudoku, para ello se remite a resolver el problema de colorear el grafo}
		 */
		if(this.gr.colorear(super.tamanoSudoku())) {
			Set<Integer> verticesColoreados = this.gr.listarVerticesConColores();
			Iterator<Integer> it = verticesColoreados.iterator();
			while(it.hasNext()) {
				Integer vertice = it.next();
				Integer colorAsociado = this.gr.getColorVertice(vertice);
				super.anadirNumero(colorAsociado, (vertice-1)/super.tamanoSudoku()+1, (vertice-1)%super.tamanoSudoku()+1);
			}			
		} else {
			System.out.println("Error no tiene solución");
		}
	}
}
