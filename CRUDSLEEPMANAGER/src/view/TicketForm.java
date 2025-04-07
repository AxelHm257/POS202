package view;

import dao.TicketDAO;
import model.Ticket;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TicketForm extends JFrame {
    private JTextField txtAsunto;
    private JTextField txtDescripcionProblema;
    private JButton btnSave;
    private Ticket ticket; // Ticket a actualizar

    // Constructor para agregar un nuevo ticket
    public TicketForm() {
        this(null); // Llama al constructor que acepta un Ticket
    }

    // Constructor para actualizar un ticket existente
    public TicketForm(Ticket ticket) {
        this.ticket = ticket; // Guarda el ticket a actualizar
        setTitle(ticket == null ? "Agregar Ticket" : "Actualizar Ticket");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblAsunto = new JLabel("Asunto:");
        lblAsunto.setBounds(20, 20, 100, 30);
        add(lblAsunto);

        txtAsunto = new JTextField();
        txtAsunto.setBounds(150, 20, 200, 30);
        add(txtAsunto);

        JLabel lblDescripcionProblema = new JLabel("Descripción del Problema:");
        lblDescripcionProblema.setBounds(20, 60, 150, 30);
        add(lblDescripcionProblema);

        txtDescripcionProblema = new JTextField();
        txtDescripcionProblema.setBounds(150, 60, 200, 30);
        add(txtDescripcionProblema);

        btnSave = new JButton(ticket == null ? "Guardar" : "Actualizar");
        btnSave.setBounds(150, 100, 100, 30);
        add(btnSave);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ticket == null) {
                    saveTicket();
                } else {
                    updateTicket();
                }
            }
        });

        // Si se está actualizando, llenar los campos con los datos del ticket
        if (ticket != null) {
            txtAsunto.setText(ticket.getAsunto());
            txtDescripcionProblema.setText(ticket.getDescripcionProblema());
            // Aquí puedes agregar lógica para llenar otros campos si es necesario
        }
    }

    private void saveTicket() {
        String asunto = txtAsunto.getText();
        String descripcionProblema = txtDescripcionProblema.getText();
        String estado = "Pendiente"; // Estado inicial
        Date fechaApertura = new Date(); // Fecha actual
        Date fechaResolucion = null; // Inicialmente nulo
        int idUsuario = 1; // Cambia esto según el usuario actual
        int idSoporteTecnico = 1; // Cambia esto según el soporte técnico asignado

        Ticket ticket = new Ticket(0, asunto, descripcionProblema, estado, fechaApertura, fechaResolucion, idUsuario, idSoporteTecnico);
        TicketDAO ticketDAO = new TicketDAO();

        try {
            if (ticketDAO.insertTicket(ticket)) {
                JOptionPane.showMessageDialog(this, "Ticket guardado exitosamente.");
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar el ticket.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
    
    

    private void updateTicket() {
        
        // Validación rápida si viene en 0
if (ticket.getIdUsuario() == 0) {
    ticket.setIdUsuario(1); // o el ID del usuario actual
}
if (ticket.getIdSoporteTecnico() == 0) {
    ticket.setIdSoporteTecnico(1); // o el ID del soporte técnico por defecto
}
    
        
        // Actualiza los campos del ticket existente
        ticket.setAsunto(txtAsunto.getText());
        ticket.setDescripcionProblema(txtDescripcionProblema.getText());
        // Aquí puedes agregar lógica para actualizar otros campos si es necesario

        // Si la fecha de apertura es null, puedes establecerla a la fecha actual o manejarlo de otra manera
        if (ticket.getFechaApertura() == null) {
            ticket.setFechaApertura(new Date()); // Establecer a la fecha actual si es null
        }

        TicketDAO ticketDAO = new TicketDAO();
        try {
            if (ticketDAO.updateTicket(ticket)) {
                JOptionPane.showMessageDialog(this, "Ticket actualizado exitosamente.");
                dispose(); // Cierra el formulario
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar el ticket.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void clearFields() {
        txtAsunto.setText("");
        txtDescripcionProblema.setText("");
    }
}