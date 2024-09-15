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

        Resena nueva_resena = new Resena();
        boolean existeElParticipante = Boolean.FALSE;
        boolean existeElEvento = Boolean.FALSE;

        nueva_resena.setId(UUID.randomUUID());

        System.out.println("Ingrese su ID");
        String idResenador = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Ingrese el ID del evento que quiere reseñar");
        String idEvento = scanner.nextLine();
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

        for (Participante participante : organizador.getListaParticipantes()) {
            if ((UUID.fromString(idResenador).equals(participante.getId()))) {
                existeElParticipante = Boolean.TRUE;

                for (EventoGastronomico evento : organizador.getListaEventos()) {
                    if ((UUID.fromString(idEvento).equals(evento.getId()))) {
                        existeElEvento = Boolean.TRUE;
                        nueva_resena.setReferenciaParticipante(participante);
                        nueva_resena.setReferenciaEvento(evento);

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
        scanner.nextLine();

        nueva_resena.setComentario(comentario);

        System.out.println();
        System.out.println("RESEÑA CREADAD CON EXITO!");
        System.out.println("-------------------------------");
        System.out.println(nueva_resena.toString());
        System.out.println("-------------------------------");
        System.out.println();

    }

    public void cerrarScanner(){
        scanner.close();
    }
}
