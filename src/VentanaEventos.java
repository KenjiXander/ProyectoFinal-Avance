import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEventos {
    private JTabbedPane registroPanel;
    private JPanel panel1;
    private JTextField textField1;
    private JButton iniciarSesiónButton;
    private JButton irARegistroButton;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JButton crearUsuarioButton;
    private JButton crearNuevoEventoButton;
    private JButton modificarEventosButton;
    private JButton gestionarPromocionesButton;
    private JButton gestionarUsuariosButton;
    private JPasswordField passwordField1;
    private JButton salirDeLaColaButton;


    public VentanaEventos() {
        irARegistroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registroPanel.setSelectedIndex(1);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaEventos");
        frame.setContentPane(new VentanaEventos().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
    }
}
