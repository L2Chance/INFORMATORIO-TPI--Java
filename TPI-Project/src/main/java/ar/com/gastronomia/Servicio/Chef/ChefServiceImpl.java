package ar.com.gastronomia.Servicio.Chef;

import ar.com.gastronomia.Dominio.Organizador;
import ar.com.gastronomia.Dominio.Chef;
import ar.com.gastronomia.Dominio.EventoGastronomico;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.UUID;

public class ChefServiceImpl implements ChefService {
    private Organizador organizador;
    Scanner sc = new Scanner(System.in);

    public ChefServiceImpl(Organizador organizador) {
        this.organizador = organizador;
    }

    public Chef agregarChef() {
        Chef nuevo_chef = new Chef();

        //Asigno un ID aleatorio al evento nuevo
        nuevo_chef.setId(UUID.randomUUID());

        //Asignando nombre

        System.out.println("Ingrese nombre");
        String nombre = sc.nextLine();

        nuevo_chef.setNombre(nombre);

        System.out.println("Ingrese apellido");
        String apellido = sc.nextLine();
        nuevo_chef.setApellido(apellido);

        //Asignamos especialidad

        System.out.println("Ingrese especialidad");

        String especialidad = sc.nextLine();

        nuevo_chef.setEspecialidad(especialidad);

        organizador.getListaChefs().add(nuevo_chef);


        System.out.println();
        System.out.println("SE HA CREADO EL PERFIL EL EVENTO CORRECTAMENTE!");
        System.out.println("----------------------------------------------");
        System.out.println(nuevo_chef.toString());
        System.out.println("----------------------------------------------");
        System.out.println();

        return nuevo_chef;
    }

    public void asignarEventoAChef(){

        System.out.println("Ingrese el ID del chef");
        String id_chef = sc.nextLine();

        System.out.println("Ingrese el ID del evento a asignar");
        String id_evento = sc.nextLine();

        boolean existe_el_chef = Boolean.FALSE;
        boolean existe_el_evento = Boolean.FALSE;

        /*En este código buscamos entre todos los chefs el correcto, cuando lo encontramos
        * buscamos entre todos los eventos el correcto y finalmente lo asignamos */

        for (Chef chef: organizador.getListaChefs()){
            if (chef.getId().equals(UUID.fromString(id_chef))){
                existe_el_chef = Boolean.TRUE;

                for (EventoGastronomico evento : organizador.getListaEventos()){
                    if (evento.getId().equals(UUID.fromString(id_evento))){
                        existe_el_evento = Boolean.TRUE;
                        evento.setChefAsignado(chef);
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

    public void listarChefs() {
        for (Chef chef : organizador.getListaChefs()){
            System.out.println(chef.toString());
        }
    }

    public void cerrarScanner(){
        sc.close();
    }

}
