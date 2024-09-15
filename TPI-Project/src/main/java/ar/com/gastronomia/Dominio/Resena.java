package ar.com.gastronomia.Dominio;

import ar.com.gastronomia.Dominio.Enumeration.CalificacionEnum;

import java.util.UUID;

public class Resena {
    private UUID id;
    private EventoGastronomico referenciaEvento;
    private Participante referenciaParticipante;
    private CalificacionEnum calificacion;
    private String comentario;

    public Resena(){

    }

    public Resena(UUID id, EventoGastronomico referenciaEvento, Participante referenciaParticipante, CalificacionEnum calificacion, String comentario) {
        this.id = id;
        this.referenciaEvento = referenciaEvento;
        this.referenciaParticipante = referenciaParticipante;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public EventoGastronomico getReferenciaEvento() {
        return referenciaEvento;
    }

    public void setReferenciaEvento(EventoGastronomico referenciaEvento) {
        this.referenciaEvento = referenciaEvento;
    }

    public Participante getReferenciaParticipante() {
        return referenciaParticipante;
    }

    public void setReferenciaParticipante(Participante referenciaParticipante) {
        this.referenciaParticipante = referenciaParticipante;
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
                .append("ID: ")
                .append(this.getId()).append("\n")
                .append("Reseñador: ")
                .append(this.getReferenciaParticipante().getNombre()).append(" ")
                .append(this.getReferenciaParticipante().getApellido()).append("\n")
                .append("Evento: ")
                .append(this.getReferenciaEvento().getNombre()).append("\n")
                .append("Comentario: ")
                .append(this.getComentario())
                .toString();

    }
}
