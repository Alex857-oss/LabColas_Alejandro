package colas;

public class Main {
    public static void main(String[] args) {

        // ===== Prueba Ejercicio 1 y 2: Imprimir y Vaciar
        System.out.println("=== Ejercicio 1 y 2: Imprimir y Vaciar ===");
        ColaEnlazada<String> cola = new ColaEnlazada<>();
        cola.encolar("Ana");
        cola.encolar("Luis");
        cola.encolar("Maria");
        cola.imprimirCola();
        System.out.println("Tamano: " + cola.tamano());
        
        cola.vaciar();
        cola.imprimirCola();
        System.out.println("Tamano despues de vaciar: " + cola.tamano());

        //==== Prueba Ejercicio 3: Invertir cola
        System.out.println("\n=== Ejercicio 3: Invertir cola ===");
        ColaEnlazada<Integer> numeros = new ColaEnlazada<>();
        numeros.encolar(1);
        numeros.encolar(2);
        numeros.encolar(3);
        System.out.print("Antes de invertir -> ");
        numeros.imprimirCola();
        
        numeros.invertir();
        System.out.print("Despues de invertir -> ");
        numeros.imprimirCola();

        //Prueba Ejercicio 4 Cola con dos pilas
        System.out.println("\n=== Ejercicio 4: Cola con dos pilas ===");
        ColaEnlazada.ColaConDosPilas<Character> colaPilas = new ColaEnlazada.ColaConDosPilas<>();
        colaPilas.encolar('A');
        colaPilas.encolar('B');
        colaPilas.encolar('C');
        
        System.out.println("Frente: " + colaPilas.frente());
        System.out.println("Sale: " + colaPilas.desencolar());
        System.out.println("Sale: " + colaPilas.desencolar());
        colaPilas.encolar('D');
        System.out.println("Sale: " + colaPilas.desencolar());
        System.out.println("Sale: " + colaPilas.desencolar());
    }
}