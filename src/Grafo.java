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
	
	public boolean aniadirVertice(Integer vertice) {
		/* {Precondici�n: vertice es un par�metro de tipo Integer}
		 * {Postcondici�n: comprueba si dicho par�metro est�, si est� devuelve cierto y no lo a�ade.
		 * En caso contrario lo a�ade y devuelve falso}
		 */
		boolean esta=(this.grafo.get(vertice)!=null);
		if(!esta) {
			this.grafo.put(vertice,new LinkedList<Integer>());
		}
		return esta;
	}

	public boolean eliminarVertice(Integer vertice) {
		/* {Precondici�n: vertice es un par�metro de tipo Integer}
		 * {Postcondici�n: si se encontraba dicho v�rtice devuelve cierto y lo elimina. En caso contrario s�lo devuelve falso.}
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
		/* {Precondici�n: vertice1 y vertice2 son dos par�metros de tipo Integer y deben existir}
		 * {Postcondici�n: al vertice1 le pone como vertice asociado el 2. Al vertice2 le asocia el 1}
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
		/* {Precondici�n: vertice1 y vertice2 son dos par�metros de tipo Integer}
		 * {Postcondici�n: al vertice1 le elimina como vertice asociado el 2. Al vertice2 le elimina el 1}
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
		return this.grafo.keySet();
	}
	
	public List<Integer> listarVerticesAdyacentes(Integer vertice){
		/* {Precondici�n: vertice1 es un par�metro de tipo Integer}
		 * {Postcondici�n: devuelve una Lista de Integers con todos los v�rtices asociados a uno dado}
		 */
		return this.grafo.get(vertice);
	}
	
	
}
