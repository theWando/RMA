package entidades;

public class Direccion {
//	| id_direccion | int(11)      | NO   | PRI | NULL    | auto_increment |
//	| id_ciudad    | int(11)      | NO   | MUL | NULL    |                |
//	| cod_pais     | varchar(3)   | NO   | MUL | NULL    |                |
//	| zona         | varchar(15)  | YES  |     | NULL    |                |
//	| linea1       | varchar(200) | YES  |     | NULL    |                |
//	| linea2       | varchar(200) | YES  |     | NULL    |                |
	
	private long idDireccion;
	
	private int idCiudad;
	
	private String codPaid;
	
	private String zona;
	
	private String linea1;
	
	private String linea2;

	public long getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(long idDireccion) {
		this.idDireccion = idDireccion;
	}

	public int getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getCodPaid() {
		return codPaid;
	}

	public void setCodPaid(String codPaid) {
		this.codPaid = codPaid;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getLinea1() {
		return linea1;
	}

	public void setLinea1(String linea1) {
		this.linea1 = linea1;
	}

	public String getLinea2() {
		return linea2;
	}

	public void setLinea2(String linea2) {
		this.linea2 = linea2;
	}

	@Override
	public String toString() {
		return "Direccion [idDireccion=" + idDireccion + ", idCiudad="
				+ idCiudad + ", codPaid=" + codPaid + ", zona=" + zona
				+ ", linea1=" + linea1 + ", linea2=" + linea2 + "]";
	}

	public Direccion() {
		super();
	}
	
}
