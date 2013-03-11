package entidades;

public class Ciudad {

//	+-------------+----------+------+-----+---------+----------------+
//	| Field       | Type     | Null | Key | Default | Extra          |
//	+-------------+----------+------+-----+---------+----------------+
//	| ID          | int(11)  | NO   | PRI | NULL    | auto_increment |
//	| Name        | char(35) | NO   |     |         |                |
//	| CountryCode | char(3)  | NO   |     |         |                |
//	| District    | char(20) | NO   |     |         |                |
//	| Population  | int(11)  | NO   |     | 0       |                |
//	+-------------+----------+------+-----+---------+----------------+

	private int idCiudad;
	
	private String nombre;
	
	private Pais pais;
	
	private String distrito;
	
	private int poblacion;

	public int getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public int getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}

	@Override
	public String toString() {
		return "Ciudad [idCiudad=" + idCiudad + ", nombre=" + nombre
				+ ", distrito=" + distrito + ", poblacion=" + poblacion + "]";
	}

	public Ciudad() {
		super();
	}
	
	
	
}
