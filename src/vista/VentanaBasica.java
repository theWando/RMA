package vista;

import javax.swing.JFrame;

public abstract class VentanaBasica extends JFrame implements AccionesBasicasVentana {
	
	@Override
	public void reiniciarCampos() {};
	@Override
	public void cerrarVentana() {
		this.setVisible(false);
        this.dispose();
	}
}
