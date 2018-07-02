package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.Sistema;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarCarpa extends JFrame {

	private JPanel contentPane;
	private Sistema sistema;
	private JTextField codigo;
	private JTextField descripcion;
	private JTextField valorHoraBase;
	private JTextField valorDiaBase;
	private JTextField seguro;
	private JTextField capacidad;
	private JTextField deposito;

	/**
	 * Create the frame.
	 */
	public RegistrarCarpa(Sistema siste) {
		setTitle("Datos Carpa");
		
		sistema=siste;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(21, 42, 46, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblNewLabel = new JLabel("Descripcion:");
		lblNewLabel.setBounds(21, 79, 98, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblValorHora = new JLabel("Valor Hora:");
		lblValorHora.setBounds(21, 122, 79, 14);
		contentPane.add(lblValorHora);
		
		JLabel lblValorDia = new JLabel("Valor Dia:");
		lblValorDia.setBounds(21, 168, 79, 14);
		contentPane.add(lblValorDia);
		
		codigo = new JTextField();
		codigo.setBounds(129, 39, 86, 20);
		contentPane.add(codigo);
		codigo.setColumns(10);
		
		descripcion = new JTextField();
		descripcion.setBounds(129, 76, 221, 20);
		contentPane.add(descripcion);
		descripcion.setColumns(10);
		
		valorHoraBase = new JTextField();
		valorHoraBase.setBounds(129, 119, 86, 20);
		contentPane.add(valorHoraBase);
		valorHoraBase.setColumns(10);
		
		valorDiaBase = new JTextField();
		valorDiaBase.setBounds(129, 165, 86, 20);
		contentPane.add(valorDiaBase);
		valorDiaBase.setColumns(10);
		
		JLabel lblSeguro = new JLabel("Seguro:");
		lblSeguro.setBounds(21, 204, 62, 14);
		contentPane.add(lblSeguro);
		
		seguro = new JTextField();
		seguro.setBounds(129, 201, 86, 20);
		contentPane.add(seguro);
		seguro.setColumns(10);
		
		JLabel lblCapacidad = new JLabel("Capacidad:");
		lblCapacidad.setBounds(21, 239, 79, 14);
		contentPane.add(lblCapacidad);
		
		capacidad = new JTextField();
		capacidad.setBounds(129, 236, 86, 20);
		contentPane.add(capacidad);
		capacidad.setColumns(10);
		
		JLabel lblDeposito = new JLabel("Deposito:");
		lblDeposito.setBounds(21, 275, 62, 14);
		contentPane.add(lblDeposito);
		
		deposito = new JTextField();
		deposito.setBounds(129, 272, 86, 20);
		contentPane.add(deposito);
		deposito.setColumns(10);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean aux = sistema.registrarCarpa(Integer.parseInt(codigo.getText()), descripcion.getText(), Float.parseFloat(valorHoraBase.getText()), Float.parseFloat(valorDiaBase.getText()), Integer.parseInt(capacidad.getText()), Float.parseFloat(deposito.getText()), Float.parseFloat(seguro.getText()));
					dispose();
					
					if (aux==true) {
						JOptionPane.showMessageDialog(null, "Carpa Creada Con Exito", "Creacion Exitosa", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Carpa Creada Previamente O Codigo Registrado Previamente", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException numberFormat) {
					JOptionPane.showMessageDialog(null, "Introduzca Caracteres Validos", "ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (ClassCastException claseExcepcion) {
					JOptionPane.showMessageDialog(null, "Tipo De Producto Equivocado", "ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Nuevo Error Desconocido", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnCrear.setBounds(36, 326, 89, 23);
		contentPane.add(btnCrear);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean aux=sistema.modificarCarpa(Integer.parseInt(codigo.getText()), descripcion.getText(), Float.parseFloat(valorHoraBase.getText()), Float.parseFloat(valorDiaBase.getText()), Integer.parseInt(capacidad.getText()), Float.parseFloat(deposito.getText()), Float.parseFloat(seguro.getText()));
					dispose();
					
					if (aux==true) {
						JOptionPane.showMessageDialog(null, "Carpa Modificada Con Exito", "Modificacion Exitosa", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Carpa No Encontrada", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException numberFormat) {
					JOptionPane.showMessageDialog(null, "Introduzca Caracteres Validos", "ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Nuevo Error Desconocido", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnModificar.setBounds(171, 326, 89, 23);
		contentPane.add(btnModificar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(304, 326, 89, 23);
		contentPane.add(btnCancelar);
		valorDiaBase.setColumns(10);
	}
}
