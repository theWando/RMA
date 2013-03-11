package vista;

import controler.ConstantesRMA;
import controler.EventSave;
import controler.WindowManager;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddProducto extends VentanaBasica {
    private JTextField cantidadTxt;
    private JTextField marcaTxt;
    private JTextField nombreTxt;
    private JTextField precioTxt;
	private JTextField idProductoTxt;
    private JLabel cantidad;
    private JLabel marca;
    private JLabel nombre;
    private JLabel precio;
	private JLabel idProducto;
    private JButton save;
    private JButton save_exit;
    private JButton cancel;
    private WindowManager wm;
    private EventSave es;

    public AddProducto() {
		super();

        setLayout(new FlowLayout());
        setSize(700, 160);
        setTitle("Agregar Producto");

		idProducto = new JLabel("Id Producto: ");
		idProductoTxt = new JTextField(10);

        marca = new JLabel("Marca: ");
        marcaTxt = new JTextField(25);

        nombre = new JLabel("Nombre del producto: ");
        nombreTxt = new JTextField(50);

        precio = new JLabel("Precio: ");
        precioTxt = new JTextField(6);

        cantidad = new JLabel("Cantidad en inventario: ");
        cantidadTxt = new JTextField(3);

        save = new JButton("Guardar");
        save_exit = new JButton("Guardar y Salir");
        cancel = new JButton("Cancelar");

		add(idProducto);
		add(idProductoTxt);
        add(marca);
        add(marcaTxt);
        add(nombre);
        add(nombreTxt);
        add(precio);
        add(precioTxt);
        add(cantidad);
        add(cantidadTxt);

        es = new EventSave(this, ConstantesRMA.ACCION_CREAR_PRODUCTO);
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

	public JTextField getCantidadTxt() {
		return cantidadTxt;
	}

	public void setCantidadTxt(JTextField cantidadTxt) {
		this.cantidadTxt = cantidadTxt;
	}

	public JTextField getMarcaTxt() {
		return marcaTxt;
	}

	public void setMarcaTxt(JTextField marcaTxt) {
		this.marcaTxt = marcaTxt;
	}

	public JTextField getNombreTxt() {
		return nombreTxt;
	}

	public void setNombreTxt(JTextField nombreTxt) {
		this.nombreTxt = nombreTxt;
	}

	public JTextField getPrecioTxt() {
		return precioTxt;
	}

	public void setPrecioTxt(JTextField precioTxt) {
		this.precioTxt = precioTxt;
	}

	public JTextField getIdProductoTxt(){
		return idProductoTxt;
	}

	public void setIdProductoTxt(JTextField idProductoTxt){
		this.idProductoTxt = idProductoTxt;
	}

	@Override
	public String toString() {
		return "AddProducto [cantidadTxt=" + cantidadTxt + ", marcaTxt="
				+ marcaTxt + ", nombreTxt=" + nombreTxt + ", precioTxt="
				+ precioTxt + "]";
	}

	@Override
	public void reiniciarCampos() {
		this.getNombreTxt().setText("");
		this.getMarcaTxt().setText("");
		this.getCantidadTxt().setText("");
		this.getPrecioTxt().setText("");
		this.getIdProductoTxt().setText("");
	}

//	@Override
//	public void cerrarVentana() {
//		this.setVisible(false);
//        this.dispose();
//	}


}
