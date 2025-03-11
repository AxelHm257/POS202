import javax.swing.*;

public class Conductor extends Empleado {

    private String licencia;

    public Conductor(String nombre, int id, double salario, String licencia) {
        super(nombre, id, salario);
        this.licencia = licencia; // Inicialización correcta
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public void mostrarInfoLicencia() {
        JOptionPane.showMessageDialog(null,
                "Nombre: " + getNombre() +
                        "\nID: " + getId() +
                        "\nSalario: " + getSalario() +
                        "\nLicencia: " + licencia);
    }
}
