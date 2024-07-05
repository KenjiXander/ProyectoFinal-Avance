import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    private JTextField textField6;
    private JTextField textField7;
    private JButton crearUsuarioButton;
    private JButton crearNuevoEventoButton;
    private JButton buscarButton;
    private JPasswordField passwordField1;
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
    private JButton agregarEventoButton;
    private JTextField idEvento;
    private JComboBox ciudadEventoCombo;
    private JTextField nombreEvento;
    private JTextField horaEvento;
    private JTextField fechaEvento;
    private JButton modificarEventoButton;
    private JPasswordField passwordField2;
    private JComboBox comboBox2;
    private JTextField textField5;
    private JList list2;
    private JComboBox comboBox3;
    private JList list4;
    private JComboBox comboBox5;
    private JTextField nombreLoca;
    private JButton agregarLocalidadButton;
    private JList listaLocalidad;
    private JTextField textField17;
    private JTextField textField18;
    private JList list6;
    private JButton agregarArtistaButton;
    private JButton modificarArtistaButton;
    private JList list7;
    private JComboBox comboBox4;
    private JSpinner spinner1;
    private JButton agregarAlCarritoButton;
    private JList list8;
    private JTextField textField19;
    private JButton eliminarDelCarritoButton;
    private JButton unirseALaColaButton;
    private JTextField textField20;
    private JTextField textField21;
    private JTextField textField22;
    private JTextField textField23;
    private JTextField textField24;
    private JComboBox comboBox6;
    private JButton modificarUsuarioButton;
    private JList list9;
    private JComboBox localidadEventoCombo;
    private JSpinner aforoEvento;
    private JButton modificarLocalidadButton;
    private JSpinner spinnerLocalidad;
    private JComboBox artistaCombo;
    private JCheckBox generalCheck;
    private JCheckBox platinumCheck;
    private JCheckBox vipCheck;
    private JTextField generalField;
    private JTextField platinumField;
    private JTextField vipField;
    private JTextField generalPrecio;
    private JTextField platinumPrecio;
    private JTextField vipPrecio;

    private List<Usuario> listaUsuarios = new ArrayList<>();
    private List<Artista> listaArtistas = new ArrayList<>();
    private List<Localidad> localidades = new ArrayList<>();
    private DefaultListModel<Evento> modeloEventos = new DefaultListModel<>();

    private int contadorId = 1;
    private Usuario usuarioActual = null;

    public VentanaEventos() {

        listaUsuarios.add(new Usuario(0, "admin", "Administrador", "admin", "direccion", "099485124", "Masculino"));

        for (int i = 2; i < registroPanel.getTabCount(); i++) {
            registroPanel.setEnabledAt(i, false);
        }

        irARegistroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registroPanel.setSelectedIndex(0);
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

                        if(usuarioActual.getUsuario().equals("admin")){
                            for(int i = 2; i < registroPanel.getTabCount(); i++){
                                registroPanel.setEnabledAt(i, true);
                            }
                        } else{
                            for(int i = 2; i < registroPanel.getTabCount(); i++){
                                registroPanel.setEnabledAt(i, true);
                            }
                            for(int i = 4; i < registroPanel.getTabCount(); i++){
                                registroPanel.setEnabledAt(i, false);
                            }
                        }
                        registroPanel.setEnabledAt(1, false);
                        registroPanel.setSelectedIndex(2);

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


        crearUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textField3.getText();
                String usuario = textField4.getText();
                String contra = new String(passwordField2.getPassword());
                String direccion = textField6.getText();
                String telefono = textField7.getText();
                String genero = comboBox2.getSelectedItem().toString();

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
                    Usuario nuevoUsuario = new Usuario(contadorId++, usuario, nombre, contra, direccion, telefono, genero);
                    listaUsuarios.add(nuevoUsuario);
                    JOptionPane.showMessageDialog(null, "Usuario creado exitosamente");

                    textField3.setText("");
                    textField4.setText("");
                    passwordField2.setText("");
                    textField6.setText("");
                    textField7.setText("");
                    comboBox2.setSelectedIndex(0);

                    list9.setListData(listaUsuarios.toArray(new Usuario[0])); //revisar toArray
                }
            }
        });

        inicioDeSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(usuarioActual == null){
                    registroPanel.setSelectedIndex(1);
                }
            }
        });
        cerrarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuarioActual = null;
                inicioValor.setText("No has iniciado sesion");

                registroPanel.setEnabledAt(1, true);

                for (int i = 2; i < registroPanel.getTabCount(); i++) {
                    registroPanel.setEnabledAt(i, false);
                }
            }
        });


        list9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int indiceSeleccionado = list9.getSelectedIndex();

                if(indiceSeleccionado != -1){
                    Usuario usuarioSeleccionado = listaUsuarios.get(indiceSeleccionado);
                    textField20.setText(usuarioSeleccionado.getNombre());
                    textField21.setText(usuarioSeleccionado.getUsuario());
                    textField22.setText(usuarioSeleccionado.getContra());
                    textField23.setText(usuarioSeleccionado.getDireccion());
                    textField24.setText(usuarioSeleccionado.getTelefono());
                    comboBox6.setSelectedItem(usuarioSeleccionado.getGenero());
                }
            }
        });
        modificarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceSeleccionado = list9.getSelectedIndex();
                if(indiceSeleccionado != -1){
                    Usuario usuarioSeleccionado = listaUsuarios.get(indiceSeleccionado);
                    usuarioSeleccionado.setNombre(textField20.getText());
                    usuarioSeleccionado.setUsuario(textField21.getText());
                    usuarioSeleccionado.setContra(textField22.getText());
                    usuarioSeleccionado.setDireccion(textField23.getText());
                    usuarioSeleccionado.setTelefono(textField24.getText());
                    usuarioSeleccionado.setGenero(comboBox6.getSelectedItem().toString());

                    list9.setListData(listaUsuarios.toArray(new Usuario[0]));
                }
            }
        });
        irAInicioDeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(usuarioActual == null){
                    registroPanel.setSelectedIndex(1);
                }
            }
        });
        agregarArtistaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreArtista = textField18.getText();

                Artista nuevoArtista = new Artista(nombreArtista);

                listaArtistas.add(nuevoArtista);

                DefaultListModel<Artista> listModel = new DefaultListModel<>();
                for(Artista artista:listaArtistas){
                    listModel.addElement(artista);
                }
                list6.setModel(listModel);

                actualizarComboBoxArtistas();
                textField18.setText("");
            }
        });
        list6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int indiceSeleccionado = list6.getSelectedIndex();

                if(indiceSeleccionado != -1){
                    Artista artistaSeleccionado = listaArtistas.get(indiceSeleccionado);
                    textField18.setText(artistaSeleccionado.getNombreArtista());
                }
            }
        });
        modificarArtistaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceSeleccionado = list6.getSelectedIndex();

                if(indiceSeleccionado != -1){
                    String nombreArtista = textField18.getText();

                    Artista artistaModificado = new Artista(nombreArtista);
                    listaArtistas.set(indiceSeleccionado, artistaModificado);

                    DefaultListModel<Artista> listModel = new DefaultListModel<>();
                    for(Artista artista:listaArtistas){
                        listModel.addElement(artista);
                    }
                    list6.setModel(listModel);
                    textField18.setText("");
                }
            }
        });
        agregarLocalidadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreLocalidad = nombreLoca.getText();
                int capacidadLocalidad = (int) spinnerLocalidad.getValue(); //Revisar este el (int)

                Localidad nuevaLocalidad = new Localidad(nombreLocalidad, capacidadLocalidad);
                localidades.add(nuevaLocalidad);

                actualizarListaLocalidades();
                limpiarCamposLocalidad();
                actualizarComboBoxLocalidades();

            }
        });
        listaLocalidad.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int indiceSeleccionado = listaLocalidad.getSelectedIndex();

                if(indiceSeleccionado != -1){
                    Localidad localidadSeleccionada = localidades.get(indiceSeleccionado);
                    nombreLoca.setText(localidadSeleccionada.getNombreLocalidad());
                    spinnerLocalidad.setValue(localidadSeleccionada.getCapacidadLocalidad());
                }
            }
        });
        modificarLocalidadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceSeleccionado = listaLocalidad.getSelectedIndex();

                if(indiceSeleccionado != -1){
                    String nombreLocalidad = nombreLoca.getText();
                    int capacidadLocalidad = (int) spinnerLocalidad.getValue(); //revisar (int)

                    Localidad localidadModificada = new Localidad(nombreLocalidad, capacidadLocalidad);
                    localidades.set(indiceSeleccionado, localidadModificada);

                    actualizarListaLocalidades();
                    limpiarCamposLocalidad();
                }
            }
        });
        localidadEventoCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreSeleccionado = (String) localidadEventoCombo.getSelectedItem(); //revisar (String)
                int capacidad = obtenerCapacidadEvento(nombreSeleccionado);
                aforoEvento.setValue(capacidad);
            }
        });
        agregarEventoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idEvento.getText());
                    String nombre = nombreEvento.getText();
                    String ciudad = ciudadEventoCombo.getSelectedItem().toString();
                    String localidad = localidadEventoCombo.getSelectedItem().toString();
                    String hora = horaEvento.getText();
                    String fecha = fechaEvento.getText();
                    String genero = comboBox5.getSelectedItem().toString();
                    int aforo = (int) aforoEvento.getValue(); //revisar (int)
                    String artista = artistaCombo.getSelectedItem().toString();
                    boolean general = generalCheck.isSelected();
                    int generalCantidad = general ? Integer.parseInt(generalField.getText()) : 0;
                    double generalPrecioValor = general ? Double.parseDouble(generalPrecio.getText()) : 0.0;
                    boolean platinum = platinumCheck.isSelected();
                    int platinumCantidad = platinum ? Integer.parseInt(platinumField.getText()) : 0;
                    double platinumPrecioValor = platinum ? Double.parseDouble(platinumPrecio.getText()) : 0.0;
                    boolean vip = vipCheck.isSelected();
                    int vipCantidad = vip ? Integer.parseInt(vipField.getText()) : 0;
                    double vipPrecioValor = vip ? Double.parseDouble(vipPrecio.getText()) : 0.0;

                    int totalButacas = generalCantidad + platinumCantidad + vipCantidad;

                    if (!nombre.matches("[a-zA-Z ]+")) {
                        JOptionPane.showMessageDialog(null, "El nombre del evento solo puede contener letras y espacios.");
                        return;
                    }

                    if (!idEvento.getText().matches("\\d+")) {
                        JOptionPane.showMessageDialog(null, "El ID del evento solo puede contener números.");
                        return;
                    }

                    if (!hora.matches("\\d{2}:\\d{2}")) {
                        JOptionPane.showMessageDialog(null, "El formato de hora debe ser hh:mm.");
                        return;
                    }

                    if (!fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
                        JOptionPane.showMessageDialog(null, "El formato de fecha debe ser dd/mm/aaaa.");
                        return;
                    }

                    LocalDate fechaActual = LocalDate.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate fechaEvento = LocalDate.parse(fecha, formatter);

                    if (fechaEvento.isBefore(fechaActual)) {
                        JOptionPane.showMessageDialog(null, "La fecha del evento no puede ser menor a la fecha actual.");
                        return;
                    }

                    if (comboBox5.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Debes escoger un género musical para el evento.");
                        return;
                    }

                    if (ciudadEventoCombo.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Debes escoger una ciudad para el evento.");
                        return;
                    }

                    if (localidadEventoCombo.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Debes escoger una localidad para el evento.");
                        return;
                    }

                    if (artistaCombo.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Debes escoger un artista para el evento.");
                        return;
                    }

                    if (totalButacas != aforo) {
                        JOptionPane.showMessageDialog(null, "Debes asignar todos los asientos disponibles sin pasarte del total.");
                        return;
                    }


                    Evento evento = new Evento(id, nombre, ciudad, localidad, hora, fecha, genero, aforo, artista, general, generalCantidad, generalPrecioValor, platinum, platinumCantidad, platinumPrecioValor, vip, vipCantidad, vipPrecioValor);
                    modeloEventos.addElement(evento);
                    list4.setModel(modeloEventos);
                    limpiarAgregarEvento();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al agregar evento: " + ex.getMessage());
                }
            }
        });
    }




    private void actualizarListaLocalidades(){
        DefaultListModel<Localidad> model = new DefaultListModel<>();
        for(Localidad localidad:localidades){
            model.addElement(localidad);
        }
        listaLocalidad.setModel(model);
    }

    private void limpiarCamposLocalidad(){
        nombreLoca.setText("");
        spinnerLocalidad.setValue(0);
    }


    private int obtenerCapacidadEvento(String nombreEvento){
        for(Localidad localidad:localidades){
            if(localidad.getNombreLocalidad().equals(nombreEvento)){
                return localidad.getCapacidadLocalidad();
            }
        }
        return 0;
    }

    private void actualizarComboBoxArtistas(){
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("Escoger artista...");
        for (Artista artista : listaArtistas) {
            model.addElement(artista.getNombreArtista());
        }
        artistaCombo.setModel(model);
    }

    private void actualizarComboBoxLocalidades(){
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("Escoger localidad...");
        for (Localidad localidad : localidades) {
            model.addElement(localidad.getNombreLocalidad());
        }
        localidadEventoCombo.setModel(model);
    }

    private void limpiarAgregarEvento(){
        idEvento.setText("");
        nombreEvento.setText("");
        ciudadEventoCombo.setSelectedIndex(0);
        localidadEventoCombo.setSelectedIndex(0);
        horaEvento.setText("");
        fechaEvento.setText("");
        comboBox5.setSelectedIndex(0);
        aforoEvento.setValue(0);
        artistaCombo.setSelectedIndex(0);
        generalCheck.setSelected(false);
        generalField.setText("");
        generalPrecio.setText("");
        platinumCheck.setSelected(false);
        platinumField.setText("");
        platinumPrecio.setText("");
        vipCheck.setSelected(false);
        vipField.setText("");
        vipPrecio.setText("");
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaEventos");
        frame.setContentPane(new VentanaEventos().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(900,800);
        frame.setLocationRelativeTo(null);
    }

}