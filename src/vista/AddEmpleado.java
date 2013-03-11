package vista;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import controler.AccionesDireccion;
import controler.ConstantesRMA;
import controler.EventSave;
import controler.MainEvents;
import controler.WindowManager;

public class AddEmpleado extends VentanaBasica {

	private JTextField ciTxt;
	private JTextField nombreTxt;
	private JTextField apellidoTxt;
	private JTextField tipoDocTxt;
	private JTextField valDocTxt;
	private JTextField tlfTxt;
	//	private JTextField direccionTxt;
	private JTextField puestoTxt;
	private JTextField zonaTxt;
	private JTextField linea1Txt;
	private JTextField linea2Txt;
	private JComboBox listaPaises;
	private JComboBox listaCiudades;
	private JLabel ciL;
	private JLabel nombreL;
	private JLabel apellidoL;
	private JLabel tipoDocL;
	private JLabel valDocL;
	private JLabel tlfL;
	private JLabel puestoL;
	private JLabel paises;
	private JLabel ciudades;
	private JLabel zonaL;
	private JLabel linea1L;
	private JLabel linea2L;
    private JButton save;
    private JButton save_exit;
    private JButton cancel;
    private WindowManager wm;
    private EventSave es;

    private AccionesDireccion accDir;
	private static Logger logger = Logger.getLogger(AddEmpleado.class);



	public AddEmpleado() {
		super();

		logger.debug("instanciando campos...");
        setLayout(new FlowLayout());
        setSize(1250, 300);
        setTitle("Nuevo Empleado");

        ciL = new JLabel("Cedula: ");
        ciTxt = new JTextField(8);

        nombreL = new JLabel("Nombre: ");
        nombreTxt = new JTextField(25);

        apellidoL = new JLabel("Apellido: ");
        apellidoTxt = new JTextField(25);

        tipoDocL = new JLabel("Tipo Documentacion: ");
        tipoDocTxt = new JTextField(25);

        valDocL = new JLabel("Identificacion del Documento: ");
        valDocTxt = new JTextField(25);

        tlfL = new JLabel("Telefono: ");
        tlfTxt = new JTextField(15);

        puestoL = new JLabel("Puesto: ");
        puestoTxt = new JTextField(30);

        zonaL = new JLabel("Zona: ");
        zonaTxt = new JTextField(20);

        linea1L = new JLabel("Direccion 1: ");
        linea1Txt = new JTextField(25);

        linea2L = new JLabel("Direccion 2: ");
        linea2Txt = new JTextField(25);

        //direccion
        logger.debug("buscando lista de paises...");
        accDir = new AccionesDireccion();
        String[] lPaises = accDir.listarPaises();
        System.out.println(lPaises);
        listaPaises = new JComboBox(lPaises);
        paises = new JLabel("Pais: ");
        logger.debug("retornÃ³ los paises...");

        logger.debug("buscando listas de ciudades...");
        listaCiudades = new JComboBox(accDir.listarCiudades());
        ciudades = new JLabel("Ciudades: ");
        logger.debug("retornÃ³ lista de ciudades...");

        save = new JButton("Guardar");
        save_exit = new JButton("Guardar y Salir");
        cancel = new JButton("Cancelar");

        add(ciL);
        add(ciTxt);
        add(nombreL);
        add(nombreTxt);
        add(apellidoL);
        add(apellidoTxt);
        add(puestoL);
        add(puestoTxt);
        add(paises);
        add(listaPaises);
        add(ciudades);
        add(listaCiudades);
        add(zonaL);
        add(zonaTxt);
        add(linea1L);
        add(linea1Txt);
        add(linea2L);
        add(linea2Txt);




        es = new EventSave(this, ConstantesRMA.ACCION_CREAR_EMPLEADO);


        save.addActionListener(es);
        add(save);

        save_exit.addActionListener(es);
        add(save_exit);

        cancel.addActionListener(es);
        add(cancel);


        setVisible(true);
        wm = new WindowManager();
        addWindowListener(wm);

}

	@Override
	public void reiniciarCampos() {
		this.getTipoDocTxt().setText("");
		this.getValDocTxt().setText("");
		this.getNombreTxt().setText("");
		this.getApellidoTxt().setText("");
		this.getPuestoTxt().setText("");
		this.getZonaTxt().setText("");
		this.getLinea1Txt().setText("");
		this.getLinea2Txt().setText("");
		this.getCiTxt().setText("");
	}

	public JTextField getTipoDocTxt() {
		return tipoDocTxt;
	}

	public void setTipoDocTxt(JTextField tipoDocTxt) {
		this.tipoDocTxt = tipoDocTxt;
	}

	public JTextField getValDocTxt() {
		return valDocTxt;
	}

	public void setValDocTxt(JTextField valDocTxt) {
		this.valDocTxt = valDocTxt;
	}

	public JTextField getNombreTxt() {
		return nombreTxt;
	}

	public void setNombreTxt(JTextField nombreTxt) {
		this.nombreTxt = nombreTxt;
	}

	public JTextField getApellidoTxt() {
		return apellidoTxt;
	}

	public void setApellidoTxt(JTextField apellidoTxt) {
		this.apellidoTxt = apellidoTxt;
	}

	public JTextField getPuestoTxt() {
		return puestoTxt;
	}

	public void setPuestoTxt(JTextField puestoTxt) {
		this.puestoTxt = puestoTxt;
	}

	public JComboBox getListaPaises() {
		return listaPaises;
	}

	public void setListaPaises(JComboBox listaPaises) {
		this.listaPaises = listaPaises;
	}

	public JComboBox getListaCiudades() {
		return listaCiudades;
	}

	public void setListaCiudades(JComboBox listaCiudades) {
		this.listaCiudades = listaCiudades;
	}

	public JTextField getZonaTxt() {
		return zonaTxt;
	}

	public void setZonaTxt(JTextField zonaTxt) {
		this.zonaTxt = zonaTxt;
	}

	public JTextField getLinea1Txt() {
		return linea1Txt;
	}

	public void setLinea1Txt(JTextField linea1Txt) {
		this.linea1Txt = linea1Txt;
	}

	public JTextField getLinea2Txt() {
		return linea2Txt;
	}

	public void setLinea2Txt(JTextField linea2Txt) {
		this.linea2Txt = linea2Txt;
	}

	public JTextField getCiTxt() {
		return ciTxt;
	}

	public void setCiTxt(JTextField ciTxt) {
		this.ciTxt = ciTxt;
	}

}
