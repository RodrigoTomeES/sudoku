package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import sudoku.SudokuConSolucion;

public class Tests_SudokuConSolucion {

	@Test
	public void testAnadirNumero() {
		SudokuConSolucion prueba1 = new SudokuConSolucion(9);
		prueba1.anadirNumero(5, 7, 7);
		assertEquals(prueba1.obtenerValorDeCasilla(7,7).getNumero(),5);
		assertFalse(prueba1.obtenerValorDeCasilla(7,7).getEstadoInicial());
		prueba1.anadirNumero(3, 3, 1);
		assertEquals(prueba1.obtenerValorDeCasilla(3,1).getNumero(),3);
		assertFalse(prueba1.obtenerValorDeCasilla(3,1).getEstadoInicial());
		prueba1.anadirNumero(1, 2, 5);
		assertEquals(prueba1.obtenerValorDeCasilla(2,5).getNumero(),1);
		assertFalse(prueba1.obtenerValorDeCasilla(2,5).getEstadoInicial());
	}
	
	@Test
	public void testAnadirNumeroInicial() {
		SudokuConSolucion prueba1 = new SudokuConSolucion(9);
		prueba1.anadirNumeroInicial(5, 7, 7);
		assertEquals(prueba1.obtenerValorDeCasilla(7,7).getNumero(),5);
		assertTrue(prueba1.obtenerValorDeCasilla(7,7).getEstadoInicial());
		prueba1.anadirNumeroInicial(3, 3, 1);
		assertEquals(prueba1.obtenerValorDeCasilla(3,1).getNumero(),3);
		assertTrue(prueba1.obtenerValorDeCasilla(3,1).getEstadoInicial());
		prueba1.anadirNumeroInicial(1, 2, 5);
		assertEquals(prueba1.obtenerValorDeCasilla(2,5).getNumero(),1);
		assertTrue(prueba1.obtenerValorDeCasilla(2,5).getEstadoInicial());
	}
	
	@Test
	public void testEliminarNumeroACasilla() {
		SudokuConSolucion prueba = new SudokuConSolucion(4);
		prueba.anadirNumero(1, 1, 1);
		prueba.eliminarNumeroACasilla(1, 1);
		
		assertEquals(prueba.obtenerValorDeCasilla(1, 1).getNumero(),-1);
		assertEquals(prueba.getGr().getColorVertice(prueba.obtenerValorDeCasilla(1, 1).getNumero()),null);
	}
	
	@Test
	public void testSePuedeResolverSudoku() {
		SudokuConSolucion prueba = new SudokuConSolucion(9);
		prueba.anadirNumero(1, 1, 1);
		prueba.anadirNumero(1, 2, 2);
		assertFalse(prueba.sePuedeResolverSudoku());
	}
	
	@Test
	public void testResolverSudoku() {
		SudokuConSolucion prueba = new SudokuConSolucion(9);
		prueba.anadirNumero(1, 1, 1);
		prueba.anadirNumero(1, 2, 2);

		boolean resultado=true;
		
		for(int n = 0; n < prueba.tamanoSudoku(); n++) {
			int fila = n;
			int columna = n;
			int valor = prueba.getSudokuInicial()[n][n].getNumero();
			
			for(int j = 0; j < prueba.tamanoSudoku() && resultado; j++) {
				resultado = prueba.getSudokuInicial()[fila][j].getNumero() != valor;
			}
			
			for(int i = 0; i < prueba.tamanoSudoku() && resultado; i++) {
				resultado = prueba.getSudokuInicial()[i][columna].getNumero() != valor;
			}
		}
		
		int secciones = (int) Math.sqrt(prueba.tamanoSudoku());
		
		int k = 0;
		int n = 0;
		while(k < secciones) {
			int columna = n;
			while(n < secciones) {
				int fila = k;
				int valor = prueba.getSudokuInicial()[n][n].getNumero();
				int tamano = (int) Math.sqrt(prueba.tamanoSudoku());
				int esquinaSuperiorCuadranteFila = (fila+1/tamano)*tamano;
				int esquinaSuperiorCuadranteColumna = (columna+1/tamano)*tamano;
				
				for(int i = 0; i < tamano && resultado; i++) {
					for(int j = 0; j < tamano && resultado; j++) {
						resultado = prueba.getSudokuInicial()[esquinaSuperiorCuadranteFila+i][esquinaSuperiorCuadranteColumna+j].getNumero() != valor;
					}
				}
				n++;
			}
			k++;
			n = 0;
			columna += secciones;
		}
		assertFalse(resultado);
	}
}
