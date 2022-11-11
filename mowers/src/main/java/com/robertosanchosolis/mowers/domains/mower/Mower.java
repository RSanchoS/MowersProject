package com.robertosanchosolis.mowers.domains.mower;

import com.robertosanchosolis.mowers.domains.plateau.Plateau;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mower {

    int x;

    int y;

    CardinalPoints facing;

    public void changeFacing(String instruction) {
        switch (instruction) {
            case "L":
                switch (facing) {
                    case N:
                        facing = CardinalPoints.W;
                        break;
                    case E:
                        facing = CardinalPoints.N;
                        break;
                    case S:
                        facing = CardinalPoints.E;
                        break;
                    case W:
                        facing = CardinalPoints.S;
                        break;
                    default:
                        break;
                }
                break;
            case "R":
                switch (facing) {
                    case N:
                        facing = CardinalPoints.E;
                        break;
                    case E:
                        facing = CardinalPoints.S;
                        break;
                    case S:
                        facing = CardinalPoints.W;
                        break;
                    case W:
                        facing = CardinalPoints.N;
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
    }

    public void moverForward(Plateau plateau) {
        switch (facing) {
            case N:
                y++;
                if(this.isCorrectMove(plateau)) {
                    y--;
                }
                break;
            case E:
                x++;
                if(this.isCorrectMove(plateau)) {
                    x--;
                }
                break;
            case S:
                y--;
                if(this.isCorrectMove(plateau)) {
                    y++;
                }
                break;
            case W:
                x--;
                if(this.isCorrectMove(plateau )) {
                    x++;
                }
                break;
            default:
                break;
        }
    }

    private boolean isCorrectMove(Plateau plateau) {
        return plateau.isInsidePlateau(x, y) && !plateau.isCollision(x, y);
    }

    
}
