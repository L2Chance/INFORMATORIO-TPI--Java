package ar.com.gastronomia.Servicio.Chef;

import ar.com.gastronomia.Dominio.Organizador;
import ar.com.gastronomia.Dominio.Participante;
import ar.com.gastronomia.Dominio.Chef;

public class ChefImplement implements ChefService {
    private Organizador organizador;

    public ChefImplement(Organizador organizador) {
        this.organizador = organizador;
    }

    public void listarchefs() {
        for (Chef chef : organizador.getLista_de_chefs()){
            System.out.println(chef.toString());
        }
    }

}
