package co.com.sofka.useCases.triggeredEventUseCases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.experiencia.commands.ModificarExperienciaLaboralEntidad;
import co.com.sofka.domain.experiencia.domainEvents.EntidadExperienciaLaboralModificada;
import co.com.sofka.domain.experiencia.domainEvents.ExperienciaLaboralCreada;
import co.com.sofka.domain.experiencia.values.ConocimientosAdquiridos;
import co.com.sofka.domain.experiencia.values.ExperienciaID;
import co.com.sofka.domain.experiencia.values.ExperienciaLaboralID;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.Institucion;
import co.com.sofka.generics.Periodo;
import co.com.sofka.useCases.experiencia.ModificarExperienciaLaboralEntidadUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EntidadExperienciaLaboralModificadaTriggeredEventUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void modificarExperienciaLaboralEntidadTriggeredEventUseCaseTest() {

        var experienciaID = ExperienciaID.of("xxxx");

        var command = new EntidadExperienciaLaboralModificada(experienciaID,
                new ExperienciaLaboralID(),
                new Institucion("Sofka"));
        var useCase = new EntidadExperienciaLaboralModificadaTriggeredEventUseCase();

        when(repository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(experienciaID.value())
                .syncExecutor(useCase, new TriggeredEvent<>(command))
                .orElseThrow();

        EntidadExperienciaLaboralModificada event = (EntidadExperienciaLaboralModificada) events.getDomainEvents().get(0);
        Assertions.assertEquals("Sofka", event.getInstitucion().value());
        Mockito.verify(repository).getEventsBy("xxxx");
    }

    private List<DomainEvent> eventList() {
        return List.of(new ExperienciaLaboralCreada(
                new ExperienciaID(),
                new ExperienciaLaboralID(),
                new Institucion("Sena"),
                new Periodo(LocalDateTime.now(), LocalDateTime.now().plusDays(5)),
                new ConocimientosAdquiridos("Sistemas")
        ), new EntidadExperienciaLaboralModificada(
                new ExperienciaID(),
                new ExperienciaLaboralID(),
                new Institucion("Sena")));
    }

}