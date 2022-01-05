package co.com.sofka.useCases.gestionEducacion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.gestionCertificacion.commands.AgregarNuevaCertificacion;
import co.com.sofka.domain.gestionCertificacion.domainEvents.GestionCertificacionCreada;
import co.com.sofka.domain.gestionCertificacion.domainEvents.NuevaCertificacionAgregada;
import co.com.sofka.domain.gestionCertificacion.values.CertificacionID;
import co.com.sofka.domain.gestionCertificacion.values.GestionCertificacionID;
import co.com.sofka.domain.gestionCertificacion.values.Nombre;
import co.com.sofka.domain.gestionEducacion.commands.AgregarNuevaEducacion;
import co.com.sofka.domain.gestionEducacion.domainEvents.EducacionAgregada;
import co.com.sofka.domain.gestionEducacion.domainEvents.GestionEducacionCreada;
import co.com.sofka.domain.gestionEducacion.values.EducacionesID;
import co.com.sofka.domain.gestionEducacion.values.Estudio;
import co.com.sofka.domain.gestionEducacion.values.GestionEducacionID;
import co.com.sofka.domain.gestionEducacion.values.Tipo;
import co.com.sofka.generics.HojaDeVidaID;
import co.com.sofka.generics.Institucion;
import co.com.sofka.generics.Periodo;
import co.com.sofka.useCases.gestionCertificacion.AgregarNuevaCertificacionUseCase;
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
class AgregarNuevaEducacionUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void agregarNuevaEducacionUseCaseTest() {

        var command = new AgregarNuevaEducacion(EducacionesID.of("1"),
                GestionEducacionID.of("xxxx"),
                new Tipo("Curso"),
                new Estudio("Anatomía"),
                new Institucion("Ces"),
                new Periodo(LocalDateTime.now(), LocalDateTime.now()));

        var useCase = new AgregarNuevaEducacionUseCase();

        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        EducacionAgregada event = (EducacionAgregada) events.getDomainEvents().get(0);
        Assertions.assertEquals("Curso", event.getTipo().value());
        Assertions.assertEquals("Anatomía", event.getEstudio().value());
        Assertions.assertEquals("Ces", event.getInstitucion().value());
        Mockito.verify(repository).getEventsBy("xxxx");
    }

    private List<DomainEvent> eventList() {
        return List.of(new GestionEducacionCreada(
                new GestionEducacionID(),
                new HojaDeVidaID()
        ), new EducacionAgregada(
                new EducacionesID(),
                new Tipo("Diplomado"),
                new Estudio("Biología"),
                new Institucion("Eafit"),
                new Periodo(LocalDateTime.now(), LocalDateTime.now().plusDays(6))
        ));
    }

}