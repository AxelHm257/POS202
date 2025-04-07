package view;

import dao.FeedbackDAO;
import model.Feedback;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class FeedbackForm extends JFrame {
    private JTextField txtComentarios;
    private JTextField txtPuntuacion;
    private JButton btnSave;

    public FeedbackForm() {
        setTitle("Agregar Feedback");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblComentarios = new JLabel("Comentarios:");
        lblComentarios.setBounds(20, 20, 100, 30);
        add(lblComentarios);

        txtComentarios = new JTextField();
        txtComentarios.setBounds(150, 20, 200, 30);
        add(txtComentarios);

        JLabel lblPuntuacion = new JLabel("Puntuación:");
        lblPuntuacion.setBounds(20, 60, 100, 30);
        add(lblPuntuacion);

        txtPuntuacion = new JTextField();
        txtPuntuacion.setBounds(150, 60, 200, 30);
        add(txtPuntuacion);

        btnSave = new JButton("Guardar");
        btnSave.setBounds(150, 100, 100, 30);
        add(btnSave);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFeedback();
            }
        });
    }

    private void saveFeedback() {
        String comentarios = txtComentarios.getText();
        int puntuacion = Integer.parseInt(txtPuntuacion.getText());
        Date fechaEnvio = new Date(); // Fecha actual
        String tipo = "Positivo"; // Cambia esto según el tipo de feedback
        int idUsuario = 1; // Cambia esto según el usuario actual

        Feedback feedback = new Feedback(0, comentarios, puntuacion, fechaEnvio, tipo, idUsuario);
        FeedbackDAO feedbackDAO = new FeedbackDAO();

        try {
            if (feedbackDAO.insertFeedback(feedback)) {
                JOptionPane.showMessageDialog(this, "Feedback guardado exitosamente.");
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar el feedback.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void clearFields() {
        txtComentarios.setText("");
        txtPuntuacion.setText("");
    }
}