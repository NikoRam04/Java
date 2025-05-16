package zona_fit.datos;

import zona_fit.conexion.Conexion;
import zona_fit.dominio.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement; //
import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static zona_fit.conexion.Conexion.getConexion;

public class ClienteDAO implements  IClienteDAO
{
    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement ps; //prepara la sentencia SQL que se ejecutara a la base de datos
        ResultSet rs; //Permite recibirl ainformacion de la onsulta que realizamos.
        Connection con = getConexion();
        var sql  = "SELECT * FROM cliente ORDER BY id";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                var cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
                clientes.add(cliente);
            }

        }catch (Exception e){
            System.out.println("Error a listar clientes "+ e.getMessage());
        }
        finally {
            try{
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar conexion");;
            }

        }

        return clientes;
    }

    @Override
    public boolean buscarClientePorId(Cliente cliente) {

        PreparedStatement ps;
        ResultSet rs;
        var con = getConexion();
        var sql = "SELECT * FROM cliente WHERE id = ?";

        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,cliente.getId());

            rs = ps.executeQuery();

            if(rs.next()){
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
                return true;
            }
        }catch(Exception e){
            System.out.println("Error al recuperar cliente por id :"+ e.getMessage());
        }
        finally {
            try{
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion"+ e.getMessage());
            }
        }

        return false;
    }

    @Override
    public boolean agregrCliente(Cliente cliente) {

        PreparedStatement ps;
        Connection con = getConexion();
        String sql  = "INSERT INTO cliente(nombre , apellido , membresia) "+
                " VALUES(?,?,?)";

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1,cliente.getNombre());
            ps.setString(2,cliente.getApellido());
            ps.setInt(3,cliente.getMembresia());

            ps.execute();
            return  true;
        }
        catch(Exception e){
            System.out.println("Error al agregar cliente : "+ e.getMessage());
        }
        finally {
            try{
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion"+e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean modificarCliente(Cliente cliente) {

        PreparedStatement ps;
        Connection con = getConexion();

        var sql = "UPDATE cliente SET nombre = ?, apellido = ?, membresia = ? "+
                "WHERE id = ?";

        try{
            ps = con.prepareStatement(sql);
            ps. setString(1, cliente.getNombre());
            ps. setString(2, cliente.getApellido());
            ps. setInt(3, cliente.getMembresia());
            ps. setInt(4, cliente.getId());
            ps.execute();

            return true;

        } catch (Exception e) {
            System.out.println("Error al modificar el cliente "+e.getMessage());
        }

        finally {
            try{
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar conexion "+e.getMessage());
            }

        }
        return false;
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {

        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "DELETE FROM cliente WHERE id = ?";


        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,cliente.getId());
            ps.execute();
            return true;

        } catch (Exception e) {
            System.out.println("Error al eliminar cliente : "+ e.getMessage());
        }

        finally {
            try{
                con.close();
            } catch (Exception e) {
                System.out.println("Error al errar  conexion" + e.getMessage());
            }
        }

        return false;
    }

    public static void main(String[] args) {
        IClienteDAO clienteDao = new ClienteDAO();
/*
        IClienteDAO clienteDao = new ClienteDAO();
        var client1 = new Cliente(7);
        System.out.println("Cliente antes de la busqueda " + client1);
        var encontrado = clienteDao.buscarClientePorId(client1);

        if(encontrado){
            System.out.println("No se encontro registro "+ client1);
        }
        else {
            System.out.println("No se encontro cliente" + client1.getId());
        }*/

        /*Agregar Cliente*/
 /*
        var nuevoCliente = new Cliente("Daniel","ortiz",5123);
        var agregado = clienteDao.agregrCliente(nuevoCliente);

        if(agregado){
            System.out.println("Cliente agregado "+nuevoCliente);
        }
        else {
            System.out.println("No se agergo el cliente "+ nuevoCliente);
        }
*/


        /*Modificar cliente*/


        /*
        var modificarCliente = new Cliente(6,"Carlos Daniel " ,"Ortiz" , 2420);
        var modificado = clienteDao.modificarCliente(modificarCliente);
        if(modificado)
            System.out.println("Cliente Modificado "+ modificarCliente);
        else
            System.out.println("nose modifico "+modificarCliente);

            */

        //Listar clientes



        //Eliminar cliente

        var clienteAEliminar = new Cliente(1);
        var eliminado = clienteDao.eliminarCliente(clienteAEliminar);
        if(eliminado)
            System.out.println("Cliente eliminado"+clienteAEliminar);
        else System.out.println("No se elimino el cliente "+clienteAEliminar);

        System.out.println("---- Lista de clientes ----");
        var clientes = clienteDao.listarClientes();
        clientes.forEach(System.out::println);
    }
}
