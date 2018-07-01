package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Sistema;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class EliminarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField dni;
	private Sistema sistema;

	/**
	 * Create the frame.
	 */
	public EliminarCliente(Sistema siste) {
		
		sistema=siste;
		
		setTitle("Eliminar Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 306, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DNI: ");
		lblNewLabel.setBounds(54, 79, 46, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int aux = sistema.eliminarCliente(Integer.parseInt(dni.getText()));
					dispose();
					if (aux==0) {
						JOptionPane.showMessageDialog(null, "Cliente Eliminado Con Exito", "Eliminacion Completada", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(aux==1){
						JOptionPane.showMessageDialog(null, "No Se Encontro El Cliente", "ERROR", JOptionPane.ERROR_MESSAGE);

					}
					else if (aux==2) {
						JOptionPane.showMessageDialog(null, "El Cliente Tiene Un Alquiler Pendiente", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (NumberFormatException numberFormat) {
					JOptionPane.showMessageDialog(null, "Introduzca Caracteres Validos", "ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (NullPointerException numberFormat) {
					JOptionPane.showMessageDialog(null, "No Se Encontro El Cliente", "ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Nuevo Error Desconocido", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBounds(31, 155, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(177, 155, 89, 23);
		contentPane.add(btnCancelar);
		
		dni = new JTextField();
		dni.setBounds(97, 76, 130, 20);
		contentPane.add(dni);
		dni.setColumns(10);
	}

}
