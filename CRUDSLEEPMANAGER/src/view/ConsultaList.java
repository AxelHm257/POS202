package view;

import dao.ConsultaDAO;
import model.Consulta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class ConsultaList extends JFrame {
    private JTable tablaConsultas;
    private JButton btnActualizar;
    private JButton btnEliminar; // Botón para eliminar
    private ConsultaDAO consultaDAO;

    public ConsultaList() {
        consultaDAO = new ConsultaDAO();
        setTitle("Lista de Consultas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Crear la tabla
        tablaConsultas = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaConsultas);
        scrollPane.setBounds(20, 20, 550, 300);
        add(scrollPane);

        // Botón para actualizar
        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(20, 330, 100, 30);
        add(btnActualizar);

        // Botón para eliminar
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(130, 330, 100, 30);
        add(btnEliminar);

        // Cargar datos en la tabla
        cargarDatos();

        // Acción para el botón de actualizar
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tablaConsultas.getSelectedRow();
                if (selectedRow != -1) {
                    int idConsulta = (int) tablaConsultas.getValueAt(selectedRow, 0); // Asumiendo que el ID está en la primera columna
                    try {
                        Consulta consulta = consultaDAO.getConsultaById(idConsulta); // Obtener la consulta por ID
                        if (consulta != null) {
                            // Mostrar el formulario de edición
                            ConsultaForm consultaForm = new ConsultaForm(consulta);
                            consultaForm.setVisible(true);
                            consultaForm.addWindowListener(new java.awt.event.WindowAdapter() {
                                @Override
                                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                                    cargarDatos(); // Recargar datos al cerrar el formulario
                                }
                            });
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró la consulta con el ID seleccionado.");
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error al recuperar la consulta: " + ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona una consulta para actualizar.");
                }
            }
        });

        // Acción para el botón de eliminar
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tablaConsultas.getSelectedRow();
                if (selectedRow != -1) {
                    int idConsulta = (int) tablaConsultas.getValueAt(selectedRow, 0); // Obtener el ID de la consulta seleccionada
                    int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar esta consulta?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        try {
                            if (consultaDAO.deleteConsulta(idConsulta)) {
                                JOptionPane.showMessageDialog(null, "Consulta eliminada con éxito.");
                                cargarDatos(); // Recargar datos después de eliminar
                            } else {
                                JOptionPane.showMessageDialog(null, "Error al eliminar la consulta.");
                            }
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Error al eliminar la consulta: " + ex.getMessage());
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona una consulta para eliminar.");
                }
            }
        });
    }

    private void cargarDatos() {
        try {
            List<Consulta> consultas = consultaDAO.listAllConsultas();
            String[] columnNames = {"ID", "Tipo", "Descripción", "Fecha", "Estado", "Respuesta", "ID Usuario", "ID Soporte"};
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);

            for (Consulta consulta : consultas) {
                Object[] row = {
                    consulta.getId(),
                    consulta.getIdTipo(),
                    consulta.getDescripcion(),
                    consulta.getFecha(),
                    consulta.getEstado(),
                    consulta.getRespuesta(),
                    consulta.getIdUsuario(),
                    consulta.getIdSoporteTecnico()
                };
                model.addRow(row);
            }

            tablaConsultas.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar las consultas: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ConsultaList().setVisible(true);
        });
    }
}