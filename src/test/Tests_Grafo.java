package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import grafo.Grafo;

public class Tests_Grafo {

	@Test
	public void testConstructor() {
		Grafo prueba = new Grafo();
		assertEquals(prueba.numeroVertices(),0);
	}
	
	@Test
	public void testAniadirVertice() {
		Grafo prueba = new Grafo();
		prueba.aniadirVertice(5);
		assertEquals(prueba.estaVertice(5),true);
		assertEquals(prueba.listarVertices().contains(5),true);
		prueba.aniadirVertice(3);
		assertEquals(prueba.estaVertice(3),true);
		prueba.aniadirVertice(3);
		assertEquals(prueba.estaVertice(3),true);
	}
	
	@Test
	public void testEliminarVertice() {
		Grafo prueba = new Grafo();
		
		prueba.aniadirVertice(5);
		assertEquals(prueba.estaVertice(5),true);
		assertEquals(prueba.listarVertices().contains(5),true);
		prueba.eliminarVertice(5);
		prueba.eliminarVertice(3);
		assertEquals(prueba.estaVertice(3),false);
		
		prueba.aniadirVertice(1);
		prueba.aniadirVertice(2);
		prueba.aniadirVertice(3);
		prueba.aniadirArista(1,2);
		prueba.aniadirArista(1,3);
		prueba.eliminarVertice(1);
		
		assertEquals(prueba.listarVerticesAdyacentes(2),new LinkedList<Integer>());
		assertEquals(prueba.listarVerticesAdyacentes(3),new LinkedList<Integer>());
	}
	
	@Test
	public void testAniadirArista() {
		Grafo prueba = new Grafo();
		prueba.aniadirVertice(1);
		prueba.aniadirVertice(2);
		prueba.aniadirVertice(3);
		prueba.aniadirArista(1,2);
		assertTrue(prueba.sonAdyacentes(1,2));
		prueba.aniadirArista(1,3);
		assertTrue(prueba.sonAdyacentes(1,3));
		prueba.aniadirArista(2,3);
		assertTrue(prueba.sonAdyacentes(2,3));
		assertTrue(prueba.sonAdyacentes(3,2));
	}
	
	@Test
	public void testEliminarArista() {
		Grafo prueba = new Grafo();
		prueba.aniadirVertice(1);
		prueba.aniadirVertice(2);
		prueba.aniadirVertice(3);
		prueba.aniadirArista(1,2);
		assertTrue(prueba.sonAdyacentes(1,2));
		prueba.aniadirArista(1,3);
		assertTrue(prueba.sonAdyacentes(1,3));
		prueba.eliminarArista(1,2);
		List<Integer> aux = new LinkedList<>();
		aux.add(3);
		assertEquals(prueba.listarVerticesAdyacentes(1),aux);
		prueba.eliminarArista(1,3);
		aux.remove((Object)3);
		assertEquals(prueba.listarVerticesAdyacentes(1),aux);
		assertEquals(prueba.listarVerticesAdyacentes(1).contains(2),false);
		prueba.eliminarArista(1,3);
		assertFalse(prueba.listarVerticesAdyacentes(1).contains(3));
	}
	
	@Test
	public void testNumeroVertices() {
		Grafo prueba = new Grafo();
		assertEquals(prueba.numeroVertices(),0);
		prueba.aniadirVertice(1);
		assertEquals(prueba.numeroVertices(),1);
		prueba.aniadirVertice(2);
		assertEquals(prueba.numeroVertices(),2);
		prueba.aniadirVertice(3);
		assertEquals(prueba.numeroVertices(),3);
	}
	
	@Test
	public void testSonAdyacentes() {
		Grafo prueba = new Grafo();
		prueba.aniadirVertice(1);
		prueba.aniadirVertice(2);
		prueba.aniadirVertice(3);
		prueba.aniadirArista(1,2);
		prueba.aniadirArista(1,3);
		prueba.aniadirArista(2,3);
		assertTrue(prueba.sonAdyacentes(1,2));
		assertTrue(prueba.sonAdyacentes(1,3));
		assertTrue(prueba.sonAdyacentes(2,3));
		prueba.eliminarArista(1,2);
		assertFalse(prueba.sonAdyacentes(1,2));
		prueba.eliminarArista(1,3);
		assertFalse(prueba.sonAdyacentes(1,3));
		prueba.eliminarArista(2,3);
		assertFalse(prueba.sonAdyacentes(2,3));
	}
	
	@Test
	public void testEstaVertice() {
		Grafo prueba = new Grafo();
		prueba.aniadirVertice(1);
		assertTrue(prueba.estaVertice(1));
		assertFalse(prueba.estaVertice(2));
	}
	
	@Test
	public void testListarVertices() {
		Grafo prueba = new Grafo();
		prueba.aniadirVertice(1);
		prueba.aniadirVertice(2);
		prueba.aniadirVertice(3);
		Set<Integer> aux = new HashSet<>();
		aux.add(1);
		aux.add(2);
		aux.add(3);
		assertEquals(prueba.listarVertices(),aux);
	}
	
	@Test
	public void testListarVerticesAdyacentes() {
		Grafo prueba = new Grafo();
		prueba.aniadirVertice(1);
		prueba.aniadirVertice(2);
		prueba.aniadirVertice(3);
		prueba.aniadirArista(1,2);
		prueba.aniadirArista(1,3);
		List<Integer> aux = new LinkedList<>();
		aux.add(2);
		aux.add(3);
		assertEquals(prueba.listarVerticesAdyacentes(1),aux);
	}
}
