package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Consulta;

public class AdminConsultasMenu extends JFrame {
    public AdminConsultasMenu() {
        setTitle("Administración de Consultas");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JButton btnAgregarConsulta = new JButton("Agregar Consulta");
        btnAgregarConsulta.setBounds(50, 30, 200, 30);
        add(btnAgregarConsulta);

        JButton btnListarConsultas = new JButton("Listar Consultas");
        btnListarConsultas.setBounds(50, 80, 200, 30);
        add(btnListarConsultas);

        // Acción para agregar una nueva consulta
        btnAgregarConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Crear un nuevo formulario de consulta vacío
                    ConsultaForm consultaForm = new ConsultaForm(new Consulta(0, 0, "", null, "", "", 0, 0));
                    consultaForm.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al abrir el formulario de consulta: " + ex.getMessage());
                }
            }
        });

        // Acción para listar las consultas
        btnListarConsultas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new ConsultaList().setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al abrir la lista de consultas: " + ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AdminConsultasMenu().setVisible(true);
        });
    }
}