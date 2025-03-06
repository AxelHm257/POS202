import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        Empleado EM = new Empleado("temporal",0,0);
        Administrativo AD = new Administrativo("temporal",0,0);

        boolean continuar = true;
        while (continuar) {
            String opcion = JOptionPane.showInputDialog(

                    "Menú:\n" +
                            "1. Implementar Empleado\n" +
                            "2. Mostrar Informacion\n" +
                            "3.Salir"
            );

            switch (opcion) {
                case "1":

                    EM.setNombre(JOptionPane.showInputDialog("Ingrese el nombre") + EM.getNombre());
                    EM.setId(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Id del empleado") + EM.getId()));
                    EM.setSalario(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el salario") + EM.getSalario()));

                    break;
                case "2":

                    Override
                    public void mostrarInfoEmpleado() {
                    JOptionPane.showMessageDialog(null, "Datos del Empleado:,\n Nombre: " + nombre + "\nID: " + id + "\nSalario: " + salario);
                }



                break;

                default:


            break;
            }
        }
    }
}