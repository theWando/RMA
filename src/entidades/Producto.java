package entidades;

public class Producto {
//	+-------------+-------------+------+-----+---------+----------------+
//	| Field       | Type        | Null | Key | Default | Extra          |
//	+-------------+-------------+------+-----+---------+----------------+
//	| id_producto | int(11)     | NO   | PRI | NULL    | auto_increment |
//	| marca       | varchar(25) | NO   |     | NULL    |                |
//	| nombre      | varchar(50) | NO   |     | NULL    |                |
//	| precio      | float       | NO   |     | NULL    |                |
//	| cantidad    | int(11)     | NO   |     | 0       |                |
//	+-------------+-------------+------+-----+---------+----------------+

	private int idProducto;
	
	private String marca;
	
	private String nombre;
	
	private float precio;
	
	private int cantidad;

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", marca=" + marca
				+ ", nombre=" + nombre + ", precio=" + precio + ", cantidad="
				+ cantidad + "]";
	}

	public Producto() {
		super();
	}
	
	
}
