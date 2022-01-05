package co.com.sofka.useCases.perfil;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.colaborador.commands.ModificarNombreCompleto;
import co.com.sofka.domain.colaborador.domainEvents.ColaboradorCreado;
import co.com.sofka.domain.colaborador.domainEvents.NombreCompletoModificado;
import co.com.sofka.domain.colaborador.values.*;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.perfil.commands.ActualizarNombreCompletoReferencia;
import co.com.sofka.domain.perfil.commands.AgregarNuevaReferencia;
import co.com.sofka.domain.perfil.domainEvents.NombreCompletoReferenciaActualizado;
import co.com.sofka.domain.perfil.domainEvents.NuevaReferenciaAgregada;
import co.com.sofka.domain.perfil.values.InformacionDeContacto;
import co.com.sofka.domain.perfil.values.PerfilID;
import co.com.sofka.domain.perfil.values.ReferenciasID;
import co.com.sofka.generics.HojaDeVidaID;
import co.com.sofka.generics.NombreCompleto;
import co.com.sofka.useCases.colaborador.ModificarNombreCompletoUseCase;
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
class ActualizaNombreCompletoReferenciaUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarNombreCompletoReferenciaUseCaseTest() {

        var command = new ActualizarNombreCompletoReferencia(PerfilID.of("xxxx"),
                ReferenciasID.of("1"),
                new NombreCompleto("Maria", "Ines"));
        var useCase = new ActualizaNombreCompletoReferenciaUseCase();

        when(repository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        NombreCompletoReferenciaActualizado event = (NombreCompletoReferenciaActualizado) events.getDomainEvents().get(0);
        Assertions.assertEquals("Maria " +"Ines", event.getNombreCompleto().value());
        Mockito.verify(repository).getEventsBy("xxxx");
    }

    private List<DomainEvent> eventList() {
        return List.of(new NuevaReferenciaAgregada(
               new ReferenciasID(),
                new InformacionDeContacto("Soltero"),
                new NombreCompleto("Juan", "Cano")
        ), new NombreCompletoReferenciaActualizado(
                new ReferenciasID(),
                new NombreCompleto("Juan", "Saldarriaga")
        ));
    }

}