package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

import grafo.GrafoConColores;

public class Tests_GrafoConColores {

	@Test
	public void testConstructorGrafoConColores() {
		GrafoConColores prueba = new GrafoConColores();
		assertEquals(prueba.numeroVertices(), 0);
	}

	@Test
	public void testAnadirColorAVertice() {
		GrafoConColores prueba = new GrafoConColores();
		prueba.anadirVertice(1);
		prueba.anadirVertice(2);
		prueba.anadirVertice(3);
		prueba.anadirColorAVertice(1, 3);
		assertEquals((int) prueba.getColorVertice(1), 3);
		prueba.anadirColorAVertice(2, 5);
		assertEquals((int) prueba.getColorVertice(2), 5);
		prueba.anadirColorAVertice(3, 89);
		assertEquals((int) prueba.getColorVertice(3), 89);
	}

	@Test
	public void testEliminarColorVertice() {
		GrafoConColores prueba = new GrafoConColores();
		prueba.anadirVertice(1);
		prueba.anadirVertice(2);
		prueba.anadirVertice(3);
		prueba.anadirColorAVertice(1, 3);
		assertEquals((int) prueba.getColorVertice(1), 3);
		prueba.anadirColorAVertice(2, 5);
		assertEquals((int) prueba.getColorVertice(2), 5);
		prueba.anadirColorAVertice(3, 89);
		assertEquals((int) prueba.getColorVertice(3), 89);
		prueba.eliminarColorVertice(1);
		assertEquals(prueba.getColorVertice(1), null);
		prueba.eliminarColorVertice(2);
		assertEquals(prueba.getColorVertice(2), null);
		prueba.eliminarColorVertice(3);
		assertEquals(prueba.getColorVertice(3), null);
	}

	@Test
	public void testGetColorVertice() {
		GrafoConColores prueba = new GrafoConColores();
		prueba.anadirVertice(1);
		prueba.anadirVertice(2);
		prueba.anadirVertice(3);
		prueba.anadirColorAVertice(1, 3);
		prueba.anadirColorAVertice(2, 324466);
		prueba.anadirColorAVertice(3, 34578);
		assertEquals((int) prueba.getColorVertice(1), 3);
		assertEquals((int) prueba.getColorVertice(2), 324466);
		assertEquals((int) prueba.getColorVertice(3), 34578);
	}

	@Test
	public void testBorrarTodosLosColores() {
		GrafoConColores prueba = new GrafoConColores();
		prueba.anadirVertice(1);
		prueba.anadirVertice(2);
		prueba.anadirVertice(3);
		prueba.anadirColorAVertice(1, 3);
		prueba.anadirColorAVertice(2, 324466);
		prueba.anadirColorAVertice(3, 34578);
		prueba.borrarTodosLosColores();
		assertEquals(prueba.getColorVertice(1), null);
		assertEquals(prueba.getColorVertice(2), null);
		assertEquals(prueba.getColorVertice(3), null);
		assertEquals(prueba.listarVerticesConColores(), new LinkedHashSet<Integer>());
	}

	@Test
	public void testListarVerticesConColores() {
		GrafoConColores prueba = new GrafoConColores();
		prueba.anadirVertice(1);
		prueba.anadirVertice(2);
		prueba.anadirVertice(3);
		prueba.anadirColorAVertice(1, 3);
		Set<Integer> aux = new HashSet<>();
		aux.add(1);
		assertEquals(prueba.listarVerticesConColores(), aux);
	}

	@Test
	public void testEsColorValido() {
		GrafoConColores prueba = new GrafoConColores();
		prueba.anadirVertice(1);
		prueba.anadirVertice(2);
		prueba.anadirVertice(3);
		prueba.anadirArista(1, 2);
		prueba.anadirArista(1, 3);
		prueba.anadirColorAVertice(3, 3);
		prueba.anadirColorAVertice(2, 2);
		assertFalse(prueba.esColorValido(1, 3));
		assertFalse(prueba.esColorValido(1, 2));
		assertTrue(prueba.esColorValido(1, 1));
	}
}
