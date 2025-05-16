import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Forma extends  JFrame{
    private JPanel panelPrincipal;
    private JTextField campoDeTexto;
    private JLabel replicadorLabel;

    public Forma(){
        inicializarForma();

        campoDeTexto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                replicarTexto();
            }
        });
    }

    private  void replicarTexto(){
        this.replicadorLabel.setText(this.campoDeTexto.getText());
    }
    private void inicializarForma(){
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cuando se cierre la ventana se termina la aplicacion
        setSize(600,400);
        setLocationRelativeTo(null);//Centramos la ventana

    }

    public static void main(String[] args) {
        FlatDarculaLaf.setup(); //Cambiar el look and feel a Modo oscuro.
        Forma forma = new Forma();

        forma.setVisible(true);
    }
}
