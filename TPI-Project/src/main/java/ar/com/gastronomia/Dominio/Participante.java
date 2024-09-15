package ar.com.gastronomia.Dominio;

import java.util.ArrayList;
import java.util.UUID;
import java.util.Set;
import java.util.List;
import java.util.HashSet;

public class Participante {
    private UUID id;
    private String nombre;
    private String Apellido;
    private Set<String> intereses = new HashSet<>();
    private List<EventoGastronomico> eventosParticipados = new ArrayList<>();

    public Participante(){

    }

    public Participante(UUID id, String nombre, String apellido, Set<String> intereses, List<EventoGastronomico> eventosParticipados) {
        this.id = id;
        this.nombre = nombre;
        Apellido = apellido;
        this.intereses = intereses;
        this.eventosParticipados = eventosParticipados;
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

    public Set<String> getIntereses() {
        return intereses;
    }

    public void setIntereses(Set<String> intereses) {
        this.intereses = intereses;
    }

    public List<EventoGastronomico> getEventosParticipados() {
        return eventosParticipados;
    }

    public void setEventosParticipados(List<EventoGastronomico> eventosParticipados) {
        this.eventosParticipados = eventosParticipados;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String toString() {

        StringBuilder builder = new StringBuilder();

        return builder.append("ID: ")
                .append(this.getId()).append("\n")
                .append("Nombre: ")
                .append(this.getNombre()).append("\n")
                .append("Apellido: ")
                .append(this.getApellido()).append("\n")
                .append("Intereses:")
                .append(this.getIntereses()).append("\n")
                .append("Eventos participados: ")
                .append(this.getEventosParticipados())
                .toString();
    }
}
