package com.robertosanchosolis.mowers.app.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.robertosanchosolis.mowers.app.controllers.impl.PlateauControllerImpl;
import com.robertosanchosolis.mowers.app.controllers.requestObjects.MoveMowerRequest;
import com.robertosanchosolis.mowers.app.controllers.requestObjects.MowerInstructionsRequest;
import com.robertosanchosolis.mowers.app.controllers.responseObjects.FinalPositionMowersResponse;
import com.robertosanchosolis.mowers.app.inputPorts.PlateauInputPort;

@ExtendWith(MockitoExtension.class)
public class PlateauControllerUnitTest {
    
    @InjectMocks
    PlateauControllerImpl plateauController;

    @Mock
    PlateauInputPort plateauInputPort;

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

        FinalPositionMowersResponse finalPositionMowersResponse = FinalPositionMowersResponse.builder()
                .finalPositions(List.of("1 3 N"))
                .build();

        //when
        Mockito.when(plateauInputPort.moveMowersinNewPlateau(Mockito.any(MoveMowerRequest.class))).thenReturn(finalPositionMowersResponse);

        ResponseEntity<FinalPositionMowersResponse> response = plateauController.moveMowersinNewPlateau(moveMowerRequest);
        
        //then
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
