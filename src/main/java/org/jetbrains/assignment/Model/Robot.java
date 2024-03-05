package org.jetbrains.assignment.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Robot {

    @Id
    private String id;

    private Enum<Direction> direction;

    private Integer x;

    private Integer y;

}
