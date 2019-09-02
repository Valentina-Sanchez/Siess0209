package co.example.prueba.consumo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Prestamo {

   private String fechasolicitud;
    private String fechasalida;
    private String fechadevolucion;
     public SimpleDateFormat sdf;

    public Prestamo() {
    }

    public Prestamo(String fechasolicitud, String fechasalida, String fechadevolucion, SimpleDateFormat sdf) {
        this.fechasolicitud = fechasolicitud;
        this.fechasalida = fechasalida;
        this.fechadevolucion = fechadevolucion;
        this.sdf = sdf;
    }

    public String getFechasolicitud() {
        return fechasolicitud;
    }

    public void setFechasolicitud(String fechasolicitud) {
        this.fechasolicitud = fechasolicitud;
    }

    public String getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(String fechasalida) {
        this.fechasalida = fechasalida;
    }

    public String getFechadevolucion() {
        return fechadevolucion;
    }

    public void setFechadevolucion(String fechadevolucion) {
        this.fechadevolucion = fechadevolucion;
    }
}
