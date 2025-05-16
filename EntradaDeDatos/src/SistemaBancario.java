import java.util.Scanner;

public class SistemaBancario {

    public static void main(String[] args) {
        System.out.println("---Sistema ancario ----");
        var consola = new Scanner(System.in);

        System.out.print("Desea salir del sistema (true false)");

        var salirSistema = Boolean.parseBoolean(consola.nextLine());

        if(!salirSistema){
            System.out.println("Continuamos dentro del sistema");
        }
        else
        {
            System.out.println("Saliendo del Sistema bancario ...");
        }
    }
}
