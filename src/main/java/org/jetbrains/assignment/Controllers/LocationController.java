package org.jetbrains.assignment.Controllers;

import org.jetbrains.assignment.Model.Direction;
import org.jetbrains.assignment.Model.Move;
import org.jetbrains.assignment.Model.Steps;
import org.jetbrains.assignment.Repositories.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;

@RestController
public class LocationController {

    @Autowired
    StepRepository stepRepository;

    // This controller takes an array of objects in the form of {"direction": "NORTH", "steps": 1} as argument and gives back the steps made in a cartiesian plane
    @PostMapping("/locations")
    public Steps[] move(@RequestBody Move[] moves) {
    Steps[] steps = new Steps[moves.length];
        for (int i = 0; i < moves.length; i++) {
            Direction direction = moves[i].getDirection();
            int stepsCount = moves[i].getSteps();
            switch (direction) {
                case NORTH:
                    steps[i] = new Steps( 0, stepsCount);
                    break;
                case SOUTH:
                    steps[i] = new Steps(0, -stepsCount);
                    break;
                case EAST:
                    steps[i] = new Steps(stepsCount, 0);
                    break;
                case WEST:
                    steps[i] = new Steps(-stepsCount, 0);
                    break;
            }
        }

        // save the steps to the repository
        stepRepository.saveAll(Arrays.asList(steps));

        return steps;
    }
}
