package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import vista.AddEmpleado;
import vista.AddProducto;
import vista.AddCliente;
import vista.BuscarPersona;

public class MainEvents implements ActionListener {

	private WindowManager wm;
	private static Logger logger = Logger.getLogger(MainEvents.class);

    @Override
	public void actionPerformed(ActionEvent e) {
		wm = new WindowManager();
			if (e.getSource().toString().contains(ConstantesRMA.BTT_ADD_PRODUCTO)) {
				logger.debug("Agregar producto....");
				AddProducto addProducto = new AddProducto();
				addProducto.addWindowListener(wm);
			}else if (e.getSource().toString().contains(ConstantesRMA.BTT_ADD_EMPLEADO)) {
				logger.debug("Agregar empleado....");
				AddEmpleado addEmpleado = new AddEmpleado();
				addEmpleado.addWindowListener(wm);
			}else if (e.getSource().toString().contains(ConstantesRMA.BTT_ADD_DEVOLUCION)) {
				logger.debug("Realizar devolucion....");
				BuscarPersona bp = new BuscarPersona();
				bp.addWindowListener(wm);
			}else if (e.getSource().toString().contains(ConstantesRMA.BTT_CREAR_CLIENTE)) {
				logger.debug("Crear cliente....");
				AddCliente ac = new AddCliente();
				ac.addWindowListener(wm);
			}
	}

}
