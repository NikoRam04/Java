import java.util.Scanner;
public class LeerTiposDatos_02 {
    public static void main(String[] args) {

        //leer tipo entero
        var consola = new Scanner(System.in);
        System.out.print("Ingresa un numero");
        var age = consola.nextInt();
        System.out.println("age = " + age);

        //leer valr double

        System.out.println("ingresa altura");
        var altura = consola.nextDouble();
        System.out.println("altura = " + altura);
        /*** CONSUMIR IMPORTANTE ***/
        consola.nextLine();

        //si no se cosume el caracter de salto de linea genera un error
        System.out.println("Ingresa tu nombe");
        var nombre = consola.nextLine();
        System.out.println("nombre = " + nombre);


        /* conversion de datos */
        System.out.println("Proporciona un valor entero");
        var enteroString = consola.nextLine();
        var entero = Integer.parseInt(enteroString);
        System.out.println("entero = " + entero);

        /* conversion de tipo flotante */
        System.out.println("Ingresa un valor flotante : ");
        var flotante = Float.parseFloat(consola.nextLine());
        System.out.println("flotante = " + flotante);




    }
}
