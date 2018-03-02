package interfazUsuario;

import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import sudoku.SudokuConSolucion;

public class InterfazGraficaSudoku extends JFrame {

	private JPanel contentPane;
	
	
	public InterfazGraficaSudoku(int tamanio) {
		setTitle("Sudoku");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(tamanio,tamanio));
		
		JTextField casillas[][] = new JTextField [tamanio][tamanio];
		
		for(int i=0;i<tamanio*tamanio;i++) {
			JTextField aux = new JTextField("");
			casillas[i/tamanio][i%tamanio]=aux;
			contentPane.add(aux);
		}
		JButton button = new JButton("Resolver");
		contentPane.add(button);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SudokuConSolucion sudokuConSolucion = new SudokuConSolucion(tamanio);
				for(int i=0;i<tamanio;i++) {
					for(int j=0;j<tamanio;j++) {
						try {
							int dato = Integer.parseInt(casillas[i][j].getText());
							sudokuConSolucion.anadirNumeroInicial(dato, i+1, j+1);
						}

						catch (NumberFormatException e) {
							System.out.println("No es un entero el dato de esa posición.");
						}
					}
				}
				sudokuConSolucion.resolverSudoku();
				for(int i=1;i<=tamanio;i++) {
					for(int j=1;j<=tamanio;j++) {
						casillas[i-1][j-1].setText(Integer.toString(sudokuConSolucion.obtenerValorDeCasilla(i,j).getNumero()));

					}
				}
			}
		});
	}

}
