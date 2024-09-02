package ar.com.gastronomia.Servicio.Menu;

import java.io.IOException;
import java.util.Scanner;
import ar.com.gastronomia.Dominio.Organizador;
import ar.com.gastronomia.Servicio.Organizador.OrganizadorImplement;

public interface MenuService {
    void mostrar_menu(Scanner scanner) throws IOException;
}
