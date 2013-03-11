package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JComboBox;

import org.apache.log4j.Logger;

import entidades.Devolucion;
import entidades.Direccion;
import entidades.DocumentoIdentificacion;
import entidades.Empleado;
import entidades.Persona;
import entidades.Producto;

import vista.AddCliente;
import vista.AddDevolucion;
import vista.AddEmpleado;
import vista.AddProducto;
import vista.BuscarPersona;

public class EventSave implements ActionListener {

    private AddProducto ap;
    private AddEmpleado ae;
    private BuscarPersona buscarPers;
    private AddCliente ac;
    private AddDevolucion addDevolucion;
    private AccionesProducto accProd;
    private AccionesEmpleado accEmp;
    private AccionesDireccion accDir;
    private AccionesPersona accPers;
    private AccionesDevolucion accDevol;
    private String accion;
	private static Logger logger = Logger.getLogger(AddEmpleado.class);


    public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public EventSave(AddProducto _ap, String accion){
        ap = _ap;
        this.accion = accion;
    }

    public EventSave(AddEmpleado _ae, String accion) {
		ae = _ae;
		this.accion = accion;
	}

	public EventSave(AccionesDireccion accDir, String accion) {
		super();
		this.accDir = accDir;
		this.accion = accion;
	}

	public EventSave(BuscarPersona buscarPersona, String accionCrearProducto) {
		this.buscarPers = buscarPersona;
		this.accion = accionCrearProducto;
	}

	public EventSave(AddCliente addCliente, String accionCrearCliente) {
		this.ac = addCliente;
		this.accion = accionCrearCliente;
	}

	public EventSave(AddDevolucion addDevolucion,
			String accionRegistrarDevolucion) {
		this.addDevolucion = addDevolucion;
		this.accion = accionRegistrarDevolucion;
	}

	public void actionPerformed(ActionEvent e) {
		if(this.getAccion().matches(ConstantesRMA.ACCION_CREAR_PRODUCTO) && ap != null){
	        if(e.getSource().toString().contains("Guardar") || e.getSource().toString().contains("Guardar y Salir")){
	        	logger.debug("Guardando producto...\ndata: ["+ap.toString()+"]");
	            accProd = new AccionesProducto();
	            accProd.crearProducto(Integer.parseInt(ap.getIdProductoTxt().getText()), ap.getNombreTxt().getText(), ap.getMarcaTxt().getText(), Integer.parseInt(ap.getCantidadTxt().getText()), Float.parseFloat(ap.getPrecioTxt().getText()));
	            if(e.getSource().toString().contains("Guardar y Salir")){
	                ap.cerrarVentana();
	            }else if(e.getSource().toString().contains("Guardar")){
	                ap.reiniciarCampos();
	            }
	        }else{
	        	ap.cerrarVentana();
	        }
		}else if(this.accion.matches(ConstantesRMA.ACCION_CREAR_EMPLEADO) && ae != null){
			 if(e.getSource().toString().contains("Guardar") || e.getSource().toString().contains("Guardar y Salir")){
		            logger.debug("Guardando empleado...\ndata: ["+ae.toString()+"]");
		            accEmp = new AccionesEmpleado();
		            Empleado emp = new Empleado();

		            Persona pers = new Persona();
		            logger.debug("nombre: "+ae.getNombreTxt().getText());
		            pers.setNombre(ae.getNombreTxt().getText());
		            pers.setApellido(ae.getApellidoTxt().getText());

			    	accDir = new AccionesDireccion();

		            Direccion dir = new Direccion();
		            dir.setIdCiudad(accDir.buscarIdCiudadXNombre(ae.getListaCiudades().getSelectedItem().toString()));
		            dir.setCodPaid(accDir.buscarCodigoPaisXNombre(ae.getListaPaises().getSelectedItem().toString()));
		            dir.setZona(ae.getZonaTxt().getText());
		            dir.setLinea1(ae.getLinea1Txt().getText());
		            dir.setLinea2(ae.getLinea2Txt().getText());
		            pers.setDir(dir);

		            DocumentoIdentificacion docId = new DocumentoIdentificacion();
		            docId.setTipo("CI");
		            docId.setValor(ae.getCiTxt().getText());
		            pers.setDocIdent(docId);

		            emp.setPuesto(ae.getPuestoTxt().getText());
		            emp.setPersona(pers);
		            emp.setNivelAcceso(0);
		            accEmp.crearEmpleado(emp);
		            if(e.getSource().toString().contains("Guardar y Salir")){
		            	ae.cerrarVentana();
		            }else if(e.getSource().toString().contains("Guardar")){
		            	ae.reiniciarCampos();
		            }
		      }else{
		    	  ae.cerrarVentana();
		      }
		}else if(this.accion.matches(ConstantesRMA.ACCION_REGISTRAR_DEVOLUCION) && buscarPers != null){
			logger.debug("entro!");
			 if(e.getSource().toString().contains("Buscar")){
				DocumentoIdentificacion docId = new DocumentoIdentificacion();
				docId.setTipo("CI");
				docId.setValor(buscarPers.getCiTxt().getText());
				logger.debug("ci cliente: "+buscarPers.getCiTxt().getText());

				DocumentoIdentificacion docIdEmpleado = new DocumentoIdentificacion();
				docIdEmpleado.setTipo("CI");
				docIdEmpleado.setValor(buscarPers.getCiEmpleado().getText());
				logger.debug("ci empleado: "+buscarPers.getCiEmpleado().getText());

				int idProducto = Integer.parseInt(buscarPers.getIdProducto().getText());
				logger.debug("id producto: "+buscarPers.getIdProducto().getText());

				accPers = new AccionesPersona();
				accEmp = new AccionesEmpleado();
				accProd = new AccionesProducto();
				Producto producto = accProd.buscarProducto(idProducto);
				buscarPers.cerrarVentana();
				if(accPers.buscarPersonaXCi(docId) && accEmp.validarEmpleado(docIdEmpleado) && producto != null){
					buscarPers.cerrarVentana();
					AddDevolucion dev = new AddDevolucion(buscarPers.getCiTxt().getText(), buscarPers.getCiEmpleado().getText(), producto);
				}else{
					logger.info("no se encontro la persona, empleado o producto");
				}
			} else {
				buscarPers.cerrarVentana();
		      }
		}else if(this.accion.matches(ConstantesRMA.ACCION_CREAR_CLIENTE) && ac != null){
			 if(e.getSource().toString().contains("Guardar") || e.getSource().toString().contains("Guardar y Salir")){
		            logger.info("Crenado cliente");
		            accPers = new AccionesPersona();

		            Persona pers = new Persona();
		            logger.debug("nombre: "+ac.getNombreTxt().getText());
		            pers.setNombre(ac.getNombreTxt().getText());
		            pers.setApellido(ac.getApellidoTxt().getText());

			    	accDir = new AccionesDireccion();

		            Direccion dir = new Direccion();
		            dir.setIdCiudad(accDir.buscarIdCiudadXNombre(ac.getListaCiudades().getSelectedItem().toString()));
		            dir.setCodPaid(accDir.buscarCodigoPaisXNombre(ac.getListaPaises().getSelectedItem().toString()));
		            dir.setZona(ac.getZonaTxt().getText());
		            dir.setLinea1(ac.getLinea1Txt().getText());
		            dir.setLinea2(ac.getLinea2Txt().getText());
		            pers.setDir(dir);

		            DocumentoIdentificacion docId = new DocumentoIdentificacion();
		            docId.setTipo("CI");
		            docId.setValor(ac.getCiTxt().getText());
		            pers.setDocIdent(docId);

		            accPers.crearPersona(pers);
		            logger.debug("persona creada");
		            if(e.getSource().toString().contains("Guardar y Salir")){
		            	ac.cerrarVentana();
		            }else if(e.getSource().toString().contains("Guardar")){
		            	ac.reiniciarCampos();
		            }
		      }else{
		    	  ac.cerrarVentana();
		      }
		}else if(this.accion.matches(ConstantesRMA.ACCION_REGISTRAR_DEVOLUCION) && addDevolucion != null){
			 if(e.getSource().toString().contains("Guardar") || e.getSource().toString().contains("Guardar y Salir")){
		            logger.info("Creando devolucion");
		            
		            accDevol = new AccionesDevolucion();
		            accPers = new AccionesPersona();
		            accEmp = new AccionesEmpleado();
		            accProd = new AccionesProducto();
		            
		            logger.debug("llenando el objeto Devolucion");
		            Devolucion dev = new Devolucion();
					DocumentoIdentificacion docId = new DocumentoIdentificacion();
					docId.setTipo("CI");
					docId.setValor(addDevolucion.getCiCliente().getText());
					logger.debug("ci cliente: "+addDevolucion.getCiCliente().getText());
					docId = accPers.buscarDocumentoIdent(docId);
					Persona cliente = new Persona();
					cliente.setDocIdent(docId);
					cliente = accPers.buscarPersona(cliente);

					DocumentoIdentificacion docIdEmpleado = new DocumentoIdentificacion();
					docIdEmpleado.setTipo("CI");
					docIdEmpleado.setValor(addDevolucion.getCiEmpleado().getText());
					logger.debug("ci empleado: "+addDevolucion.getCiEmpleado().getText());
					docIdEmpleado = accPers.buscarDocumentoIdent(docIdEmpleado);
					Persona emp1 = new Persona();
					emp1.setDocIdent(docIdEmpleado);
					emp1 = accPers.buscarPersona(emp1);
					Empleado emp = new Empleado();
					emp.setPersona(emp1);
					emp = accEmp.buscarEmpleado(emp);
					
					Producto prod = new Producto();
					prod.setMarca(addDevolucion.getMarcaProducto().getText());
					prod.setNombre(addDevolucion.getNombreProducto().getText());
					prod = accProd.buscarProductoxMarcayModelo(prod);
					
					dev.setCliente(cliente);
					dev.setEmpleado(emp);
					dev.setProducto(prod);
					dev.setObservaciones(addDevolucion.getObservaciones().getText());
					dev.setEstado(addDevolucion.getEstadoProducto().getSelectedItem().toString());
					dev.setRazon(addDevolucion.getRazonDevolucion().getText());

					dev = accDevol.crearDevolucion(dev);
		
					if(e.getSource().toString().contains("Guardar y Salir")){
						addDevolucion.cerrarVentana();
		            }
		      }else{
		    	  addDevolucion.cerrarVentana();
		      }

		}
    }
}
