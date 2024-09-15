package ar.com.gastronomia.Servicio.Chef;
import ar.com.gastronomia.Dominio.Chef;


public interface ChefService {
    void listarChefs();
    void asignarEventoAChef();
    Chef agregarChef();
    void cerrarScanner();
}
