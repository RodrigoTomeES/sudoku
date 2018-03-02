package interfazUsuario;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MenuCreacion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuCreacion frame = new MenuCreacion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuCreacion() {
		setResizable(false);
		setTitle("Men\u00FA de creaci\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Doy tamaño a la venta
		setBounds(100, 100, 350, 250);
		// Centro el contenido en la pantalla
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		textField = new JTextField();
		btnNewButton = new JButton("Crear");

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		textField.setMinimumSize(new Dimension(10, 10));
		contentPane.add(textField, BorderLayout.CENTER);

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int tamanio = Integer.parseInt(textField.getText());
					if (tamanio == 2 || tamanio == 4 || tamanio == 9) {
						InterfazGraficaSudoku interfazGraficaSudoku = new InterfazGraficaSudoku(tamanio);
						interfazGraficaSudoku.setVisible(true);
						// PREGUNTAR COMO CERRAR VENTANA
					}
				} catch (NumberFormatException e) {
					System.out.println(
							"No se ha podido crear la interfaz gráfica, ya que el dato introducido no es un entero.");
				}
			}
		});

		btnNewButton.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(btnNewButton, BorderLayout.SOUTH);

		JLabel lblIntroduceElTamao = new JLabel("Introduce el tama\u00F1o del Sudoku(2,4,9), por favor.");
		contentPane.add(lblIntroduceElTamao, BorderLayout.NORTH);
		this.pack();
	}

}
