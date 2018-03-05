package interfazUsuario;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import sudoku.SudokuConSolucion;

public class InterfazGraficaSudoku extends JFrame {

	private JPanel contentPane;
	private JPanel sudoku;
	private JPanel botones;

//	 int tamanio2;
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
		c1.ipady=250;
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
		botones.setLayout(new GridLayout(1,3));
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
				boolean bienConstruido=true;
				lecturaDeDatosDeLosCuadrosDeTexto:
				for (int i = 0; i < tamanio; i++) {
					for (int j = 0; j < tamanio; j++) {
						if(casillas[i][j].getText().equals("")) {
							
						}
						else {
							try {
								int dato = Integer.parseInt(casillas[i][j].getText());
								if(dato>=1&&dato<=tamanio) {
									sudokuConSolucion.anadirNumeroInicial(dato, i + 1, j + 1);
								}
								else {
									JOptionPane.showMessageDialog(null, "Sólo se permite introducir números entre 1 y " + tamanio + ".","Error", JOptionPane.ERROR_MESSAGE);
									bienConstruido=false;
									casillas[i][j].setText("");
									break lecturaDeDatosDeLosCuadrosDeTexto;
								}
								
							} catch (NumberFormatException e) {
								JOptionPane.showMessageDialog(null, "Sólo se permite introducir números en los campos de texto.","Error", JOptionPane.ERROR_MESSAGE);
								bienConstruido=false;
								casillas[i][j].setText("");
								break lecturaDeDatosDeLosCuadrosDeTexto;
							}
						}
						
					}
				}
				if(bienConstruido) {
					sudokuConSolucion.resolverSudoku();
					recorridoDeLaSolucion: //Necesario para poder salir del bucle si es que estaba mal resuelto.
					for (int i = 1; i <= tamanio; i++) {
						for (int j = 1; j <= tamanio; j++) {
							int numeroResultado=sudokuConSolucion.obtenerValorDeCasilla(i, j).getNumero();
							if(numeroResultado!=-1) {
								casillas[i - 1][j - 1].setText(Integer.toString(numeroResultado));
							}
							else {
								JOptionPane.showMessageDialog(null, "No se podía resolver el sudoku.","Error", JOptionPane.ERROR_MESSAGE);
								for (int n = 0; n < tamanio; n++) {
									for (int k = 0; k < tamanio; k++) {
										casillas[n][k].setText("");
									}
								}
								break recorridoDeLaSolucion;
							}
							
						}
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
		JButton limpiarSudoku = new JButton("Limpiar el sudoku");
		limpiarSudoku.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				for (int i = 0; i < tamanio; i++) {
					for (int j = 0; j < tamanio; j++) {
						casillas[i][j].setText("");

					}
				}
			}
		});
		botones.add(crearNuevo);
		botones.add(limpiarSudoku);
		botones.add(resolver);
		add(contentPane);
		//setResizable(false);
		pack();
	}

}
