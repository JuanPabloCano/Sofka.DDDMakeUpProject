package co.com.sofka.domain.colaborador.domainEvents;

import co.com.sofka.domain.colaborador.values.*;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.perfil.values.PerfilID;
import co.com.sofka.generics.HojaDeVidID;
import co.com.sofka.generics.NombreCompleto;

import java.util.Objects;

public class ColaboradorCreado extends DomainEvent {


    private final ColaboradorID colaboradorID;
    private final HojaDeVidID hojaDeVidID;
    private final FechaDeNacimiento fechaDeNacimiento;
    private final NombreCompleto nombreCompleto;
    private final Cedula cedula;
    private final Genero genero;
    private final Area area;
    private final PerfilID perfilID;

    public ColaboradorCreado(ColaboradorID colaboradorID, HojaDeVidID hojaDeVidID,
                             FechaDeNacimiento fechaDeNacimiento, NombreCompleto nombreCompleto,
                             Cedula cedula, Genero genero, Area area, PerfilID perfilID) {
        super("sofka.colaborador.colaboradorcreado");
        this.colaboradorID = Objects.requireNonNull(colaboradorID);
        this.hojaDeVidID = Objects.requireNonNull(hojaDeVidID);
        this.fechaDeNacimiento = Objects.requireNonNull(fechaDeNacimiento);
        this.nombreCompleto = Objects.requireNonNull(nombreCompleto);
        this.cedula = Objects.requireNonNull(cedula);
        this.genero = Objects.requireNonNull(genero);
        this.area = Objects.requireNonNull(area);
        this.perfilID = Objects.requireNonNull(perfilID);
    }

    public ColaboradorID getColaboradorID() {
        return colaboradorID;
    }

    public HojaDeVidID getHojaDeVidID() {
        return hojaDeVidID;
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

    public PerfilID getPerfilID() {
        return perfilID;
    }
}
