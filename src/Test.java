import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorTarea gestor = new GestorTarea(new ArrayList<>(), sc);
        int indice;
        boolean salir = false;
        do {
            System.out.println("====Bienvenido al gestor de Tareas====");
            System.out.println("1.VER LISTA DE TAREAS\n" +
                    "2.AGREGAR TAREA \n" +
                    "3.ELIMINAR TAREA\n" +
                    "4. MODIFICAR ESTADO DE TAREA.\n" +
                    "5.FILTRAR TAREAS POR PRIORIDAD\n" +
                    "6.GUARDAR TAREAS EN UN ARCHIVO\n" +
                    "7.SALIR \n"
            );
            indice = sc.nextInt();
            sc.nextLine();

            switch (indice){
                case 1: gestor.mostrarTareas();
                    break;
                case 2: gestor.agregarTarea();
                    break;
                case 3: gestor.eliminarTarea();
                    break;
                case 4: gestor.completarTarea();
                    break;
                case 5: gestor.filtrarPorPrioridad();
                    break;
                case 6: gestor.guardarTareas();
                    break;
                case 7:
                    System.out.println("Se ha cerrado el programa"); salir = true;
                    break;
                default:
                    System.out.println("introduce un número válido\n");
                    break;
            }

        } while(!salir);



    }
}
