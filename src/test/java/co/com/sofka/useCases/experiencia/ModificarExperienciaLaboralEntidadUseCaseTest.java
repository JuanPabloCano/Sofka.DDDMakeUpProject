package co.com.sofka.useCases.experiencia;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.colaborador.commands.ModificarArea;
import co.com.sofka.domain.colaborador.domainEvents.AreaModificada;
import co.com.sofka.domain.colaborador.domainEvents.ColaboradorCreado;
import co.com.sofka.domain.colaborador.values.*;
import co.com.sofka.domain.experiencia.commands.ModificarExperienciaLaboralConocimientosAdquiridos;
import co.com.sofka.domain.experiencia.commands.ModificarExperienciaLaboralEntidad;
import co.com.sofka.domain.experiencia.domainEvents.ConocimientosAdquiridosExperienciaLaboralModificada;
import co.com.sofka.domain.experiencia.domainEvents.EntidadExperienciaLaboralModificada;
import co.com.sofka.domain.experiencia.domainEvents.ExperienciaCreada;
import co.com.sofka.domain.experiencia.domainEvents.ExperienciaLaboralCreada;
import co.com.sofka.domain.experiencia.values.ConocimientosAdquiridos;
import co.com.sofka.domain.experiencia.values.ExperienciaID;
import co.com.sofka.domain.experiencia.values.ExperienciaLaboralID;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.HojaDeVidaID;
import co.com.sofka.generics.Institucion;
import co.com.sofka.generics.NombreCompleto;
import co.com.sofka.generics.Periodo;
import co.com.sofka.useCases.colaborador.ModificarAreaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ModificarExperienciaLaboralEntidadUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void modificarExperienciaLaboralEntidadUseCaseTest() {

        var experienciaID = ExperienciaID.of("xxxx");

        var command = new ModificarExperienciaLaboralEntidad(experienciaID, new Institucion("Sofka"));
        var useCase = new ModificarExperienciaLaboralEntidadUseCase();

        when(repository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(experienciaID.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
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