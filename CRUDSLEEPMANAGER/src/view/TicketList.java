package view;

import dao.TicketDAO;
import model.Ticket;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TicketList extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private TicketDAO ticketDAO;

    public TicketList() {
        ticketDAO = new TicketDAO();
        setTitle("Lista de Tickets");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Asunto");
        tableModel.addColumn("Descripción del Problema");
        tableModel.addColumn("Estado");
        tableModel.addColumn("Fecha Apertura");
        tableModel.addColumn("Fecha Resolución");
        tableModel.addColumn("ID Usuario");
tableModel.addColumn("ID Soporte Técnico");


        table = new JTable(tableModel);
        loadTickets();

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Panel para los botones
        JPanel buttonPanel = new JPanel();
        JButton updateButton = new JButton("Actualizar");
        JButton deleteButton = new JButton("Eliminar");

        updateButton.addActionListener(e -> updateTicket());
        deleteButton.addActionListener(e -> deleteTicket());

        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void loadTickets() {
        try {
            List<Ticket> tickets = ticketDAO.listAllTickets();
            tableModel.setRowCount(0); // Limpiar la tabla antes de cargar
            for (Ticket ticket : tickets) {
                tableModel.addRow(new Object[]{
    ticket.getId(),
    ticket.getAsunto(),
    ticket.getDescripcionProblema(),
    ticket.getEstado(),
    ticket.getFechaApertura(),
    ticket.getFechaResolucion(),
    ticket.getIdUsuario(),
    ticket.getIdSoporteTecnico()
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void updateTicket() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
int id = (int) tableModel.getValueAt(selectedRow, 0);
String asunto = (String) tableModel.getValueAt(selectedRow, 1);
String descripcionProblema = (String) tableModel.getValueAt(selectedRow, 2);
String estado = (String) tableModel.getValueAt(selectedRow, 3);
int idUsuario = (int) tableModel.getValueAt(selectedRow, 6);
int idSoporteTecnico = (int) tableModel.getValueAt(selectedRow, 7);

Ticket ticket = new Ticket(id, asunto, descripcionProblema, estado, null, null, idUsuario, idSoporteTecnico);


            // Abre el formulario de actualización
            TicketForm ticketForm = new TicketForm(ticket);
            ticketForm.setVisible(true);
            ticketForm.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    loadTickets(); // Recargar la lista de tickets al cerrar el formulario
                }
            });
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un ticket para actualizar.");
        }
    }

    private void deleteTicket() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) tableModel.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar este ticket?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    if (ticketDAO.deleteTicket(id)) {
                        JOptionPane.showMessageDialog(this, "Ticket eliminado con éxito.");
                        loadTickets(); // Recargar la lista de tickets
                    } else {
                        JOptionPane.showMessageDialog(this, "Error al eliminar el ticket.");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un ticket para eliminar.");
        }
    }
}