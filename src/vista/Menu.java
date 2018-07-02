package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Sistema;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Menu extends JFrame {

	private Sistema sistema;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		
		sistema = new Sistema(); 
		
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 405, 321);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setForeground(new Color(255, 69, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCrearCliente = new JButton("ABM Clientes");
		btnCrearCliente.setFont(new Font("Algerian", Font.ITALIC, 15));
		btnCrearCliente.setForeground(new Color(255, 255, 255));
		btnCrearCliente.setBackground(new Color(0, 0, 0));
		btnCrearCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ABMCliente app = new ABMCliente(sistema);
				app.setVisible(true);
			}
		});
		btnCrearCliente.setBounds(72, 42, 233, 23);
		contentPane.add(btnCrearCliente);
		
		JButton btnRegistrarProducto = new JButton("ABM Productos");
		btnRegistrarProducto.setFont(new Font("Algerian", Font.ITALIC, 15));
		btnRegistrarProducto.setForeground(new Color(255, 255, 255));
		btnRegistrarProducto.setBackground(new Color(0, 0, 0));
		btnRegistrarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ABMProducto app = new ABMProducto(sistema);
				app.setVisible(true);
			}
		});
		btnRegistrarProducto.setBounds(72, 83, 233, 23);
		contentPane.add(btnRegistrarProducto);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("GothicE", Font.ITALIC, 15));
		btnCerrar.setForeground(new Color(255, 255, 255));
		btnCerrar.setBackground(new Color(0, 0, 0));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setBounds(120, 227, 137, 30);
		contentPane.add(btnCerrar);
		
		JButton btnAlquileres = new JButton("Alquileres");
		btnAlquileres.setFont(new Font("Algerian", Font.ITALIC, 15));
		btnAlquileres.setForeground(new Color(255, 255, 255));
		btnAlquileres.setBackground(new Color(0, 0, 0));
		btnAlquileres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuAlquileres app = new MenuAlquileres(sistema);
				app.setVisible(true);
			}
		});
		btnAlquileres.setBounds(72, 127, 233, 23);
		contentPane.add(btnAlquileres);
		
		
		
	}
}
