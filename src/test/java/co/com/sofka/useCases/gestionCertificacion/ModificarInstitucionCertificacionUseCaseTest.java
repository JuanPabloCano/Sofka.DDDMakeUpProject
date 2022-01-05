package co.com.sofka.useCases.gestionCertificacion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.experiencia.commands.ModificarExperienciaLaboralConocimientosAdquiridos;
import co.com.sofka.domain.experiencia.domainEvents.ConocimientosAdquiridosExperienciaLaboralModificada;
import co.com.sofka.domain.experiencia.domainEvents.ExperienciaLaboralCreada;
import co.com.sofka.domain.experiencia.values.ConocimientosAdquiridos;
import co.com.sofka.domain.experiencia.values.ExperienciaID;
import co.com.sofka.domain.experiencia.values.ExperienciaLaboralID;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.gestionCertificacion.commands.AgregarNuevaCertificacion;
import co.com.sofka.domain.gestionCertificacion.commands.ModificarInstitucionCertificacion;
import co.com.sofka.domain.gestionCertificacion.domainEvents.GestionCertificacionCreada;
import co.com.sofka.domain.gestionCertificacion.domainEvents.InstitucionCertificacionModificada;
import co.com.sofka.domain.gestionCertificacion.domainEvents.NuevaCertificacionAgregada;
import co.com.sofka.domain.gestionCertificacion.values.CertificacionID;
import co.com.sofka.domain.gestionCertificacion.values.GestionCertificacionID;
import co.com.sofka.domain.gestionCertificacion.values.Nombre;
import co.com.sofka.domain.gestionEducacion.domainEvents.GestionEducacionCreada;
import co.com.sofka.domain.gestionEducacion.values.GestionEducacionID;
import co.com.sofka.generics.HojaDeVidaID;
import co.com.sofka.generics.Institucion;
import co.com.sofka.generics.Periodo;
import co.com.sofka.useCases.experiencia.ModificarExperienciaLaboralConocmientosAdquiridosUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class ModificarInstitucionCertificacionUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void modificarInstitucionCertificacionUseCaseTest() {

        var command = new ModificarInstitucionCertificacion(GestionCertificacionID.of("xxxx"),
                new Institucion("Sofka"));
        var useCase = new ModificarInstitucionCertificacionUseCase();

        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        InstitucionCertificacionModificada event = (InstitucionCertificacionModificada) events.getDomainEvents().get(0);
        Assertions.assertEquals("Sofka", event.getInstitucion().value());
        Mockito.verify(repository).getEventsBy("xxxx");
    }

    private List<DomainEvent> eventList() {
        return List.of(new NuevaCertificacionAgregada(
                new CertificacionID(),
                new Nombre("Administración"),
                new Institucion("Cesde"),
                new Periodo(LocalDateTime.now(), LocalDateTime.now())
        ), new InstitucionCertificacionModificada(
                new CertificacionID(),
                new Institucion("Sena")));
    }

}