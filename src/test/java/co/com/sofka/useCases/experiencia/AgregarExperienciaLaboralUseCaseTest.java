package co.com.sofka.useCases.experiencia;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.experiencia.commands.AgregarExperienciaLaboral;
import co.com.sofka.domain.experiencia.domainEvents.ExperienciaCreada;
import co.com.sofka.domain.experiencia.domainEvents.ExperienciaLaboralCreada;
import co.com.sofka.domain.experiencia.values.ConocimientosAdquiridos;
import co.com.sofka.domain.experiencia.values.ExperienciaID;
import co.com.sofka.domain.experiencia.values.ExperienciaLaboralID;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.HojaDeVidaID;
import co.com.sofka.generics.Institucion;
import co.com.sofka.generics.Periodo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarExperienciaLaboralUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void agregarExperienciaLaboralUseCaseTest(){

        ExperienciaID experienciaID = ExperienciaID.of("xxxx");
        ExperienciaLaboralID experienciaLaboralID = ExperienciaLaboralID.of("123");
        Institucion institucion = new Institucion("Sofka");
        Periodo periodo = new Periodo(LocalDateTime.now(), LocalDateTime.now().plusDays(3));
        ConocimientosAdquiridos conocimientosAdquiridos = new ConocimientosAdquiridos("Informática");

        var command = new AgregarExperienciaLaboral(experienciaLaboralID, experienciaID, institucion, periodo,
                conocimientosAdquiridos);
        var useCase = new AgregarExperienciaLaboralUseCase();

        when(repository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        ExperienciaLaboralCreada event = (ExperienciaLaboralCreada) events.getDomainEvents().get(0);
        Assertions.assertEquals("123", event.getExperienciaLaboralID().value());
        Assertions.assertEquals("Sofka", event.getInstitucion().value());
    }

    private List<DomainEvent> eventList(){
        return List.of(new ExperienciaCreada(
                ExperienciaID.of("xxxx"),
                HojaDeVidaID.of("1")
        ));
    }
}