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

public class RegistrarCuatriciclo extends JFrame {

	private JPanel contentPane;
	private Sistema sistema;
	private JTextField codigo;
	private JTextField descripcion;
	private JTextField valorHoraBase;
	private JTextField valorDiaBase;
	private JTextField patente;
	private JTextField seguro;

	/**
	 * Create the frame.
	 */
	public RegistrarCuatriciclo(Sistema siste) {
		setTitle("Datos Cuatriciclo");
		
		sistema = siste;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(27, 38, 46, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(27, 63, 78, 14);
		contentPane.add(lblDescripcion);
		
		codigo = new JTextField();
		codigo.setBounds(112, 35, 86, 20);
		contentPane.add(codigo);
		codigo.setColumns(10);
		
		descripcion = new JTextField();
		descripcion.setBounds(112, 60, 197, 20);
		contentPane.add(descripcion);
		descripcion.setColumns(10);
		
		JLabel lblValorHora = new JLabel("Valor Hora:");
		lblValorHora.setBounds(27, 88, 66, 14);
		contentPane.add(lblValorHora);
		
		valorHoraBase = new JTextField();
		valorHoraBase.setBounds(112, 85, 86, 20);
		contentPane.add(valorHoraBase);
		valorHoraBase.setColumns(10);
		
		JLabel lblValorDia = new JLabel("Valor Dia:");
		lblValorDia.setBounds(27, 113, 66, 14);
		contentPane.add(lblValorDia);
		
		valorDiaBase = new JTextField();
		valorDiaBase.setBounds(112, 110, 86, 20);
		contentPane.add(valorDiaBase);
		valorDiaBase.setColumns(10);
		
		JLabel lblPatente = new JLabel("Patente:");
		lblPatente.setBounds(27, 138, 66, 14);
		contentPane.add(lblPatente);
		
		patente = new JTextField();
		patente.setBounds(112, 135, 86, 20);
		contentPane.add(patente);
		patente.setColumns(10);
		
		JLabel lblSeguro = new JLabel("Seguro:");
		lblSeguro.setBounds(27, 163, 66, 14);
		contentPane.add(lblSeguro);
		
		seguro = new JTextField();
		seguro.setBounds(112, 160, 86, 20);
		contentPane.add(seguro);
		seguro.setColumns(10);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {try {
				boolean aux = sistema.registrarCuatriciclo(Integer.parseInt(codigo.getText()), descripcion.getText(), Float.parseFloat(valorHoraBase.getText()), Float.parseFloat(valorDiaBase.getText()), patente.getText(), Float.parseFloat(seguro.getText()));
				dispose();
				
				if (aux==true) {
					JOptionPane.showMessageDialog(null, "Cuatriciclo Creado con Exito", "Creacion Exitosa", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Cuatriciclo Creado Previamente O Codigo Registrado Previamente", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException numberFormat) {
				JOptionPane.showMessageDialog(null, "Introduzca Caracteres Validos", "ERROR", JOptionPane.ERROR_MESSAGE);
			}  catch (Exception e2) {
				e2.printStackTrace();
				JOptionPane.showMessageDialog(null, "Nuevo Error Desconocido", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			
			}
		});
		btnCrear.setBounds(36, 227, 89, 23);
		contentPane.add(btnCrear);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean aux=sistema.modificarCuatriciclo(Integer.parseInt(codigo.getText()), descripcion.getText(), Float.parseFloat(valorHoraBase.getText()), Float.parseFloat(valorDiaBase.getText()), patente.getText(), Float.parseFloat(seguro.getText()));
					dispose();
					
					if (aux==true) {
						JOptionPane.showMessageDialog(null, "Cuatriciclo Modificado Con Exito", "Modificacion Exitosa", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Cuatriciclo No Encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
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
		btnModificar.setBounds(186, 227, 89, 23);
		contentPane.add(btnModificar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(322, 227, 89, 23);
		contentPane.add(btnCancelar);
	}

}
