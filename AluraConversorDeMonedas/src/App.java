import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class App {

    static class ExchangeRates {
        JsonObject conversion_rates; 
    }

    public static void main(String[] args) throws Exception {
        double dolaresUsuario;
        Scanner input = new Scanner(System.in);
        String url = "https://v6.exchangerate-api.com/v6/afec98820a669bc383497541/latest/USD";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();
        HttpResponse<String> response = client
            .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        Gson gson = new Gson();
        ExchangeRates conversiones = gson.fromJson(json, ExchangeRates.class);

        int finalizar = 0;

        while (finalizar == 0) {
            System.out.println("Bienvenido al conversor de monedas\n");

        System.out.println("""
        Elija la opcion que desea realizar:
        ************************* PESOS ARGENTINOS **************************
        1. Convertir dolares a pesos argentinos
        2. Convertir pesos argentinos a dolares
        **************************  BOLIVIANOS  ****************************
        3. Convertir dolares a bolivianos
        4. Convertir bolivianos a dolares
        ***************************  REALES  *******************************
        5. Convertir dolares a reales
        6. Convertir reales a dolares
        ************************* PESOS CHILENOS ***************************
        7. Convertir dolares a pesos chilenos
        8 Convertir pesos chilenos a dolares
        ************************* PESOS COLOMBIANOS ************************
        9. Convertir dolares a pesos colombianos
        10. Convertir pesos colombianos a dolares
        *********************************************************************
        """);
        var opcion = input.nextInt();
        
        switch (opcion) {
            case 1:
                System.out.println("Ingrese la cantidad de dolares a convertir:");
                dolaresUsuario = input.nextDouble();
                input.nextLine();
                double pesos = conversiones.conversion_rates.get("ARS").getAsDouble();
                double resultadoArs = dolaresUsuario * pesos;
                System.out.println(String.format("Los dolares ingresados($%.2f), en pesos argentinos es: $%.2f", dolaresUsuario, resultadoArs));
                break;
            case 2:
                System.out.println("Ingrese la cantidad de pesos argentinos a convertir:");
                double pesosUsuario = input.nextDouble();
                input.nextLine();
                double dolares = conversiones.conversion_rates.get("ARS").getAsDouble();
                double resultadoUsd = pesosUsuario / dolares;
                System.out.println(String.format("La cantidad de pesos argentinos ingresados($%.2f), en dolares es: $%.2f", pesosUsuario, resultadoUsd));
                break;
            case 3:
                System.out.println("Ingrese la cantidad de dolares a convertir:");
                dolaresUsuario = input.nextDouble();
                input.nextLine();
                double pesosBob = conversiones.conversion_rates.get("BOB").getAsDouble();
                double resultadoBob = dolaresUsuario * pesosBob;
                System.out.println(String.format("Los dolares ingresados($%.2f), en bolivianos es: $%.2f", dolaresUsuario, resultadoBob));
                break;
            case 4:
                System.out.println("Ingrese la cantidad de bolivianos a convertir:");
                double bOb = input.nextDouble();
                input.nextLine();
                double dolarestoBob = conversiones.conversion_rates.get("BOB").getAsDouble();
                double resultadoUsdfromBob = bOb / dolarestoBob;
                System.out.println(String.format("La cantidad de bolivianos ingresados($%.2f), en dolares es: $%.2f", bOb, resultadoUsdfromBob));
                break;
            case 5:
                System.out.println("Ingrese la cantidad de dolares a convertir:");
                dolaresUsuario = input.nextDouble();
                input.nextLine();
                double Brs = conversiones.conversion_rates.get("BRL").getAsDouble();
                double resultadoBrl = dolaresUsuario * Brs;
                System.out.println(String.format("Los dolares ingresados($%.2f), en reales es: $%.2f", dolaresUsuario, resultadoBrl));
                break;
            case 6:
                System.out.println("Ingrese la cantidad de reales a convertir:");
                double reales = input.nextDouble();
                input.nextLine();
                double dolaresToReales = conversiones.conversion_rates.get("BRL").getAsDouble();
                double resultadoUsdfromReales = reales / dolaresToReales;
                System.out.println(String.format("La cantidad de pesos reales ingresados($%.2f), en dolares es: $%.2f", reales, resultadoUsdfromReales));
                break;
            case 7:
                System.out.println("Ingrese la cantidad de dolares a convertir:");
                dolaresUsuario = input.nextDouble();
                input.nextLine();
                double pesosClp = conversiones.conversion_rates.get("CLP").getAsDouble();
                double resultadoClp = dolaresUsuario * pesosClp;
                System.out.println(String.format("Los dolares ingresados($%.2f), en pesos chilenos es: $%.2f", dolaresUsuario, resultadoClp));
                break;
            case 8:
                System.out.println("Ingrese la cantidad de pesos chilenos a convertir:");
                double pesosChilenos = input.nextDouble();
                input.nextLine();
                dolaresUsuario = conversiones.conversion_rates.get("CLP").getAsDouble();
                double resultadoUsdfromClp = pesosChilenos / dolaresUsuario;
                System.out.println(String.format("La cantidad de pesos chilenos ingresados($%.2f), en dolares es: $%.2f", pesosChilenos, resultadoUsdfromClp));
                break;
            case 9:
                System.out.println("Ingrese la cantidad de dolares a convertir:");
                dolaresUsuario = input.nextDouble();
                input.nextLine();
                double pesosCop = conversiones.conversion_rates.get("COP").getAsDouble();
                double resultadoCop = dolaresUsuario * pesosCop;
                System.out.println(String.format("Los dolares ingresados(%.2f), en pesos colombianos es: %.2f", dolaresUsuario, resultadoCop));
                break;
            case 10:
                System.out.println("Ingrese la cantidad de pesos colombianos a convertir:");
                double pesosCol = input.nextDouble();
                input.nextLine();
                dolaresUsuario = conversiones.conversion_rates.get("COP").getAsDouble();
                double resultadoUsdfromCop = pesosCol / dolaresUsuario;
                System.out.println(String.format("La cantidad de pesos colombianos ingresados($%.2f), en dolares es: $%.2f", pesosCol, resultadoUsdfromCop));
                break;
            default:
                System.out.println("Opcion incorrecta, vuelva a intentar");
                System.out.println("Cerrando sesion...");
                break;
        }
        System.out.println("""

                Para continuar presione 0.
                Para finalizar presione 1.

                """);
        int valorOpcion = input.nextInt();

        if (valorOpcion == 1) {
            finalizar += 1;
        }
        }
        input.close();
    }
}