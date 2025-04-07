package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminTicketsMenu extends JFrame {
    public AdminTicketsMenu() {
        setTitle("Administración de Tickets");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JButton btnAgregarTicket = new JButton("Agregar Ticket");
        btnAgregarTicket.setBounds(50, 30, 200, 30);
        add(btnAgregarTicket);

        JButton btnListarTickets = new JButton("Listar Tickets");
        btnListarTickets.setBounds(50, 80, 200, 30);
        add(btnListarTickets);

        btnAgregarTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TicketForm().setVisible(true);
            }
        });

        btnListarTickets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TicketList().setVisible(true);
            }
        });
    }
}