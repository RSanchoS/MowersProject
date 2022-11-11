package com.robertosanchosolis.mowers.domains.plateau.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.robertosanchosolis.mowers.domains.mower.MowerInstructions;
import com.robertosanchosolis.mowers.domains.mower.service.MowerService;
import com.robertosanchosolis.mowers.domains.plateau.service.impl.PlateauServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PlateauServiceUnitTest {

    @InjectMocks
    PlateauServiceImpl plateauService;

    @Mock
    MowerService mowerService;
    
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
                .instructions("LM")
                .build();
        
        mowerInstructions.add(mowerInstructions1);
        
        //when
        List<String> finalPositions = plateauService.initializePlateuaAndMoveMovers(maxX, maxY, mowerInstructions);

        //then
        assertEquals(1, finalPositions.size());
    }
}
