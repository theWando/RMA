package entidades;

public class Compra {
//	+-------------+---------------+------+-----+---------+-------+
//	| Field       | Type          | Null | Key | Default | Extra |
//	+-------------+---------------+------+-----+---------+-------+
//	| id_producto | int(11)       | NO   | PRI | NULL    |       |
//	| cantidad    | tinyint(4)    | NO   |     | NULL    |       |
//	| precio      | decimal(10,0) | NO   |     | NULL    |       |
//	| id_factura  | int(11)       | NO   | PRI | NULL    |       |
//	+-------------+---------------+------+-----+---------+-------+

	private int idCompra;
	
	private Producto producto;
	
	private int cantidad;
	
	private float precio;
	
	private int idFactura;

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Compra [idCompra=" + idCompra + ", producto=" + producto
				+ ", cantidad=" + cantidad + ", precio=" + precio
				+ ", idFactura=" + idFactura + "]";
	}

	public Compra() {
		super();
	}
}
