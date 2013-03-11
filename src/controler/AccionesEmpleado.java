package controler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import entidades.DocumentoIdentificacion;
import entidades.Empleado;

public class AccionesEmpleado {
    private DBConnector dbc;
    private AccionesPersona ap;
    private AccionesDireccion ad;
    private ResultSet rs;
    
    public void crearEmpleado(Empleado emp){
        try {
        	ap = new AccionesPersona();
        	emp.setPersona(ap.crearPersona(emp.getPersona()));
        	Date fechaInicio = new Date();
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
			dbc = new DBConnector();
			dbc.dbInsercion(ConstantesRMA.TABLE_EMPLEADO, "'" + emp.getPuesto() + "', '" + sdf.format(fechaInicio) + "',"+emp.getNivelAcceso() +", " + emp.getPersona().getIdPersona(), ConstantesRMA.INSERT_EMPLEADO);
			emp = this.buscarEmpleado(emp);
		} catch (SQLException e) {
            Logger.getLogger(AccionesProducto.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
		} catch (ClassNotFoundException e) {
            Logger.getLogger(AccionesProducto.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
		}
        System.out.println("IdEmpleado: "+emp.getIdEmpleado());
    }
    
    public Empleado buscarEmpleado(Empleado emp){
       	try{
    		dbc = new DBConnector();
    		rs = dbc.dbConsult(ConstantesRMA.TABLE_EMPLEADO, "id_empleado", "id_persona = "+emp.getPersona().getIdPersona());
    		while(rs.next()){
    			emp.setIdEmpleado(rs.getInt("id_empleado"));
    		}
		} catch (SQLException e) {
            Logger.getLogger(AccionesProducto.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
		} catch (ClassNotFoundException e) {
            Logger.getLogger(AccionesProducto.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
		}
    	return emp;
    }

    public boolean validarEmpleado(DocumentoIdentificacion doc){
       	try{
       		dbc = new DBConnector();
    		rs = dbc.dbConsult(ConstantesRMA.TABLE_PERSONA, "id_persona", "id_doc_ident IN (SELECT id_doc_ident FROM " + ConstantesRMA.TABLE_DOC + " WHERE valor = '" +doc.getValor() + "')");
    		if(rs.next()){
    			int idPersona = rs.getInt("id_persona");
    			rs = dbc.dbConsult(ConstantesRMA.TABLE_EMPLEADO, "id_empleado", "id_persona = " + idPersona);
    			if(rs.next())
    				return true;
    		}
		} catch (SQLException e) {
            Logger.getLogger(AccionesProducto.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
		} catch (ClassNotFoundException e) {
            Logger.getLogger(AccionesProducto.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
		}
    	return false;
    }

}
