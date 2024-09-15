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
        Chef nuevoChef = new Chef();

        //Asigno un ID aleatorio al evento nuevo
        nuevoChef.setId(UUID.randomUUID());

        //Asignando nombre

        System.out.println("Ingrese nombre");
        String nombre = sc.nextLine();

        nuevoChef.setNombre(nombre);

        System.out.println("Ingrese apellido");
        String apellido = sc.nextLine();
        nuevoChef.setApellido(apellido);

        //Asignamos especialidad

        System.out.println("Ingrese especialidad");

        String especialidad = sc.nextLine();

        nuevoChef.setEspecialidad(especialidad);

        organizador.getListaChefs().add(nuevoChef);


        System.out.println();
        System.out.println("SE HA CREADO EL PERFIL DEL CHEF CORRECTAMENTE!");
        System.out.println("----------------------------------------------");
        System.out.println(nuevoChef.toString());
        System.out.println("----------------------------------------------");
        System.out.println();

        return nuevoChef;
    }

    public void asignarEventoAChef(){

        System.out.println("Ingrese el ID del chef");
        String idChef = sc.nextLine();

        System.out.println("Ingrese el ID del evento a asignar");
        String idEvento = sc.nextLine();

        boolean existeChef = Boolean.FALSE;
        boolean existeEvento = Boolean.FALSE;

        /*En este código buscamos entre todos los chefs el correcto, cuando lo encontramos
        * buscamos entre todos los eventos el correcto y finalmente lo asignamos */

        for (Chef chef: organizador.getListaChefs()){
            if (chef.getId().equals(UUID.fromString(idChef))){
                existeChef = Boolean.TRUE;

                for (EventoGastronomico evento : organizador.getListaEventos()){
                    if (evento.getId().equals(UUID.fromString(idEvento))){
                        existeEvento = Boolean.TRUE;
                        evento.setChefAsignado(chef);
                        break;
                    }
                }

                break;
            }
        }

        if (!existeChef){
            throw new NoSuchElementException("ERROR: No existe el chef!");
        }

        if (!existeEvento) {
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
