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
		assertEquals(prueba.numeroVertices(), 0);
	}

	@Test
	public void testAnadirVertice() {
		Grafo prueba = new Grafo();
		prueba.anadirVertice(5);
		assertEquals(prueba.estaVertice(5), true);
		assertEquals(prueba.listarVertices().contains(5), true);
		prueba.anadirVertice(3);
		assertEquals(prueba.estaVertice(3), true);
		assertEquals(prueba.listarVertices().contains(3), true);
		prueba.anadirVertice(8);
		assertEquals(prueba.estaVertice(8), true);
		assertEquals(prueba.listarVertices().contains(8), true);
	}

	@Test
	public void testEliminarVertice() {
		Grafo prueba = new Grafo();

		prueba.anadirVertice(5);
		assertEquals(prueba.estaVertice(5), true);
		assertEquals(prueba.listarVertices().contains(5), true);
		prueba.eliminarVertice(5);
		prueba.eliminarVertice(3);
		assertEquals(prueba.estaVertice(5), false);
		assertEquals(prueba.estaVertice(3), false);

		prueba.anadirVertice(1);
		prueba.anadirVertice(2);
		prueba.anadirVertice(3);
		prueba.anadirArista(1, 2);
		prueba.anadirArista(1, 3);
		prueba.eliminarVertice(1);

		assertEquals(prueba.listarVerticesAdyacentes(2), new LinkedList<Integer>());
		assertEquals(prueba.listarVerticesAdyacentes(3), new LinkedList<Integer>());
	}

	@Test
	public void testAnadirArista() {
		Grafo prueba = new Grafo();
		prueba.anadirVertice(1);
		prueba.anadirVertice(2);
		prueba.anadirVertice(3);
		prueba.anadirArista(1, 2);
		assertTrue(prueba.sonAdyacentes(1, 2));
		prueba.anadirArista(1, 3);
		assertTrue(prueba.sonAdyacentes(1, 3));
		prueba.anadirArista(2, 3);
		assertTrue(prueba.sonAdyacentes(2, 3));
		assertTrue(prueba.sonAdyacentes(3, 2));
	}

	@Test
	public void testEliminarArista() {
		Grafo prueba = new Grafo();
		prueba.anadirVertice(1);
		prueba.anadirVertice(2);
		prueba.anadirVertice(3);
		prueba.anadirArista(1, 2);
		assertTrue(prueba.sonAdyacentes(1, 2));
		prueba.anadirArista(1, 3);
		assertTrue(prueba.sonAdyacentes(1, 3));
		prueba.eliminarArista(1, 2);
		List<Integer> aux = new LinkedList<>();
		aux.add(3);
		assertEquals(prueba.listarVerticesAdyacentes(1), aux);
		prueba.eliminarArista(1, 3);
		aux.remove((Object) 3);
		assertEquals(prueba.listarVerticesAdyacentes(1), aux);
		assertEquals(prueba.listarVerticesAdyacentes(1).contains(2), false);
		prueba.eliminarArista(1, 3);
		assertFalse(prueba.listarVerticesAdyacentes(1).contains(3));
	}

	@Test
	public void testNumeroVertices() {
		Grafo prueba = new Grafo();
		assertEquals(prueba.numeroVertices(), 0);
		prueba.anadirVertice(1);
		assertEquals(prueba.numeroVertices(), 1);
		prueba.anadirVertice(2);
		assertEquals(prueba.numeroVertices(), 2);
		prueba.anadirVertice(3);
		assertEquals(prueba.numeroVertices(), 3);
	}

	@Test
	public void testSonAdyacentes() {
		Grafo prueba = new Grafo();
		prueba.anadirVertice(1);
		prueba.anadirVertice(2);
		prueba.anadirVertice(3);
		prueba.anadirArista(1, 2);
		prueba.anadirArista(1, 3);
		prueba.anadirArista(2, 3);
		assertTrue(prueba.sonAdyacentes(1, 2));
		assertTrue(prueba.sonAdyacentes(1, 3));
		assertTrue(prueba.sonAdyacentes(2, 3));
		prueba.eliminarArista(1, 2);
		assertFalse(prueba.sonAdyacentes(1, 2));
		prueba.eliminarArista(1, 3);
		assertFalse(prueba.sonAdyacentes(1, 3));
		prueba.eliminarArista(2, 3);
		assertFalse(prueba.sonAdyacentes(2, 3));
	}

	@Test
	public void testEstaVertice() {
		Grafo prueba = new Grafo();
		prueba.anadirVertice(1);
		assertTrue(prueba.estaVertice(1));
		assertFalse(prueba.estaVertice(2));
	}

	@Test
	public void testListarVertices() {
		Grafo prueba = new Grafo();
		prueba.anadirVertice(1);
		prueba.anadirVertice(2);
		prueba.anadirVertice(3);
		Set<Integer> aux = new HashSet<>();
		aux.add(1);
		aux.add(2);
		aux.add(3);
		assertEquals(prueba.listarVertices(), aux);
	}

	@Test
	public void testListarVerticesAdyacentes() {
		Grafo prueba = new Grafo();
		prueba.anadirVertice(1);
		prueba.anadirVertice(2);
		prueba.anadirVertice(3);
		prueba.anadirArista(1, 2);
		prueba.anadirArista(1, 3);
		List<Integer> aux = new LinkedList<>();
		aux.add(2);
		aux.add(3);
		assertEquals(prueba.listarVerticesAdyacentes(1), aux);
	}
}
