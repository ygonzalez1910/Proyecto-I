import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class HELLO extends JFrame{
   private JPanel panelPrincipal;
    private JTabbedPane tablaInstrumentosINS;
    private JButton guardarInstrumento;
    private JTextField txtSerieINS;
    private JTextField txtMinimoINS;
    private JTextField txtToleranciaINS;
    private JTextField txtDescripcionINS;
    private JTextField txtMaximoINS;
    private JComboBox comboBoxTipoINS;
    private JButton limpiarInstrumento;
    private JButton borrarInstrumento;
    private JButton buscarButtonINS;
    private JButton reporteButtonINS;
    private JTable tableInstrumentos;
    private JPanel Calibraciones;
    private JButton guardarCalibracion;
    private JButton borrarCalibracion;
    private JButton limpiarCalibracion;
    private JButton buscarButton;
    private JTextField txtNoBusqueda;
    private JTextField txtNoCalibracion;
    private JTextField txtMediciones;
    private JTextField txtFecha;
    private JLabel infoCalib;
    //ImageIcon icon = new ImageIcon("C:\\Users\\ypgon\\Desktop\\Proyecto I - Progra III\\Proyecto I\\Proyecto I - Programacion III\\src\\Imagenes\\pdf-icon-png-pdf-zum-download-2.png"); // Reemplaza con la ruta de tu imagen
    ImageIcon iconUNA= new ImageIcon("src\\Imagenes\\logo-universidad-nacional-costa-rica.png");
    private JButton guardarTipoIns;
    private JButton borrarTipoIns;
    private JButton limpiarTipoIns;
    private JTextField unidad;
    private JTextField codigo;
    private JTextField nombre;
    private JTable tablaTiposInstruemento;
    private JButton buscar;
    private JButton reporteButton;
    private JButton reporte ;
    private JLabel imagenUNA = new JLabel(iconUNA);
    private JTable tablaCalibraciones;
    private JPanel TablaListadoTiposIns;
    private JPanel TablaListadoCalibraciones;
    private JPanel TablaListadoInstrumentos;
    private JPanel informacionTipoIns;
    private JPanel TipoIns;
    private JPanel BusquedaPanel;
    private JPanel busquedaPanelns;
    private JLabel serieBusquedaLabel;
    private JPanel ListadoTipoIns;
    private JTextField txtSerieBusqueda;
    private JButton busquedaInstrumento;
    private JPanel Instrumentos;
    private JPanel InfoIns;
    private JPanel AcercaDe;
    private JLabel txtSerie;
    private JLabel txtTipo;
    private JLabel txtMaximo;
    private JLabel txtDescripcion;
    private JLabel txtTolerancia;
    private JLabel txtMinimo;
    private JPanel InstrumentoCalibracion;
    private JPanel Calibracion;
    private JPanel BusquedaCalibracion;
    private JLabel numeroCalibracion;
    private JLabel numeroMediciones;
    private JLabel fecha;
    private JLabel NumeroCalibBusqueda;
    private JButton reporteInstrumento;
    //private JPanel tabla;
    private ConjuntoTiposInstrumento cjntTiposInsrumentos;
    private ConjuntoInstrumentos cjntInstrumentos;
    private ConjuntoCalibraciones cjntCalibraciones;
    private ModeloTablaTipoInstrumentos modeloTablaTipoInstrumentos;
    private ModeloTablaCalibraciones modeloTablaCalibraciones;
    private ModeloTablaInstrumentos modeloTablaInstrumentos;
    private JTextField txtReferencia;
    public TiposInstrumento tiposInstrumento;
    public Instrumento instrumentos;
    public Calibraciones calibraciones;
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel modelINS = new DefaultTableModel();

    private void initTable() {
        model = new DefaultTableModel(tiposInstrumento.nombreCampos(), 0);
        tablaTiposInstruemento.setModel(model);
    }

    private void initTableINS() {
      modelINS = new DefaultTableModel(instrumentos.nombreInstrumentos(),0);
      tableInstrumentos.setModel(modelINS);
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

    public void refrescarTabla() {
        tablaTiposInstruemento.setModel(model);
    }
    public void refrescarTablaInstrumentos(){
        tableInstrumentos.setModel(modelINS);
    }
    public HELLO(){
<<<<<<< HEAD
/*
=======

        //inicializacion valores de tipos de instrumento
>>>>>>> main
        JTable tablaTiposInstrumento = new JTable();
        cjntTiposInsrumentos = new ConjuntoTiposInstrumento();
        modeloTablaTipoInstrumentos = new ModeloTablaTipoInstrumentos(cjntTiposInsrumentos);
        tablaTiposInstrumento.setModel(modeloTablaTipoInstrumentos);
<<<<<<< HEAD
*/
        cjntTiposInsrumentos = new ConjuntoTiposInstrumento();
        modeloTablaTipoInstrumentos = new ModeloTablaTipoInstrumentos(cjntTiposInsrumentos);
        tablaTiposInstruemento.setModel(modeloTablaTipoInstrumentos);
        JTableHeader headerTipoINS = tablaTiposInstruemento.getTableHeader();
        tablaListadoTiposINS.setLayout(new BorderLayout());
        tablaListadoTiposINS.add(headerTipoINS, BorderLayout.NORTH);
        tablaListadoTiposINS.add(new JScrollPane(tablaTiposInstruemento), BorderLayout.CENTER);
        //String[] opciones = {"Opción 1", "Opción 2", "Opción 3", "Opción 4"};
       // comboBoxTipoINS = new JComboBox<>(opciones);

=======

        //nombre columnas de Tipos de Instrumento
        JTableHeader headerTipoInst = tablaTiposInstrumento.getTableHeader();
        TablaListadoTiposIns.setLayout(new BorderLayout());
        TablaListadoTiposIns.add(headerTipoInst,BorderLayout.NORTH);
        TablaListadoTiposIns.add(new JScrollPane(tablaTiposInstrumento),BorderLayout.CENTER);

        //inicializacion valores de instrumentos
>>>>>>> main
        cjntInstrumentos = new ConjuntoInstrumentos();
        modeloTablaInstrumentos = new ModeloTablaInstrumentos(cjntInstrumentos);
        tableInstrumentos.setModel(modeloTablaInstrumentos);

        //nombre columnas de Instrumentos
        JTableHeader headerInstrumentos = tableInstrumentos.getTableHeader();
        TablaListadoInstrumentos.setLayout(new BorderLayout());
        TablaListadoInstrumentos.add(headerInstrumentos,BorderLayout.NORTH);
        TablaListadoInstrumentos.add(new JScrollPane(tableInstrumentos), BorderLayout.CENTER);

        //inicializacion valores de calibraciones
        cjntCalibraciones = new ConjuntoCalibraciones();
        modeloTablaCalibraciones = new ModeloTablaCalibraciones(cjntCalibraciones);
        tablaCalibraciones.setModel(modeloTablaCalibraciones);

        //nombres columnas de calibraciones
        JTableHeader headerCalibraciones = tablaCalibraciones.getTableHeader();
        TablaListadoCalibraciones.setLayout(new BorderLayout());
        TablaListadoCalibraciones.add(headerCalibraciones,BorderLayout.NORTH);
        TablaListadoCalibraciones.add(new JScrollPane(tablaCalibraciones), BorderLayout.CENTER);


        //guardar los tipos de instrumentos
        guardarTipoIns.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtCodigo = codigo.getText();
                String txtNombre = nombre.getText();
                String txtUnidad = unidad.getText();
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
            }
        });
        //limpiar tipoIns
        limpiarTipoIns.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                codigo.setText(" ");
                unidad.setText(" ");
                nombre.setText(" ");
                modeloTablaTipoInstrumentos.fireTableDataChanged();
            }
        });
        //buscar tipo de instrumentos
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String referencNombre = nombre.getText();
                JOptionPane.showMessageDialog(panelPrincipal,cjntTiposInsrumentos.buscar(referencNombre));
            }
        });
        //reporte tipos de instrumento
        reporte.addActionListener(new ActionListener() {
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

                    UtilidadesXML.guardarArchivoXML(d, "tipos de instrumento.xml");
                    JOptionPane.showMessageDialog(null,"Archivo XML generado exitosamente.");
                } catch (ParserConfigurationException ex) {
                    JOptionPane.showMessageDialog(null,"Error en el archivo XML");
                }
            }
        });
        //guardar calibraciones
        guardarCalibracion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double txtNumero = Double.parseDouble(txtNoCalibracion.getText());
                String txtFecha = HELLO.this.txtFecha.getText();
                int txtMediciones = Integer.parseInt(HELLO.this.txtMediciones.getText());
                Calibraciones calibracion = new Calibraciones(txtNumero,txtFecha,txtMediciones);
                cjntCalibraciones.agregar(calibracion);
                model.setRowCount(0);
                for(int i = 0; i < cjntCalibraciones.numCalibraciones();i++){
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
        //reporte calbraciones
        reporteButton.addActionListener(new ActionListener() {
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
        //BORRAR TIPOiNSTRUMENTO
        borrarTipoIns.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String referenciaCodigo = codigo.getText();
                String referenciaNombre = nombre.getText();
                String referenciaUnidad = unidad.getText();

                int filaSeleccionada = tablaTiposInstrumento.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    cjntTiposInsrumentos.eliminarFila(filaSeleccionada);
                    modeloTablaTipoInstrumentos.fireTableDataChanged();
                    DefaultComboBoxModel<String> comboBoxModel = (DefaultComboBoxModel<String>) comboBoxTipoINS.getModel();
                    comboBoxModel.removeElement(referenciaNombre);
                    cjntTiposInsrumentos.borrar(referenciaCodigo, referenciaNombre, referenciaUnidad);
                    JOptionPane.showMessageDialog(null, "Tipo de instrumento eliminado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar.");
                }
            }
        });

        //BOTON NUEVO
        guardarInstrumento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtSerie = txtSerieINS.getText();
                String txtDescripcion = txtDescripcionINS.getText();
                int txtMinimo = Integer.parseInt(txtMinimoINS.getText());
                int txtMaximo = Integer.parseInt(txtMaximoINS.getText());
                int txtTolerancia = Integer.parseInt(txtToleranciaINS.getText());
                String txtTipo = (String) comboBoxTipoINS.getSelectedItem();

                Instrumento nuevoInstrumento = new Instrumento(txtSerie, txtDescripcion, txtMinimo, txtMaximo, txtTolerancia, txtTipo);
                cjntInstrumentos.agregar(nuevoInstrumento);

                refrescarInstrumentos();

                modeloTablaInstrumentos.fireTableDataChanged();
                JOptionPane.showMessageDialog(null, "Instrumento agregado existosamente");

                txtSerieINS.setText("");
                txtDescripcionINS.setText("");
                txtMinimoINS.setText("");
                txtMaximoINS.setText("");
                txtToleranciaINS.setText("");
            }
        });
        //BOTON NUEVO
        limpiarInstrumento.addActionListener(new ActionListener() {
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
        //BOTON NUEVO
        borrarInstrumento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtSerie = txtSerieINS.getText();
                String txtDescripcion = txtDescripcionINS.getText();
                int txtMinimo = Integer.parseInt(txtMinimoINS.getText());
                int txtMaximo = Integer.parseInt(txtMaximoINS.getText());
                int txtTolerancia = Integer.parseInt(txtToleranciaINS.getText());
                String txtTipo = (String) comboBoxTipoINS.getSelectedItem();


                for (int i = 0; i < cjntInstrumentos.numInstrumento(); i++) {
                    if (Objects.equals(cjntInstrumentos.recuperar(i).getSerie(), txtSerie) &&
                            Objects.equals(cjntInstrumentos.recuperar(i).getDescripcion(), txtDescripcion) &&
                            cjntInstrumentos.recuperar(i).getMinimo() == txtMinimo && // Usamos == para comparar ints
                            cjntInstrumentos.recuperar(i).getMaximo() == txtMaximo && // Usamos == para comparar ints
                            cjntInstrumentos.recuperar(i).getTolerancia() == txtTolerancia  &&
                            Objects.equals(cjntInstrumentos.recuperar(i).getTipo(), txtTipo)) {
                        Instrumento a =  cjntInstrumentos.recuperar(i);
                        cjntInstrumentos.remover(a);
                        modeloTablaTipoInstrumentos.fireTableDataChanged();
                        JOptionPane.showMessageDialog(null, "Tipo de instrumento eliminado exitosamente.");
                        refrescarInstrumentos(); // actualiza la tabla
                        txtSerieINS.setText("");
                        txtDescripcionINS.setText("");  // una vez boorado el elemento se limpian los textField
                        txtMinimoINS.setText("");
                        txtMaximoINS.setText("");
                        txtToleranciaINS.setText("");
                    }
                }
            }
        });
        //BOTON NUEVO
        busquedaInstrumento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String referenciaDescripcion = txtDescripcionINS.getText();
                JOptionPane.showMessageDialog(panelPrincipal,cjntInstrumentos.buscar(referenciaDescripcion));
            }
        });
        comboBoxTipoINS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refrescarInstrumentos();
            }
        });
        reporteInstrumento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Document d;
                try {
                    d = UtilidadesXML.crearDocumento();
                    Node r = d.createElement("datosInstrumentos");

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
    }

    public static void main(String[] args) {
        HELLO hi = new HELLO();
        hi.setContentPane(hi.panelPrincipal);
        hi.setTitle("SILAB: Sistema de laboratorio Industrial");
        hi.setSize(900,400);

        hi.initTable();
        hi.initTableINS();


        hi.setLocationRelativeTo(null);
        hi.setVisible(true);
        hi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
