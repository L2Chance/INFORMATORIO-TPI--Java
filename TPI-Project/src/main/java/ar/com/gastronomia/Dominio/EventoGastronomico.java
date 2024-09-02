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
    private Chef chef_a_cargo;
    private List<Participante> lista_de_participantes = new ArrayList<>();

    public EventoGastronomico(){

    }

    public EventoGastronomico(UUID id, String nombre, String descripcion, LocalDateTime horario, String ubicacion, int capacidad, Chef chef_a_cargo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.horario = horario;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.chef_a_cargo = chef_a_cargo;
    }

    public List<Participante> getLista_de_participantes() {
        return lista_de_participantes;
    }

    public void setLista_de_participantes(List<Participante> lista_de_participantes) {
        this.lista_de_participantes = lista_de_participantes;
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

    public Chef getChef_a_cargo() {
        return chef_a_cargo;
    }

    public void setChef_a_cargo(Chef chef_a_cargo) {
        this.chef_a_cargo = chef_a_cargo;
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
                    .append(this.getChef_a_cargo().getNombre()).append("\n")
                    .append("-----------------------\n")
                    .toString();

    }
}
