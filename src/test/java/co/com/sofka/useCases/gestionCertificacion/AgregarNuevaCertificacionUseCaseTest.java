package co.com.sofka.useCases.gestionCertificacion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.colaborador.commands.AgregarPerfil;
import co.com.sofka.domain.colaborador.domainEvents.ColaboradorCreado;
import co.com.sofka.domain.colaborador.domainEvents.PerfilAgregado;
import co.com.sofka.domain.colaborador.values.*;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.gestionCertificacion.commands.AgregarNuevaCertificacion;
import co.com.sofka.domain.gestionCertificacion.domainEvents.GestionCertificacionCreada;
import co.com.sofka.domain.gestionCertificacion.domainEvents.NuevaCertificacionAgregada;
import co.com.sofka.domain.gestionCertificacion.values.CertificacionID;
import co.com.sofka.domain.gestionCertificacion.values.GestionCertificacionID;
import co.com.sofka.domain.gestionCertificacion.values.Nombre;
import co.com.sofka.domain.perfil.values.PerfilID;
import co.com.sofka.generics.HojaDeVidaID;
import co.com.sofka.generics.Institucion;
import co.com.sofka.generics.NombreCompleto;
import co.com.sofka.generics.Periodo;
import co.com.sofka.useCases.colaborador.AgregarPerfilUseCase;
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
class AgregarNuevaCertificacionUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void agregarNuevaCertificacionUseCaseTest() {

        var command = new AgregarNuevaCertificacion(CertificacionID.of("1"),
                GestionCertificacionID.of("xxxx"),
                new Nombre("Ingeniería"),
                new Institucion("Sofka"),
                new Periodo(LocalDateTime.now(), LocalDateTime.now().plusDays(5)));

        var useCase = new AgregarNuevaCertificacionUseCase();

        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        NuevaCertificacionAgregada event = (NuevaCertificacionAgregada) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("Ingeniería", event.getNombre().value());
        Assertions.assertEquals("Sofka", event.getInstitucion().value());
        Mockito.verify(repository).getEventsBy("xxxx");
    }

    private List<DomainEvent> eventList() {
        return List.of(new GestionCertificacionCreada(
                new GestionCertificacionID(),
                new HojaDeVidaID()
        ), new NuevaCertificacionAgregada(
                CertificacionID.of("1"),
                new Nombre("Administración"),
                new Institucion("Sena"),
                new Periodo(LocalDateTime.now(), LocalDateTime.now())));
    }
}