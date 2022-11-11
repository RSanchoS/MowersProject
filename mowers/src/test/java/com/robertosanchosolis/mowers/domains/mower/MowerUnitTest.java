package com.robertosanchosolis.mowers.domains.mower;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.robertosanchosolis.mowers.domains.plateau.Plateau;

public class MowerUnitTest {

    @Test
    void changeFacingLwithFacingN() {
        // given
        Mower mower = new Mower();
        mower.setFacing(CardinalPoints.N);
        // when
        mower.changeFacing("L");
        // then
        assertEquals(CardinalPoints.W, mower.getFacing());
    }

    @Test
    void changeFacingLwithFacingE() {
        // given
        Mower mower = new Mower();
        mower.setFacing(CardinalPoints.E);
        // when
        mower.changeFacing("L");
        // then
        assertEquals(CardinalPoints.N, mower.getFacing());
    }

    @Test
    void changeFacingLwithFacingW() {
        // given
        Mower mower = new Mower();
        mower.setFacing(CardinalPoints.W);
        // when
        mower.changeFacing("L");
        // then
        assertEquals(CardinalPoints.S, mower.getFacing());
    }

    @Test
    void changeFacingLwithFacingS() {
        // given
        Mower mower = new Mower();
        mower.setFacing(CardinalPoints.S);
        // when
        mower.changeFacing("L");
        // then
        assertEquals(CardinalPoints.E, mower.getFacing());
    }

    @Test
    void changeFacingUnknownwithFacingN() {
        // given
        Mower mower = new Mower();
        mower.setFacing(CardinalPoints.W);
        // when
        mower.changeFacing("A");
        // then
        assertEquals(CardinalPoints.W, mower.getFacing());
    }

    @Test
    void changeFacingRwithFacingN() {
        // given
        Mower mower = new Mower();
        mower.setFacing(CardinalPoints.N);
        // when
        mower.changeFacing("R");
        // then
        assertEquals(CardinalPoints.E, mower.getFacing());
    }   

    @Test
    void changeFacingRwithFacingE() {
        // given
        Mower mower = new Mower();
        mower.setFacing(CardinalPoints.E);
        // when
        mower.changeFacing("R");
        // then
        assertEquals(CardinalPoints.S, mower.getFacing());
    }

    @Test
    void changeFacingRwithFacingW() {
        // given
        Mower mower = new Mower();
        mower.setFacing(CardinalPoints.W);
        // when
        mower.changeFacing("R");
        // then
        assertEquals(CardinalPoints.N, mower.getFacing());
    }

    @Test
    void changeFacingRwithFacingS() {
        // given
        Mower mower = new Mower();
        mower.setFacing(CardinalPoints.S);
        // when
        mower.changeFacing("R");
        // then
        assertEquals(CardinalPoints.W, mower.getFacing());
    }

    @Test
    void changeFacingUnknownwithFacingE() {
        // given
        Mower mower = new Mower();
        mower.setFacing(CardinalPoints.E);
        // when
        mower.changeFacing("A");
        // then
        assertEquals(CardinalPoints.E, mower.getFacing());
    }

    @Test
    void moveForwardwithFacingN() {
        // given
        Mower mower = new Mower();
        mower.setFacing(CardinalPoints.N);
        mower.setX(1);
        mower.setY(1);

        Plateau plateau = new Plateau();
        // when
        mower.moverForward(plateau);
        // then
        assertEquals(1, mower.getX());
        assertEquals(2, mower.getY());
    }

    @Test
    void moveForwardwithFacingE() {
        // given
        Mower mower = new Mower();
        mower.setFacing(CardinalPoints.E);
        mower.setX(1);
        mower.setY(1);

        Plateau plateau = new Plateau();
        // when
        mower.moverForward(plateau);
        // then
        assertEquals(2, mower.getX());
        assertEquals(1, mower.getY());
    }

    @Test
    void moveForwardwithFacingW() {
        // given
        Mower mower = new Mower();
        mower.setFacing(CardinalPoints.W);
        mower.setX(1);
        mower.setY(1);

        Plateau plateau = new Plateau();
        // when
        mower.moverForward(plateau);
        // then
        assertEquals(0, mower.getX());
        assertEquals(1, mower.getY());
    }

    @Test
    void moveForwardwithFacingS() {
        // given
        Mower mower = new Mower();
        mower.setFacing(CardinalPoints.S);
        mower.setX(1);
        mower.setY(1);

        Plateau plateau = new Plateau();
        // when
        mower.moverForward(plateau);
        // then
        assertEquals(1, mower.getX());
        assertEquals(0, mower.getY());
    }
    

    
}
