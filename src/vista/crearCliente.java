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

public class crearCliente extends JFrame {

	private JPanel contentPane;
	private JTextField DNI;
	private JTextField Domicilio;
	private JTextField Nombre;
	private JTextField Telefono;
	private JTextField Email;
	private Sistema sistema;

	/**
	 * Create the frame.
	 */
	public crearCliente(Sistema siste) {
		sistema=siste;
		setTitle("Registrar Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(30, 42, 34, 14);
		contentPane.add(lblDni);
		
		DNI = new JTextField();
		DNI.setBounds(100, 39, 122, 20);
		contentPane.add(DNI);
		DNI.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(30, 107, 60, 14);
		contentPane.add(lblNombre);
		
		JLabel lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setBounds(30, 74, 60, 14);
		contentPane.add(lblDomicilio);
		
		Domicilio = new JTextField();
		Domicilio.setBounds(100, 70, 122, 20);
		contentPane.add(Domicilio);
		Domicilio.setColumns(10);
		
		Nombre = new JTextField();
		
		Nombre.setBounds(100, 104, 122, 20);
		contentPane.add(Nombre);
		Nombre.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(30, 144, 60, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(30, 183, 46, 14);
		contentPane.add(lblEmail);
		
		Telefono = new JTextField();
		Telefono.setBounds(100, 141, 122, 20);
		contentPane.add(Telefono);
		Telefono.setColumns(10);
		
		Email = new JTextField();
		Email.setBounds(100, 180, 216, 20);
		contentPane.add(Email);
		Email.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					boolean aux=sistema.crearCliente(Integer.parseInt(DNI.getText()), Nombre.getText(), Domicilio.getText(), Email.getText(), Integer.parseInt(Telefono.getText()));
					dispose();
					if (aux==true) {
						JOptionPane.showMessageDialog(null, "Cliente Creado", "Exito", JOptionPane.INFORMATION_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(null, "Cliente Ya Existente ", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException number) {
					JOptionPane.showMessageDialog(null, "Introduzca Datos Validos", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				 catch (Exception ex) 
				{
						ex.printStackTrace();
					 JOptionPane.showMessageDialog(null, "Nuevo Error Desconocido", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				
				
			}
		});
		btnOk.setBounds(68, 239, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(265, 239, 89, 23);
		contentPane.add(btnCancelar);
	}
}
