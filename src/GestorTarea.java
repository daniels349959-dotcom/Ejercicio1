import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GestorTarea {
    Scanner sc;
    ArrayList<Tarea> tareas;

    public GestorTarea(ArrayList<Tarea> tareas, Scanner sc) {
        this.tareas = tareas;
        this.sc = sc;
    }

    private String leerLinea(String mensaje) {
        System.out.println(mensaje);
        return sc.nextLine();
    }


    private String leerPalabra(String mensaje) {
        System.out.println(mensaje);
        return sc.nextLine();
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
        String prioridad = leerLinea("Introduce la prioridad (alta, media o baja): ");

        while (!prioridad.equalsIgnoreCase("alta") &&
                !prioridad.equalsIgnoreCase("media") &&
                !prioridad.equalsIgnoreCase("baja")) {
            prioridad = leerLinea("Prioridad no válida. Escribe alta, media o baja: ");
        }

        Tarea tarea = new Tarea(nombre, descripcion, prioridad.toLowerCase());

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

    public void filtrarPorPrioridad() {
        String prioridad = leerLinea("Introduce la prioridad que quieres ver (alta, media o baja): ");
        boolean encontrada = false;

        for (Tarea tarea : tareas) {
            if (tarea.getPrioridad().equalsIgnoreCase(prioridad)) {
                System.out.println(tarea);
                encontrada = true;
            }
        }

        if (!encontrada) {
            System.out.println("No hay tareas con esa prioridad.\n");
        }
    }

    public void guardarTareas() {
        try {
            FileWriter archivo = new FileWriter("tareas.txt");

            for (Tarea tarea : tareas) {
                archivo.write(tarea.toString());
                archivo.write(System.lineSeparator());
            }

            archivo.close();
            System.out.println("Tareas guardadas en tareas.txt");
        } catch (IOException e) {
            System.out.println("No se han podido guardar las tareas.");
        }
    }



}
