package nicoprojects.zona_fit;

import nicoprojects.zona_fit.modelo.Cliente;
import nicoprojects.zona_fit.servicio.IClienteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ZonaFitApplication implements CommandLineRunner {
/*CommandLineRunner
* Recibimos los argumentos de la linea de comandos si es necesario.*/

	@Autowired
	private IClienteServicio clienteServicio;

	private static final Logger logger = LoggerFactory.getLogger(ZonaFitApplication.class);



	public static void main(String[] args) {
		logger.info("Iniciando la aplicacion");
		//Levantar la fabrica de spring
		SpringApplication.run(ZonaFitApplication.class, args);
		logger.info("Aplicacion finalizada.");

	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("********Aplicacion ZONA FIT GYM********");

		zonaFitApp();
	}

	public void zonaFitApp(){

		var salir = false;
		var consola = new Scanner(System.in);

		while (!salir){
			var opcion = mostrarMenu(consola);
			salir = ejecutarOpciones(consola,opcion);
			logger.info("");
		}
	}

	private int mostrarMenu(Scanner consola){
		logger.info("""
					\n1.- Listar clientes
					2.- Buscar Cliente
					3.- Agregar clietne 
					4.- Modificar cliente
					5.- Eliminar cliente
					6.- Salir
					Elige una opcion  :
					""");
		var opcion = Integer.parseInt(consola.nextLine());

		return opcion;
	}

	private boolean ejecutarOpciones(Scanner consola,int opcion){
		var salir = false;

		switch(opcion){

			case 1 ->{
				logger.info("\n ****** Listado de Clientes ----- \n");
				List<Cliente> clientes = clienteServicio.listarClientes();
				clientes.forEach(cliente -> logger.info(cliente.toString()));
			}

			case 2 -> {
				logger.info("\n Buscar cliente por ID");
				var idCliente = Integer.parseInt(consola.nextLine());
				Cliente cliente = clienteServicio.buscarClientePorId(idCliente);
				if(cliente!= null)
					logger.info("\n Cliente encontrado "+ cliente);
				else
					logger.info("Cliente no encontrado");
			}

			case 3 -> {

				var clientex = new Cliente();

				logger.info("-- Agergar Cliente");
				logger.info("Nombre : ");
				var nombre = consola.nextLine();
				logger.info("Apellido");
				var apellido = consola.nextLine();
				logger.info("Membresia : ");
				var membresia = Integer.parseInt(consola.nextLine());

				clientex.setNombre(nombre);
				clientex.setApellido(apellido);
				clientex.setMembresia(membresia);
				clienteServicio.guardarCliente(clientex);
				logger.info("Cliente agregado" + clientex);
			}

			case 4 -> {
				logger.info("Modificar Cliente-...");
				logger.info("Id del Cliente");
				var idCliente = Integer.parseInt(consola.nextLine());
				Cliente cliente = clienteServicio.buscarClientePorId(idCliente);
				if(cliente != null){

					logger.info("Nombre : ");
					var nombre = consola.nextLine();
					logger.info("Apellido");
					var apellido = consola.nextLine();
					logger.info("Membresia : ");
					var membresia = Integer.parseInt(consola.nextLine());

					cliente.setNombre(nombre);
					cliente.setApellido(apellido);
					cliente.setMembresia(membresia);

					clienteServicio.guardarCliente(cliente);
					logger.info("Cliente modificado \n");
				}else {
					logger.info("Cliente no encontrado "+ cliente);
				}
			}

			case 5->{
				logger.info("Ëliminar Cliente");

				logger.info("Id Cliente:");
				var idCliente = Integer.parseInt(consola.nextLine());
				var cliente = clienteServicio.buscarClientePorId(idCliente);

				if(cliente != null){
					clienteServicio.eliminarCliente(cliente);
					logger.info("Cliente Eliminado"+ cliente);
				}
				else {
					logger.info("Cliente no encontrado "+ cliente);
				}

			}

			case 6 ->{
				logger.info("Hasta pronto \n \n");
				salir = true;
			}

			default -> logger.info("Opcion no reconocida : "+opcion);
		}
		return salir;
	}
}
