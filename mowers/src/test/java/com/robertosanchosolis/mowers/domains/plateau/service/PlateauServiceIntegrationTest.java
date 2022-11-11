package com.robertosanchosolis.mowers.domains.plateau.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.robertosanchosolis.mowers.domains.mower.MowerInstructions;

@SpringBootTest
public class PlateauServiceIntegrationTest {

    @Autowired
    PlateauService plateauService;

    @Test
    void initializePlateuaAndMoveMovers() {
        //given
        Integer maxX = 5;
        Integer maxY = 5;

        List<MowerInstructions> mowerInstructions = new ArrayList<>();

        MowerInstructions mowerInstructions1 = MowerInstructions.builder()
                .initialX(1)
                .initialY(2)
                .initialFacing("N")
                .instructions("LMLMLMLMM")
                .build();
        
        mowerInstructions.add(mowerInstructions1);

        MowerInstructions mowerInstructions2 = MowerInstructions.builder()
        .initialX(3)
        .initialY(3)
        .initialFacing("E")
        .instructions("MMRMMRMRRM")
        .build();

        mowerInstructions.add(mowerInstructions2);
        //when
        List<String> finalPositions = plateauService.initializePlateuaAndMoveMovers(maxX, maxY, mowerInstructions);

        //then
        assertEquals(2, finalPositions.size());
        assertEquals("1 3 N", finalPositions.get(0));
        assertEquals("5 1 E", finalPositions.get(1));
    }
    
}
