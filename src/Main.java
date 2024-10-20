import com.google.gson.Gson;
import com.moneda.Conversor;
import com.moneda.Moneda;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {


        String monedaActual = "";
        String monedaConvertir = "";
        double cantidadConvertir = 0;
        int eleccion;

        Scanner scanner = new Scanner(System.in);

        while(true){

            System.out.println("***************************************************");
            System.out.println("Bienvendo/a al Conversor de Moneda :)");
            System.out.println();
            System.out.println("1) Dolar =>> Péso Argentino");
            System.out.println("2) Peso Argentino =>> Dolar");
            System.out.println("3) Dolar =>> Real Brasileño");
            System.out.println("4) Real Brasileño =>> Dolar");
            System.out.println("5) Dolar =>> Peso Colombiano");
            System.out.println("6) Peso Colombiano =>> Dolar");
            System.out.println("7) Salir");
            System.out.println("Elija una opcion valida:");
            System.out.println("***************************************************");

            eleccion = scanner.nextInt();

            switch (eleccion) {
                case 1:
                    monedaActual = "USD";
                    monedaConvertir = "ARS";
                    System.out.println("Ingrese el valor que desea convertir:");
                    cantidadConvertir = scanner.nextDouble();
                    break;

                case 2:
                    monedaActual = "ARS";
                    monedaConvertir = "USD";
                    System.out.println("Ingrese el valor que desea convertir:");
                    cantidadConvertir = scanner.nextDouble();
                    break;

                case 3:
                    monedaActual = "USD";
                    monedaConvertir = "BRL";
                    System.out.println("Ingrese el valor que desea convertir:");
                    cantidadConvertir = scanner.nextDouble();
                    break;

                case 4:
                    monedaActual = "BRL";
                    monedaConvertir = "USD";
                    System.out.println("Ingrese el valor que desea convertir:");
                    cantidadConvertir = scanner.nextDouble();
                    break;

                case 5:
                    monedaActual = "USD";
                    monedaConvertir = "COP";
                    System.out.println("Ingrese el valor que desea convertir:");
                    cantidadConvertir = scanner.nextDouble();
                    break;

                case 6:
                    monedaActual = "COP";
                    monedaConvertir = "USD";
                    System.out.println("Ingrese el valor que desea convertir:");
                    cantidadConvertir = scanner.nextDouble();
                    break;

                case 7:
                    scanner.close();
                    return; // Salir del programa

                default:
                    System.out.println("Por favor, elija una opción válida.");
            }


            Conversor conversor = new Conversor(monedaActual, monedaConvertir, cantidadConvertir);
            float conversion = (float) conversor.convertir();

            System.out.println(conversor.moneda);


            System.out.println("El valor de "+cantidadConvertir+" ["+monedaActual+"] corresponde " +
                    "al valor final de ===> "+conversion+" ["+monedaConvertir+"]");
            System.out.println();


        }




    }
}