import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


//Las variables terminadas en "...TIPINS" corresponden al panel de Tipos de Instrumentos
//Las variables terminadas en "...INS" corresponden al panel de Instrumentos
//Las variables terminadas en "...CALI" corresponden al panel de Calibraciones
public class HELLO extends JFrame{
    private int a = 0;
    private int b = 0;
    private JPanel panelPrincipal;
    private JTabbedPane tablaInstrumentosINS;
    private JButton guardarButtonINS; // de aca en adelante son las variables relacionadas a Intrumentos (...INS)
    private JTextField txtSerieINS;
    private JTextField txtMinimoINS;
    private JTextField txtToleranciaINS;
    private JTextField txtDescripcionINS;
    private JTextField txtMaximoINS;
    private JComboBox comboBoxTipoINS;
    private JButton limpiarButtonINS;
    private JButton borrarButtonINS;
    private JTextField txtBusquedaDescripcionINS;
    private JButton buscarButtonINS;
    private JButton reporteButtonINS;
    private JTable tableInstrumentos;
    private JPanel Calibraciones; // de aca en adelante son las variables relacionadas a Calibraciones (...CALI)
    private JButton guardarButtonCALI;
    private JButton borrarButtonCALI;
    private JButton limpiarButtonCALI;
    private JButton buscarButtonCALI;
    private JTextField txtBusquedaNumeroCALI;
    private JTextField txtNumeroCALI;
    private JTextField txtFechaCALI;
    private JTextField txtMedicionesCALI;
    private JButton reporteButtonCALI;
    private JTable tableCalibraciones;
    private JButton guardarButtonTIPINS;    // de aca en adelante son las variables relacionadas a Tipos de Intrumentos (...TIPINS)
    private JButton borrarButtonTIPINS;
    private JButton limpiarButtonTIPINS;
    private JTextField txtUnidadTIPINS;
    private JTextField txtCodigoTIPINS;
    private JTextField txtNombreTIPINS;
    private JTable tablaTiposInstruemento;
    private JButton buscarButtonTIPINS;
    private JButton reporteButtonTIPINS;
    private JPanel tablaListadoINS;
    private JPanel tablaListadoTiposINS;
    private JTextField txtNumeroTIPINS;
    private JLabel imagenUNA;   // de aca en adelante son variables de otras cosas
    private JPanel TablaListadoCalibraciones;
    private JTable tableMediciones;
    private JTextField txtInstrumentoCALI;
    private JPanel TablaListadoMediciones;
    private ConjuntoTiposInstrumento cjntTiposInsrumentos;
    private ConjuntoInstrumentos cjntInstrumentos;
    private ConjuntoCalibraciones cjntCalibraciones;
    private ConjuntoMediciones cjntMediciones;
    private ModeloTablaTipoInstrumentos modeloTablaTipoInstrumentos;
    private ModeloTablaCalibraciones modeloTablaCalibraciones;
    private ModeloTablaInstrumentos modeloTablaInstrumentos;
    private ModeloTablaMediciones modeloTablaMediciones;
    private TiposInstrumento tiposInstrumento;
    private Instrumento instrumentos;
    private Calibraciones calibraciones;
    private DefaultTableModel model = new DefaultTableModel();
    private DefaultTableModel modelINS = new DefaultTableModel();
    private DefaultTableModel tableModelMediciones;
    //---------------------FINAL de las declaraciones de vriables
    private LocalDate FechaActual = LocalDate.now();
    private Mediciones mediciones;

    private void actualizarTablaMediciones(List<Mediciones> mediciones) {
        ModeloTablaMediciones tableModelMediciones = (ModeloTablaMediciones) tableMediciones.getModel();
        tableModelMediciones.limpiarModelo(); // Limpiar la tabla

        for (Mediciones medicion : mediciones) {
            Object[] fila = {
                    medicion.getMedida(),
                    medicion.getReferencia(),
                    medicion.getLectura()
            };
            tableModelMediciones.addRow(fila);
        }
    }

    private void refrescarInstrumentos(){
        modelINS.setRowCount(0);
        for (int i = 0; i < cjntInstrumentos.numInstrumento(); i++) {
            if (cjntInstrumentos.recuperar(i).getTipo() == comboBoxTipoINS.getSelectedItem()) {
                Object[] fila = {
                        cjntInstrumentos.recuperar(i).getSerie(),
                        cjntInstrumentos.recuperar(i).getDescripcion(),
                        cjntInstrumentos.recuperar(i).getMinimo(),
                        cjntInstrumentos.recuperar(i).getMaximo(),
                        cjntInstrumentos.recuperar(i).getTolerancia(),
                        cjntInstrumentos.recuperar(i).getTipo()
                };
                modelINS.addRow(fila);
            }
        }
    }
    private void limpiarTablaMediciones() {
        ModeloTablaMediciones modeloTablaMediciones = (ModeloTablaMediciones) tableMediciones.getModel();
        modeloTablaMediciones.limpiarModelo();
    }



    public HELLO(){
// Inicializa el modelo de tabla de mediciones
        tableModelMediciones = new DefaultTableModel();
        tableMediciones.setModel(tableModelMediciones);
        tableMediciones.setEnabled(false);
        tableMediciones.setVisible(false);
        TablaListadoMediciones.setVisible(false);

    //Inicializamos la tabla de TIPOS de INSTRUMENTOS (...TIPINS)
        cjntTiposInsrumentos = new ConjuntoTiposInstrumento();
        modeloTablaTipoInstrumentos = new ModeloTablaTipoInstrumentos(cjntTiposInsrumentos);
        tablaTiposInstruemento.setModel(modeloTablaTipoInstrumentos);
        JTableHeader headerTipoINS = tablaTiposInstruemento.getTableHeader();
        //tablaListadoTipoINS es el panel donde esta tabla de tipo de instrumentos
        tablaListadoTiposINS.setLayout(new BorderLayout());
        tablaListadoTiposINS.add(headerTipoINS, BorderLayout.NORTH);
        tablaListadoTiposINS.add(new JScrollPane(tablaTiposInstruemento), BorderLayout.CENTER);

    //Inicializamos la tabla de INSTRUMENTOS (...INS)
        cjntInstrumentos = new ConjuntoInstrumentos();
        modeloTablaInstrumentos = new ModeloTablaInstrumentos(cjntInstrumentos);
        tableInstrumentos.setModel(modeloTablaInstrumentos);
        JTableHeader header = tableInstrumentos.getTableHeader();
        tablaListadoINS.setLayout(new BorderLayout());
        tablaListadoINS.add(header, BorderLayout.NORTH);
        tablaListadoINS.add(new JScrollPane(tableInstrumentos), BorderLayout.CENTER);

        comboBoxTipoINS.setModel(new DefaultComboBoxModel<>(new String[]{"Seleccione un tipo"}));

        //inicializacion tabla calaibraciones
        cjntCalibraciones = new ConjuntoCalibraciones();
        modeloTablaCalibraciones = new ModeloTablaCalibraciones(cjntCalibraciones);
        tableCalibraciones.setModel(modeloTablaCalibraciones);
        JTableHeader headerCalibraciones = tableCalibraciones.getTableHeader();
        TablaListadoCalibraciones.setLayout(new BorderLayout());
        TablaListadoCalibraciones.add(headerCalibraciones,BorderLayout.NORTH);
        TablaListadoCalibraciones.add(new JScrollPane(tableCalibraciones),BorderLayout.CENTER);

        //Inicializamos tabla mediciones
        cjntMediciones = new ConjuntoMediciones();
        modeloTablaMediciones = new ModeloTablaMediciones(cjntMediciones);
        tableMediciones.setModel(modeloTablaMediciones);
        JTableHeader headerMediciones = tableMediciones.getTableHeader();
        TablaListadoMediciones.setLayout(new BorderLayout());
        TablaListadoMediciones.add(headerMediciones,BorderLayout.NORTH);
        TablaListadoMediciones.add(new JScrollPane(tableMediciones),BorderLayout.CENTER);


    //------------------------------------------------------Botones del Panel TIPOS de INSTRUMENTOS (...TIPINS)
        guardarButtonTIPINS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtCodigo = txtCodigoTIPINS.getText();
                String txtNombre = txtNombreTIPINS.getText();
                String txtUnidad = txtUnidadTIPINS.getText();
                comboBoxTipoINS.addItem(txtNombre); // Añade el nombre del tipo a ComboBox
                tiposInstrumento = new TiposInstrumento(txtCodigo,txtNombre,txtUnidad);
                cjntTiposInsrumentos.agregar(tiposInstrumento);
                model.setRowCount(0);
                for(int i = 0; i < cjntTiposInsrumentos.numTipoInstrumento();i++){
                    Object [] fila={
                            cjntTiposInsrumentos.recuperar(i).getCodigo(),
                            cjntTiposInsrumentos.recuperar(i).getNombre(),
                            cjntTiposInsrumentos.recuperar(i).getUnidad()

                    };
                    model.addRow(fila);
                }
                modeloTablaTipoInstrumentos.fireTableDataChanged();
                JOptionPane.showMessageDialog(null, "Tipo de instrumento agregado existosamente");
                txtCodigoTIPINS.setText("");
                txtNombreTIPINS.setText("");
                txtUnidadTIPINS.setText("");
                comboBoxTipoINS.setSelectedItem("Seleccione un tipo");
            }
        });
        limpiarButtonTIPINS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCodigoTIPINS.setText("");
                txtUnidadTIPINS.setText("");
                txtNombreTIPINS.setText("");
                comboBoxTipoINS.setSelectedItem("Seleccione un tipo");
                modeloTablaTipoInstrumentos.fireTableDataChanged();
            }
        });
        borrarButtonTIPINS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String referenciaCodigo = txtCodigoTIPINS.getText();
                String referenciaNombre = txtNombreTIPINS.getText();
                String referenciaUnidad = txtUnidadTIPINS.getText();

                comboBoxTipoINS.removeItem(referenciaNombre); // elimina el item de comboBox
                refrescarInstrumentos();

                tiposInstrumento = new TiposInstrumento(referenciaCodigo,referenciaNombre,referenciaUnidad);
                cjntTiposInsrumentos.borrar(referenciaCodigo,referenciaNombre,referenciaUnidad);

                for(int i = 0; i < cjntTiposInsrumentos.numTipoInstrumento();i++){
                    if(tiposInstrumento.getNombre()== referenciaNombre && tiposInstrumento.getCodigo() == referenciaCodigo
                            && tiposInstrumento.getUnidad() == referenciaUnidad){
                        Object [] fila={
                                cjntTiposInsrumentos.recuperar(i).getCodigo(),
                                cjntTiposInsrumentos.recuperar(i).getNombre(),
                                cjntTiposInsrumentos.recuperar(i).getUnidad()

                        };
                    }

                }
                modeloTablaTipoInstrumentos.fireTableDataChanged();
                JOptionPane.showMessageDialog(null,"Tipo de instrumento eliminado exitosamente.");
            }
        });
        buscarButtonTIPINS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String referencNombre = txtNombreTIPINS.getText();
                JOptionPane.showMessageDialog(panelPrincipal,cjntTiposInsrumentos.buscar(referencNombre));
            }
        });
        reporteButtonTIPINS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Document d;
                try {
                    d = UtilidadesXML.crearDocumento();
                    Node r = d.createElement("DatosClientes");

                    int numero = cjntTiposInsrumentos.numTipoInstrumento();
                    int i = 0;
                    while(i <numero){
                        r.appendChild(cjntTiposInsrumentos.recuperar(i).toXML(d));
                        i++;
                    }
                    d.appendChild(r);

                    UtilidadesXML.guardarArchivoXML(d, "tiposDeInstrumento.xml");
                    JOptionPane.showMessageDialog(null,"Archivo XML generado exitosamente.");
                } catch (ParserConfigurationException ex) {
                    JOptionPane.showMessageDialog(null,"Error en el archivo XML");
                }
            }
        });

    //------------------------------------------------------Botones del Panel de INSTRUMENTOS (...INS)


        guardarButtonINS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String txtSerie = txtSerieINS.getText();
                String txtDescripcion = txtDescripcionINS.getText();
                int txtMinimo = Integer.parseInt(txtMinimoINS.getText());
                int txtMaximo = Integer.parseInt(txtMaximoINS.getText());
                int txtTolerancia = Integer.parseInt(txtToleranciaINS.getText());
                String txtTipo = (String) comboBoxTipoINS.getSelectedItem();

                Instrumento nuevoInstrumento = new Instrumento(txtSerie, txtDescripcion, txtMinimo, txtMaximo, txtTolerancia, txtTipo);

                nuevoInstrumento.getCaliInstrumento().agregarCalibracion(0,String.valueOf(FechaActual),a);

                cjntInstrumentos.agregar(nuevoInstrumento);

                refrescarInstrumentos();

                modeloTablaInstrumentos.fireTableDataChanged();
                JOptionPane.showMessageDialog(null, "Instrumento agregado existosamente");

                txtSerieINS.setText("");
                txtDescripcionINS.setText("");
                txtMinimoINS.setText("");
                txtMaximoINS.setText("");
                txtToleranciaINS.setText("");
                //comboBoxTipoINS.getSelectedItem("Seleccione una opcion");
            }

        });
        limpiarButtonINS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtSerieINS.setText("");
                txtDescripcionINS.setText("");
                txtMinimoINS.setText("");
                txtMaximoINS.setText("");
                txtToleranciaINS.setText("");
                modeloTablaInstrumentos.fireTableDataChanged();

            }
        });
        borrarButtonINS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtSerie = txtSerieINS.getText();
                String txtDescripcion = txtDescripcionINS.getText();
                int txtMinimo = Integer.parseInt(txtMinimoINS.getText());
                int txtMaximo = Integer.parseInt(txtMaximoINS.getText());
                int txtTolerancia = Integer.parseInt(txtToleranciaINS.getText());
                String txtTipo = (String) comboBoxTipoINS.getSelectedItem();

                instrumentos = new Instrumento(txtSerie,txtDescripcion,txtMinimo,txtMaximo,txtTolerancia,txtTipo);
                cjntInstrumentos.borrar(txtSerie,txtDescripcion,txtMinimo,txtMaximo,txtTolerancia,txtTipo);

                for(int i = 0; i < cjntInstrumentos.numInstrumento();i++){
                    if(instrumentos.getSerie().equals(txtSerie) && instrumentos.getDescripcion().equals(txtDescripcion)
                        && instrumentos.getMinimo() == txtMinimo && instrumentos.getMaximo() == txtMaximo
                        && instrumentos.getTolerancia() == txtTolerancia && instrumentos.getTipo().equals(txtTipo)){
                        Object [] fila={
                                cjntInstrumentos.recuperar(i).getSerie(),
                                cjntInstrumentos.recuperar(i).getDescripcion(),
                                cjntInstrumentos.recuperar(i).getMinimo(),
                                cjntInstrumentos.recuperar(i).getMaximo(),
                                cjntInstrumentos.recuperar(i).getTolerancia(),
                                cjntInstrumentos.recuperar(i).getTipo()
                        };
                    }
                }
                modeloTablaInstrumentos.fireTableDataChanged();
                JOptionPane.showMessageDialog(null,"instrumento eliminado exitosamente.");

                txtSerieINS.setText("");
                txtDescripcionINS.setText("");
                txtMinimoINS.setText("");
                txtMaximoINS.setText("");
                txtToleranciaINS.setText("");
            }
        });

        reporteButtonINS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Document d;
                try {
                    d = UtilidadesXML.crearDocumento();
                    Node r = d.createElement("DatosInstrumentos");

                    int numero = cjntInstrumentos.numInstrumento();
                    int i = 0;
                    while(i <numero){
                        r.appendChild(cjntInstrumentos.recuperar(i).toXML(d));
                        i++;
                    }
                    d.appendChild(r);

                    UtilidadesXML.guardarArchivoXML(d, "instrumentos.xml");
                    JOptionPane.showMessageDialog(null,"Archivo XML generado exitosamente.");
                } catch (ParserConfigurationException ex) {
                    JOptionPane.showMessageDialog(null,"Error en el archivo XML");
                }
            }
        });
        buscarButtonINS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                instrumentos = null;
                String referenciaDescripcion = txtBusquedaDescripcionINS.getText();
                for (int i = 0; i < cjntInstrumentos.numInstrumento(); i++) {
                    if (Objects.equals(cjntInstrumentos.recuperar(i).getDescripcion(), referenciaDescripcion)) {
                        instrumentos = cjntInstrumentos.recuperar(i);
                    }
                }
                if(instrumentos != null) {
                    JOptionPane.showMessageDialog(null, instrumentos.toString());
                }else{
                    JOptionPane.showMessageDialog(null, "No se encontro el instrumento");
                }
            }
        });
        comboBoxTipoINS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refrescarInstrumentos();
            }
        });

    //------------------------------------------------------Botones del Panel de CALIBRACIONES (...CALI)

        guardarButtonCALI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int referenciaNoCalibraciones = Integer.parseInt(txtNumeroCALI.getText());
                String referenciaFecha = txtFechaCALI.getText();
                int referenciaMediciones = Integer.parseInt(txtMedicionesCALI.getText());
                Calibraciones calibracion = new Calibraciones(referenciaNoCalibraciones, referenciaFecha, referenciaMediciones);
                cjntCalibraciones.agregar(calibracion);
                model.setRowCount(0);
                a++;
                for(int i = 0; i < cjntCalibraciones.numCalibraciones();i++){
                    Calibraciones cal = cjntCalibraciones.recuperar(i);
                    Object [] fila={
                            cjntCalibraciones.recuperar(i).getNumeroCalibracion(),
                            cjntCalibraciones.recuperar(i).getFecha(),
                            cjntCalibraciones.recuperar(i).getMediciones(),

                    };
                    model.addRow(fila);
                }
                modeloTablaCalibraciones.fireTableDataChanged();
                JOptionPane.showMessageDialog(null, "Calibracion agregada existosamente");
            }
        });
        limpiarButtonCALI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNumeroCALI.setText("");
                txtMedicionesCALI.setText("");
                txtInstrumentoCALI.setText("");
                txtFechaCALI.setText("");
                tableInstrumentos.clearSelection();
                tableCalibraciones.clearSelection();
                txtFechaCALI.setText("");
                limpiarTablaMediciones();
                TablaListadoMediciones.setVisible(false);

                // Obtén el modelo de la tablaMediciones (ModeloTablaMediciones)
                ModeloTablaMediciones model = (ModeloTablaMediciones) tableMediciones.getModel();

                // Limpia los datos del modelo personalizado
                model.clearData();

                // Notifica a la tabla que se han cambiado los datos
                model.fireTableDataChanged();
            }
        });

        borrarButtonCALI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int referenciaNoMediciones = Integer.parseInt(txtMedicionesCALI.getText());
                String referenciaFecha = txtFechaCALI.getText();
                int referenciaMediciones = Integer.parseInt(txtMedicionesCALI.getText());

               // calibraciones = new Calibraciones(referenciaNoMediciones,referenciaFecha,referenciaMediciones);
                cjntCalibraciones.borrar(referenciaNoMediciones,referenciaFecha,referenciaMediciones);

                for (int i = 0; i < cjntCalibraciones.numCalibraciones(); i++) {
                    Calibraciones calibracion = cjntCalibraciones.recuperar(i); // Obtener la calibración actual
                    if (calibracion.getNumeroCalibracion() == referenciaNoMediciones
                            && calibracion.getFecha().equals(referenciaFecha) // Usar equals para comparar cadenas
                            && calibracion.getCantMediciones() == referenciaMediciones) {
                        Object[] fila = {
                                calibracion.getNumeroCalibracion(),
                                calibracion.getFecha(),
                                calibracion.getMediciones()
                        };
                        // Haz lo que necesites con la fila aquí
                    }
                }

                modeloTablaCalibraciones.fireTableDataChanged();
                JOptionPane.showMessageDialog(null,"Calibracion eliminado exitosamente.");
            }
        });
        reporteButtonCALI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Document d;
                try {
                    d = UtilidadesXML.crearDocumento();
                    Node r = d.createElement("DatosCalibraciones");

                    int numero = cjntCalibraciones.numCalibraciones();
                    int i = 0;
                    while(i <numero){
                        r.appendChild(cjntCalibraciones.recuperar(i).toXML(d));
                        i++;
                    }
                    d.appendChild(r);

                    UtilidadesXML.guardarArchivoXML(d, "calibraciones.xml");
                    JOptionPane.showMessageDialog(null,"Archivo XML generado exitosamente.");
                } catch (ParserConfigurationException ex) {
                    JOptionPane.showMessageDialog(null,"Error en el archivo XML");
                }
            }
        });
        buscarButtonCALI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int referenciaNumero = Integer.parseInt(txtBusquedaNumeroCALI.getText());
                JOptionPane.showMessageDialog(panelPrincipal,cjntCalibraciones.buscar(referenciaNumero));
            }
        });

        //Seleccion de Instrumento en la Tabla
        tableInstrumentos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int filaSeleccionada = tableInstrumentos.getSelectedRow();
                txtFechaCALI.setText(String.valueOf(FechaActual));
                if (filaSeleccionada >= 0) {
                    // Obtener la información del instrumento seleccionado
                    String serie = tableInstrumentos.getValueAt(filaSeleccionada, 0).toString();
                    //ConjuntoTipos tipoS = tableInstrumentos.getValueAt(filaSeleccionada, 1).toString();
                    String descripcion = tableInstrumentos.getValueAt(filaSeleccionada, 1).toString();
                    String min = tableInstrumentos.getValueAt(filaSeleccionada, 2).toString();
                    String max = tableInstrumentos.getValueAt(filaSeleccionada, 3).toString();
                    String tolerancia = tableInstrumentos.getValueAt(filaSeleccionada, 4).toString();
                    // Actualizar los campos de texto
                    txtSerieINS.setText(serie);
                    txtDescripcionINS.setText(descripcion);
                    txtMinimoINS.setText(String.valueOf(min));
                    txtMaximoINS.setText(String.valueOf(max));
                    txtToleranciaINS.setText(String.valueOf(tolerancia));
                    txtInstrumentoCALI.setText(serie +" - "+ descripcion +" ("+ min +" - "+ max +" | "+ tolerancia +")");
                    txtNumeroCALI.setText(String.valueOf(b));
                    b++;
                    // Deshabilitar el botón de limpiar
                    //limpiarButtonINS.setEnabled(false);
                    // Habilitar el botón de borrar
                    borrarButtonINS.setEnabled(true);

                }
            }
        });
        tableCalibraciones.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = tableCalibraciones.getSelectedRow();
                    tableMediciones.setEnabled(true);
                    if (selectedRow >= 0) {
                        tableMediciones.setEnabled(true);
                        tableMediciones.setVisible(true);
                        Calibraciones calibracionSeleccionada = cjntCalibraciones.recuperar(selectedRow);
                        String referenciaFecha = String.valueOf(FechaActual);
                        int cantMediciones = Integer.parseInt(txtMedicionesCALI.getText());
                        int noCalibracionReferencia = Integer.parseInt(txtNumeroCALI.getText());

                        // Eliminar todas las mediciones existentes antes de agregar nuevas
                        //cjntMediciones.getMediciones().clear();

                        // Crear las mediciones automáticamente
                        List<Mediciones> medicionesCalibracion = Mediciones.generarMediciones(cantMediciones, 90.0);

                        // Actualizar la tabla de mediciones
                        cjntMediciones.agregarMediciones(medicionesCalibracion);
                        actualizarTablaMediciones(cjntMediciones.getMediciones()); // Actualiza la tabla con todas las mediciones

                        // Restablecer el valor de txtNumeroCALI
                        //txtNumeroCALI.setText(String.valueOf(noCalibracionReferencia + 1));
                        TablaListadoMediciones.setVisible(true);
                    } else {
                        tableMediciones.setEnabled(false);
                        tableMediciones.setVisible(false);
                    }
                }
            }
        });



    }
    
//-------------------------------------------------------------------MAIN-----------------------------------------------------
    public static void main(String[] args) {
        HELLO hi = new HELLO();
        hi.setContentPane(hi.panelPrincipal);
        hi.setTitle("SILAB: Sistema de laboratorio Industrial");
        hi.setSize(1000,800);
        hi.setLocationRelativeTo(null);
        hi.setVisible(true);
        hi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
