package grafo;
import java.util.*;

public class GrafoConColores extends Grafo {
	private Map<Integer,Integer> verticesColoreado;
	
	public GrafoConColores() {
		/* {Precondici�n: }
		 * {Postcondici�n: construye la superclase y construye el atributo verticesColoreado como un HashMap<Integer,Integer>,
		 * d�nde ir� guardando para cada v�rtice, su color asociado. Este atributo est� formado por la clave que ser� el v�rtice
		 * y el valor asociado que es el color}
		 */
		super();
		this.verticesColoreado=new HashMap<Integer,Integer>();
	}
	
	public boolean anadirColorAVertice(Integer vertice, Integer color) {
		/* {Precondici�n: vertice que ya est� en el grafo y color son dos par�metros de tipo Integer.}
		 * {Postcondici�n: comprueba en la lista de claves si est� el par�metro v�rtice. Si no est�, a�ade dicho vertice y su color y devuelve cierto.
		 * En caso contrario devuelve falso y no lo a�ade}
		 */
		boolean esta=this.verticesColoreado.containsKey(vertice);
		if(!esta) {
			this.verticesColoreado.put(vertice, color);
		}
		return !esta;
	}
	
	public boolean eliminarColorVertice(Integer vertice) {
		/* {Precondici�n: vertice es un par�metro de tipo Integer}
		 * {Postcondici�n: si se encontraba dicho v�rtice devuelve cierto y lo elimina. En caso contrario s�lo devuelve falso.}
		 */
		boolean esta=this.verticesColoreado.containsKey(vertice);
		if(esta) {
			this.verticesColoreado.remove(vertice);
		}
		return esta;
	}
	
	public Integer getColorVertice(Integer vertice) {
		/* {Precondici�n: vertice es un par�metro de tipo Integer}
		 * {Postcondici�n: devuelve el color asociado a dicho vertice}
		 */
		return (Integer) this.verticesColoreado.get(vertice);
	}
	
	public void borrarTodosLosColores() {
		/* {Precondici�n: }
		 * {Postcondici�n: para borrar todos los colores lo que se hace es borrar todo el mapa de verticesColoreado}
		 */
		this.verticesColoreado.clear();
	}
	
	public Set<Integer> listarVerticesConColores(){
		/* {Precondici�n: }
		 * {Postcondici�n: devuelve un Set<Integer> el cu�l contiene todas las claves del mapa verticesColoreado,
		 * ya que todos esos v�rtiecs tienen colores}
		 */
		return new LinkedHashSet<Integer>(this.verticesColoreado.keySet());
	}
	
	public boolean esColorValido(Integer vertice,Integer color) {
		/* {Precondici�n: vertice que debe existir en grafoy color son dos par�metros de tipo Integer}
		 * {Postcondici�n: comprueba si es un color v�lido para dicho v�rtice. Para ello comprueba si es distinto del color de sus v�rtices asociados.}
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
	    // lista auxiliar en la que colocar� todos los v�rtices

	    /* Para poder aplicar el algoritmo de coloraci�n de un grafo necesito tener los
	        v�rtices almacenados en orden. En primer lugar colocar� los v�rtices que
	        tienen ya un color asignado (este color no podr� modificarse). A
	        continuaci�n colocar� en la lista el resto de v�rtices, a los que el algoritmo
	        de coloraci�n ir� asignando diferentes colores hasta dar con una
	        combinaci�n correcta.
	    */

	    List<Integer> listaVerticesColoreados=new LinkedList<>(this.listarVerticesConColores());
	    List<Integer> listaVerticesNoColoreados= new LinkedList<>(super.listarVertices()); //todos
	    listaVerticesNoColoreados.removeAll(listaVerticesColoreados); //quito los
	                                                                  //coloreados
	    
	    
	    //Compruebo que los colores que ya est�n asignados son correctos
	    for(int v:listaVerticesColoreados){
	    	if (!this.esColorValido(v, this.getColorVertice(v)))
	    		return false;
	    }

	    // vuelco los v�rtices en la nueva lista, en el orden correcto
	    listaVertices=new ArrayList<Integer>( );
	    listaVertices.addAll(listaVerticesColoreados);
	    listaVertices.addAll(listaVerticesNoColoreados);

	    int k=listaVerticesColoreados.size( );
	    boolean b=this.coloreoConRetroceso(listaVertices, k, numColores);

	    if (b== false) {
	      // no se ha podido colorear el grafo
	      // vuelvo a la situaci�n inicial

	      for (int i = 0; i < listaVerticesNoColoreados.size( ); i++) {
	        this.verticesColoreado.remove(listaVerticesNoColoreados.get(i));
	      }
	     }
	    return b;
	 }


	 private boolean aceptable(List<Integer> listaVertices, int color, int posicion){
	   /*
	      devuelve true si al v�rtice que ocupa la posici�n k en listaVertices
	      puedo asignarle el color k de modo que no haya ning�n v�rtice en las
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
	    Supongo que a los v�rtices situados en las posiciones 0..k-1
	    de listaVertices ya les he asignado color.
	    Busco un color para el v�rtice en la posici�n k que sea compatible
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

	   // he recorrido todas las combinaciones y ninguna es v�lida, devuelvo falso.
	   return false;

	  }

	 @Override
	 public GrafoConColores clone() {
		 /* {Precondici�n: }
		  * {Postcondici�n: devuelve una copia del GrafoConColores}
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
