//Correcciones:
/*

- Corregidos los nombres de parametros para ajustarse a las
normas de escritura de atributos

    eventos -> listaEventos
    lista_de_chefs -> listaChefs
    participantes -> listaParticipantes

*/

package ar.com.gastronomia.Dominio;

import java.util.ArrayList;
import java.util.List;

public class Organizador {
    private List<EventoGastronomico> listaEventos = new ArrayList<>();
    private List<Chef> listaChefs = new ArrayList<>();
    private List<Participante> listaParticipantes = new ArrayList<>();

    public Organizador(){

    }

    public Organizador(List<EventoGastronomico> listaEventos, List<Chef> listaChefs, List<Participante> listaParticipantes) {
        this.listaEventos = listaEventos;
        this.listaChefs = listaChefs;
        this.listaParticipantes = listaParticipantes;
    }

    public List<EventoGastronomico> getListaEventos() {
        return listaEventos;
    }

    public void setListaEventos(List<EventoGastronomico> listaEventos) {
        this.listaEventos = listaEventos;
    }

    public List<Chef> getListaChefs() {
        return listaChefs;
    }

    public void setListaChefs(List<Chef> listaChefs) {
        this.listaChefs = listaChefs;
    }

    public List<Participante> getListaParticipantes() {
        return listaParticipantes;
    }

    public void setListaParticipantes(List<Participante> listaParticipantes) {
        this.listaParticipantes = listaParticipantes;
    }
}
