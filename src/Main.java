import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    static String hora(){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ProcessBuilder pb = new ProcessBuilder();
        pb.command("firefox","google.es");

        System.out.println("¿Cuantas ventanas quieres?");
        int numeroVentanas = scan.nextInt();

        // coloque 20 segundos en vez de 500 ms estoy en una maquina virtual lenta ._.

        try {

            for (int i = 0; i < numeroVentanas; i++) {
                System.out.println("El proceso " + i + " inica a la hora " + hora());
                Process proceso = pb.start();
                proceso.waitFor(20, TimeUnit.SECONDS);
                proceso.destroy();
                System.out.println("El proceso " + i + " finaliza a la hora " + hora());
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
