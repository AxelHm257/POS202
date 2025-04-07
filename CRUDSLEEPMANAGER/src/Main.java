import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.AdminConsultasMenu;
import view.AdminFeedbacksMenu;
import view.AdminTicketsMenu;
import view.UsuarioAdminMenu;

public class Main {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Menú Principal");
        mainFrame.setSize(300, 400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(null);

        JButton btnAdminUsuarios = new JButton("Administrar Usuarios");
        btnAdminUsuarios.setBounds(50, 30, 200, 30);
        mainFrame.add(btnAdminUsuarios);

        JButton btnAdminConsultas = new JButton("Administrar Consultas");
        btnAdminConsultas.setBounds(50, 80, 200, 30);
        mainFrame.add(btnAdminConsultas);

        JButton btnAdminTickets = new JButton("Administrar Tickets");
        btnAdminTickets.setBounds(50, 130, 200, 30);
        mainFrame.add(btnAdminTickets);

        JButton btnAdminFeedbacks = new JButton("Administrar Feedbacks");
        btnAdminFeedbacks.setBounds(50, 180, 200, 30);
        mainFrame.add(btnAdminFeedbacks);

        btnAdminUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openUsuarioAdminMenu();
            }
        });

        btnAdminConsultas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminConsultasMenu().setVisible(true);
            }
        });

        btnAdminTickets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminTicketsMenu().setVisible(true);
            }
        });

        btnAdminFeedbacks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminFeedbacksMenu().setVisible(true);
            }
        });

        mainFrame.setVisible(true);
    }

    private static void openUsuarioAdminMenu() {
        // Aquí debes abrir el menú de administración de usuarios
        new UsuarioAdminMenu().setVisible(true);
    }
}