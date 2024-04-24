package com.alura.convert.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class principal {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        double valorConvertir = 0;
        double monedaCambio = 0;

        String moneda = "";

        System.out.println("*****************************************");
        System.out.println("Sistema Nacional de Conversión de Moneda");
        System.out.println("Bienvenido");
        System.out.println("Oficina Virtual");
        System.out.println("*****************************************");

        String direccionExchangeApi = "https://v6.exchangerate-api.com/v6/6a3b0970ae694ceca5967fcb/latest/";

        while (true) {
            System.out.println("** Seleccion el tipo de conversión que desea realizar **");
            System.out.println("1 - Colones => Dolar");
            System.out.println("2 - Dolar => Colones");
            System.out.println("3 - Colones => Peso Mexicano");
            System.out.println("4 - Peso Mexicano a Colones");
            System.out.println("5 - Colones => Libra esterlina");
            System.out.println("6 - Libra esterlina => Colones");
            System.out.println("9 - Salir");

            opcion = teclado.nextInt();
            if(opcion == 1){
                moneda = "USD";
            }
            //componer la direccion
            direccionExchangeApi = direccionExchangeApi+moneda;

            if (opcion == 9) {
                System.out.println("Finalizando el programa. Muchas gracias por usar nuestros servicios");
                break;
            }

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccionExchangeApi))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                switch (opcion) {
                    case 1:
                        System.out.println("Conversión Colón => Dolar");
                        System.out.println("Digite el monto que desea convetir");
                        valorConvertir = teclado.nextDouble();

                        break;
                    case 2:
                        System.out.println("Conversión Dolar => Colón");
                        System.out.println("Digite el monto que desea convetir");
                        // Lógica de conversión Dólar a Colones
                        break;
                    case 3:
                        System.out.println("Conversión Colón => Peso Méxicano");
                        System.out.println("Digite el monto que desea convetir");
                        // Lógica de conversión Colones a Peso Mexicano
                        break;
                    case 4:
                        System.out.println("Conversión Peso Méxicano => Colón");
                        System.out.println("Digite el monto que desea convetir");
                        // Lógica de conversión Peso Mexicano a Colones
                        break;
                    case 5:
                        System.out.println("Conversión Colón => Libra Esterlina");
                        System.out.println("Digite el monto que desea convetir");
                        // Lógica de conversión Colones a Libra Esterlina
                        break;
                    case 6:
                        System.out.println("Coversión Libra Esterlina => Colón");
                        System.out.println("Digite el monto que desea convetir");
                        // Lógica de conversión Libra Esterlina a Colones
                        break;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
