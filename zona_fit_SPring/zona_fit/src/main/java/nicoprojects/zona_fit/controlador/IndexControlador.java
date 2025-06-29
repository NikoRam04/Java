package nicoprojects.zona_fit.controlador;


import jakarta.annotation.PostConstruct;
import jakarta.faces.annotation.View;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import nicoprojects.zona_fit.modelo.Cliente;
import nicoprojects.zona_fit.servicio.IClienteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data //Generar metodos sett y get
@ViewScoped
/*LA aplicacion sera una aplicacion de solo una pagia  y se actualizara la informacion de forma parcial.
* AJAX - Asynchronous JavaScript and XML
* @ViewScoped La informacion estara disponible por el tiempo que se muestre la vista.
* */

public class IndexControlador {

    @Autowired
    IClienteServicio clienteServicio;
    private List<Cliente> clientes;

    private  static final Logger logger = LoggerFactory.getLogger(IndexControlador.class);

    @PostConstruct //Se llama despues de crear la instancia de la clase.
    /*El constructor vacio lo manda a llamar JSF automaticamente.*/
    public  void init () {
        cargarDatos();
    }

    public  void cargarDatos(){
        this.clientes = this.clienteServicio.listarClientes();
        this.clientes.forEach(cliente -> logger.info(cliente.toString()));
    }
}

