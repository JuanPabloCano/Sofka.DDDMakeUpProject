package co.com.sofka.domain.colaborador;

import co.com.sofka.domain.colaborador.domainEvents.*;
import co.com.sofka.domain.colaborador.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.perfil.values.PerfilID;
import co.com.sofka.generics.NombreCompleto;
import co.com.sofka.generics.HojaDeVidaID;

import java.util.List;
import java.util.Objects;

public class Colaborador extends AggregateEvent<ColaboradorID> {

    protected ColaboradorID colaboradorID;
    protected HojaDeVidaID hojaDeVidaID;
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

    public Colaborador(ColaboradorID colaboradorID, HojaDeVidaID hojaDeVidaID, FechaDeNacimiento fechaDeNacimiento,
                       NombreCompleto nombreCompleto, Cedula cedula, Genero genero, Area area) {
        super(colaboradorID);
        appendChange(new ColaboradorCreado(colaboradorID, hojaDeVidaID, fechaDeNacimiento, nombreCompleto, cedula,
                genero, area)).apply();
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

    public void modificarFechaDeNacimiento(FechaDeNacimiento fechaDeNacimiento){
        Objects.requireNonNull(fechaDeNacimiento);
        appendChange(new FechaDeNacimientoModificada(fechaDeNacimiento)).apply();
    }

    public void modificarNombreCompleto(NombreCompleto nombreCompleto){
        Objects.requireNonNull(nombreCompleto);
        appendChange(new NombreCompletoModificado(nombreCompleto)).apply();
    }

    public void modificarCedula(Cedula cedula){
        Objects.requireNonNull(cedula);
        appendChange(new CedulaModificada(cedula)).apply();
    }

    public void modificarGenero(Genero genero){
        Objects.requireNonNull(genero);
        appendChange(new GeneroModificado(genero)).apply();
    }

    public void modificarArea(Area area){
        Objects.requireNonNull(area);
        appendChange(new AreaModificada(area)).apply();
    }

    public HojaDeVidaID HojaDeVidID() {
        return hojaDeVidaID;
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
