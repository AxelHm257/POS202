package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminFeedbacksMenu extends JFrame {
    public AdminFeedbacksMenu() {
        setTitle("Administración de Feedbacks");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JButton btnAgregarFeedback = new JButton("Agregar Feedback");
        btnAgregarFeedback.setBounds(50, 30, 200, 30);
        add(btnAgregarFeedback);

        JButton btnListarFeedbacks = new JButton("Listar Feedbacks");
        btnListarFeedbacks.setBounds(50, 80, 200, 30);
        add(btnListarFeedbacks);

        btnAgregarFeedback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FeedbackForm().setVisible(true);
            }
        });

        btnListarFeedbacks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FeedbackList().setVisible(true);
            }
        });
    }
}