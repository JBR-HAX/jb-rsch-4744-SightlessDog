package org.jetbrains.assignment.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "STEPS")
public class Steps {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column
    private int x;
    @Column
    private int y;

}
