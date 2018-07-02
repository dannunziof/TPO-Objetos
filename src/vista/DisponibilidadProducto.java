package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Sistema;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisponibilidadProducto extends JFrame {

	private JPanel contentPane;
	private Sistema sistema;
	private JTextField codigo;
	private JTextField Disponibilidad;

	/**
	 * Create the frame.
	 */
	public DisponibilidadProducto(Sistema siste) {
		setTitle("Disponibilidad De Producto");
		
		sistema=siste;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(41, 58, 46, 14);
		contentPane.add(lblCodigo);
		
		codigo = new JTextField();
		codigo.setBounds(138, 55, 112, 20);
		contentPane.add(codigo);
		codigo.setColumns(10);
		
		JLabel lblDisponibilidad = new JLabel("Disponibilidad:");
		lblDisponibilidad.setBounds(41, 102, 87, 14);
		contentPane.add(lblDisponibilidad);
		
		Disponibilidad = new JTextField();
		Disponibilidad.setBounds(138, 99, 112, 20);
		contentPane.add(Disponibilidad);
		Disponibilidad.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String estado = sistema.productoDisponible(Integer.parseInt(codigo.getText()));
					Disponibilidad.setText(estado);
//					if (estado.equals("1")) {
//						JOptionPane.showMessageDialog(null, "Producto No Encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
//					}
//					else {
//						Disponibilidad.setText(String.valueOf(estado));
//					}
				} catch (NumberFormatException numberFormat) {
					JOptionPane.showMessageDialog(null, "Introduzca Caracter Numerico", "ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Nuevo Error Desconocido", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnOk.setBounds(41, 196, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(236, 196, 89, 23);
		contentPane.add(btnCancelar);
	}

}
