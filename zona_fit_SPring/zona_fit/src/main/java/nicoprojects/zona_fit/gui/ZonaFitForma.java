package nicoprojects.zona_fit.gui;

import nicoprojects.zona_fit.servicio.ClienteServicio;
import nicoprojects.zona_fit.servicio.IClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class ZonaFitForma extends JFrame{
    private JPanel PanelPrincipal;


    IClienteServicio clienteServicio;

    //1.- Inyeccion de dependencias , antes de la definicion del constructor
    @Autowired
    public ZonaFitForma(ClienteServicio clienteServicio){
        this.clienteServicio = clienteServicio;
        iniciarForma();
    }

    private void iniciarForma(){
        setContentPane(PanelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,700);
        setLocationRelativeTo(null); // Centrar ventana.
    }
}
