package com.robertosanchosolis.mowers.app.inputPorts.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.robertosanchosolis.mowers.app.controllers.requestObjects.MoveMowerRequest;
import com.robertosanchosolis.mowers.app.controllers.requestObjects.MowerInstructionsRequest;
import com.robertosanchosolis.mowers.app.controllers.responseObjects.FinalPositionMowersResponse;
import com.robertosanchosolis.mowers.app.inputPorts.PlateauInputPort;
import com.robertosanchosolis.mowers.domains.mower.MowerInstructions;
import com.robertosanchosolis.mowers.domains.plateau.service.PlateauService;

@Component
public class PlateauInputPortImpl implements PlateauInputPort{

    @Autowired
    PlateauService plateauService;

    @Override
    public FinalPositionMowersResponse moveMowersinNewPlateau(MoveMowerRequest moveMowerRequest) {

        List<String> finalList = plateauService.initializePlateuaAndMoveMovers(
            moveMowerRequest.getMaximumX(),
            moveMowerRequest.getMaximumY(),
            convertToMowerInstructions(moveMowerRequest.getInstructions())
        );

        return FinalPositionMowersResponse.builder()
        .finalPositions(finalList)
        .build();
    }

    private List<MowerInstructions> convertToMowerInstructions(List<MowerInstructionsRequest> mowerInstructionsRequests) {

        List<MowerInstructions> instructions = new ArrayList<>();

        for (MowerInstructionsRequest mowerInstructionsRequest : mowerInstructionsRequests) {

            instructions.add(MowerInstructions.builder()
                .initialX(mowerInstructionsRequest.getInitialX())
                .initialY(mowerInstructionsRequest.getInitialY())
                .initialFacing(mowerInstructionsRequest.getInitialFacing())
                .instructions(mowerInstructionsRequest.getInstructions())
                .build()
            );
            
        }
        return instructions;
    }

}
    
