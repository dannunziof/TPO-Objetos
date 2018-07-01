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

public class CantidadAlquileres extends JFrame {

	private JPanel contentPane;
	private Sistema sistema;
	private JTextField codigo;
	private JTextField Cantidad;

	/**
	 * Create the frame.
	 */
	public CantidadAlquileres(Sistema siste) {
		setTitle("Cantidad De Alquileres Por Producto");
		
		sistema=siste;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(63, 74, 46, 14);
		contentPane.add(lblCodigo);
		
		codigo = new JTextField();
		codigo.setBounds(173, 71, 102, 20);
		contentPane.add(codigo);
		codigo.setColumns(10);
		
		JLabel lblVecesAlquilado = new JLabel("Veces Alquilado:");
		lblVecesAlquilado.setBounds(63, 117, 102, 14);
		contentPane.add(lblVecesAlquilado);
		
		Cantidad = new JTextField();
		Cantidad.setBounds(173, 114, 102, 20);
		contentPane.add(Cantidad);
		Cantidad.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int cantidad = sistema.cantidadAlquilado(Integer.parseInt(codigo.getText()));
					
					if (cantidad==-1) {
						JOptionPane.showMessageDialog(null, "Producto No Encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else {
						Cantidad.setText(String.valueOf(cantidad));
					}
				} catch (NumberFormatException numberFormat) {
					JOptionPane.showMessageDialog(null, "Introduzca Caracter Numerico", "ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Nuevo Error Desconocido", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnCalcular.setBounds(63, 185, 89, 23);
		contentPane.add(btnCalcular);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(259, 185, 89, 23);
		contentPane.add(btnCancelar);
	}

}
