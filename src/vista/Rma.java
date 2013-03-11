package vista;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controler.ConstantesRMA;
import controler.MainEvents;

public class Rma extends JFrame{

    private Toolkit toolkit;
    private MainEvents me;

	public Rma() {
		setSize(550, 200);
		setTitle("RMA");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width / 2 - getWidth() / 2, size.height / 2
				- getHeight() / 2);

		JPanel panel = new JPanel();
		getContentPane().add(panel);

		panel.setLayout(null);

		me = new MainEvents();

		int bttWidth = 200;
		int bttHeight = 30;
		JButton addProducto = new JButton(ConstantesRMA.BTT_ADD_PRODUCTO);
		addProducto.setBounds(50, 25, bttWidth, bttHeight);
		addProducto.addActionListener(me);
		panel.add(addProducto);

		JButton addEmpleado = new JButton(ConstantesRMA.BTT_ADD_EMPLEADO);
		addEmpleado.setBounds(300, 25, bttWidth, bttHeight);
		addEmpleado.addActionListener(me);
		panel.add(addEmpleado);

		JButton addCliente = new JButton(ConstantesRMA.BTT_CREAR_CLIENTE);
		addCliente.setBounds(50, 75, bttWidth, bttHeight);
		addCliente.addActionListener(me);
		panel.add(addCliente);

		JButton devolucion = new JButton(ConstantesRMA.BTT_ADD_DEVOLUCION);
		devolucion.setBounds(300, 75, bttWidth, bttHeight);
		devolucion.addActionListener(me);
		panel.add(devolucion);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Rma rma = new Rma();
		rma.setVisible(true);
	}

}

