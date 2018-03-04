package interfazUsuario;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import sudoku.SudokuConSolucion;

public class InterfazGraficaSudoku extends JFrame {

	private JPanel contentPane;
	private JPanel sudoku;
	private JPanel botones;

	// int tamanio2;
	public InterfazGraficaSudoku(int tamanio) {
		//tamanio = 5;
		// tamanio2 = tam

		setTitle("Sudoku");
		setBounds(100, 100, tamanio * 50, tamanio * 50);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		sudoku = new JPanel();
		botones = new JPanel();

		//fl_contentPane.setVgap(0);
		//fl_contentPane.setHgap(0);
		//contentPane.setLayout(new GridLayout(2, 1, 0, 0));
		contentPane.setLayout(new GridBagLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		GridBagConstraints c1 = new GridBagConstraints();
		c1.weightx=1d;
		c1.weighty=1d;
		sudoku.setLayout(new GridLayout(tamanio, tamanio));
		c1.ipady=100;
		c1.ipadx=250;
		c1.gridy=0;
		c1.fill=GridBagConstraints.BOTH;
		contentPane.add(sudoku,c1);
		
		JTextField casillas[][] = new JTextField[tamanio][tamanio];

		for (int i = 0; i < tamanio * tamanio; i++) {
			JTextField aux = new JTextField("");
			aux.setHorizontalAlignment(SwingConstants.CENTER);
			aux.setMaximumSize(new Dimension(50,50));
			casillas[i / tamanio][i % tamanio] = aux;
			sudoku.add(aux);
		}
		botones.setLayout(new GridLayout(1,2));
		JButton resolver = new JButton("Resolver");
		c1.ipadx=0;
		c1.ipady=0;
		c1.gridy=1;
		c1.weightx=1d;
		c1.weighty=0d;
		c1.fill=GridBagConstraints.HORIZONTAL;
		contentPane.add(botones,c1);

		resolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SudokuConSolucion sudokuConSolucion = new SudokuConSolucion(tamanio);
				for (int i = 0; i < tamanio; i++) {
					for (int j = 0; j < tamanio; j++) {
						try {
							int dato = Integer.parseInt(casillas[i][j].getText());
							sudokuConSolucion.anadirNumeroInicial(dato, i + 1, j + 1);
						} catch (NumberFormatException e) {
							//System.out.println("No es un entero el dato de esa posición.");
						}
					}
				}
				sudokuConSolucion.resolverSudoku();
				for (int i = 1; i <= tamanio; i++) {
					for (int j = 1; j <= tamanio; j++) {
						casillas[i - 1][j - 1]
								.setText(Integer.toString(sudokuConSolucion.obtenerValorDeCasilla(i, j).getNumero()));
					}
				}
			}
		});
		JButton crearNuevo = new JButton("Crear nuevo sudoku");
		crearNuevo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MenuCreacion menuCreacion = new MenuCreacion();
				menuCreacion.setVisible(true);
				dispose();
			}
		});
		botones.add(crearNuevo);
		botones.add(resolver);
		add(contentPane);
		//setResizable(false);
		pack();
	}

}
