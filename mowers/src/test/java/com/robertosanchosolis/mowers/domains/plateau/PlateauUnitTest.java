package com.robertosanchosolis.mowers.domains.plateau;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.robertosanchosolis.mowers.domains.mower.Mower;

public class PlateauUnitTest {

    @Test
    void isInsidePlateau() {
        // given
        Plateau plateau = new Plateau();
        plateau.setMaxX(5);
        plateau.setMaxY(5);
        // then
        assertEquals(true, plateau.isInsidePlateau(1, 1));
    }

    @Test
    void isOutsidePlateau() {
        // given
        Plateau plateau = new Plateau();
        plateau.setMaxX(5);
        plateau.setMaxY(5);
        // then
        assertEquals(false, plateau.isInsidePlateau(6, 6));
    }

    @Test
    void isCollisionFalse() {
        // given
        List<Mower> mowers = new ArrayList<>();

        Mower mower = new Mower();
        mower.setX(2);
        mower.setY(2);

        mowers.add(mower);

        Plateau plateau = new Plateau();
        plateau.setMaxX(5);
        plateau.setMaxY(5);
        plateau.setMowers(mowers);

        // then
        assertEquals(false, plateau.isCollision(1, 1));
    }

    @Test
    void isCollisionTrue() {
        // given
        List<Mower> mowers = new ArrayList<>();

        Mower mower = new Mower();
        mower.setX(2);
        mower.setY(2);

        mowers.add(mower);

        Plateau plateau = new Plateau();
        plateau.setMaxX(5);
        plateau.setMaxY(5);
        plateau.setMowers(mowers);

        // then
        assertEquals(true, plateau.isCollision(2, 2));
    }
    
}
