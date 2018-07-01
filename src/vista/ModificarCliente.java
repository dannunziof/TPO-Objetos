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

public class ModificarCliente extends JFrame {

	private JPanel contentPane;
	private Sistema sistema;
	private JTextField dni;
	private JTextField nombre;
	private JTextField domicilio;
	private JTextField mail;
	private JTextField telefono;

	/**
	 * Create the frame.
	 */
	public ModificarCliente(Sistema siste) {
		setTitle("Menu Modificacion Cliente");
		
		sistema=siste;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblXzxz = new JLabel("DNI: ");
		lblXzxz.setBounds(34, 47, 46, 14);
		contentPane.add(lblXzxz);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(34, 86, 66, 14);
		contentPane.add(lblNombre);
		
		JLabel lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setBounds(34, 128, 66, 14);
		contentPane.add(lblDomicilio);
		
		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setBounds(34, 174, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(34, 215, 66, 14);
		contentPane.add(lblTelefono);
		
		dni = new JTextField();
		dni.setBounds(110, 44, 119, 20);
		contentPane.add(dni);
		dni.setColumns(10);
		
		nombre = new JTextField();
		nombre.setBounds(110, 83, 119, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		domicilio = new JTextField();
		domicilio.setBounds(110, 125, 119, 20);
		contentPane.add(domicilio);
		domicilio.setColumns(10);
		
		mail = new JTextField();
		mail.setBounds(110, 171, 207, 20);
		contentPane.add(mail);
		mail.setColumns(10);
		
		telefono = new JTextField();
		telefono.setBounds(110, 212, 119, 20);
		contentPane.add(telefono);
		telefono.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int aux = sistema.modificarCliente(Integer.parseInt(dni.getText()), nombre.getText(), domicilio.getText(), mail.getText(), Integer.parseInt(telefono.getText()));
					dispose();
					if (aux==1) {
						JOptionPane.showMessageDialog(null, "Cliente Modificado Con Exito", "Modificacion Exitosa", JOptionPane.INFORMATION_MESSAGE);
					}
					else if (aux==2){
						JOptionPane.showMessageDialog(null, "Cliente No Encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException numberFormat) {
					JOptionPane.showMessageDialog(null, "Introducir Caracteres Validos", "ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Nuevo Error Desconocido", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btnOk.setBounds(65, 278, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(268, 278, 89, 23);
		contentPane.add(btnCancelar);
	}

}
