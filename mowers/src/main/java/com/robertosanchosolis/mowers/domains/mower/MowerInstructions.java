package com.robertosanchosolis.mowers.domains.mower;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MowerInstructions {

    int initialX;

    int initialY;

    String initialFacing;

    String instructions;

}
