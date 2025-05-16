public class RetoDetalleTienda {
    public static void main(String[] args) {

        System.out.println("*** Tienda en linea , {Detalle del producto} ***");

        //Declaracion e inicializacion de variables
        String nombreProducto = "Shampoo";
        float precioProducto = 144.75F;
        int cantidadDisponible = 500;
        boolean isDisponible = true;

        //Detalle del producto
        System.out.println("nombreProducto = " + nombreProducto);
        System.out.println("precioProducto = " + precioProducto);
        System.out.println("cantidadDisponible = " + cantidadDisponible);
        System.out.println("isDisponible = " + isDisponible);

        //Modificacion de valores
        nombreProducto = "Carne de Res";
        precioProducto = 345.50f;
        cantidadDisponible = 40;
        isDisponible = false;

        System.out.println();
        
        //Detalle de nuevo producto
        System.out.println("nombreProducto = " + nombreProducto);
        System.out.println("precioProducto = " + precioProducto);
        System.out.println("cantidadDisponible = " + cantidadDisponible);
        System.out.println("isDisponible = " + isDisponible);

    }
}
