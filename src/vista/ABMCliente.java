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

public class ABMCliente extends JFrame {

	private JPanel contentPane;
	private Sistema sistema;

	/**
	 * Create the frame.
	 */
	public ABMCliente(Sistema siste) {
		
		sistema = siste;
		
		setTitle("Menu ABM De Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegistarProducto = new JButton("Registar Cliente");
		btnRegistarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearCliente app = new crearCliente(sistema);
				app.setVisible(true);
			}
		});
		btnRegistarProducto.setBounds(123, 43, 158, 23);
		contentPane.add(btnRegistarProducto);
		
		JButton btnModificarCliente = new JButton("Modificar Cliente");
		btnModificarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarCliente app = new ModificarCliente(sistema);
				app.setVisible(true);
			}
		});
		btnModificarCliente.setBounds(123, 91, 158, 23);
		contentPane.add(btnModificarCliente);
		
		JButton btnEliminarCliente = new JButton("Eliminar Cliente");
		btnEliminarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarCliente app = new EliminarCliente(sistema);
				app.setVisible(true);
			}
		});
		btnEliminarCliente.setBounds(123, 143, 158, 23);
		contentPane.add(btnEliminarCliente);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(157, 218, 100, 32);
		contentPane.add(btnCancelar);
	}

}
