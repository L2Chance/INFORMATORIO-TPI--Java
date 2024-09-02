package ar.com.gastronomia.Servicio.Organizador;
import ar.com.gastronomia.Dominio.*;

import java.util.Scanner;

public interface OrganizadorService {
    public EventoGastronomico crearevento();
    public Chef agregarchef(Scanner scanner);
    void asignar_evento_a_chef();
}
