public class Indices {
    public static void main(String[] args) {
         /*----Manejo de indices en una cadena*/
        
        String cadena1 = "Hola Mundo";

        //Recuperar el primer caracter
        char firstChar = cadena1.charAt(0);
        System.out.println("firstChar = " + firstChar);
        
        // Recuperar el ultmo caracter en la posicion 9 
        char lastChar = cadena1.charAt(9);
        System.out.println("lastChar = " + lastChar);
        
        //imprimir la letra M
        char letraM  = cadena1.charAt(5);
        System.out.println("letraM = " + letraM);
    }
}
