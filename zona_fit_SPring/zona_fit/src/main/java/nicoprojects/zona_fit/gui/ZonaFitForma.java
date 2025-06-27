package nicoprojects.zona_fit.gui;

import nicoprojects.zona_fit.modelo.Cliente;
import nicoprojects.zona_fit.servicio.ClienteServicio;
import nicoprojects.zona_fit.servicio.IClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ConditionalOnEnabledResourceChain;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//@Component
public class ZonaFitForma extends JFrame{
    private JPanel PanelPrincipal;
    private JTable ClientesTabla;
    private JScrollPane scrollPane1;
    private JTextField nombreTexto;
    private JTextField apellidoTexto;
    private JTextField membresiaTexto;
    private JButton guardarButton;
    private JButton limpiarButton;
    private JButton eliminarButton;
    private DefaultTableModel tablaModeloClientes;
    private Integer idCliente;

    IClienteServicio clienteServicio;

    //1.- Inyeccion de dependencias , antes de la definicion del constructor
    @Autowired
    public ZonaFitForma(ClienteServicio clienteServicio){
        this.clienteServicio = clienteServicio;
        iniciarForma();
        guardarButton.addActionListener(e -> guardarCliente());

        ClientesTabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cargarClienteSeleccionado();
            }
        });

        eliminarButton.addActionListener(e -> eliminarCliente());
        limpiarButton.addActionListener(e -> limpiarFormulario());
    }

    private void iniciarForma(){
        setContentPane(PanelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,700);
        setLocationRelativeTo(null); // Centrar ventana.
    }

    //Se ejecutara antes del constructor de la clase.
    private void createUIComponents() {
        //this.tablaModeloClientes = new DefaultTableModel(0,4);
        //Evitar la edicion de los valores de la celda
        this.tablaModeloClientes = new DefaultTableModel(0,4){
            @Override
            public boolean isCellEditable(int row , int column){
                return false;
            }
        };
        String[] head = {"Id" , "Nombre" , "Apellido" , "Membresia"};
        this.tablaModeloClientes.setColumnIdentifiers(head);
        this.ClientesTabla  = new JTable(tablaModeloClientes);

        //Restringir la seleccion de la tabla a un solo registro.
        this.ClientesTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listarClientes();

    }

    private void listarClientes(){
        this.tablaModeloClientes.setRowCount(0);
        var clientes = this.clienteServicio.listarClientes();
        clientes.forEach(cliente -> {
            Object[] renglonCliente = {
                    cliente.getId(),
                    cliente.getNombre(),
                    cliente.getApellido(),
                    cliente.getMembresia()
            };

            this.tablaModeloClientes.addRow(renglonCliente);
        });
    }

    private void guardarCliente(){
        if(nombreTexto.getText().equals("")){
            mostrarMensaje("Proporciona un nombre");
            nombreTexto.requestFocusInWindow(); // Lleva al usuario al formulario
            return;
        }

        if(membresiaTexto.getText().equals("")){
            mostrarMensaje("Proporciona una membresia");
            membresiaTexto.requestFocusInWindow(); // Lleva al usuario al formulario
            return;
        }

        //Recuperar los valores del formulario

        var nombre = nombreTexto.getText();
        var apellido = apellidoTexto.getText();
        var membresia = Integer.parseInt(membresiaTexto.getText());

        var cliente = new Cliente(this.idCliente,nombre,apellido,membresia);
        /*
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setMembresia(membresia);
        */
        this.clienteServicio.guardarCliente(cliente); /* De forma automatica JPA con hiberate hace la validacion si el
        id es nulo crea uno nuevo , si existe se actualiza.*/
        if(this.idCliente == null){
            mostrarMensaje("Se agrego el nuevo Cliente");
        }
        else
        {
            mostrarMensaje("Se actualizo el Cliente");
        }
        limpiarFormulario();
        listarClientes();
    }
    private void cargarClienteSeleccionado(){
        var renglon = ClientesTabla.getSelectedRow();
        if(renglon != -1){
            var id = ClientesTabla.getModel().getValueAt(renglon,0).toString(); // Del renglon seleccionado obtenemos el indice 0 o ID

            this.idCliente = Integer.parseInt(id);

            var nombre = ClientesTabla.getModel().getValueAt(renglon,1).toString();
            this.nombreTexto.setText(nombre);

            var apellido = ClientesTabla.getModel().getValueAt(renglon,2).toString();
            this.apellidoTexto.setText(apellido);

            var membresia = ClientesTabla.getModel().getValueAt(renglon,3).toString();
            this.membresiaTexto.setText(membresia);

        }
    }

    private void eliminarCliente(){

        if(this.idCliente == null){
            mostrarMensaje("Selecciona un cliente para eliminar");
        }
        else
        {
            var cliente = this.clienteServicio.buscarClientePorId(this.idCliente);
            this.clienteServicio.eliminarCliente(cliente);
            mostrarMensaje("Cliente eliminado");
        }
        limpiarFormulario();
        listarClientes();
    }

    private void limpiarFormulario(){
        this.idCliente = null;
        nombreTexto.setText("");
        apellidoTexto.setText("");
        membresiaTexto.setText("");
        //Desekeccuiar cualquier registro seleccionado de la tabla.
        this.ClientesTabla.getSelectionModel().clearSelection();
    }

    private void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
