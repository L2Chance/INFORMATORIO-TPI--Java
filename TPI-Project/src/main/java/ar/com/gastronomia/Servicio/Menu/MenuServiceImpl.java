package ar.com.gastronomia.Servicio.Menu;

import ar.com.gastronomia.Servicio.Chef.ChefService;
import ar.com.gastronomia.Servicio.Evento.EventoService;
import ar.com.gastronomia.Servicio.Organizador.*;
import ar.com.gastronomia.Servicio.Participante.ParticipanteService;
import ar.com.gastronomia.Servicio.Resena.ResenaService;

import java.io.IOException;
import java.util.Scanner;

public class MenuServiceImpl implements MenuService{
    Scanner scanner = new Scanner(System.in);
    private OrganizadorService organizadorService;
    private ParticipanteService participanteService;
    private EventoService eventoService;
    private ChefService ChefService;
    private ResenaService resenaService;

    public MenuServiceImpl(OrganizadorService organizadorService, ParticipanteService participanteService, EventoService eventoService, ChefService ChefService, ResenaService resenaService) {
        this.organizadorService = organizadorService;
        this.participanteService = participanteService;
        this.eventoService = eventoService;
        this.ChefService = ChefService;
        this.resenaService = resenaService;
    }

    public void mostrarMenu() throws IOException {
        int option = 0;

        do{
            System.out.println("Ingrese su opción: ");
            System.out.println("----------------------");
            System.out.println("1. Crear evento nuevo (Requiere ID de chef)");
            System.out.println("2. Crear nuevo participante");
            System.out.println("3. Inscribirse a un evento (Requiere ID de evento e ID de participante)");
            System.out.println("4. Reseñar evento (Requiere ID de participante e ID de participante)");
            System.out.println("5. Crear nuevo chef");
            System.out.println("6. Asignar un evento existente a un chef (Requiere ID de chef e ID de evento)");
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

                    eventoService.crearEvento();
                    break;

                case 2:

                    participanteService.participanteNuevo();
                    break;

                case 3:

                    participanteService.inscribirseEvento();
                    break;

                case 4:

                    resenaService.hacerResena();
                    break;

                case 5:

                    ChefService.agregarChef();
                    break;

                case 6:

                    ChefService.asignarEventoAChef();
                    break;

                case 7:

                    eventoService.listarEventosDeUnaFecha();
                    break;

                case 8:

                    eventoService.exportarArchivo();
                    break;

                case 9:

                    participanteService.listadoParticipante();
                    break;

                case 10:
                    ChefService.listarChefs();
                    break;

                case 11:

                    eventoService.listarEventos();
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

    public void cerrarScanner(){
        scanner.close();
    }
}
