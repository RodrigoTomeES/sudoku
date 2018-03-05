package test;
import static org.junit.Assert.*;

import org.junit.Test;

import sudoku.Sudoku;

public class Tests_Sudoku {

	@Test
	public void testConstructorSudoku_TamañoSudoku() {
		Sudoku prueba1 = new Sudoku(0);
		assertEquals(prueba1.tamanoSudoku(),0);
		Sudoku prueba2 = new Sudoku(3);
		assertEquals(prueba2.tamanoSudoku(),3);
		Sudoku prueba3 = new Sudoku(25);
		assertEquals(prueba3.tamanoSudoku(),25);
	}
	
	@Test
	public void testGetSudokuInicial() {
		Sudoku prueba = new Sudoku(9);
		for(int i=1;i<=9;i++) {
			for(int j=1;j<=9;j++) {
				prueba.anadirNumero(4, i, j);
			}
		}
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				assertEquals(prueba.getSudokuInicial()[i][j].getNumero(),4);
			}
		}
	}
	
	@Test
	public void testAnadirNumero() {
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
	public void testAnadirNumeroInicial() {
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
		assertEquals(prueba1.obtenerValorDeCasilla(7,7).getNumero(),5);
		prueba1.anadirNumeroInicial(3, 3, 1);
		assertEquals(prueba1.obtenerValorDeCasilla(3,1).getNumero(),3);
		prueba1.anadirNumeroInicial(1, 2, 5);
		assertEquals(prueba1.obtenerValorDeCasilla(2,5).getNumero(),1);
		
		prueba1.eliminarNumeroACasilla(7,7);
		assertEquals(prueba1.obtenerValorDeCasilla(7,7).getNumero(),-1);
		prueba1.eliminarNumeroACasilla(3,1);
		assertEquals(prueba1.obtenerValorDeCasilla(3,1).getNumero(),-1);
		prueba1.eliminarNumeroACasilla(2,5);
		assertEquals(prueba1.obtenerValorDeCasilla(2,5).getNumero(),-1);
	}
	
	@Test
	public void testVolverAlEstadoInicial() {
		Sudoku prueba = new Sudoku(2);

		prueba.anadirNumeroInicial(1, 1, 1);
		prueba.anadirNumeroInicial(1, 2, 2);
		
		prueba.anadirNumero(1, 1, 2);
		prueba.anadirNumero(1, 2, 1);
		
		assertEquals(prueba.getSudokuInicial()[0][0].getNumero(),1);
		assertTrue(prueba.getSudokuInicial()[0][0].getEstadoInicial());
		assertEquals(prueba.getSudokuInicial()[1][1].getNumero(),1);
		assertTrue(prueba.getSudokuInicial()[1][1].getEstadoInicial());
		
		assertEquals(prueba.getSudokuInicial()[0][1].getNumero(),1);
		assertFalse(prueba.getSudokuInicial()[0][1].getEstadoInicial());
		assertEquals(prueba.getSudokuInicial()[1][0].getNumero(),1);
		assertFalse(prueba.getSudokuInicial()[1][0].getEstadoInicial());
		
		prueba.volverAlEstadoInicial();
		
		assertEquals(prueba.getSudokuInicial()[0][0].getNumero(),1);
		assertTrue(prueba.getSudokuInicial()[0][0].getEstadoInicial());
		assertEquals(prueba.getSudokuInicial()[1][1].getNumero(),1);
		assertTrue(prueba.getSudokuInicial()[1][1].getEstadoInicial());
		
		assertEquals(prueba.getSudokuInicial()[0][1].getNumero(),-1);
		assertFalse(prueba.getSudokuInicial()[0][1].getEstadoInicial());
		assertEquals(prueba.getSudokuInicial()[1][0].getNumero(),-1);
		assertFalse(prueba.getSudokuInicial()[1][0].getEstadoInicial());
	}
	
	@Test
	public void testEsCorrectoAnadirValorACasilla() {
		Sudoku prueba = new Sudoku(9);

		prueba.anadirNumeroInicial(1, 1, 1);
		assertFalse(prueba.esCorrectoAnadirValorACasilla(1, 2, 2));
		assertTrue(prueba.esCorrectoAnadirValorACasilla(2, 2, 2));
		prueba.anadirNumeroInicial(2, 2, 2);
		assertFalse(prueba.esCorrectoAnadirValorACasilla(2, 3, 3));
		assertFalse(prueba.esCorrectoAnadirValorACasilla(2, 3, 2));
		assertFalse(prueba.esCorrectoAnadirValorACasilla(1, 3, 3));
		assertTrue(prueba.esCorrectoAnadirValorACasilla(3, 3, 3));
	}
}
