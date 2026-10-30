package colas;

/**
 * Clase que representa un nodo para almacenar datos y enlazar con el siguiente nodo
 * @param <T> Tipo de dato que almacena el nodo
 */

public class Nodo<T> {
    T dato;
    Nodo<T> siguiente;

    //Constructor que inicializa el nodo con un dato

    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}