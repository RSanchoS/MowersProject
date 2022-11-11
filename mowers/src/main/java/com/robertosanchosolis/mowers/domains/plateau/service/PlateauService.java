package com.robertosanchosolis.mowers.domains.plateau.service;

import java.util.List;

import com.robertosanchosolis.mowers.domains.mower.MowerInstructions;

public interface PlateauService {

    public List<String> initializePlateuaAndMoveMovers(Integer plateauMaxX, Integer plateauMaxY, List<MowerInstructions> instructions);
    
}
