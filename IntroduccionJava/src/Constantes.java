import java.sql.SQLOutput;

public class Constantes {
    public static void main(String[] args){
        System.out.println("----- Constantes en Java -----");

        final var DIAS_SEMANA = 7;
        System.out.println("DIAS_SEMANA = " + DIAS_SEMANA);

        //DIAS_SEMANA = 8; no se puede cambiar un tipo de dato constante.

        var PI = 3.14159F;
        System.out.println("PI = " + PI);
        System.out.println("Math.PI = " + Math.PI);
        
        final var MENSAJE_DEFAULT = "Este un mensaje por defult";
        System.out.println("MENSAJE_DEFAULT = " + MENSAJE_DEFAULT);
    }
}
