package ar.com.gastronomia.Servicio.Evento;
import ar.com.gastronomia.Dominio.*;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EventoImplement implements EventoService{
    private Organizador organizador;

    CSVWriter csvWriter;

    public EventoImplement(Organizador organizador) {
        this.organizador = organizador;
    }

    @Override
    public void listar_eventos(Scanner scanner) {
        System.out.println("Ingrese el año");
        int year = scanner.nextInt();

        System.out.println("Ingrese el mes");
        int month = scanner.nextInt();

        System.out.println("Ingrese el día");
        int day = scanner.nextInt();

        for (EventoGastronomico evento : organizador.getEventos()){
            if (evento.getHorario().getYear() == year && evento.getHorario().getMonthValue() == month && evento.getHorario().getDayOfMonth() == day){
                System.out.println(evento.toString());
            }
        }
    }

    public void exportar_archivo(Scanner scanner) {
        System.out.println("Ingrese el año");
        int year = scanner.nextInt();

        System.out.println("Ingrese el mes");
        int month = scanner.nextInt();

        System.out.println("Ingrese el día");
        int day = scanner.nextInt();
        scanner.nextLine();

        String ruta = "src/main/java/ar/com/gastronomia/Recursos/ListaExportada.csv";

        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(ruta))) {
            String[] encabezado = {"ID", "NOMBRE", "DESCRIPCIÓN", "UBICACIÓN", "CAPACIDAD"};
            csvWriter.writeNext(encabezado);

            for (EventoGastronomico evento : organizador.getEventos()) {
                if (evento.getHorario().getYear() == year &&
                        evento.getHorario().getMonthValue() == month &&
                        evento.getHorario().getDayOfMonth() == day) {

                    if (evento.getCapacidad() == evento.getLista_de_participantes().size()) {
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

    public void listado(){
        for (EventoGastronomico evento : organizador.getEventos()){
            System.out.println(evento.toString());
            if (!evento.getLista_de_participantes().isEmpty()){
                System.out.println("participantes:" + evento.getLista_de_participantes().get(evento.getLista_de_participantes().size() - 1).getNombreyapellido());
            }

        }
    }

}