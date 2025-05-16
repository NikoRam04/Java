public class comparacionCadenas {
    public static void main(String[] args) {


        /*La comparacion de cadenas se hace por reerencia , si se asigna la misma
         * cadena se esta comparano la direccion de memoria  , si se desea almacenar
         * la misma cadena en otro objeto se debe realizar con la definicion forma
         * ejemmplo:
         * cadena = new String("cadena")
         * */

        var cadena1 = "Hola";
        var cadena2 = "Hola";
        var cadena3 = new String("Hola");

        System.out.print("Cadena 1 es igual a cadena 2 en referencia : ");
        System.out.println(cadena1 == cadena2);

        System.out.print("Cadena 1 es igual a cadena 3 en referencia : ");
        System.out.println(cadena1 == cadena3);

        System.out.print("El contenido de la cadena 1 es igual a la cadena 3 : ");
        System.out.println(cadena1.equals(cadena3));

    }
}
