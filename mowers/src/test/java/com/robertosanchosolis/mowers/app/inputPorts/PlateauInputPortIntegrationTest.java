package com.robertosanchosolis.mowers.app.inputPorts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.robertosanchosolis.mowers.app.controllers.requestObjects.MoveMowerRequest;
import com.robertosanchosolis.mowers.app.controllers.requestObjects.MowerInstructionsRequest;
import com.robertosanchosolis.mowers.app.controllers.responseObjects.FinalPositionMowersResponse;
import com.robertosanchosolis.mowers.domains.plateau.service.PlateauService;

@SpringBootTest
public class PlateauInputPortIntegrationTest {
    
    @Autowired
    PlateauInputPort plateauInputPort;

    @Test
    void moveMowersinNewPlateau() {
        //given
        List<MowerInstructionsRequest> mowerInstructions = List.of(
                MowerInstructionsRequest.builder()
                    .initialX(1)
                    .initialY(2)
                    .initialFacing("N")
                    .instructions("LMLMLMLMM")
                    .build(),
                MowerInstructionsRequest.builder()
                    .initialX(3)
                    .initialY(3)
                    .initialFacing("E")
                    .instructions("MMRMMRMRRM")
                    .build()
                );

        MoveMowerRequest moveMowerRequest = MoveMowerRequest.builder()
                .maximumX(5)
                .maximumY(5)
                .instructions(mowerInstructions)
                .build();

        List<String> finalPositions = List.of("1 3 N", "5 1 E");
        //when
        FinalPositionMowersResponse response = plateauInputPort.moveMowersinNewPlateau(moveMowerRequest);

        //then
        assertEquals(finalPositions.get(0), response.getFinalPositions().get(0));
        assertEquals(finalPositions.get(1), response.getFinalPositions().get(1));

    }
}
