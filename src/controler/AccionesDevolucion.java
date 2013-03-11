package controler;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import entidades.Devolucion;

import vista.AddEmpleado;

public class AccionesDevolucion {
    private DBConnector dbc;
    private ResultSet rs;
	private static Logger logger = Logger.getLogger(AddEmpleado.class);

	public Devolucion crearDevolucion(Devolucion dev){
    	try {
			dbc = new DBConnector();
			dbc.dbInsercion(ConstantesRMA.TABLE_DEVOLUCION, dev.getEmpleado().getIdEmpleado() + ", " + dev.getCliente().getIdPersona() + ", " + dev.getProducto().getIdProducto() + ", '" + dev.getRazon() + "', '" + dev.getEstado() + "', '" + dev.getObservaciones() + "'", ConstantesRMA.INSERT_DEVOLUCION);
			dev = this.buscarDevolucion(dev);
			logger.debug("trajo id de devolucion: "+dev.getIdDevolucion());
		} catch (SQLException e) {
			logger.error("Error SQL: "+e);
            e.printStackTrace();
		} catch (ClassNotFoundException e) {
			logger.error("Error : "+e);
            e.printStackTrace();
		}
		return dev;
	}

	private Devolucion buscarDevolucion(Devolucion dev) {
       	try{
    		dbc = new DBConnector();
    		rs = dbc.dbConsult(ConstantesRMA.TABLE_DEVOLUCION, "id_devolucion", "id_empleado = " + dev.getEmpleado().getIdEmpleado() + " AND id_cliente = " + dev.getCliente().getIdPersona() + " AND id_producto = " + dev.getProducto().getIdProducto());
    		while(rs.next()){
    			dev.setIdDevolucion(rs.getInt("id_devolucion"));
    		}
    		logger.debug("devolucion: id "+dev.getIdDevolucion());
		} catch (SQLException e) {
			logger.error("Error SQL: "+e);
            e.printStackTrace();
		} catch (ClassNotFoundException e) {
			logger.error("Error : "+e);
            e.printStackTrace();
		}
		return dev;
	}
}
