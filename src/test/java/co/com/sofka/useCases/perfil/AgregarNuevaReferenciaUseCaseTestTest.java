package co.com.sofka.useCases.perfil;

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
import co.com.sofka.domain.perfil.commands.AgregarNuevaReferencia;
import co.com.sofka.domain.perfil.domainEvents.NuevaReferenciaAgregada;
import co.com.sofka.domain.perfil.values.InformacionDeContacto;
import co.com.sofka.domain.perfil.values.PerfilID;
import co.com.sofka.domain.perfil.values.ReferenciasID;
import co.com.sofka.generics.HojaDeVidaID;
import co.com.sofka.generics.Institucion;
import co.com.sofka.generics.NombreCompleto;
import co.com.sofka.generics.Periodo;
import co.com.sofka.useCases.experiencia.AgregarExperienciaLaboralUseCase;
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
class AgregarNuevaReferenciaUseCaseTestTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void agregarNuevaReferenciaUseCaseTest(){

        var command = new AgregarNuevaReferencia(PerfilID.of("xxxx"), ReferenciasID.of("1"),
                new InformacionDeContacto("Casado"),
                new NombreCompleto("Juan", "Pablo"));

        var useCase = new AgregarNuevaReferenciaUseCase();

        when(repository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        NuevaReferenciaAgregada event = (NuevaReferenciaAgregada) events.getDomainEvents().get(0);
        Assertions.assertEquals("Casado", event.getInformacionDeContacto().value());
        Assertions.assertEquals("Juan "+"Pablo", event.getNombreCompleto().value());
    }

    private List<DomainEvent> eventList(){
        return List.of(new NuevaReferenciaAgregada(
               new ReferenciasID(),
                new InformacionDeContacto("Soltero"),
                new NombreCompleto("Pablo", "Cano")
        ));
    }

}