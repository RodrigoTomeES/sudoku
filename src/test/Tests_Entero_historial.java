package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import sudoku.Entero_historial;

public class Tests_Entero_historial {

	@Test
	public void testConstructor() {
		Entero_historial prueba1 = new Entero_historial(5, false);
		assertEquals(prueba1.getNumero(), 5);
		assertFalse(prueba1.getEstadoInicial());
		Entero_historial prueba2 = new Entero_historial(85, true);
		assertEquals(prueba2.getNumero(), 85);
		assertTrue(prueba2.getEstadoInicial());
		Entero_historial prueba3 = new Entero_historial();
		assertEquals(prueba3.getNumero(), -1);
		assertFalse(prueba3.getEstadoInicial());
	}

	@Test
	public void testGetSetNumero() {
		Entero_historial prueba1 = new Entero_historial(2, true);
		assertEquals(prueba1.getNumero(), 2);
		prueba1.setNumero(4);
		assertEquals(prueba1.getNumero(), 4);
		assertTrue(prueba1.getEstadoInicial());
	}

	@Test
	public void testGetSetEstadoInicial() {
		Entero_historial prueba1 = new Entero_historial(2, true);
		assertEquals(prueba1.getNumero(), 2);
		assertTrue(prueba1.getEstadoInicial());
		prueba1.setEstadoInicial(false);
		assertFalse(prueba1.getEstadoInicial());
	}
}
