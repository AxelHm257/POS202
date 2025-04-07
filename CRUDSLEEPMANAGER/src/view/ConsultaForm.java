package view;

import dao.ConsultaDAO;
import model.Consulta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ConsultaForm extends JFrame {
    private JTextField txtIdTipo;
    private JTextArea txtDescripcion;
    private JTextField txtEstado;
    private JTextField txtRespuesta;
    private JTextField txtIdUsuario;
    private JTextField txtIdSoporteTecnico;
    private JButton btnGuardar;
    private JButton btnCancelar;
    private Consulta consulta; // Consulta a editar

    public ConsultaForm(Consulta consulta) {
        this.consulta = consulta; // Guardar la consulta a editar
        setTitle("Editar Consulta");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Etiquetas y campos de texto
        JLabel lblIdTipo = new JLabel("ID Tipo:");
        lblIdTipo.setBounds(20, 20, 100, 25);
        add(lblIdTipo);

        txtIdTipo = new JTextField(String.valueOf(consulta.getIdTipo()));
        txtIdTipo.setBounds(150, 20, 200, 25);
        add(txtIdTipo);

        JLabel lblDescripcion = new JLabel("Descripción:");
        lblDescripcion.setBounds(20, 60, 100, 25);
        add(lblDescripcion);

        txtDescripcion = new JTextArea(consulta.getDescripcion());
        txtDescripcion.setBounds(150, 60, 200, 100);
        add(txtDescripcion);

        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setBounds(20, 180, 100, 25);
        add(lblEstado);

        txtEstado = new JTextField(consulta.getEstado());
        txtEstado.setBounds(150, 180, 200, 25);
        add(txtEstado);

        JLabel lblRespuesta = new JLabel("Respuesta:");
        lblRespuesta.setBounds(20, 220, 100, 25);
        add(lblRespuesta);

        txtRespuesta = new JTextField(consulta.getRespuesta());
        txtRespuesta.setBounds(150, 220, 200, 25);
        add(txtRespuesta);

        JLabel lblIdUsuario = new JLabel("ID Usuario:");
        lblIdUsuario.setBounds(20, 260, 100, 25);
        add(lblIdUsuario);

        txtIdUsuario = new JTextField(String.valueOf(consulta.getIdUsuario()));
        txtIdUsuario.setBounds(150, 260, 200, 25);
        add(txtIdUsuario);

        JLabel lblIdSoporteTecnico = new JLabel("ID Soporte Técnico:");
        lblIdSoporteTecnico.setBounds(20, 300, 150, 25);
        add(lblIdSoporteTecnico);

        txtIdSoporteTecnico = new JTextField(String.valueOf(consulta.getIdSoporteTecnico()));
        txtIdSoporteTecnico.setBounds(150, 300, 200, 25);
        add(txtIdSoporteTecnico);

        // Botones
        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(50, 340, 100, 30);
        add(btnGuardar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(200, 340, 100, 30);
        add(btnCancelar);

        // Acción para guardar la consulta
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarConsulta();
            }
        });

        // Acción para cancelar
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra el formulario
            }
        });
    }

    private void guardarConsulta() {
        try {
            // Obtener los datos del formulario
            int idTipo = Integer.parseInt(txtIdTipo.getText());
            String descripcion = txtDescripcion.getText();
            String estado = txtEstado.getText();
            String respuesta = txtRespuesta.getText();
            int idUsuario = Integer.parseInt(txtIdUsuario.getText());
            int idSoporteTecnico = Integer.parseInt(txtIdSoporteTecnico.getText());

            // Actualizar la consulta
            consulta.setIdTipo(idTipo);
            consulta.setDescripcion(descripcion);
            consulta.setEstado(estado);
            consulta.setRespuesta(respuesta);
            consulta.setIdUsuario(idUsuario);
            consulta.setIdSoporteTecnico(idSoporteTecnico);

            ConsultaDAO consultaDAO = new ConsultaDAO();

            // Guardar la consulta en la base de datos
            if (consultaDAO.updateConsulta(consulta)) {
                JOptionPane.showMessageDialog(this, "Consulta actualizada con éxito.");
                dispose(); // Cierra el formulario
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar la consulta.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa valores válidos.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al actualizar la consulta: " + ex.getMessage());
        }
    }
}