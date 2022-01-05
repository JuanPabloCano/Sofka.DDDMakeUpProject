package co.com.sofka.useCases.colaborador;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.colaborador.commands.ModificarArea;
import co.com.sofka.domain.colaborador.commands.ModificarGenero;
import co.com.sofka.domain.colaborador.domainEvents.AreaModificada;
import co.com.sofka.domain.colaborador.domainEvents.ColaboradorCreado;
import co.com.sofka.domain.colaborador.domainEvents.GeneroModificado;
import co.com.sofka.domain.colaborador.values.*;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.HojaDeVidaID;
import co.com.sofka.generics.NombreCompleto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ModificarGeneroUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void modificarGeneroUseCaseTes() {

        var colaboradorId = ColaboradorID.of("xxxx");

        var command = new ModificarGenero(colaboradorId, new Genero("Masculino"));
        var useCase = new ModificarGeneroUseCase();

        when(repository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(colaboradorId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        GeneroModificado event = (GeneroModificado) events.getDomainEvents().get(0);
        Assertions.assertEquals("Masculino", event.getGenero().value());
        Mockito.verify(repository).getEventsBy("xxxx");
    }

    private List<DomainEvent> eventList() {
        return List.of(new ColaboradorCreado(
                ColaboradorID.of("1"),
                HojaDeVidaID.of("1"),
                new FechaDeNacimiento(12, 3, 1989),
                new NombreCompleto("Juan", "cano"),
                new Cedula("12344556"),
                new Genero("Masculino"),
                new Area("Desarrollo")
        ), new GeneroModificado(
                new Genero("Femenino")
        ));
    }

}
