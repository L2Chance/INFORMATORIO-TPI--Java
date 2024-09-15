package ar.com.gastronomia.Servicio.Evento;
import java.io.IOException;
import java.util.Scanner;
import ar.com.gastronomia.Dominio.*;

public interface EventoService {
    EventoGastronomico crearEvento();
    void listarEventosDeUnaFecha();
    void exportarArchivo() throws IOException;
    void cerrarWriter();
    void listarEventos();
    void cerrarScanner();
}
