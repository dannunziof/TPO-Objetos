package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Sistema;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ABMProducto extends JFrame {

	private JPanel contentPane;
	private Sistema sistema;

	/**
	 * Create the frame.
	 */
	public ABMProducto(Sistema siste) {
		sistema=siste;
		setTitle("Menu ABM De Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegistrarCliente = new JButton("Registrar Producto");
		btnRegistrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuCrearProducto app = new MenuCrearProducto(sistema);
				app.setVisible(true);
			}
		});
		btnRegistrarCliente.setBounds(125, 35, 157, 23);
		contentPane.add(btnRegistrarCliente);
		
		JButton btnModificarCliente = new JButton("Modificar Producto");
		btnModificarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuModificarProducto app = new MenuModificarProducto(sistema);
				app.setVisible(true);
			}
		});
		btnModificarCliente.setBounds(125, 82, 157, 23);
		contentPane.add(btnModificarCliente);
		
		JButton btnEliminarCliente = new JButton("Eliminar Producto");
		btnEliminarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarProducto app = new EliminarProducto(sistema);
				app.setVisible(true);
			}
		});
		btnEliminarCliente.setBounds(125, 127, 157, 23);
		contentPane.add(btnEliminarCliente);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(153, 211, 89, 23);
		contentPane.add(btnCancelar);
	}

}
