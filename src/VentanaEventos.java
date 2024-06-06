import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VentanaEventos {
    private JTabbedPane registroPanel;
    private JPanel panel1;
    private JTextField textField1;
    private JButton iniciarSesionButton;
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
    private JTextArea eventoPane2;
    private JTextArea eventoPane3;
    private JTextArea eventoPane4;
    private JTextArea eventoPane1;
    private JButton irAInicioDeButton;
    private JLabel errorInicio;
    private JButton cerrarSesionButton;
    private JButton cerrarSesionButton1;
    private JButton inicioDeSesionButton;
    private JLabel inicioValor;
    private JButton comprarButton;
    private JButton comprarButton1;
    private JButton comprarButton2;
    private JButton comprarButton3;
    private JButton agregarEventoButton;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;

    private List<Usuario> listaUsuarios = new ArrayList<>();
    private int contadorId = 1;
    private Usuario usuarioActual = null;

    public VentanaEventos() {

        listaUsuarios.add(new Usuario(0, "admin", "Administrador", "admin", "direccion", 111));

        irARegistroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registroPanel.setSelectedIndex(2);
            }
        });
        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = textField1.getText();
                String pass = new String(passwordField1.getPassword());


                boolean encontrar = false;

                for (Usuario us : listaUsuarios){
                    if(us.getUsuario().equals(usuario) && us.getContra().equals(pass)){
                        encontrar = true;
                        usuarioActual = us;
                        JOptionPane.showMessageDialog(null, "Has iniciado sesion correctamente");
                        inicioValor.setText("Bienvenido " + us.getUsuario());
                        textField1.setText("");
                        passwordField1.setText("");
                        errorInicio.setText("");

                        if(us.getId() == 0){
                            registroPanel.setSelectedIndex(3);
                        } else{
                            registroPanel.setSelectedIndex(0);
                        }

                        break;
                    }
                }

                if(!encontrar){
                    errorInicio.setText("Las credenciales son erroneas");
                }

            }
        });
        irAInicioDeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registroPanel.setSelectedIndex(1);
            }
        });
        crearUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nombre = textField3.getText();
                String usuario = textField4.getText();
                String contra = textField5.getText();
                String direccion = textField6.getText();
                int telefono = Integer.parseInt(textField7.getText());

                Usuario nuevoUsuario = new Usuario(contadorId++, usuario, nombre, contra, direccion, telefono);
                listaUsuarios.add(nuevoUsuario);

                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
                textField6.setText("");
                textField7.setText("");

                JOptionPane.showMessageDialog(panel1, "Usuario creado exitosamente");
            }
        });
        inicioDeSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registroPanel.setSelectedIndex(1);
            }
        });
        cerrarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuarioActual = null;
                inicioValor.setText("No has iniciado sesion");
            }
        });
        cerrarSesionButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuarioActual = null;
                inicioValor.setText("No has iniciado sesion");
                registroPanel.setSelectedIndex(1);
            }
        });
        registroPanel.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(registroPanel.getSelectedIndex() == 3 && (usuarioActual == null || usuarioActual.getId() != 0)){
                    JOptionPane.showMessageDialog(null, "Solo el administrador puede acceder a esta pestaña");
                    registroPanel.setSelectedIndex(1);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaEventos");
        frame.setContentPane(new VentanaEventos().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(700,800);
        frame.setLocationRelativeTo(null);
    }
}
