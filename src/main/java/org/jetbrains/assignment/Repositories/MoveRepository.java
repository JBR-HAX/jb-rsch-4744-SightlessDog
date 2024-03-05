package org.jetbrains.assignment.Repositories;

import org.jetbrains.assignment.Model.Move;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MoveRepository extends CrudRepository<Move, UUID> {
}
