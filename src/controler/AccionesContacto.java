package controler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import entidades.Contacto;
import entidades.Empleado;

public class AccionesContacto {
    private DBConnector dbc;
    private ResultSet rs;

    public Contacto crearContacto(Contacto con){
    	try {
			dbc = new DBConnector();
			dbc.dbInsercion(ConstantesRMA.TABLE_CONTACTO, "'"+con.getTipoContacto()+"'"+con.getIdContacto()+"'"+con.getValor()+"'", ConstantesRMA.INSERT_CONTACTO);
			con = this.buscarContacto(con);
		} catch (SQLException e) {
            Logger.getLogger(AccionesProducto.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
		} catch (ClassNotFoundException e) {
            Logger.getLogger(AccionesProducto.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
		}
		System.out.println("Creado contacto, id: "+con.getIdContacto());
    	return con;
    }
    
    public Contacto buscarContacto(Contacto con){
       	try{
    		dbc = new DBConnector();
    		rs = dbc.dbConsult(ConstantesRMA.TABLE_CONTACTO, "id_contacto", "id_persona = "+con.getIdPersona());
    		while(rs.next()){
    			con.setIdContacto(rs.getInt("id_contacto"));
    		}
		} catch (SQLException e) {
            Logger.getLogger(AccionesProducto.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
		} catch (ClassNotFoundException e) {
            Logger.getLogger(AccionesProducto.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
		}
    	return con;
    }

}
