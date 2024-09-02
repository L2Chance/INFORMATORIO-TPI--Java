package ar.com.gastronomia.Servicio.Evento;
import java.io.IOException;
import java.util.Scanner;

public interface EventoService {
    void listar_eventos(Scanner scanner);
    void exportar_archivo(Scanner scanner) throws IOException;
    void cerrarWriter();
    void listado();
}
