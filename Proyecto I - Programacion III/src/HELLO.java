import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class HELLO extends JFrame{
   private JPanel panelPrincipal;
    private JTabbedPane tablaInstrumentosINS;
    private JButton guardarButtonINS;
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
    private JPanel Calibraciones;
    private JButton guardarButton;
    private JButton borrarButton;
    private JButton limpiarButton;
    private JButton buscarButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel infoCalib;
    ImageIcon icon = new ImageIcon("C:\\Users\\ypgon\\Desktop\\Proyecto I - Progra III\\Proyecto I\\Proyecto I - Programacion III\\src\\Imagenes\\pdf-icon-png-pdf-zum-download-2.png"); // Reemplaza con la ruta de tu imagen
    private JButton guardarButton1;
    private JButton borrarButton1;
    private JButton limpiarButton1;
    private JTextField unidad;
    private JTextField codigo;
    private JTextField nombre;
    private JTable tablaTiposInstruemento;
    private JTable tablaCalibraciones;
    private JButton buscar;
    private JButton reporteButton;
    private JButton reporte = new JButton("Reporte",icon);
    private JTable table2;
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
    //private void setImageLabel(JLabel labelName, String root){
      //  ImagenIcon image = new ImageIcon(root);
        //Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.get))
        //}
    public HELLO(){

        JTable tablaTiposInstrumento = new JTable();
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Unidad");
        refrescarTabla();
        cjntTiposInsrumentos = new ConjuntoTiposInstrumento();
        modeloTablaTipoInstrumentos = new ModeloTablaTipoInstrumentos(cjntTiposInsrumentos);
        tablaTiposInstrumento.setModel(modeloTablaTipoInstrumentos);

        //String[] opciones = {"Opción 1", "Opción 2", "Opción 3", "Opción 4"};
       // comboBoxTipoINS = new JComboBox<>(opciones);

        JTable tablaInstrumentosINS = new JTable();
        //model.addColumn("No. Serie");
        modelINS.addColumn("Descripcion");
        modelINS.addColumn("Minimo");
        modelINS.addColumn("Maximo");
        modelINS.addColumn("Tolerancia");
        refrescarTablaInstrumentos();
        cjntInstrumentos = new ConjuntoInstrumentos();
        modeloTablaInstrumentos =new ModeloTablaInstrumentos(cjntInstrumentos);
        tablaInstrumentosINS.setModel(modeloTablaTipoInstrumentos);
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

        //guardar los tipos de instrumentos
        guardarButton1.addActionListener(new ActionListener() {
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
        limpiarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                codigo.setText(" ");
                unidad.setText(" ");
                nombre.setText(" ");
                modeloTablaTipoInstrumentos.fireTableDataChanged();
            }
        });
        borrarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String referenciaCodigo = codigo.getText();
                String referenciaNombre = nombre.getText();
                String referenciaUnidad = unidad.getText();

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
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String referencNombre = nombre.getText();
                JOptionPane.showMessageDialog(panelPrincipal,cjntTiposInsrumentos.buscar(referencNombre));
            }
        });
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


                //cjntInstrumentos.borrar(txtSerie, txtDescripcion, txtMinimo, txtMaximo, txtTolerancia, txtTipo);
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
                String referenciaDescripcion = txtDescripcionINS.getText();
                JOptionPane.showMessageDialog(panelPrincipal,cjntInstrumentos.buscar(referenciaDescripcion));
            }
        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double txtNumero = Double.parseDouble(textField2.getText());
                String txtFecha = textField4.getText();
                int txtMediciones = Integer.parseInt(textField3.getText());
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
        limpiarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField2.setText("");
                textField4.setText("");
                textField3.setText("");
                modeloTablaTipoInstrumentos.fireTableDataChanged();
            }
        });
        borrarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double txtNumero = Double.parseDouble(textField2.getText());
                String txtFecha = textField4.getText();
                int txtMediciones = Integer.parseInt(textField3.getText());

                cjntCalibraciones.borrar(txtNumero,txtFecha,txtMediciones);

                for (int i = 0; i < cjntCalibraciones.numCalibraciones(); i++) {
                    if (calibraciones.getNumeroCalibracion() == txtNumero &&
                            calibraciones.getFecha().equals(txtFecha) &&
                            calibraciones.getMediciones() == txtMediciones) {

                        Object[] fila = {
                                cjntCalibraciones.recuperar(i).getNumeroCalibracion(),
                                cjntCalibraciones.recuperar(i).getFecha(),
                                cjntCalibraciones.recuperar(i).getMediciones()
                        };
                    }
                }

                modeloTablaCalibraciones.fireTableDataChanged();
                JOptionPane.showMessageDialog(null, "Calibracion eliminada exitosamente.");
            }
        });
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
        comboBoxTipoINS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refrescarInstrumentos();
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
