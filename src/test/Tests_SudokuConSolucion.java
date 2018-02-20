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
		
	}
}
