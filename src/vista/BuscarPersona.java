package vista;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import controler.ConstantesRMA;
import controler.EventSave;
import controler.WindowManager;

public class BuscarPersona extends VentanaBasica {
	private JLabel ciL;
	private JLabel ciEmpleadoLabel;
	private JLabel idProductoLabel;
	private JTextField ciTxt;
	private JTextField ciEmpleado;
	private JTextField idProducto;
	private JButton buscarBtt;
    private WindowManager wm;
    private EventSave es;
	private static Logger logger = Logger.getLogger(AddEmpleado.class);
    
	public BuscarPersona() {
		super();
		
		logger.debug("creando la ventana para buscar persona");
		setLayout(new FlowLayout());
        setSize(400, 100);
        setTitle("Buscar Cliente");

		ciL = new JLabel("CI Cliente: ");
		ciTxt = new JTextField(15);
		ciEmpleadoLabel = new JLabel("CI Empleado: ");
		ciEmpleado = new JTextField(15);
		idProductoLabel = new JLabel("ID Producto: ");
		idProducto = new JTextField(15);
		buscarBtt = new JButton("Buscar");
		es = new EventSave(this, ConstantesRMA.ACCION_REGISTRAR_DEVOLUCION);
		buscarBtt.addActionListener(es);
		
		add(ciL);
		add(ciTxt);
		add(ciEmpleadoLabel);
		add(ciEmpleado);
		add(idProductoLabel);
		add(idProducto);
		add(buscarBtt);
		
        setVisible(true);
        wm = new WindowManager();
        addWindowListener(wm);
        logger.debug("ventana para buscar persona creada");
	}
	
	@Override
	public void reiniciarCampos() {
		this.getCiTxt().setText("");
		this.getCiEmpleado().setText("");
		this.getIdProducto().setText("");
	}

	
	public JTextField getCiTxt() {
		return ciTxt;
	}
	
	public void setCiTxt(JTextField ciTxt) {
		this.ciTxt = ciTxt;
	}

	public JTextField getCiEmpleado() {
		return ciEmpleado;
	}

	public void setCiEmpleado(JTextField ciEmpleado) {
		this.ciEmpleado = ciEmpleado;
	}

	public JTextField getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(JTextField idProducto) {
		this.idProducto = idProducto;
	}
	
	
	

}
