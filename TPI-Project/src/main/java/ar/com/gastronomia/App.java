package ar.com.gastronomia;

import ar.com.gastronomia.Dominio.Organizador;

import ar.com.gastronomia.Servicio.Chef.ChefImplement;
import ar.com.gastronomia.Servicio.Chef.ChefService;
import ar.com.gastronomia.Servicio.Evento.EventoImplement;
import ar.com.gastronomia.Servicio.Evento.EventoService;

import ar.com.gastronomia.Servicio.Menu.MenuImplement;
import ar.com.gastronomia.Servicio.Menu.MenuService;

import ar.com.gastronomia.Servicio.Organizador.OrganizadorImplement;
import ar.com.gastronomia.Servicio.Organizador.OrganizadorService;

import ar.com.gastronomia.Servicio.Participante.ParticipanteImplement;
import ar.com.gastronomia.Servicio.Participante.ParticipanteService;


import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        Organizador organizador_de_eventos = new Organizador();
        EventoService evento_service = new EventoImplement(organizador_de_eventos);
        OrganizadorService organizador_service = new OrganizadorImplement(organizador_de_eventos);
        ParticipanteService participante_service = new ParticipanteImplement(organizador_de_eventos);
        ChefService chef_service = new ChefImplement(organizador_de_eventos);
        MenuService menu_service = new MenuImplement(organizador_service, participante_service, evento_service, chef_service);

        menu_service.mostrar_menu(scanner);

        evento_service.cerrarWriter();

        scanner.close();

    }
}
