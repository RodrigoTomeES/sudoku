package test;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import grafo.GrafoConColores;

public class Tests_GrafoConColores {

	@Test
	public void testConstructorGrafoConColores() {
		GrafoConColores prueba = new GrafoConColores();
		assertEquals(prueba.numeroVertices(),0);
	}
	
	@Test
	public void testAniadirColorAVertice() {
		GrafoConColores prueba = new GrafoConColores();
		prueba.aniadirVertice(1);
		prueba.aniadirVertice(2);
		prueba.aniadirVertice(3);
		prueba.aniadirColorAVertice(1,3);
		assertEquals((int)prueba.getColorVertice(1),3);
		prueba.aniadirColorAVertice(2,5);
		assertEquals((int)prueba.getColorVertice(2),5);
		prueba.aniadirColorAVertice(3,89);
		assertEquals((int)prueba.getColorVertice(3),89);
	}
	
	@Test
	public void testEliminarColorVertice() {
		GrafoConColores prueba = new GrafoConColores();
		prueba.aniadirVertice(1);
		prueba.aniadirVertice(2);
		prueba.aniadirVertice(3);
		prueba.aniadirColorAVertice(1,3);
		assertEquals((int)prueba.getColorVertice(1),3);
		prueba.aniadirColorAVertice(2,5);
		assertEquals((int)prueba.getColorVertice(2),5);
		prueba.aniadirColorAVertice(3,89);
		assertEquals((int)prueba.getColorVertice(3),89);
		prueba.eliminarColorVertice(1);
		assertEquals(prueba.getColorVertice(1),null);
		prueba.eliminarColorVertice(2);
		assertEquals(prueba.getColorVertice(2),null);
		prueba.eliminarColorVertice(3);
		assertEquals(prueba.getColorVertice(3),null);
	}
	
	@Test
	public void testGetColorVertice() {
		GrafoConColores prueba = new GrafoConColores();
		prueba.aniadirVertice(1);
		prueba.aniadirVertice(2);
		prueba.aniadirVertice(3);
		prueba.aniadirColorAVertice(1,3);
		prueba.aniadirColorAVertice(2,324466);
		prueba.aniadirColorAVertice(3,34578);
		assertEquals((int)prueba.getColorVertice(1),3);
		assertEquals((int)prueba.getColorVertice(2),324466);
		assertEquals((int)prueba.getColorVertice(3),34578);
	}
	
	@Test
	public void testBorrarTodosLosColores() {
		GrafoConColores prueba = new GrafoConColores();
		prueba.aniadirVertice(1);
		prueba.aniadirVertice(2);
		prueba.aniadirVertice(3);
		prueba.aniadirColorAVertice(1,3);
		prueba.aniadirColorAVertice(2,324466);
		prueba.aniadirColorAVertice(3,34578);
		prueba.borrarTodosLosColores();
		assertEquals(prueba.getColorVertice(1),null);
		assertEquals(prueba.getColorVertice(2),null);
		assertEquals(prueba.getColorVertice(3),null);
	}
	
	@Test
	public void testListarVerticesConColores() {
		GrafoConColores prueba = new GrafoConColores();
		prueba.aniadirVertice(1);
		prueba.aniadirVertice(2);
		prueba.aniadirVertice(3);
		prueba.aniadirColorAVertice(1,3);
		Set<Integer> aux = new HashSet<>();
		aux.add(1);
		assertEquals(prueba.listarVerticesConColores(),aux);
	}
	
	@Test
	public void testEsColorValido() {
		GrafoConColores prueba = new GrafoConColores();
		prueba.aniadirVertice(1);
		prueba.aniadirVertice(2);
		prueba.aniadirVertice(3);
		prueba.aniadirArista(1,2);
		prueba.aniadirArista(1,3);
		prueba.aniadirColorAVertice(3,3);
		prueba.aniadirColorAVertice(2, 2);
		assertFalse(prueba.esColorValido(1,3));
		assertFalse(prueba.esColorValido(1,2));
		assertTrue(prueba.esColorValido(1,1));
	}
}
