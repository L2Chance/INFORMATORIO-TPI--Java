package ar.com.gastronomia.Servicio.Evento;
import ar.com.gastronomia.Dominio.*;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.NoSuchElementException;

public class EventoServiceImpl implements EventoService{
    private Organizador organizador;
    Scanner sc = new Scanner(System.in);

    CSVWriter csvWriter;

    public EventoServiceImpl(Organizador organizador) {
        this.organizador = organizador;
    }


    public EventoGastronomico crearEvento() {

        EventoGastronomico eventoNuevo = new EventoGastronomico();

        //asiganamos chef a cargo

        System.out.println("Ingrese el ID del chef");

        String input = sc.nextLine();

        boolean condicion = Boolean.FALSE;

        /*En esta parte del código estamos comprobando que el chef existe y
         * asignandolo como chef a cargo del evento en caso de que si*/

        for (Chef chef : organizador.getListaChefs()){
            if (UUID.fromString(input).equals(chef.getId())){
                condicion = Boolean.TRUE;

                eventoNuevo.setChefAsignado(chef);

            }
        }

        if (!condicion){
            throw new NoSuchElementException("ERROR: No existe el chef!");
        }

        //Asigno un ID aleatorio al evento nuevo
        eventoNuevo.setId(UUID.randomUUID());

        //Asignamos el nombre del evento nuevo

        System.out.println("Ingrese el nombre del evento");
        String nombre = sc.nextLine();
        eventoNuevo.setNombre(nombre);

        //Asiganmos la descripción

        System.out.println("Ingrese la descripción");
        String descripcion = sc.nextLine();
        eventoNuevo.setDescripcion(descripcion);

        //Asignamos fecha y hora

        System.out.println("Ingrese año del evento");
        int anoEvento = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese mes del evento");
        int mesEvento = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese día del evento");
        int diaEvento = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese horas del evento");
        int horaEvento = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese minutos del evento");
        int minutosEvento = sc.nextInt();
        sc.nextLine();

        LocalDateTime fechaHora = LocalDateTime.of(anoEvento, mesEvento, diaEvento, horaEvento, minutosEvento);

        eventoNuevo.setHorario(fechaHora);

        //Asignamos ubicación

        System.out.println("Ingrese la ubicación del evento");

        String ubicacion = sc.nextLine();

        eventoNuevo.setUbicacion(ubicacion);

        //Asiganmos la capacidad

        System.out.println("Ingrese la capacidad del evento");

        int capacidad = sc.nextInt();
        sc.nextLine();

        eventoNuevo.setCapacidad(capacidad);

        organizador.getListaEventos().add(eventoNuevo);

        System.out.println();
        System.out.println("SE HA CREADO EL NUEVO EVENTO CORRECTAMENTE!");
        System.out.println("----------------------------------------------");
        System.out.println(eventoNuevo.toString());
        System.out.println("----------------------------------------------");
        System.out.println();

        return eventoNuevo;
    }

    public void listarEventosDeUnaFecha() {
        System.out.println("Ingrese el año");
        int year = sc.nextInt();

        System.out.println("Ingrese el mes");
        int month = sc.nextInt();

        System.out.println("Ingrese el día");
        int day = sc.nextInt();

        for (EventoGastronomico evento : organizador.getListaEventos()){
            if (evento.getHorario().getYear() == year && evento.getHorario().getMonthValue() == month && evento.getHorario().getDayOfMonth() == day){
                System.out.println(evento.toString());
            }
        }
    }

    public void exportarArchivo() {
        System.out.println("Ingrese el año");
        int year = sc.nextInt();

        System.out.println("Ingrese el mes");
        int month = sc.nextInt();

        System.out.println("Ingrese el día");
        int day = sc.nextInt();
        sc.nextLine();

        String ruta = "src/main/java/ar/com/gastronomia/Recursos/ListaExportada.csv";

        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(ruta))) {
            String[] encabezado = {"ID", "NOMBRE", "DESCRIPCIÓN", "UBICACIÓN", "CAPACIDAD"};
            csvWriter.writeNext(encabezado);

            for (EventoGastronomico evento : organizador.getListaEventos()) {
                if (evento.getHorario().getYear() == year &&
                        evento.getHorario().getMonthValue() == month &&
                        evento.getHorario().getDayOfMonth() == day) {

                    if (evento.getCapacidad() == evento.getListaParticipantes().size()) {
                        String[] datos = {
                                evento.getId().toString(),
                                evento.getNombre(),
                                evento.getDescripcion(),
                                evento.getUbicacion(),
                                String.valueOf(evento.getCapacidad())};

                        csvWriter.writeNext(datos);
                    }
                }
            }

            System.out.println("Exportación exitosa");

        } catch (IOException e) {
            System.out.println("Algo salió mal. Motivo: " + e.getMessage() + ". Ubicación del archivo: " + ruta);
        }
    }

    public void cerrarWriter(){
        if (this.csvWriter != null){
            try{
                this.csvWriter.close();
            }catch(IOException e) {
                System.out.println("Algo salio mal. Motivo: " + e.getMessage());
            }
        }
    }

    public void listarEventos(){
        for (EventoGastronomico evento : organizador.getListaEventos()){
            System.out.println(evento.toString());
            if (!evento.getListaParticipantes().isEmpty()){
                System.out.println("participantes:" + evento.getListaParticipantes().get(evento.getListaParticipantes().size() - 1).getNombre());
                System.out.println(" " + evento.getListaParticipantes().get(evento.getListaParticipantes().size() - 1).getApellido());
            }

        }
    }

    public void cerrarScanner(){
        sc.close();
    }

}