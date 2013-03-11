package controler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import vista.AddEmpleado;

import entidades.Direccion;

public class AccionesDireccion {
    private DBConnector dbc;
    private ResultSet rs;
	private static Logger logger = Logger.getLogger(AddEmpleado.class);


    public Direccion crearDireccion(Direccion dir, int idPersona){
    	try {
			dbc = new DBConnector();
			dbc.dbInsercion(ConstantesRMA.TABLE_DIRECCION, dir.getIdCiudad()+",'"+dir.getCodPaid()+"','"+dir.getZona()+"','"+dir.getLinea1()+"','"+dir.getLinea2()+"'", ConstantesRMA.INSERT_DIRECCION);
			dir = this.buscarDireccion(dir);
			logger.debug("trajo id de direccion: "+dir.getIdDireccion());
			 dbc.dbInsercion(ConstantesRMA.TABLE_DIRECCION_PERSONA, dir.getIdDireccion() + ", " + idPersona, null);


		} catch (SQLException e) {
			logger.error("Error SQL: "+e);
            e.printStackTrace();
		} catch (ClassNotFoundException e) {
			logger.error("Error : "+e);
            e.printStackTrace();
		}
    	return dir;
    }
    
    public Direccion buscarDireccion(Direccion dir){
       	try{
    		dbc = new DBConnector();
    		rs = dbc.dbConsult(ConstantesRMA.TABLE_DIRECCION, "id_direccion", "id_ciudad = " + dir.getIdCiudad() + " AND cod_pais = '" + dir.getCodPaid() + "' AND zona = '" + dir.getZona() + "' AND linea1 = '" + dir.getLinea1() + "' AND linea2 = '" + dir.getLinea2() + "'");
    		while(rs.next()){
    			dir.setIdDireccion(rs.getLong("id_direccion"));
    		}
    		logger.debug("direccion creada: id "+dir.getIdDireccion());
		} catch (SQLException e) {
			logger.error("Error SQL: "+e);
            e.printStackTrace();
		} catch (ClassNotFoundException e) {
			logger.error("Error : "+e);
            e.printStackTrace();
		}
    	return dir;
    }
    
    public String[] listarPaises(){
    	logger.debug("buscando lista de paises");
    	List<String> paises = new ArrayList<String>();
    	try{
    		dbc = new DBConnector();
    		rs = dbc.dbConsult(ConstantesRMA.TABLE_COUNTRY, "Name", "Code <> '' ORDER BY Name");
    		while(rs.next()){
    			paises.add(rs.getString("Name"));
    		}
    		logger.debug("lista es de "+paises.size()+" paises");
    	} catch (SQLException e) {
			logger.error("Error SQL: CODE='"+e.getErrorCode()+"' REASON='"+e.getMessage()+"'");
            e.printStackTrace();
		} catch (ClassNotFoundException e) {
			logger.error("Error : "+e);
            e.printStackTrace();
		}
		String[] arrayResponse = Arrays.copyOf(paises.toArray(), paises.size(), String[].class);

    	return arrayResponse;
    }

    public String[] listarCiudades(){
    	logger.info("buscando ciudades");
    	List<String> ciudades = new ArrayList<String>();
    	try{
    		dbc = new DBConnector();
    		rs = dbc.dbConsult(ConstantesRMA.TABLE_CITY, "Name", "ID <> '' ORDER BY Name");
    		while(rs.next()){
    			ciudades.add(rs.getString("Name"));
    		}
    		logger.debug("lista es de "+ciudades.size()+" ciudades");
    	} catch (SQLException e) {
			logger.error("Error SQL: "+e);
            e.printStackTrace();
		} catch (ClassNotFoundException e) {
			logger.error("Error : "+e);
            e.printStackTrace();
		}
		String[] arrayResponse = Arrays.copyOf(ciudades.toArray(), ciudades.size(), String[].class);

    	return arrayResponse;
    }

    public String[] listarCiudadesxCode(String nombrePais){
    	List<String> ciudades = new ArrayList<String>();
    	try{
    		dbc = new DBConnector();
    		rs = dbc.dbConsult(ConstantesRMA.TABLE_CITY, "Name", "CountryCode IN (SELECT Code FROM "+ConstantesRMA.TABLE_COUNTRY+" WHERE Name = '" + nombrePais + "') ORDER BY Name");
    		while(rs.next()){
    			ciudades.add(rs.getString("Name"));
    		}
    		logger.debug("lista es de "+ciudades.size()+" Ciudades");
    	} catch (SQLException e) {
			logger.error("Error SQL: "+e);
            e.printStackTrace();
		} catch (ClassNotFoundException e) {
			logger.error("Error : "+e);
            e.printStackTrace();
		}
		String[] arrayResponse = Arrays.copyOf(ciudades.toArray(), ciudades.size(), String[].class);

    	return arrayResponse;
    }
    
    public String buscarCodigoPaisXNombre(String nombrePais){
    	String codigo = new String();
    	try{
    		dbc = new DBConnector();
    		rs = dbc.dbConsult(ConstantesRMA.TABLE_COUNTRY, "Code", "Name = '" + nombrePais + "'");
    		while(rs.next()){
    			codigo = rs.getString("Code");
    		}
    	} catch (SQLException e) {
			logger.error("Error SQL: "+e);
            e.printStackTrace();
		} catch (ClassNotFoundException e) {
			logger.error("Error : "+e);
            e.printStackTrace();
		}
		return codigo;
    }
    
    public int buscarIdCiudadXNombre(String nombreCiudad){
    	int idCiudad = -1;
    	try{
    		dbc = new DBConnector();
    		rs = dbc.dbConsult(ConstantesRMA.TABLE_CITY, "ID", "Name = '" + nombreCiudad + "'");
    		while(rs.next()){
    			idCiudad = rs.getInt("ID");
    		}
    	} catch (SQLException e) {
			logger.error("Error SQL: "+e);
            e.printStackTrace();
		} catch (ClassNotFoundException e) {
			logger.error("Error : "+e);
            e.printStackTrace();
		}
    	
    	return idCiudad;
    }
}
