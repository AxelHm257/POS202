package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuarioAdminMenu extends JFrame {
    public UsuarioAdminMenu() {
        setTitle("Administración de Usuarios");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JButton btnAgregarUsuario = new JButton("Agregar Usuario");
        btnAgregarUsuario.setBounds(50, 30, 200, 30);
        add(btnAgregarUsuario);

        JButton btnListarUsuarios = new JButton("Listar Usuarios");
        btnListarUsuarios.setBounds(50, 80, 200, 30);
        add(btnListarUsuarios);

        btnAgregarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UsuarioForm().setVisible(true);
            }
        });

        btnListarUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UsuarioList().setVisible(true);
            }
        });
    }
}