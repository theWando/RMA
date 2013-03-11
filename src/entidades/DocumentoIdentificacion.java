package entidades;

public class DocumentoIdentificacion {
//	+--------------+-------------+------+-----+---------+----------------+
//	| Field        | Type        | Null | Key | Default | Extra          |
//	+--------------+-------------+------+-----+---------+----------------+
//	| id_doc_ident | int(11)     | NO   | PRI | NULL    | auto_increment |
//	| tipo         | varchar(3)  | NO   |     | NULL    |                |
//	| valor        | varchar(14) | NO   |     | NULL    |                |
//	+--------------+-------------+------+-----+---------+----------------+

	private int idDocIdent;
	
	private String tipo;
	
	private String valor;

	public int getIdDocIdent() {
		return idDocIdent;
	}

	public void setIdDocIdent(int idDocIdent) {
		this.idDocIdent = idDocIdent;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "DocumentoIdentificacion [idDocIdent=" + idDocIdent + ", tipo="
				+ tipo + ", valor=" + valor + "]";
	}

	public DocumentoIdentificacion() {
		super();
	}
	
	
}
