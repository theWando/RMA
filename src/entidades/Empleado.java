package entidades;

import java.util.Date;

public class Empleado{
//	+--------------+-------------+------+-----+---------+----------------+
//	| Field        | Type        | Null | Key | Default | Extra          |
//	+--------------+-------------+------+-----+---------+----------------+
//	| id_empleado  | int(11)     | NO   | PRI | NULL    | auto_increment |
//	| id_persona   | int(11)     | NO   | MUL | NULL    |                |
//	| puesto       | varchar(20) | NO   |     | NULL    |                |
//	| fecha_inicio | date        | NO   |     | NULL    |                |
//	| fecha_fin    | date        | YES  |     | NULL    |                |
//	| nivel_acceso | tinyint(4)  | NO   |     | NULL    |                |
//	+--------------+-------------+------+-----+---------+----------------+

	private int idEmpleado;
	
	private Persona persona;
	
	private String puesto;
	
	private Date fechaInicio;
	
	private Date fechaFin;
	
	private int nivelAcceso;

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getNivelAcceso() {
		return nivelAcceso;
	}

	public void setNivelAcceso(int nivelAcceso) {
		this.nivelAcceso = nivelAcceso;
	}

	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", persona=" + persona
				+ ", puesto=" + puesto + ", nivelAcceso=" + nivelAcceso + "]";
	}

	public Empleado() {
		super();
	}
	
	
}
