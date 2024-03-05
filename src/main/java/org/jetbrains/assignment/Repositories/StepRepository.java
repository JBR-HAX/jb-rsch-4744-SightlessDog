package org.jetbrains.assignment.Repositories;


import org.jetbrains.assignment.Model.StepEntity;
import org.jetbrains.assignment.Model.Steps;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

// this is a repository where to save steps
public interface StepRepository extends CrudRepository<Steps, UUID>{
}
