import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    static void main(String[] args) {
    GestorTarea gestor = new GestorTarea(new ArrayList<>());
    int indice;
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
       do {
           System.out.println("====Bienvenido al gestor de Tareas====");
           System.out.println("1.VER LISTA DE TAREAS\n" +
                   "2.AGREGAR TAREA \n" +
                   "3.ELIMINAR TAREA\n" +
                   "4. MODIFICAR ESTADO DE TAREA.\n" +
                   "5.SALIR \n"
           );
           indice = sc.nextInt();

           switch (indice){
               case 1: gestor.mostrarTareas();
                   break;
               case 2: gestor.agregarTarea();
                   break;
               case 3: gestor.eliminarTarea();
                   break;
               case 4: gestor.completarTarea();
                   break;
               case 5:
                   System.out.println("Se ha cerrado el programa"); salir = true;
                   break;
               default:
                   System.out.println("introduce un número válido\n");
                   break;
           }

       } while(!salir);



    }
}
