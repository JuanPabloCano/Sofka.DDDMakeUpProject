package co.com.sofka.domain.colaborador.domainEvents;

import co.com.sofka.domain.colaborador.values.*;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.perfil.values.PerfilID;
import co.com.sofka.generics.HojaDeVidaID;
import co.com.sofka.generics.NombreCompleto;

import java.util.Objects;

public class ColaboradorCreado extends DomainEvent {


    private final ColaboradorID colaboradorID;
    private final HojaDeVidaID hojaDeVidaID;
    private final FechaDeNacimiento fechaDeNacimiento;
    private final NombreCompleto nombreCompleto;
    private final Cedula cedula;
    private final Genero genero;
    private final Area area;

    public ColaboradorCreado(ColaboradorID colaboradorID, HojaDeVidaID hojaDeVidaID,
                             FechaDeNacimiento fechaDeNacimiento, NombreCompleto nombreCompleto,
                             Cedula cedula, Genero genero, Area area) {
        super("sofka.colaborador.colaboradorcreado");
        this.colaboradorID = Objects.requireNonNull(colaboradorID);
        this.hojaDeVidaID = Objects.requireNonNull(hojaDeVidaID);
        this.fechaDeNacimiento = Objects.requireNonNull(fechaDeNacimiento);
        this.nombreCompleto = Objects.requireNonNull(nombreCompleto);
        this.cedula = Objects.requireNonNull(cedula);
        this.genero = Objects.requireNonNull(genero);
        this.area = Objects.requireNonNull(area);
    }

    public ColaboradorID getColaboradorID() {
        return colaboradorID;
    }

    public HojaDeVidaID getHojaDeVidID() {
        return hojaDeVidaID;
    }

    public FechaDeNacimiento getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public Cedula getCedula() {
        return cedula;
    }

    public Genero getGenero() {
        return genero;
    }

    public Area getArea() {
        return area;
    }
}
