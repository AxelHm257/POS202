import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Conductor CO = null;
        Administrativo AD = null;

        boolean continuar = true;
        while (continuar) {
            String opcion = JOptionPane.showInputDialog(
                    "Menú:\n" +
                            "1. Implementar Empleado\n" +
                            "2. Mostrar Información\n" +
                            "3. Salir"
            );

            switch (opcion) {
                case "1":
                    String opcionEmpleado = JOptionPane.showInputDialog(
                            "1. Conductor\n2. Administrativo\n3. Volver"
                    );

                    switch (opcionEmpleado) {
                        case "1":
                            String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
                            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Id del empleado:"));
                            double salario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario:"));
                            String licencia = JOptionPane.showInputDialog("Ingrese la licencia:");

                            CO = new Conductor(nombre, id, salario, licencia);
                            break;

                        case "2":
                            nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
                            id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Id del empleado:"));
                            salario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario:"));
                            String departamento = JOptionPane.showInputDialog("Ingrese el departamento:");

                            AD = new Administrativo(nombre, id, salario, departamento);
                            break;

                        case "3":
                            break;

                        default:
                            JOptionPane.showMessageDialog(null, "Ingrese una opción válida.");
                    }
                    break;

                case "2": // Mostrar información
                    StringBuilder info = new StringBuilder();

                    if (CO != null) {
                        info.append("Conductor:\n");
                        info.append("Nombre: ").append(CO.getNombre()).append("\n");
                        info.append("ID: ").append(CO.getId()).append("\n");
                        info.append("Salario: ").append(CO.getSalario()).append("\n");
                        info.append("Licencia: ").append(CO.getLicencia()).append("\n\n");
                    } else {
                        info.append("No hay información de Conductor registrada.\n\n");
                    }

                    if (AD != null) {
                        info.append("Administrativo:\n");
                        info.append("Nombre: ").append(AD.getNombre()).append("\n");
                        info.append("ID: ").append(AD.getId()).append("\n");
                        info.append("Salario: ").append(AD.getSalario()).append("\n");
                        info.append("Departamento: ").append(AD.getDepartamento()).append("\n");
                    } else {
                        info.append("No hay información de Administrativo registrada.");
                    }

                    JOptionPane.showMessageDialog(null, info.toString());
                    break;

                case "3":
                    continuar = false;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Ingrese una opción válida.");
            }
        }
    }
}
