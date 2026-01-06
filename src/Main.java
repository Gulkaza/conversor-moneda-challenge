import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultarMoneda consulta = new ConsultarMoneda();

        System.out.println("Cargando tasas de cambio, por favor espere...");

        try {
            // Ahora recibimos un objeto 'Moneda' directamente
            Moneda moneda = consulta.buscarTasas("USD");

            int opcion;
            while (true) {
                System.out.println("\n***************************************************");
                System.out.println("      BIENVENIDO AL CONVERSOR DE MONEDAS  ");
                System.out.println("***************************************************");
                System.out.println("1) Dólar (USD)  ==> Peso Argentino (ARS)");
                System.out.println("2) Peso Arg.    ==> Dólar (USD)");
                System.out.println("3) Dólar (USD)  ==> Real Brasileño (BRL)");
                System.out.println("4) Real Bras.   ==> Dólar (USD)");
                System.out.println("5) Dólar (USD)  ==> Peso Colombiano (COP)");
                System.out.println("6) Peso Col.    ==> Dólar (USD)");
                System.out.println("7) Dólar (USD)  ==> Peso Chileno (CLP)");
                System.out.println("8) Dólar (USD)  ==> Boliviano (BOB)");
                System.out.println("9) Salir");
                System.out.println("***************************************************");
                System.out.print("Elija una opción válida: ");

                opcion = lectura.nextInt();
                lectura.nextLine(); // Limpiar buffer

                if (opcion == 9) {
                    System.out.println("Cerrando el programa. Gracias");
                    break;
                }

                if (opcion < 1 || opcion > 9) {
                    System.out.println(" Opción no válida, intente de nuevo.");
                    continue;
                }

                System.out.print("Ingrese la cantidad que desea convertir: ");
                double cantidad = lectura.nextDouble();

                double resultado = 0;
                String codigoDestino = "";

                // Usamos el Map dentro de nuestro record Moneda
                // Nota: moneda.conversion_rates() accede al mapa de tasas
                resultado = switch (opcion) {
                    case 1 -> {
                        codigoDestino = "ARS";
                        yield cantidad * moneda.conversion_rates().get("ARS");
                    }
                    case 2 -> {
                        codigoDestino = "USD";
                        yield cantidad / moneda.conversion_rates().get("ARS");
                    }
                    case 3 -> {
                        codigoDestino = "BRL";
                        yield cantidad * moneda.conversion_rates().get("BRL");
                    }
                    case 4 -> {
                        codigoDestino = "USD";
                        yield cantidad / moneda.conversion_rates().get("BRL");
                    }
                    case 5 -> {
                        codigoDestino = "COP";
                        yield cantidad * moneda.conversion_rates().get("COP");
                    }
                    case 6 -> {
                        codigoDestino = "USD";
                        yield cantidad / moneda.conversion_rates().get("COP");
                    }
                    case 7 -> {
                        codigoDestino = "CLP";
                        yield cantidad * moneda.conversion_rates().get("CLP");
                    }
                    case 8 -> {
                        codigoDestino = "BOB";
                        yield cantidad * moneda.conversion_rates().get("BOB");
                    }
                    default -> resultado;
                };

                System.out.printf("El valor %.2f corresponde al valor final de =>>> %.2f %s%n",
                        cantidad, resultado, codigoDestino);
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicación.");
        }

        lectura.close();
    }
}