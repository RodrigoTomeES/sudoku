import static org.junit.Assert.*;

import org.junit.Test;

public class Tests_Sudoku {

	@Test
	public void testConstructorSudoku() {
		Sudoku prueba1 = new Sudoku(0);
		assertEquals(prueba1.tama�oSudoku(),0);
		Sudoku prueba2 = new Sudoku(3);
		assertEquals(prueba2.tama�oSudoku(),3);
		Sudoku prueba3 = new Sudoku(25);
		assertEquals(prueba3.tama�oSudoku(),25);
	}
	
	@Test
	public void testGetSudokuInicial() {
		
	}
	
	@Test
	public void testTama�oSudoku() {
		
	}
	
	@Test
	public void testA�adirNumero() {
		Sudoku prueba1 = new Sudoku(9);
		prueba1.a�adirNumero(5, 7, 7);
		assertEquals(prueba1.obtenerValorDeCasilla(7,7).getNumero(),5);
		assertFalse(prueba1.obtenerValorDeCasilla(7,7).getEstadoInicial());
		prueba1.a�adirNumero(3, 3, 1);
		assertEquals(prueba1.obtenerValorDeCasilla(3,1).getNumero(),3);
		assertFalse(prueba1.obtenerValorDeCasilla(3,1).getEstadoInicial());
		prueba1.a�adirNumero(1, 2, 5);
		assertEquals(prueba1.obtenerValorDeCasilla(2,5).getNumero(),1);
		assertFalse(prueba1.obtenerValorDeCasilla(2,5).getEstadoInicial());
	}
	
	@Test
	public void testA�adirNumeroInicial() {
		Sudoku prueba1 = new Sudoku(9);
		prueba1.a�adirNumeroInicial(5, 7, 7);
		assertEquals(prueba1.obtenerValorDeCasilla(7,7).getNumero(),5);
		assertTrue(prueba1.obtenerValorDeCasilla(7,7).getEstadoInicial());
		prueba1.a�adirNumeroInicial(3, 3, 1);
		assertEquals(prueba1.obtenerValorDeCasilla(3,1).getNumero(),3);
		assertTrue(prueba1.obtenerValorDeCasilla(3,1).getEstadoInicial());
		prueba1.a�adirNumeroInicial(1, 2, 5);
		assertEquals(prueba1.obtenerValorDeCasilla(2,5).getNumero(),1);
		assertTrue(prueba1.obtenerValorDeCasilla(2,5).getEstadoInicial());
	}
	
	@Test
	public void testEliminarNumeroACasilla() {
		Sudoku prueba1 = new Sudoku(9);
		
		prueba1.a�adirNumeroInicial(5, 7, 7);
		assertEquals(prueba1.obtenerValorDeCasilla(7,7),5);
		prueba1.a�adirNumeroInicial(3, 3, 1);
		assertEquals(prueba1.obtenerValorDeCasilla(3,1),3);
		prueba1.a�adirNumeroInicial(1, 2, 5);
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
