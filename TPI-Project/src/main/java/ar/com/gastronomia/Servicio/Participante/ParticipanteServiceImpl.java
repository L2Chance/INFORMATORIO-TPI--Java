package ar.com.gastronomia.Servicio.Participante;
import ar.com.gastronomia.Dominio.*;
import ar.com.gastronomia.Dominio.Participante;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.UUID;

public class ParticipanteServiceImpl implements ParticipanteService {
    private final Organizador organizador;
    Scanner scanner = new Scanner(System.in);

    public ParticipanteServiceImpl(Organizador organizador) {
        this.organizador = organizador;
    }

    public void participanteNuevo() {

        /*Se inscribe al participante a la lista de participantes de la organización*/

        Participante participante = new Participante();

        participante.setId(UUID.randomUUID());

        System.out.println("Ingrese el nombre");

        participante.setNombre(scanner.nextLine());

        System.out.println("Ingrese el apellido");

        participante.setApellido(scanner.nextLine());

        int option;

        do{
            System.out.println("ELIJA INTERESES");
            System.out.println("------------------");
            System.out.println("1. Cocina internacional");
            System.out.println("2. Bebidas");
            System.out.println("3. Pastelería");
            System.out.println("4. Repostería");
            System.out.println("5. Carnes");
            System.out.println("6. Veganismo");
            System.out.println("7. Otro...");
            System.out.println("8. No quiero elegir más");

            option = scanner.nextInt();
            scanner.nextLine();

            switch(option){
                case 1: participante.getIntereses().add("Cocina Internacional");
                break;
                case 2: participante.getIntereses().add("Bebidas");
                break;
                case 3: participante.getIntereses().add("Pastelería");
                break;
                case 4: participante.getIntereses().add("Respotería");
                break;
                case 5: participante.getIntereses().add("Carnes");
                break;
                case 6: participante.getIntereses().add("Veganismo");
                break;
                case 7:
                    System.out.println("Ingrese su interes especifico:");
                    participante.getIntereses().add(scanner.nextLine());
                break;
                case 8: System.out.println("Intereses subidos con exito!");
                break;
                default: System.out.println("Por favor, ingrese una opción valida");
            }

        }while(option != 8);

        if (participante.getIntereses().isEmpty()){
            participante.getIntereses().add("Ningún interes en particular");
        }


        organizador.getListaParticipantes().add(participante);

        System.out.println();
        System.out.println("SE HA CREADO EL PERFIL DEL PARTICIPANTE!");
        System.out.println("----------------------------------------------");
        System.out.println(participante.toString());
        System.out.println("----------------------------------------------");
        System.out.println();
    }

    public void inscribirseEvento() {

        System.out.println("Ingrese el ID del participante");

        String idIngresado = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Ingrese el ID del evento");

        String idEvento = scanner.nextLine();
        scanner.nextLine();

        boolean existeElParticipante = Boolean.FALSE;
        boolean existeElEvento = Boolean.FALSE;

        /*En este código buscamos entre todos los participantes el correcto. Cuando lo encontramos,
         buscamos entre todos los eventos el correcto y finalmente lo asignamos */

        for (Participante participante : organizador.getListaParticipantes()) {
            if (participante.getId().equals(UUID.fromString(idIngresado))) {
                existeElParticipante = Boolean.TRUE;

                for (EventoGastronomico evento : organizador.getListaEventos()) {
                    if (evento.getId().equals(UUID.fromString(idEvento))) {
                        existeElEvento = Boolean.TRUE;
                        if (evento.getCapacidad() > evento.getListaParticipantes().size()) {
                            evento.getListaParticipantes().add(participante);
                            participante.getEventosParticipados().add(evento);
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

        if (!existeElParticipante){
            throw new NoSuchElementException("ERROR: No existe el participante!");
        }

        if (!existeElEvento){
            throw new NoSuchElementException("ERROR: No existe el evento!");
        }

        System.out.println();

        System.out.println("INSCRIPCIÓN REALIZADA CORRECTAMENTE");
        System.out.println("-------------------------------------");

    }

    public void listadoParticipante(){
        for (Participante participante : organizador.getListaParticipantes()){
            System.out.println(participante.toString());
        }
    }

    public void cerrarScanner(){
        scanner.close();
    }

}