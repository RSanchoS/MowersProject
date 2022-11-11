package com.robertosanchosolis.mowers.domains.mower.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.robertosanchosolis.mowers.domains.mower.CardinalPoints;
import com.robertosanchosolis.mowers.domains.mower.Mower;
import com.robertosanchosolis.mowers.domains.mower.service.impl.MowerServiceImpl;
import com.robertosanchosolis.mowers.domains.plateau.Plateau;

@ExtendWith(MockitoExtension.class)
public class MowerServiceUnitTest {

    @InjectMocks
    MowerServiceImpl mowerService;

    @Test
    void moveL() {
        // given
        Mower mower = new Mower();
        mower.setFacing(CardinalPoints.N);
        mower.setX(1);
        mower.setY(1);

        Plateau plateau = new Plateau();

        String instruction = "L";
        // when
        mowerService.move(mower, plateau, instruction);
        // then
        assertEquals(CardinalPoints.W, mower.getFacing());
    }

    @Test
    void moveR() {
        // given
        Mower mower = new Mower();
        mower.setFacing(CardinalPoints.N);
        mower.setX(1);
        mower.setY(1);

        Plateau plateau = new Plateau();

        String instruction = "R";
        // when
        mowerService.move(mower, plateau, instruction);
        // then
        assertEquals(CardinalPoints.E, mower.getFacing());
    }

    @Test
    void moveM() {
        // given
        Mower mower = new Mower();
        mower.setFacing(CardinalPoints.N);
        mower.setX(1);
        mower.setY(1);

        Plateau plateau = new Plateau();

        String instruction = "M";
        // when
        mowerService.move(mower, plateau, instruction);
        // then
        assertEquals(2, mower.getY());
    }

    @Test
    void moveUnknown(){
        // given
        Mower mower = new Mower();
        mower.setFacing(CardinalPoints.N);
        mower.setX(1);
        mower.setY(1);

        Plateau plateau = new Plateau();

        String instruction = "X";
        // when
        mowerService.move(mower, plateau, instruction);
        // then
        assertEquals(1, mower.getY());
    }
    
}
