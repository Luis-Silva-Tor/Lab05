import java.util.List;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
	    GestorDeTareas<Tarea> gestor = new GestorDeTareas<>();

	   
       	     // EJERCICIO 1: Buscar un elemento genérico en una lista 
        List<String> nombres = List.of("Karen", "Diego", "Santiago");
        if (buscarElemento(nombres, "Diego")) {
            System.out.println("Sí está");
        } else {
            System.out.println("No está");
        }

        // ====== EJERCICIO 2: Invertir una lista genérica
        List<String> invertida = invertirLista(nombres);
        System.out.println("Lista original: " + nombres);
        System.out.println("Lista invertida: " + invertida);

        // ====== EJERCICIO 3: Insertar un nodo al final 
        Node<String> head = null;
        head = insertarAlFinal(head, "Uno");
        head = insertarAlFinal(head, "Dos");
        head = insertarAlFinal(head, "Tres");

        // ====== EJERCICIO 4: Contar los nodos 
        int total = contarNodos(head);
        System.out.println("Total de nodos: " + total);

        // ====== EJERCICIO 5: Comparar dos listas 
        Node<String> head2 = null;
        head2 = insertarAlFinal(head2, "Uno");
        head2 = insertarAlFinal(head2, "Dos");
        head2 = insertarAlFinal(head2, "Tres");

        boolean iguales = sonIguales(head, head2);
        System.out.println("¿Son iguales las dos listas?: " + (iguales ? "Sí" : "No"));

        // ====== EJERCICIO 6: Concatenar dos listas 
        Node<String> head3 = null;
        head3 = insertarAlFinal(head3, "Cuatro");
        head3 = insertarAlFinal(head3, "Cinco");

        Node<String> listaConcatenada = concatenarListas(head, head3);

        System.out.println("Lista concatenada:");
        imprimirLista(listaConcatenada);
    }

    // organizacion de cada unos de los elementos 

    // EJERCICIO 1: buscarElemento
    public static <T> boolean buscarElemento(List<T> lista, T valor) {
        for (T elemento : lista) {
            if (elemento.equals(valor)) return true;
        }
        return false;
    }

    // EJERCICIO 2: invertirLista
    public static <T> List<T> invertirLista(List<T> lista) {
        List<T> invertida = new ArrayList<>();
        for (int i = lista.size() - 1; i >= 0; i--) {
            invertida.add(lista.get(i));
        }
        return invertida;
    }

    // EJERCICIO 3: insertarAlFinal
    public static <T> Node<T> insertarAlFinal(Node<T> head, T valor) {
        Node<T> nuevo = new Node<>(valor);
        if (head == null) return nuevo;

        Node<T> actual = head;
        while (actual.next != null) {
            actual = actual.next;
        }
        actual.next = nuevo;
        return head;
    }

    // EJERCICIO 4: contarNodos
    public static <T> int contarNodos(Node<T> head) {
        int contador = 0;
        Node<T> actual = head;
        while (actual != null) {
            contador++;
            actual = actual.next;
        }
        return contador;
    }

    // EJERCICIO 5: sonIguales
    public static <T> boolean sonIguales(Node<T> head1, Node<T> head2) {
        Node<T> actual1 = head1;
        Node<T> actual2 = head2;

        while (actual1 != null && actual2 != null) {
            if (!actual1.data.equals(actual2.data)) {
                return false;
            }
            actual1 = actual1.next;
            actual2 = actual2.next;
        }

        return actual1 == null && actual2 == null; // ambos deben llegar a null
    }

    // EJERCICIO 6: concatenarListas
    public static <T> Node<T> concatenarListas(Node<T> head1, Node<T> head2) {
        if (head1 == null) return head2;
        Node<T> actual = head1;
        while (actual.next != null) {
            actual = actual.next;
        }
        actual.next = head2;
        return head1;
    }

    // Método extra: imprimir lista (para ver la concatenación)
    public static <T> void imprimirLista(Node<T> head) {
        Node<T> actual = head;
        while (actual != null) {
            System.out.print(actual.data + " -> ");
            actual = actual.next;
        }
        System.out.println("null");
        
        
        
        

    }
}