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

public class MenuCrearProducto extends JFrame {

	private JPanel contentPane;
	private Sistema sistema;

	/**
	 * Create the frame.
	 */
	public MenuCrearProducto(Sistema siste) {
		setTitle("Menu Registrar Producto");
		
		sistema=siste;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 288, 274);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBicicleta = new JButton("Bicicleta");
		btnBicicleta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarBici app = new RegistrarBici(sistema);
				app.setVisible(true);
				dispose();
			}
		});
		btnBicicleta.setBounds(20, 38, 99, 23);
		contentPane.add(btnBicicleta);
		
		JButton btnCarpa = new JButton("Carpa");
		btnCarpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistrarCarpa app = new RegistrarCarpa(sistema);
				app.setVisible(true);
			}
		});
		btnCarpa.setBounds(157, 38, 105, 23);
		contentPane.add(btnCarpa);
		
		JButton btnCuatriciclo = new JButton("Cuatriciclo");
		btnCuatriciclo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarCuatriciclo app = new RegistrarCuatriciclo(sistema);
				app.setVisible(true);
			}
		});
		btnCuatriciclo.setBounds(20, 88, 99, 23);
		contentPane.add(btnCuatriciclo);
		
		JButton btnReposera = new JButton("Reposera");
		btnReposera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarReposera app = new RegistrarReposera(sistema);
				app.setVisible(true);
			}
		});
		btnReposera.setBounds(157, 88, 105, 23);
		contentPane.add(btnReposera);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(80, 185, 89, 23);
		contentPane.add(btnCancelar);
	}

}
