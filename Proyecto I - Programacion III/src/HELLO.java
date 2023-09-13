import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HELLO extends JFrame{
   private JPanel panelPrincipal;
    private JTabbedPane tabbedPane1;
    private JButton guardarButtonINS;
    private JTextField txtCodTipoInstrumento;
    private JTextField txtNomTipoIns;
    private JTextField txtBuscarNombreTI;
    private JButton reporteTIButton;
    private JButton buscarTIButton;
    private JTable ListadoTipInst;
    private JTextField txtUnidTipInst;
    private JButton guardarTIButton;
    private JButton limpiarButtonTI;
    private JButton borrarButtonTI;
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
    private JTable table2;
    private JScrollPane tablaCalibraciones;
    private JButton guardarButton;
    private JButton borrarButton;
    private JButton limpiarButton;
    private JButton buscarButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel infoCalib;
    private JButton reporteButton;


    public HELLO(){
        guardarButtonINS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(guardarButtonINS, "Guardado");
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
