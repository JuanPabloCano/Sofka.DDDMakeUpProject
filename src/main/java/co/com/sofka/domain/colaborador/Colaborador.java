package co.com.sofka.domain.colaborador;

import co.com.sofka.domain.colaborador.domainEvents.*;
import co.com.sofka.domain.colaborador.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.perfil.values.PerfilID;
import co.com.sofka.generics.NombreCompleto;
import co.com.sofka.generics.HojaDeVidID;

import java.util.List;
import java.util.Objects;

public class Colaborador extends AggregateEvent<ColaboradorID> {

    protected ColaboradorID colaboradorID;
    protected HojaDeVidID hojaDeVidID;
    protected FechaDeNacimiento fechaDeNacimiento;
    protected NombreCompleto nombreCompleto;
    protected Cedula cedula;
    protected Genero genero;
    protected Area area;
    protected PerfilID perfilID;

    private Colaborador(ColaboradorID colaboradorID) {
        super(colaboradorID);
        subscribe(new ColaboradorChange(this));
    }

    public Colaborador(ColaboradorID colaboradorID, HojaDeVidID hojaDeVidID, FechaDeNacimiento fechaDeNacimiento,
                       NombreCompleto nombreCompleto, Cedula cedula, Genero genero, Area area, PerfilID perfilID) {
        super(colaboradorID);
        appendChange(new ColaboradorCreado(colaboradorID, hojaDeVidID, fechaDeNacimiento, nombreCompleto, cedula,
                genero, area, perfilID)).apply();
    }

    public static Colaborador from(ColaboradorID colaboradorID, List<DomainEvent> events){
        var colaborador = new Colaborador(colaboradorID);
        events.forEach(colaborador::applyEvent);
        return colaborador;
    }

    public void agregarPerfil(PerfilID perfilID){
        Objects.requireNonNull(perfilID);
        appendChange(new PerfilAgregado(perfilID)).apply();
    }

    public void modificarFechaDeNacimiento(ColaboradorID colaboradorID, FechaDeNacimiento fechaDeNacimiento){
        Objects.requireNonNull(fechaDeNacimiento);
        appendChange(new FechaDeNacimientoModificada(colaboradorID, fechaDeNacimiento)).apply();
    }

    public void modificarNombreCompleto(ColaboradorID colaboradorID, NombreCompleto nombreCompleto){
        Objects.requireNonNull(nombreCompleto);
        appendChange(new NombreCompletoModificado(colaboradorID, nombreCompleto)).apply();
    }

    public void modificarCedula(ColaboradorID colaboradorID, Cedula cedula){
        Objects.requireNonNull(cedula);
        appendChange(new CedulaModificada(colaboradorID, cedula)).apply();
    }

    public void modificarGenero(ColaboradorID colaboradorID, Genero genero){
        Objects.requireNonNull(genero);
        appendChange(new GeneroModificado(colaboradorID, genero)).apply();
    }

    public void modificarArea(ColaboradorID colaboradorID, Area area){
        Objects.requireNonNull(area);
        appendChange(new AreaModificada(colaboradorID, area)).apply();
    }

    public HojaDeVidID HojaDeVidID() {
        return hojaDeVidID;
    }

    public FechaDeNacimiento FechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public NombreCompleto NombreCompleto() {
        return nombreCompleto;
    }

    public Cedula Cedula() {
        return cedula;
    }

    public Genero Genero() {
        return genero;
    }

    public Area Area() {
        return area;
    }

    public PerfilID perfilID() {
        return perfilID;
    }
}
