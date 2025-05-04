public class Node<T> {
    // Atributo que almacena el dato del nodo

	T data;
	 // Referencia al siguiente nodo en la lista
    Node<T> next;
    // El siguiente nodo se establece como null por defecto.
    public Node(T data) {
        this.data = data;
        this.next = null; // Al crear el nodo, no apunta a ningún otro 
    }
}
