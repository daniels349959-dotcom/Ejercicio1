import java.util.ArrayList;
import java.util.Scanner;

public class GestorTarea {
    Scanner sc = new Scanner(System.in);
    ArrayList<Tarea> tareas;

    public GestorTarea(ArrayList<Tarea> tareas) {
        this.tareas = new ArrayList<>();
    }

    private String leerLinea(String mensaje) {
        System.out.println(mensaje);
        return sc.nextLine();
    }


    private String leerPalabra(String mensaje) {
        System.out.println(mensaje);
        return sc.next();
    }


    private Tarea buscarPorNombre(String nombre) {
        for (Tarea tarea : tareas) {
            if (tarea.getNombre().equals(nombre)) {
                return tarea;
            }
        }
        return null;
    }

    public void agregarTarea(){
        System.out.println("==AGREGAR TAREA==");
        String nombre = leerLinea("Introduce el nombre: ");
        String descripcion = leerLinea("Introduce la descripción: ");
        Tarea tarea = new Tarea(nombre,descripcion);

        tareas.add(tarea);

        System.out.println("Tarea agregada\n");
        System.out.println(tarea);
    }

    public void eliminarTarea() {
        System.out.println("==ELIMINAR TAREA==");
        String nombre = leerPalabra("Introduce el nombre");

        boolean eliminado = tareas.removeIf(tarea -> tarea.getNombre().equals(nombre));

        if(eliminado){
            System.out.println("Tarea eliminada con éxito");
        }else{
            System.out.println("La tarea no se ha encontrado o no ha sido eliminada");
        }


    }

    public boolean completarTarea() {
        String nombre = leerPalabra("Introduce el nombre");
        Tarea tarea = buscarPorNombre(nombre);

        if (tarea != null) {
            tarea.setEstado(true);
            System.out.println("La tarea se ha marcado como completada.");
            return true;
        }

        System.out.println("La tarea no ha sido marcada como completada");
        return false;
    }


    public void mostrarTareas(){
        System.out.println("==LISTA DE TAREAS==\n");
        if (!tareas.isEmpty()){
            for (Tarea t : tareas) {
                System.out.println(t);
            }
        }else{
            System.out.println("No hay tareas que mostrar\n");

        }

    }



}
