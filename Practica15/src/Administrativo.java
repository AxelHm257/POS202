import javax.swing.*;

public class Administrativo extends Empleado {

    private String departamento;
    public Administrativo(String nombre, int id, double salario) {
        super(nombre, id, salario);
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void mostrarInfoDepartamento() {
        JOptionPane.showMessageDialog(null, "Departamento:" + departamento);
    }
}
