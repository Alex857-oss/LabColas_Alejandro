package colas;

import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {
        ColaEnlazada<String> fila = new ColaEnlazada<>();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== FILA DE BANCO =====");
            System.out.println("1. Llega un cliente");
            System.out.println("2. Atender al siguiente cliente");
            System.out.println("3. Ver quién sigue");
            System.out.println("4. Ver cantidad de clientes en espera");
            System.out.println("5. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el nombre del cliente: ");
                    String nombre = sc.nextLine();
                    fila.encolar(nombre);
                    System.out.println("Cliente \"" + nombre + "\" se ha agregado a la fila.");
                    break;

                case 2:
                    if (fila.estaVacia()) {
                        System.out.println("No hay clientes en espera");
                    } else {
                        String atendido = fila.desencolar();
                        System.out.println("Atendiendo a: " + atendido);
                    }
                    break;

                case 3:
                    if (fila.estaVacia()) {
                        System.out.println("No hay clientes en espera");
                    } else {
                        System.out.println("Sigue: " + fila.frente());
                    }
                    break;

                case 4:
                    System.out.println("Clientes en espera: " + fila.tamano());
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion no valida. Intenta nuevamente.");
            }

        } while (opcion != 5);

        sc.close();
    }
}