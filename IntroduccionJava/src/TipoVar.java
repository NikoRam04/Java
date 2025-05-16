public class TipoVar {
    public static void main(String[] args) {

        System.out.println("----- Uso de var en Java -----");
        
        String nombre1 = "Hector";
        System.out.println("nombre1 = " + nombre1);
        
        var nombre2 = "Nicolas"; //Solo almacenara tipo String
        System.out.println("nombre2 = " + nombre2);

        //Definicion de otras variables

        var edad = 50; //Edad solo almacenara tipos int.
        System.out.println("edad = " + edad);

        var salario = 10000.5F; //Se infiere el tipo float. (L -> long)
        System.out.println("salario = " + salario);

        var isCasado = false;
        isCasado = true;
        System.out.println("isCasado = " + isCasado);

        //var errorVal = null;
    }
}
