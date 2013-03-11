package vista;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import controler.ConstantesRMA;
import controler.EventSave;
import controler.WindowManager;
import entidades.Producto;

public class AddDevolucion extends VentanaBasica {
	private JTextField ciEmpleado;
	private JTextField ciCliente;
	private JTextField idProducto;
	private JTextField marcaProducto;
	private JTextField nombreProducto;
	private JTextField razonDevolucion;
	private JTextField observaciones;
	private JComboBox estadoProducto;
	private JLabel ciEmpleadoLabel;
	private JLabel ciClienteLabel;
	private JLabel idProductoLabel;
	private JLabel marcaProductoLabel;
	private JLabel nombreProductoLabel;
	private JLabel estadoProductoLabel;
	private JLabel razonDevolucionLabel;
	private JLabel observacionesLabel;
    private JButton save_exit;
    private JButton cancel;
	
    private WindowManager wm;
    private EventSave es;
	private static Logger logger = Logger.getLogger(AddDevolucion.class);
	public AddDevolucion(String ciCli, String ciEmp, Producto prod) {
		super();

		logger.debug("creando la ventana para registrar devolucion");
		setLayout(new FlowLayout());
        setSize(1500, 800);
        setTitle("Registrar Devolucion");
        
        ciEmpleadoLabel = new JLabel("CI Empleado: ");
        ciEmpleado = new JTextField(ciEmp);
        ciEmpleado.setEditable(false);
        ciClienteLabel = new JLabel("CI Cliente: ");
        ciCliente = new JTextField(ciCli);
        ciCliente.setEditable(false);
        idProductoLabel = new JLabel("ID Producto: ");
        idProducto = new JTextField(prod.getIdProducto());
        idProducto.setEditable(false);
        marcaProductoLabel = new JLabel("Marca: ");
        marcaProducto = new JTextField(prod.getMarca());
        marcaProducto.setEditable(false);
        nombreProductoLabel = new JLabel("Nombre Producto: ");
        nombreProducto = new JTextField(prod.getNombre());
        nombreProducto.setEditable(false);
        estadoProductoLabel = new JLabel("Estado");
        razonDevolucionLabel = new JLabel("Razon Devolucion: ");
        razonDevolucion = new JTextField(20);
        observacionesLabel = new JLabel("Observaciones: ");
        observaciones = new JTextField(20);
        
        List<String> estado = new ArrayList<String>();
        estado.add("BUENO");
        estado.add("DEFECTUOSO");
        estado.add("DAÑADO");
        estadoProducto = new JComboBox(Arrays.copyOf(estado.toArray(), estado.size(), String[].class));

        save_exit = new JButton("Guardar y Salir");
        cancel = new JButton("Cancelar");

        add(ciEmpleadoLabel);
        add(ciEmpleado);
        add(ciClienteLabel);
        add(ciCliente);
        add(idProductoLabel);
        add(idProducto);
        add(marcaProductoLabel);
        add(marcaProducto);
        add(nombreProductoLabel);
        add(nombreProducto);
        add(estadoProductoLabel);
        add(estadoProducto);
        add(razonDevolucionLabel);
        add(razonDevolucion);
        add(observacionesLabel);
        add(observaciones);
        
        es = new EventSave(this, ConstantesRMA.ACCION_REGISTRAR_DEVOLUCION);
        
        save_exit.addActionListener(es);
        add(save_exit);

        cancel.addActionListener(es);
        add(cancel);

        setVisible(true);
        wm = new WindowManager();
        addWindowListener(wm);
        logger.debug("ventana para registrar devolucion creada");


	}
	public JTextField getCiEmpleado() {
		return ciEmpleado;
	}
	public void setCiEmpleado(JTextField ciEmpleado) {
		this.ciEmpleado = ciEmpleado;
	}
	public JTextField getCiCliente() {
		return ciCliente;
	}
	public void setCiCliente(JTextField ciCliente) {
		this.ciCliente = ciCliente;
	}
	public JTextField getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(JTextField idProducto) {
		this.idProducto = idProducto;
	}
	public JTextField getMarcaProducto() {
		return marcaProducto;
	}
	public void setMarcaProducto(JTextField marcaProducto) {
		this.marcaProducto = marcaProducto;
	}
	public JTextField getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(JTextField nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public JTextField getRazonDevolucion() {
		return razonDevolucion;
	}
	public void setRazonDevolucion(JTextField razonDevolucion) {
		this.razonDevolucion = razonDevolucion;
	}
	public JTextField getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(JTextField observaciones) {
		this.observaciones = observaciones;
	}
	public JComboBox getEstadoProducto() {
		return estadoProducto;
	}
	public void setEstadoProducto(JComboBox estadoProducto) {
		this.estadoProducto = estadoProducto;
	}

	
	

}
