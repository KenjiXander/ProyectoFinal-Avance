import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import CapaNegocio.*;
import CapaEstructuras.Navegar;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
    private JButton ordenarButton;
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
    private JTextField nombreNavTF;
    private JList navList;
    private JComboBox generoMusicalNavCB;
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
    private JButton comprarButton;
    private JButton buscarPorNombreButton;
    private JComboBox artistaNavCB;
    private JButton buscarPorArtistaButton;
    private JTextField fechaNavTF;
    private JButton buscarPorFechaButton;
    private JButton buscarPorGeneroButton;
    private JComboBox localidadNavCB;
    private JButton buscarPorLocalidadButton;
    private JComboBox ciudadNavCB;
    private JButton buscarPorCiudadButton;
    private JTextField generoArtistaTF;
    private JList list1;
    private JSpinner spinner2;
    private JTextField textField2;
    private JTextField textField5;
    private JButton agregarPublicidadButton;
    private JList list2;
    private JComboBox comboBox1;
    private JButton limpiarButton;
    private JButton limpiarButton1;
    private JButton limpiarButton2;
    private JList list3;
    private JButton limpiarButton3;

    private Evento evento = new Evento();
    private Usuario usuario = new Usuario();
    Navegar navegar = new Navegar(usuario.listaEventos);


    private int contadorId = 1;
    private Usuario usuarioActual = null;

    public VentanaEventos() {

        usuario.listaUsuarios.add(new Usuario(0, "admin", "Administrador", "admin", "direccion", "099485124", "Masculino"));
        usuario.listaUsuarios.add(new Usuario(1, "ray", "Ray", "ray", "direccion", "099485124", "Masculino"));
        usuario.listaUsuarios.add(new Usuario(2, "richi", "Richi", "richi", "direccion", "099485124", "Masculino"));
        usuario.listaUsuarios.add(new Usuario(3, "mati", "Mati", "mati", "direccion", "099485124", "Masculino"));
        usuario.listaUsuarios.add(new Usuario(4, "kenji", "Kenji", "kenji", "direccion", "099485124", "Masculino"));
        evento.listaArtistas.add(new Artista("Morat"));
        evento.listaArtistas.add(new Artista("Falling in reverse"));
        evento.listaArtistas.add(new Artista("Nirvana"));
        evento.listaLocalidades.add(new Localidad("Estadio Olimpico Atahualpa",1000,true,500,50,true,300,100,true,200,200));
        evento.listaLocalidades.add(new Localidad("Coliseo General Rumiñahui",2000,true,1500,60,true,300,120,true,200,220));
        evento.listaLocalidades.add(new Localidad("Paseo San Francisco",500,true,350,50,true,100,100,true,50,200));
        //usuario.listaEventos.addElement(new Evento(1,"Morat en Quito","Quito","Estadio Olimpico Atahualpa","15:30","15/12/2024","Pop",1000,"Morat"));
        Evento eventoMorat = new Evento(1, "Morat en Quito", "Quito", "Estadio Olimpico Atahualpa", "15:30", "15/12/2024", "Pop", 1000, "Morat");
        eventoMorat.listaLocalidades.add(new Localidad("Estadio Olimpico Atahualpa", 1000, true, 500, 50, true, 300, 100, true, 200, 200));
        usuario.listaEventos.addElement(eventoMorat);

        actualizarListaArtistas();
        actualizarComboBoxArtistas();
        agregarUsuarioLista();
        actualizarComboBoxLocalidades();
        actualizarListaLocalidades();
        actualizarEventos();

        desabilitarPestanas();
        comboBox4.setModel(new DefaultComboBoxModel<>());

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

                verificarInicioSesion(usuario,pass,encontrado);


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
                String usuarioField = textField4.getText();
                String contra = new String(passwordField2.getPassword());
                String direccion = textField6.getText();
                String telefono = textField7.getText();
                String genero = comboBox2.getSelectedItem().toString();

                if (!nombre.matches("[a-zA-Z ]+")) {
                    JOptionPane.showMessageDialog(null, "El nombre solo puede contener letras y espacios.");
                    return;
                }
                if (!direccion.matches("[a-zA-Z ]+")) {
                    JOptionPane.showMessageDialog(null, "La dirección solo puede contener letras y espacios.");
                    return;
                }
                if (!usuarioField.matches("^[a-zA-Z][a-zA-Z0-9]*$")) {
                    JOptionPane.showMessageDialog(null, "El usuario solo puede contener letras y números, y debe empezar con una letra.");
                    return;
                }
                if (!telefono.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "El teléfono solo puede contener números.");
                    return;
                }

                boolean usuarioExistente = false;
                for (Usuario user : usuario.listaUsuarios) {
                    if (user.getUsuario().equals(usuarioField)) {
                        usuarioExistente = true;
                        break;
                    }
                }

                if (usuarioExistente) {
                    JOptionPane.showMessageDialog(null, "El usuario que ingresaste ya se encuentra en el sistema.");
                } else {
                    Usuario nuevoUsuario = new Usuario(contadorId++, usuarioField, nombre, contra, direccion, telefono, genero);
                    usuario.listaUsuarios.add(nuevoUsuario);
                    JOptionPane.showMessageDialog(null, "Usuario creado exitosamente");

                    agregarUsuarioLista();

                    textField3.setText("");
                    textField4.setText("");
                    passwordField2.setText("");
                    textField6.setText("");
                    textField7.setText("");
                    comboBox2.setSelectedIndex(0);
                }
            }
        });

        inicioDeSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuarioActual == null) {
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
                    Usuario usuarioSeleccionado = usuario.listaUsuarios.get(indiceSeleccionado);
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
                if (indiceSeleccionado != -1) {
                    String nombre = textField20.getText();
                    String usuarioField = textField21.getText();
                    String contra = textField22.getText();
                    String direccion = textField23.getText();
                    String telefono = textField24.getText();
                    String genero = comboBox6.getSelectedItem().toString();

                    if (!nombre.matches("[a-zA-Z ]+")) {
                        JOptionPane.showMessageDialog(null, "El nombre solo puede contener letras y espacios.");
                        return;
                    }
                    if (!direccion.matches("[a-zA-Z ]+")) {
                        JOptionPane.showMessageDialog(null, "La dirección solo puede contener letras y espacios.");
                        return;
                    }
                    if (!usuarioField.matches("^[a-zA-Z][a-zA-Z0-9]*$")) {
                        JOptionPane.showMessageDialog(null, "El usuario solo puede contener letras y números, y debe empezar con una letra.");
                        return;
                    }
                    if (!telefono.matches("\\d+")) {
                        JOptionPane.showMessageDialog(null, "El teléfono solo puede contener números.");
                        return;
                    }

                    boolean usuarioExistente = false;
                    for (Usuario user : usuario.listaUsuarios) {
                        if (user.getUsuario().equals(usuarioField) && user != usuario.listaUsuarios.get(indiceSeleccionado)) {
                            usuarioExistente = true;
                            break;
                        }
                    }

                    if (usuarioExistente) {
                        JOptionPane.showMessageDialog(null, "El usuario que ingresaste ya se encuentra en el sistema.");
                        return;
                    }

                    Usuario usuarioSeleccionado = usuario.listaUsuarios.get(indiceSeleccionado);
                    usuarioSeleccionado.setNombre(nombre);
                    usuarioSeleccionado.setUsuario(usuarioField);
                    usuarioSeleccionado.setContra(contra);
                    usuarioSeleccionado.setDireccion(direccion);
                    usuarioSeleccionado.setTelefono(telefono);
                    usuarioSeleccionado.setGenero(genero);

                    list9.setListData(usuario.listaUsuarios.toArray(new Usuario[0]));
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

                if (!nombreArtista.isEmpty()) {
                    for (Artista artista : evento.listaArtistas) {
                        if (artista.getNombreArtista().equalsIgnoreCase(nombreArtista)) {
                            JOptionPane.showMessageDialog(null, "Ya existe un artista con ese nombre.");
                            return;
                        }
                    }

                    Artista nuevoArtista = new Artista(nombreArtista);
                    evento.agregarArtista(nuevoArtista);

                    DefaultListModel<Artista> listModel = new DefaultListModel<>();
                    for (Artista artista : evento.listaArtistas) {
                        listModel.addElement(artista);
                    }
                    list6.setModel(listModel);

                    actualizarComboBoxArtistas();
                    textField18.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor ingresa el nombre del artista.");
                }
            }
        });
        list6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int indiceSeleccionado = list6.getSelectedIndex();

                if(indiceSeleccionado != -1){
                    Artista artistaSeleccionado = evento.listaArtistas.get(indiceSeleccionado);
                    textField18.setText(artistaSeleccionado.getNombreArtista());
                }
            }
        });
        modificarArtistaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceSeleccionado = list6.getSelectedIndex();

                if (indiceSeleccionado != -1) {
                    String nombreArtista = textField18.getText();

                    if (!nombreArtista.matches("[a-zA-Z ]+")) {
                        JOptionPane.showMessageDialog(null, "El nombre del artista solo puede contener letras y espacios.");
                        return;
                    }

                    Artista artistaModificado = new Artista(nombreArtista);
                    evento.listaArtistas.set(indiceSeleccionado, artistaModificado);

                    DefaultListModel<Artista> listModel = new DefaultListModel<>();
                    for (Artista artista : evento.listaArtistas) {
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
                int capacidadLocalidad;

                if (!nombreLocalidad.matches("[a-zA-Z ]+")) {
                    JOptionPane.showMessageDialog(null, "El nombre de la localidad solo puede contener letras y espacios.");
                    return;
                }

                try {
                    capacidadLocalidad = Integer.parseInt(spinnerLocalidad.getValue().toString());
                    if (capacidadLocalidad <= 0) {
                        JOptionPane.showMessageDialog(null, "La capacidad debe ser un número positivo.");
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "La capacidad debe ser un número válido.");
                    return;
                }

                boolean general = generalCheck.isSelected();
                int generalCantidad;
                double generalPrecioValor;
                if (general) {
                    try {
                        generalCantidad = Integer.parseInt(generalField.getText());
                        generalPrecioValor = Double.parseDouble(generalPrecio.getText());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "La cantidad y el precio de la butaca general deben ser números válidos.");
                        return;
                    }
                } else {
                    generalCantidad = 0;
                    generalPrecioValor = 0.0;
                }

                boolean platinum = platinumCheck.isSelected();
                int platinumCantidad;
                double platinumPrecioValor;
                if (platinum) {
                    try {
                        platinumCantidad = Integer.parseInt(platinumField.getText());
                        platinumPrecioValor = Double.parseDouble(platinumPrecio.getText());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "La cantidad y el precio de la butaca platinum deben ser números válidos.");
                        return;
                    }
                } else {
                    platinumCantidad = 0;
                    platinumPrecioValor = 0.0;
                }

                boolean vip = vipCheck.isSelected();
                int vipCantidad;
                double vipPrecioValor;
                if (vip) {
                    try {
                        vipCantidad = Integer.parseInt(vipField.getText());
                        vipPrecioValor = Double.parseDouble(vipPrecio.getText());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "La cantidad y el precio de la butaca VIP deben ser números válidos.");
                        return;
                    }
                } else {
                    vipCantidad = 0;
                    vipPrecioValor = 0.0;
                }

                for (Localidad loc : evento.listaLocalidades) {
                    if (loc.getNombreLocalidad().equalsIgnoreCase(nombreLocalidad)) {
                        JOptionPane.showMessageDialog(null, "Ya existe una localidad con ese nombre.");
                        return;
                    }
                }

                Localidad nuevaLocalidad = new Localidad(nombreLocalidad, capacidadLocalidad, general, generalCantidad, generalPrecioValor, platinum, platinumCantidad, platinumPrecioValor, vip, vipCantidad, vipPrecioValor);
                evento.agregarLocalidad(nuevaLocalidad);
                actualizarListaLocalidades();
                limpiarCamposLocalidad();
                actualizarComboBoxLocalidades();
            }
        });

        listaLocalidad.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int indiceSeleccionado = listaLocalidad.getSelectedIndex();
                if (indiceSeleccionado != -1) {
                    Localidad localidadSeleccionada = evento.listaLocalidades.get(indiceSeleccionado);
                    nombreLoca.setText(localidadSeleccionada.getNombreLocalidad());
                    spinnerLocalidad.setValue(localidadSeleccionada.getCapacidadLocalidad());

                    generalCheck.setSelected(localidadSeleccionada.getGeneralCantidad() > 0);
                    generalField.setText(String.valueOf(localidadSeleccionada.getGeneralCantidad()));
                    generalPrecio.setText(String.valueOf(localidadSeleccionada.getGeneralPrecio()));

                    platinumCheck.setSelected(localidadSeleccionada.getPlatinumCantidad() > 0);
                    platinumField.setText(String.valueOf(localidadSeleccionada.getPlatinumCantidad()));
                    platinumPrecio.setText(String.valueOf(localidadSeleccionada.getPlatinumPrecio()));

                    vipCheck.setSelected(localidadSeleccionada.getVipCantidad() > 0);
                    vipField.setText(String.valueOf(localidadSeleccionada.getVipCantidad()));
                    vipPrecio.setText(String.valueOf(localidadSeleccionada.getVipPrecio()));
                }
            }
        });
        modificarLocalidadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceSeleccionado = listaLocalidad.getSelectedIndex();
                if (indiceSeleccionado != -1) {
                    String nombreLocalidad = nombreLoca.getText();
                    int capacidadLocalidad;

                    if (!nombreLocalidad.matches("[a-zA-Z ]+")) {
                        JOptionPane.showMessageDialog(null, "El nombre de la localidad solo puede contener letras y espacios.");
                        return;
                    }

                    try {
                        capacidadLocalidad = Integer.parseInt(spinnerLocalidad.getValue().toString());
                        if (capacidadLocalidad <= 0) {
                            JOptionPane.showMessageDialog(null, "La capacidad debe ser un número positivo.");
                            return;
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "La capacidad debe ser un número válido.");
                        return;
                    }

                    boolean general = generalCheck.isSelected();
                    int generalCantidad;
                    double generalPrecioValor;
                    if (general) {
                        try {
                            generalCantidad = Integer.parseInt(generalField.getText());
                            generalPrecioValor = Double.parseDouble(generalPrecio.getText());
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "La cantidad y el precio de la butaca general deben ser números válidos.");
                            return;
                        }
                    } else {
                        generalCantidad = 0;
                        generalPrecioValor = 0.0;
                    }

                    boolean platinum = platinumCheck.isSelected();
                    int platinumCantidad;
                    double platinumPrecioValor;
                    if (platinum) {
                        try {
                            platinumCantidad = Integer.parseInt(platinumField.getText());
                            platinumPrecioValor = Double.parseDouble(platinumPrecio.getText());
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "La cantidad y el precio de la butaca platinum deben ser números válidos.");
                            return;
                        }
                    } else {
                        platinumCantidad = 0;
                        platinumPrecioValor = 0.0;
                    }

                    boolean vip = vipCheck.isSelected();
                    int vipCantidad;
                    double vipPrecioValor;
                    if (vip) {
                        try {
                            vipCantidad = Integer.parseInt(vipField.getText());
                            vipPrecioValor = Double.parseDouble(vipPrecio.getText());
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "La cantidad y el precio de la butaca VIP deben ser números válidos.");
                            return;
                        }
                    } else {
                        vipCantidad = 0;
                        vipPrecioValor = 0.0;
                    }

                    Localidad localidadModificada = new Localidad(nombreLocalidad, capacidadLocalidad, general, generalCantidad, generalPrecioValor, platinum, platinumCantidad, platinumPrecioValor, vip, vipCantidad, vipPrecioValor);
                    evento.listaLocalidades.set(indiceSeleccionado, localidadModificada);
                    actualizarListaLocalidades();
                    limpiarCamposLocalidad();
                }
            }
        });

        spinnerLocalidad.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int valorActual = (int) spinnerLocalidad.getValue();
                if (valorActual <= 0) {
                    JOptionPane.showMessageDialog(null, "La capacidad debe ser un número positivo.");
                    SwingUtilities.invokeLater(() -> spinnerLocalidad.setValue(1));
                }
            }
        });

        localidadEventoCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreSeleccionado = (String) localidadEventoCombo.getSelectedItem();
                for (Localidad loc : evento.listaLocalidades) {
                    if (loc.getNombreLocalidad().equals(nombreSeleccionado)) {
                        aforoEvento.setValue(loc.getCapacidadLocalidad());
                        break;
                    }
                }
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
                    int aforo = (int) aforoEvento.getValue();
                    String artista = artistaCombo.getSelectedItem().toString();

                    if (!nombre.matches("[a-zA-Z ]+")) {
                        JOptionPane.showMessageDialog(null, "El nombre del evento solo puede contener letras y espacios.");
                        return;
                    }

                    if (!idEvento.getText().matches("\\d+")) {
                        JOptionPane.showMessageDialog(null, "El ID del evento solo puede contener números.");
                        return;
                    }

                    if (!hora.matches("^([01]?[0-9]|2[0-3]):([0-5][0-9])$")) {
                        JOptionPane.showMessageDialog(null, "El formato de hora debe ser hh:mm con valores válidos.");
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

                    if (fechaEvento.isAfter(fechaActual.plusYears(10))) {
                        JOptionPane.showMessageDialog(null, "La fecha del evento no puede ser mayor a 10 años a partir del año actual.");
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

                    Localidad localidadSeleccionada = null;
                    for (Localidad loc : evento.listaLocalidades) {
                        if (loc.getNombreLocalidad().equals(localidad)) {
                            localidadSeleccionada = loc;
                            break;
                        }
                    }

                    if (localidadSeleccionada == null) {
                        JOptionPane.showMessageDialog(null, "La localidad seleccionada no es válida.");
                        return;
                    }

                    int totalButacas = localidadSeleccionada.getGeneralCantidad() + localidadSeleccionada.getPlatinumCantidad() + localidadSeleccionada.getVipCantidad();

                    if (totalButacas != aforo) {
                        JOptionPane.showMessageDialog(null, "Debes asignar todos los asientos disponibles sin pasarte del total.");
                        return;
                    }

                    Evento eventoAgregar = new Evento(id, nombre, ciudad, localidad, hora, fecha, genero, aforo, artista);
                    eventoAgregar.listaLocalidades.add(localidadSeleccionada);
                    usuario.agregarEventoGestionado(eventoAgregar);
                    list4.setModel(usuario.listaEventos);
                    list7.setModel(usuario.listaEventos);
                    list1.setModel(usuario.listaEventos);
                    limpiarAgregarEvento();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al agregar evento: " + ex.getMessage());
                }
            }
        });


        list7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int indiceSeleccionado = list7.getSelectedIndex();
                if (indiceSeleccionado != -1) {
                    Evento eventoSeleccionado = usuario.listaEventos.getElementAt(indiceSeleccionado);
                    actualizarComboBox4(eventoSeleccionado);
                }
            }
        });

        agregarAlCarritoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarEntradaAlCarrito();
                spinner1.setValue(0);
            }
        });
        eliminarDelCarritoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceSeleccionado = list8.getSelectedIndex();
                if(indiceSeleccionado != -1){
                    usuario.eliminarCarrito(indiceSeleccionado);
                    actualizarCarrito();
                }
            }
        });
        comprarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarFactura();
                Evento eventoSeleccionado = usuario.listaEventos.getElementAt(list7.getSelectedIndex());
                for (Factura item : usuario.carrito) {
                    agregarBoleto(item, eventoSeleccionado);
                }
            }
        });

        buscarPorNombreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreNavTF.getText();
                List<Evento> resultados = navegar.buscarPorNombre(nombre);
                evento.mostrarResultados(resultados,navList);
            }
        });

        buscarPorFechaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fecha = fechaNavTF.getText();
                List<Evento> resultados = navegar.buscarPorFecha(fecha);
                evento.mostrarResultados(resultados,navList);
            }
        });

        buscarPorGeneroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String genero = generoMusicalNavCB.getSelectedItem().toString();
                List<Evento> resultados = navegar.buscarPorGenero(genero);
                evento.mostrarResultados(resultados,navList);
            }
        });

        buscarPorLocalidadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String localidad = localidadNavCB.getSelectedItem().toString();
                List<Evento> resultados = navegar.buscarPorLocalidad(localidad);
                evento.mostrarResultados(resultados,navList);
            }
        });

        buscarPorCiudadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ciudad = ciudadNavCB.getSelectedItem().toString();
                List<Evento> resultados = navegar.buscarPorCiudad(ciudad);
                evento.mostrarResultados(resultados, navList);
            }
        });
        buscarPorArtistaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String artista = artistaNavCB.getSelectedItem().toString();
                List<Evento> resultados = navegar.buscarPorArtista(artista);
                evento.mostrarResultados(resultados, navList);
            }
        });

        ordenarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Evento> resultados = new ArrayList<>();
                for (int i = 0; i < navList.getModel().getSize(); i++) {
                    resultados.add((Evento) navList.getModel().getElementAt(i));
                }
                evento.ordenarYMostrarResultados(resultados, navList);
            }
        });

        agregarPublicidadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceSeleccionado = list1.getSelectedIndex();
                if (indiceSeleccionado != -1) {
                    Evento eventoSeleccionado = usuario.listaEventos.getElementAt(indiceSeleccionado);
                    String idEventoSeleccionado = String.valueOf(eventoSeleccionado.getIdEvento());
                    String plataformaSeleccionada = comboBox1.getSelectedItem().toString();
                    int presupuestoUsado = (int) spinner2.getValue();
                    String fechaInicio = textField2.getText();
                    String fechaCulminacion = textField5.getText();

                    if (!fechaInicio.matches("\\d{2}/\\d{2}/\\d{4}")) {
                        JOptionPane.showMessageDialog(null, "El formato de la fecha de inicio debe ser dd/mm/aaaa.");
                        return;
                    }
                    if (!fechaCulminacion.matches("\\d{2}/\\d{2}/\\d{4}")) {
                        JOptionPane.showMessageDialog(null, "El formato de la fecha de culminación debe ser dd/mm/aaaa.");
                        return;
                    }

                    String publicidad = String.format("Evento: %s - Plataforma: %s - Presupuesto: %d - Fecha de inicio: %s - Fecha de culminación: %s",
                            idEventoSeleccionado, plataformaSeleccionada, presupuestoUsado, fechaInicio, fechaCulminacion);
                    usuario.agregarModeloCarrito(publicidad);
                    list2.setModel(usuario.modeloCarrito);
                }
            }
        });
        list4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int indiceSeleccionado = list4.getSelectedIndex();
                if (indiceSeleccionado != -1) {
                    Evento eventoSeleccionado = usuario.listaEventos.getElementAt(indiceSeleccionado);
                    nombreEvento.setText(eventoSeleccionado.getNombreEvento());
                    idEvento.setText(String.valueOf(eventoSeleccionado.getIdEvento()));
                    horaEvento.setText(eventoSeleccionado.getHoraEvento());
                    fechaEvento.setText(eventoSeleccionado.getFechaEvento());
                    comboBox5.setSelectedItem(eventoSeleccionado.getGeneroMusical());
                    ciudadEventoCombo.setSelectedItem(eventoSeleccionado.getCiudadEvento());
                    localidadEventoCombo.setSelectedItem(eventoSeleccionado.getLocalidadEvento());
                    aforoEvento.setValue(eventoSeleccionado.getAforoEvento());
                    artistaCombo.setSelectedItem(eventoSeleccionado.getArtistaEvento());

                    Localidad localidadSeleccionada = null;
                    for (Localidad loc : eventoSeleccionado.listaLocalidades) {
                        if (loc.getNombreLocalidad().equals(eventoSeleccionado.getLocalidadEvento())) {
                            localidadSeleccionada = loc;
                            break;
                        }
                    }

                    if (localidadSeleccionada != null) {
                        generalCheck.setSelected(localidadSeleccionada.isGeneral());
                        generalField.setText(String.valueOf(localidadSeleccionada.getGeneralCantidad()));
                        generalPrecio.setText(String.valueOf(localidadSeleccionada.getGeneralPrecio()));
                        platinumCheck.setSelected(localidadSeleccionada.isPlatinum());
                        platinumField.setText(String.valueOf(localidadSeleccionada.getPlatinumCantidad()));
                        platinumPrecio.setText(String.valueOf(localidadSeleccionada.getPlatinumPrecio()));
                        vipCheck.setSelected(localidadSeleccionada.isVip());
                        vipField.setText(String.valueOf(localidadSeleccionada.getVipCantidad()));
                        vipPrecio.setText(String.valueOf(localidadSeleccionada.getVipPrecio()));
                    }

                    actualizarComboBox4(eventoSeleccionado);
                }
            }
        });

        modificarEventoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceSeleccionado = list4.getSelectedIndex();
                if (indiceSeleccionado != -1) {
                    Evento eventoSeleccionado = usuario.listaEventos.getElementAt(indiceSeleccionado);
                    eventoSeleccionado.setNombreEvento(nombreEvento.getText());
                    eventoSeleccionado.setIdEvento(Integer.parseInt(idEvento.getText()));
                    eventoSeleccionado.setHoraEvento(horaEvento.getText());
                    eventoSeleccionado.setFechaEvento(fechaEvento.getText());
                    eventoSeleccionado.setGeneroMusical((String) comboBox5.getSelectedItem());
                    eventoSeleccionado.setCiudadEvento((String) ciudadEventoCombo.getSelectedItem());
                    eventoSeleccionado.setLocalidadEvento((String) localidadEventoCombo.getSelectedItem());
                    eventoSeleccionado.setAforoEvento((Integer) aforoEvento.getValue());
                    eventoSeleccionado.setArtistaEvento((String) artistaCombo.getSelectedItem());

                    Localidad localidadSeleccionada = null;
                    for (Localidad loc : evento.listaLocalidades) {
                        if (loc.getNombreLocalidad().equals(eventoSeleccionado.getLocalidadEvento())) {
                            localidadSeleccionada = loc;
                            break;
                        }
                    }

                    if (localidadSeleccionada != null) {
                        localidadSeleccionada.setGeneral(generalCheck.isSelected());
                        localidadSeleccionada.setGeneralCantidad(Integer.parseInt(generalField.getText()));
                        localidadSeleccionada.setGeneralPrecio(Double.parseDouble(generalPrecio.getText()));
                        localidadSeleccionada.setPlatinum(platinumCheck.isSelected());
                        localidadSeleccionada.setPlatinumCantidad(Integer.parseInt(platinumField.getText()));
                        localidadSeleccionada.setPlatinumPrecio(Double.parseDouble(platinumPrecio.getText()));
                        localidadSeleccionada.setVip(vipCheck.isSelected());
                        localidadSeleccionada.setVipCantidad(Integer.parseInt(vipField.getText()));
                        localidadSeleccionada.setVipPrecio(Double.parseDouble(vipPrecio.getText()));

                        eventoSeleccionado.getListaLocalidades().clear();
                        eventoSeleccionado.getListaLocalidades().add(localidadSeleccionada);
                    }

                    usuario.listaEventos.set(indiceSeleccionado, eventoSeleccionado);
                    JOptionPane.showMessageDialog(null, "Se ha modificado el evento");
                    list4.repaint();
                }
            }
        });



        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCamposLocalidad();
            }
        });
        limpiarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCamposArtistas();
            }
        });
        limpiarButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarAgregarEvento();
            }
        });
        limpiarButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarNavegacion();
            }
        });
    }


    private void verificarInicioSesion(String usuarioIngresado, String pass, boolean encontrado){
        for (Usuario us : usuario.listaUsuarios) {
            if (us.getUsuario().equals(usuarioIngresado) && us.getContra().equals(pass)) {
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
                    for(int i = 2; i < 4; i++){
                        registroPanel.setEnabledAt(i, true);
                    }
                }
                registroPanel.setEnabledAt(1, false);
                registroPanel.setSelectedIndex(2);

                break;
            }
        }
    }


    private void actualizarEventos(){
        DefaultListModel<Evento> model = new DefaultListModel<>();

        for (int i = 0; i < usuario.listaEventos.getSize(); i++) {
            model.addElement(usuario.listaEventos.getElementAt(i));
        }
        list4.setModel(usuario.listaEventos);
        list7.setModel(usuario.listaEventos);
        list1.setModel(usuario.listaEventos);
    }


    private void actualizarListaArtistas(){
        DefaultListModel<Artista> listModel = new DefaultListModel<>();
        for (Artista artista : evento.listaArtistas) {
            listModel.addElement(artista);
        }
        list6.setModel(listModel);
    }

    private void actualizarListaLocalidades() {
        DefaultListModel<Localidad> listModel = new DefaultListModel<>();
        for (Localidad localidad : evento.listaLocalidades) {
            listModel.addElement(localidad);
        }
        listaLocalidad.setModel(listModel);
    }

    private void limpiarCamposLocalidad(){
        nombreLoca.setText("");
        spinnerLocalidad.setValue(0);
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

    private void limpiarCamposArtistas(){
        textField18.setText("");

    }


    private void actualizarComboBoxArtistas(){
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("Escoger artista...");
        for (Artista artista : evento.listaArtistas) {
            model.addElement(artista.getNombreArtista());
        }
        artistaCombo.setModel(model);
        artistaNavCB.setModel(model);
    }

    private void agregarUsuarioLista(){
        DefaultListModel<Usuario> listModel = new DefaultListModel<>();
        for(Usuario user: usuario.listaUsuarios){
            listModel.addElement(user);
        }
        list9.setModel(listModel);
    }



    private void actualizarComboBoxLocalidades(){
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("Escoger localidad...");
        for (Localidad localidad : evento.listaLocalidades) {
            model.addElement(localidad.getNombreLocalidad());
        }
        localidadEventoCombo.setModel(model);
        localidadNavCB.setModel(model);
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

    private void actualizarComboBox4(Evento evento) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("Escoge el tipo de entrada...");

        if (evento != null) {
            String localidadEvento = evento.getLocalidadEvento();
            for (Localidad localidad : evento.getListaLocalidades()) {
                if (localidad.getNombreLocalidad().equalsIgnoreCase(localidadEvento)) {
                    if (localidad.isGeneral()) {
                        model.addElement("General - $" + localidad.getGeneralPrecio() + " - Cantidad disponible: " + localidad.getGeneralCantidad());
                    }
                    if (localidad.isPlatinum()) {
                        model.addElement("Platinum - $" + localidad.getPlatinumPrecio() + " - Cantidad disponible: " + localidad.getPlatinumCantidad());
                    }
                    if (localidad.isVip()) {
                        model.addElement("VIP - $" + localidad.getVipPrecio() + " - Cantidad disponible: " + localidad.getVipCantidad());
                    }
                    break;
                }
            }
        }

        comboBox4.setModel(model);
    }


    private void agregarEntradaAlCarrito() {
        String tipoEntrada = (String) comboBox4.getSelectedItem();
        int cantidad = (int) spinner1.getValue();

        if (tipoEntrada.equals("Escoge el tipo de entrada...") || cantidad <= 0) {
            JOptionPane.showMessageDialog(null, "Por favor selecciona un tipo de entrada y una cantidad válida.");
            return;
        }

        String[] partes = tipoEntrada.split(" - ");
        double precio = Double.parseDouble(partes[1].substring(1));
        int cantidadDisponible = Integer.parseInt(partes[2].split(": ")[1]);

        if (cantidad > cantidadDisponible) {
            JOptionPane.showMessageDialog(null, "No puedes ingresar una cantidad mayor a la disponible.");
            return;
        }

        String tipoButaca = partes[0] + " - $" + String.format("%.2f", precio);
        usuario.agregarCarrito(new Factura(tipoButaca, cantidad, precio));
        actualizarCarrito();
    }

    private void actualizarCarrito() {
        usuario.modeloCarrito.clear();
        double total = 0.0;

        for (Factura entrada : usuario.carrito) {
            String tipoEntrada = entrada.getTipoEntrada();
            int cantidad = entrada.getCantidad();
            String item = tipoEntrada + " x" + cantidad;
            usuario.agregarModeloCarrito(item);
            total += cantidad * entrada.getPrecio();
        }

        list8.setModel(usuario.modeloCarrito);
        textField19.setText(String.format("%.2f", total));
    }

    private void generarFactura() {
        StringBuilder facturaString = new StringBuilder();
        facturaString.append("***** FACTURA *****\n\n");

        facturaString.append("Informacion del Comprador:\n");
        facturaString.append("Nombre: Consumidor Final\n");
        facturaString.append("Cedula: 1111111111\n\n");

        facturaString.append("Detalles de la Compra:\n");
        double totalAPagar = 0.0;

        for (Factura item : usuario.carrito) {
            String tipoEntrada = item.getTipoEntrada();
            double precio = item.getPrecio();
            int cantidad = item.getCantidad();
            facturaString.append(String.format("%s x%d\n", tipoEntrada, cantidad));
            totalAPagar += precio * cantidad;

            // Actualizar la cantidad disponible en la localidad correspondiente
            String tipoButaca = tipoEntrada.split(" - ")[0];
            Evento eventoSeleccionado = usuario.listaEventos.getElementAt(list7.getSelectedIndex());
            for (Localidad localidad : eventoSeleccionado.getListaLocalidades()) {
                if (localidad.getNombreLocalidad().equals(eventoSeleccionado.getLocalidadEvento())) {
                    if (tipoButaca.equals("General")) {
                        localidad.setGeneralCantidad(localidad.getGeneralCantidad() - cantidad);
                    } else if (tipoButaca.equals("Platinum")) {
                        localidad.setPlatinumCantidad(localidad.getPlatinumCantidad() - cantidad);
                    } else if (tipoButaca.equals("VIP")) {
                        localidad.setVipCantidad(localidad.getVipCantidad() - cantidad);
                    }
                    break;
                }
            }
        }

        facturaString.append("\nTotal a Pagar: $").append(String.format("%.2f", totalAPagar)).append("\n");

        JOptionPane.showMessageDialog(null, facturaString.toString(), "Factura de Compra", JOptionPane.INFORMATION_MESSAGE);

        limpiarCarrito();
        actualizarComboBox4(usuario.listaEventos.getElementAt(list7.getSelectedIndex()));
    }


    private void limpiarCarrito(){
        usuario.modeloCarrito.clear();
        usuario.carrito.clear();
        textField19.setText("");
    }

    private void desabilitarPestanas(){
        for (int i = 2; i < registroPanel.getTabCount(); i++) {
            registroPanel.setEnabledAt(i, false);
        }
    }

    private void agregarBoleto(Factura item, Evento eventoSeleccionado) {
        int idBoleto = usuario.getNextBoletoId();
        Boleto boleto = new Boleto(idBoleto, usuarioActual.getIdUsuario(), eventoSeleccionado.getIdEvento(), item);
        usuario.agregarBoleto(boleto);
    }

    private void limpiarNavegacion(){
        DefaultListModel<Evento> listaVacia = new DefaultListModel<>();
        nombreNavTF.setText("");
        artistaNavCB.setSelectedIndex(0);
        fechaNavTF.setText("");
        generoMusicalNavCB.setSelectedIndex(0);
        localidadNavCB.setSelectedIndex(0);
        ciudadNavCB.setSelectedIndex(0);
        navList.setModel(listaVacia);
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