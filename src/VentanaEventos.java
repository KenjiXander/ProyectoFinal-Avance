import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import GestionEvento.Evento;
import Arboles.OrdenarArbol;

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

    private List<Usuario> listaUsuarios = new ArrayList<>();
    private List<Artista> listaArtistas = new ArrayList<>();
    private List<Localidad> localidades = new ArrayList<>();
    private DefaultListModel<Evento> modeloEventos = new DefaultListModel<>();
    private List<Factura> carrito = new ArrayList<>();
    private DefaultListModel<String> modeloCarrito = new DefaultListModel<>();
    private List<Publicidad> listaPublicidades = new ArrayList<>();


    private int contadorId = 1;
    private Usuario usuarioActual = null;

    public VentanaEventos() {

        listaUsuarios.add(new Usuario(0, "admin", "Administrador", "admin", "direccion", "099485124", "Masculino"));

        modeloEventos = new DefaultListModel<>();
        Navegar navegar = new Navegar(modeloEventos);

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

                    list9.setListData(listaUsuarios.toArray(new Usuario[0]));
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
                String generoArtista = generoArtistaTF.getText();

                if(!nombreArtista.isEmpty() && !generoArtista.isEmpty()){
                    Artista nuevoArtista = new Artista(nombreArtista, generoArtista);
                    listaArtistas.add(nuevoArtista);

                    DefaultListModel<Artista> listModel = new DefaultListModel<>();
                    for(Artista artista:listaArtistas){
                        listModel.addElement(artista);
                    }
                    list6.setModel(listModel);

                    actualizarComboBoxArtistas();
                    actualizarComboBoxGeneros();
                    textField18.setText("");
                    generoArtistaTF.setText("");
                } else{
                    JOptionPane.showMessageDialog(null, "Por favor ingresa el nombre del artista y su género musical.");
                }
            }
        });
        list6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int indiceSeleccionado = list6.getSelectedIndex();

                if(indiceSeleccionado != -1){
                    Artista artistaSeleccionado = listaArtistas.get(indiceSeleccionado);
                    textField18.setText(artistaSeleccionado.getNombreArtista());
                    generoArtistaTF.setText(artistaSeleccionado.getGeneroArtista());
                }
            }
        });
        modificarArtistaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceSeleccionado = list6.getSelectedIndex();

                if(indiceSeleccionado != -1){
                    String nombreArtista = textField18.getText();
                    String generoArtista = generoArtistaTF.getText();

                    Artista artistaModificado = new Artista(nombreArtista,generoArtista);
                    listaArtistas.set(indiceSeleccionado, artistaModificado);

                    DefaultListModel<Artista> listModel = new DefaultListModel<>();
                    for(Artista artista:listaArtistas){
                        listModel.addElement(artista);
                    }
                    list6.setModel(listModel);
                    textField18.setText("");
                    generoArtistaTF.setText("");
                    actualizarComboBoxGeneros();
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
                    int aforo = (int) aforoEvento.getValue();
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

                    if (!hora.matches("^([01]?[0-9]|2[0-3]):([0-5][0-9])$")) {
                        JOptionPane.showMessageDialog(null, "El formato de hora debe ser hh:mm con valores validos.");
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
                    list7.setModel(modeloEventos);
                    list1.setModel(modeloEventos);
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
                if(indiceSeleccionado != -1){
                    Evento eventoSeleccionado = modeloEventos.getElementAt(indiceSeleccionado);
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
                    carrito.remove(indiceSeleccionado);
                    actualizarCarrito();
                }
            }
        });
        comprarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarFactura();
            }
        });
        buscarPorNombreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreNavTF.getText();
                List<Evento> resultados = navegar.buscarPorNombre(nombre);
                mostrarResultados(resultados);
            }
        });

        buscarPorFechaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fecha = fechaNavTF.getText();
                List<Evento> resultados = navegar.buscarPorFecha(fecha);
                mostrarResultados(resultados);
            }
        });

        buscarPorGeneroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String genero = generoMusicalNavCB.getSelectedItem().toString();
                List<Evento> resultados = navegar.buscarPorGenero(genero);
                mostrarResultados(resultados);
            }
        });

        buscarPorLocalidadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String localidad = localidadNavCB.getSelectedItem().toString();
                List<Evento> resultados = navegar.buscarPorLocalidad(localidad);
                mostrarResultados(resultados);
            }
        });

        buscarPorCiudadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ciudad = ciudadNavCB.getSelectedItem().toString();
                List<Evento> resultados = navegar.buscarPorCiudad(ciudad);
                mostrarResultados(resultados);
            }
        });
        buscarPorArtistaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String artista = artistaNavCB.getSelectedItem().toString();
                List<Evento> resultados = navegar.buscarPorArtista(artista);
                mostrarResultados(resultados);
            }
        });

        ordenarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Evento> resultados = new ArrayList<>();
                for (int i = 0; i < navList.getModel().getSize(); i++) {
                    resultados.add((Evento) navList.getModel().getElementAt(i));
                }
                ordenarYMostrarResultados(resultados);
            }
        });

        agregarPublicidadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceSeleccionado = list1.getSelectedIndex();
                if (indiceSeleccionado != -1) {
                    Evento eventoSeleccionado = modeloEventos.getElementAt(indiceSeleccionado);
                    String idEventoSeleccionado = String.valueOf(eventoSeleccionado.getIdEvento());
                    String plataformaSeleccionada = comboBox1.getSelectedItem().toString();
                    int presupuestoUsado = (int) spinner2.getValue();
                    String fechaInicio = textField2.getText();
                    String fechaCulminacion = textField5.getText();

                    // Validación de las fechas
                    if (!fechaInicio.matches("\\d{2}/\\d{2}/\\d{4}")) {
                        JOptionPane.showMessageDialog(null, "El formato de la fecha de inicio debe ser dd/mm/aaaa.");
                        return;
                    }
                    if (!fechaCulminacion.matches("\\d{2}/\\d{2}/\\d{4}")) {
                        JOptionPane.showMessageDialog(null, "El formato de la fecha de culminación debe ser dd/mm/aaaa.");
                        return;
                    }

                    // Crear el string de publicidad y agregarlo al modelo de lista
                    String publicidad = String.format("Evento: %s - Plataforma: %s - Presupuesto: %d - Fecha de inicio: %s - Fecha de culminación: %s",
                            idEventoSeleccionado, plataformaSeleccionada, presupuestoUsado, fechaInicio, fechaCulminacion);
                    modeloCarrito.addElement(publicidad);
                    list2.setModel(modeloCarrito);
                }
            }
        });
    }


    private void verificarInicioSesion(String usuario, String pass, boolean encontrado){
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
        artistaNavCB.setModel(model);
    }

    private void actualizarComboBoxGeneros(){
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("Escoger género musical...");
        for (Artista artista : listaArtistas) {
            model.addElement(artista.getGeneroArtista());
        }
        comboBox5.setModel(model);
        generoMusicalNavCB.setModel(model);
    }



    private void actualizarComboBoxLocalidades(){
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("Escoger localidad...");
        for (Localidad localidad : localidades) {
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

    private void actualizarComboBox4(Evento evento){
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

        model.addElement("Escoge el tipo de entrada...");

        if(evento.isGeneral()){
            model.addElement("General - $" + evento.getGeneralPrecio() + " - Cantidad disponible de entradas: " + evento.getGeneralCantidad());
        }
        if (evento.isPlatinum()) {
            model.addElement("Platinum - $" + evento.getPlatinumPrecio() + " - Cantidad disponible: " + evento.getPlatinumCantidad());
        }
        if (evento.isVip()) {
            model.addElement("VIP - $" + evento.getVipPrecio() + " - Cantidad disponible: " + evento.getVipCantidad());
        }

        comboBox4.setModel(model);
    }

    private void agregarEntradaAlCarrito(){
        String tipoEntrada = (String) comboBox4.getSelectedItem();
        int cantidad = (int) spinner1.getValue();

        if(tipoEntrada.equals("Escoge el tipo de entrada...") || cantidad <= 0){
            JOptionPane.showMessageDialog(null, "Porfavor selecciona un tipo de entrada y una cantidad valida");
            return;
        }

        String[] partes = tipoEntrada.split(" - ");
        double precio = Double.parseDouble(partes[1].substring(1));

        carrito.add(new Factura(tipoEntrada, cantidad, precio));
        actualizarCarrito();
    }

    private void actualizarCarrito(){
        modeloCarrito.clear();
        double total = 0.0;

        for(Factura entrada:carrito){
            String tipoEntrada = entrada.getTipoEntrada();
            int cantidad = entrada.getCantidad();
            String[] partes = tipoEntrada.split(" - ");
            String item = partes[0] + " - $" + partes[1].substring(1) + " x" + cantidad;
            modeloCarrito.addElement(item);
            total += cantidad * entrada.getPrecio();
        }

        list8.setModel(modeloCarrito);
        textField19.setText(String.format("%.2f", total));
    }

    private void generarFactura(){
        StringBuilder factura = new StringBuilder();
        factura.append("***** Factura *****\n\n");

        factura.append("Informacion del Comprador:\n");
        factura.append("Nombre: Consumidor Final\n");
        factura.append("Cedula: 1111111111\n\n");

        factura.append("Detalles de la Compra:\n");
        for(Factura item: carrito){
            factura.append(item.getTipoEntrada()).append("\n");
        }

        factura.append("\nTotal a Pagar: $").append(textField19.getText()).append("\n");

        JOptionPane.showMessageDialog(null,factura.toString(), "Factura de Compra", JOptionPane.INFORMATION_MESSAGE);

        limpiarCarrito();
    }

    private void limpiarCarrito(){
        modeloCarrito.clear();
        carrito.clear();
        textField19.setText("");
    }

    private void ordenarYMostrarResultados(List<Evento> resultados) {
        OrdenarArbol ordenarArbol = new OrdenarArbol();
        List<Evento> eventosOrdenados = ordenarArbol.ordenarPorNombre(resultados);
        mostrarResultados(eventosOrdenados);
    }

    private void mostrarResultados(List<Evento> resultados) {
        DefaultListModel<Evento> model = new DefaultListModel<>();
        for (Evento evento : resultados) {
            model.addElement(evento);
        }
        navList.setModel(model);
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