import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
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
    private JButton modificarEventoButton;
    private JTextArea eventosArea;

    private List<Usuario> listaUsuarios = new ArrayList<>();
    private int contadorId = 1;
    private Usuario usuarioActual = null;
    private Admin admin = new Admin();

    private JPanel panelEventos;
    private JPanel panelAdmin;

    public VentanaEventos() {

        listaUsuarios.add(new Usuario(0, "admin", "Administrador", "admin", "direccion", 111));

        panelEventos = (JPanel) registroPanel.getComponentAt(0);
        panelAdmin = (JPanel) registroPanel.getComponentAt(3);


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


                boolean encontrado = false;

                for (Usuario us : listaUsuarios){
                    if(us.getUsuario().equals(usuario) && us.getContra().equals(pass)){
                        encontrado = true;
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

                if(!encontrado){
                    errorInicio.setText("Las credenciales son erroneas");
                    textField1.setText("");
                    passwordField1.setText("");
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
        agregarEventoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreEvento = textField2.getText();
                String ciudad = comboBox1.getSelectedItem().toString();
                int dia = Integer.parseInt(textField8.getText());
                int mes = Integer.parseInt(textField9.getText());
                int anio = Integer.parseInt(textField10.getText());

                String error = admin.agregarEvento(nombreEvento, ciudad, dia, mes, anio);
                if(error != null){
                    JOptionPane.showMessageDialog(null,error);
                } else{
                    actualizarEventos();
                }



                textField2.setText("");
                comboBox1.setSelectedIndex(0);
                textField8.setText("");
                textField9.setText("");
                textField10.setText("");
            }
        });
        crearNuevoEventoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registroPanel.setSelectedIndex(7);
            }
        });
    }


    private void actualizarEventos(){
        eventosArea.setText("");
        eventoPane1.setText("");
        eventoPane2.setText("");
        eventoPane3.setText("");
        eventoPane4.setText("");
        for(Evento evento: admin.getListaEventos()){
            eventosArea.append(evento.toString()+"\n");
        }

        for(Evento ev:admin.getListaEventos()){
            switch (ev.getIdEvento()){
                case 1:
                    eventoPane1.setText(ev.toString());
                    break;
                case 2:
                    eventoPane2.setText(ev.toString());
                    break;
                case 3:
                    eventoPane3.setText(ev.toString());
                    break;
                case 4:
                    eventoPane4.setText(ev.toString());
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "La lista de eventos esta llena");
                    break;
            }
        }


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
