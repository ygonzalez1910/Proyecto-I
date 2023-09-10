import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HELLO extends JFrame{
    private JPanel panelPrincipal;
    private JTextField txtSerie, txtDescripcion, txtMaximo, txtMinimo, txtTolerancia, txtDescBusqueda;
    private JButton btnGuardar,btnLimpiar,btnBorrar,btnReporte,btnBuscar;
    private JComboBox comboBoxTIPO;
    private JTable table;
    private JMenuBar menuPrincipal;
    private JMenu tipoInstrumento, instrumento, calibraciones;

    public HELLO(){
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(btnGuardar, "Guardado");
            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(btnLimpiar, "Limpiado");
            }
        });
        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(btnBorrar, "Borrado");
            }
        });
        btnReporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(btnReporte, "Reporte...");
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(btnBuscar, "Buscando...");
            }
        });
        ajustarMenus();
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
    private void ajustarMenus(){
        menuPrincipal = new JMenuBar();
        menuPrincipal.add(tipoInstrumento=new JMenu("Tipos de intrumentos"));
        menuPrincipal.add(instrumento =new JMenu("Intrumentos"));
        menuPrincipal.add(calibraciones=new JMenu("Calibraciones"));
        setJMenuBar(menuPrincipal);
    }

}
