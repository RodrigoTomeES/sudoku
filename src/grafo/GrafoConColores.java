package grafo;
import java.util.*;

public class GrafoConColores extends Grafo {
	private Map<Integer,Integer> verticesColoreado;
	
	public GrafoConColores() {
		/* {Precondición: }
		 * {Postcondición: construye la superclase y construye el atributo verticesColoreado como un HashMap<Integer,Integer>,
		 * dónde irá guardando para cada vértice, su color asociado. Este atributo está formado por la clave que será el vértice
		 * y el valor asociado que es el color}
		 */
		super();
		this.verticesColoreado=new HashMap<Integer,Integer>();
	}
	
	public boolean anadirColorAVertice(Integer vertice, Integer color) {
		/* {Precondición: vertice que ya esté en el grafo y color son dos parámetros de tipo Integer.}
		 * {Postcondición: comprueba en la lista de claves si está el parámetro vértice. Si no está, añade dicho vertice y su color y devuelve cierto.
		 * En caso contrario devuelve falso y no lo añade}
		 */
		boolean esta=this.verticesColoreado.containsKey(vertice);
		if(!esta) {
			this.verticesColoreado.put(vertice, color);
		}
		return !esta;
	}
	
	public boolean eliminarColorVertice(Integer vertice) {
		/* {Precondición: vertice es un parámetro de tipo Integer}
		 * {Postcondición: si se encontraba dicho vértice devuelve cierto y lo elimina. En caso contrario sólo devuelve falso.}
		 */
		boolean esta=this.verticesColoreado.containsKey(vertice);
		if(esta) {
			this.verticesColoreado.remove(vertice);
		}
		return esta;
	}
	
	public Integer getColorVertice(Integer vertice) {
		/* {Precondición: vertice es un parámetro de tipo Integer}
		 * {Postcondición: devuelve el color asociado a dicho vertice}
		 */
		return (Integer) this.verticesColoreado.get(vertice);
	}
	
	public void borrarTodosLosColores() {
		/* {Precondición: }
		 * {Postcondición: para borrar todos los colores lo que se hace es borrar todo el mapa de verticesColoreado}
		 */
		this.verticesColoreado.clear();
	}
	
	public Set<Integer> listarVerticesConColores(){
		/* {Precondición: }
		 * {Postcondición: devuelve un Set<Integer> el cuál contiene todas las claves del mapa verticesColoreado,
		 * ya que todos esos vértiecs tienen colores}
		 */
		return new LinkedHashSet<Integer>(this.verticesColoreado.keySet());
	}
	
	public boolean esColorValido(Integer vertice,Integer color) {
		/* {Precondición: vertice que debe existir en grafoy color son dos parámetros de tipo Integer}
		 * {Postcondición: comprueba si es un color válido para dicho vértice. Para ello comprueba si es distinto del color de sus vértices asociados.}
		 */
		List<Integer> verticesAdyacentes=super.listarVerticesAdyacentes(vertice);
		boolean colorValido=true;
		
		Iterator<Integer> it = verticesAdyacentes.iterator();
		
		while(it.hasNext()&&colorValido) {
			Integer aux=it.next();
			colorValido=colorValido&&(color!=this.verticesColoreado.get(aux));
		}
		return colorValido;
	}
	
	public boolean colorear(int numColores){
	    List<Integer> listaVertices;
	    // lista auxiliar en la que colocaré todos los vértices

	    /* Para poder aplicar el algoritmo de coloración de un grafo necesito tener los
	        vértices almacenados en orden. En primer lugar colocaré los vértices que
	        tienen ya un color asignado (este color no podrá modificarse). A
	        continuación colocaré en la lista el resto de vértices, a los que el algoritmo
	        de coloración irá asignando diferentes colores hasta dar con una
	        combinación correcta.
	    */

	    List<Integer> listaVerticesColoreados=new LinkedList<>(this.listarVerticesConColores());
	    List<Integer> listaVerticesNoColoreados= new LinkedList<>(super.listarVertices()); //todos
	    listaVerticesNoColoreados.removeAll(listaVerticesColoreados); //quito los
	                                                                  //coloreados
	    
	    
	    //Compruebo que los colores que ya están asignados son correctos
	    for(int v:listaVerticesColoreados){
	    	if (!this.esColorValido(v, this.getColorVertice(v)))
	    		return false;
	    }

	    // vuelco los vértices en la nueva lista, en el orden correcto
	    listaVertices=new ArrayList<Integer>( );
	    listaVertices.addAll(listaVerticesColoreados);
	    listaVertices.addAll(listaVerticesNoColoreados);

	    int k=listaVerticesColoreados.size( );
	    boolean b=this.coloreoConRetroceso(listaVertices, k, numColores);

	    if (b== false) {
	      // no se ha podido colorear el grafo
	      // vuelvo a la situación inicial

	      for (int i = 0; i < listaVerticesNoColoreados.size( ); i++) {
	        this.verticesColoreado.remove(listaVerticesNoColoreados.get(i));
	      }
	     }
	    return b;
	 }


	 private boolean aceptable(List<Integer> listaVertices, int color, int posicion){
	   /*
	      devuelve true si al vértice que ocupa la posición k en listaVertices
	      puedo asignarle el color k de modo que no haya ningún vértice en las
	      posiciones anteriores que sea adyacente y que tenga el mismo color asignado.
	   */

	   boolean acept=true;
	   for (int i=0; i<posicion && acept; i++){
	     if (super.sonAdyacentes(listaVertices.get(i), listaVertices.get(posicion)) &&
	         this.getColorVertice(listaVertices.get(i))== color)
	       acept=false;
	   }
	   return acept;
	 }


	 private boolean coloreoConRetroceso(List<Integer> listaVertices, int k, int numColores){
	   /*
	    Supongo que a los vértices situados en las posiciones 0..k-1
	    de listaVertices ya les he asignado color.
	    Busco un color para el vértice en la posición k que sea compatible
	    con los anteriores.
	   */

	    if (k==listaVertices.size( ))
	     return true;
	   else {
	     for (int c=1; c<=numColores; c++){
	       if (this.aceptable(listaVertices,c, k)) {
	         this.verticesColoreado.put(listaVertices.get(k), c);
	         boolean b=coloreoConRetroceso(listaVertices,k + 1, numColores);
	         if (b)
	           return b;
	       }
	     }
	   }

	   // he recorrido todas las combinaciones y ninguna es válida, devuelvo falso.
	   return false;

	  }

	 @Override
	 public GrafoConColores clone() {
		 /* {Precondición: }
		  * {Postcondición: devuelve una copia del GrafoConColores}
		  */
		 GrafoConColores resultado = new GrafoConColores();
		 resultado.setGrafo(super.clone().getGrafo());
		 Set<Integer> verticesConColores = this.listarVerticesConColores();
		 Iterator<Integer> it = verticesConColores.iterator();
		 while(it.hasNext()) {
			 Integer i = it.next();
			 Integer colorAsociado = this.verticesColoreado.get(i);
			 resultado.anadirColorAVertice(new Integer(i), colorAsociado); 
		 }
		 return resultado;
	 }
}
