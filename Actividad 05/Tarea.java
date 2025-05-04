public class Tarea {
    private String titulo;
    private int prioridad;

    // Constructor
    public Tarea(String titulo, int prioridad) {
        this.titulo = titulo;
        this.prioridad = prioridad;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    // Método Tostring
    @Override
    public String toString() {
        return "Tarea{" +
                "titulo='" + titulo + '\'' +
                ", prioridad=" + prioridad +
                '}';
    }

    // Método para comparar si dos tareas son iguales (necesario para eliminar/buscar)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tarea tarea = (Tarea) obj;
        return prioridad == tarea.prioridad && titulo.equals(tarea.titulo);
    }
}
