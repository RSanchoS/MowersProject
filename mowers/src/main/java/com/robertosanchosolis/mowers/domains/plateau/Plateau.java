package com.robertosanchosolis.mowers.domains.plateau;

import java.util.List;

import com.robertosanchosolis.mowers.domains.mower.Mower;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Plateau {

    private int initX = 0;

    private int initY = 0;

    private int maxX;

    private int maxY;

    private List<Mower> mowers;

    public boolean isInsidePlateau(int x, int y) {
        return x >= initX && x <= maxX && y >= initY && y <= maxY;
    }

    public boolean isCollision(int x, int y) {
        return mowers.stream().anyMatch(mower -> mower.getX() == x && mower.getY() == y);
    }
    
}
