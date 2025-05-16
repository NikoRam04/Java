import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import javax.swing.plaf.metal.MetalBorders;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogingForm extends  JFrame {
    private JPanel PanelPrincipal;
    private JTextField textField1;
    private JPasswordField paswordTexto;
    private JButton enviarBoton;

    public LogingForm(){
        inicializarForma();

        enviarBoton.addActionListener(e -> validar());
    }

    private  void inicializarForma(){
        setContentPane(PanelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
        setLocationRelativeTo(null);
    }

    private void validar(){
        //Leer Valores
        var usuario = this.textField1.getText();
        var password = this.paswordTexto.getPassword();

        if("admin".equals(password) && "root".equals(usuario)){
            mostrarMensaje("Datos correctos , bienvenido");
        }
        else if ("root".equals(usuario))
            mostrarMensaje("Password incorrecto");
        else
            mostrarMensaje("Usuario incorrecto , corregirlo");
    }

    private void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(this , mensaje);
    }

    public static void main(String[] args) {
        FlatDarculaLaf.setup(); // Modo oscuro
        LogingForm logingForm = new LogingForm();
        logingForm.setVisible(true);
    }
}
