package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Sistema;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EliminarProducto extends JFrame {

	private JPanel contentPane;
	private Sistema sistema;
	private JTextField codigo;

	/**
	 * Create the frame.
	 */
	public EliminarProducto(Sistema siste) {
		setTitle("Eliminar Producto");
		
		sistema=siste;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 288, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnOk = new JButton("Eliminar");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int aux = sistema.eliminarProducto(Integer.parseInt(codigo.getText()));
					dispose();
					
					if (aux==1) {
						JOptionPane.showMessageDialog(null, "Producto Eliminado Con Exito", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
					}
					else if (aux==2) {
						JOptionPane.showMessageDialog(null, "Producto No Encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else if (aux==3) {
						JOptionPane.showMessageDialog(null, "El Producto Tiene Un Alquiler Pendiente", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException numberFormat) {
					JOptionPane.showMessageDialog(null, "Introduzca Caracteres Validos", "ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Nuevo Error Desconocido", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnOk.setBounds(23, 153, 89, 23);
		contentPane.add(btnOk);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(54, 79, 46, 14);
		contentPane.add(lblCodigo);
		
		codigo = new JTextField();
		codigo.setBounds(110, 76, 107, 20);
		contentPane.add(codigo);
		codigo.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(162, 153, 89, 23);
		contentPane.add(btnCancelar);
	}

}
