package grafo;
import java.util.*;

public class Grafo{
	private Map<Integer,List<Integer>> grafo;
	
	public Grafo(){
		/* {Precondici�n: }
		 * {Postcondici�n: inicializa el atributo grafo como un HasMap<Integer,List<Integer>> y vac�o. En dicho mapa la clave es
		 * el v�rtice y su valor asociado es la lista de v�rtices asociados}
		*/
		this.grafo=new HashMap<Integer,List<Integer>>();
	}
	
	public Map<Integer, List<Integer>> getGrafo() {
		/* {Precondici�n: }
		 * {Postcondici�n: devuelve el mapa asociado al grafo}
		 */
		return this.grafo;
	}

	public void setGrafo(Map<Integer, List<Integer>> grafo) {
		/* {Precondici�n: grafo es un par�metro de tipo Map<Integer, List<Integer>>}
		 * {Postcondici�n: asigna al atributo grafo el par�metro grafo}
		 */
		this.grafo = grafo;
	}

	public boolean anadirVertice(Integer vertice) {
		/* {Precondici�n: v�rtice es un par�metro de tipo Integer}
		 * {Postcondici�n: comprueba si dicho par�metro est�, si esta devuelve falso y no lo a�ade.
		 * En caso contrario lo a�ade y devuelve cierto}
		 */
		boolean esta=(this.grafo.get(vertice)!=null);
		if(!esta) {
			this.grafo.put(vertice,new LinkedList<Integer>());
		}
		return !esta;
	}

	public boolean eliminarVertice(Integer vertice) {
		/* {Precondici�n: v�rtice es un par�metro de tipo Integer}
		 * {Postcondici�n: si se encontraba dicho v�rtice devuelve cierto y lo elimina. En caso contrario s�lo devuelve falso.}
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
		/* {Precondici�n: vertice1 y vertice2 son dos par�metros de tipo Integer y deben existir}
		 * {Postcondici�n: al vertice1 le pone como v�rtice asociado el 2. Al vertice2 le asocia el 1. Si la arista ya exist�a devuelve falso, si no cierto}
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
		/* {Precondici�n: vertice1 y vertice2 son dos par�metros de tipo Integer}
		 * {Postcondici�n: al vertice1 le elimina como v�rtice asociado el 2. Al vertice2 le elimina el 1. Devuelve cierto si la ha podido eliminar}
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
		/* {Precondici�n: }
		 * {Postcondici�n: devuelve el n�mero de v�rtices que hay en todo el grafo}
		 */
		return this.grafo.size();
	}
	
	public boolean sonAdyacentes(Integer vertice1,Integer vertice2) {
		/* {Precondici�n: vertice1 y vertice2 son dos par�metros de tipo Integer}
		 * {Postcondici�n: comprueba si en los v�rtices asociados al 1 est� el 2.
		 * Comprueba si en los v�rtices asociados al 2 se encuentra el 1}
		 */
		List<Integer> dato1=(LinkedList<Integer>)this.grafo.get(vertice1);
		List<Integer> dato2=(LinkedList<Integer>)this.grafo.get(vertice2);
		return (dato1.contains(vertice2))&&(dato2.contains(vertice1));
	}
	
	public boolean estaVertice(Integer vertice1) {
		/* {Precondici�n: vertice1 es un par�metro de tipo Integer}
		 * {Postcondici�n: de vuelve cierto si el grafo contiene a dicho v�rtice y falso en caso contrario}
		 */
		return this.grafo.containsKey(vertice1);
	}
	
	public Set<Integer> listarVertices(){
		/* {Precondici�n: }
		 * {Postcondici�n: devuelve un Set<Integer> con todos los v�rtices del grafo}
		 */
		return new LinkedHashSet<Integer>(this.grafo.keySet());
	}
	
	public List<Integer> listarVerticesAdyacentes(Integer vertice){
		/* {Precondici�n: vertice1 es un par�metro de tipo Integer}
		 * {Postcondici�n: devuelve una Lista de Integers con todos los v�rtices asociados a uno dado}
		 */
		return new LinkedList<Integer>(this.grafo.get(vertice));
	}
	
	@Override
	public Grafo clone() {
		/* {Precondici�n: }
		 * {Postcondici�n: devuelve una copia del grafo}
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
