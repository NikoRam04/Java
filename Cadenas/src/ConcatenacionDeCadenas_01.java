public class ConcatenacionDeCadenas_01 {
    public static void main(String[] args) {

        /*Mas formas de concatenar cadenas en java*/

        var cadena1 = "hola";
        var cadena2 = "Mundo";

        var cadena3 = cadena1 + " " + cadena2 ;
        System.out.println("cadena3 = " + cadena3);

        //Metodo concat
        cadena3 = cadena1.concat(cadena1.concat(cadena2));
        System.out.println("cadena3 = " + cadena3);

        cadena3 = cadena1.concat(" ").concat(cadena2);
        System.out.println("cadena3 = " + cadena3);
        
        // String Builder 
        
        var constructorCadenas = new StringBuilder();
        constructorCadenas.append(cadena1);
        constructorCadenas.append(" ");
        constructorCadenas.append("Mundo");

        var resultado = constructorCadenas.toString();
        System.out.println("resultado = " + resultado);

        //Clase String Buffer - Es seguro uando estamos trabaajando con varios hilos.

        var stringBuffer = new StringBuffer();
        stringBuffer.append(cadena1).append(" ").append("Mundo");
        resultado = stringBuffer.toString();

        System.out.println("resultado = " + resultado);

        //Metodo join unir 2 o mas cadenas

        resultado = String.join("**",cadena1,cadena2,cadena1,cadena2);
        System.out.println("resultado = " + resultado);



    }
}
