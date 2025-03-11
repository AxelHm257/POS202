import javax.swing.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        SolicitudDeDatos PE = new SolicitudDeDatos("temporal", "temporal", "temporal", "temporal", 0);

        boolean continuar = true;
        while (continuar) {
            String opcion = JOptionPane.showInputDialog(
                    "Menú:\n" +
                            "1. Solicitar Datos\n" +
                            "2. Mostrar Datos\n" +
                            "3. Generar Matrícula\n" +
                            "4. Salir"
            );

            switch (opcion) {
                case "1":
                    PE.setNombre(JOptionPane.showInputDialog("Ingrese el Nombre"));
                    PE.setCarrera(JOptionPane.showInputDialog("Ingrese la Carrera"));
                    PE.setAp(JOptionPane.showInputDialog("Ingrese su Apellido Paterno"));
                    PE.setAm(JOptionPane.showInputDialog("Ingrese su Apellido Materno"));
                    PE.setFecha(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Fecha de Nacimiento (AAAA)")));
                    break;
                case "2":
                    PE.MostrarInfo();
                    break;
                case "3":
                    String matricula = generarMatricula(PE);
                    JOptionPane.showMessageDialog(null, "Matrícula generada: " + matricula);
                    break;
                case "4":
                    continuar = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
                    break;
            }
        }
    }

    public static String generarMatricula(SolicitudDeDatos PE) {
        String carrera = PE.getCarrera().substring(0, Math.min(3, PE.getCarrera().length()));

        int añoActual = java.time.Year.now().getValue();
        String añoActualStr = String.valueOf(añoActual).substring(2);

        String añoNacimientoStr = String.valueOf(PE.getFecha()).substring(2);

        char primeraLetraNombre = PE.getNombre().charAt(0);

        String apellidoPaterno = PE.getAp().substring(0, Math.min(3, PE.getAp().length()));

        String apellidoMaterno = PE.getAm().substring(0, Math.min(3, PE.getAm().length()));

        String caracteresAleatorios = generarCaracteresAleatorios(3);

        return carrera.toUpperCase() + añoActualStr + añoNacimientoStr + primeraLetraNombre + apellidoPaterno.toUpperCase()+ apellidoMaterno.toUpperCase()+ caracteresAleatorios;
    }

    public static String generarCaracteresAleatorios(int longitud) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(longitud);
        for (int i = 0; i < longitud; i++) {
            sb.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }
        return sb.toString();
    }
}

class SolicitudDeDatos {
    private String Nombre;
    private String Carrera;
    private String Ap;
    private String Am;
    private int Fecha;

    public SolicitudDeDatos(String nombre, String carrera, String ap, String am, int fecha) {
        this.Nombre = nombre;
        this.Carrera = carrera;
        this.Ap = ap;
        this.Am = am;
        this.Fecha = fecha;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String carrera) {
        Carrera = carrera;
    }

    public String getAp() {
        return Ap;
    }

    public void setAp(String ap) {
        Ap = ap;
    }

    public String getAm() {
        return Am;
    }

    public void setAm(String am) {
        Am = am;
    }

    public int getFecha() {
        return Fecha;
    }

    public void setFecha(int fecha) {
        Fecha = fecha;
    }

    public void MostrarInfo() {
        JOptionPane.showMessageDialog(null, "Datos del Empleado:\nNombre: " + Nombre + "\nApellido Paterno: " + Ap + "\nApellido Materno: " + Am + "\nCarrera: " + Carrera + "\nFecha de Nacimiento: " + Fecha);
    }
}
