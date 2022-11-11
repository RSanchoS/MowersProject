package com.robertosanchosolis.mowers.app.controllers.requestObjects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MowerInstructionsRequest {

    int initialX;

    int initialY;

    String initialFacing;

    String instructions;

}
