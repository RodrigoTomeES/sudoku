import java.util.*;

public class Grafo{
	private Map<Integer,List<Integer>> grafo;
	
	public Grafo(){
		/* {Precondición: }
		 * {Postcondición: inicializa el atributo grafo como un HasMap<Integer,List<Integer>> y vacío. En dicho mapa la clave es
		 * el vértice y su valor asociado es la lista de vértices asociados}
		*/
		this.grafo=new HashMap<Integer,List<Integer>>();
	}
	
	public boolean aniadirVertice(Integer vertice) {
		/* {Precondición: vertice es un parámetro de tipo Integer}
		 * {Postcondición: comprueba si dicho parámetro está, si está devuelve cierto y no lo añade.
		 * En caso contrario lo añade y devuelve falso}
		 */
		boolean esta=(this.grafo.get(vertice)!=null);
		if(!esta) {
			this.grafo.put(vertice,new LinkedList<Integer>());
		}
		return esta;
	}

	public boolean eliminarVertice(Integer vertice) {
		/* {Precondición: vertice es un parámetro de tipo Integer}
		 * {Postcondición: si se encontraba dicho vértice devuelve cierto y lo elimina. En caso contrario sólo devuelve falso.}
		 */
		List<Integer> asociados=this.grafo.get(vertice);
		this.grafo.remove(vertice);
		boolean esta=(asociados!=null);
		if(esta) {
			
			
			//Preguntar
			
			Iterator it = asociados.iterator();
			
			while(it.hasNext()) {
				this.grafo.get(it.next()).remove(vertice);
			}
		}
		return esta;
	}
	
	public boolean aniadirArista(Integer vertice1,Integer vertice2) {
		/* {Precondición: vertice1 y vertice2 son dos parámetros de tipo Integer y deben existir}
		 * {Postcondición: al vertice1 le pone como vertice asociado el 2. Al vertice2 le asocia el 1}
		 */
		List<Integer> dato1=(LinkedList<Integer>)this.grafo.get(vertice1);
		List<Integer> dato2=(LinkedList<Integer>)this.grafo.get(vertice2);
		boolean existe=(dato1.contains(vertice2))&&(dato2.contains(vertice1));
		if(!existe) {
			this.grafo.get(vertice1).add(vertice2);
			this.grafo.get(vertice2).add(vertice1);
		}
		return !existe;
	}
	
	public boolean eliminarArista(Integer vertice1,Integer vertice2) {
		/* {Precondición: vertice1 y vertice2 son dos parámetros de tipo Integer}
		 * {Postcondición: al vertice1 le elimina como vertice asociado el 2. Al vertice2 le elimina el 1}
		 */
		List<Integer> dato1=(LinkedList<Integer>)this.grafo.get(vertice1);
		List<Integer> dato2=(LinkedList<Integer>)this.grafo.get(vertice2);
		boolean existe=(dato1.contains(vertice2))&&(dato2.contains(vertice1));
		if(existe) {
			/*
			this.grafo.get(vertice1).remove(vertice2);
			this.grafo.get(vertice2).remove(vertice1);
			*/
			
			dato1.remove(vertice2);
			dato2.remove(vertice1);
			/*
			this.grafo.put(vertice1,dato1);
			this.grafo.put(vertice2,dato2);
			*/
		}
		return existe;
	}
	
	public int numeroVertices() {
		/* {Precondición: }
		 * {Postcondición: devuelve el número de vértices que hay en todo el grafo}
		 */
		return this.grafo.size();
	}
	
	public boolean sonAdyacentes(Integer vertice1,Integer vertice2) {
		/* {Precondición: vertice1 y vertice2 son dos parámetros de tipo Integer}
		 * {Postcondición: comprueba si en los vértices asociados al 1 está el 2.
		 * Comprueba si en los vértices asociados al 2 se encuentra el 1}
		 */
		List<Integer> dato1=(LinkedList<Integer>)this.grafo.get(vertice1);
		List<Integer> dato2=(LinkedList<Integer>)this.grafo.get(vertice2);
		return (dato1.contains(vertice2))&&(dato2.contains(vertice1));
	}
	
	public boolean estaVertice(Integer vertice1) {
		/* {Precondición: vertice1 es un parámetro de tipo Integer}
		 * {Postcondición: de vuelve cierto si el grafo contiene a dicho vértice y falso en caso contrario}
		 */
		return this.grafo.containsKey(vertice1);
	}
	
	public Set<Integer> listarVertices(){
		/* {Precondición: }
		 * {Postcondición: devuelve un Set<Integer> con todos los vértices del grafo}
		 */
		return this.grafo.keySet();
	}
	
	public List<Integer> listarVerticesAdyacentes(Integer vertice){
		/* {Precondición: vertice1 es un parámetro de tipo Integer}
		 * {Postcondición: devuelve una Lista de Integers con todos los vértices asociados a uno dado}
		 */
		return this.grafo.get(vertice);
	}
	
	
}
