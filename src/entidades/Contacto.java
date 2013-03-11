package entidades;


public class Contacto {
//	+---------------+-------------+------+-----+---------+-------+
//	| Field         | Type        | Null | Key | Default | Extra |
//	+---------------+-------------+------+-----+---------+-------+
//	| id_contacto   | int(11)     | NO   | PRI | NULL    |       |
//	| tipo_contacto | varchar(3)  | YES  | MUL | NULL    |       |
//	| id_persona    | int(11)     | NO   | MUL | NULL    |       |
//	| valor         | varchar(20) | NO   |     | NULL    |       |
//	+---------------+-------------+------+-----+---------+-------+


	private int idContacto;
	
	private String tipoContacto;
	
	private int idPersona;
	
	private String valor;

	public int getIdContacto() {
		return idContacto;
	}

	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}

	public String getTipoContacto() {
		return tipoContacto;
	}

	public void setTipoContacto(String tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	@Override
	public String toString() {
		return "Contacto [idContacto=" + idContacto + ", tipoContacto="
				+ tipoContacto + ", idPersona=" + idPersona + ", valor="
				+ valor + "]";
	}

	public Contacto() {
		super();
	}

}
