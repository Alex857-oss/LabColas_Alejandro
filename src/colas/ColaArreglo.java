package colas;

/**
 * Clase que implementa una Cola utilizando un arreglo circular
 */

public class ColaArreglo {
    private int[] datos;
    private int frente;
    private int fin;
    private int tamano;
    private int capacidad;

    /**
     * Constructor que inicializa la cola con una capacidad máxima
     * @param capacidad Número máximo de elementos que puede almacenar la cola
     */

    public ColaArreglo(int capacidad) {
        this.capacidad = capacidad;
        this.datos = new int[capacidad];
        this.frente = 0;
        this.fin = -1;
        this.tamano = 0;
    }

    // ========== Paso 1.2: Metodos de consulta

    /**
     * Verifica si la cola no tiene elementos
     * @return true si está vacía, false en caso contrario
     */

    public boolean estaVacia() {
        return tamano == 0;
    }

    /**
     * Verifica si la cola alcanzo su capacidad maxima
     * @return true si está llena, false en caso contrario
     */

    public boolean estaLlena() {
        return tamano == capacidad;
    }

    /**
     * Devuelve la cantidad actual de elementos en la cola
     */

    public int tamano() {
        return tamano;
    }

    // ========== Paso 1.3: Metodo encolar
    /**
     * Agrega un elemento al final de la cola
     * @param valor elemento a agregar
     * @throws IllegalStateException si la cola está llena
     */

    public void encolar(int valor) {
        if (estaLlena()) {
            throw new IllegalStateException("La cola está llena");
        }
        fin = (fin + 1) % capacidad; //avance circular
        datos[fin] = valor;
        tamano++;
    }

    // ========== Paso 1.4: Métodos desencolar y frente

    /**
     * Elimina y devuelve el elemento del frente de la cola
     * @return elemento que estaba al frente
     * @throws IllegalStateException si la cola está vacía
     */

    public int desencolar() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola esta vacia");
        }
        int valor = datos[frente];
        frente = (frente + 1) % capacidad;
        tamano--;
        return valor;
    }

    /**
     * Consulta el elemento del frente sin eliminarlo
     * @return elemento del frente
     * @throws IllegalStateException si la cola está vacía
     */

    public int frente() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola esta vacia");
        }
        return datos[frente];
    }
}