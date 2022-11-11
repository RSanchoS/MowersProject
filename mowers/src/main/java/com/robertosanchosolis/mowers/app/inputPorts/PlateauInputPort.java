package com.robertosanchosolis.mowers.app.inputPorts;


import com.robertosanchosolis.mowers.app.controllers.requestObjects.MoveMowerRequest;
import com.robertosanchosolis.mowers.app.controllers.responseObjects.FinalPositionMowersResponse;

public interface PlateauInputPort {

    FinalPositionMowersResponse moveMowersinNewPlateau(MoveMowerRequest moveMowerRequest);
    
}
