package grafo;
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
	
	public Map<Integer, List<Integer>> getGrafo() {
		/* {Precondición: }
		 * {Postcondición: devuelve el mapa asociado al grafo}
		 */
		return this.grafo;
	}

	public void setGrafo(Map<Integer, List<Integer>> grafo) {
		/* {Precondición: grafo es un parámetro de tipo Map<Integer, List<Integer>>}
		 * {Postcondición: asigna al atributo grafo el parámetro grafo}
		 */
		this.grafo = grafo;
	}

	public boolean anadirVertice(Integer vertice) {
		/* {Precondición: vértice es un parámetro de tipo Integer}
		 * {Postcondición: comprueba si dicho parámetro está, si esta devuelve falso y no lo añade.
		 * En caso contrario lo añade y devuelve cierto}
		 */
		boolean esta=(this.grafo.get(vertice)!=null);
		if(!esta) {
			this.grafo.put(vertice,new LinkedList<Integer>());
		}
		return !esta;
	}

	public boolean eliminarVertice(Integer vertice) {
		/* {Precondición: vértice es un parámetro de tipo Integer}
		 * {Postcondición: si se encontraba dicho vértice devuelve cierto y lo elimina. En caso contrario sólo devuelve falso.}
		 */
		List<Integer> asociados=this.grafo.get(vertice);
		this.grafo.remove(vertice);
		boolean esta=(asociados!=null);
		if(esta) {
			Iterator<Integer> it = asociados.iterator();
			
			while(it.hasNext()) {
				this.grafo.get(it.next()).remove(vertice);
			}
		}
		return esta;
	}
	
	public boolean anadirArista(Integer vertice1,Integer vertice2) {
		/* {Precondición: vertice1 y vertice2 son dos parámetros de tipo Integer y deben existir}
		 * {Postcondición: al vertice1 le pone como vértice asociado el 2. Al vertice2 le asocia el 1. Si la arista ya existía devuelve falso, si no cierto}
		 */
		List<Integer> dato1=(LinkedList<Integer>)this.grafo.get(vertice1);
		List<Integer> dato2=(LinkedList<Integer>)this.grafo.get(vertice2);
		boolean existe=(dato1.contains(vertice2))&&(dato2.contains(vertice1));
		if(!existe) {
			dato1.add(vertice2);
			dato2.add(vertice1);
		}
		return !existe;
	}
	
	public boolean eliminarArista(Integer vertice1,Integer vertice2) {
		/* {Precondición: vertice1 y vertice2 son dos parámetros de tipo Integer}
		 * {Postcondición: al vertice1 le elimina como vértice asociado el 2. Al vertice2 le elimina el 1. Devuelve cierto si la ha podido eliminar}
		 */
		List<Integer> dato1=(LinkedList<Integer>)this.grafo.get(vertice1);
		List<Integer> dato2=(LinkedList<Integer>)this.grafo.get(vertice2);
		boolean existe=(dato1.contains(vertice2))&&(dato2.contains(vertice1));
		if(existe) {	
			dato1.remove(vertice2);
			dato2.remove(vertice1);
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
		return new LinkedHashSet<Integer>(this.grafo.keySet());
	}
	
	public List<Integer> listarVerticesAdyacentes(Integer vertice){
		/* {Precondición: vertice1 es un parámetro de tipo Integer}
		 * {Postcondición: devuelve una Lista de Integers con todos los vértices asociados a uno dado}
		 */
		return new LinkedList<Integer>(this.grafo.get(vertice));
	}
	
	@Override
	public Grafo clone() {
		/* {Precondición: }
		 * {Postcondición: devuelve una copia del grafo}
		 */
		Grafo copia = new Grafo();
		Set<Integer> auxCopia = this.listarVertices();
		Iterator<Integer> it = auxCopia.iterator();
		while(it.hasNext()) {
			Integer vertice = it.next();
			List<Integer> asociados = this.listarVerticesAdyacentes(vertice);
			copia.grafo.put(vertice, asociados);
		}
		return copia;
	}
}
