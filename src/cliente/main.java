package cliente;

import sudoku.SudokuConSolucion;

public class main {
	public static void main(String[] args) {
		SudokuConSolucion prueba = new SudokuConSolucion(9);
		prueba.anadirNumeroInicial(1, 1, 1);
		prueba.resolverSudoku();
		prueba.mostrarEstadoSudoku();
	}
}
