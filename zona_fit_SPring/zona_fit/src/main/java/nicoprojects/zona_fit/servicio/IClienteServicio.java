package nicoprojects.zona_fit.servicio;

import nicoprojects.zona_fit.modelo.Cliente;
import java.util.List;

public interface IClienteServicio {

    public List<Cliente> listarClientes();

    public Cliente buscarClientePorId (Integer idCliente);

    public void guardarCliente(Cliente cliente);
    /*En este caso se usara para insertar o actualizar
    * si el valor de la llave primaria es null entonces se realizara una insercion
    * si es diferente de nulo se realizara una actualizacion
    * JPA se encargara de la persistencia de informacion*/

    public  void eliminarCliente(Cliente cliente);

}
