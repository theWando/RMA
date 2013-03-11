package entidades;

import java.util.Date;
import java.util.List;

public class Factura {
//	+--------------+---------------+------+-----+---------+----------------+
//	| Field        | Type          | Null | Key | Default | Extra          |
//	+--------------+---------------+------+-----+---------+----------------+
//	| id_factura   | int(11)       | NO   | PRI | NULL    | auto_increment |
//	| cajero       | int(11)       | NO   | MUL | NULL    |                |
//	| cliente      | int(11)       | NO   | MUL | NULL    |                |
//	| fecha_compra | date          | NO   |     | NULL    |                |
//	| total        | decimal(10,0) | NO   |     | NULL    |                |
//	| iva          | int(11)       | NO   |     | NULL    |                |
//	| descuento    | int(11)       | NO   |     | NULL    |                |
//	| subtotal     | decimal(10,0) | NO   |     | NULL    |                |
//	+--------------+---------------+------+-----+---------+----------------+

	private int idFactura;
	
	private Empleado cajero;
	
	private Persona cliente;
	
	private Date fechaCompra;
	
	private List<Compra> listaCompra;

	private float total;
	
	private int iva;
	
	private int descuento;
	
	private float subTotal;

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public Empleado getCajero() {
		return cajero;
	}

	public void setCajero(Empleado cajero) {
		this.cajero = cajero;
	}

	public Persona getCliente() {
		return cliente;
	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}
	
	public List<Compra> getListaCompra() {
		return listaCompra;
	}

	public void setListaCompra(List<Compra> listaCompra) {
		this.listaCompra = listaCompra;
	}

	public Factura() {
		super();
	}
	
	
}
