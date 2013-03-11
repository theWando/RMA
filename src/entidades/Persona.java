package entidades;

public class Persona {
	private long idPersona;
	
	private DocumentoIdentificacion docIdent;
	
	private String nombre;
	
	private String apellido;
	
	private Direccion dir;

	public Direccion getDir() {
		return dir;
	}

	public void setDir(Direccion dir) {
		this.dir = dir;
	}

	public long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(long idPersona) {
		this.idPersona = idPersona;
	}

	public DocumentoIdentificacion getDocIdent() {
		return docIdent;
	}

	public void setDocIdent(DocumentoIdentificacion dicIdent) {
		this.docIdent = dicIdent;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", dicIdent=" + docIdent
				+ ", nombre=" + nombre + ", apellido=" + apellido + ", dir="
				+ dir + "]";
	}

	public Persona() {
		super();
	}
	
	
	
}
