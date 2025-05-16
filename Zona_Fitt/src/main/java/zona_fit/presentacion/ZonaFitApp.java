package zona_fit.presentacion;

import zona_fit.datos.ClienteDAO;
import zona_fit.datos.IClienteDAO;
import zona_fit.dominio.Cliente;

import java.util.Scanner;

public class ZonaFitApp {
    public static void main(String[] args) {

        var consola = new Scanner(System.in);
        int opcion;
        IClienteDAO clienteDao = new ClienteDAO();
        MostrarMenu();

        do{
            System.out.print("Select : ");
            opcion = consola.nextInt();
            System.out.println(opcion);

            switch (opcion){
                case 1:
                    ListarClientes((ClienteDAO) clienteDao);
                    break;
                case 2:
                    System.out.println("Id del cliente a buscar :");
                    var idCliente = Integer.parseInt(consola.nextLine());
                    var cliente = new Cliente(idCliente);
                    var encontrado = clienteDao.buscarClientePorId(cliente);
                    if(encontrado)
                        System.out.println("Cliente encontrado : "+ cliente);
                    else System.out.println("Clienta no econtrado" + cliente);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
            }

            MostrarMenu();
        }while (opcion != 5);

    }

    public static void  MostrarMenu(){
        System.out.println("***Menu de opciones ***");

        var menu = """
                [1] Listar Clientes\n
                [2] Agregar Cliente\n
                [3] Modificar Cliente\n
                [4] Eliminar Cliente \n
                [5] Salir \n
                """;
        System.out.println(menu);
    }

    public static void ListarClientes(ClienteDAO clienteDAO){

        System.out.println("Clientes Disponibles en la aplicacion : ");
        var clientes = clienteDAO.listarClientes();
        clientes.forEach(System.out::println);
    }

}
