package ar.com.gastronomia.Servicio.Participante;
import java.util.Scanner;

public interface ParticipanteService {
    void inscribirse_a_evento(Scanner scanner);
    void hacer_resena(Scanner scanner);
    void participante_nuevo(Scanner scanner);
    void listado();
}
