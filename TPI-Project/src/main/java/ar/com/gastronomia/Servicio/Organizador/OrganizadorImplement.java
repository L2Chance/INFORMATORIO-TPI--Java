package ar.com.gastronomia.Servicio.Organizador;

import ar.com.gastronomia.Dominio.*;
import ar.com.gastronomia.Dominio.Organizador;
import ar.com.gastronomia.Dominio.Chef;
import ar.com.gastronomia.Dominio.EventoGastronomico;
import com.sun.source.tree.TryTree;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.UUID;

public class OrganizadorImplement implements OrganizadorService{
    Scanner sc = new Scanner(System.in);

    private Organizador organizador;

    public OrganizadorImplement(Organizador organizador) {
        this.organizador = organizador;
    }

    public EventoGastronomico crearevento() {

        EventoGastronomico evento_nuevo = new EventoGastronomico();

        //asiganamos chef a cargo

        System.out.println("Ingrese el ID del chef");

        String input = sc.nextLine();

        boolean condicion = Boolean.FALSE;

        /*En esta parte del código estamos comprobando que el chef existe y
         * asignandolo como chef a cargo del evento en caso de que si*/

        for (Chef chef : organizador.getLista_de_chefs()){
            if (UUID.fromString(input).equals(chef.getId())){
                condicion = Boolean.TRUE;

                evento_nuevo.setChef_a_cargo(chef);

            }
        }

        if (!condicion){
            throw new NoSuchElementException("ERROR: No existe el chef!");
        }

        //Asigno un ID aleatorio al evento nuevo
        evento_nuevo.setId(UUID.randomUUID());

        //Asignamos el nombre del evento nuevo

        System.out.println("Ingrese el nombre del evento");

        String nombre = sc.nextLine();
        sc.nextLine();

        evento_nuevo.setNombre(nombre);

        //Asiganmos la descripción

        System.out.println("Ingrese la descripción");

        String descripcion = sc.nextLine();
        sc.nextLine();

        evento_nuevo.setDescripcion(descripcion);

        //Asignamos fecha y hora

        System.out.println("Ingrese año del evento");
        int ano_de_evento = sc.nextInt();

        System.out.println("Ingrese mes del evento");
        int mes_de_evento = sc.nextInt();

        System.out.println("Ingrese día del evento");
        int dia_de_vento = sc.nextInt();

        System.out.println("Ingrese horas del evento");
        int hora_de_evento = sc.nextInt();

        System.out.println("Ingrese minutos del evento");
        int minutos_de_evento = sc.nextInt();

        LocalDateTime fechayhora = LocalDateTime.of(ano_de_evento, mes_de_evento, dia_de_vento, hora_de_evento, minutos_de_evento);

        evento_nuevo.setHorario(fechayhora);

        //Asignamos ubicación

        System.out.println("Ingrese la ubicación del evento");

        String ubicacion = sc.nextLine();
        sc.nextLine();

        evento_nuevo.setUbicacion(ubicacion);

        //Asiganmos la capacidad

        System.out.println("Ingrese la capacidad del evento");

        int capacidad = sc.nextInt();
        sc.nextLine();

        evento_nuevo.setCapacidad(capacidad);

        organizador.getEventos().add(evento_nuevo);

        System.out.println("SE HA CREADO EL PERFIL DEL CHEF CORRECTAMENTE!");
        System.out.println("----------------------------------------------");
        System.out.println(evento_nuevo.toString());
        System.out.println("----------------------------------------------");

        return evento_nuevo;
    }

    public Chef agregarchef(Scanner scanner) {
        Chef nuevo_chef = new Chef();

        //Asigno un ID aleatorio al evento nuevo
        nuevo_chef.setId(UUID.randomUUID());

        //Asignando nombre


        System.out.println("Ingrese nombre");
        String nombre = sc.nextLine();

        nuevo_chef.setNombre(nombre);

        //Asignamos especialidad

        System.out.println("Ingrese especialidad");

        String especialidad = sc.nextLine();

        nuevo_chef.setEspecialidad(especialidad);

        organizador.getLista_de_chefs().add(nuevo_chef);

        System.out.println("SE HA CREADO EL PERFIL EL EVENTO CORRECTAMENTE!");
        System.out.println("----------------------------------------------");
        System.out.println(nuevo_chef.toString());
        System.out.println("----------------------------------------------");

        return nuevo_chef;
    }

    public void asignar_evento_a_chef(){

        System.out.println("Ingrese el ID del chef");
        String id_chef = sc.nextLine();

        System.out.println("Ingrese el ID del evento a asignar");
        String id_evento = sc.nextLine();

        boolean existe_el_chef = Boolean.FALSE;
        boolean existe_el_evento = Boolean.FALSE;

        /*En este código buscamos entre todos los chefs el correcto, cuando lo encontramos
        * buscamos entre todos los eventos el correcto y finalmente lo asignamos */

        for (Chef chef: organizador.getLista_de_chefs()){
            if (chef.getId().equals(UUID.fromString(id_chef))){
                existe_el_chef = Boolean.TRUE;

                for (EventoGastronomico evento : organizador.getEventos()){
                    if (evento.getId().equals(UUID.fromString(id_evento))){
                        existe_el_evento = Boolean.TRUE;
                        evento.setChef_a_cargo(chef);
                        break;
                    }
                }

                break;
            }
        }

        if (!existe_el_chef){
            throw new NoSuchElementException("ERROR: No existe el chef!");
        }

        if (!existe_el_evento) {
            throw new NoSuchElementException("ERROR: No existe el evento!");
        }
        else {
            System.out.println("Chef correctamente asignado");
        }
    }

}

