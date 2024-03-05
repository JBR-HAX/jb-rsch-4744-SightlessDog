package org.jetbrains.assignment.Controllers;

import org.jetbrains.assignment.Model.Direction;
import org.jetbrains.assignment.Model.Move;
import org.jetbrains.assignment.Model.Steps;
import org.jetbrains.assignment.Repositories.MoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.UUID;

@RestController
public class MoveController {

    @Autowired
    MoveRepository moveRepository;

    @PostMapping("/moves")
    public Move[] move(@RequestBody Steps[] steps) {
        // genereta ramdom UUID
        Move moveNorth = new Move(UUID.randomUUID(), Direction.NORTH, 0);
        Move moveSouth = new Move(UUID.randomUUID(),Direction.SOUTH, 0);
        Move moveEast = new Move(UUID.randomUUID(), Direction.EAST, 0);
        Move moveWest = new Move(UUID.randomUUID(),Direction.WEST, 0);

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
        moveRepository.saveAll(Arrays.stream(new Move[]{moveNorth, moveSouth, moveEast, moveWest}).toList());

        return new Move[]{moveNorth, moveSouth, moveEast, moveWest};
    }
}
