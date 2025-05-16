public class metodosDeCadenas {
    public static void main(String[] args) {

        //Metodos de cadenas

        var cadena1 = "              hola como estas         ";
        var longitudCadena = cadena1.length();
        System.out.println("longitudCadena = " + longitudCadena);
        
        //Reemplazar caracteres 
        
        var nuevaCadena = cadena1.replace('o','0');
        System.out.println("nuevaCadena = " + nuevaCadena);
        
        //convertir a mayusculas
        var cadenaMayusculas = cadena1.toUpperCase();
        System.out.println("cadenaMayusculas = " + cadenaMayusculas);
        
        //Convertir a minusculas 
        
        var cadenaMinusculas = cadena1.toLowerCase();
        System.out.println("cadenaMinusculas = " + cadenaMinusculas);

        //Eliminar espacios en las cadenas al inicio y final de las cadenas
        System.out.println("cadena sin espacios = " + cadena1.trim());
    }
}
