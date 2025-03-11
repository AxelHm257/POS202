import javax.swing.*;
import java.awt.*;

public class DashboardUI extends JFrame {
    public DashboardUI() {
        setTitle("Dashboard");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Panel lateral
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
        sidePanel.setBackground(new Color(33, 66, 178));
        sidePanel.setPreferredSize(new Dimension(120, getHeight()));
        sidePanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.WHITE)); // Borde de separación

        // Cargar iconos de imagen y redimensionarlos
        ImageIcon homeIcon = new ImageIcon("C:\\Users\\Daniel Horta\\Documents\\home.png");
        ImageIcon statsIcon = new ImageIcon("C:\\Users\\Daniel Horta\\Documents\\Stats.png");
        ImageIcon settingsIcon = new ImageIcon("C:\\Users\\Daniel Horta\\Documents\\settings.png");

        // Ajustar el tamaño de los iconos (ajustar a 40x40 píxeles)
        homeIcon = new ImageIcon(homeIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        statsIcon = new ImageIcon(statsIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        settingsIcon = new ImageIcon(settingsIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));

        // Botones con iconos
        JButton btnHome = new JButton(homeIcon);
        JButton btnStats = new JButton(statsIcon);
        JButton btnSettings = new JButton(settingsIcon);

        // Configurar los botones
        for (JButton btn : new JButton[]{btnHome, btnStats, btnSettings}) {
            btn.setBackground(new Color(33, 66, 178));
            btn.setForeground(Color.WHITE);
            btn.setFont(new Font("Arial", Font.BOLD, 24));
            btn.setFocusPainted(false);
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            btn.setPreferredSize(new Dimension(100, 60)); // Ajustar tamaño del botón
            sidePanel.add(Box.createVerticalStrut(20)); // Espaciado entre botones
            sidePanel.add(btn);
        }

        add(sidePanel, BorderLayout.WEST);

        // Panel principal con gráfico y botones
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Panel para los gráficos (reemplazado por un JPanel)
        JPanel chartPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Dibujar las barras de forma más detallada
                g.setColor(Color.BLUE);
                g.fillRect(100, 50, 200, 40);
                g.setColor(Color.RED);
                g.fillRect(100, 120, 300, 40);
                g.setColor(Color.GREEN);
                g.fillRect(100, 190, 150, 40);

                // Añadir las etiquetas de cada barra
                g.setColor(Color.BLACK);
                g.drawString("Resma de papel", 100, 45);
                g.drawString("Bolígrafo BIC", 100, 115);
                g.drawString("Carpeta", 100, 185);

                // Añadir títulos
                g.setFont(new Font("Arial", Font.BOLD, 14));
                g.drawString("Artículos más solicitados", 100, 250);

                // Dibujar el eje X
                g.drawLine(80, 230, 700, 230);

                // Dibujar el eje Y
                g.drawLine(80, 50, 80, 230);
            }
        };
        chartPanel.setPreferredSize(new Dimension(700, 400));
        chartPanel.setBackground(Color.WHITE);
        chartPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        // Crear un panel para centrar el gráfico dentro de su contenedor
        JPanel chartContainer = new JPanel();
        chartContainer.setLayout(new BorderLayout());
        chartContainer.add(chartPanel, BorderLayout.CENTER);
        chartContainer.setPreferredSize(new Dimension(700, 400));

        // Centrar el gráfico en la parte superior
        mainPanel.add(chartContainer, BorderLayout.NORTH);

        // Panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));
        buttonPanel.setBackground(new Color(240, 240, 240));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton btnExportPDF = new JButton("EXPORTAR PDF");
        JButton btnExportDepto = new JButton("EXPORTAR POR DEPARTAMENTO PDF");
        JButton btnExportFecha = new JButton("EXPORTAR POR FECHA PDF");

        for (JButton btn : new JButton[]{btnExportPDF, btnExportDepto, btnExportFecha}) {
            btn.setBackground(new Color(33, 66, 178));
            btn.setForeground(Color.WHITE);
            btn.setFont(new Font("Arial", Font.PLAIN, 16));
            btn.setFocusPainted(false);
            buttonPanel.add(btn);
        }

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DashboardUI frame = new DashboardUI();
            frame.setVisible(true);
        });
    }
}
