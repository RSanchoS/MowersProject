package com.robertosanchosolis.mowers.app.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.robertosanchosolis.mowers.app.controllers.PlateauController;
import com.robertosanchosolis.mowers.app.controllers.requestObjects.MoveMowerRequest;
import com.robertosanchosolis.mowers.app.controllers.responseObjects.FinalPositionMowersResponse;
import com.robertosanchosolis.mowers.app.inputPorts.PlateauInputPort;

@Controller
public class PlateauControllerImpl implements PlateauController{

    @Autowired
    PlateauInputPort plateauInputPort;

    @Override
    @PostMapping("/instructions")
    public ResponseEntity<FinalPositionMowersResponse> moveMowersinNewPlateau(@RequestBody MoveMowerRequest moveMowerRequest) {

        FinalPositionMowersResponse finalPositionMowersResponse = plateauInputPort.moveMowersinNewPlateau(moveMowerRequest);
        
        return finalPositionMowersResponse != null 
            ? ResponseEntity.ok(finalPositionMowersResponse) 
            : ResponseEntity.badRequest().build();
    }
    
}
