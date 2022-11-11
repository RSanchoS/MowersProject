package com.robertosanchosolis.mowers.app.controllers;

import org.springframework.http.ResponseEntity;

import com.robertosanchosolis.mowers.app.controllers.requestObjects.MoveMowerRequest;
import com.robertosanchosolis.mowers.app.controllers.responseObjects.FinalPositionMowersResponse;

public interface PlateauController {
    
    public ResponseEntity<FinalPositionMowersResponse> moveMowersinNewPlateau(MoveMowerRequest moveMowerRequest);
}
