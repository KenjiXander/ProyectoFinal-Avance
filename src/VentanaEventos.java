import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    private JList list1;
    private JPasswordField passwordField2;

    private List<Usuario> listaUsuarios = new ArrayList<>();
    private int contadorId = 1;
    private Usuario usuarioActual = null;
    private Admin admin = new Admin();

    public VentanaEventos() {

        listaUsuarios.add(new Usuario(0, "admin", "Administrador", "admin", "direccion", "099485124"));

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

                for (Usuario us : listaUsuarios) {
                    if (us.getUsuario().equals(usuario) && us.getContra().equals(pass)) {
                        encontrado = true;
                        usuarioActual = us;
                        JOptionPane.showMessageDialog(null, "Has iniciado sesion correctamente");
                        inicioValor.setText("Bienvenido " + us.getUsuario());
                        textField1.setText("");
                        passwordField1.setText("");
                        errorInicio.setText("");

                        if (us.getId() == 0) {
                            registroPanel.setSelectedIndex(3);
                        } else {
                            registroPanel.setSelectedIndex(0);
                        }

                        break;
                    }
                }

                if (!encontrado) {
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
                String contra = new String(passwordField2.getPassword());
                String direccion = textField6.getText();
                String telefono = textField7.getText();

                if (!nombre.matches("[a-zA-Z ]+")) {
                    JOptionPane.showMessageDialog(null, "El nombre solo puede contener letras y espacios.");
                    return;
                }
                if (!telefono.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "El teléfono solo puede contener números.");
                    return;
                }

                boolean usuarioExistente = false;
                for (Usuario user : listaUsuarios) {
                    if (user.getUsuario().equals(usuario)) {
                        usuarioExistente = true;
                        break;
                    }
                }

                if (usuarioExistente) {
                    JOptionPane.showMessageDialog(null, "El usuario que ingresaste ya se encuentra en el sistema");
                } else {
                    Usuario nuevoUsuario = new Usuario(contadorId++, usuario, nombre, contra, direccion, telefono);
                    listaUsuarios.add(nuevoUsuario);
                    JOptionPane.showMessageDialog(null, "Usuario creado exitosamente");

                    textField3.setText("");
                    textField4.setText("");
                    passwordField2.setText("");
                    textField6.setText("");
                    textField7.setText("");
                }
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
                int selectedIndex = registroPanel.getSelectedIndex();
                if ((selectedIndex == 3 || selectedIndex == 5 || selectedIndex == 6 || selectedIndex == 7) &&
                        (usuarioActual == null || usuarioActual.getId() != 0)) {
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

                String[] fechaEscoger = textField10.getText().split("/");
                int dia = Integer.parseInt(fechaEscoger[0]);
                int mes = Integer.parseInt(fechaEscoger[1]);
                int anio = Integer.parseInt(fechaEscoger[2]);

                Calendar calendarioActual = Calendar.getInstance();
                calendarioActual.setTime(new Date());
                int diaActual = calendarioActual.get(Calendar.DAY_OF_MONTH);
                int mesActual = calendarioActual.get(Calendar.MONTH) + 1;
                int anioActual = calendarioActual.get(Calendar.YEAR);

                if(anio < anioActual || (anio == anioActual && mes < mesActual) || (anio == anioActual && mes == mesActual && dia < diaActual)){
                    JOptionPane.showMessageDialog(null, "La fecha ingresada no puede ser anterior a la actual");
                    return;
                }

                if (mes < 1 || mes > 12) {
                    JOptionPane.showMessageDialog(null, "El mes debe estar entre 1 y 12");
                    return;
                }

                int diasEnMes = 31;
                if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                    diasEnMes = 30;
                } else if (mes == 2) {
                    if ((anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0) {
                        diasEnMes = 29;
                    } else {
                        diasEnMes = 28;
                    }
                }

                if (dia < 1 || dia > diasEnMes) {
                    JOptionPane.showMessageDialog(null, "El día debe estar entre 1 y " + diasEnMes + " para el mes seleccionado");
                    return;
                }

                String error = admin.agregarEvento(nombreEvento, ciudad, dia, mes, anio);
                if(error != null){
                    JOptionPane.showMessageDialog(null,error);
                } else{
                    actualizarEventos();
                }



                textField2.setText("");
                comboBox1.setSelectedIndex(0);
                textField10.setText("");
            }
        });
        crearNuevoEventoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registroPanel.setSelectedIndex(7);
            }
        });


        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = list1.getSelectedIndex();
                if (index != -1) {
                    Evento eventoSeleccionado = admin.getListaEventos().get(index);
                    textField2.setText(eventoSeleccionado.getNombreEvento());
                    comboBox1.setSelectedItem(eventoSeleccionado.getCiudadEvento());
                    textField10.setText(eventoSeleccionado.getDia() + "/" + eventoSeleccionado.getMes() + "/" + eventoSeleccionado.getAnio());

                }
            }
        });

        modificarEventoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = list1.getSelectedIndex();
                if (index != -1) {
                    Evento eventoSeleccionado = admin.getListaEventos().get(index);
                    eventoSeleccionado.setNombreEvento(textField2.getText());
                    eventoSeleccionado.setCiudadEvento(comboBox1.getSelectedItem().toString());

                    String[] fechaEscoger = textField10.getText().split("/");
                    int dia = Integer.parseInt(fechaEscoger[0]);
                    int mes = Integer.parseInt(fechaEscoger[1]);
                    int anio = Integer.parseInt(fechaEscoger[2]);

                    eventoSeleccionado.setDia(dia);
                    eventoSeleccionado.setMes(mes);
                    eventoSeleccionado.setAnio(anio);
                    actualizarEventos();
                }
            }
        });


    }


    private void actualizarEventos(){

        DefaultListModel<String> dlm = new DefaultListModel<>();

        for(Evento ev: admin.getListaEventos()){
            dlm.addElement(ev.toString());
        }

        list1.setModel(dlm);

        eventoPane1.setText("");
        eventoPane2.setText("");
        eventoPane3.setText("");
        eventoPane4.setText("");

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
