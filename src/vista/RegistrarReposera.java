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

public class RegistrarReposera extends JFrame {

	private JPanel contentPane;
	private Sistema sistema;
	private JTextField codigo;
	private JTextField descripcion;
	private JTextField valorHoraBase;
	private JTextField valorDiaBase;
	private JTextField deposito;
	
	/**
	 * Create the frame.
	 */
	public RegistrarReposera(Sistema siste) {
		setTitle("Datos Reposera");
		
		sistema=siste;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(28, 32, 46, 14);
		contentPane.add(lblCodigo);
		
		codigo = new JTextField();
		codigo.setBounds(106, 29, 86, 20);
		contentPane.add(codigo);
		codigo.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(28, 58, 75, 14);
		contentPane.add(lblDescripcion);
		
		descripcion = new JTextField();
		descripcion.setBounds(106, 55, 192, 20);
		contentPane.add(descripcion);
		descripcion.setColumns(10);
		
		JLabel lblValorHora = new JLabel("Valor Hora:");
		lblValorHora.setBounds(28, 83, 68, 14);
		contentPane.add(lblValorHora);
		
		valorHoraBase = new JTextField();
		valorHoraBase.setBounds(106, 80, 86, 20);
		contentPane.add(valorHoraBase);
		valorHoraBase.setColumns(10);
		
		JLabel lblValorDia = new JLabel("Valor Dia:");
		lblValorDia.setBounds(28, 108, 68, 14);
		contentPane.add(lblValorDia);
		
		valorDiaBase = new JTextField();
		valorDiaBase.setBounds(106, 105, 86, 20);
		contentPane.add(valorDiaBase);
		valorDiaBase.setColumns(10);
		
		JLabel lblDeposito = new JLabel("Deposito:");
		lblDeposito.setBounds(28, 133, 68, 14);
		contentPane.add(lblDeposito);
		
		deposito = new JTextField();
		deposito.setBounds(106, 130, 86, 20);
		contentPane.add(deposito);
		deposito.setColumns(10);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean aux = sistema.registrarReposera(Integer.parseInt(codigo.getText()), descripcion.getText(), Float.parseFloat(valorHoraBase.getText()), Float.parseFloat(valorDiaBase.getText()), Float.parseFloat(deposito.getText()));
					dispose();
					
					if (aux==true) {
						JOptionPane.showMessageDialog(null, "Reposera Creada Con Exito", "Creacion Exitosa", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Reposera No Encontrada", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException numberFormat) {
					JOptionPane.showMessageDialog(null, "Introduzca Caracteres Validos", "ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Nuevo Error Desconocido", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnCrear.setBounds(39, 215, 89, 23);
		contentPane.add(btnCrear);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean aux = sistema.modificarReposera(Integer.parseInt(codigo.getText()), descripcion.getText(), Float.parseFloat(valorHoraBase.getText()), Float.parseFloat(valorDiaBase.getText()), Float.parseFloat(deposito.getText()));
					dispose();
					
					if (aux==true) {
						JOptionPane.showMessageDialog(null, "Reposera Modificada Con Exito", "Modificacion Exitosa", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Reposera Creada Previamente O Codigo Registrado Previamente", "ERROR", JOptionPane.ERROR_MESSAGE);
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
		btnModificar.setBounds(175, 215, 89, 23);
		contentPane.add(btnModificar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(308, 215, 89, 23);
		contentPane.add(btnCancelar);
	}

}
