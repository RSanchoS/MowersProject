package com.robertosanchosolis.mowers.app.inputPorts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.robertosanchosolis.mowers.app.controllers.requestObjects.MoveMowerRequest;
import com.robertosanchosolis.mowers.app.controllers.requestObjects.MowerInstructionsRequest;
import com.robertosanchosolis.mowers.app.controllers.responseObjects.FinalPositionMowersResponse;
import com.robertosanchosolis.mowers.app.inputPorts.impl.PlateauInputPortImpl;
import com.robertosanchosolis.mowers.domains.plateau.service.PlateauService;

@ExtendWith(MockitoExtension.class)
public class PlateauInputPortUnitTest {

    @InjectMocks
    PlateauInputPortImpl plateauInputPort;

    @Mock
    PlateauService plateauService;

    @Test
    void moveMowersinNewPlateau() {
        //given
        List<MowerInstructionsRequest> mowerInstructions = List.of(
                MowerInstructionsRequest.builder()
                    .initialX(1)
                    .initialY(2)
                    .initialFacing("N")
                    .instructions("LM")
                    .build()
                );

        MoveMowerRequest moveMowerRequest = MoveMowerRequest.builder()
                .maximumX(5)
                .maximumY(5)
                .instructions(mowerInstructions)
                .build();

        List<String> finalPositions = List.of("1 3 N");
        //when
        Mockito.when(plateauService.initializePlateuaAndMoveMovers(anyInt()
        , anyInt(), any(List.class))).thenReturn(finalPositions);

        FinalPositionMowersResponse response = plateauInputPort.moveMowersinNewPlateau(moveMowerRequest);
        //then

        assertEquals(finalPositions, response.getFinalPositions());
    }
    
}
