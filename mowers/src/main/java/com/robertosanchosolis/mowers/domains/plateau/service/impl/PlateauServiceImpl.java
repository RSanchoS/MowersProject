package com.robertosanchosolis.mowers.domains.plateau.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertosanchosolis.mowers.app.controllers.responseObjects.FinalPositionMowersResponse;
import com.robertosanchosolis.mowers.domains.mower.CardinalPoints;
import com.robertosanchosolis.mowers.domains.mower.Mower;
import com.robertosanchosolis.mowers.domains.mower.MowerInstructions;
import com.robertosanchosolis.mowers.domains.mower.service.MowerService;
import com.robertosanchosolis.mowers.domains.plateau.Plateau;
import com.robertosanchosolis.mowers.domains.plateau.service.PlateauService;


@Service
public class PlateauServiceImpl implements PlateauService{

    @Autowired
    MowerService mowerService;

    @Override
    public List<String> initializePlateuaAndMoveMovers(Integer plateauMaxX, Integer plateauMaxY,
            List<MowerInstructions> instructions) {

                List<String> finalPositions = new ArrayList<>();

                Plateau plateau = Plateau.builder()
                .maxX(plateauMaxX)
                .maxY(plateauMaxY)
                .mowers(new ArrayList<>())
                .build();

            for (MowerInstructions mowerInstructions : instructions) {
                
                Mower mower = Mower.builder()
                .x(mowerInstructions.getInitialX())
                .y(mowerInstructions.getInitialY())
                .facing(CardinalPoints.valueOf(mowerInstructions.getInitialFacing()))
                .build();

                plateau.getMowers().add(mower);

                for (int i = 0; i < mowerInstructions.getInstructions().length(); i++) {
                    char instruction = mowerInstructions.getInstructions().charAt(i);
                    Mower mowerInMovement = mower;
                    mowerInMovement = mowerService.move(mowerInMovement, plateau, String.valueOf(instruction));
                }

                finalPositions.add(mower.getX() + " " + mower.getY() + " " + mower.getFacing());

            }
        return finalPositions;
    }

}
    
