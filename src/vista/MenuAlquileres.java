package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Sistema;

public class MenuAlquileres extends JFrame {

	private JPanel contentPane;
	private Sistema sistema;

	/**
	 * Create the frame.
	 */
	public MenuAlquileres(Sistema siste) {
		
		sistema=siste;
		
		setTitle("Menu Alquileres");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDevolverAlquiler = new JButton("Devolver Alquiler");
		btnDevolverAlquiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DevolverAlquiler app = new DevolverAlquiler(sistema);
				app.setVisible(true);
			}
		});
		btnDevolverAlquiler.setBounds(72, 83, 250, 23);
		contentPane.add(btnDevolverAlquiler);
		
		JButton btnRecaudacionFiltradaPor = new JButton("Recaudacion Filtrada Por Fechas");
		btnRecaudacionFiltradaPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TotalPorFechas app = new TotalPorFechas(sistema);
				app.setVisible(true);
			}
		});
		btnRecaudacionFiltradaPor.setBounds(72, 130, 250, 23);
		contentPane.add(btnRecaudacionFiltradaPor);
		
		JButton btnCantidadDeAlquileres = new JButton("Cantidad De Alquileres Por Producto");
		btnCantidadDeAlquileres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CantidadAlquileres app = new CantidadAlquileres(sistema);
				app.setVisible(true);
			}
		});
		btnCantidadDeAlquileres.setBounds(72, 175, 250, 23);
		contentPane.add(btnCantidadDeAlquileres);
		
		JButton btnDisponibilidadDeProducto = new JButton("Disponibilidad De Producto");
		btnDisponibilidadDeProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisponibilidadProducto app = new DisponibilidadProducto(sistema);
				app.setVisible(true);
			}
		});
		btnDisponibilidadDeProducto.setBounds(72, 224, 250, 23);
		contentPane.add(btnDisponibilidadDeProducto);
		
		JButton btnRegistrarAlquiler = new JButton("Registrar Alquiler");
		btnRegistrarAlquiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarAlquiler app = new RegistrarAlquiler(sistema);
				app.setVisible(true);
			}
		});
		btnRegistrarAlquiler.setBounds(72, 41, 250, 23);
		contentPane.add(btnRegistrarAlquiler);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(153, 283, 98, 30);
		contentPane.add(btnCancelar);
	}

}
