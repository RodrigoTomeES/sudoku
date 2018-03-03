package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.TreeMap;

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
		SudokuConSolucion prueba1 = new SudokuConSolucion(9);
		prueba1.anadirNumero(1, 1, 1);
		prueba1.anadirNumero(1, 2, 2);
		assertFalse(prueba1.sePuedeResolverSudoku());
		SudokuConSolucion prueba2 = new SudokuConSolucion(9);
		prueba2.anadirNumero(1, 1, 1);
		assertTrue(prueba2.sePuedeResolverSudoku());
	}
	
	@Test
	public void testResolverSudoku() {
		SudokuConSolucion prueba1 = new SudokuConSolucion(9);
		prueba1.anadirNumeroInicial(1, 1, 1);
		prueba1.anadirNumeroInicial(1, 2, 2);
		prueba1.resolverSudoku();
		assertFalse(compruebaSiSudokuBienResuelto(prueba1));
		
		SudokuConSolucion prueba2 = new SudokuConSolucion(9);
		prueba2.anadirNumeroInicial(1, 1, 1);
		prueba2.resolverSudoku();
		assertTrue(compruebaSiSudokuBienResuelto(prueba2));
		
		
	}
	
	public boolean compruebaSiSudokuBienResuelto(SudokuConSolucion sudokuAResolver) {
		boolean resultado=true;
		int tamano = sudokuAResolver.tamanoSudoku();
		int sumaRangoValores = 45;
		
		int sumaAux;
		for(int n = 0; n < tamano && resultado; n++) {
			int fila = n;
			int columna = n;
			sumaAux = 0;
			for(int j = 0; j < tamano; j++) {
				sumaAux=sumaAux+sudokuAResolver.getSudokuInicial()[fila][j].getNumero();
			}
			resultado = (sumaAux==sumaRangoValores);
			sumaAux = 0;
			for(int i = 0; i < tamano && resultado; i++) {
				sumaAux=sumaAux+sudokuAResolver.getSudokuInicial()[i][columna].getNumero(); 
			}
			resultado = (sumaAux==sumaRangoValores);
		}
		
		int secciones = (int) Math.sqrt(tamano);
		for(int i = 1; i < tamano && resultado;i=i+secciones ) {
			for(int j = 1; j < tamano && resultado;j=j+secciones) {
				int esquinaSuperiorCuadranteFila = (i/tamano)*tamano;
				int esquinaSuperiorCuadranteColumna = (j/tamano)*tamano;
				sumaAux=0;
				for(int n=0;n<secciones;n++) {
					for(int k=0;k<secciones;k++) {
						sumaAux=sumaAux+sudokuAResolver.getSudokuInicial()[esquinaSuperiorCuadranteFila+n][esquinaSuperiorCuadranteColumna+k].getNumero();
					}
				}
				resultado = (sumaAux==sumaRangoValores);
			}
		}
		return resultado;
	}
}
