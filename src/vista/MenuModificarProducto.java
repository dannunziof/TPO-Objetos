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

public class MenuModificarProducto extends JFrame {

	private JPanel contentPane;
	private Sistema sistema;

	/**
	 * Create the frame.
	 */
	public MenuModificarProducto(Sistema siste) {
		setTitle("Menu Modificar Productos");
		
		sistema=siste;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBicicleta = new JButton("Bicicleta");
		btnBicicleta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarBici app = new RegistrarBici(sistema);
				app.setVisible(true);
			}
		});
		btnBicicleta.setBounds(46, 58, 109, 23);
		contentPane.add(btnBicicleta);
		
		JButton btnCuatriciclo = new JButton("Cuatriciclo");
		btnCuatriciclo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarCuatriciclo app = new RegistrarCuatriciclo(sistema);
				app.setVisible(true);
			}
		});
		btnCuatriciclo.setBounds(47, 112, 108, 23);
		contentPane.add(btnCuatriciclo);
		
		JButton btnCarpa = new JButton("Carpa");
		btnCarpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarCarpa app = new RegistrarCarpa(sistema);
				app.setVisible(true);
			}
		});
		btnCarpa.setBounds(241, 58, 109, 23);
		contentPane.add(btnCarpa);
		
		JButton btnReposera = new JButton("Reposera");
		btnReposera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarReposera app = new RegistrarReposera(sistema);
				app.setVisible(true);
			}
		});
		btnReposera.setBounds(241, 112, 109, 23);
		contentPane.add(btnReposera);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(158, 214, 89, 23);
		contentPane.add(btnCancelar);
	}

}
