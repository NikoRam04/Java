public class ReservaHotelesReto {
    public static void main(String[] args) {

        System.out.println("----- Detalle de reservacion de Hotel ------");

        var nombreCliente  = "Nicolas Ramirez";
        var diasEstancia = 7;
        var tarifaDiaria = 240.7F;
        var hasVistaMar = false;

        System.out.println("nombreCliente = " + nombreCliente);
        System.out.println("diasEstancia = " + diasEstancia);
        System.out.println("tarifaDiaria = " + tarifaDiaria);
        System.out.println("hasVistaMar = " + hasVistaMar);

        nombreCliente = "Hector Muñoz";
        diasEstancia = 1;
        tarifaDiaria = 450.1F;
        hasVistaMar = true;

        System.out.println();
        System.out.println("Datos de reservacion modificados :");
        System.out.println("nombreCliente = " + nombreCliente);
        System.out.println("diasEstancia = " + diasEstancia);
        System.out.println("tarifaDiaria = " + tarifaDiaria);
        System.out.println("hasVistaMar = " + hasVistaMar);



    }
}
