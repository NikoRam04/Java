package zona_fit.presentacion;

import com.mysql.cj.xdevapi.Client;
import zona_fit.datos.ClienteDAO;
import zona_fit.datos.IClienteDAO;
import zona_fit.dominio.Cliente;

import java.util.Scanner;

public class ZonaFitAppCurso {
    public static void main(String[] args) {

        zonaFitApp();
    }
    private static  void zonaFitApp(){
        var salir = false;
        var consola = new Scanner(System.in);

        //Creamos un objeto de la clase cliente DAO
        IClienteDAO clienteDao = new ClienteDAO();

        while(!salir){
            try {
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(opcion,clienteDao,consola);

            }catch(Exception e){
                System.out.println("Error al ejecutar opciones" + e);
            }
            System.out.println();
        }
    }


    private static int mostrarMenu(Scanner consola){

        System.out.println("""
                *** Gym Zona Fit ***
                1. Listar Clientes
                2. Buscar Cliente
                3. Agregar Cliente
                4. Modificar Cliente
                5. Eliminar Cliente
                6. Salir
                Elije  un opcion : \s
                """);
        return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpciones(int opcion, IClienteDAO clienteDao,Scanner consola){

        var salir = false;

        switch(opcion){
            case 1 -> {
                System.out.println("*** Listado de clientes ***");
                var clientes = clienteDao.listarClientes();
                clientes.forEach(System.out::println);
            }
            case 2 ->{ // Busca cliente por ID
                System.out.println("Introduce el ID del cliente a buscar");
                var idCliente = Integer.parseInt(consola.nextLine());
                var cliente = new Cliente(idCliente);

                var encontrado = clienteDao.buscarClientePorId(cliente);
                if(encontrado){
                    System.out.println("Cliente encontrado: "+ cliente);
                }
                else
                {
                    System.out.println("Cliente NO encontrado : "+cliente);
                }
            }

            case 3 ->{ // Agregar cliente
                System.out.println("*** Agergar Cliente ***");

                System.out.print("Nombre : ");
                var nombre = consola.nextLine();

                System.out.print("Apellido : ");
                var apellido = consola.nextLine();

                System.out.print("Membresia : ");
                var membresia = Integer.parseInt(consola.nextLine());

                var cliente = new Cliente(nombre,apellido,membresia);
                var agregado = clienteDao.agregrCliente(cliente);

                if(agregado){
                    System.out.println("Cliente agregado " + cliente);
                }
                else {
                    System.out.println("Cliente no agregado "+ cliente);
                }
            }

            case 4 -> { //Modificar cliente
                System.out.println( "** Modificar Cliente ");

                System.out.print("Id Cliente : ");
                var idCliente = Integer.parseInt(consola.nextLine());

                System.out.print("Nombre : ");
                var nombre = consola.nextLine();

                System.out.print("Apellido : ");
                var apellido = consola.nextLine();

                System.out.print("Membresia : ");
                var membresia = Integer.parseInt(consola.nextLine());

                var cliente = new Cliente(idCliente , nombre , apellido , membresia);
                var modificado = clienteDao.modificarCliente(cliente);

                if(modificado){
                    System.out.println("Cliente modificado : "+ cliente);
                }
                else{
                    System.out.println("Cliente NO modificado "+ cliente);
                }
            }

            case 5 ->{ // Eliminar cliente
                System.out.println(" ---- Eliminar cliente ----");


                System.out.print("Id Cliente : ");
                var idCliente = Integer.parseInt(consola.nextLine());
                var cliente = new Cliente(idCliente);

                var eliminado = clienteDao.eliminarCliente(cliente);

                if(eliminado){
                    System.out.println("Cliente eliminado : "+ cliente);
                }
                else{
                    System.out.println("Cliente NO eliminado "+ cliente);
                }
            }

            case 6 ->{ //Salir
                System.out.println("Saliendo del sistema");
                salir  = true;
            }

            default -> {
                System.out.println("Opcion no reconocida."+opcion);
            }
        }
        return salir;
    }
}
