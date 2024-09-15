package ar.com.gastronomia.Servicio.Resena;
import ar.com.gastronomia.Dominio.Enumeration.CalificacionEnum;
import ar.com.gastronomia.Dominio.*;
import ar.com.gastronomia.Dominio.Participante;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.UUID;

public class ResenaServiceImpl implements ResenaService {
    Organizador organizador;
    Scanner scanner = new Scanner(System.in);

    public ResenaServiceImpl(Organizador organizador) {
        this.organizador = organizador;
    }

    public void hacerResena() {

        Resena nuevaResena = new Resena();
        boolean existeElParticipante = Boolean.FALSE;
        boolean existeElEvento = Boolean.FALSE;

        nuevaResena.setId(UUID.randomUUID());

        System.out.println("Ingrese su ID");
        String idResenador = scanner.nextLine();

        System.out.println("Ingrese el ID del evento que quiere reseñar");
        String idEvento = scanner.nextLine();

        System.out.println("Ingrese la calificación");
        System.out.println("1. UNO - 2. DOS - 3. TRES - 4. CUATRO - 5. CINCO");

        int calificacion = scanner.nextInt();
        scanner.nextLine();

        switch (calificacion){
            case 1:
                nuevaResena.setCalificacion(CalificacionEnum.UNO);
                break;
            case 2:
                nuevaResena.setCalificacion(CalificacionEnum.DOS);
                break;
            case 3:
                nuevaResena.setCalificacion(CalificacionEnum.TRES);
                break;
            case 4:
                nuevaResena.setCalificacion(CalificacionEnum.CUATRO);
                break;
            case 5:
                nuevaResena.setCalificacion(CalificacionEnum.CINCO);
                break;
            default:
                nuevaResena.setCalificacion((null));
        }

        for (Participante participante : organizador.getListaParticipantes()) {
            if ((UUID.fromString(idResenador).equals(participante.getId()))) {
                existeElParticipante = Boolean.TRUE;

                for (EventoGastronomico evento : organizador.getListaEventos()) {
                    if ((UUID.fromString(idEvento).equals(evento.getId()))) {
                        existeElEvento = Boolean.TRUE;
                        nuevaResena.setReferenciaParticipante(participante);
                        nuevaResena.setReferenciaEvento(evento);

                    }
                    break;
                }
            }
            break;
        }

        if (!existeElParticipante){
            throw new NoSuchElementException("ERROR: No existe el participante!");
        }

        if (!existeElEvento){
            throw new NoSuchElementException("ERROR: No existe el evento!");
        }

        System.out.println("Ingrese el comentario que quiera dejar");

        String comentario = scanner.nextLine();

        nuevaResena.setComentario(comentario);

        System.out.println();
        System.out.println("RESEÑA CREADAD CON EXITO!");
        System.out.println("-------------------------------");
        System.out.println(nuevaResena.toString());
        System.out.println("-------------------------------");
        System.out.println();

    }

    public void cerrarScanner(){
        scanner.close();
    }
}
