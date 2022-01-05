package co.com.sofka.useCases.gestionCertificacion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.gestionCertificacion.commands.ModificarInstitucionCertificacion;
import co.com.sofka.domain.gestionCertificacion.commands.ModificarNombreCertificacion;
import co.com.sofka.domain.gestionCertificacion.domainEvents.InstitucionCertificacionModificada;
import co.com.sofka.domain.gestionCertificacion.domainEvents.NombreCertificacionModificada;
import co.com.sofka.domain.gestionCertificacion.domainEvents.NuevaCertificacionAgregada;
import co.com.sofka.domain.gestionCertificacion.values.CertificacionID;
import co.com.sofka.domain.gestionCertificacion.values.GestionCertificacionID;
import co.com.sofka.domain.gestionCertificacion.values.Nombre;
import co.com.sofka.generics.Institucion;
import co.com.sofka.generics.Periodo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ModificarNombreCertificacionUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void modificarNombreCertificacionUseCaseTest() {

        var command = new ModificarNombreCertificacion(GestionCertificacionID.of("xxxx"),
                new Nombre("Diplomado"));
        var useCase = new ModificarNombreCertificacionUseCase();

        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        NombreCertificacionModificada event = (NombreCertificacionModificada) events.getDomainEvents().get(0);
        Assertions.assertEquals("Diplomado", event.getNombre().value());
        Mockito.verify(repository).getEventsBy("xxxx");
    }

    private List<DomainEvent> eventList() {
        return List.of(new NuevaCertificacionAgregada(
                new CertificacionID(),
                new Nombre("Administración"),
                new Institucion("Cesde"),
                new Periodo(LocalDateTime.now(), LocalDateTime.now())
        ), new NombreCertificacionModificada(
                new CertificacionID(),
                new Nombre("Curso")));
    }

}