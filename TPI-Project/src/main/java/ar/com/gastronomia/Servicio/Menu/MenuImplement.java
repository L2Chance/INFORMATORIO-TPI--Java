package ar.com.gastronomia.Servicio.Menu;

import ar.com.gastronomia.Dominio.Organizador;
import ar.com.gastronomia.Servicio.Chef.ChefService;
import ar.com.gastronomia.Servicio.Evento.EventoService;
import ar.com.gastronomia.Servicio.Organizador.*;
import ar.com.gastronomia.App;
import ar.com.gastronomia.Servicio.Participante.ParticipanteService;

import java.io.IOException;
import java.util.UUID;
import java.util.Scanner;

public class MenuImplement implements MenuService{
    private OrganizadorService organizador_service;
    private ParticipanteService participante_service;
    private EventoService evento_service;
    private ChefService chef_service;

    public MenuImplement(OrganizadorService organizador_service, ParticipanteService participante_service, EventoService evento_service, ChefService chef_service) {
        this.organizador_service = organizador_service;
        this.participante_service = participante_service;
        this.evento_service = evento_service;
        this.chef_service = chef_service;
    }

    public void mostrar_menu(Scanner scanner) throws IOException {
        int option = 0;

        do{
            System.out.println("Ingrese su opción: ");
            System.out.println("----------------------");
            System.out.println("1. Crear evento nuevo");
            System.out.println("2. Crear nuevo participante");
            System.out.println("3. Inscribirse a un evento");
            System.out.println("4. Reseñar evento");
            System.out.println("5. Crear nuevo chef");
            System.out.println("6. Asignar un evento existente a un chef");
            System.out.println("7. Listar eventos disponibles a partir de una fecha");
            System.out.println("8. Exportar archivo");
            System.out.println("9. Listar participantes");
            System.out.println("10. Listar chefs");
            System.out.println("11. Listar eventos");
            System.out.println("12. Salir");

            System.out.println();

            System.out.print("opcion: ");
            option = scanner.nextInt();
            scanner.nextLine();

            System.out.println();

            switch (option){
                case 1:

                    organizador_service.crearevento();
                    break;

                case 2:

                    participante_service.participante_nuevo(scanner);
                    break;

                case 3:

                    participante_service.inscribirse_a_evento(scanner);
                    break;

                case 4:

                    participante_service.hacer_resena(scanner);
                    break;

                case 5:

                    organizador_service.agregarchef(scanner);
                    break;

                case 6:

                    organizador_service.asignar_evento_a_chef();
                    break;

                case 7:

                    evento_service.listar_eventos(scanner);
                    break;

                case 8:

                    evento_service.exportar_archivo(scanner);
                    break;

                case 9:

                    participante_service.listado();
                    break;

                case 10:
                    chef_service.listarchefs();
                    break;

                case 11:

                    evento_service.listado();
                    break;

                case 12:

                    System.out.println("Programa cerrado");
                    break;

                default:
                    System.out.println("ERROR: !INGRESE UN VALOR VALIDO!");
                    System.out.println();
                    break;

            }

        } while(option != 12);

        System.out.println("Aplicación finalizada");

    }
}
