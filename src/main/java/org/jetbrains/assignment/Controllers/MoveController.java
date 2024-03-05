package org.jetbrains.assignment.Controllers;

import org.jetbrains.assignment.Model.Direction;
import org.jetbrains.assignment.Model.Move;
import org.jetbrains.assignment.Model.Steps;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoveController {

    @PostMapping("/moves")
    public Move[] move(@RequestBody Steps[] steps) {
        // genereta ramdom UUID
        Move moveNorth = new Move(Direction.NORTH, 0);
        Move moveSouth = new Move(Direction.SOUTH, 0);
        Move moveEast = new Move( Direction.EAST, 0);
        Move moveWest = new Move(Direction.WEST, 0);

        for (Steps step : steps) {
            if (step.getX() > 0) {
                moveEast.setSteps(moveEast.getSteps() + step.getX());
            } else if (step.getX() < 0) {
                moveWest.setSteps(moveWest.getSteps() + step.getX());
            }
            if (step.getY() > 0) {
                moveNorth.setSteps(moveNorth.getSteps() + step.getY());
            } else if (step.getY() < 0) {
                moveSouth.setSteps(moveSouth.getSteps() + step.getY());
            }
        }
        // Save the output to MoveRepository


        return new Move[]{moveNorth, moveSouth, moveEast, moveWest};
    }
}
