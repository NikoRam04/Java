public class Cadenas {
    public static void main(String[] args) {

        System.out.println("-----Manejo de Cadenas-----");

        var cadena1 = "Cadena Normal";
        System.out.println("cadena1 = " + cadena1);

        var cadena2 = new String("Cadena desde el constructor");
        System.out.println("cadena2 = " + cadena2);

        var cadena3 = cadena1 + " " + cadena2; // Se genera una nueva cadena .
        System.out.println("cadena3 = " + cadena3);

        //Cadena de multiples lineas (text block)
        
        var cadena4 = """
                Cadena
                con
                multiples
                lineas
                """;
        System.out.println("cadena4 = " + cadena4);
    }
}
