package com.robertosanchosolis.mowers.domains.mower.service.impl;

import org.springframework.stereotype.Service;

import com.robertosanchosolis.mowers.domains.mower.Mower;
import com.robertosanchosolis.mowers.domains.mower.service.MowerService;
import com.robertosanchosolis.mowers.domains.plateau.Plateau;

@Service
public class MowerServiceImpl implements MowerService {

    @Override
    public Mower move(Mower mower, Plateau plateau, String instruction) {

        switch (instruction) {
            case "L":
                mower.changeFacing(instruction); 
                break;
            case "R":
                mower.changeFacing(instruction); 
                break;
            case "M":
                mower.moverForward(plateau);
                break;
            default:
                break;
        }
        return mower;
        
    }


}
    
