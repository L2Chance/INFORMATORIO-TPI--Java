package ar.com.gastronomia.Dominio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EventoGastronomico {
    private UUID id;
    private String nombre;
    private String descripcion;
    private LocalDateTime horario;
    private String ubicacion;
    private int capacidad;
    private Chef chefAsignado;
    private List<Participante> listaParticipantes = new ArrayList<>();

    public EventoGastronomico(){

    }

    public EventoGastronomico(String nombre, UUID id, String descripcion, LocalDateTime horario, String ubicacion, int capacidad, Chef chefAsignado, List<Participante> listaParticipantes) {
        this.nombre = nombre;
        this.id = id;
        this.descripcion = descripcion;
        this.horario = horario;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.chefAsignado = chefAsignado;
        this.listaParticipantes = listaParticipantes;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Chef getChefAsignado() {
        return chefAsignado;
    }

    public void setChefAsignado(Chef chefAsignado) {
        this.chefAsignado = chefAsignado;
    }

    public List<Participante> getListaParticipantes() {
        return listaParticipantes;
    }

    public void setListaParticipantes(List<Participante> listaParticipantes) {
        this.listaParticipantes = listaParticipantes;
    }

    @Override
    public String toString() {

            StringBuilder myString = new StringBuilder();

            return myString.append("id: ")
                    .append(this.getId()).append("\n")
                    .append("Nombre:  ")
                    .append(this.getNombre()).append("\n")
                    .append("Horario: ")
                    .append(this.getHorario()).append("\n")
                    .append("Ubicación: ")
                    .append(this.getUbicacion()).append("\n")
                    .append("Chef a cargo: ")
                    .append(this.getChefAsignado().getNombre())
                    .toString();

    }
}
