package view;

import dao.UsuarioDAO;
import model.Usuario;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuarioForm extends JFrame {
    private JTextField txtNombre;
    private JTextField txtAp;
    private JTextField txtAm;
    private JTextField txtEdad;
    private JTextField txtCorreo;
    private JTextField txtTelefono;
    private JTextField txtFechanacimiento;
    private JTextField txtNivelestudios;
    private JTextField txtContraseña;
    private JTextField txtIdgenero;
    private JButton btnSave;

    public UsuarioForm() {
        setTitle("Agregar Usuario");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 20, 100, 30);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(150, 20, 200, 30);
        add(txtNombre);

        JLabel lblAp = new JLabel("Apellido Paterno:");
        lblAp.setBounds(20, 60, 120, 30);
        add(lblAp);

        txtAp = new JTextField();
        txtAp.setBounds(150, 60, 200, 30);
        add(txtAp);

        JLabel lblAm = new JLabel("Apellido Materno:");
        lblAm.setBounds(20, 100, 120, 30);
        add(lblAm);

        txtAm = new JTextField();
        txtAm.setBounds(150, 100, 200, 30);
        add(txtAm);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(20, 140, 100, 30);
        add(lblEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(150, 140, 200, 30);
        add(txtEdad);

        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setBounds(20, 180, 100, 30);
        add(lblCorreo);

        txtCorreo = new JTextField();
        txtCorreo.setBounds(150, 180, 200, 30);
        add(txtCorreo);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(20, 220, 100, 30);
        add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(150, 220, 200, 30);
        add(txtTelefono);

        JLabel lblFechanacimiento = new JLabel("Fecha Nacimiento:");
        lblFechanacimiento.setBounds(20, 260, 120, 30);
        add(lblFechanacimiento);

        txtFechanacimiento = new JTextField();
        txtFechanacimiento.setBounds(150, 260, 200, 30);
        add(txtFechanacimiento);

        JLabel lblNivelestudios = new JLabel("Nivel Estudios:");
        lblNivelestudios.setBounds(20, 300, 100, 30);
        add(lblNivelestudios);

        txtNivelestudios = new JTextField();
        txtNivelestudios.setBounds(150, 300, 200, 30);
        add(txtNivelestudios);

        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setBounds(20, 340, 100, 30);
        add(lblContraseña);

        txtContraseña = new JTextField();
        txtContraseña.setBounds(150, 340, 200, 30);
        add(txtContraseña);

        JLabel lblIdgenero = new JLabel("ID Género:");
        lblIdgenero.setBounds(20, 380, 100, 30);
        add(lblIdgenero);

        txtIdgenero = new JTextField();
        txtIdgenero.setBounds(150, 380, 200, 30);
        add(txtIdgenero);

        btnSave = new JButton("Guardar");
        btnSave.setBounds(150, 420, 100, 30);
        add(btnSave);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveUsuario();
            }
        });
    }

    private void saveUsuario() {
        String nombre = txtNombre.getText();
        String ap = txtAp.getText();
        String am = txtAm.getText();
        int edad = Integer.parseInt(txtEdad.getText());
        String correo = txtCorreo.getText();
        String telefono = txtTelefono.getText();
        String fechanacimiento = txtFechanacimiento.getText();
        String nivelestudios = txtNivelestudios.getText();
        String contraseña = txtContraseña.getText();
        int idgenero = Integer.parseInt(txtIdgenero.getText());

        Usuario usuario = new Usuario(0, nombre, ap, am, edad, correo, telefono, fechanacimiento, nivelestudios, contraseña, idgenero);
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        try {
            if (usuarioDAO.insertUsuario(usuario)) {
                JOptionPane.showMessageDialog(this, "Usuario guardado exitosamente.");
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar el usuario.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void clearFields() {
        txtNombre.setText("");
        txtAp.setText("");
        txtAm.setText("");
        txtEdad.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        txtFechanacimiento.setText("");
        txtNivelestudios.setText("");
        txtContraseña.setText("");
        txtIdgenero.setText("");
    }
}