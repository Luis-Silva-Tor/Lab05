import java.util.List;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
	    GestorDeTareas<Tarea> gestor = new GestorDeTareas<>();

	    // Agregar tareas
	    gestor.agregarTarea(new Tarea("\n Estudiar para el examen", 4));
	    gestor.agregarTarea(new Tarea("\n Comprar pan", 1));

	    System.out.println(" \n TAREAS ACTUALES:");
	    gestor.imprimirTareas();

	    // Eliminar tarea
	    Tarea tareaAEliminar = new Tarea("\n Tarea a eliminar ", 2);
	    gestor.eliminarTarea(tareaAEliminar);
	    System.out.println(" \n Se elimino la tarea: " + tareaAEliminar);

	    // Buscar tarea
	    Tarea tareaABuscar = new Tarea("\n Estudiar para el examen", 4);
	    System.out.println("\n Existe la tarea '" + tareaABuscar.getTitulo() + "'? " + 
	        (gestor.contieneTarea(tareaABuscar) ? "Sí" : "No"));

	    // Contar tareas
	    System.out.println(" \n Número total de tareas: " + gestor.contarTareas());

	    // Obtener tarea más prioritaria
	    System.out.println("\n  Tarea más importante:");
	    System.out.println(gestor.obtenerTareaMasPrioritaria());

	    // Invertir lista
	    gestor.invertirTareas();
	    System.out.println(" \n TAREAS INVERTIDAS:");
	    gestor.imprimirTareas();

	    // Mover una tarea a completadas
	    Tarea tareaCompletada = new Tarea(" \\n Estudiar para el examen", 4);
	    gestor.moverATareasCompletadas(tareaCompletada);

	    System.out.println(" \n  TAREAS DESPUÉS DE MOVER UNA A COMPLETADAS:");
	    gestor.imprimirTareas();

	    System.out.println("\n TAREAS COMPLETADAS:");
	    gestor.imprimirTareasCompletadas();
	

        
        
        
        
        
        

    }
}