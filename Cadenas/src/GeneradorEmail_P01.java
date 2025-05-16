public class GeneradorEmail_P01 {

    public static void main(String[] args) {

        var nombreUsuario = "Hector Nicolas Ramirez Muñoz";
        var nombreEmpresa = "Continental Corporation";
        var dominio = ".com.mx";

        var nombreNormalizado = nombreUsuario.toLowerCase().replace(" ",".");
        var empresaNormalizado = nombreEmpresa.toLowerCase().replace(" ","-");

        var dominioNormalizado = "@"+empresaNormalizado+dominio;

        var email = new StringBuilder();

        email.append(nombreNormalizado).append(dominioNormalizado);

        System.out.println("nombreUsuario = " + nombreUsuario);
        System.out.println("nombreNormalizado = " + nombreNormalizado);

        System.out.println("nombreEmpresa = " + nombreEmpresa);
        System.out.println("email = " + email.toString());
    }
}

