package nicoprojects.zona_fit;

import com.formdev.flatlaf.FlatDarculaLaf;
import nicoprojects.zona_fit.gui.ZonaFitForma;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

//@SpringBootApplication
public class ZonaFitSwing {
    public static void main(String[] args) {
        //Configuracion del modo oscuro
        FlatDarculaLaf.setup();

        //Instanciar la fabrica de spring
        ConfigurableApplicationContext contextoSpring  = new SpringApplicationBuilder(ZonaFitSwing.class)
                                                        .headless(false)
                                                        .web(WebApplicationType.NONE)
                                                        .run(args);

        //Se invoca despues que se crea la fabrica de Spring
        //Ejecutar la aplicacion de forma indirecta , despues de levantar a fabrica de spring
        SwingUtilities.invokeLater(() -> {
            //Recuperar el objeto de spring
            ZonaFitForma zonaFitForma = contextoSpring.getBean(ZonaFitForma.class);
            //ZonaFitForma zonaFitForma = new ZonaFitForma(); este codigo ya no se utiliza ,
            // sino no se podria inyetar  dependdencias.
            zonaFitForma.setVisible(true);
        });
    }
}
