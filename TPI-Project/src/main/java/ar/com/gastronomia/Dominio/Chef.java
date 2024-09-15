package ar.com.gastronomia.Dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Chef {
    private UUID id;
    private String nombre;
    private String apellido;
    private String especialidad;
    private List<EventoGastronomico> listaEventos = new ArrayList<>();

    public Chef(){

    }

    public Chef(UUID id, String nombre,String apellido, String especialidad, List<EventoGastronomico> listaEventos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.listaEventos = listaEventos;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<EventoGastronomico> getListaEventos() {
        return listaEventos;
    }

    public void setListaEventos(List<EventoGastronomico> listaEventos) {
        this.listaEventos = listaEventos;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        return builder.append("id: ")
                .append(this.getId()).append("\n")
                .append("Nombre: ")
                .append(this.getNombre()).append("\n")
                .append("Apellido: ")
                .append(this.getApellido()).append("\n")
                .append("Especialidad: ")
                .append(this.getEspecialidad()).append("\n")
                .append("Eventos")
                .append(this.getListaEventos()).toString();
    }
}
