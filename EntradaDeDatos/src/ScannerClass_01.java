import java.util.Scanner;

public class ScannerClass_01 {
    public static void main(String[] args) {

        var scanner = new Scanner(System.in);
        System.out.print("type your name");

        var name = scanner.nextLine();

        System.out.println("name = " + name);
    }
}
