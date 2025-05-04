import java.util.ArrayList;
import java.util.List;

/**
 * Clase genérica para gestionar tareas usando una lista enlazada.
 * Permite agregar, eliminar, buscar, contar, invertir y mover tareas 
 */
public class GestorDeTareas<T> {
    private Node<T> head; // Nodo cabeza de la lista enlazada 
    private List<T> tareasCompletadas; // Lista para almacenar tareas que ya han sido completadas

    // Constructor: inicializa la lista enlazada 
    public GestorDeTareas() {
        this.head = null;
        this.tareasCompletadas = new ArrayList<>();
    }

    /**
     * Agrega una tarea al final de la lista enlazada.
     */
    public void agregarTarea(T tarea) {
        Node<T> nuevo = new Node<>(tarea); // Crea un nuevo nodo con la tarea
        if (head == null) {
            head = nuevo; // Si la lista está vacía, el nuevo nodo es el primero
        } else {
            Node<T> actual = head;
            while (actual.next != null) {
                actual = actual.next; // Recorre hasta el último nodo
            }
            actual.next = nuevo; // Lo enlaza al final
        }
    }

    /**
     * Elimina una tarea si existe en la lista enlazada.
     * Retorna true si se eliminó, false si no se encontró.
     */
    public boolean eliminarTarea(T tarea) {
        if (head == null) return false; // Lista vacía

        // Si la tarea está en el primer nodo
        if (head.data.equals(tarea)) {
            head = head.next;
            return true;
        }

        // Buscar la tarea en los siguientes nodos
        Node<T> actual = head;
        while (actual.next != null && !actual.next.data.equals(tarea)) {
            actual = actual.next;
        }

        // Si se encontró la tarea, se elimina el nodo
        if (actual.next != null) {
            actual.next = actual.next.next;
            return true;
        }

        return false; // No se encontró
    }

    /**
     * Verifica si una tarea está en la lista.
     * Retorna true si existe, false si no.
     */
    public boolean contieneTarea(T tarea) {
        Node<T> actual = head;
        while (actual != null) {
            if (actual.data.equals(tarea)) return true;
            actual = actual.next;
        }
        return false;
    }

    /**
     * Imprime todas las tareas de la lista.
     */
    public void imprimirTareas() {
        Node<T> actual = head;
        while (actual != null) {
            System.out.println(actual.data); // Usa toString() de la clase Tarea
            actual = actual.next;
        }
    }

    /**
     * Cuenta cuántas tareas hay en la lista enlazada.
     */
    public int contarTareas() {
        int contador = 0;
        Node<T> actual = head;
        while (actual != null) {
            contador++;
            actual = actual.next;
        }
        return contador;
    }

    /**
     * Retorna la tarea de mayor prioridad.
     * Solo funciona si T es una instancia de Tarea.
     */
    public T obtenerTareaMasPrioritaria() {
        if (head == null || !(head.data instanceof Tarea)) return null;

        Node<T> actual = head;
        Tarea masPrioritaria = (Tarea) actual.data;

        while (actual != null) {
            Tarea t = (Tarea) actual.data;
            if (t.getPrioridad() > masPrioritaria.getPrioridad()) {
                masPrioritaria = t;
            }
            actual = actual.next;
        }

        return (T) masPrioritaria;
    }

    /**
     * Invierte el orden de la lista enlazada.
     */
    public void invertirTareas() {
        Node<T> anterior = null;
        Node<T> actual = head;

        while (actual != null) {
            Node<T> siguiente = actual.next; // Guarda el siguiente nodo
            actual.next = anterior;          // Invierte el enlace
            anterior = actual;
            actual = siguiente;
        }

        head = anterior; // Nuevo inicio de la lista
    }

    /**
     * Mueve una tarea a la lista de tareas completadas si se encuentra en la lista principal.
     */
    public boolean moverATareasCompletadas(T tarea) {
        if (eliminarTarea(tarea)) {
            tareasCompletadas.add(tarea);
            return true;
        }
        return false;
    }

    /**
     * Imprime todas las tareas que han sido completadas.
     */
    public void imprimirTareasCompletadas() {
        for (T tarea : tareasCompletadas) {
            System.out.println(tarea);
        }
    }
}
