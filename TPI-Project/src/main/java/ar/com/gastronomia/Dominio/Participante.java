package ar.com.gastronomia.Dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Participante {
    private UUID id_participante;
    private String nombreyapellido;
    private String intereses;
    private List<EventoGastronomico> eventos_participados = new ArrayList<>();

    public Participante(){

    }

    public Participante(UUID id_participante, String nombreyapellido, String intereses, List<EventoGastronomico> eventos_participados) {
        this.id_participante = id_participante;
        this.nombreyapellido = nombreyapellido;
        this.intereses = intereses;
        this.eventos_participados = eventos_participados;
    }

    public UUID getId_participante() {
        return id_participante;
    }

    public void setId_participante(UUID id_participante) {
        this.id_participante = id_participante;
    }

    public String getNombreyapellido() {
        return nombreyapellido;
    }

    public void setNombreyapellido(String nombreyapellido) {
        this.nombreyapellido = nombreyapellido;
    }

    public String getIntereses() {
        return intereses;
    }

    public void setIntereses(String intereses) {
        this.intereses = intereses;
    }

    public List<EventoGastronomico> getEventos_participados() {
        return eventos_participados;
    }

    public void setEventos_participados(List<EventoGastronomico> eventos_participados) {
        this.eventos_participados = eventos_participados;
    }

    public String toString() {

        StringBuilder builder = new StringBuilder();

        return builder.append("ID: ")
                .append(this.getId_participante()).append("\n")
                .append("Nombre: ")
                .append(this.getNombreyapellido()).append("\n")
                .append("Intereses:")
                .append(this.getIntereses()).append("\n")
                .append("Eventos participados: ")
                .append(this.getEventos_participados()).append("\n")
                .append("-----------------------------------------").toString();

    }
}
