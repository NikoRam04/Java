package nicoprojects.zona_fit.servicio;

import nicoprojects.zona_fit.modelo.Cliente;
import nicoprojects.zona_fit.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicio implements IClienteServicio {
    @Autowired /*Se va a autoinyectar una referencia de la clase de repositorio.*/
    private ClienteRepositorio clienteRepositorio;

    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = clienteRepositorio.findAll(); //Metodo implementado dentro de la clase JPA
        return clientes;
    }

    @Override
    public Cliente buscarClientePorId(Integer idCliente) {
        /*En caso de que no se ha encontrado el registro se regresa nul*/
        Cliente cliente = clienteRepositorio.findById(idCliente).orElse(null);
        return cliente;
    }

    @Override
    public void guardarCliente(Cliente cliente) {
        clienteRepositorio.save(cliente); /*Spring utilzia JPA para hacer todo de forma automatica*/
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        clienteRepositorio.delete(cliente);
        
    }
}
