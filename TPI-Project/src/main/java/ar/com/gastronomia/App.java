package ar.com.gastronomia;

import ar.com.gastronomia.Dominio.Organizador;

import ar.com.gastronomia.Servicio.Chef.ChefServiceImpl;
import ar.com.gastronomia.Servicio.Chef.ChefService;
import ar.com.gastronomia.Servicio.Evento.EventoServiceImpl;
import ar.com.gastronomia.Servicio.Evento.EventoService;

import ar.com.gastronomia.Servicio.Menu.MenuServiceImpl;
import ar.com.gastronomia.Servicio.Menu.MenuService;

import ar.com.gastronomia.Servicio.Organizador.OrganizadorServiceImpl;
import ar.com.gastronomia.Servicio.Organizador.OrganizadorService;

import ar.com.gastronomia.Servicio.Participante.ParticipanteServiceImpl;
import ar.com.gastronomia.Servicio.Participante.ParticipanteService;

import ar.com.gastronomia.Servicio.Resena.ResenaService;
import ar.com.gastronomia.Servicio.Resena.ResenaServiceImpl;


import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {

        Organizador organizadorEvento = new Organizador();
        EventoService eventoService = new EventoServiceImpl(organizadorEvento);
        OrganizadorService organizadorService = new OrganizadorServiceImpl(organizadorEvento);
        ParticipanteService participanteService = new ParticipanteServiceImpl(organizadorEvento);
        ChefService chefService = new ChefServiceImpl(organizadorEvento);
        ResenaService resenaService = new ResenaServiceImpl(organizadorEvento);
        MenuService menuService = new MenuServiceImpl(organizadorService, participanteService, eventoService, chefService, resenaService);

        menuService.mostrarMenu();

        eventoService.cerrarWriter();

        resenaService.cerrarScanner();
        chefService.cerrarScanner();
        eventoService.cerrarScanner();
        menuService.cerrarScanner();
        participanteService.cerrarScanner();

    }
}

