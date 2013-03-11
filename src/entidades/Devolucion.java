package entidades;

public class Devolucion {
	private int idDevolucion;
	private Empleado empleado;
	private Persona cliente;
	private Producto producto;
	private String razon;
	private String estado;
	private String observaciones;
	
	public int getIdDevolucion() {
		return idDevolucion;
	}
	public void setIdDevolucion(int idDevolucion) {
		this.idDevolucion = idDevolucion;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Persona getCliente() {
		return cliente;
	}
	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public String getRazon() {
		return razon;
	}
	public void setRazon(String razon) {
		this.razon = razon;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Devolucion() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Devolucion [idDevolucion=" + idDevolucion + ", empleado="
				+ empleado + ", cliente=" + cliente + ", producto=" + producto
				+ ", razon=" + razon + ", estado=" + estado
				+ ", observaciones=" + observaciones + "]";
	}
	
//	+-----------------+--------------+------+-----+---------+----------------+
//	| Field           | Type         | Null | Key | Default | Extra          |
//	+-----------------+--------------+------+-----+---------+----------------+
//	| id_devolucion   | int(11)      | NO   | PRI | NULL    | auto_increment |
//	| id_empleado     | int(11)      | NO   | MUL | NULL    |                |
//	| id_cliente      | int(11)      | NO   | MUL | NULL    |                |
//	| id_producto     | int(11)      | NO   | MUL | NULL    |                |
//	| razon           | varchar(200) | NO   |     | NULL    |                |
//	| estado_producto | varchar(10)  | NO   |     | NULL    |                |
//	| observaciones   | varchar(200) | NO   |     | NULL    |                |
//	+-----------------+--------------+------+-----+---------+----------------+

	
}
