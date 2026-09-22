public class Tarea {
    String nombre;
    String descripcion;
    String prioridad;
    boolean estado;

    //Constructor con nombre y descripcion, por defecto no estará completada.

    public Tarea(String nombre, String descripcion, String prioridad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = false;
    }

    //Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    private String mensajeEstado(){
        return estado ? "Completada" : "Por completar";
    }

    @Override
    public String toString() {
        return "====Tarea==== \n" +
                "Nombre | " + nombre + '\n' +
                "Descripción | " + descripcion + '\n' +
                "Prioridad | " + prioridad + '\n' +
                " Estado | " + mensajeEstado() +"\n"
                ;
    }
}
