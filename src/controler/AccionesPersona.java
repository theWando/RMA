package controler;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import vista.AddEmpleado;

import entidades.DocumentoIdentificacion;
import entidades.Empleado;
import entidades.Persona;

public class AccionesPersona {
	private AccionesDireccion ac;
    private DBConnector dbc;
	private ResultSet rs;
	private static Logger logger = Logger.getLogger(AccionesPersona.class);

    
    public Persona crearPersona(Persona pers){
        try {
        	pers.setDocIdent(this.crearDocumentoIdent(pers.getDocIdent()));
			dbc = new DBConnector();
			logger.debug("largo del nombre: "+pers.getNombre().length());
			dbc.dbInsercion(ConstantesRMA.TABLE_PERSONA, "'" + pers.getNombre()+ "', '" + pers.getApellido()+ "', " + pers.getDocIdent().getIdDocIdent(), ConstantesRMA.INSERT_PERSONA);
			pers = this.buscarPersona(pers);
			ac = new AccionesDireccion();
			ac.crearDireccion(pers.getDir(), Integer.valueOf(Long.toString(pers.getIdPersona())));
		} catch (SQLException e) {
			logger.error("Error SQL: "+e);
            e.printStackTrace();
		} catch (ClassNotFoundException e) {
			logger.error("Error : "+e);
            e.printStackTrace();
		}
		return pers;
    }

    public DocumentoIdentificacion crearDocumentoIdent(DocumentoIdentificacion doc){
        try {
			dbc = new DBConnector();
			dbc.dbInsercion(ConstantesRMA.TABLE_DOC, "'" + doc.getTipo()+ "', '" + doc.getValor()+ "'", ConstantesRMA.INSERT_DOC);
			doc = this.buscarDocumentoIdent(doc);
		} catch (SQLException e) {
			logger.error("Error SQL: "+e);
            e.printStackTrace();
		} catch (ClassNotFoundException e) {
			logger.error("Error : "+e);
            e.printStackTrace();
		}
		return doc;
    }

    public DocumentoIdentificacion buscarDocumentoIdent(DocumentoIdentificacion doc){
        try {
			dbc = new DBConnector();
			rs = dbc.dbConsult(ConstantesRMA.TABLE_DOC, "id_doc_ident", "tipo = '"+doc.getTipo()+"' AND valor = "+doc.getValor());
			while(rs.next()){
				doc.setIdDocIdent(rs.getInt("id_doc_ident"));
			}
		} catch (SQLException e) {
			logger.error("Error SQL: "+e);
            e.printStackTrace();
		} catch (ClassNotFoundException e) {
			logger.error("Error : "+e);
            e.printStackTrace();
		}
		return doc;
    }
    
    public Persona buscarPersona(Persona pers){
    	try{
    		dbc = new DBConnector();
    		rs = dbc.dbConsult(ConstantesRMA.TABLE_PERSONA, "id_persona", "id_doc_ident = "+pers.getDocIdent().getIdDocIdent());
    		while(rs.next()){
    			pers.setIdPersona(rs.getInt("id_persona"));
    		}
		} catch (SQLException e) {
			logger.error("Error SQL: "+e);
            e.printStackTrace();
		} catch (ClassNotFoundException e) {
			logger.error("Error : "+e);
            e.printStackTrace();
		}
    	return pers;
    }
    
    public boolean buscarPersonaXCi(DocumentoIdentificacion doc){
    	try{
    		dbc = new DBConnector();
    		rs = dbc.dbConsult(ConstantesRMA.TABLE_PERSONA, "id_persona", "id_doc_ident IN (SELECT id_doc_ident FROM " + ConstantesRMA.TABLE_DOC + " WHERE valor = '" +doc.getValor() + "')");
    		if(rs.next())
    			return true;
		} catch (SQLException e) {
			logger.error("Error SQL: "+e);
            e.printStackTrace();
		} catch (ClassNotFoundException e) {
			logger.error("Error : "+e);
            e.printStackTrace();
		}
		return false;
    }
    
}
