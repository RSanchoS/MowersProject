package com.robertosanchosolis.mowers.domains.mower.service;

import com.robertosanchosolis.mowers.domains.mower.Mower;
import com.robertosanchosolis.mowers.domains.plateau.Plateau;

public interface MowerService {

    public Mower move(Mower mower, Plateau plateau, String instruction);
    
}
