package org.jetbrains.assignment.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MOVE")
public class Move {
    @Id
    private UUID id;
@Column
    private Direction direction;
@Column
private int steps;
}
