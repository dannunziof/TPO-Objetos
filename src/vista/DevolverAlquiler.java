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

public class DevolverAlquiler extends JFrame {

	private JPanel contentPane;
	private Sistema sistema;
	private JTextField dni;
	private JTextField codigo;
	
	/**
	 * Create the frame.
	 */
	public DevolverAlquiler(Sistema siste) {
		setTitle("Devolver Producto");
		
		sistema=siste;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 317, 254);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(39, 42, 46, 14);
		contentPane.add(lblDni);
		
		dni = new JTextField();
		dni.setBounds(95, 39, 86, 20);
		contentPane.add(dni);
		dni.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(39, 67, 46, 14);
		contentPane.add(lblCodigo);
		
		codigo = new JTextField();
		codigo.setBounds(95, 64, 86, 20);
		contentPane.add(codigo);
		codigo.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int aux = sistema.devolverAlquiler(Integer.parseInt(codigo.getText()), Integer.parseInt(dni.getText()));
					dispose();
					
					if (aux==1) {
						JOptionPane.showMessageDialog(null, "Producto Devuelto Con Exito", "Devolucion Exitosa", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(aux==3){
						JOptionPane.showMessageDialog(null, "No Existe En El Registro De Alquileres", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else if(aux==2){
						JOptionPane.showMessageDialog(null, "Producto No Encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else if(aux==4){
						JOptionPane.showMessageDialog(null, "Cliente No Encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else if(aux==5){
						JOptionPane.showMessageDialog(null, "Alquiler Devuelto Previamente", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException numberFormat) {
					JOptionPane.showMessageDialog(null, "Introduzca Caracteres Validos", "ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Nuevo Error Desconocido", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnOk.setBounds(34, 163, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(173, 163, 89, 23);
		contentPane.add(btnCancelar);
	}

}
