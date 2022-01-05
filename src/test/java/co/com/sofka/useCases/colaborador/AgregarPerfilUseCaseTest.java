package co.com.sofka.useCases.colaborador;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.colaborador.commands.AgregarPerfil;
import co.com.sofka.domain.colaborador.domainEvents.ColaboradorCreado;
import co.com.sofka.domain.colaborador.domainEvents.PerfilAgregado;
import co.com.sofka.domain.colaborador.values.*;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.perfil.values.PerfilID;
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

@ExtendWith(MockitoExtension.class)
class AgregarPerfilUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarPerfilUseCase(){

        ColaboradorID colaboradorID = ColaboradorID.of("xxxx");
        PerfilID perfilID = PerfilID.of("1");

        var command = new AgregarPerfil(colaboradorID, perfilID);
        var useCase = new AgregarPerfilUseCase();

        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        PerfilAgregado event = (PerfilAgregado) events.getDomainEvents().get(0);
        Assertions.assertEquals("1", event.getPerfilID().value());
        Mockito.verify(repository).getEventsBy("xxxx");
    }

    private List<DomainEvent> eventList(){
        return List.of(new ColaboradorCreado(
                new ColaboradorID(),
                new HojaDeVidaID(),
                new FechaDeNacimiento(2,4,1996),
                new NombreCompleto("Juan", "cano"),
                new Cedula("1234"),
                new Genero("Masculino"),
                new Area("Sistemas")
        ), new PerfilAgregado(
                new PerfilID()
        ));
    }
}