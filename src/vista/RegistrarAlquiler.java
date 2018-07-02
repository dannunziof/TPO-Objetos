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
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class RegistrarAlquiler extends JFrame {

	private JPanel contentPane;
	private Sistema sistema;
	private JTextField dni;
	private JTextField codigo;
	private JTextField cantidadHoras;
	private JTextField cantidadDias;
	private JButton btnRegistrar;
	private JButton btnCancelar;
	
	/**
	 * Create the frame.
	 */
	public RegistrarAlquiler(Sistema siste) {
		setTitle("Registrar Alquiler");
		
		sistema=siste;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 405, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(27, 41, 46, 14);
		contentPane.add(lblDni);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(27, 66, 46, 14);
		contentPane.add(lblCodigo);
		
		dni = new JTextField();
		dni.setBounds(129, 38, 114, 20);
		contentPane.add(dni);
		dni.setColumns(10);
		
		codigo = new JTextField();
		codigo.setBounds(129, 63, 114, 20);
		contentPane.add(codigo);
		codigo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cantidad Horas:");
		lblNewLabel.setBounds(27, 91, 92, 14);
		contentPane.add(lblNewLabel);
		
		cantidadHoras = new JTextField();
		cantidadHoras.setBounds(129, 88, 114, 20);
		contentPane.add(cantidadHoras);
		cantidadHoras.setColumns(10);
		
		JLabel lblCantidadDias = new JLabel("Cantidad Dias:");
		lblCantidadDias.setBounds(27, 116, 92, 14);
		contentPane.add(lblCantidadDias);
		
		cantidadDias = new JTextField();
		cantidadDias.setBounds(129, 113, 114, 20);
		contentPane.add(cantidadDias);
		cantidadDias.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int aux = sistema.registrarAlquiler(Integer.parseInt(dni.getText()), Integer.parseInt(codigo.getText()), Integer.parseInt(cantidadHoras.getText()), Integer.parseInt(cantidadDias.getText()));
					dispose();
					
					if (aux==1) {
						JOptionPane.showMessageDialog(null, "Alquiler Registrado Con Exito", "ERROR", JOptionPane.INFORMATION_MESSAGE);
					}
					else if (aux==2) {
						JOptionPane.showMessageDialog(null, "Producto No Encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else if (aux==3) {
						JOptionPane.showMessageDialog(null, "Cliente No Encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else if (aux==4) {
						JOptionPane.showMessageDialog(null, "Cliente Y Productos No Encontrados", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else if (aux==5) {
						JOptionPane.showMessageDialog(null, "Producto Actualmente Alquilado", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException numberFormat) {
					JOptionPane.showMessageDialog(null, "Introduzca Caracteres Validos", "ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Nuevo Error Desconocido", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnRegistrar.setBounds(55, 215, 89, 23);
		contentPane.add(btnRegistrar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(238, 215, 89, 23);
		contentPane.add(btnCancelar);
	}

}
