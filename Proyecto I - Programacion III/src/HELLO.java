import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HELLO extends JFrame{
   private JPanel panelPrincipal;
    private JTabbedPane tabbedPane1;
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
    private JTable table1;
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
    private JButton buscar;
    private JButton reporteButton;
    private JButton reporte = new JButton("Reporte",icon);
    private JTable table2;
    private ConjuntoTiposInstrumento cjntTiposInsrumentos;
    private ConjuntoInstrumentos cjntInstrumentos;
    private ModeloTablaTipoInstrumentos modeloTablaTipoInstrumentos;
    private ModeloTablaInstrumentos modeloTablaInstrumentos;
    private JTextField txtReferencia;
    public TiposInstrumento tiposInstrumento;
    public Instrumento instrumentos;

    public void refrescarTabla() {
        tablaTiposInstruemento.setModel(model);
    }
    DefaultTableModel model = new DefaultTableModel();

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

        //JTable tablaInstrumentos = new JTable();
        //modeloTablaInstrumentos.addColumn("No. Serie");
        //modeloTablaInstrumentos.addColumn("Descripcion");
        //modeloTablaInstrumentos.addColumn("Minimo");
        //modeloTablaInstrumentos.addColumn("Maximo");
        //modeloTablaInstrumentos.addColumn("Tolerancia");
        guardarButtonINS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtSerie = txtSerieINS.getText();
                String txtDescripcion = txtDescripcionINS.getText();
                int txtMinimo = Integer.parseInt(txtMinimoINS.getText());
                int txtMaximo = Integer.parseInt(txtMaximoINS.getText());
                int txtTolerancia = Integer.parseInt(txtToleranciaINS.getText());
                String txtTipo = comboBoxTipoINS.getName();

                Instrumento nuevoInstrumento = new Instrumento(txtSerie, txtDescripcion, txtMinimo, txtMaximo, txtTolerancia, txtTipo);

                cjntInstrumentos.agregar(nuevoInstrumento);

                model.setRowCount(0);
                for (int i = 0; i < cjntInstrumentos.numInstrumento(); i++) {
                    Object[] fila = {
                            cjntInstrumentos.recuperar(i).getSerie(),
                            cjntInstrumentos.recuperar(i).getDescripcion(),
                            cjntInstrumentos.recuperar(i).getMinimo(),
                            cjntInstrumentos.recuperar(i).getMaximo(),
                            cjntInstrumentos.recuperar(i).getTolerancia(),
                            cjntInstrumentos.recuperar(i).getTipo()
                    };
                    model.addRow(fila);
                }

                modeloTablaInstrumentos.fireTableDataChanged();
                JOptionPane.showMessageDialog(null, "Instrumento agregado existosamente");
            }

        });
        guardarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtCodigo = codigo.getText();
                String txtNombre = nombre.getText();
                String txtUnidad = unidad.getText();
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
                codigo.setText("");
                unidad.setText("");
                nombre.setText("");
                modeloTablaTipoInstrumentos.fireTableDataChanged();
            }
        });
        borrarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String referenciaCodigo = codigo.getText();
                String referenciaNombre = nombre.getText();
                String referenciaUnidad = unidad.getText();
                cjntTiposInsrumentos.borrar(referenciaCodigo,referenciaNombre,referenciaUnidad);
                for(int i = 0; i < cjntTiposInsrumentos.numTipoInstrumento();i++){
                    if(tiposInstrumento.getNombre() == referenciaNombre && tiposInstrumento.getCodigo() == referenciaCodigo
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

        guardarButtonINS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtCodigo = codigo.getText();
                String txtNombre = nombre.getText();
                String txtUnidad = unidad.getText();
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
                String txtTipo = comboBoxTipoINS.getName();

                cjntInstrumentos.borrar(txtSerie, txtDescripcion, txtMinimo, txtMaximo, txtTolerancia, txtTipo);

                for (int i = 0; i < cjntTiposInsrumentos.numTipoInstrumento(); i++) {
                    if (instrumentos.getSerie().equals(txtSerie) &&
                            instrumentos.getDescripcion().equals(txtDescripcion) &&
                            instrumentos.getMinimo() == txtMinimo && // Usamos == para comparar ints
                            instrumentos.getMaximo() == txtMaximo && // Usamos == para comparar ints
                            instrumentos.getTolerancia() == txtTolerancia  &&
                            instrumentos.getTipo().equals(txtTipo)) {

                        Object[] fila = {
                                cjntInstrumentos.recuperar(i).getSerie(),
                                cjntInstrumentos.recuperar(i).getDescripcion(),
                                cjntInstrumentos.recuperar(i).getMinimo(),
                                cjntInstrumentos.recuperar(i).getMaximo(),
                                cjntInstrumentos.recuperar(i).getTolerancia()
                        };
                    }
                }

                modeloTablaTipoInstrumentos.fireTableDataChanged();
                JOptionPane.showMessageDialog(null, "Tipo de instrumento eliminado exitosamente.");
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
    }

    public static void main(String[] args) {
        HELLO hi = new HELLO();
        hi.setContentPane(hi.panelPrincipal);
        hi.setTitle("SILAB: Sistema de laboratorio Industrial");
        hi.setSize(900,400);

        hi.setLocationRelativeTo(null);
        hi.setVisible(true);
        hi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
