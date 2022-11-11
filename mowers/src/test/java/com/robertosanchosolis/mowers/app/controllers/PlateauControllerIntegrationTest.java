package com.robertosanchosolis.mowers.app.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.robertosanchosolis.mowers.app.controllers.requestObjects.MoveMowerRequest;
import com.robertosanchosolis.mowers.app.controllers.requestObjects.MowerInstructionsRequest;
import com.robertosanchosolis.mowers.app.controllers.responseObjects.FinalPositionMowersResponse;

@SpringBootTest
public class PlateauControllerIntegrationTest {
    
    @Autowired
    PlateauController plateauController;

    @Test
    void moveMowersinNewPlateau(){
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

        FinalPositionMowersResponse finalPositionMowersResponse = FinalPositionMowersResponse.builder()
                .finalPositions(List.of("1 3 N", "5 1 E"))
                .build();

        //when
        ResponseEntity<FinalPositionMowersResponse> response = plateauController.moveMowersinNewPlateau(moveMowerRequest);
        
        //then
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(finalPositionMowersResponse.getFinalPositions().get(0), response.getBody().getFinalPositions().get(0));
        assertEquals(finalPositionMowersResponse.getFinalPositions().get(1), response.getBody().getFinalPositions().get(1));
    }

}
