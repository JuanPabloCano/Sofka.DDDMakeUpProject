package co.com.sofka.useCases.gestionEducacion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.gestionEducacion.commands.ModificarEstudioEducacion;
import co.com.sofka.domain.gestionEducacion.commands.ModificarInstitucionEducacion;
import co.com.sofka.domain.gestionEducacion.domainEvents.EducacionAgregada;
import co.com.sofka.domain.gestionEducacion.domainEvents.EstudioEducacionModificado;
import co.com.sofka.domain.gestionEducacion.domainEvents.InstitucionEducacionModificada;
import co.com.sofka.domain.gestionEducacion.values.EducacionesID;
import co.com.sofka.domain.gestionEducacion.values.Estudio;
import co.com.sofka.domain.gestionEducacion.values.GestionEducacionID;
import co.com.sofka.domain.gestionEducacion.values.Tipo;
import co.com.sofka.generics.Institucion;
import co.com.sofka.generics.Periodo;
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
class ModificarInstitucionEducacionUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void modificarInstitucionEducacionUseCaseTest() {

        var command = new ModificarInstitucionEducacion(GestionEducacionID.of("xxxx"),
                new Institucion("Sofka"));

        var useCase = new ModificarInstitucionEducacionUseCase();

        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        InstitucionEducacionModificada event = (InstitucionEducacionModificada) events.getDomainEvents().get(0);
        Assertions.assertEquals("Sofka", event.getInstitucion().value());
        Mockito.verify(repository).getEventsBy("xxxx");
    }

    private List<DomainEvent> eventList() {
        return List.of(new EducacionAgregada(
                        new EducacionesID(),
                        new Tipo("Curso"),
                        new Estudio("Etica"),
                        new Institucion("Sena"),
                        new Periodo(LocalDateTime.now(), LocalDateTime.now().plusDays(5))
                ), new InstitucionEducacionModificada(
                        new EducacionesID(),
                        new Institucion("Sena")
                )
        );
    }

}