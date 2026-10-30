package colas;

import java.util.ArrayDeque;
import java.util.Stack;

public class ColaEnlazada<T> {
    private Nodo<T> frente;
    private Nodo<T> fin;
    private int tamano;

    public boolean estaVacia() {
        return frente == null;
    }

    public int tamano() {
        return tamano;
    }

    public void encolar(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);
        if (estaVacia()) {
            frente = nuevo;
        } else {
            fin.siguiente = nuevo;
        }
        fin = nuevo;
        tamano++;
    }

    public T desencolar() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola esta vacia");
        }
        T valor = frente.dato;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        tamano--;
        return valor;
    }

    public T frente() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola esta vacia");
        }
        return frente.dato;
    }

    //==== Ejercicio 1 Imprimir toda la cola sin destruirla

    public void imprimirCola() {
        if (estaVacia()) {
            System.out.println("La cola esta vacia");
            return;
        }
        Nodo<T> actual = frente;
        System.out.print("Contenido: ");
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    //===== Ejercicio 2 Vaciar la cola
    public void vaciar() {
        frente = null;
        fin = null;
        tamano = 0;
    }

    // ===== Ejercicio 3 Invertir cola usando pila

    public void invertir() {
        if (estaVacia()) return;

        Stack<T> pila = new Stack<>();
        
        // Pasar todos los elementos a la pila
        while (!estaVacia()) {
            pila.push(desencolar());
        }
        
        // Regresar desde la pila (quedan en orden inverso)
        while (!pila.isEmpty()) {
            encolar(pila.pop());
        }
    }

    //===== Ejercicio 4 Implementar cola usando dos pilas

    public static class ColaConDosPilas<T> {
        private ArrayDeque<T> pilaEntrada;
        private ArrayDeque<T> pilaSalida;

        public ColaConDosPilas() {
            pilaEntrada = new ArrayDeque<>();
            pilaSalida = new ArrayDeque<>();
        }

        public void encolar(T valor) {
            pilaEntrada.push(valor);
        }

        public T desencolar() {
            if (estaVacia()) {
                throw new IllegalStateException("La cola esta vacia");
            }
            if (pilaSalida.isEmpty()) {
                while (!pilaEntrada.isEmpty()) {
                    pilaSalida.push(pilaEntrada.pop());
                }
            }
            return pilaSalida.pop();
        }

        public T frente() {
            if (estaVacia()) {
                throw new IllegalStateException("La cola esta vacia");
            }
            if (pilaSalida.isEmpty()) {
                while (!pilaEntrada.isEmpty()) {
                    pilaSalida.push(pilaEntrada.pop());
                }
            }
            return pilaSalida.peek();
        }

        public boolean estaVacia() {
            return pilaEntrada.isEmpty() && pilaSalida.isEmpty();
        }
    }
}