package co.example.prueba.consumo;

import java.text.SimpleDateFormat;
import java.util.Date;

import co.example.prueba.modelo.Ficha;
import co.example.prueba.modelo.Municipio;
import co.example.prueba.modelo.Responsable;

public class Prestamo {

    private String codigo;
   private long fechasolicitud;
    private String fechasalida;
    private String fechadevolucion;
    private short estado;
    private String observacion;
    private Ficha fk_ficha;
    private Municipio fk_municipio;
    private Responsable fk_responsable;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Prestamo(Long fechasolicitud, String fechasalida, String fechadevolucion, short estado, String observacion, Ficha fk_ficha, Municipio fk_municipio, Responsable fk_responsable , String codigo) {
        this.fechasolicitud = fechasolicitud;
        this.fechasalida = fechasalida;
        this.fechadevolucion = fechadevolucion;
        this.estado = estado;
        this.observacion = observacion;
        this.fk_ficha = fk_ficha;
        this.fk_municipio = fk_municipio;
        this.fk_responsable = fk_responsable;
        this.codigo = codigo;
    }

    public long getFechasolicitud() {
        return fechasolicitud;
    }

    public void setFechasolicitud(long fechasolicitud) {
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

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String descripcion) {
        this.observacion = descripcion;
    }

    public Ficha getFk_ficha() {
        return fk_ficha;
    }

    public void setFk_ficha(Ficha fk_ficha) {
        this.fk_ficha = fk_ficha;
    }

    public Municipio getFk_municipio() {
        return fk_municipio;
    }

    public void setFk_municipio(Municipio fk_municipio) {
        this.fk_municipio = fk_municipio;
    }

    public Responsable getFk_responsable() {
        return fk_responsable;
    }

    public void setFk_responsable(Responsable fk_responsable) {
        this.fk_responsable = fk_responsable;
    }

    public Prestamo() {
    }

}
