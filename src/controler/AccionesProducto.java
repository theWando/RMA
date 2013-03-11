package controler;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import entidades.DocumentoIdentificacion;
import entidades.Producto;

public class AccionesProducto {
    private DBConnector dbc;
    private ResultSet rs;
	private static Logger logger = Logger.getLogger(AccionesProducto.class);


    public void crearProducto(int idProducto, String nombre, String marca, int cantidad, float precio){
        try {
			dbc = new DBConnector();
			logger.debug("parametros de entrada: "+idProducto+", '" + nombre + "', '" + marca + "',"+cantidad+","+precio);
			dbc.dbInsercion(ConstantesRMA.TABLE_PRODUCTO, idProducto+", '" + nombre + "', '" + marca + "',"+cantidad+","+precio, ConstantesRMA.INSERT_PRODUCTO);
		} catch (SQLException e) { logger.debug("asdasdasdasd");
			logger.error("Error SQL: "+e);
            e.printStackTrace();
		} catch (ClassNotFoundException e) {
			logger.error("Error : "+e);
            e.printStackTrace();
		}
    }

    public Producto buscarProducto(int idProducto){
    	Producto producto = new Producto();
       	try{
    		dbc = new DBConnector();
    		rs = dbc.dbConsult(ConstantesRMA.TABLE_PRODUCTO, null, "id_producto = "+ idProducto);
    		while(rs.next()){
    			producto.setMarca(rs.getString("marca"));
    			producto.setNombre(rs.getString("nombre"));
    			producto.setPrecio(rs.getFloat("precio"));
    			producto.setCantidad(rs.getInt("cantidad"));
    			producto.setIdProducto(idProducto);
    			return producto;
    		}
		} catch (SQLException e) {
			logger.error("Error SQL: "+e);
            e.printStackTrace();
		} catch (ClassNotFoundException e) {
			logger.error("Error : "+e);
            e.printStackTrace();
		}
    	return null;
    }

    public Producto buscarProductoxMarcayModelo(Producto producto){
       	try{
    		dbc = new DBConnector();
    		rs = dbc.dbConsult(ConstantesRMA.TABLE_PRODUCTO, "id_producto", "marca = '"+ producto.getMarca() + "' AND nombre = '" + producto.getNombre() + "'");
    		while(rs.next()){
    			producto.setIdProducto(rs.getInt("id_producto"));
    			return producto;
    		}
		} catch (SQLException e) {
			logger.error("Error SQL: "+e);
            e.printStackTrace();
		} catch (ClassNotFoundException e) {
			logger.error("Error : "+e);
            e.printStackTrace();
		}
    	return null;
    }
}
