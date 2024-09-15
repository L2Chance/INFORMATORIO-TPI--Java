package ar.com.gastronomia.Servicio.Organizador;

import ar.com.gastronomia.Dominio.Organizador;

import java.util.Scanner;

public class OrganizadorServiceImpl implements OrganizadorService{
    Scanner sc = new Scanner(System.in);

    private Organizador organizador;

    public OrganizadorServiceImpl(Organizador organizador) {
        this.organizador = organizador;
    }


}

