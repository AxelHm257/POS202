package view;

import dao.UsuarioDAO;
import model.Usuario;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UsuarioList extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton btnDelete;

    public UsuarioList() {
        setTitle("Lista de Usuarios");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Apellido Paterno");
        tableModel.addColumn("Apellido Materno");
        tableModel.addColumn("Edad");
        tableModel.addColumn("Correo");
        tableModel.addColumn("Teléfono");
        tableModel.addColumn("Fecha Nacimiento");
        tableModel.addColumn("Nivel Estudios");
        tableModel.addColumn("Contraseña");
        tableModel.addColumn("ID Género");

        table = new JTable(tableModel);
        loadUsuarios();

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        btnDelete = new JButton("Eliminar Usuario");
        add(btnDelete, BorderLayout.SOUTH);

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteUsuario();
            }
        });
    }

    private void loadUsuarios() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            List<Usuario> usuarios = usuarioDAO.listAllUsuarios();
            for (Usuario usuario : usuarios) {
                tableModel.addRow(new Object[]{
                        usuario.getId(),
                        usuario.getNombre(),
                        usuario.getAp(),
                        usuario.getAm(),
                        usuario.getEdad(),
                        usuario.getCorreo(),
                        usuario.getTelefono(),
                        usuario.getFechanacimiento(),
                        usuario.getNivelestudios(),
                        usuario.getContraseña(),
                        usuario.getIdgenero()
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void deleteUsuario() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) tableModel.getValueAt(selectedRow, 0);
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            try {
                if (usuarioDAO.deleteUsuario(id)) {
                    tableModel.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(this, "Usuario eliminado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el usuario.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un usuario para eliminar.");
        }
    }
}