public class TiposDatos {
    public static void main(String[] args) {
        //Tipos de Datos en Java
        // Enteros , su valor por default es 0

        byte tipoByte = 127;//Almacen 8 bits -128 a 127
        System.out.println("tipoByte = " + tipoByte);

        short tipoShort = 32000; // -32,768 a 32,767
        System.out.println("tipoShort = " + tipoShort);

        int tipoInt = 2147483647; //-2,147,483,648 a 2,147,483,647
        System.out.println("tipoInt = " + tipoInt);

        long tipoLong =  9223372036854775807L; //-9,223,372,036,854,775,808 a 9,223,372,036,854,775,807
        System.out.println("tipoLong = " + tipoLong);


        //Punto flotante , su valor por default es 0.0
        float tipoFloat = 3.14F; // 3.40282347 x 10^38 (positivo y negativo)
        System.out.println("tipoFloat = " + tipoFloat);

        double tipoDouble = 3.1314; //1.79769313486231570 x 10^308 (positivo y negativo)
        System.out.println("tipoDouble = " + tipoDouble);


        //Valor por default = ('\U0000')
        char tipoChar = 'N' ; // aracteres del juego unicode
        System.out.println("tipoChar = " + tipoChar);
        tipoChar = 65;
        System.out.println("tipoChar = " + tipoChar);


        //Tipo Booleano , el valor por default es false.
        boolean tipoBoolean = true;
        System.out.println("tipoBoolean = " + tipoBoolean);
        tipoBoolean = false;
        System.out.println("tipoBoolean = " + tipoBoolean);

        //Para el tipo de datos por referencia el valor por default es null , ausencia de referencia
        //Tipos object o tipos por referencia
        String nombre = null;
        System.out.println("nombre = " + nombre);
        nombre = "Valor de la cadena";
        System.out.println("nombre = " + nombre);


        /**/

    }
}
