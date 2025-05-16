package zona_fit.datos;

import com.mysql.cj.xdevapi.Client;
import zona_fit.dominio.Cliente;

import java.util.List;

public interface IClienteDAO {

    List<Cliente> listarClientes();
    boolean buscarClientePorId(Cliente cliente);
    boolean agregrCliente(Cliente cliente);
    boolean modificarCliente(Cliente cliente);
    boolean eliminarCliente(Cliente cliente);
}
