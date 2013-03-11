package controler;

import java.awt.Window;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowManager implements WindowListener{
    
    public void windowOpened(WindowEvent e) {}

    public void windowClosing(WindowEvent e) {
        Window w = (Window) e.getSource();
        w.setVisible(false);
        w.dispose();
        if(e.getSource().toString().contains("LVP"))
            System.exit(0);
    }

    public void windowClosed(WindowEvent e) {}

    public void windowIconified(WindowEvent e) {}

    public void windowDeiconified(WindowEvent e) {}

    public void windowActivated(WindowEvent e) {}

    public void windowDeactivated(WindowEvent e) {}

}
