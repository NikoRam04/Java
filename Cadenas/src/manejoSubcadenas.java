public class manejoSubcadenas {
    public static void main(String[] args) {
        //Obtener subcadenas
        
        var cadena = "Hola mi nombre es nicolas";
        
        //subcadena
        var subCadena1 = cadena.substring(5,14); //El ultimo indice no se incluye.
        System.out.println("subCadena1 = " + subCadena1);

    }
}
