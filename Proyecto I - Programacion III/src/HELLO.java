import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HELLO extends JFrame{
   private JPanel panelPrincipal;
    private JTabbedPane tabbedPane1;
    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtUnidad;
    private JButton guardarButton;
    private JButton limpiarButton;
    private JButton borrarButton;
    private JTextField txtBuscarPorNombre;
    private JButton reporteButton;
    private JButton buscarButton;
    private JTable Listado;


    public HELLO(){
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(guardarButton, "Guardado");
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

    
}
