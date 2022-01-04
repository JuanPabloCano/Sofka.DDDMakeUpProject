package co.com.sofka.domain.gestionEducacion;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.gestionEducacion.domainEvents.*;
import co.com.sofka.domain.gestionEducacion.values.EducacionesID;
import co.com.sofka.domain.gestionEducacion.values.Estudio;
import co.com.sofka.domain.gestionEducacion.values.GestionEducacionID;
import co.com.sofka.domain.gestionEducacion.values.Tipo;
import co.com.sofka.generics.HojaDeVidaID;
import co.com.sofka.generics.Institucion;
import co.com.sofka.generics.Periodo;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class GestionEducacion extends AggregateEvent<GestionEducacionID> {

    protected HojaDeVidaID hojaDeVidaID;
    protected Set<Educaciones> educaciones;


    private GestionEducacion(GestionEducacionID gestionEducacionID) {
        super(gestionEducacionID);
        subscribe(new GestionEducacionChange(this));
    }

    public GestionEducacion(GestionEducacionID gestionEducacionID, HojaDeVidaID hojaDeVidaID) {
        super(gestionEducacionID);
        appendChange(new GestionEducacionCreada(gestionEducacionID, hojaDeVidaID)).apply();
    }

    public static GestionEducacion from(GestionEducacionID gestionEducacionID, List<DomainEvent> events) {
        var gestionEducacion = new GestionEducacion(gestionEducacionID);
        events.forEach(gestionEducacion::applyEvent);
        return gestionEducacion;
    }

    public void agregarNuevaEducacion(Tipo tipo, Estudio estudio, Institucion institucion, Periodo periodo){
        var id = new EducacionesID();
        Objects.requireNonNull(tipo);
        Objects.requireNonNull(estudio);
        Objects.requireNonNull(institucion);
        Objects.requireNonNull(periodo);
        appendChange(new EducacionAgregada(id, tipo, estudio, institucion, periodo)).apply();
    }

    public void eliminarEducacion(EducacionesID educacionesID){
        Objects.requireNonNull(educacionesID);
        appendChange(new EducacionEliminada(educacionesID)).apply();
    }

    public void modificarTipoEducacion(Tipo tipo){
        var id = new EducacionesID();
        Objects.requireNonNull(tipo);
        appendChange(new TipoEducacionModificado(id, tipo)).apply();
    }

    public void modificarEstudioEducacion(Estudio estudio){
        var id = new EducacionesID();
        Objects.requireNonNull(estudio);
        appendChange(new EstudioEducacionModificado(id, estudio)).apply();
    }

    public void actualizarPeriodoEducacion(Periodo periodo){
        var id = new EducacionesID();
        Objects.requireNonNull(periodo);
        appendChange(new PeriodoEducacionModificado(id, periodo)).apply();
    }

    public void modificarInstitucionEducacion(Institucion institucion){
        var id = new EducacionesID();
        Objects.requireNonNull(institucion);
        appendChange(new InstitucionEducacionModificada(id, institucion)).apply();
    }

    public HojaDeVidaID getHojaDeVidaID() {
        return hojaDeVidaID;
    }

    public Set<Educaciones> getEducaciones() {
        return educaciones;
    }
}
