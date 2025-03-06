import javax.swing.*;

public class Conductor  extends Empleado {

    private String licencia;
    public Conductor(String nombre, int id, double salario) {
        super(nombre, id, salario);
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public void mostrarInfoLicencia() {
        JOptionPane.showMessageDialog(null, "Licencia:" + licencia);
    }
}
