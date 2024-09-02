package ar.com.gastronomia.Dominio;

import ar.com.gastronomia.Dominio.Enumeration.CalificacionEnum;

import java.util.UUID;

public class Resena {
    private UUID id_resena;
    private EventoGastronomico referencia_evento;
    private Participante referencia_participante;
    private CalificacionEnum calificacion;
    private String comentario;

    public Resena(){

    }

    public Resena(UUID id_resena, EventoGastronomico referencia_evento, Participante referencia_participante, String comentario, CalificacionEnum calificacion) {
        this.id_resena = id_resena;
        this.referencia_evento = referencia_evento;
        this.referencia_participante = referencia_participante;
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    public UUID getId_resena() {
        return id_resena;
    }

    public void setId_resena(UUID id_resena) {
        this.id_resena = id_resena;
    }

    public EventoGastronomico getReferencia_evento() {
        return referencia_evento;
    }

    public void setReferencia_evento(EventoGastronomico referencia_evento) {
        this.referencia_evento = referencia_evento;
    }

    public Participante getReferencia_participante() {
        return referencia_participante;
    }

    public void setReferencia_participante(Participante referencia_participante) {
        this.referencia_participante = referencia_participante;
    }

    public CalificacionEnum getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(CalificacionEnum calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        return builder
                .append("-----------------------------------------")
                .append("ID: ")
                .append(this.getId_resena()).append("\n")
                .append("Reseñador ")
                .append(this.referencia_participante.getNombreyapellido()).append("\n")
                .append("Evento:")
                .append(this.getReferencia_evento().getNombre()).append("\n")
                .append("Comentario: ")
                .append(this.getComentario()).append("\n")
                .append("-----------------------------------------").toString();

    }
}
