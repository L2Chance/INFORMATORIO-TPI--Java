package ar.com.gastronomia.Servicio.Participante;
import ar.com.gastronomia.Dominio.Enumeration.CalificacionEnum;
import ar.com.gastronomia.Dominio.*;
import ar.com.gastronomia.Dominio.Participante;
import ar.com.gastronomia.Dominio.Enumeration.CalificacionEnum;
import ar.com.gastronomia.Servicio.Organizador.OrganizadorService;
import ar.com.gastronomia.Dominio.Participante;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.UUID;

public class ParticipanteImplement implements ParticipanteService {
    private final Organizador organizador;

    public ParticipanteImplement(Organizador organizador) {
        this.organizador = organizador;
    }

    public void participante_nuevo(Scanner scanner) {

        /*Se inscribe al participante a la lista de participantes de la organización*/

        Participante participante = new Participante();

        participante.setId_participante(UUID.randomUUID());

        System.out.println("Ingrese nombre y apellido");

        participante.setNombreyapellido(scanner.nextLine());

        System.out.println("Ingrese sus intereses culinarios");

        participante.setIntereses(scanner.nextLine());

        organizador.getParticipantes().add(participante);

        System.out.println("SE HA CREADO EL PERFIL DEL CHEF CORRECTAMENTE!");
        System.out.println("----------------------------------------------");
        System.out.println(participante.toString());
        System.out.println("----------------------------------------------");
    }

    public void inscribirse_a_evento(Scanner scanner) {

        System.out.println("Ingrese el ID del participante");

        String id_ingresado = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Ingrese el ID del evento");

        String id_evento = scanner.nextLine();
        scanner.nextLine();

        boolean existe_el_participante = Boolean.FALSE;
        boolean existe_el_evento = Boolean.FALSE;

        /*En este código buscamos entre todos los participantes el correcto. Cuando lo encontramos,
         buscamos entre todos los eventos el correcto y finalmente lo asignamos */

        for (Participante participante : organizador.getParticipantes()) {
            if (participante.getId_participante().equals(UUID.fromString(id_ingresado))) {
                existe_el_participante = Boolean.TRUE;

                for (EventoGastronomico evento : organizador.getEventos()) {
                    if (evento.getId().equals(UUID.fromString(id_evento))) {
                        existe_el_evento = Boolean.TRUE;
                        if (evento.getCapacidad() > evento.getLista_de_participantes().size()) {
                            evento.getLista_de_participantes().add(participante);
                            participante.getEventos_participados().add(evento);
                        } else {
                            System.out.println("ERROR: EL EVENTO YA ESTÁ AL TOPE DE PARTICIPANTES!");
                            break;
                        }
                        break;
                    }

                }
                break;
            }

        }

        if (!existe_el_participante){
            throw new NoSuchElementException("ERROR: No existe el participante!");
        }

        if (!existe_el_evento){
            throw new NoSuchElementException("ERROR: No existe el evento!");
        }

        System.out.println();

        System.out.println("INSCRIPCIÓN REALIZADA CORRECTAMENTE");
        System.out.println("-------------------------------------");

    }

    public void hacer_resena(Scanner scanner) {

        Resena nueva_resena = new Resena();
        boolean existe_el_participante = Boolean.FALSE;
        boolean existe_el_evento = Boolean.FALSE;

        nueva_resena.setId_resena(UUID.randomUUID());

        System.out.println("Ingrese su ID");
        String id_resenador = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Ingrese el ID del evento que quiere reseñar");
        String id_para_resenar = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Ingrese la calificación");
        System.out.println("1. UNO - 2. DOS - 3. TRES - 4. CUATRO - 5. CINCO");

        int calificacion = scanner.nextInt();

        switch (calificacion){
            case 1:
                nueva_resena.setCalificacion(CalificacionEnum.UNO);
                break;
            case 2:
                nueva_resena.setCalificacion(CalificacionEnum.DOS);
                break;
            case 3:
                nueva_resena.setCalificacion(CalificacionEnum.TRES);
                break;
            case 4:
                nueva_resena.setCalificacion(CalificacionEnum.CUATRO);
                break;
            case 5:
                nueva_resena.setCalificacion(CalificacionEnum.CINCO);
                break;
            default:
                nueva_resena.setCalificacion((null));
        }

        for (Participante participante : organizador.getParticipantes()) {
            if ((UUID.fromString(id_resenador).equals(participante.getId_participante()))) {
                existe_el_participante = Boolean.TRUE;

                for (EventoGastronomico evento : organizador.getEventos()) {
                    if ((UUID.fromString(id_para_resenar).equals(evento.getId()))) {
                        existe_el_evento = Boolean.TRUE;
                        nueva_resena.setReferencia_participante(participante);
                        nueva_resena.setReferencia_evento(evento);

                    }
                    break;
                }
            }
            break;
        }

        if (!existe_el_participante){
            throw new NoSuchElementException("ERROR: No existe el participante!");
        }

        if (!existe_el_evento){
            throw new NoSuchElementException("ERROR: No existe el evento!");
        }

        System.out.println("Ingrese el comentario que quiera dejar");

        String comentario = scanner.nextLine();
        scanner.nextLine();

        nueva_resena.setComentario(comentario);

        System.out.println("RESEÑA CREADAD CON EXITO");

        System.out.println(nueva_resena.toString());

    }

    public void listado(){
        for (Participante participante : organizador.getParticipantes()){
            System.out.println(participante.toString());
        }
    }

}