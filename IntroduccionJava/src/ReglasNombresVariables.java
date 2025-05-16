public class ReglasNombresVariables {
    public static void main(String[] args) {
        // Reglas de nombres de variables

        String nombreCompleto = "Juan Carlos"; // Correcto , Buena practica
        System.out.println("nombreCompleto = " + nombreCompleto);

        String NombreCompleto = "JOSE CARLOS"; //Correcto , No aplica buena practica
        System.out.println("NombreCompleto = " + NombreCompleto);

        // String Nombre-Cliente = "Nombre Cliente"; // Incorrecto
        String nombre_cliente = "Juan"; // Correcto , no aplica buenas praticas
        String _apellido = "Perez"; // Correcto y Aceptable
        String $apellido = "Ramirez" ; // Correcto y Aceptable

        int totPzs = 10 ; //Corecto  , no aplica buenas practicas.
        int totalPiezas = 10; //Correcto , aplica las buenas practicas

        boolean casado = true; //Correcto , aun puedde mejorar
        boolean esCasado = true; //Correcto , y aplica buenas practias.
        boolean isCasado = true; // Correcto , aplica buenas practias *
        boolean hasSaldo = false ; // Ccorrecto y aplica buenas practicas.


    }
}
