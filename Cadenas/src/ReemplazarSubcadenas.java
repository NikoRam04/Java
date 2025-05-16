public class ReemplazarSubcadenas {
    public static void main(String[] args) {
        
        // Reemplazar subcadenas
        
        var cadena = "Hola mundo";
        System.out.println("cadena = " + cadena);
        
        //Reemplazar "mundo" por subcadena "a todos"
        
        var nuevaCadena = cadena.replace("mundo","a todos");
        System.out.println("nuevaCadena = " + nuevaCadena);
    }
}
