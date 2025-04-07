package view;

import dao.FeedbackDAO; 
import model.Feedback; 
import java.sql.SQLException; 
import javax.swing.*; 
import javax.swing.table.DefaultTableModel; 
import java.awt.BorderLayout;
 import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FeedbackList extends JFrame { private JTable table; private DefaultTableModel tableModel;

public FeedbackList() {
    setTitle("Lista de Feedbacks");
    setSize(600, 400);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());

    tableModel = new DefaultTableModel();
    tableModel.addColumn("ID");
    tableModel.addColumn("Comentarios");
    tableModel.addColumn("Puntuación");
    tableModel.addColumn("Fecha Envío");
    tableModel.addColumn("Tipo");

    table = new JTable(tableModel);
    loadFeedbacks();

    JScrollPane scrollPane = new JScrollPane(table);
    add(scrollPane, BorderLayout.CENTER);
}

private void loadFeedbacks() {
    FeedbackDAO feedbackDAO = new FeedbackDAO();
    try {
        List<Feedback> feedbacks = feedbackDAO.listAllFeedbacks();
        for (Feedback feedback : feedbacks) {
            tableModel.addRow(new Object[]{
                    feedback.getId(),
                    feedback.getComentarios(),
                    feedback.getPuntuacion(),
                    feedback.getFechaEnvio(),
                    feedback.getTipo()
            });
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    }
}
}