package ar.com.gastronomia.Dominio;

import java.util.ArrayList;
import java.util.List;

public class Organizador {
    private List<EventoGastronomico> eventos = new ArrayList<>();
    private List<Chef> lista_de_chefs = new ArrayList<>();
    private List<Participante> participantes = new ArrayList<>();

    public Organizador(){

    }

    public Organizador(List<EventoGastronomico> eventos, List<Chef> lista_de_chefs, List<Participante> participantes) {
        this.eventos = eventos;
        this.lista_de_chefs = lista_de_chefs;
        this.participantes = participantes;
    }

    public List<EventoGastronomico> getEventos() {
        return eventos;
    }

    public void setEventos(List<EventoGastronomico> eventos) {
        this.eventos = eventos;
    }

    public List<Chef> getLista_de_chefs() {
        return lista_de_chefs;
    }

    public void setLista_de_chefs(List<Chef> lista_de_chefs) {
        this.lista_de_chefs = lista_de_chefs;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }
}
