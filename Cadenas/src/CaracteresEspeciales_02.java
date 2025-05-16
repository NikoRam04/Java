public class CaracteresEspeciales_02 {
    public static void main(String[] args) {
        
        //Caracteres especiales : Cuando se utilizan se comportan de forma distinta
        
        
        // \n caracter de salto de linea
        var cadena  = "Hola mundo";
        System.out.println("cadena = " + cadena);
        
        var cadenaEspecial = "Hola \n Mundo ";
        System.out.println("cadenaEspecial = " + cadenaEspecial);
        
        // \t caracter de tabulador
        
        var cadenaTabulador = "Hola soy \t una cadena con \t tabulador";
        System.out.println("cadenaTabulador = " + cadenaTabulador);

        var cadenaComillaSimple = "Cadena \' con comilla simple";
        System.out.println("cadenaComillaSimple = " + cadenaComillaSimple);

        var cadenaComillaDoble = "Cadena con \" comilla doble ";
        System.out.println("cadenaComillaDoble = " + cadenaComillaDoble);
        
        var cadenaBarraInvertida =  "cadena con \\ barra invertida ";
        System.out.println("cadenaBarraInvertida = " + cadenaBarraInvertida);
    }
}
