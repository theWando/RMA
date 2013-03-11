package controler;

public final class ConstantesRMA {

	public static final String BTT_ADD_EMPLEADO = "Crear Empleado";

	public static final String BTT_ADD_PRODUCTO = "Crear Producto";

	public static final String BTT_ADD_FACTURA = "Crear Factura";

	public static final String BTT_ADD_DEVOLUCION = "Registrar Devolucion";

	public static final String BTT_VER_FACTURAS_X_CLIENTE = "Ver Facturas de Cliente";

	public static final String BTT_CREAR_CLIENTE = "Crear Cliente";

	public static final String ACCION_CREAR_EMPLEADO = "crear.empleado";

	public static final String ACCION_CREAR_PRODUCTO = "crear.producto";

	public static final String ACCION_BUSCAR_CLIENTE = "buscar.cliente";

	public static final String ACCION_CREAR_CLIENTE = "crear.cliente";

	public static final String ACCION_REGISTRAR_DEVOLUCION = "registrar.devolucion";

	/*TABLAS*/
	public static final String TABLE_PERSONA = "persona";

	public static final String TABLE_EMPLEADO = "empleado";

	public static final String TABLE_DOC = "documento_identificacion";

	public static final String TABLE_CONTACTO = "contacto";

	public static final String TABLE_DIRECCION = "direccion";

	public static final String TABLE_DIRECCION_PERSONA = "direccion_persona";

	public static final String TABLE_COUNTRY = "Country";

	public static final String TABLE_CITY = "City";

	public static final String TABLE_DEVOLUCION = "devolucion";

	public static final String TABLE_PRODUCTO = "producto";

	/*selects, inserts */
	public static final String INSERT_DOC = "tipo, valor";

	public static final String INSERT_PERSONA = "nombre, apellido, id_doc_ident";

	public static final String INSERT_EMPLEADO = "puesto, fecha_inicio, nivel_acceso, id_persona";

	public static final String INSERT_CONTACTO = "tipo_contacto, id_persona, valor";

	public static final String INSERT_DIRECCION = "id_ciudad, cod_pais, zona, linea1, linea2";

    public static final String INSERT_DIRECCION_PERSONA = "id_direccion, id_persona, tipo_direccion";

    public static final String INSERT_PRODUCTO = "id_producto, nombre, marca, cantidad, precio";
        
    public static final String INSERT_DEVOLUCION = "id_empleado, id_cliente, id_producto, razon, estado_producto, observaciones";    

}
