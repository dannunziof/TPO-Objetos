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

public class RegistrarBici extends JFrame {

	private JPanel contentPane;
	private Sistema sistema;
	private JTextField codigo;
	private JTextField descripcion;
	private JTextField valorHoraBase;
	private JTextField valorDiaBase;
	private JTextField seguro;

	/**
	 * Create the frame.
	 */
	public RegistrarBici(Sistema siste) {
		setTitle("Datos Bicicleta");
		
		sistema=siste;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(21, 42, 46, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblNewLabel = new JLabel("Descripcion:");
		lblNewLabel.setBounds(21, 79, 79, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblValorHora = new JLabel("Valor Hora:");
		lblValorHora.setBounds(21, 122, 79, 14);
		contentPane.add(lblValorHora);
		
		JLabel lblValorDia = new JLabel("Valor Dia:");
		lblValorDia.setBounds(21, 168, 58, 14);
		contentPane.add(lblValorDia);
		
		codigo = new JTextField();
		codigo.setBounds(132, 39, 86, 20);
		contentPane.add(codigo);
		codigo.setColumns(10);
		
		descripcion = new JTextField();
		descripcion.setBounds(132, 76, 221, 20);
		contentPane.add(descripcion);
		descripcion.setColumns(10);
		
		valorHoraBase = new JTextField();
		valorHoraBase.setBounds(132, 119, 86, 20);
		contentPane.add(valorHoraBase);
		valorHoraBase.setColumns(10);
		
		valorDiaBase = new JTextField();
		valorDiaBase.setBounds(132, 165, 86, 20);
		contentPane.add(valorDiaBase);
		valorDiaBase.setColumns(10);
		
		JButton btnOk = new JButton("Crear");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean aux = sistema.registrarBicicleta(Integer.parseInt(codigo.getText()), descripcion.getText(),Float.parseFloat(valorHoraBase.getText()),Float.parseFloat(valorDiaBase.getText()), Float.parseFloat(seguro.getText()));
					dispose();
					
					if (aux==true) {
						JOptionPane.showMessageDialog(null, "Bicicleta Creada Con Exito", "Creacion Exitosa", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Bicicleta Creada Previamente O Codigo Registrado Previamente", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Introduzca Caracteres Validos", "ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (ClassCastException claseExcepcion) {
					JOptionPane.showMessageDialog(null, "Tipo De Producto Equivocado", "ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Nuevo Error Desconocido", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnOk.setBounds(35, 251, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(297, 251, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblSeguro = new JLabel("Seguro:");
		lblSeguro.setBounds(21, 208, 46, 14);
		contentPane.add(lblSeguro);
		
		seguro = new JTextField();
		seguro.setBounds(132, 205, 86, 20);
		contentPane.add(seguro);
		seguro.setColumns(10);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean aux = sistema.modificarBicicleta(Integer.parseInt(codigo.getText()), descripcion.getText(), Integer.parseInt(valorHoraBase.getText()), Integer.parseInt(valorDiaBase.getText()), Integer.parseInt(seguro.getText()));	
					dispose();
					
					if (aux==true) {
						JOptionPane.showMessageDialog(null, "Bicicleta Modificada Con Exito", "Modificacion Concluida", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Bicicleta No Encontrada", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException numberFormat) {
					JOptionPane.showMessageDialog(null, "Introducir Caracteres Validos", "ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Nuevo Error Desconocido", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnModificar.setBounds(170, 251, 89, 23);
		contentPane.add(btnModificar);
	}
}
