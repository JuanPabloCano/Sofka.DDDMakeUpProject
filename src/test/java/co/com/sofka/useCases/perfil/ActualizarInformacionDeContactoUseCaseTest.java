package co.com.sofka.useCases.perfil;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.perfil.commands.ActualizarInformacionDeContacto;
import co.com.sofka.domain.perfil.commands.ActualizarInformacionDeContactoReferencia;
import co.com.sofka.domain.perfil.domainEvents.InformacionDeContactoActualizada;
import co.com.sofka.domain.perfil.domainEvents.InformacionDeContactoReferenciaActualizado;
import co.com.sofka.domain.perfil.domainEvents.NuevaReferenciaAgregada;
import co.com.sofka.domain.perfil.values.InformacionDeContacto;
import co.com.sofka.domain.perfil.values.PerfilID;
import co.com.sofka.domain.perfil.values.ReferenciasID;
import co.com.sofka.generics.NombreCompleto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarInformacionDeContactoUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarInformacionDeContactoUseCaseTest() {

        var command = new ActualizarInformacionDeContacto(PerfilID.of("xxxx"),
                new InformacionDeContacto("Soltero"));
        var useCase = new ActualizarInformacionDeContactoUseCase();

        when(repository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        InformacionDeContactoActualizada event = (InformacionDeContactoActualizada) events.getDomainEvents().get(0);
        Assertions.assertEquals("Soltero", event.getInformacionDeContacto().value());
        Mockito.verify(repository).getEventsBy("xxxx");
    }

    private List<DomainEvent> eventList() {
        return List.of(new NuevaReferenciaAgregada(
                new ReferenciasID(),
                new InformacionDeContacto("Soltero"),
                new NombreCompleto("Juan", "Cano")
        ), new InformacionDeContactoActualizada(
                new PerfilID(),
                new InformacionDeContacto("Casado")
        ));
    }

}