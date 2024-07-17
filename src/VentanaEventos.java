import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import CapaEstructuras.Lista;
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
    private JButton limpiarButton3;
    private JButton eliminarButton;
    private JButton modificarButton;
    private JButton limpiarButton4;
    private JButton eliminarArtistaButton;
    private JButton eliminarEventoButton;
    private JButton elminarLocalidadButton;
    private JButton eliminarButton1;
    private JButton limpiarButton5;
    private JTextField textField8;
    private JButton buscarPorFechaButton1;
    private JComboBox comboBox3;
    private JButton buscarPorUsuarioButton;
    private JList list3;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;

    private Evento evento = new Evento();
    private Usuario usuario = new Usuario();
    private Lista lista = new Lista();
    Navegar navegar = new Navegar(usuario.listaEventos);
    Lista list = new Lista();



    private int contadorId = 1;
    private Usuario usuarioActual = null;

    public VentanaEventos() {

        lista.listaUsuarios.add(new Usuario(0, "admin", "Administrador", "admin", "direccion", "099485124", "Masculino"));
        lista.listaUsuarios.add(new Usuario(1, "ray", "Ray", "ray", "direccion", "099485124", "Masculino"));
        lista.listaUsuarios.add(new Usuario(2, "richi", "Richi", "richi", "direccion", "099485124", "Masculino"));
        lista.listaUsuarios.add(new Usuario(3, "mati", "Mati", "mati", "direccion", "099485124", "Masculino"));
        lista.listaUsuarios.add(new Usuario(4, "kenji", "Kenji", "kenji", "direccion", "099485124", "Masculino"));
        evento.listaArtistas.add(new Artista("Morat"));
        evento.listaArtistas.add(new Artista("Falling in reverse"));
        evento.listaArtistas.add(new Artista("Nirvana"));
        evento.listaLocalidades.add(new Localidad("Estadio Olimpico Atahualpa", "General", 50.0, 500));
        evento.listaLocalidades.add(new Localidad("Coliseo General Rumiñahui", "Platinum", 100.0, 300));
        evento.listaLocalidades.add(new Localidad("Paseo San Francisco", "VIP", 200.0, 50));

        Evento eventoMorat = new Evento(1, "Morat en Quito", "Quito", "Estadio Olimpico Atahualpa", "15:30", "15/12/2024", "Pop", 1000, "Morat");
        eventoMorat.listaLocalidades.add(new Localidad("Estadio Olimpico Atahualpa", "General", 50.0, 500));
        usuario.listaEventos.addElement(eventoMorat);

        Evento eventoFalling = new Evento(2, "Falling in reverse en Quito", "Quito", "Coliseo General Rumiñahui", "11:30", "17/12/2024", "Metal", 2000, "Falling in reverse");
        eventoFalling.listaLocalidades.add(new Localidad("Coliseo General Rumiñahui", "Platinum", 100.0, 300));
        usuario.listaEventos.addElement(eventoFalling);



        actualizarComboBoxUsuarios();
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
                for (Usuario user : lista.listaUsuarios) {
                    if (user.getUsuario().equals(usuarioField)) {
                        usuarioExistente = true;
                        break;
                    }
                }

                if (usuarioExistente) {
                    JOptionPane.showMessageDialog(null, "El usuario que ingresaste ya se encuentra en el sistema.");
                } else {
                    Usuario nuevoUsuario = new Usuario(contadorId++, usuarioField, nombre, contra, direccion, telefono, genero);
                    lista.listaUsuarios.add(nuevoUsuario);
                    JOptionPane.showMessageDialog(null, "Usuario creado exitosamente");

                    agregarUsuarioLista();
                    actualizarComboBoxUsuarios();

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
                    Usuario usuarioSeleccionado = lista.listaUsuarios.get(indiceSeleccionado);
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
                    for (Usuario user : lista.listaUsuarios) {
                        if (user.getUsuario().equals(usuarioField) && user != lista.listaUsuarios.get(indiceSeleccionado)) {
                            usuarioExistente = true;
                            break;
                        }
                    }

                    if (usuarioExistente) {
                        JOptionPane.showMessageDialog(null, "El usuario que ingresaste ya se encuentra en el sistema.");
                        return;
                    }

                    Usuario usuarioSeleccionado = lista.listaUsuarios.get(indiceSeleccionado);
                    usuarioSeleccionado.setNombre(nombre);
                    usuarioSeleccionado.setUsuario(usuarioField);
                    usuarioSeleccionado.setContra(contra);
                    usuarioSeleccionado.setDireccion(direccion);
                    usuarioSeleccionado.setTelefono(telefono);
                    usuarioSeleccionado.setGenero(genero);

                    list9.setListData(lista.listaUsuarios.toArray(new Usuario[0]));
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
                String nombreButaca = textField9.getText();
                double precio;
                int cantidad;

                try {
                    precio = Double.parseDouble(textField10.getText());
                    cantidad = Integer.parseInt(textField11.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Cantidad y precio deben ser números válidos.");
                    return;
                }

                Localidad nuevaLocalidad = new Localidad(nombreLocalidad, nombreButaca, precio, cantidad);
                evento.agregarLocalidad(nuevaLocalidad);
                actualizarListaLocalidades();
            }
        });





        listaLocalidad.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int indiceSeleccionado = listaLocalidad.getSelectedIndex();
                if (indiceSeleccionado != -1) {
                    String selectedValue = listaLocalidad.getSelectedValue().toString();
                    String[] parts = selectedValue.split(" - ");
                    String nombreLocalidad = parts[0];
                    String nombreButaca = parts[1];

                    for (Localidad loc : evento.listaLocalidades) {
                        if (loc.getNombreLocalidad().equals(nombreLocalidad) && loc.getNombreButaca().equals(nombreButaca)) {
                            nombreLoca.setText(loc.getNombreLocalidad());
                            textField9.setText(loc.getNombreButaca());
                            textField10.setText(String.valueOf(loc.getPrecio()));
                            textField11.setText(String.valueOf(loc.getCantidad()));
                            break;
                        }
                    }
                }
            }
        });


        // Este código se encuentra en el listener del botón modificarLocalidadButton

        modificarLocalidadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceSeleccionado = listaLocalidad.getSelectedIndex();
                if (indiceSeleccionado != -1) {
                    String selectedValue = listaLocalidad.getSelectedValue().toString();
                    String[] parts = selectedValue.split(" - ");
                    String nombreLocalidad = parts[0];
                    String nombreButaca = parts[1];

                    for (Localidad loc : evento.listaLocalidades) {
                        if (loc.getNombreLocalidad().equals(nombreLocalidad) && loc.getNombreButaca().equals(nombreButaca)) {
                            loc.setNombreLocalidad(nombreLoca.getText());
                            loc.setNombreButaca(textField9.getText());
                            loc.setPrecio(Double.parseDouble(textField10.getText()));
                            loc.setCantidad(Integer.parseInt(textField11.getText()));
                            break;
                        }
                    }

                    actualizarListaLocalidades();
                }
            }
        });


        localidadEventoCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreSeleccionado = (String) localidadEventoCombo.getSelectedItem();
                for (Localidad loc : evento.listaLocalidades) {
                    if (loc.getNombreLocalidad().equals(nombreSeleccionado)) {
                        aforoEvento.setValue(loc.getCantidad());
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

                    int totalButacas = 0;
                    for (Localidad loc : evento.listaLocalidades) {
                        if (loc.getNombreLocalidad().equals(localidad)) {
                            totalButacas += loc.getCantidad();
                        }
                    }

                    if (totalButacas != aforo) {
                        JOptionPane.showMessageDialog(null, "Debes asignar todos los asientos disponibles sin pasarte del total.");
                        return;
                    }

                    for (int i = 0; i < usuario.listaEventos.getSize(); i++) {
                        Evento eventoExistente = usuario.listaEventos.getElementAt(i);
                        if (eventoExistente.getNombreEvento().equalsIgnoreCase(nombre)) {
                            JOptionPane.showMessageDialog(null, "Ya existe un evento con ese nombre.");
                            return;
                        }
                        if (eventoExistente.getFechaEvento().equals(fecha)) {
                            JOptionPane.showMessageDialog(null, "Ya existe un evento programado para esta fecha.");
                            return;
                        }
                    }

                    Evento eventoAgregar = new Evento(id, nombre, ciudad, localidad, hora, fecha, genero, aforo, artista);
                    for (Localidad loc : evento.listaLocalidades) {
                        if (loc.getNombreLocalidad().equals(localidad)) {
                            eventoAgregar.listaLocalidades.add(loc);
                        }
                    }

                    usuario.agregarEventoGestionado(eventoAgregar);
                    list4.setModel(usuario.listaEventos);
                    list7.setModel(usuario.listaEventos);
                    list1.setModel(usuario.listaEventos);
                    limpiarAgregarEvento();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al agregar evento");
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
                    list.carrito.remove(indiceSeleccionado);
                    actualizarCarrito();
                }
            }
        });
        comprarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (list.carrito.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debes seleccionar al menos una entrada antes de comprar.");
                    return;
                }
                generarFactura();
                Evento eventoSeleccionado = usuario.listaEventos.getElementAt(list7.getSelectedIndex());
                for (DetalleFactura item : list.carrito) {
                    agregarBoleto(item, eventoSeleccionado);
                    actualizarCantidadEntradas(eventoSeleccionado, item);
                }
                actualizarComboBox4(eventoSeleccionado);
                limpiarCarrito();
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
                int selectedIndex = list1.getSelectedIndex();
                if (selectedIndex != -1) {
                    Evento eventoSeleccionado = usuario.listaEventos.getElementAt(selectedIndex);
                    String plataforma = comboBox1.getSelectedItem().toString();
                    int presupuesto = (int) spinner2.getValue();
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

                    if (!verificarFechaInicio(fechaInicio) || !verificarFechaCulminacion(fechaCulminacion)) {
                        return;
                    }

                    Publicidad nuevaPublicidad = new Publicidad(eventoSeleccionado.getIdEvento(), plataforma, presupuesto, fechaInicio, fechaCulminacion);
                    eventoSeleccionado.agregarPublicidad(nuevaPublicidad);
                    actualizarListaPublicidad(eventoSeleccionado);
                    limpiarCamposPublicidad();
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

                    // Limpiar campos de butacas
                    textField9.setText("");
                    textField10.setText("");
                    textField11.setText("");

                    // Llenar los campos de butacas
                    for (Localidad loc : eventoSeleccionado.getListaLocalidades()) {
                        if (loc.getNombreLocalidad().equals(eventoSeleccionado.getLocalidadEvento())) {
                            nombreLoca.setText(loc.getNombreLocalidad());
                            textField9.setText(loc.getNombreButaca());
                            textField10.setText(String.valueOf(loc.getPrecio()));
                            textField11.setText(String.valueOf(loc.getCantidad()));
                            break;
                        }
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
                    String nuevoNombre = nombreEvento.getText();
                    String nuevaCiudad = ciudadEventoCombo.getSelectedItem().toString();
                    String nuevaLocalidad = localidadEventoCombo.getSelectedItem().toString();
                    String nuevaHora = horaEvento.getText();
                    String nuevaFecha = fechaEvento.getText();
                    String nuevoGenero = comboBox5.getSelectedItem().toString();
                    int nuevoAforo = (int) aforoEvento.getValue();
                    String nuevoArtista = artistaCombo.getSelectedItem().toString();

                    if (!nuevoNombre.matches("[a-zA-Z ]+")) {
                        JOptionPane.showMessageDialog(null, "El nombre del evento solo puede contener letras y espacios.");
                        return;
                    }

                    if (!idEvento.getText().matches("\\d+")) {
                        JOptionPane.showMessageDialog(null, "El ID del evento solo puede contener números.");
                        return;
                    }

                    if (!nuevaHora.matches("^([01]?[0-9]|2[0-3]):([0-5][0-9])$")) {
                        JOptionPane.showMessageDialog(null, "El formato de hora debe ser hh:mm con valores válidos.");
                        return;
                    }

                    if (!nuevaFecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
                        JOptionPane.showMessageDialog(null, "El formato de fecha debe ser dd/mm/aaaa.");
                        return;
                    }

                    LocalDate fechaActual = LocalDate.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate fechaEvento = LocalDate.parse(nuevaFecha, formatter);

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

                    // Encuentra la localidad seleccionada
                    Localidad localidadSeleccionada = null;
                    for (Localidad loc : eventoSeleccionado.getListaLocalidades()) {
                        if (loc.getNombreLocalidad().equals(nuevaLocalidad)) {
                            localidadSeleccionada = loc;
                            break;
                        }
                    }

                    if (localidadSeleccionada == null) {
                        JOptionPane.showMessageDialog(null, "La localidad seleccionada no es válida.");
                        return;
                    }

                    // Actualiza los datos del evento seleccionado
                    eventoSeleccionado.setNombreEvento(nuevoNombre);
                    eventoSeleccionado.setCiudadEvento(nuevaCiudad);
                    eventoSeleccionado.setLocalidadEvento(nuevaLocalidad);
                    eventoSeleccionado.setHoraEvento(nuevaHora);
                    eventoSeleccionado.setFechaEvento(nuevaFecha);
                    eventoSeleccionado.setGeneroMusical(nuevoGenero);
                    eventoSeleccionado.setAforoEvento(nuevoAforo);
                    eventoSeleccionado.setArtistaEvento(nuevoArtista);

                    // Actualiza la localidad seleccionada
                    localidadSeleccionada.setNombreLocalidad(nuevaLocalidad);
                    localidadSeleccionada.setNombreButaca(textField9.getText());
                    localidadSeleccionada.setPrecio(Double.parseDouble(textField10.getText()));
                    localidadSeleccionada.setCantidad(Integer.parseInt(textField11.getText()));

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
        list2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedIndexEvento = list1.getSelectedIndex();
                int selectedIndexPublicidad = list2.getSelectedIndex();
                if (selectedIndexEvento != -1 && selectedIndexPublicidad != -1) {
                    Evento eventoSeleccionado = usuario.listaEventos.getElementAt(selectedIndexEvento);
                    Publicidad publicidadSeleccionada = eventoSeleccionado.getListaPublicidades().get(selectedIndexPublicidad);
                    comboBox1.setSelectedItem(publicidadSeleccionada.getPlataforma());
                    spinner2.setValue(publicidadSeleccionada.getPresupuesto());
                    textField2.setText(publicidadSeleccionada.getFechaInicio());
                    textField5.setText(publicidadSeleccionada.getFechaCulminacion());
                }
            }
        });

        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedIndex = list1.getSelectedIndex();
                if (selectedIndex != -1) {
                    Evento eventoSeleccionado = usuario.listaEventos.getElementAt(selectedIndex);
                    actualizarListaPublicidad(eventoSeleccionado);
                }
            }
        });

        limpiarButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCamposPublicidad();
            }
        });
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndexEvento = list1.getSelectedIndex();
                int selectedIndexPublicidad = list2.getSelectedIndex();

                if (selectedIndexEvento != -1 && selectedIndexPublicidad != -1) {
                    Evento eventoSeleccionado = usuario.listaEventos.getElementAt(selectedIndexEvento);
                    Publicidad publicidadSeleccionada = eventoSeleccionado.getListaPublicidades().get(selectedIndexPublicidad);

                    String nuevaPlataforma = comboBox1.getSelectedItem().toString();
                    int nuevoPresupuesto = (int) spinner2.getValue();
                    String nuevaFechaInicio = textField2.getText();
                    String nuevaFechaCulminacion = textField5.getText();

                    if (!nuevaFechaInicio.matches("\\d{2}/\\d{2}/\\d{4}")) {
                        JOptionPane.showMessageDialog(null, "El formato de la fecha de inicio debe ser dd/mm/aaaa.");
                        return;
                    }
                    if (!nuevaFechaCulminacion.matches("\\d{2}/\\d{2}/\\d{4}")) {
                        JOptionPane.showMessageDialog(null, "El formato de la fecha de culminación debe ser dd/mm/aaaa.");
                        return;
                    }

                    publicidadSeleccionada.setPlataforma(nuevaPlataforma);
                    publicidadSeleccionada.setPresupuesto(nuevoPresupuesto);
                    publicidadSeleccionada.setFechaInicio(nuevaFechaInicio);
                    publicidadSeleccionada.setFechaCulminacion(nuevaFechaCulminacion);

                    actualizarListaPublicidad(eventoSeleccionado);
                    limpiarCamposPublicidad();
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona un evento y una publicidad para modificar.");
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndexEvento = list1.getSelectedIndex();
                int selectedIndexPublicidad = list2.getSelectedIndex();

                if (selectedIndexEvento != -1 && selectedIndexPublicidad != -1) {
                    Evento eventoSeleccionado = usuario.listaEventos.getElementAt(selectedIndexEvento);
                    eventoSeleccionado.getListaPublicidades().remove(selectedIndexPublicidad);
                    actualizarListaPublicidad(eventoSeleccionado);
                    limpiarCamposPublicidad();
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona un evento y una publicidad para eliminar.");
                }
            }
        });

        eliminarEventoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list4.getSelectedIndex();
                evento.eliminarEvento(selectedIndex, usuario.listaEventos);
                evento.actualizarListaEventos(list4, usuario.listaEventos);
            }
        });
        eliminarArtistaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list6.getSelectedIndex();
                evento.eliminarArtista(selectedIndex, evento.listaArtistas);
                evento.actualizarListaArtistas(list6, evento.listaArtistas);
            }
        });
        elminarLocalidadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = listaLocalidad.getSelectedIndex();
                evento.eliminarLocalidad(selectedIndex, evento.listaLocalidades);
                evento.actualizarListaLocalidades(listaLocalidad, evento.listaLocalidades);
            }
        });
        textField2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                verificarFechaInicio(textField2.getText());
            }
        });
        textField5.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                verificarFechaCulminacion(textField5.getText());
            }
        });
        eliminarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarUsuarioSeleccionado();
            }
        });
        limpiarButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField20.setText("");
                textField21.setText("");
                textField22.setText("");
                textField23.setText("");
                textField24.setText("");
                comboBox6.setSelectedIndex(0);
            }
        });
        buscarPorFechaButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarFacturasPorFecha();
            }
        });

    }

    private void generarFactura() {
        double totalAPagar = 0.0;
        List<DetalleFactura> detalles = new ArrayList<>(list.carrito);

        for (DetalleFactura item : detalles) {
            totalAPagar += item.getPrecio() * item.getCantidad();
        }

        CabeceraFactura cabecera = new CabeceraFactura(usuario.getNextFacturaId(), usuarioActual, LocalDate.now(), totalAPagar, detalles);
        usuario.agregarFactura(cabecera);
        JOptionPane.showMessageDialog(null, cabecera.toString(), "Factura de Compra", JOptionPane.INFORMATION_MESSAGE);
        limpiarCarrito();
    }



    private void verificarInicioSesion(String usuarioIngresado, String pass, boolean encontrado) {
        for (Usuario us : lista.listaUsuarios) {
            if (us.getUsuario().equals(usuarioIngresado) && us.getContra().equals(pass)) {
                encontrado = true;
                usuarioActual = us;
                System.out.println("Usuario autenticado: " + usuarioActual.getUsuario());
                JOptionPane.showMessageDialog(null, "Has iniciado sesion correctamente");
                inicioValor.setText("Bienvenido " + us.getUsuario());
                textField1.setText("");
                passwordField1.setText("");
                errorInicio.setText("");

                if (usuarioActual.getUsuario().equals("admin")) {
                    for (int i = 2; i < registroPanel.getTabCount(); i++) {
                        registroPanel.setEnabledAt(i, true);
                    }
                } else {
                    for (int i = 2; i < 4; i++) {
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
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Localidad loc : evento.getListaLocalidades()) {
            listModel.addElement(loc.getNombreLocalidad() + " - " + loc.getNombreButaca() + " - " + loc.getCantidad() + " - $" + loc.getPrecio());
        }
        listaLocalidad.setModel(listModel);
    }




    private void limpiarCamposLocalidad() {
        nombreLoca.setText("");
        textField9.setText("");
        textField10.setText("");
        textField11.setText("");
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
        for(Usuario user: lista.listaUsuarios){
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
                    // Limpia los campos antes de llenarlos
                    textField9.setText("");
                    textField10.setText("");
                    textField11.setText("");

                    // Itera sobre los tipos de butaca y llena los campos correspondientes
                    String tipoButaca = localidad.getNombreButaca();
                    int cantidadButaca = localidad.getCantidad();
                    double precioButaca = localidad.getPrecio();

                    model.addElement(tipoButaca + " - $" + precioButaca + " - Cantidad disponible: " + cantidadButaca);
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
        int cantidadDisponible = Integer.parseInt(partes[2].split(": ")[1].split(" ")[0]);

        if (cantidad > cantidadDisponible) {
            JOptionPane.showMessageDialog(null, "No puedes ingresar una cantidad mayor a la disponible.");
            return;
        }

        String tipoButaca = partes[0] + " - $" + String.format("%.2f", precio);
        Evento eventoSeleccionado = usuario.listaEventos.getElementAt(list7.getSelectedIndex());
        DetalleFactura detalle = new DetalleFactura(eventoSeleccionado, tipoButaca, cantidad, precio);

        list.carrito.add(detalle);
        actualizarCarrito();
    }


    private void actualizarCarrito() {
        lista.modeloCarrito.clear();
        double total = 0.0;

        for (DetalleFactura entrada : list.carrito) {
            String tipoEntrada = entrada.getTipoAsiento();
            int cantidad = entrada.getCantidad();
            String item = tipoEntrada + " x" + cantidad;
            lista.modeloCarrito.addElement(item);
            total += cantidad * entrada.getPrecio();
        }

        list8.setModel(lista.modeloCarrito);
        textField19.setText(String.format("%.2f", total));
    }



    private void limpiarCarrito(){
        lista.modeloCarrito.clear();
        list.carrito.clear();
        textField19.setText("");
    }

    private void desabilitarPestanas(){
        for (int i = 2; i < registroPanel.getTabCount(); i++) {
            registroPanel.setEnabledAt(i, false);
        }
    }

    private void agregarBoleto(DetalleFactura detalle, Evento eventoSeleccionado) {
        int idBoleto = usuario.getNextBoletoId();
        Boleto boleto = new Boleto(idBoleto, usuarioActual.getIdUsuario(), eventoSeleccionado.getIdEvento(), detalle);
        list.listaBoletos.add(boleto);
        System.out.println("Boleto agregado: " + boleto.toString());
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

    private void actualizarListaPublicidad(Evento eventoSeleccionado) {
        DefaultListModel<Publicidad> model = new DefaultListModel<>();
        for (Publicidad publicidad : eventoSeleccionado.getListaPublicidades()) {
            model.addElement(publicidad);
        }
        list2.setModel(model);
    }

    private void limpiarCamposPublicidad(){
        list1.setSelectedIndex(-1);
        comboBox1.setSelectedIndex(0);
        spinner2.setValue(0);
        textField2.setText("");
        textField5.setText("");
    }

    private boolean verificarFechaInicio(String fechaTexto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate fechaIngresada = LocalDate.parse(fechaTexto, formatter);
            LocalDate fechaActual = LocalDate.now();

            if (fechaIngresada.isBefore(fechaActual)) {
                JOptionPane.showMessageDialog(null, "No se puede ingresar una fecha anterior a la fecha actual.");
                textField2.setText("");
                textField2.requestFocus();
                return false;
            }
            return true;
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Use dd/MM/yyyy.");
            textField2.setText("");
            textField2.requestFocus();
            return false;
        }
    }

    private boolean verificarFechaCulminacion(String fechaTexto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate fechaIngresada = LocalDate.parse(fechaTexto, formatter);
            LocalDate fechaActual = LocalDate.now();

            Evento eventoSeleccionado = getEventoSeleccionado();
            if (eventoSeleccionado == null) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un evento primero.");
                textField5.setText("");
                return false;
            }

            LocalDate fechaEvento = LocalDate.parse(eventoSeleccionado.getFechaEvento(), formatter);

            if (fechaIngresada.isBefore(fechaActual) || fechaIngresada.isEqual(fechaActual)) {
                JOptionPane.showMessageDialog(null, "No se puede ingresar una fecha anterior o igual a la fecha actual.");
                textField5.setText("");
                textField5.requestFocus();
                return false;
            } else if (fechaIngresada.isAfter(fechaEvento)) {
                JOptionPane.showMessageDialog(null, "No se puede ingresar una fecha posterior a la fecha del evento.");
                textField5.setText("");
                textField5.requestFocus();
                return false;
            }
            return true;
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Use dd/MM/yyyy.");
            textField5.setText("");
            textField5.requestFocus();
            return false;
        }
    }

    private Evento getEventoSeleccionado() {
        int selectedIndex = list1.getSelectedIndex();
        if (selectedIndex != -1) {
            return usuario.listaEventos.getElementAt(selectedIndex);
        }
        return null;
    }

    private void eliminarUsuarioSeleccionado() {
        int indiceSeleccionado = list9.getSelectedIndex();

        if (indiceSeleccionado != -1) {
            lista.listaUsuarios.remove(indiceSeleccionado);

            DefaultListModel<Usuario> listModel = (DefaultListModel<Usuario>) list9.getModel();
            listModel.remove(indiceSeleccionado);

            textField20.setText("");
            textField21.setText("");
            textField22.setText("");
            textField23.setText("");
            textField24.setText("");
            comboBox6.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un usuario para eliminar.");
        }
    }

    private void buscarFacturasPorFecha() {
        String fechaTexto = textField8.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha;

        try {
            fecha = LocalDate.parse(fechaTexto, formatter);
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Use dd/MM/yyyy.");
            return;
        }

        List<CabeceraFactura> facturasPorFecha = usuario.getFacturasPorFecha(fecha);
        DefaultListModel<String> model = new DefaultListModel<>();
        for (CabeceraFactura factura : facturasPorFecha) {
            model.addElement(factura.toString());
        }
        list3.setModel(model);
    }

    private void actualizarComboBoxUsuarios() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Usuario user : lista.listaUsuarios) {
            model.addElement(user.getUsuario());
        }
        comboBox3.setModel(model);
    }

    private void actualizarCantidadEntradas(Evento evento, DetalleFactura item) {
        String tipoAsiento = item.getTipoAsiento();
        int cantidadComprada = item.getCantidad();

        for (Localidad localidad : evento.getListaLocalidades()) {
            if (localidad.getNombreLocalidad().equals(evento.getLocalidadEvento())) {
                if (localidad.getNombreButaca().equalsIgnoreCase(tipoAsiento)) {
                    int nuevaCantidad = localidad.getCantidad() - cantidadComprada;
                    localidad.setCantidad(nuevaCantidad);
                    break;
                }
            }
        }
    }


    private void agregarButacaALocalidad(String nombreLocalidad, String nombreButaca, double precio, int cantidad) {
        for (Localidad localidad : evento.listaLocalidades) {
            if (localidad.getNombreLocalidad().equals(nombreLocalidad)) {
                localidad.setCantidad(localidad.getCantidad() + cantidad);
                localidad.setPrecio(precio); // Asignar el precio de la última butaca agregada
                localidad.setNombreButaca(nombreButaca);
                return;
            }
        }
        Localidad nuevaLocalidad = new Localidad(nombreLocalidad, nombreButaca, precio, cantidad);
        evento.listaLocalidades.add(nuevaLocalidad);
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