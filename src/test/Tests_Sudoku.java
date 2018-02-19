package test;
import static org.junit.Assert.*;

import org.junit.Test;

import sudoku.Sudoku;

public class Tests_Sudoku {

	@Test
	public void testConstructorSudoku() {
		Sudoku prueba1 = new Sudoku(0);
		assertEquals(prueba1.tamanoSudoku(),0);
		Sudoku prueba2 = new Sudoku(3);
		assertEquals(prueba2.tamanoSudoku(),3);
		Sudoku prueba3 = new Sudoku(25);
		assertEquals(prueba3.tamanoSudoku(),25);
	}
	
	@Test
	public void testGetSudokuInicial() {
		
	}
	
	@Test
	public void testTamañoSudoku() {
		
	}
	
	@Test
	public void testAñadirNumero() {
		Sudoku prueba1 = new Sudoku(9);
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
	public void testAñadirNumeroInicial() {
		Sudoku prueba1 = new Sudoku(9);
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
		Sudoku prueba1 = new Sudoku(9);
		
		prueba1.anadirNumeroInicial(5, 7, 7);
		assertEquals(prueba1.obtenerValorDeCasilla(7,7),5);
		prueba1.anadirNumeroInicial(3, 3, 1);
		assertEquals(prueba1.obtenerValorDeCasilla(3,1),3);
		prueba1.anadirNumeroInicial(1, 2, 5);
		assertEquals(prueba1.obtenerValorDeCasilla(2,5),1);
		
		prueba1.eliminarNumeroACasilla(7,7);
		assertEquals(prueba1.obtenerValorDeCasilla(7,7),null);
		prueba1.eliminarNumeroACasilla(3,1);
		prueba1.eliminarNumeroACasilla(2,5);
	}
	
	@Test
	public void volverAlEstadoInicial() {
		
	}
}
