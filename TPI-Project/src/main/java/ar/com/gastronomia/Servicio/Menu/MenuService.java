package ar.com.gastronomia.Servicio.Menu;

import java.io.IOException;
import java.util.Scanner;

public interface MenuService {
    void mostrarMenu() throws IOException;
    void cerrarScanner();
}
