package entidades;

public class Pais {
//	+----------------+---------------------------------------------------------------------------------------+------+-----+---------+-------+
//	| Field          | Type                                                                                  | Null | Key | Default | Extra |
//	+----------------+---------------------------------------------------------------------------------------+------+-----+---------+-------+
//	| Code           | char(3)                                                                               | NO   | PRI |         |       |
//	| Name           | char(52)                                                                              | NO   |     |         |       |
//	| Continent      | enum('Asia','Europe','North America','Africa','Oceania','Antarctica','South America') | NO   |     | Asia    |       |
//	| Region         | char(26)                                                                              | NO   |     |         |       |
//	| SurfaceArea    | float(10,2)                                                                           | NO   |     | 0.00    |       |
//	| IndepYear      | smallint(6)                                                                           | YES  |     | NULL    |       |
//	| Population     | int(11)                                                                               | NO   |     | 0       |       |
//	| LifeExpectancy | float(3,1)                                                                            | YES  |     | NULL    |       |
//	| GNP            | float(10,2)                                                                           | YES  |     | NULL    |       |
//	| GNPOld         | float(10,2)                                                                           | YES  |     | NULL    |       |
//	| LocalName      | char(45)                                                                              | NO   |     |         |       |
//	| GovernmentForm | char(45)                                                                              | NO   |     |         |       |
//	| HeadOfState    | char(60)                                                                              | YES  |     | NULL    |       |
//	| Capital        | int(11)                                                                               | YES  |     | NULL    |       |
//	| Code2          | char(2)                                                                               | NO   |     |         |       |
//	+----------------+---------------------------------------------------------------------------------------+------+-----+---------+-------+

	private String codigo;
	
	private String nombre;
	
	private String continente;

	private String region;
	
	private String superficie;
	
	private String capital;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContinente() {
		return continente;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSuperficie() {
		return superficie;
	}

	public void setSuperficie(String superficie) {
		this.superficie = superficie;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	@Override
	public String toString() {
		return "Pais [codigo=" + codigo + ", nombre=" + nombre
				+ ", continente=" + continente + ", region=" + region
				+ ", superficie=" + superficie + ", capital=" + capital + "]";
	}

	public Pais() {
		super();
	}
	
	
}
