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
import java.time.format.DateTimeParseException;
import java.awt.event.ActionEvent;

public class TotalPorFechas extends JFrame {

	private JPanel contentPane;
	private Sistema sistema;
	private JTextField fechaD;
	private JTextField fechaH;
	private JTextField Total;

	/**
	 * Create the frame.
	 */
	public TotalPorFechas(Sistema siste) {
		setTitle("Recaudacion Por Fechas");
		
		sistema=siste;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFechaDesde = new JLabel("Fecha Desde:");
		lblFechaDesde.setBounds(42, 40, 78, 14);
		contentPane.add(lblFechaDesde);
		
		fechaD = new JTextField();
		fechaD.setBounds(147, 37, 109, 20);
		contentPane.add(fechaD);
		fechaD.setColumns(10);
		
		JLabel lblFechaHasta = new JLabel("Fecha Hasta:");
		lblFechaHasta.setBounds(42, 74, 78, 14);
		contentPane.add(lblFechaHasta);
		
		fechaH = new JTextField();
		fechaH.setBounds(147, 71, 109, 20);
		contentPane.add(fechaH);
		fechaH.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					float total = sistema.montoTotalPorFechas(LocalDate.parse(fechaD.getText()), LocalDate.parse(fechaH.getText()));
					Total.setText(String.valueOf(total));
				} catch (DateTimeParseException fechaException) {
					JOptionPane.showMessageDialog(null, "Introduzca Una Fecha Valida", "ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Nuevo Error Desconocido", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnCalcular.setBounds(44, 177, 89, 23);
		contentPane.add(btnCalcular);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(232, 177, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblTotalRecaudado = new JLabel("Total Recaudado:");
		lblTotalRecaudado.setBounds(42, 123, 109, 14);
		contentPane.add(lblTotalRecaudado);
		
		Total = new JTextField();
		Total.setBounds(147, 120, 109, 20);
		contentPane.add(Total);
		Total.setColumns(10);
		
		JLabel lblaaaammdd = new JLabel("(AAAA-MM-DD)");
		lblaaaammdd.setBounds(275, 74, 110, 14);
		contentPane.add(lblaaaammdd);
		
		JLabel label = new JLabel("(AAAA-MM-DD)");
		label.setBounds(275, 40, 110, 14);
		contentPane.add(label);
	}
}
